package practice.decorator.part2.practice2.decorator;

import practice.decorator.part2.practice2.component.MessageSender;

public class LoggingDecorator extends MessageSenderDecorator {

    public LoggingDecorator(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void send(String message) {
        System.out.println("[LOG] Sending started");
        messageSender.send(message);
        System.out.println("[LOG] Sending completed");
    }
}