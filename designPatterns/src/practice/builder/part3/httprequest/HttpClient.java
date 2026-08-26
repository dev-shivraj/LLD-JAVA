package practice.builder.part3.httprequest;

public class HttpClient {

    public static void main(String[] args) {

        // ==============================================================================================================

//        HttpRequest request = HttpRequest.builder()
//                .setUrl("https://example.com/users")
//                .setMethod("POST")
//                .addHeader("Content-Type", "application/json")
//                .addHeader("Authorization", "Bearer token")
//                .setBody("{\"name\":\"Shivraj\"}")
//                .setTimeout(5000)
//                .setRetryCount(3)
//                .build();
//
//        System.out.println("URL: " + request.getUrl());
//        System.out.println("Method: " + request.getMethod());
//        System.out.println("Headers: " + request.getHeaders());
//        System.out.println("Body: " + request.getBody());
//        System.out.println("Timeout: " + request.getTimeout());
//        System.out.println("Retry Count: " + request.getRetryCount());
//        System.out.println("Follow Redirects: " + request.isFollowRedirects());

        // ==============================================================================================================
        // Builder Reuse
//        HttpRequest.Builder builder = HttpRequest.builder();
//
//        builder
//                .setUrl("https://example.com")
//                .setMethod("GET");
//
//        HttpRequest request1 = builder.build();
//
//
//
//
//        builder.setMethod("POST");
//        HttpRequest request2 = builder.build();


        // ==============================================================================================================
        // Builder Reuse Can Cause State Leakage

        HttpRequest.Builder builder =
                HttpRequest.builder()
                        .setUrl("https://example.com")
                        .setMethod("POST")
                        .addHeader("Authorization", "token");

        HttpRequest request1 = builder.build();

        builder.setMethod("GET");

        // request 2 will contain Authorization header now, because the Builder retained its state.
        // Therefore: A Builder should generally be treated as a single-use construction object unless its reuse semantics are explicitly designed.
        HttpRequest request2 = builder.build();

        /*
            Prefer:
                HttpRequest request1 = HttpRequest.builder()
                        ...
                        .build();

                HttpRequest request2 = HttpRequest.builder()
                        ...
                        .build();
         */



        // ==============================================================================================================


        // ==============================================================================================================


        // ==============================================================================================================
    }
}