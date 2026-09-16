package practice.flyweight.part3.practice2.factory;

import practice.flyweight.part3.practice2.intrinsic.Icon;

import java.util.HashMap;
import java.util.Map;

public class IconFactory {

    private final Map<String, Icon> icons = new HashMap<>();

    public Icon getIcon(String name, String imagePath, int width) {
        String key = name + "_" + imagePath + "_" + width;

        return icons.computeIfAbsent(key, ignored -> new Icon(name, imagePath, width));
    }
}