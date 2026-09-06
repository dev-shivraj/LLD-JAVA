package practice.registry.part1.practice2.processor;

public class WordProcessor implements DocumentProcessor {
    @Override
    public void process(String fileName) {
        System.out.println("Processing Word document: " + fileName);
    }
}