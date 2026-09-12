package practice.decorator.part2.example2.decorator;

import practice.decorator.part2.example2.component.DataProcessor;

public class CompressionDecorator extends DataProcessorDecorator {

    public CompressionDecorator(DataProcessor dataProcessor) {
        super(dataProcessor);
    }

    @Override
    public void process(String data) {

        String compressedData = "COMPRESSED(" + data + ")";

        System.out.println("[COMPRESSION] Data compressed");

        dataProcessor.process(compressedData);
    }
}