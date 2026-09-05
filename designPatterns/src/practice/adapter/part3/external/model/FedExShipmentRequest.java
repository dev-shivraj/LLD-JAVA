package practice.adapter.part3.external.model;

public class FedExShipmentRequest {
    private final String originAddress;
    private final String destinationAddress;
    private final double packageWeight;

    public FedExShipmentRequest(String originAddress, String destinationAddress, double packageWeight) {
        this.originAddress = originAddress;
        this.destinationAddress = destinationAddress;
        this.packageWeight = packageWeight;
    }

    public String getOriginAddress() {
        return originAddress;
    }

    public String getDestinationAddress() {
        return destinationAddress;
    }

    public double getPackageWeight() {
        return packageWeight;
    }
}