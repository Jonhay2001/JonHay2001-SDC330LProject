public class Main {
    public static void main(String[] args) {

        Address addr1 = new Address("123 Main St", "Greensboro");

        SalariedEmployee emp1 =
            new SalariedEmployee(1, "John Haynes", addr1, 50000);

        emp1.displayInfo();
    }
}
