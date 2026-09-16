package practice.flyweight.part2.practice1.extrinsic;

import practice.flyweight.part2.practice1.intrinsic.CharacterStyle;

public class Character {

    private final char value;
    private final int x;
    private final int y;
    private final CharacterStyle style;

    public Character(char value, int x, int y, CharacterStyle style) {
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