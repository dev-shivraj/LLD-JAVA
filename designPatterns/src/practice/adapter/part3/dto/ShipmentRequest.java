package practice.adapter.part3.dto;

public class ShipmentRequest {
    private final String source;
    private final String destination;
    private final double weight;

    public ShipmentRequest(String source, String destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }
}