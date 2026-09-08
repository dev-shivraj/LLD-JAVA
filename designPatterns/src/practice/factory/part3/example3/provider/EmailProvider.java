package practice.factory.part3.example3.provider;

public class EmailProvider {

    public void sendEmail(String message) {
        System.out.println("Email Provider: Sending email -> " + message);
    }
}