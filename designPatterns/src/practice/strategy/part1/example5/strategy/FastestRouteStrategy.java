package practice.strategy.part1.example5.strategy;

public class FastestRouteStrategy implements RouteStrategy {

    @Override
    public void calculateRoute(String source, String destination) {
        System.out.println("Calculating fastest route from " + source + " to " + destination);
    }
}