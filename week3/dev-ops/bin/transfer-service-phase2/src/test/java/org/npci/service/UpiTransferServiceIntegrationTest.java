package org.npci.service;

import org.junit.ClassRule;
import org.junit.jupiter.api.*;
import org.npci.Application;
import org.npci.exception.AccountBalanceException;
import org.npci.exception.AccountNotFoundException;
import org.npci.model.Account;
import org.npci.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.transaction.annotation.Transactional;
import org.testcontainers.containers.PostgreSQLContainer;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

@SpringBootTest(
        classes = {Application.class}
        // H2 database configuration
//        properties = {
//                "spring.datasource.url=jdbc:h2:mem:testdb;DB_CLOSE_DELAY=-1",
//                "spring.datasource.driverClassName=org.h2.Driver",
//                "spring.datasource.username=sa",
//                "spring.datasource.password=",
//                "spring.jpa.database-platform=org.hibernate.dialect.H2Dialect",
//                "spring.jpa.hibernate.ddl-auto=create-drop"
//        }
)
public class UpiTransferServiceIntegrationTest {

    @Autowired
    UpiTransferService upiTransferService;
    @Autowired
    AccountRepository accountRepository;

    public static PostgreSQLContainer<?> postgresContainer = new PostgreSQLContainer<>("postgres:15.3")
            .withDatabaseName("testdb")
            .withUsername("test")
            .withPassword("test");


    @BeforeAll
    public static void setUpClass() {
        postgresContainer.start();
    }

    @AfterAll
    public static void tearDownClass() {
        postgresContainer.stop();
    }

    @DynamicPropertySource
    static void overrideProps(DynamicPropertyRegistry registry) {
        registry.add("spring.datasource.url", postgresContainer::getJdbcUrl);
        registry.add("spring.datasource.username", postgresContainer::getUsername);
        registry.add("spring.datasource.password", postgresContainer::getPassword);
        registry.add("spring.jpa.hibernate.ddl-auto", () -> "update");
    }


    @BeforeEach
    @Transactional
    public void setUp() {
        // Initialize the database with test data
        Account fromAccount = new Account("fromAccount", "John", 200.0);
        Account toAccount = new Account("toAccount", "Jane", 300.0);
        accountRepository.save(fromAccount);
        accountRepository.save(toAccount);
    }

    // Cleanup after tests
    @AfterEach
    @Transactional
    public void tearDown() {
        // Clear the database after each test
        accountRepository.deleteAll();
    }

    // Invalid account number test
    @Test
    @Transactional
    public void testInitiateTransfer_InvalidAccountNumber() {
        String fromAccountNumber = "invalidFromAccount";
        String toAccountNumber = "invalidToAccount";
        double amount = 100.0;
        AccountNotFoundException e = assertThrows(AccountNotFoundException.class, () -> {
            upiTransferService.initiateTransfer(fromAccountNumber, toAccountNumber, amount);
        });
        assertEquals("Sender account not found", e.getMessage());
    }

    // Insufficient balance test
    @Test
    @Transactional
    public void testInitiateTransfer_InsufficientBalance() {
        String fromAccountNumber = "fromAccount";
        String toAccountNumber = "toAccount";
        double amount = 1000.0;

        AccountBalanceException e = assertThrows(AccountBalanceException.class, () -> {
            upiTransferService.initiateTransfer(fromAccountNumber, toAccountNumber, amount);
        });

        assertEquals("Insufficient balance in sender account", e.getMessage());
    }

    // Successful transfer test
    @Test
    @Transactional
    public void testInitiateTransfer_Successful() {
        String fromAccountNumber = "fromAccount";
        String toAccountNumber = "toAccount";
        double amount = 100.0;

        upiTransferService.initiateTransfer(fromAccountNumber, toAccountNumber, amount);

        Account fromAccount = accountRepository.findByAccountNumber(fromAccountNumber)
                .orElseThrow(() -> new RuntimeException("From account not found - " + fromAccountNumber));

        Account toAccount = accountRepository.findByAccountNumber(toAccountNumber)
                .orElseThrow(() -> new RuntimeException("To account not found - " + toAccountNumber));

        assertEquals(100.0, fromAccount.getBalance());
        assertEquals(400.0, toAccount.getBalance());
    }


}
