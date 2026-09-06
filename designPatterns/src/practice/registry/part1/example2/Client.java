package practice.registry.part1.example2;

import practice.registry.part1.example2.processor.DocumentProcessor;
import practice.registry.part1.example2.processor.ExcelProcessor;
import practice.registry.part1.example2.processor.PdfProcessor;
import practice.registry.part1.example2.processor.WordProcessor;
import practice.registry.part1.example2.registry.DocumentRegistry;

public class Client {
    public static void main(String[] args) {
        DocumentRegistry registry = new DocumentRegistry();

        registry.register("pdf", new PdfProcessor());
        registry.register("word", new WordProcessor());
        registry.register("excel", new ExcelProcessor());

        DocumentProcessor pdfProcessor = registry.get("pdf");
        pdfProcessor.process("resume.pdf");

        DocumentProcessor wordProcessor = registry.get("word");
        wordProcessor.process("resume.docx");

        DocumentProcessor excelProcessor = registry.get("excel");
        excelProcessor.process("report.xlsx");
    }
}