package practice.builder.part2.computer;

public class ComputerBuilder {

    private String brand;
    private String processor;
    private int ram;
    private int storage;
    private String gpu;
    private boolean wifi;
    private boolean bluetooth;

    public ComputerBuilder setBrand(String brand) {
        this.brand = brand;
        return this;
    }

    public ComputerBuilder setProcessor(String processor) {
        this.processor = processor;
        return this;
    }

    public ComputerBuilder setRam(int ram) {
        this.ram = ram;
        return this;
    }

    public ComputerBuilder setStorage(int storage) {
        this.storage = storage;
        return this;
    }

    public ComputerBuilder setGpu(String gpu) {
        this.gpu = gpu;
        return this;
    }

    public ComputerBuilder setWifi(boolean wifi) {
        this.wifi = wifi;
        return this;
    }

    public ComputerBuilder setBluetooth(boolean bluetooth) {
        this.bluetooth = bluetooth;
        return this;
    }

    public Computer build() {

        if (brand == null || brand.isBlank()) {
            throw new IllegalArgumentException("Brand is required");
        }

        if (processor == null || processor.isBlank()) {
            throw new IllegalArgumentException("Processor is required");
        }

        if (ram <= 0) {
            throw new IllegalArgumentException("RAM must be greater than 0");
        }

        return new Computer(
                brand,
                processor,
                ram,
                storage,
                gpu,
                wifi,
                bluetooth
        );
    }
}