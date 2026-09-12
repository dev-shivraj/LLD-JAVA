package practice.decorator.part2.example3.decorator;

import practice.decorator.part2.example3.component.FileWriter;

public class EncryptionFileWriter extends FileWriterDecorator {

    public EncryptionFileWriter(FileWriter fileWriter) {
        super(fileWriter);
    }

    @Override
    public void write(String data) {
        String encryptedData = "ENCRYPTED(" + data + ")";
        fileWriter.write(encryptedData);
    }
}