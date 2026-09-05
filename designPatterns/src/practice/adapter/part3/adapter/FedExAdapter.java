package practice.adapter.part3.adapter;

import practice.adapter.part3.dto.Shipment;
import practice.adapter.part3.dto.ShipmentRequest;
import practice.adapter.part3.dto.ShippingRate;
import practice.adapter.part3.dto.ShippingRequest;
import practice.adapter.part3.exception.ShippingException;
import practice.adapter.part3.external.FedExClient;
import practice.adapter.part3.external.exception.FedExApiException;
import practice.adapter.part3.external.model.FedExRateResponse;
import practice.adapter.part3.external.model.FedExShipmentRequest;
import practice.adapter.part3.external.model.FedExShipmentResponse;
import practice.adapter.part3.provider.ShippingProvider;

public class FedExAdapter implements ShippingProvider {
    private final FedExClient client;

    public FedExAdapter(FedExClient client) {
        this.client = client;
    }

    @Override
    public ShippingRate getRate(ShippingRequest request) {
        try {
            FedExShipmentRequest fedExRequest = new FedExShipmentRequest(request.getSource(), request.getDestination(), request.getWeight());
            FedExRateResponse response = client.calculateRate(fedExRequest);

            return new ShippingRate(response.getTotalCharge(), "FedEx");
        } catch (FedExApiException ex) {
            throw new ShippingException("Unable to calculate FedEx shipping rate", ex);
        }
    }

    @Override
    public Shipment createShipment(ShipmentRequest request) {
        try {
            FedExShipmentRequest fedExRequest = new FedExShipmentRequest(request.getSource(), request.getDestination(), request.getWeight());
            FedExShipmentResponse response = client.createShipment(fedExRequest);

            return new Shipment(response.getTrackingNumber(), "FedEx");
        } catch (FedExApiException ex) {
            throw new ShippingException("Unable to create FedEx shipment", ex);
        }
    }
}