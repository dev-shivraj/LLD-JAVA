package practice.lsp.part3.employee.badDesign;

public class Intern extends Employee {
    @Override
    public void manageTeam() {
        throw new UnsupportedOperationException("Intern cannot manage a team");
    }
}