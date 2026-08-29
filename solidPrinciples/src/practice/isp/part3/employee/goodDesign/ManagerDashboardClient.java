package practice.isp.part3.employee.goodDesign;

public class ManagerDashboardClient {
    public void show(ManagerCapabilities manager) {
        manager.manageTeam();
        manager.approveLeave();
        manager.generateReports();
    }
}