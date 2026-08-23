package practice.ocp.part3.notification.goodDesign;

public class PlainTextFormatter implements Formatter {

    @Override
    public String format(String message) {
        return message;
    }
}