package passByReferencePassByValue;

public class
Client {
    public static void main(String[] args) {

        int x = 10;

        // it will not change the value of x because it is passed by value
        // so add method will create a copy of x and change the value of that copy, but not the original x
        // so the value of x will remain 10 after the method call
        add(x);
        System.out.println(x);

        Driver d = new Driver(1, "Jane Doe", 4.5, true);
        changeName(d);
        System.out.println(d.name);
    }

    public static void add(int x) {
        x = x + 10;
    }

    public static void changeName(Driver driver) {
        // here driver is passed by value
        // but the value is a reference to the object in memory,
        // so it can change the state of the object

        // for example driver holds memory address : 1000 in the memory in the main method
        // and when it calls changeName method, it will create a copy of the reference and pass it to the method
        // so the copy of the reference will also hold the same memory address : 1000
        // so when we change the name of the driver object using the copy of the reference,
        // it will change the name of the driver object in the memory, which is the same object that the original reference in the main method is pointing to
        // so the name of the driver object will be changed to "Sam Smith" in the memory, and when we print the name of the driver object in the main method, it will print "Sam Smith"
        // but if we see driver is a copy of the reference, it is copy of value
        // just because this copied reference is pointing to the same object in memory, it can change the state of the object, but it cannot change the reference itself to point to a new object in memory
        // that's why it is called pass by value, because the value of the reference is passed to the method, not the reference itself
        driver.name = "Sam Smith";
    }
}
