package practice.decorator.part2.example3;

import practice.decorator.part2.example3.component.BasicFileWriter;
import practice.decorator.part2.example3.component.FileWriter;
import practice.decorator.part2.example3.decorator.CompressionFileWriter;
import practice.decorator.part2.example3.decorator.EncryptionFileWriter;
import practice.decorator.part2.example3.decorator.LoggingFileWriter;

public class Client {

    public static void main(String[] args) {

        FileWriter writer = new BasicFileWriter();

        writer = new CompressionFileWriter(writer);
        writer = new EncryptionFileWriter(writer);
        writer = new LoggingFileWriter(writer);

        writer.write("Important Data");
    }
}