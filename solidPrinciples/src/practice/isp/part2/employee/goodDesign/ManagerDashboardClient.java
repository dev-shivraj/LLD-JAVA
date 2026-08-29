package practice.isp.part2.employee.goodDesign;

public class ManagerDashboardClient {
    public void show(ManagerCapabilities manager) {
        manager.manageTeam();
        manager.approveLeave();
        manager.generateReports();
    }
}