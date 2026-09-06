package practice.singleton.part3.example.cache;

public class CacheManager {
    private CacheManager() {
    }

    private static class Holder {
        private static final CacheManager INSTANCE = new CacheManager();
    }

    public static CacheManager getInstance() {
        return Holder.INSTANCE;
    }
}