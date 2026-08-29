package practice.dip.part3.bird.goodDesign;

public class BirdClient {

    public static void main(String[] args) {

        Bird bird =
                new Bird("Penguin");

        BirdRepository repository =
                new MySQLBirdRepository();

        Notification notification =
                new EmailNotification();

        ReportGenerator reportGenerator =
                new BirdReportGenerator();

        BirdService service =
                new BirdService(
                        repository,
                        notification,
                        reportGenerator
                );

        service.processBird(bird);

        System.out.println("----------------");

        repository =
                new MongoBirdRepository();

        notification =
                new SMSNotification();

        service =
                new BirdService(
                        repository,
                        notification,
                        reportGenerator
                );

        service.processBird(bird);
    }
}