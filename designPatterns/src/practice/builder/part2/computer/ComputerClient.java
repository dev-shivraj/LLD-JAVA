package practice.builder.part2.computer;

public class ComputerClient {
    public static void main(String[] args) {
        // this will fail because of the required field validation in the builder
        Computer computer = new ComputerBuilder()
                .setRam(16)
                .build();
    }
}
