package practice.strategy.part1.example5.strategy;

public class ShortestRouteStrategy implements RouteStrategy {

    @Override
    public void calculateRoute(String source, String destination) {
        System.out.println("Calculating shortest route from " + source + " to " + destination);
    }
}