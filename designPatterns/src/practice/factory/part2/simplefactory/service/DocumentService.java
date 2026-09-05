package practice.factory.part2.simplefactory.service;

import practice.factory.part2.simplefactory.component.Document;
import practice.factory.part2.simplefactory.factory.DocumentFactory;


public class DocumentService {
    public void export(String documentType) {
        Document document = DocumentFactory.createDocument(documentType);
        document.export();
    }
}
