/**
 * Name: Jonathan Haynes
 * Date: 5/1/26
 * Purpose: Hourly employee class
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

    public double getHours() { return hours; }
    public double getRate() { return rate; }

    @Override
    public void displayInfo() {
        super.displayInfo();
        System.out.println("Hours: " + hours);
        System.out.println("Rate: " + rate);
    }
}
