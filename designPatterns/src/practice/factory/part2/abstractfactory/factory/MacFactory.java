package practice.factory.part2.abstractfactory.factory;

import practice.factory.part2.abstractfactory.component.Button;
import practice.factory.part2.abstractfactory.component.Checkbox;
import practice.factory.part2.abstractfactory.component.MacButton;
import practice.factory.part2.abstractfactory.component.MacCheckbox;

public class MacFactory implements GUIFactory{
    @Override
    public Button createButton() {
        return new MacButton();
    }

    @Override
    public Checkbox createCheckbox() {
        return new MacCheckbox();
    }
}
