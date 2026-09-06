package practice.registry.part1.practice4.service;

import practice.registry.part1.practice4.registry.ServiceRegistry;

public class ApplicationService {
    private final ServiceRegistry registry;

    public ApplicationService(ServiceRegistry registry) {
        this.registry = registry;
    }

    public void execute(String serviceType) {
        Service service = registry.get(serviceType);
        service.execute();
    }
}