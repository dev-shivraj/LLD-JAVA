package practice.decorator.part4.example3.decorator;

import practice.decorator.part4.example3.component.DataProcessor;

public class EncryptionDecorator extends DataProcessorDecorator {

    public EncryptionDecorator(DataProcessor dataProcessor) {
        super(dataProcessor);
    }

    @Override
    public void process(String data) {
        String encryptedData = "ENCRYPTED(" + data + ")";
        System.out.println("Encrypting data...");
        dataProcessor.process(encryptedData);
    }
}