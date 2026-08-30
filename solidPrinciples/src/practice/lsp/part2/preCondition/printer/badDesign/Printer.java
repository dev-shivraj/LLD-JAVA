package practice.lsp.part2.preCondition.printer.badDesign;

public class Printer {
    public void print(String document) {
        if (document == null || document.isEmpty()) {
            throw new IllegalArgumentException("Document cannot be empty");
        }

        System.out.println("Printing document");
    }
}