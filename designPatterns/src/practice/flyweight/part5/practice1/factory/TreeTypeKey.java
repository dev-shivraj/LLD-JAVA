package practice.flyweight.part5.practice1.factory;

import java.util.Objects;

public class TreeTypeKey {

    private final String name;
    private final String image;
    private final String color;
    private final int height;

    public TreeTypeKey(
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TreeTypeKey other)) {
            return false;
        }

        return height == other.height
                && Objects.equals(name, other.name)
                && Objects.equals(image, other.image)
                && Objects.equals(color, other.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, image, color, height);
    }
}