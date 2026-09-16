package practice.flyweight.part5.example1.service;

import practice.flyweight.part5.example1.extrinsic.TerrainTile;
import practice.flyweight.part5.example1.factory.TerrainTypeFactory;
import practice.flyweight.part5.example1.intrinsic.TerrainType;

import java.util.ArrayList;
import java.util.List;

public class GameMap {

    private final TerrainTypeFactory terrainTypeFactory;
    private final List<TerrainTile> tiles = new ArrayList<>();

    public GameMap(TerrainTypeFactory terrainTypeFactory) {
        this.terrainTypeFactory = terrainTypeFactory;
    }

    public void addTile(int row, int col, String name, String texture, int movementCost) {
        TerrainType terrainType = terrainTypeFactory.getTerrainType(name, texture, movementCost);
        tiles.add(new TerrainTile(row, col, terrainType));
    }

    public void render() {
        for (TerrainTile tile : tiles) {
            tile.render();
        }
    }
}