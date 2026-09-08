package practice.factory.part1.simplefactory.document;

import practice.factory.part1.simplefactory.document.service.DocumentService;

public class Client {
    public static void main(String[] args) {
        DocumentService service = new DocumentService();
        service.export("PDF");
        service.export("HTML");
        service.export("WORD");
    }
}
