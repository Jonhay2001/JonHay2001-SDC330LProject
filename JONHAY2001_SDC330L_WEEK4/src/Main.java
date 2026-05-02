
/**
 * Name: Jonathan Haynes
 * Date: 2026
 * Purpose: Week 4 Main demonstrating database CRUD
 */

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Week 4 Project ===");
        System.out.println("Employee Management System");
        System.out.println("By: Jonathan Haynes");
        System.out.println("----------------------------");
        System.out.println("Welcome! This program uses SQLite for CRUD operations.\n");

        DatabaseManager.initializeDatabase();

        int choice;

        do {
            System.out.println("\n1. Add Employee");
            System.out.println("2. View Employees");
            System.out.println("3. Update Employee");
            System.out.println("4. Delete Employee");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = scanner.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Enter ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();

                    Employee emp = new SalariedEmployee(
                            id, name,
                            new Address("123 Main St", "Winston-Salem"),
                            50000
                    );

                    DatabaseManager.addEmployee(emp);
                    break;

                case 2:
                    DatabaseManager.viewEmployees();
                    break;

                case 3:
                    System.out.print("Enter ID: ");
                    int updateId = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("New Name: ");
                    String newName = scanner.nextLine();

                    DatabaseManager.updateEmployee(updateId, newName);
                    break;

                case 4:
                    System.out.print("Enter ID: ");
                    int deleteId = scanner.nextInt();

                    DatabaseManager.deleteEmployee(deleteId);
                    break;

            }

        } while (choice != 5);

        System.out.println("Goodbye!");
        scanner.close();
        
    }
}