package practice.srp.part2.printer;
// this doesn't violate SRP as all the methods are cohesive
public class Printer {

    public void print() {
        System.out.println("Printing");
    }

    public void scan() {
        System.out.println("Scanning");
    }

    public void fax() {
        System.out.println("Faxing");
    }
}