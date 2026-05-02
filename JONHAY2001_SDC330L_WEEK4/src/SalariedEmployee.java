/**
 * Name: Jonathan Haynes
 * Date: 5/1/26
 * Purpose: Salaried employee class
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

    public double getSalary() {
        return salary;
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Salary: " + salary);
    }
}