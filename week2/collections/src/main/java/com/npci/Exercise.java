package com.npci;

public class Exercise {
    public static void main(String[] args) {

        String csvLine = "A,IT,1000";
        String[] parts = csvLine.split(",");
        String empName = parts[0];
        String empDept = parts[1];
        double empSalary = Double.parseDouble(parts[2]);
        System.out.println("Employee Name: " + empName);
        System.out.println("Employee Department: " + empDept);
        System.out.println("Employee Salary: " + empSalary);

        // Input CSV report
        String[] csvReport = {
                "A,IT,1000",
                "B,HR,1200",
                "C,Finance,1500",
                "D,IT,1100",
                "E,HR,1300",
        };

        // Output the report
        /*
            deptName TotalSalary
            IT 2100.0
            HR 2500.0
            Finance 1500.0
         */



    }
}
