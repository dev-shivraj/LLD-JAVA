package practice.dip.part4.integrated.goodDesign;

public class SMSNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}