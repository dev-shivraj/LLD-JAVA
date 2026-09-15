package practice.decorator.part4.example3.decorator;

import practice.decorator.part4.example3.component.DataProcessor;

public abstract class DataProcessorDecorator implements DataProcessor {

    protected final DataProcessor dataProcessor;

    protected DataProcessorDecorator(DataProcessor dataProcessor) {
        this.dataProcessor = dataProcessor;
    }

    @Override
    public void process(String data) {
        dataProcessor.process(data);
    }
}