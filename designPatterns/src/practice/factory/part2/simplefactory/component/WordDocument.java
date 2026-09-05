package practice.factory.part2.simplefactory.component;

public class WordDocument implements Document{
    @Override
    public void export() {
        System.out.println("Exporting document as Word");
    }
}
