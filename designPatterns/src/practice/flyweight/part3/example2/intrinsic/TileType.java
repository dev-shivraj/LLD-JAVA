package practice.flyweight.part3.example2.intrinsic;

public class TileType {

    private final String name;
    private final String texture;
    private final int movementCost;

    public TileType(String name, String texture, int movementCost) {
        this.name = name;
        this.texture = texture;
        this.movementCost = movementCost;
    }

    public void render(int row, int col) {
        System.out.println(
                "Rendering " + name +
                " tile at (" + row + ", " + col + ")" +
                " | Texture: " + texture +
                " | Movement Cost: " + movementCost
        );
    }
}