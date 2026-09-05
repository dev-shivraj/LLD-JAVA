package practice.factory.part2.simplefactory.factory;

import practice.factory.part2.simplefactory.component.HtmlDocument;
import practice.factory.part2.simplefactory.component.PdfDocument;
import practice.factory.part2.simplefactory.component.WordDocument;
import practice.factory.part2.simplefactory.component.Document;

public class DocumentFactory {
    public static Document createDocument(String type) {
        if(type.equals("PDF")) {
            return new PdfDocument();
        } else if(type.equals("WORD")) {
            return new WordDocument();
        } else if(type.equals("HTML")){
            return new HtmlDocument();
        } else {
            throw new IllegalArgumentException("Unsupported document type: " + type);
        }
    }
}
