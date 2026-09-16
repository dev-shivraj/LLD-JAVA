package practice.flyweight.part2.practice1;

import practice.flyweight.part2.practice1.extrinsic.Character;
import practice.flyweight.part2.practice1.factory.CharacterStyleFactory;
import practice.flyweight.part2.practice1.intrinsic.CharacterStyle;

public class Client {

    public static void main(String[] args) {

        CharacterStyleFactory factory = new CharacterStyleFactory();

        CharacterStyle normalStyle = factory.getStyle("Arial", 14, "Black");
        CharacterStyle sameStyle = factory.getStyle("Arial", 14, "Black");
        CharacterStyle headingStyle = factory.getStyle("Arial", 24, "Blue");

        practice.flyweight.part2.practice1.extrinsic.Character character1 = new practice.flyweight.part2.practice1.extrinsic.Character('H', 100, 200, normalStyle);
        practice.flyweight.part2.practice1.extrinsic.Character character2 = new practice.flyweight.part2.practice1.extrinsic.Character('e', 110, 200, sameStyle);
        practice.flyweight.part2.practice1.extrinsic.Character character3 = new Character('H', 100, 300, headingStyle);

        character1.render();
        character2.render();
        character3.render();

        System.out.println();
        System.out.println("normalStyle == sameStyle: " + (normalStyle == sameStyle));
        System.out.println("normalStyle == headingStyle: " + (normalStyle == headingStyle));
        System.out.println("character1 and character2 share style: " + (character1.getStyle() == character2.getStyle()));
    }
}