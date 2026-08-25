package practice.builder.part1.computer;

public class Computer {
    private String brand;
    private String processor;
    private int ram;
    private int storage;
    private String gpu;
    private boolean wifi;
    private boolean bluetooth;

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

    @Override
    public String toString() {
        return "Computer{" +
                "brand='" + brand + '\'' +
                ", processor='" + processor + '\'' +
                ", ram=" + ram +
                ", storage=" + storage +
                ", gpu='" + gpu + '\'' +
                ", wifi=" + wifi +
                ", bluetooth=" + bluetooth +
                '}';
    }
}
