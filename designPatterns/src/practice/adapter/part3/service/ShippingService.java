package practice.adapter.part3.service;

import practice.adapter.part3.dto.Shipment;
import practice.adapter.part3.dto.ShipmentRequest;
import practice.adapter.part3.dto.ShippingRate;
import practice.adapter.part3.dto.ShippingRequest;
import practice.adapter.part3.provider.ShippingProvider;

public class ShippingService {
    private final ShippingProvider provider;

    public ShippingService(ShippingProvider provider) {
        this.provider = provider;
    }

    public ShippingRate getRate(ShippingRequest request) {
        return provider.getRate(request);
    }

    public Shipment createShipment(ShipmentRequest request) {
        return provider.createShipment(request);
    }
}