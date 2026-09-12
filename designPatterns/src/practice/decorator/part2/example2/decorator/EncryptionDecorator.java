package practice.decorator.part2.example2.decorator;

import practice.decorator.part2.example2.component.DataProcessor;

public class EncryptionDecorator extends DataProcessorDecorator {

    public EncryptionDecorator(DataProcessor dataProcessor) {
        super(dataProcessor);
    }

    @Override
    public void process(String data) {

        String encryptedData = "ENCRYPTED(" + data + ")";

        System.out.println("[ENCRYPTION] Data encrypted");

        dataProcessor.process(encryptedData);
    }
}