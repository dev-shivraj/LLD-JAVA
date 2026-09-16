package practice.flyweight.part3.example1.factory;

import java.util.Objects;

public class CharacterStyleKey {

    private final String font;
    private final int fontSize;
    private final String color;
    private final boolean bold;

    public CharacterStyleKey(
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof CharacterStyleKey other)) {
            return false;
        }

        return fontSize == other.fontSize
                && bold == other.bold
                && Objects.equals(font, other.font)
                && Objects.equals(color, other.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(
                font,
                fontSize,
                color,
                bold
        );
    }
}