package practice.builder.part1;

import practice.builder.part1.computer.Computer;
import practice.builder.part1.computer.ComputerBuilder;

public class ComputerClient {

    public static void main(String[] args) {

        Computer computer = new ComputerBuilder()
                .setBrand("Apple")
                .setProcessor("M4")
                .setRam(16)
                .setStorage(512)
                .setWifi(true)
                .setBluetooth(true)
                .build();

        System.out.println("Brand: " + computer.getBrand());
        System.out.println("Processor: " + computer.getProcessor());
        System.out.println("RAM: " + computer.getRam());
        System.out.println("Storage: " + computer.getStorage());
        System.out.println("GPU: " + computer.getGpu());
        System.out.println("WiFi: " + computer.isWifi());
        System.out.println("Bluetooth: " + computer.isBluetooth());
    }
}