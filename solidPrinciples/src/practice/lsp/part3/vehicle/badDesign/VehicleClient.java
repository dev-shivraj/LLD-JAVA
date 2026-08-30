package practice.lsp.part3.vehicle.badDesign;

public class VehicleClient {
    public static void main(String[] args) {
        Vehicle vehicle = new ElectricCar();
        vehicle.startEngine();
        vehicle.drive();
        vehicle.refuel();
    }
}