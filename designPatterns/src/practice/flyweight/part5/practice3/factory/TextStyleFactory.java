package practice.flyweight.part5.practice3.factory;

import practice.flyweight.part5.practice3.intrinsic.TextStyle;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class TextStyleFactory {

    private final Map<TextStyleKey, TextStyle> styles = new ConcurrentHashMap<>();

    public TextStyle getStyle(String fontFamily, int fontSize, boolean bold, boolean italic, String color) {
        TextStyleKey key = new TextStyleKey(fontFamily, fontSize, bold, italic, color);

        return styles.computeIfAbsent(key, ignored -> new TextStyle(fontFamily, fontSize, bold, italic, color));
    }

    public int getStyleCount() {
        return styles.size();
    }
}