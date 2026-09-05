# Liskov Substitution Principle (LSP)

**SOLID Principle #3**

> Objects of a superclass should be replaceable with objects of a subclass without affecting the correctness of the program.

LSP was introduced by Barbara Liskov.

The simplest way to understand LSP is:

> If `Child` extends or implements `Parent`, then wherever the program expects `Parent`, we should be able to provide `Child` without breaking the expected behavior.

---

## Table of Contents

1. [What is LSP?](#1-what-is-lsp)
2. [Simple Mental Model](#2-simple-mental-model)
3. [Substitution](#3-substitution)
4. [Behavioral Contract](#4-behavioral-contract)
5. [LSP Is About Behavior](#5-lsp-is-about-behavior)
6. [LSP and Preconditions](#6-lsp-and-preconditions)
7. [LSP and Postconditions](#7-lsp-and-postconditions)
8. [LSP and Invariants](#8-lsp-and-invariants)
9. [LSP Contract Summary](#9-lsp-contract-summary)
10. [Classic Bird Example](#10-classic-bird-example)
11. [Why Inheritance Alone Is Not Enough](#11-why-inheritance-alone-is-not-enough)
12. [Inheritance vs Composition](#12-inheritance-vs-composition)
13. [Capability-Based Design](#13-capability-based-design)
14. [Bird Example (Full)](#14-bird-example-full)
15. [Vehicle Example](#15-vehicle-example)
16. [Employee Example](#16-employee-example)
17. [Payment Example](#17-payment-example)
18. [Printer Example](#18-printer-example)
19. [Media Player Example](#19-media-player-example)
20. [Cloud Storage Example](#20-cloud-storage-example)
21. [UnsupportedOperationException](#21-unsupportedoperationexception)
22. [Empty Method Implementation](#22-empty-method-implementation)
23. [instanceof and Downcasting](#23-instanceof-and-downcasting)
24. [LSP Violation Smells](#24-lsp-violation-smells)
25. [Bad vs Good Design](#25-bad-vs-good-design)
26. [LSP Refactoring Workflow](#26-lsp-refactoring-workflow)
27. [Example of Complete Refactoring](#27-example-of-complete-refactoring)
28. [LSP Relationship With Other SOLID Principles](#28-lsp-relationship-with-other-solid-principles)
29. [How to Identify LSP Violations](#29-how-to-identify-lsp-violations)
30. [LSP Substitution Test](#30-lsp-substitution-test)
31. [Interview Questions](#31-interview-questions)
32. [Practice Checklist](#32-practice-checklist)
33. [Quick Comparison](#33-quick-comparison)
34. [LSP Smell Cheat Sheet](#34-lsp-smell-cheat-sheet)
35. [Final Mental Model](#35-final-mental-model)
36. [The Most Important Rule](#36-the-most-important-rule)
37. [LSP in One Example](#37-lsp-in-one-example)
38. [Final LSP Workflow](#38-final-lsp-workflow)
39. [LSP Final Summary](#39-lsp-final-summary)
40. [One-Line Definition](#40-one-line-definition)
41. [LSP Parts Covered](#41-lsp-parts-covered)

---

## 1. What is LSP?

LSP says:

> A subtype should be usable wherever its supertype is expected without changing the correctness of the program.

Suppose:

```java
class Bird {

    void eat() {
        System.out.println("Eating");
    }
}

class Sparrow extends Bird {
}
```

This is potentially valid because:

```java
Bird bird = new Sparrow();
bird.eat();
```

`Sparrow` can behave like a `Bird`.

But if the parent promises behavior that the child cannot support:

```java
class Bird {

    void fly() {
        System.out.println("Flying");
    }
}

class Penguin extends Bird {

    @Override
    void fly() {
        throw new UnsupportedOperationException();
    }
}
```

then:

```java
Bird bird = new Penguin();
bird.fly();
```

breaks the expectation of the client. That is the important idea behind LSP.

---

## 2. Simple Mental Model

Whenever you see:

```text
Parent
  │
  ▼
Child
```

Ask: *"Can Child completely behave like Parent?"*

**If yes:**

```text
Parent reference
       │
       ▼
  Child object
       │
       ▼
Expected behavior works
```

**If no:**

```text
Parent reference
       │
       ▼
  Child object
       │
       ▼
Unexpected behavior
       │
       ▼
   LSP violation
```

---

## 3. Substitution

Substitution means: **we can replace the parent object with a child object without breaking the program.**

```java
class Animal {

    public void eat() {
        System.out.println("Eating");
    }
}

class Dog extends Animal {
}

public class Client {

    public static void main(String[] args) {
        Animal animal = new Dog();
        animal.eat();
    }
}
```

The client doesn't care whether it received `new Animal()` or `new Dog()`. The expected behavior remains valid.

---

## 4. Behavioral Contract

This is one of the most important concepts in LSP.

> A parent class or interface creates a contract. The contract describes what clients can expect.

```java
interface Payment {

    void process();
}
```

The contract says: *any implementation of `Payment` must provide a valid `process()` operation.*

If:

```java
class CreditCardPayment implements Payment {

    @Override
    public void process() {
        System.out.println("Processing card payment");
    }
}
```

then substitution works:

```java
Payment payment = new CreditCardPayment();
payment.process();
```

But if another implementation does:

```java
class SomePayment implements Payment {

    @Override
    public void process() {
        throw new UnsupportedOperationException();
    }
}
```

then the implementation cannot properly fulfill the contract.

---

## 5. LSP Is About Behavior

LSP is not only about method signatures. This is important.

A child can have:

- the same methods
- the correct inheritance
- correct compilation

and still violate LSP because its behavior is incompatible.

```java
class BankAccount {

    public void withdraw(double amount) {
        // withdraw amount
    }
}
```

Suppose clients expect `withdraw(5000)` to work. Now a subclass says:

```java
@Override
public void withdraw(double amount) {

    if (amount > 1000) {
        throw new IllegalArgumentException();
    }
    // withdraw
}
```

The subclass has changed the behavioral contract. Therefore, the important question is:

> Can the child preserve the expectations established by the parent?

---

## 6. LSP and Preconditions

**What is a Precondition?**

A precondition is something that must be true before a method executes.

```java
void withdraw(double amount)
```

Parent contract: `amount > 0`. A client is therefore allowed to call `withdraw(5000)`.

Now suppose the child changes the rule to: `amount > 0 AND amount <= 1000`. The child has made the precondition stricter. **This is an LSP violation.**

### Rule

> A subtype should not strengthen the preconditions of the parent.

```text
Parent accepts: 0 < amount
Child accepts:  0 < amount <= 1000

Child accepts FEWER valid inputs → ❌ LSP violation
```

---

## 7. LSP and Postconditions

**What is a Postcondition?**

A postcondition is what the method guarantees after execution.

Suppose the parent promises:

```text
withdraw(100) → balance decreases by 100
```

But the child does:

```text
withdraw(100) → balance decreases by only 50
```

The child has weakened the parent's guarantee. **❌ LSP violation.**

### Rule

> A subtype should not weaken the postconditions of the parent.

```text
Parent: Strong guarantee
Child:  Weaker guarantee
             │
             ▼
      LSP violation
```

---

## 8. LSP and Invariants

**What is an Invariant?**

An invariant is something that must remain true for an object.

```text
BankAccount
Invariant: balance >= 0
```

If the parent guarantees `balance >= 0` but the child allows `balance = -500`, then the child has broken the parent's invariant. **❌ LSP violation.**

---

## 9. LSP Contract Summary

The relationship can be remembered as:

```text
                Parent Contract
        ┌─────────────┼─────────────┐
        ▼              ▼              ▼
 Preconditions   Postconditions    Invariants
        │              │              │
        ▼              ▼              ▼
  Don't make      Don't weaken      Preserve
   stricter        guarantees         them
```

> Child must honor the behavioral contract of Parent.

---

## 10. Classic Bird Example

```text
Bird
├── Sparrow  (flies)
└── Penguin  (cannot fly)
```

```java
class Bird {

    public void eat() {
        System.out.println("Eating");
    }

    public void fly() {
        System.out.println("Flying");
    }
}
```

```java
class Penguin extends Bird {

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguin cannot fly");
    }
}
```

```java
Bird bird = new Penguin();
bird.fly();
```

The client expects a bird to fly because the parent contract provides `fly()`. But the child cannot fulfill that expectation. **❌ LSP violation.**

---

## 11. Why Inheritance Alone Is Not Enough

A common misunderstanding is: *"If `Penguin` extends `Bird`, then LSP is automatically satisfied."*

No. Inheritance establishes a **structural** relationship. LSP establishes a **behavioral** relationship.

```text
Inheritance: "Penguin is technically a Bird."
LSP:         "Penguin can safely substitute Bird
              wherever Bird is expected."
```

The first can be true while the second is false.

---

## 12. Inheritance vs Composition

One of the most useful solutions to LSP problems is reconsidering inheritance.

### Inheritance

Use inheritance when `Child IS-A Parent`:

```text
Dog IS-A Animal
Sparrow IS-A Bird
Manager IS-A Employee
```

But the child must also preserve the parent's behavioral contract.

### Composition

Composition means an object **HAS-A** behavior or dependency.

```text
Bird          Car          CloudStorage
└── FlyingBehavior   └── Engine   └── Encryption
```

Composition is useful when behavior varies independently.

---

## 13. Capability-Based Design

A common LSP solution is to separate capabilities.

Instead of:

```text
Bird
└── fly()
```

use:

```text
Bird
└── common bird behavior

FlyingBird
└── fly()
```

Now:

```text
Bird
├── Penguin
└── FlyingBird
      └── Sparrow
```

Only flying birds receive the flying capability.

---

## 14. Bird Example (Full)

### Bad Design

**Bird.java**

```java
package practice.lsp.part3.bird.badDesign;

public class Bird {

    public void eat() {
        System.out.println("Bird is eating");
    }

    public void sleep() {
        System.out.println("Bird is sleeping");
    }

    public void fly() {
        System.out.println("Bird is flying");
    }
}
```

**Penguin.java**

```java
package practice.lsp.part3.bird.badDesign;

public class Penguin extends Bird {

    @Override
    public void fly() {
        throw new UnsupportedOperationException("Penguin cannot fly");
    }
}
```

**Client**

```java
package practice.lsp.part3.bird.badDesign;

public class BirdClient {

    public static void main(String[] args) {
        Bird bird = new Penguin();
        bird.eat();
        bird.sleep();
        bird.fly();
    }
}
```

### Good Design

**Bird.java**

```java
package practice.lsp.part3.bird.goodDesign;

public class Bird {

    public void eat() {
        System.out.println("Bird is eating");
    }

    public void sleep() {
        System.out.println("Bird is sleeping");
    }
}
```

**FlyingBird.java**

```java
package practice.lsp.part3.bird.goodDesign;

public class FlyingBird extends Bird {

    public void fly() {
        System.out.println("Bird is flying");
    }
}
```

**Sparrow.java**

```java
package practice.lsp.part3.bird.goodDesign;

public class Sparrow extends FlyingBird {
}
```

**Penguin.java**

```java
package practice.lsp.part3.bird.goodDesign;

public class Penguin extends Bird {
}
```

**Client**

```java
package practice.lsp.part3.bird.goodDesign;

public class BirdClient {

    public static void main(String[] args) {
        Bird penguin = new Penguin();
        penguin.eat();
        penguin.sleep();

        FlyingBird sparrow = new Sparrow();
        sparrow.eat();
        sparrow.sleep();
        sparrow.fly();
    }
}
```

The important improvement:

```text
Bird
└── common behavior

FlyingBird
└── fly()

Penguin
└── does not inherit fly()
```

---

## 15. Vehicle Example

```text
Vehicle
├── start()
├── drive()
└── refuel()
```

`ElectricCar extends Vehicle` — but an electric car doesn't refuel.

### Bad Design

**Vehicle.java**

```java
package practice.lsp.part3.vehicle.badDesign;

public class Vehicle {

    public void start() {
        System.out.println("Vehicle started");
    }

    public void drive() {
        System.out.println("Vehicle is driving");
    }

    public void refuel() {
        System.out.println("Vehicle is refueling");
    }
}
```

**ElectricCar.java**

```java
package practice.lsp.part3.vehicle.badDesign;

public class ElectricCar extends Vehicle {

    @Override
    public void refuel() {
        throw new UnsupportedOperationException("Electric car does not use fuel");
    }
}
```

### Good Design

**Vehicle.java**

```java
package practice.lsp.part3.vehicle.goodDesign;

public class Vehicle {

    public void start() {
        System.out.println("Vehicle started");
    }

    public void drive() {
        System.out.println("Vehicle is driving");
    }
}
```

**FuelVehicle.java**

```java
package practice.lsp.part3.vehicle.goodDesign;

public class FuelVehicle extends Vehicle {

    public void refuel() {
        System.out.println("Vehicle is refueling");
    }
}
```

**ElectricCar.java**

```java
package practice.lsp.part3.vehicle.goodDesign;

public class ElectricCar extends Vehicle {

    public void charge() {
        System.out.println("Electric car is charging");
    }
}
```

Hierarchy:

```text
Vehicle
├── FuelVehicle
│     └── PetrolCar
└── ElectricCar
```

---

## 16. Employee Example

```text
Employee
├── work()
├── receiveSalary()
└── manageTeam()
```

An intern is an employee but may not manage a team.

### Bad Design

```java
package practice.lsp.part3.employee.badDesign;

public class Employee {

    public void work() {
        System.out.println("Employee is working");
    }

    public void receiveSalary() {
        System.out.println("Employee received salary");
    }

    public void manageTeam() {
        System.out.println("Employee is managing team");
    }
}
```

```java
package practice.lsp.part3.employee.badDesign;

public class Intern extends Employee {

    @Override
    public void manageTeam() {
        throw new UnsupportedOperationException("Intern cannot manage a team");
    }
}
```

### Good Design

**Employee.java**

```java
package practice.lsp.part3.employee.goodDesign;

public class Employee {

    public void work() {
        System.out.println("Employee is working");
    }

    public void receiveSalary() {
        System.out.println("Employee received salary");
    }
}
```

**Manager.java**

```java
package practice.lsp.part3.employee.goodDesign;

public class Manager extends Employee {

    public void manageTeam() {
        System.out.println("Manager is managing team");
    }
}
```

**Intern.java**

```java
package practice.lsp.part3.employee.goodDesign;

public class Intern extends Employee {
}
```

Hierarchy:

```text
Employee
├── Intern
└── Manager
      └── manageTeam()
```

---

## 17. Payment Example

```text
Payment
├── process()
└── refund()
```

Not every payment method supports the same refund mechanism.

### Bad Design

```java
package practice.lsp.part3.payment.badDesign;

public class Payment {

    public void process() {
        System.out.println("Payment processed");
    }

    public void refund() {
        System.out.println("Payment refunded");
    }
}
```

```java
package practice.lsp.part3.payment.badDesign;

public class CashPayment extends Payment {

    @Override
    public void refund() {
        throw new UnsupportedOperationException("Cash payment does not support automatic refund");
    }
}
```

This means:

```text
Payment
└── refund()
      └── CashPayment
            └── ✗ cannot fulfill
```

### Good Design

**Payment.java**

```java
package practice.lsp.part3.payment.goodDesign;

public interface Payment {

    void process();
}
```

**Refundable.java**

```java
package practice.lsp.part3.payment.goodDesign;

public interface Refundable {

    void refund();
}
```

**CreditCardPayment.java**

```java
package practice.lsp.part3.payment.goodDesign;

public class CreditCardPayment implements Payment, Refundable {

    @Override
    public void process() {
        System.out.println("Credit card payment processed");
    }

    @Override
    public void refund() {
        System.out.println("Credit card payment refunded");
    }
}
```

**CashPayment.java**

```java
package practice.lsp.part3.payment.goodDesign;

public class CashPayment implements Payment {

    @Override
    public void process() {
        System.out.println("Cash payment processed");
    }
}
```

Now:

```text
Payment
└── process()

Refundable
└── refund()

CreditCardPayment
├── Payment
└── Refundable

CashPayment
└── Payment
```

---

## 18. Printer Example

```text
Printer
├── print()
└── scan()
```

A basic printer can print but cannot scan.

### Bad Design

```java
package practice.lsp.part3.printer.badDesign;

public class Printer {

    public void print() {
        System.out.println("Printing");
    }

    public void scan() {
        System.out.println("Scanning");
    }
}
```

```java
package practice.lsp.part3.printer.badDesign;

public class BasicPrinter extends Printer {

    @Override
    public void scan() {
        throw new UnsupportedOperationException("Basic printer cannot scan");
    }
}
```

### Good Design

**Printer.java**

```java
package practice.lsp.part3.printer.goodDesign;

public interface Printer {

    void print();
}
```

**Scanner.java**

```java
package practice.lsp.part3.printer.goodDesign;

public interface Scanner {

    void scan();
}
```

**BasicPrinter.java**

```java
package practice.lsp.part3.printer.goodDesign;

public class BasicPrinter implements Printer {

    @Override
    public void print() {
        System.out.println("Printing");
    }
}
```

**MultiFunctionPrinter.java**

```java
package practice.lsp.part3.printer.goodDesign;

public class MultiFunctionPrinter implements Printer, Scanner {

    @Override
    public void print() {
        System.out.println("Printing");
    }

    @Override
    public void scan() {
        System.out.println("Scanning");
    }
}
```

---

## 19. Media Player Example

```text
MediaPlayer
├── play()
└── stream()
```

An offline player cannot stream.

### Bad Design

```java
package practice.lsp.part3.media.badDesign;

public class MediaPlayer {

    public void play() {
        System.out.println("Playing media");
    }

    public void stream() {
        System.out.println("Streaming media");
    }
}
```

```java
package practice.lsp.part3.media.badDesign;

public class OfflinePlayer extends MediaPlayer {

    @Override
    public void stream() {
        throw new UnsupportedOperationException("Offline player cannot stream");
    }
}
```

### Good Design

**Playable.java**

```java
package practice.lsp.part3.media.goodDesign;

public interface Playable {

    void play();
}
```

**Streamable.java**

```java
package practice.lsp.part3.media.goodDesign;

public interface Streamable {

    void stream();
}
```

**OfflinePlayer.java**

```java
package practice.lsp.part3.media.goodDesign;

public class OfflinePlayer implements Playable {

    @Override
    public void play() {
        System.out.println("Playing offline media");
    }
}
```

**StreamingPlayer.java**

```java
package practice.lsp.part3.media.goodDesign;

public class StreamingPlayer implements Playable, Streamable {

    @Override
    public void play() {
        System.out.println("Playing streaming media");
    }

    @Override
    public void stream() {
        System.out.println("Streaming media");
    }
}
```

---

## 20. Cloud Storage Example

```text
CloudStorage
├── upload()
├── download()
└── encrypt()
```

Not every storage implementation necessarily supports encryption.

### Bad Design

```java
package practice.lsp.part3.cloudStorage.badDesign;

public class CloudStorage {

    public void upload(String fileName) {
        System.out.println("Uploading " + fileName);
    }

    public void download(String fileName) {
        System.out.println("Downloading " + fileName);
    }

    public void encrypt(String fileName) {
        System.out.println("Encrypting " + fileName);
    }
}
```

```java
package practice.lsp.part3.cloudStorage.badDesign;

public class LocalStorage extends CloudStorage {

    @Override
    public void encrypt(String fileName) {
        throw new UnsupportedOperationException("Local storage does not support encryption");
    }
}
```

### Good Design

**Storage.java**

```java
package practice.lsp.part3.cloudStorage.goodDesign;

public interface Storage {

    void upload(String fileName);

    void download(String fileName);
}
```

**Encryption.java**

```java
package practice.lsp.part3.cloudStorage.goodDesign;

public interface Encryption {

    void encrypt(String fileName);
}
```

**S3Storage.java**

```java
package practice.lsp.part3.cloudStorage.goodDesign;

public class S3Storage implements Storage, Encryption {

    @Override
    public void upload(String fileName) {
        System.out.println("Uploading " + fileName + " to S3");
    }

    @Override
    public void download(String fileName) {
        System.out.println("Downloading " + fileName + " from S3");
    }

    @Override
    public void encrypt(String fileName) {
        System.out.println("Encrypting " + fileName);
    }
}
```

**LocalStorage.java**

```java
package practice.lsp.part3.cloudStorage.goodDesign;

public class LocalStorage implements Storage {

    @Override
    public void upload(String fileName) {
        System.out.println("Uploading " + fileName + " locally");
    }

    @Override
    public void download(String fileName) {
        System.out.println("Downloading " + fileName + " locally");
    }
}
```

---

## 21. UnsupportedOperationException

One of the strongest LSP smells is:

```java
@Override
public void someMethod() {
    throw new UnsupportedOperationException();
}
```

Why? Because it often means:

```text
Parent promises behavior
        │
        ▼
Child inherits behavior
        │
        ▼
Child cannot perform it
        │
        ▼
UnsupportedOperationException
        │
        ▼
Possible LSP violation
```

**Important:** `UnsupportedOperationException` is not automatically an LSP violation in every possible design. But when the method is part of the parent's meaningful behavioral contract, it is a strong signal that the abstraction is wrong.

---

## 22. Empty Method Implementation

Another smell:

```java
@Override
public void fly() {
    // Do nothing
}
```

This can be just as suspicious. The parent says `fly()`. The child says *"I technically implement it, but I don't actually do anything."*

Ask: **should this behavior really exist in the parent abstraction?**

---

## 23. instanceof and Downcasting

Consider:

```java
public void makeBirdFly(Bird bird) {

    if (bird instanceof Penguin) {
        System.out.println("Penguin cannot fly");
        return;
    }

    bird.fly();
}
```

This is a design smell — the client knows specific details about subclasses, but the abstraction is supposed to hide those details.

Instead of:

```text
makeBirdFly(Bird)
├── if Penguin
├── if Sparrow
├── if Eagle
└── ...
```

we can create:

```java
public void makeBirdFly(FlyingBird bird) {
    bird.fly();
}
```

Now the method explicitly requires the flying capability.

### Downcasting

```java
Animal animal = new Dog();
Dog dog = (Dog) animal;
dog.bark();
```

Downcasting itself isn't automatically an LSP violation. But repeated downcasting can indicate a weak abstraction:

```java
if (animal instanceof Dog) {
    Dog dog = (Dog) animal;
    dog.bark();
}
```

If clients constantly need to know the concrete subtype, investigate the design.

---

## 24. LSP Violation Smells

Use these as a practical checklist.

**Smell 1 — UnsupportedOperationException**

```java
@Override
public void method() {
    throw new UnsupportedOperationException();
}
```
Ask: *why does this child inherit something it cannot support?*

**Smell 2 — Empty Override**

```java
@Override
public void method() {
}
```
Ask: *is this behavior actually valid for the child?*

**Smell 3 — Strengthened Preconditions**

```text
Parent: accepts many inputs
Child:  accepts fewer inputs
```
Possible LSP violation.

**Smell 4 — Weakened Postconditions**

```text
Parent: promises X
Child:  only guarantees part of X
```
Possible LSP violation.

**Smell 5 — Broken Invariants**

```text
Parent: balance >= 0
Child:  balance can become negative
```
Possible LSP violation.

**Smell 6 — instanceof**

```java
if (object instanceof SomeChild) {
}
```
Repeated type checking can indicate a problematic abstraction.

**Smell 7 — Downcasting**

```java
Parent parent = new Child();
Child child = (Child) parent;
```
Not automatically wrong, but repeated downcasting deserves investigation.

**Smell 8 — Special Child Handling**

```java
if (employee instanceof Intern) {
    // special handling
}
```
Ask: *why can't the parent abstraction handle the child polymorphically?*

---

## 25. Bad vs Good Design

### Bad Design

```text
             Large Parent
        ┌────────┼────────┐
        ▼        ▼        ▼
    Child A   Child B   Child C
                 │
                 ✗ unsupported
                 │
                 ▼
            LSP problem
```

### Good Design

```text
Base Abstraction
└── Common behavior
        ┌───────┴───────┐
        ▼               ▼
  Capability A     Capability B
        │               │
        ▼               ▼
     Classes         Classes
```

---

## 26. LSP Refactoring Workflow

When you find a suspicious inheritance hierarchy, follow this process.

```text
Step 1 — Find inheritance relationship
        │
        ▼
Step 2 — Check parent's behavioral contract
        │
        ▼
Step 3 — Check every child
        ├── Child supports contract?    → YES → Keep hierarchy
        └── Child doesn't support it?   → NO  → Rethink abstraction
                                                    ├── Split capability
                                                    └── Composition
                                                          │
                                                          ▼
                                                  Test substitution
```

---

## 27. Example of Complete Refactoring

Suppose we start with:

```java
class Vehicle {

    void drive() {
        System.out.println("Driving");
    }

    void refuel() {
        System.out.println("Refueling");
    }
}

class ElectricCar extends Vehicle {

    @Override
    void refuel() {
        throw new UnsupportedOperationException();
    }
}
```

**Step 1 — Find the problematic behavior:** `refuel()`.

**Step 2 — Ask:** does every vehicle refuel? No.

**Step 3 — Separate capability:**

```text
Vehicle
└── drive()

FuelVehicle
└── refuel()

ElectricCar
└── charge()
```

**Step 4 — Implement:**

```java
class Vehicle {

    void drive() {
        System.out.println("Driving");
    }
}

class FuelVehicle extends Vehicle {

    void refuel() {
        System.out.println("Refueling");
    }
}

class ElectricCar extends Vehicle {

    void charge() {
        System.out.println("Charging");
    }
}
```

Now the abstractions are more accurate.

---

## 28. LSP Relationship With Other SOLID Principles

```text
                     SOLID
        ┌──────────────┼──────────────┐
        ▼               ▼               ▼
      SRP              OCP              LSP
       │                │                │
one reason        extend without     safe
to change          modifying       substitution
                                         │
                                         ▼
                                        ISP
                                         │
                                 small contracts
                                         │
                                         ▼
                                        DIP
                                         │
                              abstractions/dependency
```

### LSP and SRP

- **SRP:** a class should have one reason to change.
- **LSP:** a subtype should be safely substitutable for its parent.

Different principles, but a poorly designed abstraction can create problems for both.

### LSP and OCP

- **OCP:** open for extension, closed for modification.

LSP helps polymorphism work correctly. If we create a `Parent` with `Child A`, `Child B`, `Child C`, and all children correctly follow the parent contract, new implementations can often be added without modifying existing client logic. Therefore LSP strongly supports OCP.

### LSP and ISP

- **ISP:** clients should not be forced to depend on methods they don't need.
- **LSP:** subtypes must honor the contracts they implement.

They often work together. For example, a `Printer` with `print()`, `scan()`, `fax()` — a basic printer might not support scanning or faxing. Splitting the interface into `Printer`, `Scanner`, `Fax` creates smaller, more accurate contracts.

### LSP and DIP

- **DIP:** depend on abstractions, not concrete implementations.

LSP ensures those implementations can actually satisfy the abstraction.

```java
Payment payment = new CreditCardPayment();
payment.process();
```

This is useful only if `CreditCardPayment` correctly fulfills the `Payment` contract.

---

## 29. How to Identify LSP Violations

Use this practical process during code reviews.

| Step | Action |
|:----:|--------|
| 1 | Find `extends` / `implements`. |
| 2 | Look at the parent contract — what does the parent promise? |
| 3 | Look at every child — can the child fulfill that promise? |
| 4 | Search for `UnsupportedOperationException`, `instanceof`, downcasting, empty overrides, special child handling, extra validation, weaker results, broken invariants. |
| 5 | Test substitution (see below). |

---

## 30. LSP Substitution Test

The simplest practical test:

```java
Parent object = new Child();
parentOperation(object);
```

If this works exactly as the client expects → ✅ Good sign.

If you need:

```java
if (object instanceof Child) {
    // special handling
}
```

or:

```java
try {
    object.someMethod();
} catch (UnsupportedOperationException e) {
    // special handling
}
```

then → ⚠️ Investigate the abstraction.

---

## 31. Interview Questions

**Q1. What is LSP?**
LSP states that objects of a subtype should be replaceable for objects of the supertype without breaking the correctness of the program.

**Q2. Is inheritance itself an LSP violation?**
No. Inheritance is simply a mechanism. LSP is violated when the child cannot honor the behavioral contract of the parent.

**Q3. Is every `UnsupportedOperationException` an LSP violation?**
No. But when a child inherits a meaningful parent operation and cannot support it, it is a strong LSP smell.

**Q4. Is `instanceof` always an LSP violation?**
No. `instanceof` can be valid in some situations. But repeated type checking can indicate that polymorphism or the abstraction is poorly designed.

**Q5. What is a precondition?**
A condition that must be satisfied before a method executes, e.g. `amount > 0`.

**Q6. What should a child do with preconditions?**
It should not strengthen the parent's preconditions.

**Q7. What is a postcondition?**
A guarantee that must be true after a method executes.

**Q8. What should a child do with postconditions?**
It should not weaken the parent's guarantees.

**Q9. What is an invariant?**
A condition that must remain true for an object's valid state.

**Q10. What is the classic Penguin problem?**
If `Bird` has `fly()`, then `Penguin extends Bird` but `Penguin` cannot fly. The abstraction incorrectly promises that every `Bird` can fly.

**Q11. How can you solve the Penguin problem?**
Separate the flying capability:
```text
Bird
└── common behavior

FlyingBird
└── fly()

Penguin
└── Bird
```

**Q12. When can composition help?**
When behavior varies independently or when inheritance creates subclasses that cannot fully satisfy the parent's contract.

**Q13. What is the difference between SRP and LSP?**
SRP is about *reasons to change*. LSP is about *behavioral substitutability*.

**Q14. What is the difference between LSP and OCP?**
OCP says: extend behavior without modifying existing working code. LSP ensures that polymorphic extensions behave correctly wherever the abstraction is used.

---

## 32. Practice Checklist

When reviewing an inheritance hierarchy, ask:

- [ ] Can the child replace the parent?
- [ ] Does the child preserve parent behavior?
- [ ] Does the child accept all inputs that the parent accepts?
- [ ] Does the child preserve the parent's guarantees?
- [ ] Does the child preserve invariants?
- [ ] Does the child throw `UnsupportedOperationException`?
- [ ] Does the child have empty overrides?
- [ ] Does client code use `instanceof`?
- [ ] Does client code downcast?
- [ ] Does client code have special handling for a particular child?
- [ ] Does the parent contain capabilities that some children cannot support?
- [ ] Would splitting capabilities improve the abstraction?
- [ ] Would composition be better?

---

## 33. Quick Comparison

| Concept | Main Question |
|---|---|
| **SRP** | Does this have one reason to change? |
| **OCP** | Can we extend without modifying existing behavior? |
| **LSP** | Can the child safely replace the parent? |
| **ISP** | Are clients forced to depend on things they don't need? |
| **DIP** | Does high-level code depend on abstractions? |

---

## 34. LSP Smell Cheat Sheet

Strong LSP warning signs:

1. `UnsupportedOperationException`
2. Empty overridden methods
3. `instanceof` everywhere
4. Frequent downcasting
5. Special handling for subclasses
6. Child rejects inputs accepted by parent
7. Child gives weaker results
8. Child breaks parent invariants
9. Parent has capabilities not supported by all children
10. Client cannot treat all implementations uniformly

---

## 35. Final Mental Model

The entire LSP principle can be reduced to one question:

```text
   Parent
     │
     ▼
   Child
     │
     ▼
"Can Child behave exactly
 as Parent promises?"
     │
  ┌──┴──┐
  ▼      ▼
 YES     NO
  │      │
  ▼      ▼
LSP OK  LSP Problem
           │
     ┌─────┴─────┐
     ▼           ▼
Better       Composition
abstraction       │
                  ▼
        Split capabilities
```

---

## 36. The Most Important Rule

> A subtype must honor the behavioral contract of its supertype.

Do not memorize only *"Penguin cannot fly."* Instead understand the general principle:

> If Parent promises behavior X, Child must be able to correctly provide behavior X.

---

## 37. LSP in One Example

**Bad:**

```java
class Bird {

    void fly() {
        System.out.println("Flying");
    }
}

class Penguin extends Bird {

    @Override
    void fly() {
        throw new UnsupportedOperationException();
    }
}
```

**Good:**

```java
class Bird {

    void eat() {
        System.out.println("Eating");
    }
}

class FlyingBird extends Bird {

    void fly() {
        System.out.println("Flying");
    }
}

class Penguin extends Bird {
}
```

The difference:

```text
BAD                          GOOD

Bird                         Bird
└── fly()                    └── common behavior
      └── Penguin                   └── Penguin
            └── ✗ cannot fly
                              FlyingBird
                              └── fly()
                                    └── Sparrow
```

---

## 38. Final LSP Workflow

When designing an inheritance hierarchy:

```text
 1. Identify the parent abstraction
         │
         ▼
 2. Identify the behavioral contract
         │
         ▼
 3. Identify candidate subtypes
         │
         ▼
 4. Check substitution
         │
         ▼
 5. Check preconditions
         │
         ▼
 6. Check postconditions
         │
         ▼
 7. Check invariants
         │
         ▼
 8. Look for LSP smells
         │
         ▼
 9. If violation exists
         ├── Split behavior
         └── Composition
                │
                ▼
10. Test substitution again
```

---

## 39. LSP Final Summary

Remember these 10 points:

1. LSP = safe substitution.
2. A child must honor the parent's behavioral contract.
3. Inheritance does not automatically guarantee LSP.
4. Don't strengthen parent preconditions.
5. Don't weaken parent postconditions.
6. Preserve parent invariants.
7. `UnsupportedOperationException` is a strong LSP smell.
8. Repeated `instanceof` and downcasting can indicate abstraction problems.
9. Separate capabilities when not every subtype supports every behavior.
10. Use composition when behavior varies independently or inheritance becomes problematic.

---

## 40. One-Line Definition

> **LSP means:** if `Child` is a subtype of `Parent`, then `Child` should be usable anywhere `Parent` is expected without breaking the program's correctness or behavioral expectations.

---

## 41. LSP Parts Covered

```text
LSP
├── Part 1
│     ├── Substitution Principle
│     ├── Parent / Child behavior
│     └── Behavioral contract
│
├── Part 2
│     ├── Preconditions
│     ├── Postconditions
│     └── Invariants
│
├── Part 3
│     ├── Inheritance vs Composition
│     ├── Capability-based design
│     ├── Bird
│     ├── Vehicle
│     ├── Employee
│     ├── Payment
│     ├── Printer
│     ├── Media
│     └── Cloud Storage
│
└── Part 4
      ├── LSP violation detection
      ├── UnsupportedOperationException
      ├── instanceof
      ├── Downcasting
      ├── Refactoring
      ├── Real-world design smells
      └── Interview questions
```

---

> **LSP = Substitutability + Behavioral Contract + Correct Abstraction**

The key question to ask whenever you see inheritance is:

> *"Can I replace the parent with this child without the client needing to know that I changed the type?"*

If yes, you are likely respecting LSP. If no, rethink the abstraction.
