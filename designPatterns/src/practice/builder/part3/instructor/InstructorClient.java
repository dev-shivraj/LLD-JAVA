package practice.builder.part3.instructor;

public class InstructorClient {
    public static void main(String[] args) {

        Instructor instructor = Instructor.builder()
                .setName("Shivraj")
                .setEmail("shivraj@gmail.com")
                .setAge(22)
                .setSalary(50000)
                .setCompany("Scaler")
                .setWorking(true)
                .build();

        System.out.println("Name: " + instructor.getName());
        System.out.println("Company: " + instructor.getCompany());
    }
}
