package practice.adapter.part3.external.exception;

public class FedExApiException extends RuntimeException {
    public FedExApiException(String message) {
        super(message);
    }
}