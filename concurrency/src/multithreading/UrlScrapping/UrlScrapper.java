package multithreading.UrlScrapping;

import java.util.concurrent.Callable;

public class UrlScrapper implements Callable<Void> {
    private String url;

    public UrlScrapper(String url) {
        this.url = url;
    }

    @Override
    public Void call() throws Exception {
        // Simulate URL scrapping
        System.out.println("Scrapping URL: " + url);
        Thread.sleep(200); // Simulate time taken to scrap the URL
        System.out.println("Finished scrapping URL: " + url);
        return null;
    }
}
