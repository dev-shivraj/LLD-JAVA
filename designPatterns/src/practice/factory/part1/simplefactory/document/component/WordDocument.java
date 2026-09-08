package practice.factory.part1.simplefactory.document.component;

public class WordDocument implements Document{
    @Override
    public void export() {
        System.out.println("Exporting document as Word");
    }
}
