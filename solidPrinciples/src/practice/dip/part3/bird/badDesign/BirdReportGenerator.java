package practice.dip.part3.bird.badDesign;

public class BirdReportGenerator {

    public void generate(Bird bird) {

        System.out.println(
                "Generating report for "
                        + bird.getName()
        );
    }
}