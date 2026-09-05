package practice.factory.part2.abstractfactory.factory;

import practice.factory.part2.abstractfactory.component.Button;
import practice.factory.part2.abstractfactory.component.Checkbox;
import practice.factory.part2.abstractfactory.component.WindowsButton;
import practice.factory.part2.abstractfactory.component.WindowsCheckbox;

public class WindowsFactory implements GUIFactory{
    @Override
    public Checkbox createCheckbox() {
        return new WindowsCheckbox();
    }

    @Override
    public Button createButton() {
        return new WindowsButton();
    }
}
