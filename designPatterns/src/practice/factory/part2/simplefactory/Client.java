package practice.factory.part2.simplefactory;

import practice.factory.part2.simplefactory.service.DocumentService;

public class Client {
    public static void main(String[] args) {
        DocumentService service = new DocumentService();
        service.export("PDF");
        service.export("HTML");
        service.export("WORD");
    }
}
