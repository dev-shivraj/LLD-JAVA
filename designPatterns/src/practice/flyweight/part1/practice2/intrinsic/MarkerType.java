package practice.flyweight.part1.practice2.intrinsic;

public class MarkerType {

    private final String category;
    private final String icon;

    public MarkerType(String category, String icon) {
        this.category = category;
        this.icon = icon;
    }

    public void display(String name, double latitude, double longitude) {
        System.out.println(
                "Restaurant: " + name +
                " | Category: " + category +
                " | Icon: " + icon +
                " | Location: (" + latitude + ", " + longitude + ")"
        );
    }
}