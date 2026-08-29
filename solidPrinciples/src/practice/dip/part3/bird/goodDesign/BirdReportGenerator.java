package practice.dip.part3.bird.goodDesign;

public class BirdReportGenerator
        implements ReportGenerator {

    @Override
    public void generate(Bird bird) {

        System.out.println(
                "Generating report for "
                        + bird.getName()
        );
    }
}