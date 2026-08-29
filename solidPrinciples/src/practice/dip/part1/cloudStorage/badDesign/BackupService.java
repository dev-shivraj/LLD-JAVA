package practice.dip.part1.cloudStorage.badDesign;

public class BackupService {
    private final AmazonS3Storage storage = new AmazonS3Storage();

    public void backup() {
        storage.upload();
    }
}