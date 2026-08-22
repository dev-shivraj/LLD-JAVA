package practice.srp.part2.payment.badDesign;

public class PaymentService {

    // group 1 : core payment business logic
    public void processPayment() {
        System.out.println("Processing payment");
    }

    // group 1 : core payment business logic
    public void calculateTax() {
        System.out.println("Calculating tax");
    }

    // group 1 : core payment business logic
    public void applyDiscount() {
        System.out.println("Applying discount");
    }

    // group 2 : reporting responsibility
    public void generateReceipt() {
        System.out.println("Generating receipt");
    }

    // group 3 : persistence responsibility
    public void saveTransaction() {
        System.out.println("Saving transaction");
    }

    // group 4 : communication responsibility
    public void sendConfirmation() {
        System.out.println("Sending confirmation");
    }
}