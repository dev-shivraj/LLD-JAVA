package practice.prototype.part1.employee;

public class Employee {

    private String name;
    private String department;
    private String designation;

    public Employee(String name, String department, String designation) {
        this.name = name;
        this.department = department;
        this.designation = designation;
    }

    public Employee copy() {
        return new Employee(this.name, this.department, this.designation);
    }

    public void setName(String name) {
        this.name = name;
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
                "}";
    }

}