package practice.factory.part2.abstractfactory.factory;

import practice.factory.part2.abstractfactory.component.Button;
import practice.factory.part2.abstractfactory.component.Checkbox;

public interface GUIFactory {
    Button createButton();
    Checkbox createCheckbox();
}
