package practice.ocp.part4.printer.badDesign;

public class Printer {

    public void print(String documentType) {

        if (documentType.equals("PDF")) {
            System.out.println("Printing PDF");
        } else if (documentType.equals("WORD")) {
            System.out.println("Printing Word");
        } else if (documentType.equals("IMAGE")) {
            System.out.println("Printing Image");
        }
    }
}