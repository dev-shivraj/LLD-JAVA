package practice.flyweight.part5.practice3.extrinsic;

import practice.flyweight.part5.practice3.intrinsic.TextStyle;

public class Character {

    private final char value;
    private final int position;
    private final TextStyle style;

    public Character(
            char value,
            int position,
            TextStyle style
    ) {
        this.value = value;
        this.position = position;
        this.style = style;
    }

    public void render() {
        style.render(value, position);
    }
}