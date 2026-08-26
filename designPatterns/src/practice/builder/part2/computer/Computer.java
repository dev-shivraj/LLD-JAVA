package practice.builder.part2.computer;

public class Computer {

    private final String brand;
    private final String processor;
    private final int ram;
    private final int storage;
    private final String gpu;
    private final boolean wifi;
    private final boolean bluetooth;

    public Computer(String brand, String processor, int ram, int storage, String gpu, boolean wifi, boolean bluetooth) {
        this.brand = brand;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.gpu = gpu;
        this.wifi = wifi;
        this.bluetooth = bluetooth;
    }

    public String getBrand() {
        return brand;
    }

    public String getProcessor() {
        return processor;
    }

    public int getRam() {
        return ram;
    }

    public int getStorage() {
        return storage;
    }

    public String getGpu() {
        return gpu;
    }

    public boolean isWifi() {
        return wifi;
    }

    public boolean isBluetooth() {
        return bluetooth;
    }
}