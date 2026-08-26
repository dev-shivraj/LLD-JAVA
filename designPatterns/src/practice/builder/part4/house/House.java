package practice.builder.part4.house;

public class House {

    private final String foundation;
    private final String walls;
    private final String doors;
    private final String windows;
    private final String roof;

    public House(
            String foundation,
            String walls,
            String doors,
            String windows,
            String roof
    ) {
        this.foundation = foundation;
        this.walls = walls;
        this.doors = doors;
        this.windows = windows;
        this.roof = roof;
    }

    public void printDetails() {
        System.out.println("Foundation: " + foundation);
        System.out.println("Walls: " + walls);
        System.out.println("Doors: " + doors);
        System.out.println("Windows: " + windows);
        System.out.println("Roof: " + roof);
    }
}