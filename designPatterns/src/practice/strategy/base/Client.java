package practice.strategy.base;

import practice.strategy.base.service.GoogleMap;

import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String mode = sc.next(); // car, walk
        GoogleMap googleMap = new GoogleMap(mode);

        GoogleMap map2 = new GoogleMap(mode);
        System.out.println(googleMap.calculatePath("new Delhi","Mumbai"));
        System.out.println(map2.calculatePath("ABC","XYZ"));

        System.out.println("DEBUG");
    }
}