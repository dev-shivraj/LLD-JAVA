package practice.decorator.part2.example3.decorator;

import practice.decorator.part2.example3.component.FileWriter;

public class CompressionFileWriter extends FileWriterDecorator {

    public CompressionFileWriter(FileWriter fileWriter) {
        super(fileWriter);
    }

    @Override
    public void write(String data) {
        String compressedData = "COMPRESSED(" + data + ")";
        fileWriter.write(compressedData);
    }
}