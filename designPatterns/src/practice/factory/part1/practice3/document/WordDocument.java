package practice.factory.part1.practice3.document;

import practice.factory.part1.practice3.parser.DocumentParser;

public class WordDocument implements Document {

    private final DocumentParser parser;

    public WordDocument(DocumentParser parser) {
        this.parser = parser;
    }

    @Override
    public void open() {
        parser.parse();
    }

    @Override
    public void save() {
        System.out.println("Saving Word document");
    }
}