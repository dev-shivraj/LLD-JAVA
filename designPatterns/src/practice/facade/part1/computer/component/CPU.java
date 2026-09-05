package practice.facade.part1.computer.component;

public class CPU {
    public void freeze() {
        System.out.println("CPU frozen");
    }

    public void jump(long position) {
        System.out.println("CPU jumping to position: " + position);
    }
}