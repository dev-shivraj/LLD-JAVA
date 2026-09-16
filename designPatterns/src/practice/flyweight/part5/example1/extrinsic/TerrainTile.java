package practice.flyweight.part5.example1.extrinsic;

import practice.flyweight.part5.example1.intrinsic.TerrainType;

public class TerrainTile {

    private final int row;
    private final int col;
    private final TerrainType terrainType;

    public TerrainTile(int row, int col, TerrainType terrainType) {
        this.row = row;
        this.col = col;
        this.terrainType = terrainType;
    }

    public void render() {
        terrainType.render(row, col);
    }
}