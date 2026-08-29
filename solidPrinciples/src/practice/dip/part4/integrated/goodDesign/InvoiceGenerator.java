package practice.dip.part4.integrated.goodDesign;

public interface InvoiceGenerator {
    void generate(String orderId, double amount);
}