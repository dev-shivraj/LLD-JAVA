package practice.builder.part3.instructor;

public class Instructor {
    private String name;
    private  String email;
    private int age;
    private double salary;
    private String company;
    private boolean working;

    private Instructor(Builder builder) {
        this.name = builder.name;
        this.email = builder.email;
        this.age = builder.age;
        this.salary = builder.salary;
        this.company = builder.company;
        this.working = builder.working;
    }

    public static Builder builder() {
        return new Builder();
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    public String getCompany() {
        return company;
    }

    public boolean isWorking() {
        return working;
    }

    public static class Builder {
        private String name;
        private  String email;
        private int age;
        private double salary;
        private String company;
        private boolean working;


        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setSalary(double salary) {
            this.salary = salary;
            return this;
        }

        public Builder setCompany(String company) {
            this.company = company;
            return this;
        }

        public Builder setWorking(boolean working) {
            this.working = working;
            return this;
        }

        public Instructor build() {
            if (!working) {
                throw new IllegalArgumentException("Working is a mandatory field");
            }
            return new Instructor(this);
        }
    }
}
