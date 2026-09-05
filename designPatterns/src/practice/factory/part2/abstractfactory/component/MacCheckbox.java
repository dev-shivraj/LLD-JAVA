package practice.factory.part2.abstractfactory.component;

public class MacCheckbox implements Checkbox{
    @Override
    public void render() {
        System.out.println("Rendering Mac checkbox");
    }
}
