package practice.prototype.part3.game;

import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistry {
    private final Map<String, Prototype<?>> prototypes = new HashMap<>();

    public void register(String key, Prototype<?> prototype) {
        prototypes.put(key, prototype);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {
        Prototype<?> prototype = prototypes.get(key);

        if (prototype == null) {
            throw new IllegalArgumentException("Prototype not found: " + key);
        }

        return (T) prototype.copy();
    }

    public void remove(String key) {
        prototypes.remove(key);
    }

    public boolean contains(String key) {
        return prototypes.containsKey(key);
    }
}