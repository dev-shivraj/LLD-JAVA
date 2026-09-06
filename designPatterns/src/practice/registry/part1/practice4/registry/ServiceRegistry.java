package practice.registry.part1.practice4.registry;

import practice.registry.part1.practice4.service.Service;

import java.util.HashMap;
import java.util.Map;

public class ServiceRegistry {

    private final Map<String, Service> services = new HashMap<>();

    public void register(String type, Service service) {

        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException(
                "Service type cannot be null or blank"
            );
        }

        if (service == null) {
            throw new IllegalArgumentException(
                "Service cannot be null"
            );
        }

        if (services.containsKey(type)) {
            throw new IllegalArgumentException(
                "Service already registered for type: " + type
            );
        }

        services.put(type, service);
    }

    public Service get(String type) {

        if (type == null || type.isBlank()) {
            throw new IllegalArgumentException(
                "Service type cannot be null or blank"
            );
        }

        Service service = services.get(type);

        if (service == null) {
            throw new IllegalArgumentException(
                "No service registered for type: " + type
            );
        }

        return service;
    }
}