package practice.strategy.part1.example5.strategy;

public class CheapestRouteStrategy implements RouteStrategy {

    @Override
    public void calculateRoute(String source, String destination) {
        System.out.println("Calculating cheapest route from " + source + " to " + destination);
    }
}