package practice.decorator.part4.example3;

import practice.decorator.part4.example3.component.DataProcessor;
import practice.decorator.part4.example3.component.FileStorage;
import practice.decorator.part4.example3.decorator.CompressionDecorator;
import practice.decorator.part4.example3.decorator.EncryptionDecorator;

public class Client {
    public static void main(String[] args) {
        DataProcessor processor = new FileStorage();

        processor = new CompressionDecorator(processor);
        processor = new EncryptionDecorator(processor);

        processor.process("Customer sensitive information");
    }
}