package practice.decorator.part5.practice2.decorator;

import practice.decorator.part5.practice2.component.FileDownloadService;

public class EncryptionDecorator extends FileDownloadServiceDecorator {

    public EncryptionDecorator(FileDownloadService fileDownloadService) {
        super(fileDownloadService);
    }

    @Override
    public void download(String fileName) {
        System.out.println("[ENCRYPTION] Encrypting " + fileName);
        fileDownloadService.download(fileName + ".encrypted");
    }
}