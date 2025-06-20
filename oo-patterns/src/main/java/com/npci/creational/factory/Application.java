package com.npci.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;


/*

    java + SQL database
    -------------------

    using 2 apis
    1. JDBC api
    2. JPA api
        - Hibernate
        - EclipseLink
        - TopLink

 */


/*

    steps to use JDBC api
    1. Load 'jdbc driver' class
    2. Create a connection to the database
    3. Create a statement with SQL query
    4. Execute the query
    5. Process the result set
    6. Close the connection
    7. Handle exceptions
    8. satisfy ACID


 */

/*

 Connection pooling lib
    1. HikariCP
    2. Apache DBCP
    3. C3P0
    4. Tomcat JDBC Pool

    - HikariCP is the fastest connection pool library
    - Apache DBCP is the most widely used connection pool library
    - C3P0 is the most feature rich connection pool library
    - Tomcat JDBC Pool is the most stable connection pool library


 */


// Factory
class ConnectionFactory {

    private static Properties properties = new Properties();

    static {
        try {
            FileInputStream fis = new FileInputStream("src/main/resources/db.properties");
            properties.load(fis);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // One time initialization
    static {
        // 1. Load 'jdbc driver' class
        try {
            Class.forName(properties.getProperty("db.driver"));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to load JDBC driver", e);
        }
    }

    public static Connection getConnection() throws SQLException {
        // 2. Create a connection to the database
        String url = properties.getProperty("db.url");
        String user = properties.getProperty("db.user");
        String password = properties.getProperty("db.password");
        return java.sql.DriverManager.getConnection(url, user, password);
    }
}


class Module1 {
    public void doSomething() {

        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            // 3. Create a statement with SQL query
            String sql = "SELECT * FROM users";
            java.sql.Statement statement = connection.createStatement();
            // 4. Execute the query
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            // 5. Process the result set
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println("User Name: " + name);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

class Module2 {
    public void doSomething() {

        Connection connection = null;
        try {
            connection = ConnectionFactory.getConnection();
            // 3. Create a statement with SQL query
            String sql = "SELECT * FROM users";
            java.sql.Statement statement = connection.createStatement();

            // 4. Execute the query
            java.sql.ResultSet resultSet = statement.executeQuery(sql);
            // 5. Process the result set
            while (resultSet.next()) {
                String name = resultSet.getString("name");
                System.out.println("User Name: " + name);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. Close the connection
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

    }
}

public class Application {

    public static void main(String[] args) {


        Module1 module1 = new Module1();
        module1.doSomething();

        Module2 module2 = new Module2();
        module2.doSomething();


    }

}
