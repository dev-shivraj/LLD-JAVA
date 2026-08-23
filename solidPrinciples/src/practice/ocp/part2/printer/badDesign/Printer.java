package practice.ocp.part2.printer.badDesign;

public class Printer {

    public void print(String format) {
        if (format.equals("PDF")) {
            System.out.println("Printing PDF");
        } else if (format.equals("WORD")) {
            System.out.println("Printing Word");
        } else if (format.equals("IMAGE")) {
            System.out.println("Printing Image");
        }
    }
}