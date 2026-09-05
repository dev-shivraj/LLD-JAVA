package practice.adapter.part3.dto;

public class Shipment {
    private final String trackingId;
    private final String provider;

    public Shipment(String trackingId, String provider) {
        this.trackingId = trackingId;
        this.provider = provider;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public String getProvider() {
        return provider;
    }

    @Override
    public String toString() {
        return provider + " shipment created. Tracking ID: " + trackingId;
    }
}