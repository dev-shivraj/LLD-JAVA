package static_keyword;

public class NotLoaded {
    static {
        System.out.println("============================================================================================");
        System.out.println("NotLoaded class static block executed");
        System.out.println("NotLoaded class static block is executed only once when the class is loaded into memory");
        System.out.println("============================================================================================");
    }
}
