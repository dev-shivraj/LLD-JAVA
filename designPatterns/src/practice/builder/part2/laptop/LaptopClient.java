package practice.builder.part2.laptop;

public class LaptopClient {
    public static void main(String[] args) {
        // =========================================================================
        // this will fail because of brand, model, processor, ram is required
//        Laptop laptop = Laptop.builder()
//                .setBrand("Apple")
//                .setRam(24)
//                .build();
//        System.out.println(laptop.getBrand());


        // =========================================================================

        Laptop laptop = Laptop.builder()
                .setBrand("Apple")
                .setModel("MacBook Pro")
                .setProcessor("M4 Pro")
                .setRam(24)
                .setStorage(512)
                .setScreenSize(14.2)
                .setBacklit(true)
                .build();

        System.out.println("Brand: " + laptop.getBrand());
        System.out.println("Model: " + laptop.getModel());
        System.out.println("Processor: " + laptop.getProcessor());
        System.out.println("Ram: " + laptop.getRam());
        System.out.println("Storage: " + laptop.getStorage());
        System.out.println("ScreenSize: " + laptop.getScreenSize());
        System.out.println("Backlit: " + laptop.isBacklit());

        // =========================================================================
    }
}
