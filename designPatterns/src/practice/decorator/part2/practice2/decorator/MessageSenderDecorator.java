package practice.decorator.part2.practice2.decorator;

import practice.decorator.part2.practice2.component.MessageSender;

public abstract class MessageSenderDecorator implements MessageSender {

    protected MessageSender messageSender;

    protected MessageSenderDecorator(MessageSender messageSender) {
        this.messageSender = messageSender;
    }

    @Override
    public void send(String message) {
        messageSender.send(message);
    }
}