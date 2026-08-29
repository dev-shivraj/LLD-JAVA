package practice.isp.part3.employee.goodDesign;

public class EmployeeClient {
    public static void main(String[] args) {
        Employee developer = new Developer();
        developer.work();
        developer.eat();
        developer.sleep();
        System.out.println("----------------");

        Employee manager = new Manager();
        manager.work();
        manager.eat();
        manager.sleep();
        System.out.println("----------------");

        ManagerCapabilities managerCapabilities = new Manager();
        managerCapabilities.manageTeam();
        managerCapabilities.approveLeave();
        managerCapabilities.generateReports();
    }
}