package practice.factory.part2.abstractfactory;

import practice.factory.part2.abstractfactory.factory.GUIFactory;
import practice.factory.part2.abstractfactory.factory.MacFactory;
import practice.factory.part2.abstractfactory.factory.WindowsFactory;

public class Client {
    public static void main(String[] args) {
        // =============================================================================

//        GUIFactory factory = new WindowsFactory();
//        Application application = new Application(factory);
//        application.render();

        // =============================================================================

        GUIFactory factory = new MacFactory();
        Application application = new Application(factory);
        application.render();

        // =============================================================================
    }
}
