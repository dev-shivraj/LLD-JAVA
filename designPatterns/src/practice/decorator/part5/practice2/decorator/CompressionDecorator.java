package practice.decorator.part5.practice2.decorator;

import practice.decorator.part5.practice2.component.FileDownloadService;

public class CompressionDecorator extends FileDownloadServiceDecorator {

    public CompressionDecorator(FileDownloadService fileDownloadService) {
        super(fileDownloadService);
    }

    @Override
    public void download(String fileName) {
        System.out.println("[COMPRESSION] Compressing " + fileName);
        fileDownloadService.download(fileName + ".compressed");
    }
}