package practice.dip.part1.cloudStorage.badDesign;

public class BackupClient {
    public static void main(String[] args) {
        BackupService backupService = new BackupService();

        backupService.backup();
    }
}