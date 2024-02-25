import java.util.Scanner;

class Complaint {
    private int consumerId;
    private String customerName;
    private String complaintType;
    private String category;
    private String problemDescription;
    private String mobile;
    private String status;

    // Constructor
    public Complaint(int consumerId, String customerName, String complaintType, String category,
                     String problemDescription, String mobile, String status) {
        this.consumerId = consumerId;
        this.customerName = customerName;
        this.complaintType = complaintType;
        this.category = category;
        this.problemDescription = problemDescription;
        this.mobile = mobile;
        this.status = status;
    }

    // Getters
    public int getConsumerId() {
        return consumerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getComplaintType() {
        return complaintType;
    }

    public String getCategory() {
        return category;
    }

    public String getProblemDescription() {
        return problemDescription;
    }

    public String getMobile() {
        return mobile;
    }

    public String getStatus() {
        return status;
    }
}

public class ComplaintDetails {
    // Preconfigured array of complaint objects
    private static Complaint[] complaints = {
            new Complaint(101, "John Doe", "Service", "Technical", "Internet not working", "1234567890", "Open"),
            new Complaint(102, "Jane Smith", "Billing", "Financial", "Incorrect bill amount", "9876543210", "Closed"),
            new Complaint(103, "Alice Johnson", "Service", "Technical", "Noisy line", "9998887770", "Open")
    };

    // Method to display complaint details based on consumer ID
    public static void displayComplaintDetails(int consumerId) {
        System.out.println("Consumer ID | CustomerName | Complaint Type | Category | Problem Description | Mobile | Status");
        for (Complaint complaint : complaints) {
            if (complaint.getConsumerId() == consumerId) {
                System.out.println(complaint.getConsumerId() + " | " + complaint.getCustomerName() + " | " +
                                   complaint.getComplaintType() + " | " + complaint.getCategory() + " | " +
                                   complaint.getProblemDescription() + " | " + complaint.getMobile() + " | " +
                                   complaint.getStatus());
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Consumer ID: ");
        int consumerId = scanner.nextInt();

        displayComplaintDetails(consumerId);
    }
}
