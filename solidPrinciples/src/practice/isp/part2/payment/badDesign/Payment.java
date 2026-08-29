package practice.isp.part2.payment.badDesign;

public interface Payment {
    void pay();
    void refund();
    void payWithCash();
    void generateReceipt();
    void sendNotification();
}