package practice.decorator.part4.example3.decorator;

import practice.decorator.part4.example3.component.DataProcessor;

public class CompressionDecorator extends DataProcessorDecorator {

    public CompressionDecorator(DataProcessor dataProcessor) {
        super(dataProcessor);
    }

    @Override
    public void process(String data) {
        String compressedData = "COMPRESSED(" + data + ")";
        System.out.println("Compressing data...");
        dataProcessor.process(compressedData);
    }
}