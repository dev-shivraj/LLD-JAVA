package practice.singleton.part2.examples.lazycache;

public class Client {
    public static void main(String[] args) {
        LazyCache cache1 = LazyCache.getInstance();
        cache1.put("user", "Shivraj");

        LazyCache cache2 = LazyCache.getInstance();

        System.out.println(cache2.get("user"));
        System.out.println(cache1 == cache2);
    }
}