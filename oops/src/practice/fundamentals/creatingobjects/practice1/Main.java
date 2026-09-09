package practice.fundamentals.creatingobjects.practice1;

public class Main {
    public static void main(String[] args) {
        MobilePhone phone1 = new MobilePhone();
        phone1.brand = "Apple";
        phone1.model = "iPhone 16";
        phone1.price = 79999;
        phone1.isPoweredOn = true;

        MobilePhone phone2 = new MobilePhone();
        phone2.brand = "Samsung";
        phone2.model = "Galaxy S25";
        phone2.price = 74999;
        phone2.isPoweredOn = false;

        MobilePhone phone3 = new MobilePhone();

        System.out.println("Phone 1:");
        System.out.println("Brand: " + phone1.brand);
        System.out.println("Model: " + phone1.model);
        System.out.println("Price: " + phone1.price);
        System.out.println("Powered On: " + phone1.isPoweredOn);
        System.out.println();

        System.out.println("Phone 2:");
        System.out.println("Brand: " + phone2.brand);
        System.out.println("Model: " + phone2.model);
        System.out.println("Price: " + phone2.price);
        System.out.println("Powered On: " + phone2.isPoweredOn);
        System.out.println();


        System.out.println("Phone 3:");
        System.out.println("Brand: " + phone3.brand);
        System.out.println("Model: " + phone3.model);
        System.out.println("Price: " + phone3.price);
        System.out.println("Powered On: " + phone3.isPoweredOn);
    }
}
