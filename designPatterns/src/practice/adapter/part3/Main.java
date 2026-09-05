package practice.adapter.part3;

import practice.adapter.part3.adapter.FedExAdapter;
import practice.adapter.part3.dto.Shipment;
import practice.adapter.part3.dto.ShipmentRequest;
import practice.adapter.part3.dto.ShippingRate;
import practice.adapter.part3.dto.ShippingRequest;
import practice.adapter.part3.external.FedExClient;
import practice.adapter.part3.provider.ShippingProvider;
import practice.adapter.part3.service.ShippingService;

public class Main {
    public static void main(String[] args) {
        FedExClient fedExClient = new FedExClient();

        ShippingProvider provider = new FedExAdapter(fedExClient);
        ShippingService shippingService = new ShippingService(provider);
        ShippingRequest rateRequest = new ShippingRequest("Bengaluru", "Mumbai", 5);

        ShippingRate rate = shippingService.getRate(rateRequest);
        System.out.println(rate);

        ShipmentRequest shipmentRequest = new ShipmentRequest("Bengaluru", "Mumbai", 5);
        Shipment shipment = shippingService.createShipment(shipmentRequest);
        System.out.println(shipment);
    }
}