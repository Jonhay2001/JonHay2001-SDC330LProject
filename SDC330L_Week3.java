/**
 * Name: Jonathan Haynes
 * Date: 4/25/26
 * Purpose: Main driver class demonstrating abstraction, constructors, and access specifiers
 */

import java.util.ArrayList;

public class SDC330L_Week2 {
    public static void main(String[] args) {

        // Program Header (REQUIRED)
        System.out.println("=== Week 3 Project ===");
        System.out.println("Employee Management System");
        System.out.println("By: Jonathan Haynes");
        System.out.println("----------------------------");
        System.out.println("Welcome! This program demonstrates abstraction, constructors, and access specifiers.\n");

        ArrayList<Employee> employees = new ArrayList<>();

        // Instantiate objects using parameterized constructors
        Employee emp1 = new SalariedEmployee(
                1, "John Haynes",
                new Address("123 Main St", "Greensboro"),
                50000
        );

        Employee emp2 = new HourlyEmployee(
                2, "Michelle Pegram",
                new Address("456 Oak St", "Winston-Salem"),
                40, 20
        );

        employees.add(emp1);
        employees.add(emp2);

        // Polymorphism demonstration
        for (Employee emp : employees) {
            emp.displayInfo();
            System.out.println("Pay: " + emp.calculatePay());
            System.out.println("-------------------");
        }
    }
}