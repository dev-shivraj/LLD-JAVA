package practice.registry.part1.practice4;

import practice.registry.part1.practice4.registry.ServiceRegistry;
import practice.registry.part1.practice4.service.ApplicationService;
import practice.registry.part1.practice4.service.OrderService;
import practice.registry.part1.practice4.service.PaymentService;
import practice.registry.part1.practice4.service.UserService;

public class Main {

    public static void main(String[] args) {

        ServiceRegistry registry = new ServiceRegistry();
        registry.register("user", new UserService());
        registry.register("order", new OrderService());
        registry.register("payment", new PaymentService());

        ApplicationService applicationService = new ApplicationService(registry);
        applicationService.execute("user");
        applicationService.execute("order");
        applicationService.execute("payment");
    }
}