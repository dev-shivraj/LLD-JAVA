package practice.facade.part1.computer;

import practice.facade.part1.computer.component.CPU;
import practice.facade.part1.computer.component.HardDrive;
import practice.facade.part1.computer.component.Memory;
import practice.facade.part1.computer.component.OperatingSystem;
import practice.facade.part1.computer.facade.ComputerFacade;

public class Main {
    public static void main(String[] args) {
        ComputerFacade computer = new ComputerFacade(new CPU(), new Memory(), new HardDrive(), new OperatingSystem());
        computer.startComputer();
    }
}