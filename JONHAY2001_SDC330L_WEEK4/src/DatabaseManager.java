/**
 * Name: Jonathan Haynes
 * Date: 5/1/26
 * Purpose: Handles SQLite database operations (CRUD)
 */

import java.sql.*;

public class DatabaseManager {

    private static final String URL = "jdbc:sqlite:employees.db";

    public static void initializeDatabase() {
        String sql = "CREATE TABLE IF NOT EXISTS employees (" +
                "id INTEGER PRIMARY KEY, " +
                "name TEXT, " +
                "type TEXT, " +
                "salary REAL, " +
                "hours REAL, " +
                "rate REAL, " +
                "street TEXT, " +
                "city TEXT)";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // CREATE
    public static void addEmployee(Employee emp) {
        String sql = "INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, emp.id);
            pstmt.setString(2, emp.name);
            pstmt.setString(3, emp.getEmployeeType());

            if (emp instanceof SalariedEmployee) {
                pstmt.setDouble(4, ((SalariedEmployee) emp).getSalary());
                pstmt.setDouble(5, 0);
                pstmt.setDouble(6, 0);
            } else {
                pstmt.setDouble(4, 0);
                pstmt.setDouble(5, ((HourlyEmployee) emp).getHours());
                pstmt.setDouble(6, ((HourlyEmployee) emp).getRate());
            }

            pstmt.setString(7, emp.address.getStreet());
            pstmt.setString(8, emp.address.getCity());

            pstmt.executeUpdate();
            System.out.println("Employee added.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // READ
    public static void viewEmployees() {
        String sql = "SELECT * FROM employees";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql)) {

            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id"));
                System.out.println("Name: " + rs.getString("name"));
                System.out.println("Type: " + rs.getString("type"));
                System.out.println("City: " + rs.getString("city"));
                System.out.println("-------------------");
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // UPDATE
    public static void updateEmployee(int id, String newName) {
        String sql = "UPDATE employees SET name = ? WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, newName);
            pstmt.setInt(2, id);

            pstmt.executeUpdate();
            System.out.println("Employee updated.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // DELETE
    public static void deleteEmployee(int id) {
        String sql = "DELETE FROM employees WHERE id = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.executeUpdate();

            System.out.println("Employee deleted.");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
