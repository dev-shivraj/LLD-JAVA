package practice.singleton.part2.holder;

public class HolderSingleton {
    private HolderSingleton() {
        System.out.println("HolderSingleton created");
    }

    private static class Holder {
        private static final HolderSingleton INSTANCE = new HolderSingleton();
    }

    public static HolderSingleton getInstance() {
        return Holder.INSTANCE;
    }
}