package practice.ocp.part3.cloudStorage.goodDesign.newRequirement;

import practice.ocp.part3.cloudStorage.goodDesign.StorageProvider;

public class OracleCloudStorageProvider implements StorageProvider {
    @Override
    public void upload(String file) {
        System.out.println("Uploading to Oracle Cloud: " + file);
    }
}