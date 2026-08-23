package practice.ocp.part3.notification.goodDesign;

public class SmsSender implements Sender {

    @Override
    public void send(String message) {
        System.out.println("Sending SMS: " + message);
    }
}