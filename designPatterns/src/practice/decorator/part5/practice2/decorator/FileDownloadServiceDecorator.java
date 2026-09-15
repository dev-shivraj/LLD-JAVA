package practice.decorator.part5.practice2.decorator;

import practice.decorator.part5.practice2.component.FileDownloadService;

public abstract class FileDownloadServiceDecorator implements FileDownloadService {

    protected final FileDownloadService fileDownloadService;

    protected FileDownloadServiceDecorator(FileDownloadService fileDownloadService) {
        this.fileDownloadService = fileDownloadService;
    }

    @Override
    public void download(String fileName) {
        fileDownloadService.download(fileName);
    }
}