package practice.builder.part2.car;

/*
    brand       → required
    model       → required
    engine      → required
    color       → optional
    sunroof     → optional
    automatic   → optional
 */
public class Car {
    private final String brand;
    private final String model;
    private final String engine;
    private final String color;
    private final boolean sunroof;
    private final boolean automatic;

    private Car(
            String brand,
            String model,
            String engine,
            String color,
            boolean sunroof,
            boolean automatic
    ) {
        this.brand = brand;
        this.model = model;
        this.engine = engine;
        this.color = color;
        this.sunroof = sunroof;
        this.automatic = automatic;
    }

    public static CarBuilder builder() {
        return new CarBuilder();
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public String getEngine() {
        return engine;
    }

    public String getColor() {
        return color;
    }

    public boolean isSunroof() {
        return sunroof;
    }

    public boolean isAutomatic() {
        return automatic;
    }

    public static class CarBuilder {

        private String brand;
        private String model;
        private String engine;
        private String color;
        private boolean sunroof;
        private boolean automatic;

        public CarBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public CarBuilder setModel(String model) {
            this.model = model;
            return this;
        }

        public CarBuilder setEngine(String engine) {
            this.engine = engine;
            return this;
        }

        public CarBuilder setColor(String color) {
            this.color = color;
            return this;
        }

        public CarBuilder setSunroof(boolean sunroof) {
            this.sunroof = sunroof;
            return this;
        }

        public CarBuilder setAutomatic(boolean automatic) {
            this.automatic = automatic;
            return this;
        }

        public Car build() {
            if (brand == null || brand.isBlank()) {
                throw new IllegalArgumentException("Brand is required");
            }

            if (model == null || model.isBlank()) {
                throw new IllegalArgumentException("Model is required");
            }

            if (engine == null || engine.isBlank()) {
                throw new IllegalArgumentException("Engine is required");
            }

            return new Car(
                    brand,
                    model,
                    engine,
                    color,
                    sunroof,
                    automatic
            );
        }
    }
}