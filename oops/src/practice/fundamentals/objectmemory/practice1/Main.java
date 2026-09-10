package practice.fundamentals.objectmemory.practice1;

public class Main {

    public static void main(String[] args) {

        Address address = new Address();

        address.city = "Bengaluru";
        address.country = "India";

        Person person1 = new Person();

        person1.name = "Shivraj";
        person1.age = 27;
        person1.address = address;

        Person person2 = person1;

        System.out.println("Before changing through person2:");
        System.out.println("person1 name: " + person1.name);
        System.out.println("person2 name: " + person2.name);

        person2.name = "Rahul";

        System.out.println();
        System.out.println("After changing through person2:");
        System.out.println("person1 name: " + person1.name);
        System.out.println("person2 name: " + person2.name);

        System.out.println();
        System.out.println("City: " + person1.address.city);
        System.out.println("Country: " + person1.address.country);

        System.out.println();
        System.out.println("person1 == person2: " + (person1 == person2));
    }
}