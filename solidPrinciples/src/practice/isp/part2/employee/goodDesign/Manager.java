package practice.isp.part2.employee.goodDesign;

public class Manager implements Employee, ManagerCapabilities {
    @Override
    public void work() {
        System.out.println("Manager is working");
    }

    @Override
    public void eat() {
        System.out.println("Manager is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Manager is sleeping");
    }

    @Override
    public void manageTeam() {
        System.out.println("Manager is managing team");
    }

    @Override
    public void approveLeave() {
        System.out.println("Manager is approving leave");
    }

    @Override
    public void generateReports() {
        System.out.println("Manager is generating reports");
    }
}