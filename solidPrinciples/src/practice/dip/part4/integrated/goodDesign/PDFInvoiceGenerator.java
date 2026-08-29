package practice.dip.part4.integrated.goodDesign;

public class PDFInvoiceGenerator implements InvoiceGenerator {
    @Override
    public void generate(String orderId, double amount) {
        System.out.println("PDF invoice generated for order " + orderId + ", amount: " + amount);
    }
}