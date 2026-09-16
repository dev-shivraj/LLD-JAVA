package practice.flyweight.part5.practice3;

import practice.flyweight.part5.practice3.extrinsic.Character;
import practice.flyweight.part5.practice3.factory.TextStyleFactory;
import practice.flyweight.part5.practice3.intrinsic.TextStyle;
import practice.flyweight.part5.practice3.service.Document;

public class Client {

    public static void main(String[] args) {

        TextStyleFactory factory = new TextStyleFactory();

        TextStyle style = factory.getStyle("Arial", 14, true, false, "BLACK");
        TextStyle sameStyle = factory.getStyle("Arial", 14, true, false, "BLACK");

        Document document = new Document();

        document.addCharacter(new practice.flyweight.part5.practice3.extrinsic.Character('H', 0, style));
        document.addCharacter(new practice.flyweight.part5.practice3.extrinsic.Character('e', 1, sameStyle));
        document.addCharacter(new practice.flyweight.part5.practice3.extrinsic.Character('l', 2, style));
        document.addCharacter(new practice.flyweight.part5.practice3.extrinsic.Character('l', 3, sameStyle));
        document.addCharacter(new Character('o', 4, style));

        document.render();

        System.out.println("Same style object: " + (style == sameStyle));
        System.out.println("Unique styles: " + factory.getStyleCount());
    }
}