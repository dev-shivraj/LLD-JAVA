package practice.dip.part3.bird.badDesign;

public class EmailNotification {

    public void send(String message) {

        System.out.println(
                "Email: " + message
        );
    }
}