package practice.prototype.part3.document;

public class Client {

    public static void main(String[] args) {
        DocumentRegistry registry = new DocumentRegistry();

        Invoice invoicePrototype = new Invoice("Invoice Template", "Invoice Content", "Company");
        Resume resumePrototype = new Resume("Resume Template", "Resume Content", "Shivraj");

        registry.register("invoice", invoicePrototype);
        registry.register("resume", resumePrototype);

        Invoice invoice1 = (Invoice) registry.get("invoice");
        Invoice invoice2 = (Invoice) registry.get("invoice");

        Resume resume1 = (Resume) registry.get("resume");

        invoice1.setTitle("Invoice #1001");
        invoice2.setTitle("Invoice #1002");
        resume1.setTitle("Shivraj Resume");

        System.out.println("Invoice Prototype: " + invoicePrototype);
        System.out.println("Invoice 1: " + invoice1);
        System.out.println("Invoice 2: " + invoice2);
        System.out.println("Resume Prototype: " + resumePrototype);
        System.out.println("Resume 1: " + resume1);
    }
}