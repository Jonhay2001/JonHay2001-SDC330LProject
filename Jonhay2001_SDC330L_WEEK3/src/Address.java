/**
 * Name: Jonathan Haynes
 * Date: 4/252/026
 * Purpose: Represents an Address for an Employee (Composition)
 */
public class Address {
    private String street;
    private String city;

    // Default constructor
    public Address() {
        this.street = "N/A";
        this.city = "N/A";
    }

    // Parameterized constructor
    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    public void displayAddress() {
        System.out.println("Address: " + street + ", " + city);
    }
}
