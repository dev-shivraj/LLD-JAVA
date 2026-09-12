package practice.decorator.part2.example2.decorator;

import practice.decorator.part2.example2.component.DataProcessor;

public abstract class DataProcessorDecorator implements DataProcessor {

    protected DataProcessor dataProcessor;

    protected DataProcessorDecorator(DataProcessor dataProcessor) {
        this.dataProcessor = dataProcessor;
    }

    @Override
    public void process(String data) {
        dataProcessor.process(data);
    }
}