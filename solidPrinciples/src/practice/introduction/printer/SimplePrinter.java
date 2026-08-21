package practice.introduction.printer;

class SimplePrinter implements Printer {
    public void print() {}
    public void scan() {
        throw new UnsupportedOperationException();
    }
    public void fax() {
        throw new UnsupportedOperationException();
    }
}