package practice.lsp.part3.vehicle.goodDesign;

public class VehicleClient {
    public static void main(String[] args) {
        Vehicle electricCar = new ElectricCar();
        electricCar.start();
        electricCar.drive();
        System.out.println("----------------");

        FuelVehicle petrolCar = new PetrolCar();
        petrolCar.start();
        petrolCar.drive();
        petrolCar.refuel();
    }
}