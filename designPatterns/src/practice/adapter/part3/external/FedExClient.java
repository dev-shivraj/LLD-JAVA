package practice.adapter.part3.external;

import practice.adapter.part3.external.exception.FedExApiException;
import practice.adapter.part3.external.model.FedExRateResponse;
import practice.adapter.part3.external.model.FedExShipmentRequest;
import practice.adapter.part3.external.model.FedExShipmentResponse;

public class FedExClient {
    public FedExRateResponse calculateRate(FedExShipmentRequest request) {
        if (request.getPackageWeight() <= 0) {
            throw new FedExApiException("Invalid package weight");
        }

        return new FedExRateResponse(500);
    }

    public FedExShipmentResponse createShipment(FedExShipmentRequest request) {
        if (request.getPackageWeight() <= 0) {
            throw new FedExApiException("Invalid package weight");
        }

        return new FedExShipmentResponse("FDX-12345");
    }
}