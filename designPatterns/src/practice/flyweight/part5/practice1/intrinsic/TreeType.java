package practice.flyweight.part5.practice1.intrinsic;

public class TreeType {

    private final String name;
    private final String image;
    private final String color;
    private final int height;

    public TreeType(
            String name,
            String image,
            String color,
            int height
    ) {
        this.name = name;
        this.image = image;
        this.color = color;
        this.height = height;
    }

    public void render(int x, int y) {
        System.out.println(
                "Rendering " + name
                        + " at (" + x + ", " + y + ")"
                        + ", image=" + image
                        + ", color=" + color
                        + ", height=" + height
        );
    }
}