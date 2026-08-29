package practice.dip.part3.bird.goodDesign;

public class MongoBirdRepository
        implements BirdRepository {

    @Override
    public void save(Bird bird) {

        System.out.println(
                "Saving " + bird.getName() + " to MongoDB"
        );
    }
}