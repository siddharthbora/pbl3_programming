import java.util.Scanner;

class Customer {
    private int consumerId;
    private String customerName;
    private String mobileNumber;
    private String email;

    // Constructor
    public Customer(int consumerId, String customerName, String mobileNumber, String email) {
        this.consumerId = consumerId;
        this.customerName = customerName;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }

    // Getters
    public int getConsumerId() {
        return consumerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public String getEmail() {
        return email;
    }
}

public class CustomerDetails {
    // Preconfigured array of customer objects
    private static Customer[] customers = {
            new Customer(101, "John Doe", "1234567890", "john@example.com"),
            new Customer(102, "Jane Smith", "9876543210", "jane@example.com"),
            new Customer(103, "Alice Johnson", "9998887770", "alice@example.com")
    };

    // Method to display customer details based on consumer ID
    public static void displayCustomerDetails(int consumerId) {
        System.out.println("Consumer ID | Customer Name | Mobile Number | Email");
        for (Customer customer : customers) {
            if (customer.getConsumerId() == consumerId) {
                System.out.println(customer.getConsumerId() + " | " + customer.getCustomerName() + " | " +
                                   customer.getMobileNumber() + " | " + customer.getEmail());
                return;
            }
        }
        System.out.println("Customer not found with the provided Consumer ID.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Consumer ID: ");
        int consumerId = scanner.nextInt();

        displayCustomerDetails(consumerId);
    }
}
