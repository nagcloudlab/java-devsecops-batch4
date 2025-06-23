package com.npci;

import java.util.Map;

public class Exercise {
    public static void main(String[] args) {

        // Input CSV report
        String[] csvReport = {
                "A,IT,1000",
                "B,HR,1200",
                "C,Finance,1500",
                "D,IT,1100",
                "E,HR,1300",
        };
        // note : we dont know department names in advance

        // Output the report
        /*
            deptName TotalSalary
            IT 2100.0
            HR 2500.0
            Finance 1500.0
         */


        Map<String, Double> departmentSalaries = new java.util.HashMap<>();
        for (String csvLine : csvReport) {
            String[] parts = csvLine.split(",");
            String empName = parts[0];
            String empDept = parts[1];
            double empSalary = Double.parseDouble(parts[2]);
            if (departmentSalaries.containsKey(empDept)) {
                double existingSalary = departmentSalaries.get(empDept);
                departmentSalaries.put(empDept, existingSalary + empSalary);
            } else {
                departmentSalaries.put(empDept, empSalary);
            }
        }
        System.out.println("deptName TotalSalary");
        for (Map.Entry<String, Double> entry : departmentSalaries.entrySet()) {
            String deptName = entry.getKey();
            double totalSalary = entry.getValue();
            System.out.println(deptName + " " + totalSalary);
        }


    }
}
