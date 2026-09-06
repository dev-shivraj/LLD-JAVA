package practice.facade.base;

public class MailService {

    public void sendEmail(Order order) {
        System.out.println("Sending mail for Order id: "+order.orderId);
    }
}