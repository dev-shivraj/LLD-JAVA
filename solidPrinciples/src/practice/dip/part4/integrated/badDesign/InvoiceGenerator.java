package practice.dip.part4.integrated.badDesign;

public class InvoiceGenerator {
    public void generate(String orderId, double amount) {
        System.out.println("Invoice generated for order " + orderId + ", amount: " + amount);
    }
}