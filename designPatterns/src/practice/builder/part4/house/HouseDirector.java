package practice.builder.part4.house;

public class HouseDirector {

    private final HouseBuilder builder;

    public HouseDirector(HouseBuilder builder) {
        this.builder = builder;
    }

    public House constructStandardHouse() {

        return builder
                .buildFoundation()
                .buildWalls()
                .buildDoors()
                .buildWindows()
                .buildRoof()
                .build();
    }
}