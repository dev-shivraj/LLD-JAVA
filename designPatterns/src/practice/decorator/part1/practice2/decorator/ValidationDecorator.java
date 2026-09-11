package practice.decorator.part1.practice2.decorator;

import practice.decorator.part1.practice2.component.DataService;

public class ValidationDecorator extends DataServiceDecorator {

    public ValidationDecorator(DataService dataService) {
        super(dataService);
    }

    @Override
    public void process(String data) {

        if (data == null || data.isBlank()) {
            System.out.println("Validation failed: Data cannot be empty");
            return;
        }

        dataService.process(data);
    }
}