package practice.singleton.part1.app;

public class Client {
    public static void main(String[] args) {
        Application application1 = Application.getInstance();
        Application application2 = Application.getInstance();
        Application application3 = Application.getInstance();

        application1.start();

        System.out.println(application1 == application2);
        System.out.println(application2 == application3);
        System.out.println(application1 == application3);
    }
}