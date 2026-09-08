package practice.factory.part1.simplefactory.document.component;

public class HtmlDocument implements Document {
    @Override
    public void export() {
        System.out.println("Exporting document as HTML");
    }
}
