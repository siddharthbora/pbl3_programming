import java.util.ArrayList;
import java.util.Scanner;

class Customer {
    private int consumerId;
    private int billNumber;
    private String title;
    private String customerName;
    private String email;
    private String mobileNumber;
    private String userId;
    private String password;

    // Constructor
    public Customer(int consumerId, int billNumber, String title, String customerName, String email,
                    String mobileNumber, String userId, String password) {
        this.consumerId = consumerId;
        this.billNumber = billNumber;
        this.title = title;
        this.customerName = customerName;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.userId = userId;
        this.password = password;
    }

    // Getters and Setters
    // Add as needed
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getConsumerId() {
        return consumerId;
    }
}

public class CustomerManagementSystem {
    private ArrayList<Customer> customers = new ArrayList<>();

    // Method to add a customer
    public void addCustomer(int consumerId, int billNumber, String title, String customerName, String email,
                            String mobileNumber, String userId, String password) {
        Customer customer = new Customer(consumerId, billNumber, title, customerName, email, mobileNumber, userId, password);
        customers.add(customer);
        System.out.println("Customer Registration is successful");
    }

    // Method to update customer details by consumerId
    public void updateCustomerDetails(int consumerId, String newEmail) {
        for (Customer customer : customers) {
            if (customer.getConsumerId() == consumerId) {
                customer.setEmail(newEmail);
                System.out.println("Customer details are updated successfully");
                return;
            }
        }
        System.out.println("Customer not found with the provided consumer ID");
    }

    // Method to delete customer by consumerId
    public void deleteCustomer(int consumerId) {
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).getConsumerId() == consumerId) {
                customers.remove(i);
                System.out.println("Customer details are deleted");
                return;
            }
        }
        System.out.println("Customer not found with the provided consumer ID");
    }

    // Method to print all customers
    public void printAllCustomers() {
        for (Customer customer : customers) {
            System.out.println(customer.getEmail()); // Print any other desired information
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        CustomerManagementSystem cms = new CustomerManagementSystem();

        while (true) {
            System.out.println("1. Add Customer");
            System.out.println("2. Update Customer Details");
            System.out.println("3. Delete Customer");
            System.out.println("4. Print All Customers");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Consumer ID: ");
                    int consumerId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Bill Number: ");
                    int billNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    System.out.print("Enter Mobile Number: ");
                    String mobileNumber = scanner.nextLine();
                    // Assuming userId and password will be generated automatically
                    cms.addCustomer(consumerId, billNumber, title, customerName, email, mobileNumber, "defaultUserId", "defaultPassword");
                    break;
                case 2:
                    System.out.print("Enter Consumer ID: ");
                    int updateConsumerId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter New Email: ");
                    String newEmail = scanner.nextLine();
                    cms.updateCustomerDetails(updateConsumerId, newEmail);
                    break;
                case 3:
                    System.out.print("Enter Consumer ID: ");
                    int deleteConsumerId = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    cms.deleteCustomer(deleteConsumerId);
                    break;
                case 4:
                    cms.printAllCustomers();
                    break;
                case 5:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
