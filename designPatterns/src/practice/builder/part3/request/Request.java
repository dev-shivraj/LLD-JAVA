package practice.builder.part3.request;

import java.security.PrivateKey;
import java.util.HashMap;
import java.util.Map;

/*
    url              required
    method           required
    headers          optional
    queryParameters  optional
    body             optional
    timeout          optional

    String url
    String method
    Map<String, String> headers
    Map<String, String> queryParameters
    String body
    int timeout

    Requirements:
        * Request immutable.
        * All fields final.
        * Private constructor.
        * Nested Builder.
        * Static builder().
        * Defensive copy of Maps.
        * URL and method mandatory.
        * Timeout must be greater than zero.
        * addHeader() method.
        * addQueryParameter() method.
        * Method chaining.
 */
public class Request {
    private final String url;
    private final String method;
    private final Map<String, String> headers;
    private final Map<String, String> queryParameters;
    private final String body;
    private final int timeout;

    private Request(String url, String method, Map<String, String> headers, Map<String, String> queryParameters, String body, int timeout) {
        this.url = url;
        this.method = method;
        this.headers = Map.copyOf(headers);
        this.queryParameters = Map.copyOf(queryParameters);
        this.body = body;
        this.timeout = timeout;
    }

    public static RequestBuilder builder() {
        return new RequestBuilder();
    }

    public String getUrl() {
        return url;
    }

    public String getMethod() {
        return method;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }

    public Map<String, String> getQueryParameters() {
        return queryParameters;
    }

    public String getBody() {
        return body;
    }

    public int getTimeout() {
        return timeout;
    }

    public static class RequestBuilder{
        private String url;
        private String method;
        private Map<String, String> headers = new HashMap<>();
        private Map<String, String> queryParameters = new HashMap<>();
        private String body;
        private int timeout = 3000;

        public RequestBuilder setUrl(String url) {
            this.url = url;
            return this;
        }

        public RequestBuilder setMethod(String method) {
            this.method = method;
            return this;
        }

        public RequestBuilder addHeader(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public RequestBuilder addQueryParameter(String key, String value) {
            this.queryParameters.put(key, value);
            return this;
        }

        public RequestBuilder setBody(String body) {
            this.body = body;
            return this;
        }

        public RequestBuilder setTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public Request build() {
            if(url == null || url.isBlank()) {
                throw new IllegalArgumentException("Url is required");
            }

            if (method == null || method.isBlank()) {
                throw new IllegalArgumentException(
                        "HTTP method is required"
                );
            }

            return new Request(url, method, headers, queryParameters, body, timeout);
        }
    }
}
