package practice.boundedgenerics_04.part5;

public class Client {
    public static void main(String[] args) {
        EntityRepository<Employee> employeeEntityRepository = new EntityRepository<>();
        employeeEntityRepository.save(new Employee(1));

        // it will fail here
        // EntityRepository<String> entityRepository = new EntityRepository<String>();
    }
}
