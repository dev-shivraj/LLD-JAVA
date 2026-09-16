package practice.flyweight.part3.example1.factory;

import practice.flyweight.part3.example1.intrinsic.CharacterStyle;

import java.util.HashMap;
import java.util.Map;

public class CharacterStyleFactory {

    private final Map<CharacterStyleKey, CharacterStyle> styles = new HashMap<>();

    public CharacterStyle getStyle(String font, int fontSize, String color, boolean bold) {
        CharacterStyleKey key = new CharacterStyleKey(font, fontSize, color, bold);

        return styles.computeIfAbsent(key, ignored -> new CharacterStyle(font, fontSize, color, bold));
    }
}