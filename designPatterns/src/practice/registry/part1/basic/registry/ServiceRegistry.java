package practice.registry.part1.basic.registry;

import practice.registry.part1.basic.service.Service;

import java.util.HashMap;
import java.util.Map;

public class ServiceRegistry {
    private final Map<String, Service> services = new HashMap<>();

    public void register(String key, Service service) {
        services.put(key, service);
    }

    public Service get(String key) {
        return services.get(key);
    }
}