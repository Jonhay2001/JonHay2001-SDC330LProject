
/**
 * Name: Jonathan Haynes
 * Date: 2026
 * Purpose: Represents an hourly employee
 */
public class HourlyEmployee extends Employee implements Payable {

    private double hours;
    private double rate;

    // Default constructor
    public HourlyEmployee() {
        super();
        this.hours = 0;
        this.rate = 0;
    }

    // Parameterized constructor
    public HourlyEmployee(int id, String name, Address address, double hours, double rate) {
        super(id, name, address);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        return hours * rate;
    }

    @Override
    public String getEmployeeType() {
        return "Hourly Employee";
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Hours: " + hours);
        System.out.println("Rate: " + rate);
    }
}
