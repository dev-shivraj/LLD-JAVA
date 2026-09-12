package practice.decorator.part2.practice2.decorator;

import practice.decorator.part2.practice2.component.MessageSender;

public class CompressionDecorator extends MessageSenderDecorator {

    public CompressionDecorator(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void send(String message) {
        String compressedMessage = "COMPRESSED(" + message + ")";
        messageSender.send(compressedMessage);
    }
}