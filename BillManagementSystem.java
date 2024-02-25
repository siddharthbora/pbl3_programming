import java.util.ArrayList;
import java.util.Scanner;

class Bill {
    public int consumerNumber;
    public double dueAmount;
    public double payableAmount;

    // Constructor
    public Bill(int consumerNumber, double dueAmount, double payableAmount) {
        this.consumerNumber = consumerNumber;
        this.dueAmount = dueAmount;
        this.payableAmount = payableAmount;
    }
}

public class BillManagementSystem {
    private ArrayList<Bill> bills = new ArrayList<>();

    // Method to add a bill
    public void addBill(int consumerNumber, double dueAmount, double payableAmount) {
        Bill bill = new Bill(consumerNumber, dueAmount, payableAmount);
        bills.add(bill);
        System.out.println("Bill added successfully");
    }

    // Method to update bill details by consumer number
    public void updateBillDetails(int consumerNumber, double newAmount) {
        for (Bill bill : bills) {
            if (bill.consumerNumber == consumerNumber) {
                bill.dueAmount = newAmount;
                System.out.println("Bill details updated successfully");
                return;
            }
        }
        System.out.println("Bill not found with the provided consumer number");
    }

    // Method to delete bill details by consumer number
    public void deleteBill(int consumerNumber) {
        for (Bill bill : bills) {
            if (bill.consumerNumber == consumerNumber) {
                bills.remove(bill);
                System.out.println("Bill deleted");
                return;
            }
        }
        System.out.println("Bill not found with the provided consumer number");
    }

    // Method to print all bills
    public void printAllBills() {
        if (bills.isEmpty()) {
            System.out.println("No bills found");
            return;
        }
        System.out.println("All Bills:");
        for (Bill bill : bills) {
            System.out.println("Consumer Number: " + bill.consumerNumber + ", Due Amount: " + bill.dueAmount + ", Payable Amount: " + bill.payableAmount);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BillManagementSystem bms = new BillManagementSystem();

        while (true) {
            System.out.println("1. Add Bill");
            System.out.println("2. Update Due Amount");
            System.out.println("3. Delete Bill");
            System.out.println("4. Print All Bills");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Consumer Number: ");
                    int consumerNumber = scanner.nextInt();
                    System.out.print("Enter Due Amount: ");
                    double dueAmount = scanner.nextDouble();
                    System.out.print("Enter Payable Amount: ");
                    double payableAmount = scanner.nextDouble();
                    bms.addBill(consumerNumber, dueAmount, payableAmount);
                    break;
                case 2:
                    System.out.print("Enter Consumer Number: ");
                    int updateConsumerNumber = scanner.nextInt();
                    System.out.print("Enter New Due Amount: ");
                    double newDueAmount = scanner.nextDouble();
                    bms.updateBillDetails(updateConsumerNumber, newDueAmount);
                    break;
                case 3:
                    System.out.print("Enter Consumer Number: ");
                    int deleteConsumerNumber = scanner.nextInt();
                    bms.deleteBill(deleteConsumerNumber);
                    break;
                case 4:
                    bms.printAllBills();
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
