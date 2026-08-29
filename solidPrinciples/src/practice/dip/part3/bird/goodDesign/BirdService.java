package practice.dip.part3.bird.goodDesign;

public class BirdService {

    private final BirdRepository repository;
    private final Notification notification;
    private final ReportGenerator reportGenerator;

    public BirdService(
            BirdRepository repository,
            Notification notification,
            ReportGenerator reportGenerator) {

        this.repository = repository;
        this.notification = notification;
        this.reportGenerator = reportGenerator;
    }

    public void processBird(Bird bird) {

        repository.save(bird);

        reportGenerator.generate(bird);

        notification.send(
                "Bird processed"
        );
    }
}