package practice.decorator.part2.example2;

import practice.decorator.part2.example2.component.BasicDataProcessor;
import practice.decorator.part2.example2.component.DataProcessor;
import practice.decorator.part2.example2.decorator.CompressionDecorator;
import practice.decorator.part2.example2.decorator.EncryptionDecorator;
import practice.decorator.part2.example2.decorator.LoggingDecorator;
import practice.decorator.part2.example2.decorator.ValidationDecorator;

public class Client {

    public static void main(String[] args) {

        DataProcessor processor = new BasicDataProcessor();

        processor = new LoggingDecorator(processor);
        processor = new ValidationDecorator(processor);
        processor = new CompressionDecorator(processor);
        processor = new EncryptionDecorator(processor);

        processor.process("PaymentData");
    }
}