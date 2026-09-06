package practice.singleton.part2.examples.lazycache;

import java.util.HashMap;
import java.util.Map;

public class LazyCache {
    private static LazyCache instance;

    private final Map<String, String> cache;

    private LazyCache() {
        cache = new HashMap<>();
    }

    public static LazyCache getInstance() {
        if (instance == null) {
            instance = new LazyCache();
        }

        return instance;
    }

    public void put(String key, String value) {
        cache.put(key, value);
    }

    public String get(String key) {
        return cache.get(key);
    }
}