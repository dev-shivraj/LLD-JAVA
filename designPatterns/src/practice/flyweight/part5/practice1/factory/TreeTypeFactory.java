package practice.flyweight.part5.practice1.factory;

import practice.flyweight.part5.practice1.intrinsic.TreeType;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TreeTypeFactory {

    private final Map<TreeTypeKey, TreeType> treeTypes = new ConcurrentHashMap<>();

    public TreeType getTreeType(String name, String image, String color, int height) {
        TreeTypeKey key = new TreeTypeKey(name, image, color, height);

        return treeTypes.computeIfAbsent(key, ignored -> new TreeType(name, image, color, height));
    }

    public int getTreeTypeCount() {
        return treeTypes.size();
    }
}