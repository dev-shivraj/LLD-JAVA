package practice.dip.part1.cloudStorage.goodDesign;

public class BackupClient {
    public static void main(String[] args) {
        Storage storage = new AmazonS3Storage();


        BackupService backupService = new BackupService(storage);
        backupService.backup();
        System.out.println("----------------");

        storage = new AzureBlobStorage();
        backupService = new BackupService(storage);
        backupService.backup();
        System.out.println("----------------");

        storage =new GCPStorage();
        backupService = new BackupService(storage);
        backupService.backup();
    }
}