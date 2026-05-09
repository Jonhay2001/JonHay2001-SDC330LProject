
/**
 * Name: Jonathan Haynes
 * Date: 5/1/26
 * Purpose: Abstract base class demonstrating abstraction
 */
public abstract class Employee {

    protected int id;
    protected String name;
    protected Address address;

    // Default constructor
    public Employee() {
        this.id = 0;
        this.name = "Unknown";
        this.address = new Address();
    }

    // Parameterized constructor
    public Employee(int id, String name, Address address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public void displayInfo() {
        System.out.println("ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Type: " + getEmployeeType());
        address.displayAddress();
    }

    public abstract double calculatePay();
    public abstract String getEmployeeType();
}
