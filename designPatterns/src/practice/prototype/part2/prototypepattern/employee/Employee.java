package practice.prototype.part2.prototypepattern.employee;

public class Employee implements Prototype<Employee> {
    private String name;
    private String department;
    private String designation;

    public Employee(String name, String department, String designation) {
        this.name = name;
        this.department = department;
        this.designation = designation;
    }

    @Override
    public Employee copy() {
        return new Employee(name, department, designation);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                ", designation='" + designation + '\'' +
                '}';
    }
}
