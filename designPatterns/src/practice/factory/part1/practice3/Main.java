package practice.factory.part1.practice3;

import practice.factory.part1.practice3.service.DocumentService;

public class Main {

    public static void main(String[] args) {
        DocumentService service = new DocumentService();
        service.process("pdf");
        service.process("word");
        service.process("excel");
    }
}