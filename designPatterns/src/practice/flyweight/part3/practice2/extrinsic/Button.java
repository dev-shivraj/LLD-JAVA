package practice.flyweight.part3.practice2.extrinsic;

import practice.flyweight.part3.practice2.intrinsic.Icon;

public class Button {

    private final String buttonId;
    private final int x;
    private final int y;
    private final Icon icon;

    public Button(
            String buttonId,
            int x,
            int y,
            Icon icon
    ) {
        this.buttonId = buttonId;
        this.x = x;
        this.y = y;
        this.icon = icon;
    }

    public void render() {
        icon.render(buttonId, x, y);
    }

    public Icon getIcon() {
        return icon;
    }
}