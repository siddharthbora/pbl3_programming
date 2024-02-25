import java.util.ArrayList;
import java.util.Scanner;

class Complaint {
    public String complaintType;
    public String category;
    public String landmark;
    public String customerName;
    public String problem;
    public int consumerNumber;
    public String address;
    public String mobileNumber;

    // Constructor
    public Complaint(String complaintType, String category, String landmark, String customerName,
                     String problem, int consumerNumber, String address, String mobileNumber) {
        this.complaintType = complaintType;
        this.category = category;
        this.landmark = landmark;
        this.customerName = customerName;
        this.problem = problem;
        this.consumerNumber = consumerNumber;
        this.address = address;
        this.mobileNumber = mobileNumber;
    }
}

public class ComplaintManagementSystem {
    private ArrayList<Complaint> complaints = new ArrayList<>();

    // Method to register a complaint
    public void registerComplaint(String complaintType, String category, String landmark, String customerName,
                                  String problem, int consumerNumber, String address, String mobileNumber) {
        Complaint complaint = new Complaint(complaintType, category, landmark, customerName, problem, consumerNumber, address, mobileNumber);
        complaints.add(complaint);
        System.out.println("Successfully registered Complaint");
    }

    // Method to validate mobile number
    public boolean validateMobileNumber(String mobileNumber) {
        return mobileNumber.matches("\\d{10}");
    }

    // Method to delete a complaint by consumer number
    public void deleteComplaint(int consumerNumber) {
        for (Complaint complaint : complaints) {
            if (complaint.consumerNumber == consumerNumber) {
                complaints.remove(complaint);
                System.out.println("Complaint details are deleted");
                return;
            }
        }
        System.out.println("Complaint not found with the provided consumer number");
    }

    // Method to print all complaints
    public void printAllComplaints() {
        if (complaints.isEmpty()) {
            System.out.println("No complaints registered yet");
            return;
        }
        System.out.println("All Complaints:");
        for (Complaint complaint : complaints) {
            System.out.println("Complaint Type: " + complaint.complaintType);
            System.out.println("Category: " + complaint.category);
            System.out.println("Landmark: " + complaint.landmark);
            System.out.println("Customer Name: " + complaint.customerName);
            System.out.println("Problem: " + complaint.problem);
            System.out.println("Consumer Number: " + complaint.consumerNumber);
            System.out.println("Address: " + complaint.address);
            System.out.println("Mobile Number: " + complaint.mobileNumber);
            System.out.println("---------------------------");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComplaintManagementSystem cms = new ComplaintManagementSystem();

        while (true) {
            System.out.println("1. Register Complaint");
            System.out.println("2. Delete Complaint");
            System.out.println("3. Print All Complaints");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Complaint Type: ");
                    String complaintType = scanner.nextLine();
                    System.out.print("Enter Category: ");
                    String category = scanner.nextLine();
                    System.out.print("Enter Landmark: ");
                    String landmark = scanner.nextLine();
                    System.out.print("Enter Customer Name: ");
                    String customerName = scanner.nextLine();
                    System.out.print("Enter Problem: ");
                    String problem = scanner.nextLine();
                    System.out.print("Enter Consumer Number: ");
                    int consumerNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    System.out.print("Enter Address: ");
                    String address = scanner.nextLine();
                    System.out.print("Enter Mobile Number: ");
                    String mobileNumber = scanner.nextLine();
                    if (cms.validateMobileNumber(mobileNumber)) {
                        cms.registerComplaint(complaintType, category, landmark, customerName, problem, consumerNumber, address, mobileNumber);
                    } else {
                        System.out.println("Invalid mobile number format. Please enter a 10-digit mobile number.");
                    }
                    break;
                case 2:
                    System.out.print("Enter Consumer Number of Complaint to Delete: ");
                    int deleteConsumerNumber = scanner.nextInt();
                    scanner.nextLine(); // Consume newline
                    cms.deleteComplaint(deleteConsumerNumber);
                    break;
                case 3:
                    cms.printAllComplaints();
                    break;
                case 4:
                    System.out.println("Exiting...");
                    return;
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
            }
        }
    }
}
