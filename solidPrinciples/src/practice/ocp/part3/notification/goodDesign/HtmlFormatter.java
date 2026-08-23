package practice.ocp.part3.notification.goodDesign;

public class HtmlFormatter implements Formatter {

    @Override
    public String format(String message) {
        return "<html>" + message + "</html>";
    }
}