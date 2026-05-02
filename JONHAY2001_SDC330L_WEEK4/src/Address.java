/**
 * Name: Jonathan Haynes
 * Date: 5/1/26
 * Purpose: Represents an Address (Composition)
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

    public String getStreet() { return street; }
    public String getCity() { return city; }

    public void displayAddress() {
        System.out.println("Address: " + street + ", " + city);
    }
}