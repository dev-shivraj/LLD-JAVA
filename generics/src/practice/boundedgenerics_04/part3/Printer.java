package practice.boundedgenerics_04.part3;

public class Printer<T extends Printable>{

    public void print(T value) {
        value.print();
    }
}
