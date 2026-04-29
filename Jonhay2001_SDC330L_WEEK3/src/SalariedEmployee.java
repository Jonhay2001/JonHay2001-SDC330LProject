/**
 * Name: Jonathan Haynes
 * Date: 2026
 * Purpose: Represents a salaried employee
 */
public class SalariedEmployee extends Employee implements Payable {

    private double salary;

    // Default constructor
    public SalariedEmployee() {
        super();
        this.salary = 0;
    }

    // Parameterized constructor
    public SalariedEmployee(int id, String name, Address address, double salary) {
        super(id, name, address);
        this.salary = salary;
    }

    @Override
    public double calculatePay() {
        return salary;
    }

    @Override
    public String getEmployeeType() {
        return "Salaried Employee";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Salary: " + salary);
    }
}

