package practice.dip.part3.cloudStorage.goodDesign;

public class EmailNotification
        implements Notification {

    @Override
    public void send(String message) {

        System.out.println(
                "Sending email: " + message
        );
    }
}