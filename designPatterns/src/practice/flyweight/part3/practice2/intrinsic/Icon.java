package practice.flyweight.part3.practice2.intrinsic;

public class Icon {

    private final String name;
    private final String imagePath;
    private final int width;

    public Icon(
            String name,
            String imagePath,
            int width
    ) {
        this.name = name;
        this.imagePath = imagePath;
        this.width = width;
    }

    public void render(
            String buttonId,
            int x,
            int y
    ) {
        System.out.println(
                "Button: " + buttonId +
                " | Icon: " + name +
                " | Image: " + imagePath +
                " | Width: " + width +
                " | Position: (" + x + ", " + y + ")"
        );
    }
}