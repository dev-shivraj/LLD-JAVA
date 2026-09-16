package practice.flyweight.part3.example1.intrinsic;

public class CharacterStyle {

    private final String font;
    private final int fontSize;
    private final String color;
    private final boolean bold;

    public CharacterStyle(
            String font,
            int fontSize,
            String color,
            boolean bold
    ) {
        this.font = font;
        this.fontSize = fontSize;
        this.color = color;
        this.bold = bold;
    }

    public void render(
            char value,
            int x,
            int y
    ) {
        System.out.println(
                "Rendering '" + value +
                "' at (" + x + ", " + y + ")" +
                " | Font: " + font +
                " | Size: " + fontSize +
                " | Color: " + color +
                " | Bold: " + bold
        );
    }
}