package practice.observer.part3.practice2.strategy;

public class EmailStrategy implements NotificationStrategy {

    @Override
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}