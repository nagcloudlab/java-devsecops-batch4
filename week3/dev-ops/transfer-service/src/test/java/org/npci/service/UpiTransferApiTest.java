package org.npci.service;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.npci.Application;
import org.springframework.boot.test.context.SpringBootTest;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.startsWith;


@SpringBootTest(
        classes = {Application.class}
)
public class UpiTransferApiTest extends BaseTransferApiTest {


    // Junit + Hamcrest + Rest Assured
    @Test
    @Disabled
    public void transferMoneyTest() {

        String requestBody = """
                {
                  "fromAccountNumber": "123456789013",
                  "toAccountNumber": "123456789012",
                  "amount": 100.0
                }
                """;
        given()
                .spec(transferRequestSpec)
                .body(requestBody)
                .when()
                .post()
                .then()
                .spec(transferResponseSpec)
                .body("status", equalTo("SUCCESS"))
                .body("amount", equalTo(100.0f)) // for float/double use f
                .body("fromAccountNumber", startsWith("1234567890"))
                .body("transactionId", isValidTransferId);

    }

    Matcher<String> isValidTransferId = new TypeSafeMatcher<String>() {
        public void describeTo(Description description) {
            description.appendText("a valid transfer id starting with TRX");
        }

        protected boolean matchesSafely(String id) {
            return id != null && id.startsWith("TXN") && id.length() > 5;
        }
    };


}
