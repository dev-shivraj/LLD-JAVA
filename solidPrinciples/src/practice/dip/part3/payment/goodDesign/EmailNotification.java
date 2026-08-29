package practice.dip.part3.payment.goodDesign;

public class EmailNotification
        implements Notification {

    @Override
    public void send(String message) {

        System.out.println(
                "Email: " + message
        );
    }
}