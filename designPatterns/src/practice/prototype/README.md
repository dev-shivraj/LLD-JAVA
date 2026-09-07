# Prototype Design Pattern

Complete learning documentation for the Prototype Design Pattern.

This README covers: Prototype fundamentals, why Prototype is needed, Creational Design Patterns, normal object creation vs Prototype, Prototype terminology, object copying, shallow copy, deep copy, Java `Cloneable`, `Object.clone()`, `super.clone()`, `CloneNotSupportedException`, copy constructor, copy factory method, Prototype interface, Game Character example, Document Template example, Prototype Registry, registry operations, Registry vs Factory, Prototype + Builder, final Notification LLD, deep copying nested mutable objects, advantages, disadvantages, when to use Prototype, when not to use Prototype, interview questions, practice problems, practice solutions, project structure, and final checklist.

---

## Table of Contents

1. [What Is the Prototype Design Pattern?](#1-what-is-the-prototype-design-pattern)
2. [Why Do We Need Prototype?](#2-why-do-we-need-prototype)
3. [Prototype Is a Creational Design Pattern](#3-prototype-is-a-creational-design-pattern)
4. [Normal Object Creation](#4-normal-object-creation)
5. [Prototype-Based Object Creation](#5-prototype-based-object-creation)
6. [Prototype Mental Model](#6-prototype-mental-model)
7. [Important Prototype Terminology](#7-important-prototype-terminology)
8. [Basic Prototype Workflow](#8-basic-prototype-workflow)
9. [Object Copying](#9-object-copying)
10. [Shallow Copy](#10-shallow-copy)
11. [Deep Copy](#11-deep-copy)
12. [Shallow Copy vs Deep Copy](#12-shallow-copy-vs-deep-copy)
13. [Primitive Fields vs Reference Fields](#13-primitive-fields-vs-reference-fields)
14. [Java Cloneable](#14-java-cloneable)
15. [Object.clone()](#15-objectclone)
16. [Why super.clone()?](#16-why-superclone)
17. [Basic Cloneable Example](#17-basic-cloneable-example)
18. [Why Do We Cast super.clone()?](#18-why-do-we-cast-superclone)
19. [CloneNotSupportedException](#19-clonenotsupportedexception)
20. [Shallow Clone Example](#20-shallow-clone-example)
21. [Deep Clone Example](#21-deep-clone-example)
22. [Prototype Does Not Require Cloneable](#22-prototype-does-not-require-cloneable)
23. [Copy Constructor](#23-copy-constructor)
24. [Copy Constructor With Nested Object](#24-copy-constructor-with-nested-object)
25. [Copy Factory Method](#25-copy-factory-method)
26. [Generic Prototype Interface](#26-generic-prototype-interface)
27. [Comparison of Copying Approaches](#27-comparison-of-copying-approaches)
28. [Game Character Example](#28-game-character-example)
29. [GameCharacter](#29-gamecharacter)
30. [Warrior](#30-warrior)
31. [Mage](#31-mage)
32. [Game Character Workflow](#32-game-character-workflow)
33. [Prototype Independence](#33-prototype-independence)
34. [Document Template Example](#34-document-template-example)
35. [Document Prototype Interface](#35-document-prototype-interface)
36. [Document](#36-document)
37. [Invoice](#37-invoice)
38. [Resume](#38-resume)
39. [Prototype Registry](#39-prototype-registry)
40. [Registry Concept](#40-registry-concept)
41. [Registry Architecture](#41-registry-architecture)
42. [Why Registry Should Return a Copy](#42-why-registry-should-return-a-copy)
43. [Basic Registry](#43-basic-registry)
44. [Registry That Returns Copies](#44-registry-that-returns-copies)
45. [Registry Operations](#45-registry-operations)
46. [Document Registry](#46-document-registry)
47. [Document Registry Client](#47-document-registry-client)
48. [Prototype Registry vs Factory](#48-prototype-registry-vs-factory)
49. [Factory vs Prototype](#49-factory-vs-prototype)
50. [Factory vs Prototype Registry Example](#50-factory-vs-prototype-registry-example)
51. [Prototype + Builder](#51-prototype--builder)
52. [Responsibilities of Builder, Prototype and Registry](#52-responsibilities-of-builder-prototype-and-registry)
53. [Final LLD — Notification Template System](#53-final-lld--notification-template-system)
54. [Final Project Structure](#54-final-project-structure)
55. [Final Practice Files](#55-final-practice-files)
56. [Prototype.java](#56-prototypejava)
57. [NotificationMetadata.java](#57-notificationmetadatajava)
58. [Notification.java](#58-notificationjava)
59. [EmailNotification.java](#59-emailnotificationjava)
60. [SmsNotification.java](#60-smsnotificationjava)
61. [PushNotification.java](#61-pushnotificationjava)
62. [NotificationRegistry.java](#62-notificationregistryjava)
63. [Client.java](#63-clientjava)
64. [Final Deep Copy Verification](#64-final-deep-copy-verification)
65. [Final Object Graph](#65-final-object-graph)
66. [Why Not Just Use new?](#66-why-not-just-use-new)
67. [Complete Prototype Workflow](#67-complete-prototype-workflow)
68. [Complete Prototype Architecture](#68-complete-prototype-architecture)
69. [Generic Registry](#69-generic-registry)
70. [Type-Safety Consideration](#70-type-safety-consideration)
71. [Advantages of Prototype](#71-advantages-of-prototype)
72. [Disadvantages of Prototype](#72-disadvantages-of-prototype)
73. [When Should We Use Prototype?](#73-when-should-we-use-prototype)
74. [When Should We Not Use Prototype?](#74-when-should-we-not-use-prototype)
75. [Prototype vs Builder](#75-prototype-vs-builder)
76. [Prototype vs Singleton](#76-prototype-vs-singleton)
77. [Prototype vs Cloneable](#77-prototype-vs-cloneable)
78. [Prototype vs Copy Constructor](#78-prototype-vs-copy-constructor)
79. [Important Interview Questions](#79-important-interview-questions)
80. [Common Mistakes](#80-common-mistakes)
81. [Practice 1 — Game Character](#81-practice-1--game-character)
82. [Practice 2 — Document Registry](#82-practice-2--document-registry)
83. [Practice 3 — Final Notification System](#83-practice-3--final-notification-system)
84. [Final Prototype Mental Model](#84-final-prototype-mental-model)
85. [Final Prototype + Builder + Registry Architecture](#85-final-prototype--builder--registry-architecture)
86. [Prototype Design Pattern Checklist](#86-prototype-design-pattern-checklist)
87. [Final Summary](#87-final-summary)

---

## 1. What Is the Prototype Design Pattern?

Prototype is a **Creational Design Pattern**.

The Prototype Design Pattern allows us to create a new object by copying an existing object instead of creating the object completely from scratch. The existing object is called the **Prototype**.

```text
Existing Object
      │  copy()
      ▼
  New Object
```

> Build and configure an object once, then create new objects by copying it.

---

## 2. Why Do We Need Prototype?

Consider a game application. A `GameCharacter` may contain many properties: `name`, `health`, `attackPower`, `weapon`, `armor`, `skills`, `inventory`, `configuration`, `metadata`, etc.

Creating every character manually can become complicated:

```java
GameCharacter warrior = new GameCharacter(
        "Warrior", 100, 50, sword, armor, skills, inventory, configuration
);
```

Now imagine creating 100 warriors. We would repeatedly need to provide the same configuration. Prototype allows us to create one configured object and reuse it as a template.

```text
Create and configure one Warrior
            │
            ▼
    Warrior Prototype
      ├───┬───┬───┐
      ▼   ▼   ▼   ▼
     W1  W2  W3  W4
```

---

## 3. Prototype Is a Creational Design Pattern

```text
Design Patterns
├── Creational
├── Structural
└── Behavioral
```

Prototype belongs to Creational Design Patterns:

```text
Creational Design Patterns
├── Singleton
├── Factory
├── Abstract Factory
├── Builder
└── Prototype
```

The main concern of Prototype is:

> How can we efficiently create new objects by copying an existing object?

---

## 4. Normal Object Creation

```java
Warrior warrior = new Warrior("Warrior", 100, 50);
```

If we need another Warrior:

```java
Warrior warrior2 = new Warrior("Warrior", 100, 50);
```

The client is responsible for knowing how the Warrior is constructed.

```text
Client
   ├── new Warrior()
   ├── new Warrior()
   └── new Warrior()
```

The client knows the construction details.

---

## 5. Prototype-Based Object Creation

First create a prototype:

```java
Warrior warriorPrototype = new Warrior("Warrior", 100, 50);
```

Then create objects from the prototype:

```java
Warrior warrior1 = warriorPrototype.copy();
Warrior warrior2 = warriorPrototype.copy();
Warrior warrior3 = warriorPrototype.copy();
```

```text
Warrior Prototype
   ├── copy() → Warrior 1
   ├── copy() → Warrior 2
   └── copy() → Warrior 3
```

The client no longer needs to know all the construction details.

---

## 6. Prototype Mental Model

```text
Create once
     │
     ▼
Configure once
     │
     ▼
  Prototype
     ├── copy()
     ├── copy()
     └── copy()
     │
     ▼
Multiple similar objects
```

> Prototype = Build once, copy many times.

---

## 7. Important Prototype Terminology

**Prototype** — the existing object that acts as the template, e.g. `Warrior Prototype`.

**Copy** — the newly created object produced from the prototype, e.g. `Warrior 1`, `Warrior 2`, `Warrior 3`.

**Prototype Interface** — defines the copy operation:

```java
public interface Prototype<T> {

    T copy();
}
```

**Prototype Registry** — stores prototypes using keys:

```text
"warrior" → Warrior Prototype
"mage"    → Mage Prototype
"archer"  → Archer Prototype
```

---

## 8. Basic Prototype Workflow

```text
Create Prototype
       │
       ▼
Configure Prototype
       │
       ▼
 Store Prototype
       │
       ▼
 Request Copy
       │
       ▼
prototype.copy()
       │
       ▼
  New Object
```

With a Registry:

```text
Client
   │  key
   ▼
Prototype Registry
   │
   ▼
Find Prototype
   │
   ▼
  copy()
   │
   ▼
New Object
```

---

## 9. Object Copying

Prototype fundamentally revolves around copying objects.

```java
Warrior warriorPrototype = new Warrior("Warrior", 100, 50);
Warrior warrior = warriorPrototype.copy();
```

The new Warrior should contain the prototype's configuration, but it should be a different object. Therefore `warriorPrototype == warrior` must be `false`.

---

## 10. Shallow Copy

A shallow copy creates a new outer object but does not create independent copies of referenced objects.

```java
class Employee {

    String name;
    Address address;
}
```

**Original:**

```text
Employee 1
     └── Address
```

**After shallow copy:**

```text
Employee 1 ──┐
              ▼
           Address
              ▲
Employee 2 ──┘
```

Both Employee objects point to the same Address. Therefore `employee1.address == employee2.address` returns `true`.

---

## 11. Deep Copy

A deep copy creates a new outer object and also creates independent copies of nested mutable objects.

**Original:**

```text
Employee 1
     └── Address 1
```

**Copied object:**

```text
Employee 2
     └── Address 2
```

Therefore `employee1.address == employee2.address` returns `false`.

---

## 12. Shallow Copy vs Deep Copy

**Shallow Copy:**

```text
Original ──┐
            ▼
     Nested Object
            ▲
Copy ───────┘
```

The nested object is shared.

**Deep Copy:**

```text
Original ──► Nested Object 1
Copy     ──► Nested Object 2
```

The nested objects are independent.

---

## 13. Primitive Fields vs Reference Fields

```java
class Employee {

    String name;
    int age;
    Address address;
}
```

During a normal shallow clone, primitive values such as `int` are copied. Object references are copied as references.

```text
Original Employee
  name    → "Shivraj"
  age     → 27
  address → Address A

Copied Employee
  name    → "Shivraj"
  age     → 27
  address → Address A
```

The Employee objects are different, but both refer to `Address A`.

---

## 14. Java Cloneable

Java provides the `Cloneable` interface. `Cloneable` is a **marker interface** — it does not define a `clone()` method.

```java
public interface Cloneable {
}
```

Its purpose is to indicate that the object permits cloning through `Object.clone()`.

---

## 15. Object.clone()

The `clone()` method is defined in `java.lang.Object`.

```java
protected native Object clone() throws CloneNotSupportedException
```

Because it returns `Object`, we often cast it to the concrete type:

```java
return (Employee) super.clone();
```

---

## 16. Why super.clone()?

```java
class Employee implements Cloneable {
}
```

The inheritance relationship:

```text
Object
   │
   ▼
Employee
```

`clone()` comes from `Object`. Therefore `super.clone()` invokes the clone implementation from the parent class.

```text
Employee
   │  super.clone()
   ▼
Object.clone()
```

---

## 17. Basic Cloneable Example

**Location:** `designPatterns/src/prototype/part2/cloneablebasic/Employee.java`

```java
package prototype.part2.cloneablebasic;

public class Employee implements Cloneable {

    private String name;
    private String department;

    public Employee(String name, String department) {
        this.name = name;
        this.department = department;
    }

    @Override
    public Employee clone() {

        try {
            return (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", department='" + department + '\'' +
                '}';
    }
}
```

**Client location:** `designPatterns/src/prototype/part2/cloneablebasic/Client.java`

```java
package prototype.part2.cloneablebasic;

public class Client {

    public static void main(String[] args) {

        Employee employee1 = new Employee("Shivraj", "Engineering");
        Employee employee2 = employee1.clone();

        System.out.println(employee1);
        System.out.println(employee2);
        System.out.println(employee1 == employee2);
    }
}
```

Expected result:

```text
Employee{name='Shivraj', department='Engineering'}
Employee{name='Shivraj', department='Engineering'}
false
```

The two objects contain the same values but are different objects.

---

## 18. Why Do We Cast super.clone()?

`Object.clone()` returns `Object`:

```java
Object copy = super.clone();
```

But we want `Employee`. Therefore:

```java
Employee copy = (Employee) super.clone();
```

Or:

```java
return (Employee) super.clone();
```

---

## 19. CloneNotSupportedException

If a class does not implement `Cloneable`, calling `Object.clone()` can result in `CloneNotSupportedException`.

```java
public class Employee {

    public Employee clone() {

        try {
            return (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }
}
```

Since `Employee` does not implement `Cloneable`, cloning is not supported. Therefore `public class Employee implements Cloneable` is required when using the traditional `Object.clone()` mechanism.

---

## 20. Shallow Clone Example

**Location:** `designPatterns/src/prototype/part2/shallowclone/`

**Files:** `Address.java`, `Employee.java`, `Client.java`

**Address.java**

```java
package prototype.part2.shallowclone;

public class Address {

    String city;

    public Address(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Address{city='" + city + '\'' + '}';
    }
}
```

**Employee.java**

```java
package prototype.part2.shallowclone;

public class Employee implements Cloneable {

    String name;
    Address address;

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public Employee clone() {

        try {
            return (Employee) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + '\'' + ", address=" + address + '}';
    }
}
```

**Client.java**

```java
package prototype.part2.shallowclone;

public class Client {

    public static void main(String[] args) {

        Address address = new Address("Bangalore");
        Employee employee1 = new Employee("Shivraj", address);
        Employee employee2 = employee1.clone();

        System.out.println(employee1 == employee2);
        System.out.println(employee1.address == employee2.address);

        employee2.address.city = "Mumbai";

        System.out.println(employee1);
        System.out.println(employee2);
    }
}
```

Important output:

```text
false
true
```

The Employee objects are different, but the Address object is shared. Therefore changing `employee2.address` also affects `employee1.address`.

---

## 21. Deep Clone Example

**Location:** `designPatterns/src/prototype/part2/deepclone/`

**Files:** `Address.java`, `Employee.java`, `Client.java`

**Address.java**

```java
package prototype.part2.deepclone;

public class Address implements Cloneable {

    String city;

    public Address(String city) {
        this.city = city;
    }

    @Override
    public Address clone() {

        try {
            return (Address) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "Address{city='" + city + '\'' + '}';
    }
}
```

**Employee.java**

```java
package prototype.part2.deepclone;

public class Employee implements Cloneable {

    String name;
    Address address;

    public Employee(String name, Address address) {
        this.name = name;
        this.address = address;
    }

    @Override
    public Employee clone() {

        try {
            Employee copy = (Employee) super.clone();
            copy.address = this.address.clone();
            return copy;

        } catch (CloneNotSupportedException e) {
            throw new AssertionError(e);
        }
    }

    @Override
    public String toString() {
        return "Employee{name='" + name + '\'' + ", address=" + address + '}';
    }
}
```

**Client.java**

```java
package prototype.part2.deepclone;

public class Client {

    public static void main(String[] args) {

        Address address = new Address("Bangalore");
        Employee employee1 = new Employee("Shivraj", address);
        Employee employee2 = employee1.clone();

        System.out.println(employee1 == employee2);
        System.out.println(employee1.address == employee2.address);

        employee2.address.city = "Mumbai";

        System.out.println(employee1);
        System.out.println(employee2);
    }
}
```

Important output:

```text
false
false
```

Now both the outer object and nested Address object are independent.

---

## 22. Prototype Does Not Require Cloneable

Prototype is a Design Pattern. `Cloneable` is a Java mechanism. They are not the same thing.

Prototype can be implemented without `Cloneable`:

```java
public interface Prototype<T> {

    T copy();
}
```

```java
public class Warrior implements Prototype<Warrior> {

    private String name;
    private int health;
    private int attackPower;

    public Warrior(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    @Override
    public Warrior copy() {
        return new Warrior(this.name, this.health, this.attackPower);
    }
}
```

This approach makes the copying operation explicit.

---

## 23. Copy Constructor

Prototype-like copying can also be implemented using a Copy Constructor.

```java
public class Warrior {

    private String name;
    private int health;
    private int attackPower;

    public Warrior(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }

    public Warrior(Warrior other) {
        this.name = other.name;
        this.health = other.health;
        this.attackPower = other.attackPower;
    }
}
```

Usage:

```java
Warrior warrior1 = new Warrior("Warrior", 100, 50);
Warrior warrior2 = new Warrior(warrior1);
```

```text
Existing Warrior
      │  copy constructor
      ▼
   New Warrior
```

---

## 24. Copy Constructor With Nested Object

Suppose Warrior contains Weapon.

```java
public class Warrior {

    private String name;
    private Weapon weapon;

    public Warrior(String name, Weapon weapon) {
        this.name = name;
        this.weapon = weapon;
    }

    public Warrior(Warrior other) {
        this.name = other.name;
        this.weapon = new Weapon(other.weapon);
    }
}
```

`new Weapon(other.weapon)` creates an independent Weapon. Therefore it can implement deep copying.

---

## 25. Copy Factory Method

Another approach is a static copy factory.

```java
public class Warrior {

    private String name;
    private int health;

    public Warrior(String name, int health) {
        this.name = name;
        this.health = health;
    }

    public static Warrior copyOf(Warrior other) {
        return new Warrior(other.name, other.health);
    }
}
```

Usage:

```java
Warrior warrior2 = Warrior.copyOf(warrior1);
```

---

## 26. Generic Prototype Interface

For our LLD implementation, we can use:

```java
public interface Prototype<T> {

    T copy();
}
```

The generic type makes the return type explicit:

```java
public class Warrior implements Prototype<Warrior> {

    @Override
    public Warrior copy() {
        ...
    }
}
```

```java
public class Mage implements Prototype<Mage> {

    @Override
    public Mage copy() {
        ...
    }
}
```

This avoids unnecessary casting in the individual Prototype classes.

---

## 27. Comparison of Copying Approaches

Common approaches: `Cloneable + clone()`, Copy Constructor, Copy Factory Method, `Prototype<T> + copy()`.

| Approach | Advantages | Disadvantages |
|---|---|---|
| **Cloneable** | Java-supported mechanism | Clone API is awkward |
| **Copy Constructor** | Explicit and readable | Must manually implement |
| **Copy Factory** | Flexible API | Convention based |
| **Prototype\<T\>** | Clear design-pattern abstraction | Requires explicit implementation |

For our LLD learning, `Prototype<T>` with `copy()` is very clear because the intention is explicit.

---

## 28. Game Character Example

**Location:** `designPatterns/src/prototype/part1/`

```text
Prototype<GameCharacter>
         │
         ▼
   GameCharacter
     ├────┴────┐
     ▼         ▼
  Warrior     Mage
```

The goal is to create similar game characters by copying configured prototypes.

---

## 29. GameCharacter

```java
public abstract class GameCharacter implements Prototype<GameCharacter> {

    protected String name;
    protected int health;
    protected int attackPower;

    protected GameCharacter(String name, int health, int attackPower) {
        this.name = name;
        this.health = health;
        this.attackPower = attackPower;
    }
}
```

---

## 30. Warrior

```java
public class Warrior extends GameCharacter {

    public Warrior(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public Warrior copy() {
        return new Warrior(this.name, this.health, this.attackPower);
    }
}
```

The copy operation creates a new Warrior using the current Warrior's configuration.

---

## 31. Mage

```java
public class Mage extends GameCharacter {

    public Mage(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }

    @Override
    public Mage copy() {
        return new Mage(this.name, this.health, this.attackPower);
    }
}
```

---

## 32. Game Character Workflow

```text
Warrior Prototype
      │  copy()
   ┌──┼──┐
   ▼  ▼  ▼
  W1  W2  W3
```

```java
Warrior warriorPrototype = new Warrior("Warrior", 100, 50);

Warrior warrior1 = warriorPrototype.copy();
Warrior warrior2 = warriorPrototype.copy();
```

---

## 33. Prototype Independence

```java
Warrior prototype = new Warrior("Warrior", 100, 50);
Warrior warrior1 = prototype.copy();
```

If `warrior1` is modified:

```java
warrior1.health = 50;
```

the prototype should still have `health = 100`. This is one of the important goals of Prototype.

---

## 34. Document Template Example

Prototype is useful for document templates.

```text
Document
├── Invoice
└── Resume
```

We can create a template once and copy it whenever required.

```text
Invoice Template
├── Invoice #1001
├── Invoice #1002
└── Invoice #1003
```

---

## 35. Document Prototype Interface

**Location:** `designPatterns/src/prototype/part3/practice/Prototype.java`

```java
package prototype.part3.practice;

public interface Prototype<T> {

    T copy();
}
```

---

## 36. Document

**Location:** `designPatterns/src/prototype/part3/practice/Document.java`

```java
package prototype.part3.practice;

public abstract class Document implements Prototype<Document> {

    protected String title;
    protected String content;
    protected String author;

    protected Document(String title, String content, String author) {
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
```

---

## 37. Invoice

**Location:** `designPatterns/src/prototype/part3/practice/Invoice.java`

```java
package prototype.part3.practice;

public class Invoice extends Document {

    public Invoice(String title, String content, String author) {
        super(title, content, author);
    }

    @Override
    public Invoice copy() {
        return new Invoice(this.title, this.content, this.author);
    }
}
```

---

## 38. Resume

**Location:** `designPatterns/src/prototype/part3/practice/Resume.java`

```java
package prototype.part3.practice;

public class Resume extends Document {

    public Resume(String title, String content, String author) {
        super(title, content, author);
    }

    @Override
    public Resume copy() {
        return new Resume(this.title, this.content, this.author);
    }
}
```

---

## 39. Prototype Registry

When we have many prototypes, manually managing every prototype can become inconvenient.

```text
Warrior, Mage, Archer, Tank, Healer, Boss
```

We could maintain separate references for each, but the client needs to know all these objects. A Prototype Registry solves this.

---

## 40. Registry Concept

The Registry stores prototypes using keys.

| Key | Prototype |
|---|---|
| `warrior` | Warrior Prototype |
| `mage` | Mage Prototype |
| `archer` | Archer Prototype |

The client can request `registry.get("warrior");`. The Registry finds the prototype and creates a copy.

---

## 41. Registry Architecture

```text
Prototype Registry
   ├── warrior prototype
   ├── mage prototype
   └── archer prototype
```

When the client calls `registry.get("warrior");`, the flow is:

```text
Client
   │
   ▼
Registry
   │
   ▼
"warrior"
   │
   ▼
Warrior Prototype
   │  copy()
   ▼
New Warrior
```

---

## 42. Why Registry Should Return a Copy

Suppose Registry returns the prototype itself:

```text
Registry ──► Warrior Prototype ◄── Client
```

The client can modify the prototype. This is dangerous because future copies would start from the modified state. Instead:

```text
Registry ──► Warrior Prototype ──copy()──► Warrior Instance
```

The prototype remains protected.

---

## 43. Basic Registry

**Location:** `designPatterns/src/prototype/part3/registry/PrototypeRegistry.java`

```java
package prototype.part3.registry;

import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistry {

    private final Map<String, Prototype<?>> prototypes = new HashMap<>();

    public void register(String key, Prototype<?> prototype) {
        prototypes.put(key, prototype);
    }

    public Prototype<?> get(String key) {

        Prototype<?> prototype = prototypes.get(key);

        if (prototype == null) {
            throw new IllegalArgumentException("Prototype not found: " + key);
        }

        return prototype;
    }

    public void remove(String key) {
        prototypes.remove(key);
    }

    public boolean contains(String key) {
        return prototypes.containsKey(key);
    }
}
```

This version returns the stored prototype itself. For a proper Prototype Registry, we normally want `get()` to return a copy.

---

## 44. Registry That Returns Copies

A better implementation:

```java
package prototype.part3.registry;

import java.util.HashMap;
import java.util.Map;

public class PrototypeRegistry {

    private final Map<String, Prototype<?>> prototypes = new HashMap<>();

    public void register(String key, Prototype<?> prototype) {
        prototypes.put(key, prototype);
    }

    @SuppressWarnings("unchecked")
    public <T> T get(String key) {

        Prototype<?> prototype = prototypes.get(key);

        if (prototype == null) {
            throw new IllegalArgumentException("Prototype not found: " + key);
        }

        return (T) prototype.copy();
    }

    public void remove(String key) {
        prototypes.remove(key);
    }

    public boolean contains(String key) {
        return prototypes.containsKey(key);
    }
}
```

The most important line: `return (T) prototype.copy();`. The Registry returns a new object.

---

## 45. Registry Operations

A Prototype Registry commonly provides:

**register()**

```java
registry.register("warrior", warriorPrototype);
```

**get()**

```java
Warrior warrior = registry.get("warrior");
```

**remove()**

```java
registry.remove("warrior");
```

**contains()**

```java
registry.contains("warrior");
```

---

## 46. Document Registry

**Location:** `designPatterns/src/prototype/part3/practice/DocumentRegistry.java`

```java
package prototype.part3.practice;

import java.util.HashMap;
import java.util.Map;

public class DocumentRegistry {

    private final Map<String, Document> prototypes = new HashMap<>();

    public void register(String key, Document prototype) {
        prototypes.put(key, prototype);
    }

    public Document get(String key) {

        Document prototype = prototypes.get(key);

        if (prototype == null) {
            throw new IllegalArgumentException("Prototype not found: " + key);
        }

        return prototype.copy();
    }

    public void remove(String key) {
        prototypes.remove(key);
    }

    public boolean contains(String key) {
        return prototypes.containsKey(key);
    }
}
```

---

## 47. Document Registry Client

**Location:** `designPatterns/src/prototype/part3/practice/Client.java`

```java
package prototype.part3.practice;

public class Client {

    public static void main(String[] args) {

        DocumentRegistry registry = new DocumentRegistry();

        Invoice invoicePrototype = new Invoice("Invoice Template", "Invoice Content", "Company");
        Resume resumePrototype = new Resume("Resume Template", "Resume Content", "Shivraj");

        registry.register("invoice", invoicePrototype);
        registry.register("resume", resumePrototype);

        Invoice invoice1 = (Invoice) registry.get("invoice");
        Invoice invoice2 = (Invoice) registry.get("invoice");
        Resume resume1 = (Resume) registry.get("resume");

        invoice1.setTitle("Invoice #1001");
        invoice2.setTitle("Invoice #1002");
        resume1.setTitle("Shivraj Resume");

        System.out.println("Invoice Prototype: " + invoicePrototype);
        System.out.println("Invoice 1: " + invoice1);
        System.out.println("Invoice 2: " + invoice2);
        System.out.println("Resume Prototype: " + resumePrototype);
        System.out.println("Resume 1: " + resume1);
    }
}
```

---

## 48. Prototype Registry vs Factory

This is a very important distinction.

Factory contains object creation logic:

```text
Factory
├── warrior → new Warrior()
├── mage    → new Mage()
└── archer  → new Archer()
```

Prototype Registry stores already-created prototype objects:

```text
Registry
├── warrior → Warrior Prototype
├── mage    → Mage Prototype
└── archer  → Archer Prototype
```

Then: `Registry ──copy()──► New Object`

---

## 49. Factory vs Prototype

Factory asks: *"How should I construct this object?"*

Prototype asks: *"Can I give you another object like this existing object?"*

```text
Factory
   │
   ▼
Construct object

Prototype
   │
   ▼
Existing Prototype ──copy()──► New object
```

---

## 50. Factory vs Prototype Registry Example

**Factory:**

```java
if (type.equals("dragon")) {
    return new Dragon(...);
}
```

The Factory contains construction logic.

**Prototype Registry:**

```java
registry.register("dragon", dragonPrototype);
```

Then:

```java
Dragon dragon = registry.get("dragon");
```

The Registry does not need to know how Dragon was originally constructed.

---

## 51. Prototype + Builder

Prototype and Builder can work together.

- **Builder** answers: *how do I construct a complex object?*
- **Prototype** answers: *how do I copy an existing configured object?*
- **Registry** answers: *where do I store and retrieve prototypes?*

```text
Builder
   │
   ▼
Fully Configured Object
   │
   ▼
Prototype
   │
   ▼
Prototype Registry
   ├── copy() → Obj 1
   ├── copy() → Obj 2
   └── copy() → Obj 3
```

```java
Warrior warriorPrototype = new Warrior.Builder()
        .health(100)
        .attackPower(50)
        .build();

registry.register("warrior", warriorPrototype);
```

Then:

```java
Warrior w1 = registry.get("warrior");
Warrior w2 = registry.get("warrior");
Warrior w3 = registry.get("warrior");
```

---

## 52. Responsibilities of Builder, Prototype and Registry

```text
Builder  → Construct complex object
Prototype → Copy existing object
Registry  → Store and retrieve prototypes
```

Together:

```text
Builder
   │
   ▼
Configured Prototype
   │
   ▼
Registry
   ├── copy()
   ├── copy()
   └── copy()
```

---

## 53. Final LLD — Notification Template System

The final practice system is a Notification Template System. It supports Email, SMS, Push Notification. Each notification contains `recipient`, `message`, `priority`, `metadata`.

We create prototype templates:

```text
Email Prototype
├── Email 1
├── Email 2
└── Email 3

SMS Prototype
├── SMS 1
└── SMS 2

Push Prototype
└── Push 1
```

Registry:

```text
"email" → Email Prototype
"sms"   → SMS Prototype
"push"  → Push Prototype
```

---

## 54. Final Project Structure

**Project root:** `designPatterns`

Prototype structure:

```text
src/
└── prototype/
    ├── part1/
    ├── part2/
    │   ├── cloneablebasic/
    │   ├── shallowclone/
    │   └── deepclone/
    │
    ├── part3/
    │   ├── basic/
    │   ├── registry/
    │   └── practice/
    │
    └── part4/
        └── finalpractice/
```

---

## 55. Final Practice Files

**Location:** `designPatterns/src/prototype/part4/finalpractice/`

```text
Prototype.java
NotificationMetadata.java
Notification.java
EmailNotification.java
SmsNotification.java
PushNotification.java
NotificationRegistry.java
Client.java
```

---

## 56. Prototype.java

```java
package prototype.part4.finalpractice;

public interface Prototype<T> {

    T copy();
}
```

---

## 57. NotificationMetadata.java

```java
package prototype.part4.finalpractice;

import java.util.HashMap;
import java.util.Map;

public class NotificationMetadata implements Prototype<NotificationMetadata> {

    private Map<String, String> data;

    public NotificationMetadata() {
        this.data = new HashMap<>();
    }

    public NotificationMetadata(Map<String, String> data) {
        this.data = new HashMap<>(data);
    }

    public void put(String key, String value) {
        data.put(key, value);
    }

    public String get(String key) {
        return data.get(key);
    }

    @Override
    public NotificationMetadata copy() {
        return new NotificationMetadata(this.data);
    }

    @Override
    public String toString() {
        return data.toString();
    }
}
```

Important: `this.data = new HashMap<>(data);` creates a new Map. Therefore the copied metadata does not share the same Map instance.

---

## 58. Notification.java

```java
package prototype.part4.finalpractice;

public abstract class Notification implements Prototype<Notification> {

    protected String recipient;
    protected String message;
    protected int priority;
    protected NotificationMetadata metadata;

    protected Notification(String recipient, String message, int priority, NotificationMetadata metadata) {
        this.recipient = recipient;
        this.message = message;
        this.priority = priority;
        this.metadata = metadata;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public void addMetadata(String key, String value) {
        metadata.put(key, value);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() +
                "{recipient='" + recipient + '\'' +
                ", message='" + message + '\'' +
                ", priority=" + priority +
                ", metadata=" + metadata +
                '}';
    }
}
```

---

## 59. EmailNotification.java

```java
package prototype.part4.finalpractice;

public class EmailNotification extends Notification {

    private String subject;

    public EmailNotification(
            String recipient,
            String message,
            int priority,
            NotificationMetadata metadata,
            String subject) {

        super(recipient, message, priority, metadata);
        this.subject = subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public EmailNotification copy() {

        return new EmailNotification(
                this.recipient,
                this.message,
                this.priority,
                this.metadata.copy(),
                this.subject
        );
    }
}
```

Important: `this.metadata.copy()` — this ensures that metadata is also copied.

---

## 60. SmsNotification.java

```java
package prototype.part4.finalpractice;

public class SmsNotification extends Notification {

    private String senderId;

    public SmsNotification(
            String recipient,
            String message,
            int priority,
            NotificationMetadata metadata,
            String senderId) {

        super(recipient, message, priority, metadata);
        this.senderId = senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    @Override
    public SmsNotification copy() {

        return new SmsNotification(
                this.recipient,
                this.message,
                this.priority,
                this.metadata.copy(),
                this.senderId
        );
    }
}
```

---

## 61. PushNotification.java

```java
package prototype.part4.finalpractice;

public class PushNotification extends Notification {

    private String deviceToken;

    public PushNotification(
            String recipient,
            String message,
            int priority,
            NotificationMetadata metadata,
            String deviceToken) {

        super(recipient, message, priority, metadata);
        this.deviceToken = deviceToken;
    }

    public void setDeviceToken(String deviceToken) {
        this.deviceToken = deviceToken;
    }

    @Override
    public PushNotification copy() {

        return new PushNotification(
                this.recipient,
                this.message,
                this.priority,
                this.metadata.copy(),
                this.deviceToken
        );
    }
}
```

---

## 62. NotificationRegistry.java

```java
package prototype.part4.finalpractice;

import java.util.HashMap;
import java.util.Map;

public class NotificationRegistry {

    private final Map<String, Notification> prototypes = new HashMap<>();

    public void register(String key, Notification prototype) {
        prototypes.put(key, prototype);
    }

    public Notification get(String key) {

        Notification prototype = prototypes.get(key);

        if (prototype == null) {
            throw new IllegalArgumentException("Prototype not found: " + key);
        }

        return prototype.copy();
    }

    public void remove(String key) {
        prototypes.remove(key);
    }

    public boolean contains(String key) {
        return prototypes.containsKey(key);
    }
}
```

The critical operation: `return prototype.copy();`

---

## 63. Client.java

```java
package prototype.part4.finalpractice;

public class Client {

    public static void main(String[] args) {

        NotificationRegistry registry = new NotificationRegistry();

        NotificationMetadata emailMetadata = new NotificationMetadata();
        emailMetadata.put("category", "transactional");
        emailMetadata.put("application", "banking");

        EmailNotification emailPrototype = new EmailNotification(
                "default@email.com", "Default email message", 1, emailMetadata, "Default Subject"
        );

        NotificationMetadata smsMetadata = new NotificationMetadata();
        smsMetadata.put("category", "transactional");

        SmsNotification smsPrototype = new SmsNotification(
                "9999999999", "Default SMS message", 2, smsMetadata, "BANK"
        );

        NotificationMetadata pushMetadata = new NotificationMetadata();
        pushMetadata.put("category", "marketing");

        PushNotification pushPrototype = new PushNotification(
                "user123", "Default push message", 3, pushMetadata, "device-token-123"
        );

        registry.register("email", emailPrototype);
        registry.register("sms", smsPrototype);
        registry.register("push", pushPrototype);

        EmailNotification email1 = (EmailNotification) registry.get("email");
        EmailNotification email2 = (EmailNotification) registry.get("email");
        SmsNotification sms1 = (SmsNotification) registry.get("sms");
        PushNotification push1 = (PushNotification) registry.get("push");

        email1.setRecipient("shivraj@example.com");
        email1.setSubject("Your payment was successful");
        email1.addMetadata("transactionId", "TXN-1001");

        email2.setRecipient("rahul@example.com");
        email2.setSubject("Your payment was successful");

        sms1.setRecipient("9876543210");
        push1.setMessage("You have a new notification");

        System.out.println("===== PROTOTYPES =====");
        System.out.println(emailPrototype);
        System.out.println(smsPrototype);
        System.out.println(pushPrototype);

        System.out.println();

        System.out.println("===== COPIES =====");
        System.out.println(email1);
        System.out.println(email2);
        System.out.println(sms1);
        System.out.println(push1);
    }
}
```

---

## 64. Final Deep Copy Verification

```java
email1 == emailPrototype
```
Result: `false` (different objects).

```java
email2 == emailPrototype
```
Result: `false`.

```java
email1.metadata == emailPrototype.metadata
```
Result: `false`. Therefore the nested metadata is also independently copied.

---

## 65. Final Object Graph

**Prototype:**

```text
Email Prototype
      └── Metadata 1
```

**Copy:**

```text
Email Copy
      └── Metadata 2
```

There is no shared mutable metadata.

---

## 66. Why Not Just Use new?

Suppose `EmailNotification` eventually contains `recipient`, `message`, `priority`, `subject`, `template`, `metadata`, `attachments`, `headers`, tracking settings, retry settings, localization, security settings, configuration, etc.

Creating every object manually could become cumbersome. Instead:

```text
Build/configure once
        │
        ▼
  Email Prototype
   ├── copy()
   ├── copy()
   └── copy()
```

---

## 67. Complete Prototype Workflow

```text
Client
   │
   ▼
Need New Object
   │
   ▼
Existing Prototype
   │
   ▼
  copy()
   │
   ▼
New Object
```

With Registry:

```text
Client
   │  key
   ▼
Prototype Registry
   │
   ▼
Find Prototype
   │
   ▼
  copy()
   │
   ▼
New Object
```

---

## 68. Complete Prototype Architecture

```text
Client
   │  get("warrior")
   ▼
┌────────────────────┐
│ Prototype Registry  │
└────────────────────┘
   ├────────────┐
   ▼            ▼
Warrior       Mage
Prototype     Prototype
   │            │
 copy()       copy()
   │            │
   ▼            ▼
Warrior 1     Mage 1
```

---

## 69. Generic Registry

A generic Registry may use:

```java
Map<String, Prototype<?>> prototypes = new HashMap<>();
```

The Registry can return:

```java
@SuppressWarnings("unchecked")
public <T> T get(String key) {

    Prototype<?> prototype = prototypes.get(key);

    if (prototype == null) {
        throw new IllegalArgumentException("Prototype not found: " + key);
    }

    return (T) prototype.copy();
}
```

This provides convenient usage:

```java
Warrior warrior = registry.get("warrior");
```

However, this approach uses an unchecked cast.

---

## 70. Type-Safety Consideration

Suppose:

```java
Warrior warrior = registry.get("mage");
```

The Registry cannot necessarily prevent this at compile time if it uses a generic unchecked return. It could eventually cause a `ClassCastException`. Therefore in production systems, Registry APIs should be designed carefully. Possible approaches include typed keys, class-based keys, generic registry methods, and explicit type validation.

> Convenience should not come at the cost of type safety.

---

## 71. Advantages of Prototype

**71.1 Avoid Repeated Complex Construction.** If object construction is complicated, copying an existing object can be easier.

**71.2 Reuse Existing Configuration.** The prototype already contains the desired configuration.

**71.3 Reduce Client Knowledge.** The client does not need to know all construction details.

**71.4 Runtime Flexibility.** Prototypes can be registered dynamically:

```java
registry.register("special-warrior", specialWarriorPrototype);
```

**71.5 Efficient Creation of Similar Objects.** One configured object can be used to create many similar objects.

---

## 72. Disadvantages of Prototype

**72.1 Deep Copy Can Be Difficult.** Nested mutable objects must be copied correctly.

**72.2 Shared References Can Cause Bugs.** If nested objects are accidentally shared, modifying one object can affect another.

**72.3 Circular References.** Consider `A → B, B → A`. Naive recursive deep copying can become complicated.

**72.4 Cloneable Has Problems.** Java `Cloneable` has several awkward aspects: marker interface, `clone()` is defined in `Object`, `clone()` is protected, `CloneNotSupportedException`, default shallow-copy behavior, inheritance complexity.

**72.5 Prototype Can Be Overengineering.** If object creation is simple, Prototype may add unnecessary complexity.

---

## 73. When Should We Use Prototype?

Prototype is useful when:

```text
Object construction is expensive
   OR
Object configuration is complex
   OR
Many similar objects are required
   OR
Runtime templates are needed
   OR
Existing configuration should be reused
   OR
Construction logic should not be repeated
```

Typical examples: game characters, game objects, document templates, email templates, SMS templates, report templates, UI components, workflow templates, configuration objects, query templates.

---

## 74. When Should We Not Use Prototype?

Do not use Prototype simply because it is a design pattern.

```java
User user = new User("Shivraj");
```

If object construction is this simple, Prototype may provide no meaningful benefit. Use Prototype when copying provides real value.

---

## 75. Prototype vs Builder

```text
Builder
   │
   ▼
Complex Object

Prototype
   │
   ▼
Existing Object ──copy()──► New Object
```

Builder focuses on construction. Prototype focuses on copying. They can be combined.

---

## 76. Prototype vs Singleton

**Singleton:** ensures that a class has one shared instance.

```text
Client ──► Single Shared Instance
```

**Prototype:** creates new objects by copying an existing object.

```text
Client
   │
   ▼
Prototype
   ├── copy()
   ├── copy()
   └── copy()
```

They solve completely different problems.

---

## 77. Prototype vs Cloneable

**Prototype** — Design Pattern.

**Cloneable** — Java Interface / Mechanism.

Prototype can be implemented using Cloneable, Copy Constructor, Copy Factory Method, or an explicit `copy()` method. Therefore:

> Cloneable is one possible implementation technique, not the Prototype Design Pattern itself.

---

## 78. Prototype vs Copy Constructor

**Prototype:**

```java
existingObject.copy();
```

**Copy Constructor:**

```java
new Object(existingObject);
```

Both can create copies. Prototype makes copying behavior explicit through an abstraction.

---

## 79. Important Interview Questions

**Q1. What is Prototype?**
Prototype is a Creational Design Pattern that creates new objects by copying existing objects instead of constructing them from scratch.

**Q2. Why is Prototype useful?**
It is useful when object creation is expensive, complex, or highly configurable.

**Q3. What is shallow copy?**
A shallow copy creates a new outer object but shares nested referenced objects.

**Q4. What is deep copy?**
A deep copy creates independent copies of nested mutable objects.

**Q5. What is Cloneable?**
`Cloneable` is a Java marker interface that indicates an object can be cloned using `Object.clone()`.

**Q6. Does Cloneable contain clone()?**
No. `Cloneable` is only a marker interface.

**Q7. Where is clone() defined?**
`clone()` is defined in `Object`.

**Q8. Why use super.clone()?**
Because the cloning implementation comes from `Object`.

**Q9. Why do we cast super.clone()?**
Because `Object.clone()` returns `Object`.

**Q10. Is Object.clone() deep copy?**
No. Its default behavior is effectively a shallow field-level copy.

**Q11. How do we implement deep cloning?**
Explicitly copy nested mutable objects.

**Q12. Can Prototype be implemented without Cloneable?**
Yes, e.g. `public interface Prototype<T> { T copy(); }`.

**Q13. What is Prototype Registry?**
A Registry stores prototypes under keys and creates copies from those prototypes.

**Q14. Why should Registry return a copy?**
To prevent clients from modifying the stored prototype.

**Q15. Prototype Registry vs Factory?**
Factory contains object construction logic. Prototype Registry stores configured prototype objects and copies them.

**Q16. Can Prototype and Builder be combined?**
Yes — Builder can construct the initial complex object, while Prototype can copy it.

---

## 80. Common Mistakes

**Mistake 1 — Returning Prototype Directly**

Wrong:

```java
public Notification get(String key) {
    return prototypes.get(key);
}
```

This exposes the prototype. Better:

```java
public Notification get(String key) {

    Notification prototype = prototypes.get(key);
    return prototype.copy();
}
```

**Mistake 2 — Forgetting Deep Copy**

Wrong:

```java
return new EmailNotification(
        this.recipient, this.message, this.priority, this.metadata, this.subject
);
```

This shares the metadata object. Better:

```java
return new EmailNotification(
        this.recipient, this.message, this.priority, this.metadata.copy(), this.subject
);
```

**Mistake 3 — Assuming Cloneable Provides clone()**

`Cloneable` does not define `clone()`. The clone method comes from `Object`. `Cloneable` only indicates that cloning is supported.

**Mistake 4 — Confusing Prototype With Factory**

```text
Factory   → Construct
Prototype → Copy
```

**Mistake 5 — Using Prototype Everywhere**

Prototype should not be used for every object. If construction is trivial (`new User("Shivraj")`), using Prototype may add unnecessary complexity.

---

## 81. Practice 1 — Game Character

**Location:** `designPatterns/src/prototype/part1/practice/`

**Create:** `Prototype.java`, `GameCharacter.java`, `Warrior.java`, `Mage.java`, `Client.java`

**Requirements:**

1. Create `Prototype<T>`.
2. Create `GameCharacter`.
3. Create `Warrior`.
4. Create `Mage`.
5. Implement `copy()`.
6. Create a Warrior prototype.
7. Create multiple Warriors from it.
8. Modify one Warrior.
9. Prove the prototype remains unchanged.
10. Prove the copies are separate objects.

---

## 82. Practice 2 — Document Registry

**Location:** `designPatterns/src/prototype/part3/practice/`

**Create:** `Prototype.java`, `Document.java`, `Invoice.java`, `Resume.java`, `DocumentRegistry.java`, `Client.java`

**Requirements:**

1. Create `Prototype<T>`.
2. Create abstract `Document`.
3. Create `Invoice`.
4. Create `Resume`.
5. Implement `copy()`.
6. Create `DocumentRegistry`.
7. Implement `register()`.
8. Implement `get()`.
9. Implement `remove()`.
10. Implement `contains()`.
11. Store prototypes.
12. Return copies.
13. Modify copies.
14. Prove prototypes remain unchanged.

---

## 83. Practice 3 — Final Notification System

**Location:** `designPatterns/src/prototype/part4/finalpractice/`

**Create:** `Prototype.java`, `NotificationMetadata.java`, `Notification.java`, `EmailNotification.java`, `SmsNotification.java`, `PushNotification.java`, `NotificationRegistry.java`, `Client.java`

**Requirements:**

1. Create `Prototype<T>`.
2. Create `NotificationMetadata`.
3. Create `Notification`.
4. Create `EmailNotification`.
5. Create `SmsNotification`.
6. Create `PushNotification`.
7. Implement `copy()`.
8. Implement deep copying.
9. Create `NotificationRegistry`.
10. Register prototypes.
11. Retrieve copies.
12. Modify copies.
13. Prove prototypes are unchanged.
14. Prove metadata is also copied.
15. Verify object identity using `==`.

---

## 84. Final Prototype Mental Model

```text
Complex Object
      │
      ▼
Configure Once
      │
      ▼
   Prototype
      │
  ┌───┼───┐
  ▼   ▼   ▼
copy() copy() copy()
  │   │   │
  ▼   ▼   ▼
Obj 1 Obj 2 Obj 3
```

With Registry:

```text
Client
   │  key
   ▼
Prototype Registry
   │
   ▼
Prototype
   │
 copy()
   │
   ▼
New Object
```

---

## 85. Final Prototype + Builder + Registry Architecture

```text
Builder
   │
   ▼
Complex Configuration
   │
   ▼
Prototype
   │
   ▼
Prototype Registry
   ├── copy() → Obj 1
   ├── copy() → Obj 2
   └── copy() → Obj 3
```

Responsibilities:

```text
Builder   → Construct
Prototype → Copy
Registry  → Store and retrieve
```

---

## 86. Prototype Design Pattern Checklist

**Fundamentals**

- [x] What is Prototype?
- [x] Why Prototype is needed
- [x] Prototype as a Creational Pattern
- [x] Normal creation vs Prototype
- [x] Prototype terminology
- [x] Prototype workflow
- [x] Prototype mental model

**Object Copying**

- [x] Object copying
- [x] Shallow Copy
- [x] Deep Copy
- [x] Primitive fields
- [x] Reference fields
- [x] Nested objects
- [x] Shared references
- [x] Independent references

**Java Cloneable**

- [x] Cloneable
- [x] Marker interface
- [x] `Object.clone()`
- [x] `super.clone()`
- [x] Casting
- [x] `CloneNotSupportedException`
- [x] Shallow cloning
- [x] Deep cloning

**Alternative Implementations**

- [x] Copy Constructor
- [x] Copy Factory Method
- [x] `Prototype<T>`
- [x] `copy()`

**Examples**

- [x] Game Character
- [x] Warrior
- [x] Mage
- [x] Document
- [x] Invoice
- [x] Resume
- [x] Notification
- [x] Email
- [x] SMS
- [x] Push

**Registry**

- [x] Registry concept
- [x] `register()`
- [x] `get()`
- [x] `remove()`
- [x] `contains()`
- [x] Registry stores prototypes
- [x] Registry returns copies
- [x] Generic Registry
- [x] Type-safety considerations

**Pattern Relationships**

- [x] Prototype vs Factory
- [x] Prototype vs Builder
- [x] Prototype vs Singleton
- [x] Prototype vs Cloneable
- [x] Prototype vs Copy Constructor
- [x] Prototype + Builder
- [x] Prototype + Registry

**LLD**

- [x] Final Notification System
- [x] Email Notification
- [x] SMS Notification
- [x] Push Notification
- [x] Metadata
- [x] Deep Copy
- [x] Registry
- [x] Multiple Prototypes
- [x] Client
- [x] Object identity verification

**Interview Preparation**

- [x] Advantages
- [x] Disadvantages
- [x] When to use
- [x] When not to use
- [x] Common mistakes
- [x] Interview questions

---

## 87. Final Summary

Prototype is a Creational Design Pattern. Its core idea is:

```text
Create a configured object
        │
        ▼
Use it as a Prototype
        │
        ▼
Copy it whenever needed
```

Important concepts:

```text
Prototype → copy() → New Object
```

When using nested mutable objects, understand the difference between:

```text
Shallow Copy → Shared nested objects
Deep Copy    → Independent nested objects
```

Java provides `Cloneable` and `Object.clone()`, but Prototype does not require `Cloneable`. A cleaner explicit approach is often:

```java
public interface Prototype<T> {

    T copy();
}
```

For multiple prototypes, use a Registry:

```text
Registry
├── "warrior" → Warrior Prototype
├── "mage"    → Mage Prototype
└── "archer"  → Archer Prototype
```

Then:

```text
registry.get("warrior")
        │
        ▼
Warrior Prototype
        │
      copy()
        │
        ▼
   New Warrior
```

The most important distinction to remember:

```text
Factory   → Creates using construction logic.
Builder   → Builds complex objects.
Prototype → Copies existing objects.
Registry  → Stores and retrieves prototypes.
Singleton → Ensures a single shared instance.
```

Final mental model:

```text
BUILD ONCE
    │
    ▼
PROTOTYPE
    │
    ▼
COPY MANY TIMES
    │
    ▼
INDEPENDENT OBJECTS
```

---

*End of Prototype Design Pattern Documentation*