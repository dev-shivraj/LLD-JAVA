package practice.builder.part4.house;

public class HouseClient {

    public static void main(String[] args) {

        HouseBuilder builder = new HouseBuilder();

        HouseDirector director =
                new HouseDirector(builder);

        House house =
                director.constructStandardHouse();

        house.printDetails();
    }
}