package practice.flyweight.part3.practice3.factory;

import practice.flyweight.part3.practice3.intrinsic.SoldierType;

import java.util.HashMap;
import java.util.Map;

public class SoldierTypeFactory {

    private final Map<String, SoldierType> soldierTypes =
            new HashMap<>();

    public SoldierType getSoldierType(
            String weapon,
            String uniform,
            String texture,
            int movementSpeed
    ) {
        String key =
                weapon + "_" +
                uniform + "_" +
                texture + "_" +
                movementSpeed;

        return soldierTypes.computeIfAbsent(
                key,
                ignored -> new SoldierType(
                        weapon,
                        uniform,
                        texture,
                        movementSpeed
                )
        );
    }
}