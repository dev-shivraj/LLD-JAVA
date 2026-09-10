# OOP Fundamentals (Java)

## 📚 Overview

**Object-Oriented Programming (OOP)** is a programming paradigm where software is designed around *objects*.

An object combines three things:

| Aspect | Meaning |
|---|---|
| **State** | Data / properties |
| **Behavior** | Actions / methods |
| **Identity** | What makes one object different from another |

Java is primarily an object-oriented language, and these fundamentals are the foundation for:

`Encapsulation` → `Inheritance` → `Polymorphism` → `Abstraction` → `Design Patterns` → `SOLID Principles` → `Low-Level Design (LLD)` → `Spring / Spring Boot`

### Table of Contents

1. [What is OOP?](#1-what-is-oop)
2. [Why OOP?](#2-why-oop)
3. [Procedural Programming vs OOP](#3-procedural-programming-vs-oop)
4. [Classes and Objects](#4-classes-and-objects)
5. [State, Behavior and Identity](#5-state-behavior-and-identity)
6. [Creating Objects](#6-creating-objects)
7. [References and Objects](#7-references-and-objects)
8. [Object Memory Basics](#8-object-memory-basics)
9. [Instance Variables](#9-instance-variables)
10. [Instance Methods](#10-instance-methods)
11. [`this` Keyword](#11-this-keyword)
12. [Constructors](#12-constructors)
13. [Default Constructor](#13-default-constructor)
14. [Parameterized Constructors](#14-parameterized-constructors)
15. [Constructor Overloading](#15-constructor-overloading)
16. [Constructor Chaining](#16-constructor-chaining)
17. [Practice Problems](#-practice-problems)
18. [Mental Model & Revision Sheet](#-mental-model--revision-sheet)
19. [Interview Questions](#-interview-questions)
20. [Common Interview Traps](#️-common-interview-traps)
21. [OOP and LLD Relevance](#️-oop-and-lld-relevance)

---

## 1. What is OOP?

> **Definition:** OOP is a programming paradigm where software is designed around objects that contain **state** and **behavior**.

Instead of thinking only in terms of functions and data separately, OOP models real-world or business entities as objects.

**Example — a bank account:**

| State | Behavior |
|---|---|
| account number | deposit money |
| account holder | withdraw money |
| balance | display balance |

```java
public class BankAccount {
    String accountNumber;
    String accountHolder;
    double balance;

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        balance -= amount;
    }

    void displayBalance() {
        System.out.println("Balance: " + balance);
    }
}
```

Creating and using an object:

```java
BankAccount account = new BankAccount();
account.accountNumber = "ACC101";
account.accountHolder = "Shivraj";
account.balance = 50000;

account.deposit(5000);
account.displayBalance();
```

> 💡 **Key idea:** OOP combines data and the operations that work on that data into objects.

---

## 2. Why OOP?

Without OOP, large applications become hard to maintain because data and operations are scattered across many functions. OOP organizes code around meaningful entities.

### Major Benefits

| Benefit | Description |
|---|---|
| **Modularity** | Related state and behavior stay together |
| **Reusability** | Classes can be reused to create multiple objects |
| **Maintainability** | Changes can be isolated to the relevant class |
| **Extensibility** | New behavior can often be added without rewriting existing code |
| **Encapsulation** | Objects control how their internal state is accessed |
| **Abstraction** | Complex implementation details can be hidden |
| **Polymorphism** | The same interface can represent different implementations |

### Example: Before vs After

**❌ Without OOP** — data and behavior scattered per entity:

```java
String employee1Name;
double employee1Salary;
String employee2Name;
double employee2Salary;

void increaseEmployee1Salary() { /* ... */ }
void increaseEmployee2Salary() { /* ... */ }
```

**✅ With OOP** — one reusable class:

```java
public class Employee {
    String name;
    double salary;

    void increaseSalary(double percentage) {
        salary += salary * percentage / 100;
    }
}
```

```java
Employee employee1 = new Employee();
Employee employee2 = new Employee();

employee1.name = "Shivraj";
employee1.salary = 50000;

employee2.name = "Rahul";
employee2.salary = 60000;

employee1.increaseSalary(10);
employee2.increaseSalary(10);
```

The same class provides structure and behavior for many objects.

---

## 3. Procedural Programming vs OOP

### Procedural Programming

Organizes software around **functions**, **procedures**, and **data** — usually kept separate.

```java
public class BankOperations {
    static double deposit(double balance, double amount) {
        return balance + amount;
    }

    static double withdraw(double balance, double amount) {
        return balance - amount;
    }
}
```

The balance is passed *into* functions each time.

### OOP

Organizes software around **objects**, which own both state and behavior.

```java
public class BankAccount {
    double balance;

    void deposit(double amount) {
        balance += amount;
    }

    void withdraw(double amount) {
        balance -= amount;
    }
}
```

```java
BankAccount account = new BankAccount();
account.balance = 50000;
account.deposit(5000);
account.withdraw(2000);
```

Here the object *owns* the state and *provides* the behavior.

### Comparison

| Procedural Programming | OOP |
|---|---|
| Function-oriented | Object-oriented |
| Data and functions often separate | State and behavior grouped |
| Focuses on operations | Focuses on objects |
| Can become harder to manage as systems grow | Better organization for complex systems |
| Reuse mainly through functions | Reuse through classes, composition, inheritance, interfaces |
| Data may be exposed | Encapsulation can protect data |

> ⚠️ Procedural programming isn't "bad," and OOP isn't automatically "better." The right paradigm depends on the problem.

---

## 4. Classes and Objects

### Class — a blueprint

```java
public class Car {
    String brand;
    String color;
    int speed;
}
```

### Object — an instance of a class

```java
Car car1 = new Car();
Car car2 = new Car();
```

- `Car` → the class
- `car1`, `car2` → reference variables
- `new Car()` → creates an object

Each object created from the class has its **own** instance state:

```java
Car car1 = new Car();
car1.brand = "BMW";
car1.color = "Black";
car1.speed = 100;

Car car2 = new Car();
car2.brand = "Audi";
car2.color = "White";
car2.speed = 80;
```

Although both objects come from the same class, their state differs.

---

## 5. State, Behavior and Identity

| Concept | Meaning (for a `Car`) |
|---|---|
| **State** | brand, color, speed |
| **Behavior** | accelerate, brake, display state |
| **Identity** | what makes two cars *different objects*, even with identical state |

```java
public class Car {
    String brand;
    String color;
    int speed;

    void accelerate() { speed += 10; }
    void brake() { speed -= 10; }

    void displayState() {
        System.out.println(brand);
        System.out.println(color);
        System.out.println(speed);
    }
}
```

```java
Car car1 = new Car();
car1.brand = "BMW"; car1.color = "Black"; car1.speed = 100;

Car car2 = new Car();
car2.brand = "BMW"; car2.color = "Black"; car2.speed = 100;

System.out.println(car1 == car2);   // false
```

**Why `false`?** Because `car1` and `car2` are two *different objects* — same state does **not** mean same identity.

---

## 6. Creating Objects

Objects are created with the `new` keyword:

```java
Car car = new Car();
```

| Part | Role |
|---|---|
| `Car` | reference type |
| `car` | reference variable |
| `new Car()` | creates the object |

**Object creation flow:**

```
new Car()
  → create object
  → initialize fields
  → execute constructor
  → return object reference
  → store reference in variable
```

Each `new` expression creates a **separate** object:

```java
Car car1 = new Car();
Car car2 = new Car();
Car car3 = new Car();
// three distinct objects
```

### Default Field Values

Instance fields get default values automatically when an object is created:

| Type | Default value |
|---|---|
| `int` | `0` |
| `long` | `0L` |
| `double` | `0.0` |
| `float` | `0.0f` |
| `boolean` | `false` |
| `char` | `'\u0000'` |
| Reference type | `null` |

```java
public class Car {
    String brand;
    String color;
    int speed;
    boolean running;
}
```

```java
Car car = new Car();
System.out.println(car.brand);    // null
System.out.println(car.color);    // null
System.out.println(car.speed);    // 0
System.out.println(car.running);  // false
```

---

## 7. References and Objects

One of the most important concepts in Java.

```java
Car car = new Car();
```

There are **two separate things**:

- `car` → a **reference variable**
- `new Car()` → the **object**

The variable doesn't *contain* the object — it holds a **reference** to it.

### `null`

A reference can point to no object:

```java
Car car = null;
```

Accessing a member through a `null` reference throws a `NullPointerException`:

```java
Car car = null;
System.out.println(car.brand);   // 💥 NullPointerException
```

### Multiple References to One Object

```java
Car car1 = new Car();
Car car2 = car1;
```

There is **only one object** — both `car1` and `car2` point to it. Changing through one reference affects the other:

```java
car2.speed = 100;
System.out.println(car1.speed);   // 100
```

### Aliasing

When multiple references point to the same object, they are called **aliases**:

```java
Car car1 = new Car();
Car car2 = car1;
Car car3 = car2;
// car1, car2, car3 all refer to the same object
```

### Reference Reassignment

```java
Car car1 = new Car();   // car1 -> Object A
Car car2 = new Car();   // car2 -> Object B

car1 = car2;             // now car1 and car2 both -> Object B
```

> 💡 Object A may now become eligible for garbage collection (if nothing else references it). Assigning one reference to another does **not** copy the object.

### `==` With References

For objects, `==` checks whether two references point to the **same object** (not whether their contents are equal).

```java
Car car1 = new Car();
Car car2 = new Car();
System.out.println(car1 == car2);   // false — different objects

Car car3 = car1;
System.out.println(car1 == car3);   // true — same object
```

---

## 8. Object Memory Basics

A simplified but useful mental model:

| Memory area | Holds |
|---|---|
| **Stack** | Method execution frames, local variables, and references |
| **Heap** | Objects created with `new` |

```java
Car car = new Car();
car.brand = "BMW";
car.speed = 100;
```

```
Stack                    Heap
 car  ───────────────►  Car Object
                          ├─ brand = "BMW"
                          └─ speed = 100
```

`car` is a reference variable; the `Car` object is the thing it refers to.

### Object Graphs

Objects can reference other objects:

```java
public class Engine {
    String type;
}

public class Car {
    String brand;
    int speed;
    Engine engine;
}
```

```java
Engine engine = new Engine();
engine.type = "Petrol";

Car car = new Car();
car.brand = "BMW";
car.speed = 100;
car.engine = engine;
```

```
car → Car Object
        └─ engine → Engine Object
                       └─ type = "Petrol"
```

This is called an **object graph** — an idea that becomes very important in LLD.

### Object Lifetime

```java
Car car = new Car();
car = null;
```

If no other reference points to the object, it becomes **eligible for garbage collection** (handled by the JVM — "eligible" doesn't mean "immediately deleted").

---

## 9. Instance Variables

An **instance variable** is declared inside a class, but outside methods, constructors, and blocks:

```java
public class Car {
    String brand;
    String color;
    int speed;
}
```

### Each Object Has Its Own Instance State

```java
Car car1 = new Car();
Car car2 = new Car();

car1.brand = "BMW";
car2.brand = "Audi";
// changing car1.brand does not affect car2.brand
```

### Instance Variable vs Local Variable

| | Gets a default value? |
|---|---|
| Instance variable | ✅ Yes |
| Local variable | ❌ No — must be initialized before use |

```java
// ❌ Does not compile — local variable used before initialization
void test() {
    int age;
    System.out.println(age);
}
```

### Direct Field Initialization

```java
public class Laptop {
    String brand = "Unknown";
    int ram = 8;
    boolean poweredOn = false;
}
```

These values are used when the object is created.

---

## 10. Instance Methods

An **instance method** represents behavior tied to an object.

```java
public class Car {
    String brand;
    int speed;

    void accelerate() { speed += 10; }
    void brake() { speed -= 10; }
    void displaySpeed() { System.out.println("Speed: " + speed); }
}
```

```java
Car car = new Car();
car.speed = 50;

car.accelerate();
car.displaySpeed();   // Speed: 60

car.brake();
car.displaySpeed();   // Speed: 50
```

The method operates on the state of the specific object it's called on:

```java
Car car1 = new Car(); car1.speed = 50;
Car car2 = new Car(); car2.speed = 100;

car1.accelerate();   // car1.speed = 60
car2.accelerate();   // car2.speed = 110
```

### Methods Can Return Values

```java
public class BankAccount {
    double balance;
    double getBalance() { return balance; }
}
```

### Methods Can Call Other Methods

```java
public class BankAccount {
    double balance;

    void deposit(double amount) { balance += amount; }
    void showBalance() { System.out.println("Balance: " + balance); }

    void depositAndShowBalance(double amount) {
        deposit(amount);
        showBalance();
    }
}
```

> 💡 **Core OOP idea:** state and behavior live together on the object, instead of data and functions being separate. This becomes essential when learning encapsulation and LLD.

---

## 11. `this` Keyword

`this` is a reference to the **current object**.

```java
public class Car {
    String brand;
    int speed;

    void displayInfo() {
        System.out.println(this.brand);
        System.out.println(this.speed);
    }
}
```

### `this` Resolves Naming Conflicts

```java
public class Employee {
    String name;

    void setName(String name) {
        this.name = name;   // this.name = instance variable, name = parameter
    }
}
```

### `this` in Constructors

```java
public class Student {
    String name;
    int age;
    String course;

    Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }
}
```

### `this` Calling Another Instance Method

```java
public class BankAccount {
    double balance;

    void deposit(double amount) { this.balance += amount; }
    void showBalance() { System.out.println(this.balance); }

    void depositAndShowBalance(double amount) {
        this.deposit(amount);
        this.showBalance();
    }
}
```

The `this.` prefix is often optional when there's no ambiguity — `deposit(amount)` is equivalent to `this.deposit(amount)`.

### `this` and Static Context

A static method belongs to the **class**, not to a particular object, so:

```java
static void test() {
    System.out.println(this);   // ❌ invalid — no current object
}
```

> **Remember:** `this` is a reference to the current object — it is not a separate object.

---

## 12. Constructors

A **constructor** is a special member that initializes an object when it's created.

```java
public class Car {
    Car() {
        System.out.println("Car constructor executed");
    }
}
```

```java
Car car = new Car();   // prints: Car constructor executed
```

### Constructor Rules

A constructor:
1. Has the same name as the class
2. Has no return type
3. Is invoked during object creation
4. Can have parameters
5. Can be overloaded
6. Can have access modifiers
7. **Cannot** be overridden
8. Can participate in constructor chaining

### Constructor vs Method

| Constructor | Method |
|---|---|
| Same name as class | Can have any valid name |
| No return type | Has a return type or `void` |
| Used during object creation | Used to perform behavior |
| Invoked implicitly via `new` | Invoked explicitly |
| Cannot be overridden | Can be overridden |
| Can be overloaded | Can be overloaded |

### Why Use a Constructor?

```java
// Without a constructor
BankAccount account = new BankAccount();
account.accountNumber = "ACC101";
account.accountHolder = "Shivraj";
account.balance = 50000;

// With a constructor
BankAccount account = new BankAccount("ACC101", "Shivraj", 50000);
```

The constructor lets the object be fully initialized at creation time.

---

## 13. Default Constructor

A **default constructor** is the no-argument constructor the compiler supplies automatically when no constructor is declared.

```java
public class Car {
    String brand;
    int speed;
    // no constructor declared → compiler provides one
}
```

```java
Car car = new Car();   // works — uses the compiler-generated constructor
```

> ⚠️ **Important rule:** If you declare *any* constructor, the compiler does **not** automatically add the default (no-arg) one.

```java
public class Student {
    Student(String name) { /* ... */ }
}
```

```java
new Student("Shivraj");   // ✅ works
new Student();             // ❌ does not compile — no no-arg constructor exists
```

### Default Constructor vs No-Argument Constructor

These terms are related but **not identical**:

| Term | Meaning |
|---|---|
| **Default constructor** | Specifically the compiler-provided constructor when none is declared |
| **No-argument constructor** | Any constructor with zero parameters — compiler-provided *or* hand-written |

```java
public class Car {
    Car() {              // a no-argument constructor, but NOT the compiler-generated default
        brand = "BMW";
        speed = 100;
    }
}
```

---

## 14. Parameterized Constructors

A constructor that accepts parameters:

```java
public class Student {
    String name;
    int age;
    String course;

    Student(String name, int age, String course) {
        this.name = name;
        this.age = age;
        this.course = course;
    }
}
```

```java
Student student = new Student("Shivraj", 27, "Java");
```

### Why Use Them?

| Without | With |
|---|---|
| Create object, then set each field manually | Object initialized in one line |

Benefits: cleaner object creation, less repetitive code, immediate initialization, required data supplied up front, and a valid object state guaranteed from the start.

```java
Student student1 = new Student("Shivraj", 27, "Java");
Student student2 = new Student("Rahul", 28, "Spring Boot");
```

Same class, different state per object.

> 💡 If you need both styles of creation (no-arg *and* parameterized), you must declare **both** constructors explicitly.

---

## 15. Constructor Overloading

**Constructor overloading** means defining multiple constructors in the same class with different parameter lists.

```java
public class Student {
    String name;
    int age;
    String course;

    Student() {
        this.name = "Unknown"; this.age = 0; this.course = "Unknown";
    }
    Student(String name) {
        this.name = name; this.age = 0; this.course = "Unknown";
    }
    Student(String name, int age) {
        this.name = name; this.age = age; this.course = "Unknown";
    }
    Student(String name, int age, String course) {
        this.name = name; this.age = age; this.course = course;
    }
}
```

### Constructor Signature

Overloading depends on the **parameter list** — parameter *names* don't matter:

```java
Student(String name)         // signature: (String)
Student(String studentName)  // ❌ same signature (String) — invalid alongside the above
```

Order also matters — these are considered different:

```java
Test(String name, int age)
Test(int age, String name)
```

### Compile-Time Polymorphism

```java
new Student("Shivraj", 27);
```

```
new Student("Shivraj", 27)
    → compile-time selection
    → Student(String, int)
```

The compiler determines the matching constructor at **compile time**, which is why constructor overloading is a form of compile-time polymorphism.

> Constructors can be **overloaded**, but not **overridden** (they aren't inherited the way methods are).

### The `null` Ambiguity Trap

```java
class Test {
    Test(String value) { System.out.println("String"); }
    Test(Integer value) { System.out.println("Integer"); }
}
```

```java
new Test(null);   // ❌ ambiguous — null matches both String and Integer
```

This is a common interview trap.

---

## 16. Constructor Chaining

**Constructor chaining** means one constructor calls another constructor. There are two forms:

| Form | Keyword | Target |
|---|---|---|
| Same class | `this(...)` | another constructor in the same class |
| Parent class | `super(...)` | the parent class's constructor (covered under inheritance) |

### `this(...)`

```java
public class Employee {
    String name;
    double salary;

    Employee() {
        this("Unknown", 0);
    }
    Employee(String name) {
        this(name, 0);
    }
    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }
}
```

The chain:

```
Employee()          → Employee(String, double)
Employee(String)    → Employee(String, double)
```

The most complete constructor performs the actual initialization.

### Why Chain?

**❌ Without chaining** — duplicated logic:

```java
Employee() { name = "Unknown"; salary = 0; }
Employee(String name) { this.name = name; salary = 0; }
Employee(String name, double salary) { this.name = name; this.salary = salary; }
```

**✅ With chaining** — centralized logic:

```java
Employee() { this("Unknown", 0); }
Employee(String name) { this(name, 0); }
Employee(String name, double salary) { this.name = name; this.salary = salary; }
```

### Chaining Direction

```
Less information → More information → Complete constructor
Employee() → Employee(String) → Employee(String, double)
```

### Rule: `this(...)` Must Be the First Statement

```java
// ✅ Valid
Employee() {
    this("Unknown", 0);
    System.out.println("Employee created");
}

// ❌ Invalid — this(...) is not the first statement
Employee() {
    System.out.println("Employee created");
    this("Unknown", 0);
}
```

Other rules:
- `this(...)` **cannot** be used inside a regular method — only inside a constructor.
- A constructor **cannot call itself** (`this()` calling itself) — this causes infinite recursion, which the compiler rejects.
- A **circular chain** between two constructors (A calls B, B calls A) is also rejected by the compiler.

### `this(...)` vs `this.field`

| | Meaning |
|---|---|
| `this.field` | refers to an instance variable of the current object |
| `this(...)` | calls another constructor of the same class |

### `this(...)` vs `super(...)`

| `this(...)` | `super(...)` |
|---|---|
| Calls another constructor in the same class | Calls the parent class's constructor |
| Used for chaining within the same class | Used for chaining with the parent |
| Must be the first statement | Must be the first statement |
| Cannot appear together in the same constructor (only one "first statement" allowed) | Same |

### Execution Order Example

```java
class Test {
    Test() {
        this(10);
        System.out.println("A");
    }
    Test(int x) {
        System.out.println("B");
    }
}
```

```java
new Test();
```

```
new Test() → Test() → this(10) → Test(int) → prints "B" → return → prints "A"
```

**Output:**
```
B
A
```

The constructor invoked via `this(...)` always runs **first**.

---

## 🧪 Practice Problems

### Practice 1 — Constructor Chaining

**Problem:** Create a `Product` class with `name`, `price`, and `quantity`. Define four constructors (no-arg, name-only, name+price, name+price+quantity), chained so they all delegate to the most complete constructor. Add a `displayInfo()` method.

**Reference solution:**

```java
public class Product {
    String name;
    double price;
    int quantity;

    Product() {
        this("Unknown");
    }
    Product(String name) {
        this(name, 0);
    }
    Product(String name, double price) {
        this(name, price, 0);
    }
    Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    void displayInfo() {
        System.out.println("Name: " + name);
        System.out.println("Price: " + price);
        System.out.println("Quantity: " + quantity);
    }
}
```

```java
public class Main {
    public static void main(String[] args) {
        Product product1 = new Product();
        Product product2 = new Product("Laptop");
        Product product3 = new Product("Mouse", 1500);
        Product product4 = new Product("Keyboard", 3000, 2);

        product1.displayInfo();
        product2.displayInfo();
        product3.displayInfo();
        product4.displayInfo();
    }
}
```

**Expected output:**

```
Product 1: Name: Unknown   | Price: 0.0    | Quantity: 0
Product 2: Name: Laptop    | Price: 0.0    | Quantity: 0
Product 3: Name: Mouse     | Price: 1500.0 | Quantity: 0
Product 4: Name: Keyboard  | Price: 3000.0 | Quantity: 2
```

### Practice 2 — Predict Constructor Execution

```java
class Test {
    Test() {
        this(10);
        System.out.println("A");
    }
    Test(int x) {
        System.out.println("B");
    }
}
```

**Question:** What is the output of `new Test();`?

<details>
<summary>Answer</summary>

```
B
A
```

Because `this(10)` runs `Test(int)` first (printing `B`), then control returns to `Test()` (printing `A`).
</details>

### Practice 3 — Find the Error

```java
class Car {
    Car() {
        System.out.println("Creating car");
        this("BMW");
    }
    Car(String brand) {
        System.out.println(brand);
    }
}
```

**Question:** What's wrong?

<details>
<summary>Answer</summary>

`this("BMW")` must be the **first statement** in the constructor. Fix:

```java
Car() {
    this("BMW");
    System.out.println("Creating car");
}
```
</details>

---

## 🧠 Mental Model & Revision Sheet

```
Class (blueprint)
  → Object (instance)
       ├─ State      → Instance Variables → Object State
       └─ Behavior   → Instance Methods

Object creation:
  new → Constructor → Initialization → Reference returned → Reference Variable

References:
  reference → object
  ref1, ref2, ref3 → (can all point to the same object — aliasing)

this → current object

Constructors:
  no-argument / parameterized / overloaded / chained

Constructor chaining:
  Constructor A → this(...) → Constructor B → Complete Initialization
```

### Quick Revision Table

| Term | One-line definition |
|---|---|
| OOP | Object = State + Behavior + Identity |
| Class | Blueprint / template |
| Object | Instance of a class |
| Reference | Points to an object |
| `new` | Creates an object |
| Instance Variable | Object-specific state |
| Instance Method | Object-specific behavior |
| `this` | Current object reference |
| Constructor | Initializes an object during creation |
| Default Constructor | Compiler-provided, only when no constructor exists |
| No-Argument Constructor | Any constructor with zero parameters |
| Parameterized Constructor | Constructor that accepts parameters |
| Constructor Overloading | Multiple constructors, different parameter lists |
| Constructor Chaining | One constructor calls another via `this(...)` |

### 13 Most Important Concepts

1. **Class vs Object** — a class is a blueprint; an object is an instance of it.
2. **State vs Behavior** — instance variables hold state; instance methods define behavior.
3. **Object vs Reference** — a reference points to an object; it isn't the object itself.
4. **`==` with objects** — checks whether two references point to the same object.
5. **`new`** — creates an object and invokes its constructor.
6. **Instance variables** — each object has its own copy.
7. **Instance methods** — operate on the object they're called through.
8. **`this`** — refers to the current object.
9. **Constructor** — initializes an object during creation.
10. **Default constructor** — supplied by the compiler only if no constructor is declared.
11. **Parameterized constructor** — supplies object state at creation time.
12. **Constructor overloading** — multiple constructors, different parameter lists.
13. **Constructor chaining** — `this(...)` lets one constructor call another in the same class.

---

## 🎯 Interview Questions

### Basic

| # | Question | Answer |
|---|---|---|
| 1 | What is OOP? | A paradigm that organizes software around objects containing state and behavior. |
| 2 | What is a class? | A blueprint used to create objects. |
| 3 | What is an object? | An instance of a class. |
| 4 | What are state, behavior, and identity? | State = data, Behavior = operations, Identity = uniqueness of the object. |
| 5 | What does `new` do? | Creates a new object and invokes its constructor. |

### References

| # | Question | Answer |
|---|---|---|
| 6 | What is a reference variable? | A variable that stores a reference to an object. |
| 7 | Can two references point to the same object? | Yes — e.g. `Car car2 = car1;` |
| 8 | What happens when one reference is changed? | If both point to the same object, changes are visible through either reference. |
| 9 | What does `==` compare for objects? | Object references, not contents. |
| 10 | What happens when an object becomes unreachable? | It becomes eligible for garbage collection. |

### Instance Variables and Methods

| # | Question | Answer |
|---|---|---|
| 11 | What is an instance variable? | A variable declared inside a class but outside methods, constructors, and blocks. |
| 12 | Do instance variables get default values? | Yes. |
| 13 | Do local variables get default values? | No. |
| 14 | What is an instance method? | A method tied to an object, operating on its instance state. |

### `this`

| # | Question | Answer |
|---|---|---|
| 15 | What is `this`? | A reference to the current object. |
| 16 | Why use `this.name = name`? | To distinguish the instance variable from a same-named parameter. |
| 17 | Can `this` be used in static methods? | No. |
| 18 | Difference between `this` and `this(...)`? | `this` refers to the current object; `this(...)` invokes another constructor in the same class. |

### Constructors

| # | Question | Answer |
|---|---|---|
| 19 | What is a constructor? | A special member used to initialize an object during creation. |
| 20 | Can a constructor have a return type? | No — not even `void`. |
| 21 | Can constructors be overloaded? | Yes. |
| 22 | Can constructors be overridden? | No. |
| 23 | What happens if no constructor is written? | The compiler provides a default constructor. |
| 24 | What happens if a parameterized constructor is declared? | The compiler no longer auto-provides a no-arg default constructor. |
| 25 | What is constructor chaining? | One constructor invoking another constructor. |
| 26 | Which keyword is used for same-class constructor chaining? | `this(...)` |
| 27 | Where must `this(...)` appear? | As the first statement of the constructor. |

---

## ⚠️ Common Interview Traps

1. **Same erasure signature:** `Student(String name)` and `Student(String studentName)` cannot coexist — both have signature `(String)`; parameter *names* don't count.
2. **Default ≠ no-arg:** A hand-written no-argument constructor is not the same thing as the compiler-generated default constructor.
3. **Declaring any constructor removes the default:** Once you write one constructor, Java stops auto-generating the no-arg default.
4. **`==` compares references, not contents.**
5. **Reference assignment doesn't copy objects:** `Car car2 = car1;` — both now point to the *same* object.
6. **`this(...)` must be the first statement** in a constructor.
7. **`this(...)` and `super(...)` can't both appear** in the same constructor — both require the "first statement" position.
8. **Constructors can be overloaded, but never overridden.**

---

## 🏗️ OOP and LLD Relevance

Part 1 is the foundation for Low-Level Design (LLD). When designing a system, you repeatedly ask:

**What are the objects?** (e.g., for a parking system)
`Vehicle` · `ParkingSpot` · `Ticket` · `ParkingLot` · `Payment`

**What is their state?** (e.g., for `Vehicle`)
vehicle number, vehicle type

**What is their behavior?**
park, exit, calculate fee

**How do objects interact?**

```
ParkingLot
  ├─ ParkingSpot
  ├─ Vehicle
  ├─ Ticket
  └─ Payment
```

### Example: A Simple Payment Object

```
Payment
  ├─ amount
  ├─ paymentId
  ├─ status
  ├─ pay()
  ├─ refund()
  └─ displayStatus()
```

With abstraction and polymorphism, this can later evolve into:

```
Payment
  ├─ CardPayment
  ├─ UpiPayment
  └─ CashPayment
```

These ideas — abstraction, polymorphism, interfaces — are developed in later OOP parts and used heavily in LLD.

---

## 🎓 Final Takeaway

The most important idea here isn't memorizing syntax — it's learning to **think in terms of objects**.

Instead of only asking:

> "What function should I write?"

start asking:

> "What object is responsible for this behavior?"
> "What state belongs to that object?"

This mindset is the foundation for the path:

**OOP → SOLID → Design Patterns → LLD → Spring / Spring Boot architecture**