package practice.srp.part2.cloudStorage.badDesign;

public class CloudStorageService {

    // group 1 : core business responsibility
    public void uploadFile() {
        System.out.println("Uploading file");
    }

    // group 1 : core business responsibility
    public void downloadFile() {
        System.out.println("Downloading file");
    }

    // group 2 : security responsibility
    public void encrypt() {
        System.out.println("Encrypting file");
    }

    // group 1 : core business responsibility
    public void deleteFile() {
        System.out.println("Deleting file");
    }

    // group 3 : persistence responsibility
    public void saveMetadataToDatabase() {
        System.out.println("Saving metadata");
    }

    // group 4 : communication responsibility
    public void sendUploadNotification() {
        System.out.println("Sending upload notification");
    }

    // group 5 : reporting responsibility
    public void generateReport() {
        System.out.println("Generating report");
    }
}