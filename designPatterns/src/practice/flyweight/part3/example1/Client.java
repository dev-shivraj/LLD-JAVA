package practice.flyweight.part3.example1;

import practice.flyweight.part3.example1.extrinsic.TextCharacter;
import practice.flyweight.part3.example1.factory.CharacterStyleFactory;
import practice.flyweight.part3.example1.intrinsic.CharacterStyle;

public class Client {

    public static void main(String[] args) {

        CharacterStyleFactory factory = new CharacterStyleFactory();

        CharacterStyle normal = factory.getStyle("Arial", 14, "Black", false);
        CharacterStyle sameNormal = factory.getStyle("Arial", 14, "Black", false);
        CharacterStyle heading = factory.getStyle("Arial", 24, "Blue", true);

        TextCharacter character1 = new TextCharacter('H', 10, 20, normal);
        TextCharacter character2 = new TextCharacter('e', 20, 20, sameNormal);
        TextCharacter character3 = new TextCharacter('H', 10, 50, heading);

        character1.render();
        character2.render();
        character3.render();

        System.out.println();
        System.out.println("normal == sameNormal: " + (normal == sameNormal));
        System.out.println("normal == heading: " + (normal == heading));
    }
}