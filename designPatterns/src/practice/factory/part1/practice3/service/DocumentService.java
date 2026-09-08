package practice.factory.part1.practice3.service;

import practice.factory.part1.practice3.document.Document;
import practice.factory.part1.practice3.factory.DocumentFactory;

public class DocumentService {

    public void process(String type) {
        Document document = DocumentFactory.create(type);
        document.open();
        document.save();
    }
}