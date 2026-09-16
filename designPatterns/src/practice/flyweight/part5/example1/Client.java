package practice.flyweight.part5.example1;

import practice.flyweight.part5.example1.factory.TerrainTypeFactory;
import practice.flyweight.part5.example1.service.GameMap;

public class Client {

    public static void main(String[] args) {

        TerrainTypeFactory factory = new TerrainTypeFactory();

        GameMap gameMap = new GameMap(factory);

        gameMap.addTile(0, 0, "GRASS", "grass.png", 1);
        gameMap.addTile(0, 1, "GRASS", "grass.png", 1);
        gameMap.addTile(0, 2, "WATER", "water.png", 3);
        gameMap.addTile(1, 0, "GRASS", "grass.png", 1);
        gameMap.addTile(1, 1, "MOUNTAIN", "mountain.png", 5);
        gameMap.addTile(1, 2, "WATER", "water.png", 3);

        gameMap.render();

        System.out.println("Unique Flyweight objects: " + factory.getFlyweightCount());
    }
}