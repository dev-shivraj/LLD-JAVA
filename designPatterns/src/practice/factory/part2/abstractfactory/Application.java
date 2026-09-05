package practice.factory.part2.abstractfactory;

import practice.factory.part2.abstractfactory.component.Button;
import practice.factory.part2.abstractfactory.component.Checkbox;
import practice.factory.part2.abstractfactory.factory.GUIFactory;

public class Application {
    private final Button button;
    private final Checkbox checkbox;

    public Application(GUIFactory factory) {
        this.button = factory.createButton();
        this.checkbox = factory.createCheckbox();
    }

    public void render() {
        button.render();
        checkbox.render();
    }
}
