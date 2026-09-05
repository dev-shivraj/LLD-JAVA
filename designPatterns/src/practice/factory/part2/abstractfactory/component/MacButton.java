package practice.factory.part2.abstractfactory.component;

public class MacButton implements Button{
    @Override
    public void render() {
        System.out.println("Rendering Mac checkbox");
    }
}
