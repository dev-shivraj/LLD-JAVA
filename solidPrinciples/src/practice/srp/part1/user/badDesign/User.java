package practice.srp.part1.user.badDesign;

class User {

    void register() {
        System.out.println("User is registered!");
    }

    void login() {
        System.out.println("User logged in");
    }

    void saveToDatabase() {
        System.out.println("User saved to DB");
    }

    void sendWelcomeEmail() {
        System.out.println("Welcome email sent!");
    }

    void generateReport() {
        System.out.println("Report generated!");
    }
}