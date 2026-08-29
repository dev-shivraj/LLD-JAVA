package practice.dip.part1.cloudStorage.goodDesign;

public class BackupService {
    private final Storage storage;

    public BackupService(Storage storage) {
        this.storage = storage;
    }

    public void backup() {
        storage.upload();
    }
}