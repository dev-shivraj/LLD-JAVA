package practice.facade.part1.computer.facade;

import practice.facade.part1.computer.component.CPU;
import practice.facade.part1.computer.component.HardDrive;
import practice.facade.part1.computer.component.Memory;
import practice.facade.part1.computer.component.OperatingSystem;

public class ComputerFacade {
    private static final long BOOT_ADDRESS = 0;
    private static final long BOOT_SECTOR = 0;
    private static final int BOOT_SIZE = 1024;

    private final CPU cpu;
    private final Memory memory;
    private final HardDrive hardDrive;
    private final OperatingSystem operatingSystem;

    public ComputerFacade(CPU cpu, Memory memory, HardDrive hardDrive, OperatingSystem operatingSystem) {
        this.cpu = cpu;
        this.memory = memory;
        this.hardDrive = hardDrive;
        this.operatingSystem = operatingSystem;
    }

    public void startComputer() {
        cpu.freeze();
        byte[] bootData = hardDrive.read(BOOT_SECTOR, BOOT_SIZE);
        memory.load(BOOT_ADDRESS, bootData);
        cpu.jump(BOOT_ADDRESS);
        operatingSystem.start();
    }
}