package practice.decorator.part1.practice2;

import practice.decorator.part1.practice2.decorator.EncryptionDecorator;
import practice.decorator.part1.practice2.decorator.LoggingDecorator;
import practice.decorator.part1.practice2.decorator.ValidationDecorator;
import practice.decorator.part1.practice2.component.BasicDataService;
import practice.decorator.part1.practice2.component.DataService;

public class Client {

    public static void main(String[] args) {

        DataService dataService = new BasicDataService();

        dataService = new LoggingDecorator(dataService);
        dataService = new ValidationDecorator(dataService);
        dataService = new EncryptionDecorator(dataService);

        dataService.process("Payment123");
    }
}