package practice.factory.part2.practice2;

public class Main {
    public static void main(String[] args) {
        ReportService service =
                new ReportService();

        service.export(
                "pdf",
                "Monthly sales report"
        );

        service.export(
                "csv",
                "Monthly sales report"
        );

        service.export(
                "json",
                "Monthly sales report"
        );
    }
}