package practice.factory.part3.registryfactory.notification.component;

public class PushNotification implements Notification{
    @Override
    public void send(String message) {
        System.out.println("PUSH: " + message);
    }
}
