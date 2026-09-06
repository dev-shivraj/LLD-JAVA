package practice.registry.part1.example2.processor;

public class PdfProcessor implements DocumentProcessor {
    @Override
    public void process(String fileName) {
        System.out.println("Processing PDF document: " + fileName);
    }
}