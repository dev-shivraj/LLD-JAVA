package practice.dip.part4.integrated.goodDesign;

public class EmailNotification implements Notification {
    @Override
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}