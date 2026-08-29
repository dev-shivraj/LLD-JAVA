package practice.isp.part2.employee.badDesign;

public class Developer implements Employee {
    @Override
    public void work() {
        System.out.println("Developer is writing code");
    }

    @Override
    public void eat() {
        System.out.println("Developer is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Developer is sleeping");
    }

    @Override
    public void manageTeam() {
        System.out.println("Developer does not manage team");
    }

    @Override
    public void approveLeave() {
        System.out.println("Developer cannot approve leave");
    }

    @Override
    public void generateReports() {
        System.out.println("Developer does not generate management reports");
    }
}