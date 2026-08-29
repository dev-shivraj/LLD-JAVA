package practice.dip.part3.cloudStorage.badDesign;

public class BackupClient {

    public static void main(String[] args) {

        BackupService service =
                new BackupService();

        service.backup("data.txt");
    }
}