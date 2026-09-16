package practice.flyweight.part2.example1.factory;

import practice.flyweight.part2.example1.intrinsic.TreeType;

import java.util.HashMap;
import java.util.Map;

public class TreeFactory {

    private final Map<String, TreeType> treeTypes = new HashMap<>();

    public TreeType getTreeType(String name, String color, String texture) {
        String key = name + "_" + color + "_" + texture;

        TreeType treeType = treeTypes.get(key);

        if (treeType == null) {
            treeType = new TreeType(name, color, texture);
            treeTypes.put(key, treeType);
        }

        return treeType;
    }
}