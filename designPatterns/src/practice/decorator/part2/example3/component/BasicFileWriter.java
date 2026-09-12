package practice.decorator.part2.example3.component;

public class BasicFileWriter implements FileWriter {

    @Override
    public void write(String data) {
        System.out.println("Writing file: " + data);
    }
}