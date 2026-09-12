package practice.decorator.part2.example3.decorator;

import practice.decorator.part2.example3.component.FileWriter;

public abstract class FileWriterDecorator implements FileWriter {

    protected FileWriter fileWriter;

    protected FileWriterDecorator(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    @Override
    public void write(String data) {
        fileWriter.write(data);
    }
}