package practice.decorator.practice2;

import practice.decorator.practice2.decorator.EncryptionDecorator;
import practice.decorator.practice2.decorator.LoggingDecorator;
import practice.decorator.practice2.decorator.ValidationDecorator;
import practice.decorator.practice2.service.BasicDataService;
import practice.decorator.practice2.service.DataService;

public class Client {

    public static void main(String[] args) {

        DataService dataService = new BasicDataService();

        dataService = new LoggingDecorator(dataService);
        dataService = new ValidationDecorator(dataService);
        dataService = new EncryptionDecorator(dataService);

        dataService.process("Payment123");
    }
}