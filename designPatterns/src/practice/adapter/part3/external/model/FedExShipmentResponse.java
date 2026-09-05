package practice.adapter.part3.external.model;

public class FedExShipmentResponse {
    private final String trackingNumber;

    public FedExShipmentResponse(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }
}