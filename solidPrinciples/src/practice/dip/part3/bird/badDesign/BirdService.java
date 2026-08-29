package practice.dip.part3.bird.badDesign;

public class BirdService {

    private final MySQLBirdRepository repository =
            new MySQLBirdRepository();

    private final EmailNotification notification =
            new EmailNotification();

    private final BirdReportGenerator reportGenerator =
            new BirdReportGenerator();

    public void processBird(Bird bird) {

        repository.save(bird);

        reportGenerator.generate(bird);

        notification.send(
                "Bird processed"
        );
    }
}