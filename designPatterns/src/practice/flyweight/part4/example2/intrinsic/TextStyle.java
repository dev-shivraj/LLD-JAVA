package practice.flyweight.part4.example2.intrinsic;

public class TextStyle {

    private final String font;
    private final int fontSize;
    private final String color;
    private final boolean bold;
    private final boolean italic;

    public TextStyle(
            String font,
            int fontSize,
            String color,
            boolean bold,
            boolean italic
    ) {
        this.font = font;
        this.fontSize = fontSize;
        this.color = color;
        this.bold = bold;
        this.italic = italic;
    }

    public void render(
            String text,
            int x,
            int y
    ) {
        System.out.println(
                "Rendering \"" + text + "\"" +
                " at (" + x + ", " + y + ")" +
                " | Font: " + font +
                " | Size: " + fontSize +
                " | Color: " + color +
                " | Bold: " + bold +
                " | Italic: " + italic
        );
    }
}