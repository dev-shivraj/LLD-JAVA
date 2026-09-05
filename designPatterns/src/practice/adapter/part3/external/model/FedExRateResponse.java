package practice.adapter.part3.external.model;

public class FedExRateResponse {
    private final double totalCharge;

    public FedExRateResponse(double totalCharge) {
        this.totalCharge = totalCharge;
    }

    public double getTotalCharge() {
        return totalCharge;
    }
}