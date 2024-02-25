import java.util.Scanner;

class Bill2 {
    private int consumerId;
    private String customerName;
    private double dueAmount;
    private double payableAmount;

    // Constructor
    public Bill2(int consumerId, String customerName, double dueAmount, double payableAmount) {
        this.consumerId = consumerId;
        this.customerName = customerName;
        this.dueAmount = dueAmount;
        this.payableAmount = payableAmount;
    }

    // Getters
    public int getConsumerId() {
        return consumerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public double getDueAmount() {
        return dueAmount;
    }

    public double getPayableAmount() {
        return payableAmount;
    }
}

public class UnpaidBillDetails {
    // Preconfigured array of bill objects
    private static Bill2[] bills = {
            new Bill2(101, "John Doe", 500.0, 600.0),
            new Bill2(102, "Jane Smith", 0.0, 0.0),
            new Bill2(103, "Alice Johnson", 200.0, 300.0)
    };

    // Method to display unpaid bill details based on consumer ID
    public static void displayUnpaidBillDetails(int consumerId) {
        System.out.println("Consumer ID | CustomerName | Due Amount | Payable Amount");
        for (Bill2 bill : bills) {
            if (bill.getConsumerId() == consumerId && bill.getDueAmount() > 0) {
                System.out.println(bill.getConsumerId() + " | " + bill.getCustomerName() + " | " +
                                   bill.getDueAmount() + " | " + bill.getPayableAmount());
                return;
            }
        }
        System.out.println("No unpaid bills found for the provided Consumer ID.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Consumer ID: ");
        int consumerId = scanner.nextInt();

        displayUnpaidBillDetails(consumerId);
    }
}
