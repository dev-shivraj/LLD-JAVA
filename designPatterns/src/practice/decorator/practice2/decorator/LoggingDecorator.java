package practice.decorator.practice2.decorator;

import practice.decorator.practice2.service.DataService;

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