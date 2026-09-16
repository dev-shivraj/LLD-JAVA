package practice.flyweight.part5.practice3.service;

import practice.flyweight.part5.practice3.extrinsic.Character;

import java.util.ArrayList;
import java.util.List;

public class Document {

    private final List<practice.flyweight.part5.practice3.extrinsic.Character> characters = new ArrayList<>();

    public void addCharacter(practice.flyweight.part5.practice3.extrinsic.Character character) {
        characters.add(character);
    }

    public void render() {
        for (Character character : characters) {
            character.render();
        }
    }
}