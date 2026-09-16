package practice.flyweight.part3.example2;

import practice.flyweight.part3.example2.extrinsic.MapTile;
import practice.flyweight.part3.example2.factory.TileFactory;
import practice.flyweight.part3.example2.intrinsic.TileType;

public class Client {

    public static void main(String[] args) {

        TileFactory factory = new TileFactory();

        TileType grass = factory.getTileType("Grass", "grass.png", 1);
        TileType grassAgain = factory.getTileType("Grass", "grass.png", 1);
        TileType water = factory.getTileType("Water", "water.png", 3);

        MapTile tile1 = new MapTile(0, 0, grass);
        MapTile tile2 = new MapTile(0, 1, grassAgain);
        MapTile tile3 = new MapTile(1, 0, water);

        tile1.render();
        tile2.render();
        tile3.render();

        System.out.println();
        System.out.println("grass == grassAgain: " + (grass == grassAgain));
        System.out.println("grass == water: " + (grass == water));
    }
}