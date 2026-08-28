package practice.prototype.part3.document;

import java.util.HashMap;
import java.util.Map;

public class DocumentRegistry {

    private final Map<String, Document> prototypes =
            new HashMap<>();

    public void register(
            String key,
            Document prototype
    ) {
        prototypes.put(key, prototype);
    }

    public Document get(String key) {

        Document prototype =
                prototypes.get(key);

        if (prototype == null) {
            throw new IllegalArgumentException(
                    "Prototype not found: " + key
            );
        }

        return prototype.copy();
    }

    public void remove(String key) {
        prototypes.remove(key);
    }

    public boolean contains(String key) {
        return prototypes.containsKey(key);
    }
}