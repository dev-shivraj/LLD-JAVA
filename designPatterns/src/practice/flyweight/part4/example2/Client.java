package practice.flyweight.part4.example2;

import practice.flyweight.part4.example2.extrinsic.TextBlock;
import practice.flyweight.part4.example2.factory.TextStyleFactory;
import practice.flyweight.part4.example2.intrinsic.TextStyle;

public class Client {

    public static void main(String[] args) {

        TextStyleFactory factory = new TextStyleFactory();

        TextStyle body = factory.getStyle("Arial", 14, "Black", false, false);
        TextStyle bodyAgain = factory.getStyle("Arial", 14, "Black", false, false);
        TextStyle heading = factory.getStyle("Arial", 24, "Blue", true, false);

        TextBlock block1 = new TextBlock("Hello", 10, 20, body);
        TextBlock block2 = new TextBlock("World", 10, 40, bodyAgain);
        TextBlock block3 = new TextBlock("Flyweight", 10, 80, heading);

        block1.render();
        block2.render();
        block3.render();

        System.out.println();
        System.out.println("body == bodyAgain: " + (body == bodyAgain));
        System.out.println("body == heading: " + (body == heading));
    }
}