package practice.singleton.part4.practice3;

public class Client {
    public static void main(String[] args) throws Exception {
        CloneSafeSingleton singleton = CloneSafeSingleton.getInstance();

        try {
            CloneSafeSingleton clone = (CloneSafeSingleton) singleton.clone();
            System.out.println(singleton == clone);
        } catch (CloneNotSupportedException e) {
            System.out.println(e.getMessage());
        }
    }
}