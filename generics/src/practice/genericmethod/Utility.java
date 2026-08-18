package practice.genericmethod;

public class Utility {

    public static <T> void print(T value) {
        System.out.println(value);
    }

    public static <T> T identity(T value) {
        return value;
    }
}
