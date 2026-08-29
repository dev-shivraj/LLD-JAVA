package practice.dip.part3.cloudStorage.badDesign;

public class EmailNotification {

    public void send(String message) {
        System.out.println("Sending email: " + message);
    }
}