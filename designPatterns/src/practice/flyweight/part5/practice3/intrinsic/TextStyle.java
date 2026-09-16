package practice.flyweight.part5.practice3.intrinsic;

public class TextStyle {

    private final String fontFamily;
    private final int fontSize;
    private final boolean bold;
    private final boolean italic;
    private final String color;

    public TextStyle(
            String fontFamily,
            int fontSize,
            boolean bold,
            boolean italic,
            String color
    ) {
        this.fontFamily = fontFamily;
        this.fontSize = fontSize;
        this.bold = bold;
        this.italic = italic;
        this.color = color;
    }

    public void render(char character, int position) {
        System.out.println(
                "Rendering '" + character
                        + "' at position " + position
                        + " using "
                        + fontFamily
                        + ", size=" + fontSize
                        + ", bold=" + bold
                        + ", italic=" + italic
                        + ", color=" + color
        );
    }
}