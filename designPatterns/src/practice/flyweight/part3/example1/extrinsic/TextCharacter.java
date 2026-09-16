package practice.flyweight.part3.example1.extrinsic;

import practice.flyweight.part3.example1.intrinsic.CharacterStyle;

public class TextCharacter {

    private final char value;
    private final int x;
    private final int y;
    private final CharacterStyle style;

    public TextCharacter(
            char value,
            int x,
            int y,
            CharacterStyle style
    ) {
        this.value = value;
        this.x = x;
        this.y = y;
        this.style = style;
    }

    public void render() {
        style.render(value, x, y);
    }

    public CharacterStyle getStyle() {
        return style;
    }
}