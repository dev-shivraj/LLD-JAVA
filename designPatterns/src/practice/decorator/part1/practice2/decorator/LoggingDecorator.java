package practice.decorator.part1.practice2.decorator;

import practice.decorator.part1.practice2.component.DataService;

public class LoggingDecorator extends DataServiceDecorator {

    public LoggingDecorator(DataService dataService) {
        super(dataService);
    }

    @Override
    public void process(String data) {
        System.out.println("LOG: Processing started");

        dataService.process(data);

        System.out.println("LOG: Processing completed");
    }
}