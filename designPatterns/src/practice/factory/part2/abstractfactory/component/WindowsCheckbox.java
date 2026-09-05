package practice.factory.part2.abstractfactory.component;

public class WindowsCheckbox implements Checkbox{
    @Override
    public void render() {
        System.out.println("Rendering Windows checkbox");
    }
}
