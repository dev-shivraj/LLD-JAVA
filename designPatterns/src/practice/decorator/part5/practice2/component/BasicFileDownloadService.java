package practice.decorator.part5.practice2.component;

public class BasicFileDownloadService implements FileDownloadService {

    @Override
    public void download(String fileName) {
        System.out.println("Downloading file: " + fileName);
    }
}