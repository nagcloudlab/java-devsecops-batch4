package com.npci.creational.builder;


import java.util.List;
import java.util.Map;

class Employee {
    private String firstName; // required
    private String lastName; // required
    private String email; // optional
    private String phoneNumber; // optional
    private String address; // optional
    private String department; // optional

    public Employee(String firstName, String lastName, String email, String phoneNumber, String address, String department) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.department = department;
    }
}

class EmployeeBuilder {
    private String firstName; // required
    private String lastName; // required
    private String email; // optional
    private String phoneNumber; // optional
    private String address; // optional
    private String department; // optional

    public EmployeeBuilder(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public EmployeeBuilder withEmail(String email) {
        this.email = email;
        return this;
    }

    public EmployeeBuilder withPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
        return this;
    }

    public EmployeeBuilder withAddress(String address) {
        this.address = address;
        return this;
    }

    public EmployeeBuilder withDepartment(String department) {
        this.department = department;
        return this;
    }

    public Employee build() {
        return new Employee(firstName, lastName, email, phoneNumber, address, department);
    }
}


class HttpResponse {
    private int statusCode;
    private List<Map<String, String>> headers;
    private String body;

    public HttpResponse(int statusCode, List<Map<String, String>> headers, String body) {
        this.statusCode = statusCode;
        this.headers = headers;
        this.body = body;
    }

}
class HttpResponseBuilder {
    private int statusCode = 200; // required
    private List<Map<String, String>> headers; // optional
    private String body; // optional

    public HttpResponseBuilder(int statusCode) {
        this.statusCode = statusCode;
    }

    public HttpResponseBuilder withHeaders(List<Map<String, String>> headers) {
        this.headers = headers;
        return this;
    }

    public HttpResponseBuilder withBody(String body) {
        this.body = body;
        return this;
    }

    public HttpResponse build() {
        return new HttpResponse(statusCode, headers, body);
    }
}

    public class Application {

        public static void main(String[] args) {

            // way-1 : firstName and lastName
            Employee e1 = new EmployeeBuilder("John", "Doe")
                    .build();

            // way-2 : firstName and lastName  with email
            Employee e2 = new EmployeeBuilder("Jane", "Doe")
                    .withEmail("jd@mail.com")
                    .build();

            // way-3 : firstName and lastName with email and phoneNumber
            Employee e3 = new EmployeeBuilder("Alice", "Smith")
                    .withEmail("as@mail.com")
                    .withPhoneNumber("123-456-7890")
                    .build();

            // way-4 : firstName and lastName with phoneNumber and address
            Employee e4 = new EmployeeBuilder("Bob", "Johnson")
                    .withPhoneNumber("987-654-3210")
                    .withAddress("123 Main St, City, Country")
                    .build();

            // way-5 : firstName and lastName with email, phoneNumber and address and department
            Employee e5 = new EmployeeBuilder("Charlie", "Brown")
                    .withEmail("cb@mail.com")
                    .withAddress("456 Elm St, City, Country")
                    .withPhoneNumber("555-555-5555")
                    .withDepartment("Engineering")
                    .build();


            // Example of HttpResponseBuilder
            HttpResponse response1 = new HttpResponseBuilder(200)
                    .withBody("Success")
                    .build();

            HttpResponse response2 = new HttpResponseBuilder(404)
                    .withHeaders(List.of(Map.of("Content-Type", "application/json")))
                    .withBody("{\"error\": \"Not Found\"}")
                    .build();


        }

    }
