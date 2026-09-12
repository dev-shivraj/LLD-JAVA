package practice.decorator.part2.example3.decorator;

import practice.decorator.part2.example3.component.FileWriter;

public class LoggingFileWriter extends FileWriterDecorator {

    public LoggingFileWriter(FileWriter fileWriter) {
        super(fileWriter);
    }

    @Override
    public void write(String data) {
        System.out.println("[LOG] File write started");
        fileWriter.write(data);
        System.out.println("[LOG] File write completed");
    }
}