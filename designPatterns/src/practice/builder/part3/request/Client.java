package practice.builder.part3.request;

public class Client {
    public static void main(String[] args) {
        Request request = Request.builder()
                .setUrl("https://api.example.com/users")
                .setMethod("GET")
                .addHeader("Authorization", "token")
                .addQueryParameter("page", "1")
                .addQueryParameter("limit", "10")
                .setTimeout(5000)
                .build();

        Request request1 = Request.builder()
                .setUrl("https://api.example.com/users")
                .setMethod("POST")
                .build();

        System.out.println(request.getMethod());

        System.out.println(request1.getMethod());
    }
}
