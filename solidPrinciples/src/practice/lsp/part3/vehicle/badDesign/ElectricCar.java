package practice.lsp.part3.vehicle.badDesign;

public class ElectricCar extends Vehicle {
    @Override
    public void refuel() {
        throw new UnsupportedOperationException("Electric car does not use fuel");
    }
}