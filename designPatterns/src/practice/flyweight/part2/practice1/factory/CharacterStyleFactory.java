package practice.flyweight.part2.practice1.factory;

import practice.flyweight.part2.practice1.intrinsic.CharacterStyle;

import java.util.HashMap;
import java.util.Map;

public class CharacterStyleFactory {

    private final Map<String, CharacterStyle> styles = new HashMap<>();

    public CharacterStyle getStyle(String font, int fontSize, String color) {
        String key = font + "_" + fontSize + "_" + color;

        return styles.computeIfAbsent(key, k -> new CharacterStyle(font, fontSize, color));
    }
}