package practice.srp.part1.order.badDesign;

public class OrderService {

    // Order responsibility
    void createOrder() {
        System.out.println("Order created");
    }

    // Order responsibility
    void calculateTotal() {
        System.out.println("Total calculated");
    }

    // Order responsibility
    void applyDiscount() {
        System.out.println("Discount applied");
    }

    // Persistence responsibility
    void saveOrder() {
        System.out.println("Order saved");
    }

    // Reporting responsibility
    void generateInvoice() {
        System.out.println("Invoice generated");
    }

    // Communication responsibility
    void sendConfirmationEmail() {
        System.out.println("Notification sent");
    }
}
