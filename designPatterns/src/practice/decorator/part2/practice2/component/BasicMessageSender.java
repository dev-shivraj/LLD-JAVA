package practice.decorator.part2.practice2.component;

public class BasicMessageSender implements MessageSender {

    @Override
    public void send(String message) {
        System.out.println("Sending message: " + message);
    }
}