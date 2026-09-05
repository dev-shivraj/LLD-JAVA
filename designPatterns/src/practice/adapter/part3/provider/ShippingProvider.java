package practice.adapter.part3.provider;

import practice.adapter.part3.dto.Shipment;
import practice.adapter.part3.dto.ShipmentRequest;
import practice.adapter.part3.dto.ShippingRate;
import practice.adapter.part3.dto.ShippingRequest;

public interface ShippingProvider {
    ShippingRate getRate(ShippingRequest request);
    Shipment createShipment(ShipmentRequest request);
}