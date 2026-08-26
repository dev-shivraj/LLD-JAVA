package practice.builder.part2.car;

public class CarClient {
    public static void main(String[] args) {
        // ===========================================================
//        Car car = new Car.CarBuilder()
//                .setBrand("Toyota")
//                .setModel("Camry")
//                .setEngine("2.5L")
//                .setColor("Black")
//                .setSunroof(true)
//                .setAutomatic(true)
//                .build();
//
//        System.out.println(car.getBrand());
//
//
//        // this will fail as it doesn't set the required field
//        Car car1 = new Car.CarBuilder()
//                .setBrand("Toyota")
//                .setModel("Camry")
//                .build();

        // ===========================================================

        // after adding static build() method to Car class
        Car car = Car.builder()
                .setBrand("Toyota")
                .setModel("Camry")
                .setEngine("2.5L")
                .setColor("Black")
                .setSunroof(true)
                .setAutomatic(true)
                .build();

        System.out.println("Brand: " + car.getBrand());
        System.out.println("Model: " + car.getModel());
        System.out.println("Engine: " + car.getEngine());
        System.out.println("Color: " + car.getColor());
        System.out.println("Sunroof: " + car.isSunroof());
        System.out.println("Automatic: " + car.isAutomatic());

        // ===========================================================
    }
}
