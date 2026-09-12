package practice.decorator.part2.practice2.decorator;

import practice.decorator.part2.practice2.component.MessageSender;

public class EncryptionDecorator extends MessageSenderDecorator {

    public EncryptionDecorator(MessageSender messageSender) {
        super(messageSender);
    }

    @Override
    public void send(String message) {
        String encryptedMessage = "ENCRYPTED(" + message + ")";
        messageSender.send(encryptedMessage);
    }
}