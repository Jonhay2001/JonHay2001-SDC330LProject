/**
 * Name: Jonathan Haynes
 * Date: 2026
 * Purpose: Week 5 Main demonstrating database CRUD
 */

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Week 4 Header
        System.out.println("=== Week 5 Project ===");
        System.out.println("Employee Management System");
        System.out.println("By: Jonathan Haynes");
        System.out.println("----------------------------------");
        System.out.println("Welcome! This program uses SQLite for CRUD operations.");
        System.out.println("You can add, view, update, and delete employees.\n");

        // Initialize database
        DatabaseManager.initializeDatabase();

        int choice;

        do {

            // Menu
            System.out.println("\n===== MENU =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {

                // CREATE
                case 1:

                    System.out.print("Enter Employee Type (1 = Salaried, 2 = Hourly): ");
                    int typeChoice = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    System.out.print("Enter Street: ");
                    String street = scanner.nextLine();

                    System.out.print("Enter City: ");
                    String city = scanner.nextLine();

                    Address address = new Address(street, city);

                    Employee emp;

                    // Salaried Employee
                    if (typeChoice == 1) {

                        System.out.print("Enter Salary: ");
                        double salary = scanner.nextDouble();

                        emp = new SalariedEmployee(
                                id,
                                name,
                                address,
                                salary
                        );

                    }
                    // Hourly Employee
                    else {

                        System.out.print("Enter Hours Worked: ");
                        double hours = scanner.nextDouble();

                        System.out.print("Enter Hourly Rate: ");
                        double rate = scanner.nextDouble();

                        emp = new HourlyEmployee(
                                id,
                                name,
                                address,
                                hours,
                                rate
                        );
                    }

                    DatabaseManager.addEmployee(emp);
                    break;

                // READ
                case 2:

                    System.out.println("\n=== Employee Records ===");
                    DatabaseManager.viewEmployees();
                    break;

                // UPDATE
                case 3:

                    System.out.print("Enter Employee ID to Update: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter New Name: ");
                    String newName = scanner.nextLine();

                    DatabaseManager.updateEmployee(updateId, newName);
                    break;

                // DELETE
                case 4:

                    System.out.print("Enter Employee ID to Delete: ");
                    int deleteId = scanner.nextInt();

                    DatabaseManager.deleteEmployee(deleteId);
                    break;

                // EXIT
                case 5:

                    System.out.println("Exiting program...");
                    break;

                // INVALID OPTION
                default:

                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 5);

        System.out.println("Goodbye!");

        // Close scanner
        scanner.close();
    }
}