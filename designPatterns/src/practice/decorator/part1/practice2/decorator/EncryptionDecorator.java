package practice.decorator.part1.practice2.decorator;

import practice.decorator.part1.practice2.component.DataService;

public class EncryptionDecorator extends DataServiceDecorator {

    public EncryptionDecorator(DataService dataService) {
        super(dataService);
    }

    @Override
    public void process(String data) {

        String encryptedData = "ENCRYPTED(" + data + ")";

        dataService.process(encryptedData);
    }
}