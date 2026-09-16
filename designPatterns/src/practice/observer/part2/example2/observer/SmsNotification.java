package practice.observer.part2.example2.observer;

public class SmsNotification implements Observer {

    @Override
    public void update(String orderId, String status) {
        System.out.println("SMS sent: Order " + orderId + " is " + status);
    }
}