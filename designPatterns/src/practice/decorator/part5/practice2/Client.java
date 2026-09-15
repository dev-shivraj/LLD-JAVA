package practice.decorator.part5.practice2;

import practice.decorator.part5.practice2.component.BasicFileDownloadService;
import practice.decorator.part5.practice2.component.FileDownloadService;
import practice.decorator.part5.practice2.decorator.CompressionDecorator;
import practice.decorator.part5.practice2.decorator.EncryptionDecorator;
import practice.decorator.part5.practice2.decorator.LoggingDecorator;

public class Client {

    public static void main(String[] args) {
        FileDownloadService service = new BasicFileDownloadService();

        service = new CompressionDecorator(service);
        service = new EncryptionDecorator(service);
        service = new LoggingDecorator(service);

        service.download("customer-data.csv");
    }
}