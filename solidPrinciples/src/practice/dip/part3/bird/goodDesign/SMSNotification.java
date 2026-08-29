package practice.dip.part3.bird.goodDesign;

public class SMSNotification
        implements Notification {

    @Override
    public void send(String message) {

        System.out.println(
                "SMS: " + message
        );
    }
}