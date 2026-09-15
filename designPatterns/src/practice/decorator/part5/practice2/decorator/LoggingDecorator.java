package practice.decorator.part5.practice2.decorator;

import practice.decorator.part5.practice2.component.FileDownloadService;

public class LoggingDecorator extends FileDownloadServiceDecorator {

    public LoggingDecorator(FileDownloadService fileDownloadService) {
        super(fileDownloadService);
    }

    @Override
    public void download(String fileName) {
        System.out.println("[LOG] Download requested: " + fileName);
        fileDownloadService.download(fileName);
    }
}