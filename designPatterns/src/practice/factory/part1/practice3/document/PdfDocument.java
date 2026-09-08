package practice.factory.part1.practice3.document;

import practice.factory.part1.practice3.parser.DocumentParser;

public class PdfDocument implements Document {

    private final DocumentParser parser;

    public PdfDocument(DocumentParser parser) {
        this.parser = parser;
    }

    @Override
    public void open() {
        parser.parse();
    }

    @Override
    public void save() {
        System.out.println("Saving PDF document");
    }
}