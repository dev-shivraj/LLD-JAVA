package practice.flyweight.part5.practice3.factory;

import java.util.Objects;

public class TextStyleKey {

    private final String fontFamily;
    private final int fontSize;
    private final boolean bold;
    private final boolean italic;
    private final String color;

    public TextStyleKey(
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TextStyleKey other)) {
            return false;
        }

        return fontSize == other.fontSize
                && bold == other.bold
                && italic == other.italic
                && Objects.equals(fontFamily, other.fontFamily)
                && Objects.equals(color, other.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                fontFamily,
                fontSize,
                bold,
                italic,
                color
        );
    }
}