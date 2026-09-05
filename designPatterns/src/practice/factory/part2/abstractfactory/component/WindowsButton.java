package practice.factory.part2.abstractfactory.component;

public class WindowsButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering Windows button");
    }
}
