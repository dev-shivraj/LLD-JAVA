package practice.flyweight.part4.example2.factory;

import practice.flyweight.part4.example2.intrinsic.TextStyle;

import java.util.HashMap;
import java.util.Map;

public class TextStyleFactory {

    private final Map<String, TextStyle> styles = new HashMap<>();

    public TextStyle getStyle(String font, int fontSize, String color, boolean bold, boolean italic) {
        String key = font + "_" + fontSize + "_" + color + "_" + bold + "_" + italic;

        return styles.computeIfAbsent(key, ignored -> new TextStyle(font, fontSize, color, bold, italic));
    }
}