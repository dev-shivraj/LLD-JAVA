package practice.registry.part1.example2.processor;

public class ExcelProcessor implements DocumentProcessor {
    @Override
    public void process(String fileName) {
        System.out.println("Processing Excel document: " + fileName);
    }
}