package practice.decorator.part2.example2.decorator;

import practice.decorator.part2.example2.component.DataProcessor;

public class LoggingDecorator extends DataProcessorDecorator {

    public LoggingDecorator(DataProcessor dataProcessor) {
        super(dataProcessor);
    }

    @Override
    public void process(String data) {

        System.out.println("[LOG] Processing started");

        dataProcessor.process(data);

        System.out.println("[LOG] Processing completed");
    }
}