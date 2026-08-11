package static_keyword;

public class Loaded {
    static int loadedCount;

    static {
        System.out.println("============================================================================================");
        System.out.println("Loaded class static block executed");
        System.out.println("Loaded class static block is executed only once when the class is loaded into memory");
        System.out.println("============================================================================================");
    }
}
