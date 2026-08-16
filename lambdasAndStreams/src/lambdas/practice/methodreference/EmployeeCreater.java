package lambdas.practice.methodreference;

import lambdas.practice.entity.Employee;

@FunctionalInterface
public interface EmployeeCreater {
    Employee create(String name, int age, double salary, String department);
}
