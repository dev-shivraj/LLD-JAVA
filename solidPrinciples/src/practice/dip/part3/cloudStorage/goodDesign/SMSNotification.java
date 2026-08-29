package practice.dip.part3.cloudStorage.goodDesign;

public class SMSNotification
        implements Notification {

    @Override
    public void send(String message) {

        System.out.println(
                "Sending SMS: " + message
        );
    }
}