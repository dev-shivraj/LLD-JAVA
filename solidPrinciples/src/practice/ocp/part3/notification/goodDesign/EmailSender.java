package practice.ocp.part3.notification.goodDesign;

public class EmailSender implements Sender {

    @Override
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}