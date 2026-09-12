package practice.decorator.part2.practice2;

import practice.decorator.part2.practice2.component.BasicMessageSender;
import practice.decorator.part2.practice2.component.MessageSender;
import practice.decorator.part2.practice2.decorator.CompressionDecorator;
import practice.decorator.part2.practice2.decorator.EncryptionDecorator;
import practice.decorator.part2.practice2.decorator.LoggingDecorator;

public class Client {

    public static void main(String[] args) {

        MessageSender sender = new BasicMessageSender();

        sender = new LoggingDecorator(sender);
        sender = new EncryptionDecorator(sender);
        sender = new CompressionDecorator(sender);

        sender.send("Hello");
    }
}