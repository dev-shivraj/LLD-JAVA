package practice.flyweight.part3.practice2;

import practice.flyweight.part3.practice2.extrinsic.Button;
import practice.flyweight.part3.practice2.factory.IconFactory;
import practice.flyweight.part3.practice2.intrinsic.Icon;

public class Client {

    public static void main(String[] args) {

        IconFactory factory = new IconFactory();

        Icon saveIcon = factory.getIcon("Save", "save.png", 24);
        Icon saveIconAgain = factory.getIcon("Save", "save.png", 24);
        Icon deleteIcon = factory.getIcon("Delete", "delete.png", 24);

        Button button1 = new Button("save-button", 100, 200, saveIcon);
        Button button2 = new Button("save-button-2", 300, 400, saveIconAgain);
        Button button3 = new Button("delete-button", 500, 600, deleteIcon);

        button1.render();
        button2.render();
        button3.render();

        System.out.println();
        System.out.println("saveIcon == saveIconAgain: " + (saveIcon == saveIconAgain));
        System.out.println("saveIcon == deleteIcon: " + (saveIcon == deleteIcon));
        System.out.println("button1 and button2 share icon: " + (button1.getIcon() == button2.getIcon()));
    }
}