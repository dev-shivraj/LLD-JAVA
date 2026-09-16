package practice.flyweight.part1.practice2;

import practice.flyweight.part1.practice2.extrinsic.RestaurantMarker;
import practice.flyweight.part1.practice2.intrinsic.MarkerType;

public class Client {

    public static void main(String[] args) {

        MarkerType restaurantMarker = new MarkerType("Restaurant", "restaurant.png");

        RestaurantMarker restaurant1 = new RestaurantMarker("Restaurant A", 12.9716, 77.5946, restaurantMarker);
        RestaurantMarker restaurant2 = new RestaurantMarker("Restaurant B", 12.9352, 77.6245, restaurantMarker);
        RestaurantMarker restaurant3 = new RestaurantMarker("Restaurant C", 13.0358, 77.5970, restaurantMarker);

        restaurant1.display();
        restaurant2.display();
        restaurant3.display();

        System.out.println();
        System.out.println("restaurant1 and restaurant2 share MarkerType: " + (restaurant1.getMarkerType() == restaurant2.getMarkerType()));
        System.out.println("restaurant2 and restaurant3 share MarkerType: " + (restaurant2.getMarkerType() == restaurant3.getMarkerType()));
    }
}