package practice.builder.part3.httprequest;

import java.util.HashMap;
import java.util.Map;

public class HttpRequest {

    private final String url;
    private final String method;
    private final Map<String, String> headers;
    private final String body;
    private final int timeout;
    private final int retryCount;
    private final boolean followRedirects;

    private HttpRequest(
            String url,
            String method,
            Map<String, String> headers,
            String body,
            int timeout,
            int retryCount,
            boolean followRedirects
    ) {
        this.url = url;
        this.method = method;
        this.headers = Map.copyOf(headers);
        this.body = body;
        this.timeout = timeout;
        this.retryCount = retryCount;
        this.followRedirects = followRedirects;
    }

    public static Builder builder() {
        return new Builder();
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

    public String getBody() {
        return body;
    }

    public int getTimeout() {
        return timeout;
    }

    public int getRetryCount() {
        return retryCount;
    }

    public boolean isFollowRedirects() {
        return followRedirects;
    }

    public static class Builder {

        private String url;
        private String method;
        private final Map<String, String> headers = new HashMap<>();
        private String body;
        private int timeout = 3000;
        private int retryCount = 0;
        private boolean followRedirects = true;

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setMethod(String method) {
            this.method = method;
            return this;
        }

        public Builder addHeader(String key, String value) {
            this.headers.put(key, value);
            return this;
        }

        public Builder setBody(String body) {
            this.body = body;
            return this;
        }

        public Builder setTimeout(int timeout) {
            this.timeout = timeout;
            return this;
        }

        public Builder setRetryCount(int retryCount) {
            this.retryCount = retryCount;
            return this;
        }

        public Builder setFollowRedirects(boolean followRedirects) {
            this.followRedirects = followRedirects;
            return this;
        }

        public HttpRequest build() {

            if (url == null || url.isBlank()) {
                throw new IllegalArgumentException(
                        "URL is required"
                );
            }

            if (method == null || method.isBlank()) {
                throw new IllegalArgumentException(
                        "HTTP method is required"
                );
            }

            if (timeout <= 0) {
                throw new IllegalArgumentException(
                        "Timeout must be greater than 0"
                );
            }

            if (retryCount < 0) {
                throw new IllegalArgumentException(
                        "Retry count cannot be negative"
                );
            }

            return new HttpRequest(
                    url,
                    method,
                    headers,
                    body,
                    timeout,
                    retryCount,
                    followRedirects
            );
        }
    }
}