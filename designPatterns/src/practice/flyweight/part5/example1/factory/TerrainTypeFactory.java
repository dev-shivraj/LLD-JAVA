package practice.flyweight.part5.example1.factory;

import practice.flyweight.part5.example1.intrinsic.TerrainType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TerrainTypeFactory {

    private final Map<TerrainTypeKey, TerrainType> terrainTypes = new ConcurrentHashMap<>();

    public TerrainType getTerrainType(String name, String texture, int movementCost) {
        TerrainTypeKey key = new TerrainTypeKey(name, texture, movementCost);

        return terrainTypes.computeIfAbsent(key, ignored -> new TerrainType(name, texture, movementCost));
    }

    public int getFlyweightCount() {
        return terrainTypes.size();
    }
}