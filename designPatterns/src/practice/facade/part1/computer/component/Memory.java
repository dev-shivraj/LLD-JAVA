package practice.facade.part1.computer.component;

public class Memory {
    public void load(long position, byte[] data) {
        System.out.println("Loading " + data.length + " bytes into memory at position " + position);
    }
}