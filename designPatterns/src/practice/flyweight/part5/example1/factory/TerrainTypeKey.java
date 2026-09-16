package practice.flyweight.part5.example1.factory;

import java.util.Objects;

public class TerrainTypeKey {

    private final String name;
    private final String texture;
    private final int movementCost;

    public TerrainTypeKey(String name, String texture, int movementCost) {
        this.name = name;
        this.texture = texture;
        this.movementCost = movementCost;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (!(obj instanceof TerrainTypeKey other)) {
            return false;
        }

        return movementCost == other.movementCost
                && Objects.equals(name, other.name)
                && Objects.equals(texture, other.texture);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, texture, movementCost);
    }
}