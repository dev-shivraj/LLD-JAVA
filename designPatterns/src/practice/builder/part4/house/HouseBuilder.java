package practice.builder.part4.house;

public class HouseBuilder {

    private String foundation;
    private String walls;
    private String doors;
    private String windows;
    private String roof;

    public HouseBuilder buildFoundation() {
        foundation = "Concrete Foundation";
        return this;
    }

    public HouseBuilder buildWalls() {
        walls = "Brick Walls";
        return this;
    }

    public HouseBuilder buildDoors() {
        doors = "Wooden Doors";
        return this;
    }

    public HouseBuilder buildWindows() {
        windows = "Glass Windows";
        return this;
    }

    public HouseBuilder buildRoof() {
        roof = "Concrete Roof";
        return this;
    }

    public House build() {
        return new House(
                foundation,
                walls,
                doors,
                windows,
                roof
        );
    }
}