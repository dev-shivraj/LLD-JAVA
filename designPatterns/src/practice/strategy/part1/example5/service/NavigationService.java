package practice.strategy.part1.example5.service;

import practice.strategy.part1.example5.strategy.RouteStrategy;

public class NavigationService {

    private final RouteStrategy routeStrategy;

    public NavigationService(RouteStrategy routeStrategy) {
        this.routeStrategy = routeStrategy;
    }

    public void navigate(String source, String destination) {
        routeStrategy.calculateRoute(source, destination);
    }
}