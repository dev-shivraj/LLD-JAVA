package practice.srp.part1.invoice.badDesign;

public class Invoice {
    public void calculateTotal() {
        System.out.println("Calculating invoice total");
    }

    public void applyDiscount() {
        System.out.println("Applying discount");
    }

    public void saveToDatabase() {
        System.out.println("Saving invoice");
    }

    public void printInvoice() {
        System.out.println("Printing invoice");
    }

    public void emailInvoice() {
        System.out.println("Emailing invoice");
    }
}
