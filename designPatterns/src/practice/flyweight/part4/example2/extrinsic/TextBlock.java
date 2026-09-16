package practice.flyweight.part4.example2.extrinsic;

import practice.flyweight.part4.example2.intrinsic.TextStyle;

public class TextBlock {

    private final String text;
    private final int x;
    private final int y;
    private final TextStyle style;

    public TextBlock(
            String text,
            int x,
            int y,
            TextStyle style
    ) {
        this.text = text;
        this.x = x;
        this.y = y;
        this.style = style;
    }

    public void render() {
        style.render(text, x, y);
    }

    public TextStyle getStyle() {
        return style;
    }
}