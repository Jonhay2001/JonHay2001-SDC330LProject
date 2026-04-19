

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        ArrayList<Employee> employees = new ArrayList<>();

        employees.add(new SalariedEmployee(
            1, "John Haynes",
            new Address("123 Main St", "Greensboro"),
            50000
        ));

        employees.add(new HourlyEmployee(
            2, " Michelle Pegram",
            new Address("456 Oak St", "Winston-Salem"),
            40, 20
        ));

        // POLYMORPHISM HAPPENS HERE
        for (Employee emp : employees) {
            emp.displayInfo();              // different behavior
            System.out.println("Pay: " + emp.calculatePay()); // dynamic binding
            System.out.println("-------------------");
        }
    }
}