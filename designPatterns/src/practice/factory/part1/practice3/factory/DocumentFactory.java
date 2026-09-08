package practice.factory.part1.practice3.factory;

import practice.factory.part1.practice3.document.Document;
import practice.factory.part1.practice3.document.ExcelDocument;
import practice.factory.part1.practice3.document.PdfDocument;
import practice.factory.part1.practice3.document.WordDocument;
import practice.factory.part1.practice3.parser.DocumentParser;
import practice.factory.part1.practice3.parser.ExcelParser;
import practice.factory.part1.practice3.parser.PdfParser;
import practice.factory.part1.practice3.parser.WordParser;

public class DocumentFactory {

    public static Document create(String type) {

        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException("Document type cannot be null or blank");
        }

        return switch (type.toLowerCase()) {
            case "pdf" -> {
                DocumentParser parser = new PdfParser();
                yield new PdfDocument(parser);
            }
            case "word" -> {
                DocumentParser parser = new WordParser();
                yield new WordDocument(parser);
            }
            case "excel" -> {
                DocumentParser parser = new ExcelParser();
                yield new ExcelDocument(parser);
            }
            default -> throw new IllegalArgumentException(
                    "Unknown document type: " + type
            );
        };
    }
}