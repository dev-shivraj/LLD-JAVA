package comparablecomparator.practice.comparable;

public class Employee implements Comparable<Employee>{
    private int id;
    private String name;
    private double salary;

    public Employee() {
    }

    public Employee(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public int compareTo(Employee other) {
        return Double.compare(this.getSalary(), other.getSalary());
    }

    @Override
    public String toString() {
        return "{" +
                "id: " + id +
                ", name: " + name +
                ", salary: " + salary +
                "}\n";
    }
}
