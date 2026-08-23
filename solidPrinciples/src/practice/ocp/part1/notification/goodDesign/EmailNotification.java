package practice.ocp.part1.notification.goodDesign;

public class EmailNotification implements Notification {
    @Override
    public void send() {
        System.out.println("Sending notification through Email");
    }
}