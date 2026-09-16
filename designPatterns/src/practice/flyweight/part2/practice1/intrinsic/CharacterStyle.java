package practice.flyweight.part2.practice1.intrinsic;

public class CharacterStyle {

    private final String font;
    private final int fontSize;
    private final String color;

    public CharacterStyle(String font, int fontSize, String color) {
        this.font = font;
        this.fontSize = fontSize;
        this.color = color;
    }

    public void render(char character, int x, int y) {
        System.out.println(
                "Rendering '" + character +
                "' at (" + x + ", " + y + ")" +
                " | Font: " + font +
                " | Size: " + fontSize +
                " | Color: " + color
        );
    }
}