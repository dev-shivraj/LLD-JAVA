package practice.builder.part2.laptop;

/*
    brand       → required
    model       → required
    processor   → required
    ram         → required
    storage     → optional
    gpu         → optional
    screenSize  → optional
    backlit     → optional
 */
public class Laptop {
    private final String brand;
    private final String model;
    private final String processor;
    private final int ram;
    private final int storage;
    private final String gpu;
    private final double screenSize;
    private final boolean backlit;


    private Laptop(String brand, String model, String processor, int ram, int storage, String gpu, double screenSize, boolean backlit) {
        this.brand = brand;
        this.model = model;
        this.processor = processor;
        this.ram = ram;
        this.storage = storage;
        this.gpu = gpu;
        this.screenSize = screenSize;
        this.backlit = backlit;
    }

    public static LaptopBuilder builder() {
        return new LaptopBuilder();
    }
    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
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

    public double getScreenSize() {
        return screenSize;
    }

    public boolean isBacklit() {
        return backlit;
    }

    public static class LaptopBuilder {
        private String brand;
        private String model;
        private String processor;
        private int ram;
        private int storage;
        private String gpu;
        private double screenSize;
        private boolean backlit;

        public LaptopBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public LaptopBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public LaptopBuilder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public LaptopBuilder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public LaptopBuilder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public LaptopBuilder setGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public LaptopBuilder setScreenSize(double screenSize) {
            this.screenSize = screenSize;
            return this;
        }

        public LaptopBuilder setBacklit(boolean backlit) {
            this.backlit = backlit;
            return this;
        }

        public Laptop build() {
            if(brand == null || brand.isBlank()) {
                throw new IllegalArgumentException("Brand is required.");
            }

            if(model == null || model.isBlank()) {
                throw new IllegalArgumentException("Model is required.");
            }

            if(processor == null || processor.isBlank()) {
                throw new IllegalArgumentException("Processor is required.");
            }

            if (ram <= 0) {
                throw new IllegalArgumentException("RAM must be greater than 0");
            }

            return new Laptop(brand, model, processor, ram, storage, gpu, screenSize, backlit);
        }
    }
}
