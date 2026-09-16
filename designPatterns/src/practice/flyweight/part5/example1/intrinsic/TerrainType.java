package practice.flyweight.part5.example1.intrinsic;

public class TerrainType {

    private final String name;
    private final String texture;
    private final int movementCost;

    public TerrainType(String name, String texture, int movementCost) {
        this.name = name;
        this.texture = texture;
        this.movementCost = movementCost;
    }

    public void render(int row, int col) {
        System.out.println(
                "Rendering " + name
                        + " at (" + row + ", " + col + ")"
                        + " using " + texture
                        + ", movementCost=" + movementCost
        );
    }
}