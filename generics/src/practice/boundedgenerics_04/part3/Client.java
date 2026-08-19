package practice.boundedgenerics_04.part3;

import practice.boundedgenerics_04.part2.NumberUtility;

public class Client {
    public static void main(String[] args) {
        // =====================================

        Printer<Reports> printer = new Printer<>();
        printer.print(new Reports());

        // below will give compile time error as String doesn't extends Printable
        // Printer<String> printer1 = new Printer<>();


        // =====================================
    }
}
