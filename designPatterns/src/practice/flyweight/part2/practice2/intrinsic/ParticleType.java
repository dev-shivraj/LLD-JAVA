package practice.flyweight.part2.practice2.intrinsic;

public class ParticleType {

    private final String texture;
    private final String color;

    public ParticleType(String texture, String color) {
        this.texture = texture;
        this.color = color;
    }

    public void render(int x, int y) {
        System.out.println(
                "Rendering particle at (" + x + ", " + y + ")" +
                " | Texture: " + texture +
                " | Color: " + color
        );
    }
}