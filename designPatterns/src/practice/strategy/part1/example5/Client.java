package practice.strategy.part1.example5;

import practice.strategy.part1.example5.service.NavigationService;
import practice.strategy.part1.example5.strategy.CheapestRouteStrategy;
import practice.strategy.part1.example5.strategy.FastestRouteStrategy;
import practice.strategy.part1.example5.strategy.ShortestRouteStrategy;

public class Client {

    public static void main(String[] args) {

        NavigationService fastestRoute = new NavigationService(new FastestRouteStrategy());
        fastestRoute.navigate("Bangalore", "Mumbai");


        NavigationService shortestRoute = new NavigationService(new ShortestRouteStrategy());
        shortestRoute.navigate("Bangalore", "Mumbai");


        NavigationService cheapestRoute = new NavigationService(new CheapestRouteStrategy());
        cheapestRoute.navigate("Bangalore", "Mumbai");
    }
}