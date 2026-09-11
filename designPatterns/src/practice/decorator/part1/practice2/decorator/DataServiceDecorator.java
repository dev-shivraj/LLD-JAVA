package practice.decorator.part1.practice2.decorator;

import practice.decorator.part1.practice2.component.DataService;

public abstract class DataServiceDecorator implements DataService {

    protected DataService dataService;

    protected DataServiceDecorator(DataService dataService) {
        this.dataService = dataService;
    }

    @Override
    public void process(String data) {
        dataService.process(data);
    }
}