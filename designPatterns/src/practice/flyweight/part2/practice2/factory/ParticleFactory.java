package practice.flyweight.part2.practice2.factory;

import practice.flyweight.part2.practice2.intrinsic.ParticleType;

import java.util.HashMap;
import java.util.Map;

public class ParticleFactory {

    private final Map<String, ParticleType> particleTypes = new HashMap<>();

    public ParticleType getParticleType(String texture, String color) {
        String key = texture + "_" + color;

        return particleTypes.computeIfAbsent(key, k -> new ParticleType(texture, color));
    }
}