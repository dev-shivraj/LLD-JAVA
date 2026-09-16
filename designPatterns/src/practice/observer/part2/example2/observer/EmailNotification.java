package practice.observer.part2.example2.observer;

public class EmailNotification implements Observer {

    @Override
    public void update(String orderId, String status) {
        System.out.println("Email sent: Order " + orderId + " is " + status);
    }
}