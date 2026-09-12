package practice.decorator.part2.example2.decorator;

import practice.decorator.part2.example2.component.DataProcessor;

public class ValidationDecorator extends DataProcessorDecorator {

    public ValidationDecorator(DataProcessor dataProcessor) {
        super(dataProcessor);
    }

    @Override
    public void process(String data) {

        if (data == null || data.isBlank()) {
            System.out.println("[VALIDATION] Invalid data");
            return;
        }

        System.out.println("[VALIDATION] Data is valid");

        dataProcessor.process(data);
    }
}