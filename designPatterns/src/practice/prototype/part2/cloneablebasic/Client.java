package practice.prototype.part2.cloneablebasic;

public class Client {
    public static void main(String[] args) {
        Employee employee1 = new Employee("Shivraj", "Engineering");
        Employee employee2 = employee1.clone();

        System.out.println(employee1);
        System.out.println(employee2);

        System.out.println(employee1 == employee2);
    }
}
