package practice.factory.part1.practice3.document;

import practice.factory.part1.practice3.parser.DocumentParser;

public class ExcelDocument implements Document {

    private final DocumentParser parser;

    public ExcelDocument(DocumentParser parser) {
        this.parser = parser;
    }

    @Override
    public void open() {
        parser.parse();
    }

    @Override
    public void save() {
        System.out.println("Saving Excel document");
    }
}