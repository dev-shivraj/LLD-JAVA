package practice.flyweight.part1.practice2.extrinsic;

import practice.flyweight.part1.practice2.intrinsic.MarkerType;

public class RestaurantMarker {

    private final String name;
    private final double latitude;
    private final double longitude;
    private final MarkerType markerType;

    public RestaurantMarker(
            String name,
            double latitude,
            double longitude,
            MarkerType markerType
    ) {
        this.name = name;
        this.latitude = latitude;
        this.longitude = longitude;
        this.markerType = markerType;
    }

    public void display() {
        markerType.display(name, latitude, longitude);
    }

    public MarkerType getMarkerType() {
        return markerType;
    }
}