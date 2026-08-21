package practice.srp.part1.printer.badDesign;

class Printer {

    // printer responsibility
    void printDocument() {
        System.out.println("Document printed");
    }

    // printer responsibility
    void calculateInkUsage() {
        System.out.println("Ink uses calculated");
    }

    // persistence responsibility
    void savePrintHistory() {
        System.out.println("Print history saved");
    }

    // communication responsibility
    void sendLowInkNotification() {
        System.out.println("Low ink notification sent");
    }
}