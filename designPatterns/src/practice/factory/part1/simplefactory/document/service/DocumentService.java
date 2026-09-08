package practice.factory.part1.simplefactory.document.service;

import practice.factory.part1.simplefactory.document.component.Document;
import practice.factory.part1.simplefactory.document.factory.DocumentFactory;


public class DocumentService {
    public void export(String documentType) {
        Document document = DocumentFactory.createDocument(documentType);
        document.export();
    }
}
