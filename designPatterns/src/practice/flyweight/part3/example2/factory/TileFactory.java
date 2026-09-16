package practice.flyweight.part3.example2.factory;

import practice.flyweight.part3.example2.intrinsic.TileType;

import java.util.HashMap;
import java.util.Map;

public class TileFactory {

    private final Map<String, TileType> tileTypes = new HashMap<>();

    public TileType getTileType(String name, String texture, int movementCost) {
        String key = name + "_" + texture + "_" + movementCost;

        return tileTypes.computeIfAbsent(key, ignored -> new TileType(name, texture, movementCost));
    }
}