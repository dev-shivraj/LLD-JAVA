# Interface Segregation Principle (ISP)

> Clients should not be forced to depend on interfaces they do not use.

The **Interface Segregation Principle (ISP)** is the fourth principle of SOLID.

ISP is mainly about designing abstractions around the **needs of their clients** instead of creating large, general-purpose interfaces that force every implementation to support every possible operation.

---

## Table of Contents

1. [What is ISP?](#1-what-is-isp)
2. [Core Idea](#2-core-idea)
3. [Client Dependency](#3-client-dependency)
4. [Fat Interface](#4-fat-interface)
5. [Important: Large Interface Does Not Automatically Mean ISP Violation](#5-important-large-interface-does-not-automatically-mean-isp-violation)
6. [ISP Violation](#6-isp-violation)
7. [Refactoring Using ISP](#7-refactoring-using-isp)
8. [Bird Example](#8-bird-example)
9. [Better Bird Design](#9-better-bird-design)
10. [Printer Example](#10-printer-example)
11. [Payment Example](#11-payment-example)
12. [Employee Example](#12-employee-example)
13. [Media Player Example](#13-media-player-example)
14. [Cloud Storage Example](#14-cloud-storage-example)
15. [UnsupportedOperationException Smell](#15-unsupportedoperationexception-smell)
16. [ISP and LSP](#16-isp-and-lsp)
17. [ISP and SRP](#17-isp-and-srp)
18. [ISP and OCP](#18-isp-and-ocp)
19. [ISP and DIP](#19-isp-and-dip)
20. [ISP Does Not Mean One Method Per Interface](#20-isp-does-not-mean-one-method-per-interface)
21. [Over-Segregation](#21-over-segregation)
22. [ISP Balance](#22-isp-balance)
23. [Role Interfaces](#23-role-interfaces)
24. [Client-Specific Interfaces](#24-client-specific-interfaces)
25. [How to Identify ISP Violations](#25-how-to-identify-isp-violations)
26. [ISP Refactoring Workflow](#26-isp-refactoring-workflow)
27. [Common ISP Smells](#27-common-isp-smells)
28. [Practical ISP Decision Tree](#28-practical-isp-decision-tree)
29. [Practice: Bird](#29-practice-bird)
30. [Practice: Printer](#30-practice-printer)
31. [Practice: Cloud Storage](#31-practice-cloud-storage)
32. [Practice: Payment](#32-practice-payment)
33. [Final Interview Questions](#33-final-interview-questions)
34. [ISP vs SRP](#34-isp-vs-srp)
35. [ISP vs OCP](#35-isp-vs-ocp)
36. [ISP vs LSP](#36-isp-vs-lsp)
37. [ISP vs DIP](#37-isp-vs-dip)
38. [SOLID Relationship](#38-solid-relationship)
39. [ISP Review Checklist](#39-isp-review-checklist)
40. [Final Mental Model](#40-final-mental-model)
41. [The One Question to Remember](#41-the-one-question-to-remember)
42. [Final Summary](#42-final-summary)

---

## 1. What is ISP?

The **Interface Segregation Principle** states:

> Clients should not be forced to depend on interfaces they do not use.

The important word is **client**.

ISP is not simply:

> ~~"Interfaces should be small."~~

Instead:

> Interfaces should contain the capabilities that their clients actually need.

---

## 2. Core Idea

Consider:

```java
interface Employee {

    void work();

    void eat();

    void sleep();

    void approveLeave();

    void manageTeam();

    void calculateSalary();

    void calculateTax();

    void generateReport();
}
```

A particular client may only need:

```java
void work();
void eat();
void sleep();
```

But because the client depends on `Employee`, it is indirectly dependent on all the other methods. This is the core ISP problem.

---

## 3. Client Dependency

Suppose:

```text
DeveloperClient
      │
      ▼
   Employee
      ├── work()
      ├── eat()
      ├── sleep()
      ├── approveLeave()
      ├── manageTeam()
      ├── calculateSalary()
      └── generateReport()
```

The client only needs `work()`, `eat()`, `sleep()`. But it is forced to depend on `approveLeave()`, `manageTeam()`, `calculateSalary()`, `generateReport()`. **This is an ISP violation.**

A better design:

```text
DeveloperClient
      │
      ▼
  EmployeeBasic
      ├── work()
      ├── eat()
      └── sleep()
```

---

## 4. Fat Interface

A **fat interface** is an interface containing too many unrelated or unnecessary methods from the perspective of its clients.

```java
interface Printer {

    void print();

    void scan();

    void fax();

    void copy();

    void printPhoto();

    void scanPhoto();

    void sendEmail();

    void saveToCloud();
}
```

This can become a problem if different clients use completely different parts of the interface:

```text
PrintClient
      ├── print()       used
      ├── scan()        unused
      ├── fax()         unused
      ├── copy()        unused
      └── sendEmail()   unused
```

The client is depending on operations it doesn't need.

---

## 5. Important: Large Interface Does Not Automatically Mean ISP Violation

This is extremely important. An interface having many methods is only a **smell** — it is not automatically an ISP violation.

```java
interface MediaPlayer {

    void play();

    void pause();

    void stop();
}
```

All three methods are strongly related to the same capability:

```text
Playback
   ├── play()
   ├── pause()
   └── stop()
```

This is a cohesive interface — perfectly valid.

The correct question is:

> Are clients forced to depend on methods they don't need?

---

## 6. ISP Violation

Consider:

```java
interface Machine {

    void print();

    void scan();

    void fax();
}
```

Now imagine a simple printer:

```java
class SimplePrinter implements Machine {

    @Override
    public void print() {
        System.out.println("Printing");
    }

    @Override
    public void scan() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void fax() {
        throw new UnsupportedOperationException();
    }
}
```

This is a strong ISP smell. The printer does not support scanning or faxing, but the interface forces it to implement those methods.

---

## 7. Refactoring Using ISP

Instead of:

```text
Machine
├── print()
├── scan()
└── fax()
```

Create capability interfaces.

**Printable**

```java
interface Printable {

    void print();
}
```

**Scannable**

```java
interface Scannable {

    void scan();
}
```

**Faxable**

```java
interface Faxable {

    void fax();
}
```

Now:

```java
class SimplePrinter implements Printable {

    @Override
    public void print() {
        System.out.println("Printing");
    }
}
```

And:

```java
class MultiFunctionPrinter implements Printable, Scannable, Faxable {

    @Override
    public void print() {
        System.out.println("Printing");
    }

    @Override
    public void scan() {
        System.out.println("Scanning");
    }

    @Override
    public void fax() {
        System.out.println("Faxing");
    }
}
```

Design:

```text
Printable
   └── print()
        ├── SimplePrinter
        └── MultiFunctionPrinter
                  ├── Scannable ── scan()
                  └── Faxable   ── fax()
```

---

## 8. Bird Example

The Bird example is particularly useful because it demonstrates ISP together with LSP.

### Bad Bird Design

```java
interface Bird {

    void eat();

    void sleep();

    void fly();

    void swim();

    void sing();
}
```

```java
class Penguin implements Bird {

    @Override
    public void eat() {
        System.out.println("Penguin is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Penguin is sleeping");
    }

    @Override
    public void fly() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void swim() {
        System.out.println("Penguin is swimming");
    }

    @Override
    public void sing() {
        throw new UnsupportedOperationException();
    }
}
```

Problems:

```text
Penguin
   ├── eat()    supported
   ├── sleep()  supported
   ├── fly()    NOT supported
   ├── swim()   supported
   └── sing()   NOT supported
```

Penguin is being forced to depend on capabilities it does not have. **This is an ISP violation.**

---

## 9. Better Bird Design

Separate capabilities.

**Bird**

```java
interface Bird {

    void eat();

    void sleep();
}
```

**Flyable**

```java
interface Flyable {

    void fly();
}
```

**Swimmable**

```java
interface Swimmable {

    void swim();
}
```

**Singable**

```java
interface Singable {

    void sing();
}
```

Now Penguin:

```java
class Penguin implements Bird, Swimmable {

    @Override
    public void eat() {
        System.out.println("Penguin is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Penguin is sleeping");
    }

    @Override
    public void swim() {
        System.out.println("Penguin is swimming");
    }
}
```

Sparrow:

```java
class Sparrow implements Bird, Flyable, Singable {

    @Override
    public void eat() {
        System.out.println("Sparrow is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Sparrow is sleeping");
    }

    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }

    @Override
    public void sing() {
        System.out.println("Sparrow is singing");
    }
}
```

Result:

```text
Bird
├── Penguin
│     └── Swimmable ── swim()
└── Sparrow
      ├── Flyable  ── fly()
      └── Singable ── sing()
```

---

## 10. Printer Example

### Bad Design

```java
interface Printer {

    void print();

    void scan();

    void fax();
}
```

```java
class SimplePrinter implements Printer {

    @Override
    public void print() {
        System.out.println("Printing");
    }

    @Override
    public void scan() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void fax() {
        throw new UnsupportedOperationException();
    }
}
```

The printer is forced to implement functionality it does not support.

### Good Design

```java
interface Printable {

    void print();
}

interface Scannable {

    void scan();
}

interface Faxable {

    void fax();
}
```

Simple printer:

```java
class SimplePrinter implements Printable {

    @Override
    public void print() {
        System.out.println("Printing");
    }
}
```

Multi-function printer:

```java
class MultiFunctionPrinter implements Printable, Scannable, Faxable {

    @Override
    public void print() {
        System.out.println("Printing");
    }

    @Override
    public void scan() {
        System.out.println("Scanning");
    }

    @Override
    public void fax() {
        System.out.println("Faxing");
    }
}
```

---

## 11. Payment Example

Consider:

```java
interface Payment {

    void pay();

    void refund();

    void chargeback();

    void generateReceipt();

    void sendNotification();

    void payWithCash();
}
```

Different payment systems may support different capabilities. Instead, separate the capabilities.

```java
interface Payable {

    void pay();
}

interface Refundable {

    void refund();
}

interface Chargebackable {

    void chargeback();
}

interface ReceiptGeneratable {

    void generateReceipt();
}

interface NotificationSender {

    void sendNotification();
}

interface CashPayable {

    void payWithCash();
}
```

An implementation can now select only the capabilities it supports.

---

## 12. Employee Example

**Bad:**

```java
interface Employee {

    void work();

    void calculateSalary();

    void calculateBonus();

    void saveToDatabase();

    void generateReport();

    void sendEmail();
}
```

Different clients may need different parts:

```text
PayrollClient
   ├── calculateSalary()
   └── calculateBonus()

EmployeeRepositoryClient
   └── saveToDatabase()

NotificationClient
   └── sendEmail()

ReportClient
   └── generateReport()
```

Instead, create focused abstractions.

```java
interface EmployeeWork {

    void work();
}

interface Compensation {

    void calculateSalary();

    void calculateBonus();
}

interface EmployeePersistence {

    void saveToDatabase();
}

interface EmployeeReporting {

    void generateReport();
}

interface EmployeeNotification {

    void sendEmail();
}
```

Now each client can depend only on the capability it requires.

---

## 13. Media Player Example

Consider:

```java
interface MediaPlayer {

    void play();

    void pause();

    void stop();

    void record();

    void stream();

    void download();

    void cast();
}
```

Different media implementations may support different capabilities. Instead:

```java
interface Playable {

    void play();

    void pause();

    void stop();
}

interface Recordable {

    void record();
}

interface Streamable {

    void stream();
}

interface Downloadable {

    void download();
}

interface Castable {

    void cast();
}
```

A normal media player can implement:

```java
class MediaPlayer implements Playable, Streamable {

    @Override
    public void play() {
        System.out.println("Playing");
    }

    @Override
    public void pause() {
        System.out.println("Paused");
    }

    @Override
    public void stop() {
        System.out.println("Stopped");
    }

    @Override
    public void stream() {
        System.out.println("Streaming");
    }
}
```

Notice that `play()`, `pause()`, and `stop()` are kept together because they form a cohesive playback capability.

---

## 14. Cloud Storage Example

Cloud storage is a useful real-world ISP example.

### Bad Design

```java
interface CloudStorage {

    void upload();

    void download();

    void delete();

    void generatePublicUrl();

    void streamVideo();

    void encrypt();

    void compress();
}
```

Suppose `BackupService` only needs `upload()`. But it depends on the entire interface:

```text
BackupService
      │
      ▼
  CloudStorage
      ├── upload()             required
      ├── download()           unnecessary
      ├── delete()             unnecessary
      ├── generatePublicUrl()  unnecessary
      ├── streamVideo()        unnecessary
      ├── encrypt()            unnecessary
      └── compress()           unnecessary
```

### Good Cloud Storage Design

Create focused capability interfaces.

```java
interface FileUploader {

    void upload();
}

interface FileDownloader {

    void download();
}

interface FileDeleter {

    void delete();
}

interface PublicUrlGenerator {

    void generatePublicUrl();
}

interface VideoStreamer {

    void streamVideo();
}

interface Encryptable {

    void encrypt();
}
```

Now `BackupService` depends only on what it needs:

```java
class BackupService {

    private final FileUploader uploader;

    public BackupService(FileUploader uploader) {
        this.uploader = uploader;
    }

    public void backup() {
        uploader.upload();
    }
}
```

The dependency becomes:

```text
BackupService
      │
      ▼
 FileUploader
      ▲
      │
CloudStorageImplementation
```

This is a clean example of ISP combined with DIP.

---

## 15. UnsupportedOperationException Smell

One of the strongest practical smells for ISP is:

```java
throw new UnsupportedOperationException();
```

```java
interface Bird {

    void fly();

    void swim();
}
```

```java
class Penguin implements Bird {

    @Override
    public void fly() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void swim() {
        System.out.println("Swimming");
    }
}
```

This strongly suggests that the abstraction is forcing `Penguin` to support something it does not support.

Possible refactoring:

```text
Bird
├── eat()
└── sleep()

Flyable
└── fly()

Swimmable
└── swim()
```

---

## 16. ISP and LSP

ISP and LSP are closely related in many bad designs.

```java
interface Bird {

    void fly();
}
```

```java
class Penguin implements Bird {

    @Override
    public void fly() {
        throw new UnsupportedOperationException();
    }
}
```

There are two problems:

- **ISP problem:** `Penguin` is forced to depend on `fly()`.
- **LSP problem:** a client expects `Bird bird = new Penguin(); bird.fly();` to work, but the abstraction says that the `Bird` can fly while the subtype cannot.

```text
Bad abstraction
   ├── ISP → Forced dependency
   └── LSP → Substitution problem
```

A single bad abstraction can violate multiple SOLID principles.

---

## 17. ISP and SRP

Consider:

```java
interface Employee {

    void calculateSalary();

    void saveToDatabase();

    void sendEmail();
}
```

There are different concerns: `Salary`, `Persistence`, `Communication`. This can indicate an SRP problem.

But if a client only needs `calculateSalary()` and is forced to depend on `saveToDatabase()` and `sendEmail()`, then we also have an ISP problem.

```text
SRP
├── Focuses on responsibility
└── One reason to change

ISP
├── Focuses on clients and interfaces
└── Don't force clients to depend on unused methods
```

---

## 18. ISP and OCP

OCP says: *open for extension, closed for modification.*

```java
interface Payment {

    void pay();
}
```

We can add `CreditCardPayment`, `UPIPayment`, `CashPayment` implementations without existing implementations needing to change. **This supports OCP.**

Now consider:

```java
interface Payment {

    void pay();

    void payWithCash();

    void payWithCard();

    void payWithUPI();
}
```

Every implementation may be forced to depend on methods that do not apply to it. **This is an ISP problem.**

```text
OCP
└── Extension without modifying stable code

ISP
└── Avoid unnecessary client dependencies
```

---

## 19. ISP and DIP

DIP says: *high-level modules should depend on abstractions, not concrete implementations.*

```java
class BackupService {

    private CloudStorage storage;

    public BackupService(CloudStorage storage) {
        this.storage = storage;
    }
}
```

DIP says: *depend on an abstraction.* But what if `CloudStorage` is huge?

```java
interface CloudStorage {

    void upload();

    void download();

    void delete();

    void stream();

    void generatePublicUrl();

    void encrypt();
}
```

`BackupService` may only need `upload()`. ISP suggests:

```java
interface FileUploader {

    void upload();
}
```

Then:

```java
class BackupService {

    private final FileUploader uploader;

    public BackupService(FileUploader uploader) {
        this.uploader = uploader;
    }
}
```

Now both principles work together:

```text
DIP
└── BackupService depends on abstraction
          │
          ▼
     FileUploader
          ▲
          │
ISP
└── abstraction contains only required capability
```

---

## 20. ISP Does Not Mean One Method Per Interface

This is one of the biggest misconceptions.

ISP does **NOT** mean:

```java
interface PlayAction {

    void play();
}

interface PauseAction {

    void pause();
}

interface StopAction {

    void stop();
}
```

This may be **over-segregation**. These three methods naturally belong to:

```text
Playback
├── play()
├── pause()
└── stop()
```

Therefore:

```java
interface Playable {

    void play();

    void pause();

    void stop();
}
```

can be perfectly reasonable. The objective is **not** *minimum number of methods*. The objective is **appropriate grouping of capabilities for clients.**

---

## 21. Over-Segregation

Over-segregation means creating too many tiny interfaces.

```text
PlayAction
PauseAction
StopAction
VolumeUpAction
VolumeDownAction
MuteAction
SeekAction
ForwardAction
BackwardAction
```

This can make the design harder to understand and maintain. Instead, group naturally cohesive capabilities:

```java
interface PlaybackControl {

    void play();

    void pause();

    void stop();

    void seek();
}
```

And:

```java
interface VolumeControl {

    void volumeUp();

    void volumeDown();

    void mute();
}
```

This creates meaningful abstractions.

---

## 22. ISP Balance

Good ISP design sits between two extremes.

```text
Fat Interface                Over-Segregated
├── one giant interface      ├── 100 tiny interfaces
└── too many unrelated       └── unnecessarily
    capabilities                 fragmented

                Good Design
        ├── meaningful capability interfaces
        ├── cohesive methods
        ├── client-focused
        └── reusable
```

---

## 23. Role Interfaces

A useful way to think about ISP is through **roles**.

Instead of asking *"What is this object?"*, ask *"What capability does this client need from this object?"*

```text
Bird
├── Flyable
├── Swimmable
└── Singable

CloudStorage
├── FileUploader
├── FileDownloader
├── FileDeleter
└── PublicUrlGenerator

Payment
├── Payable
├── Refundable
└── Chargebackable
```

These are role/capability interfaces.

---

## 24. Client-Specific Interfaces

The client should influence the abstraction.

Suppose `BackupService` only needs `upload()`. Then its abstraction should ideally expose:

```java
interface FileUploader {

    void upload();
}
```

instead of:

```java
interface CloudStorage {

    void upload();

    void download();

    void delete();

    void stream();

    void encrypt();

    void compress();
}
```

The client now depends only on the capability it actually needs. This reduces unnecessary coupling.

---

## 25. How to Identify ISP Violations

Use the following process during code review.

| Step | Action |
|:----:|--------|
| 1 | Find the interface, e.g. `interface CloudStorage { ... }`. |
| 2 | Find its clients, e.g. `BackupService`, `DownloadService`, `VideoService`, `FileDeletionService`. |
| 3 | Determine what each client actually uses. |
| 4 | Identify unused dependencies — if `BackupService` only uses `upload()` but depends on `download()`, `delete()`, `streamVideo()`, investigate ISP. |
| 5 | Find cohesive groups — group related capabilities (File Operations, Video Operations, Public URL). |
| 6 | Create meaningful interfaces, e.g. `FileUploader`, `FileDownloader`, `FileDeleter`. |
| 7 | Check implementations — does any implementation have to implement something it doesn't support? |
| 8 | Check for over-segregation — did you create too many tiny interfaces? |

---

## 26. ISP Refactoring Workflow

```text
Existing Interface
        │
        ▼
  Identify Clients
        │
        ▼
What does each client use?
        │
        ▼
  Find unused methods
        │
        ▼
Identify cohesive capabilities
        │
        ▼
Create focused interfaces
        │
        ▼
Update implementations/clients
        │
        ▼
Check for over-segregation
        │
        ▼
     Final Design
```

---

## 27. Common ISP Smells

**Smell 1 — Fat Interface**

```java
interface Machine {

    void print();

    void scan();

    void fax();

    void copy();

    void staple();

    void email();
}
```
Investigate whether all clients need all methods.

**Smell 2 — UnsupportedOperationException**

```java
@Override
public void scan() {
    throw new UnsupportedOperationException();
}
```
Strong indication that the abstraction may be too broad.

**Smell 3 — Empty Implementations**

```java
@Override
public void scan() {
}
```
The implementation is forced to provide a meaningless implementation.

**Smell 4 — Dummy Return Values**

```java
@Override
public boolean supportsVideoStreaming() {
    return false;
}
```
May indicate that the interface is asking an implementation to support something outside its responsibility.

**Smell 5 — Clients Use Only a Small Part of the Interface**

```text
Client
├── uses method 1
├── uses method 2
└── ignores methods 3-15
```
Investigate whether the interface should be segregated.

---

## 28. Practical ISP Decision Tree

```text
Interface
    │
    ▼
Identify clients
    │
    ▼
Does every client need every method?
    ├── Yes ──► Probably fine
    └── No  ──► Investigate
                     │
                     ▼
              Find capability groups
                     │
                     ▼
              Create focused interfaces
                     │
                     ▼
              Check implementations
                     │
                     ▼
              Check over-segregation
```

---

## 29. Practice: Bird

A useful practice structure:

```text
practice.isp.part4.bird.badDesign
```

Files: `Bird.java`, `BirdClient.java`, `Penguin.java`, `Sparrow.java`.

Start with:

```java
interface Bird {

    void eat();

    void sleep();

    void fly();

    void swim();

    void sing();
}
```

Implement `Penguin` and `Sparrow`. Questions:

1. Which methods does Penguin support?
2. Which methods does Sparrow support?
3. Which methods are forced?
4. Which methods should be moved into capability interfaces?
5. Is this also related to LSP?

### Bird Practice Solution

**Bird**

```java
package practice.isp.part4.bird.goodDesign;

public interface Bird {

    void eat();

    void sleep();
}
```

**Flyable**

```java
package practice.isp.part4.bird.goodDesign;

public interface Flyable {

    void fly();
}
```

**Swimmable**

```java
package practice.isp.part4.bird.goodDesign;

public interface Swimmable {

    void swim();
}
```

**Singable**

```java
package practice.isp.part4.bird.goodDesign;

public interface Singable {

    void sing();
}
```

**Penguin**

```java
package practice.isp.part4.bird.goodDesign;

public class Penguin implements Bird, Swimmable {

    @Override
    public void eat() {
        System.out.println("Penguin is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Penguin is sleeping");
    }

    @Override
    public void swim() {
        System.out.println("Penguin is swimming");
    }
}
```

**Sparrow**

```java
package practice.isp.part4.bird.goodDesign;

public class Sparrow implements Bird, Flyable, Singable {

    @Override
    public void eat() {
        System.out.println("Sparrow is eating");
    }

    @Override
    public void sleep() {
        System.out.println("Sparrow is sleeping");
    }

    @Override
    public void fly() {
        System.out.println("Sparrow is flying");
    }

    @Override
    public void sing() {
        System.out.println("Sparrow is singing");
    }
}
```

---

## 30. Practice: Printer

**Bad:**

```java
interface Printer {

    void print();

    void scan();

    void fax();
}
```

**Requirement:** a simple printer can print only; a scanner printer can print and scan; a multi-function printer can print, scan, and fax.

**Solution:**

```java
interface Printable {

    void print();
}

interface Scannable {

    void scan();
}

interface Faxable {

    void fax();
}
```

Simple printer:

```java
class SimplePrinter implements Printable {

    @Override
    public void print() {
        System.out.println("Printing");
    }
}
```

Multi-function printer:

```java
class MultiFunctionPrinter implements Printable, Scannable, Faxable {

    @Override
    public void print() {
        System.out.println("Printing");
    }

    @Override
    public void scan() {
        System.out.println("Scanning");
    }

    @Override
    public void fax() {
        System.out.println("Faxing");
    }
}
```

---

## 31. Practice: Cloud Storage

**Bad:**

```java
interface CloudStorage {

    void upload();

    void download();

    void delete();

    void streamVideo();

    void generatePublicUrl();

    void encrypt();
}
```

Suppose `BackupService` only needs `upload()`.

**Solution:**

```java
interface FileUploader {

    void upload();
}

interface FileDownloader {

    void download();
}

interface FileDeleter {

    void delete();
}

interface VideoStreamer {

    void streamVideo();
}

interface PublicUrlGenerator {

    void generatePublicUrl();
}

interface Encryptable {

    void encrypt();
}
```

Then:

```java
class BackupService {

    private final FileUploader uploader;

    public BackupService(FileUploader uploader) {
        this.uploader = uploader;
    }

    public void backup() {
        uploader.upload();
    }
}
```

---

## 32. Practice: Payment

**Bad:**

```java
interface Payment {

    void pay();

    void refund();

    void chargeback();

    void generateReceipt();

    void sendNotification();

    void payWithCash();
}
```

**Possible segregation:**

```java
interface Payable {

    void pay();
}

interface Refundable {

    void refund();
}

interface Chargebackable {

    void chargeback();
}

interface ReceiptGeneratable {

    void generateReceipt();
}

interface NotificationSender {

    void sendNotification();
}

interface CashPayable {

    void payWithCash();
}
```

---

## 33. Final Interview Questions

**Q1. What is ISP?**
ISP states: *clients should not be forced to depend on interfaces they do not use.*

**Q2. Does ISP mean every interface should have one method?**
No. Methods that belong to the same cohesive capability can remain together.

**Q3. Is a large interface automatically an ISP violation?**
No. A large interface is a smell that should be investigated. The actual issue occurs when clients or implementations are forced to depend on methods they don't need.

**Q4. What is a strong smell of ISP violation?**
An implementation being forced to implement unsupported methods — especially `throw new UnsupportedOperationException();`.

**Q5. What is a role interface?**
An interface representing a specific capability required by a client, e.g. `Flyable`, `Printable`, `Refundable`, `Streamable`, `FileUploader`.

**Q6. Who determines whether an interface is appropriately segregated?**
The clients or consumers are the most important perspective.

**Q7. Can ISP and LSP be violated by the same design?**
Yes — the Penguin example demonstrates this.

**Q8. Can ISP and SRP be violated by the same design?**
Yes. A design can combine unrelated responsibilities and simultaneously force clients to depend on unrelated methods.

**Q9. Can ISP and DIP work together?**
Yes. DIP says depend on abstractions; ISP helps make those abstractions focused and client-specific.

**Q10. What is over-segregation?**
Creating unnecessarily many tiny interfaces even though the methods naturally belong to one cohesive capability.

**Q11. Why is `UnsupportedOperationException` a design smell?**
Because it often means an abstraction is promising a capability that a particular implementation does not actually support.

**Q12. What is the biggest misconception about ISP?**
Thinking *"every interface should have as few methods as possible."* The better rule is: *every interface should contain the capabilities that its clients actually need.*

---

## 34. ISP vs SRP

| Principle | Main Question |
|---|---|
| **SRP** | Does this class have multiple reasons to change? |
| **ISP** | Is this client forced to depend on methods it doesn't need? |

SRP is primarily about **responsibility**. ISP is primarily about **client dependency**.

---

## 35. ISP vs OCP

| Principle | Main Question |
|---|---|
| **OCP** | Can I extend behavior without modifying stable code? |
| **ISP** | Can clients depend only on the capabilities they need? |

---

## 36. ISP vs LSP

| Principle | Main Question |
|---|---|
| **LSP** | Can subtype safely replace its parent abstraction? |
| **ISP** | Is the subtype/client forced to depend on unsupported capabilities? |

---

## 37. ISP vs DIP

| Principle | Main Question |
|---|---|
| **DIP** | Does the high-level module depend on abstraction? |
| **ISP** | Is that abstraction focused on what the client actually needs? |

A good design often uses both.

---

## 38. SOLID Relationship

The five SOLID principles solve different design problems.

```text
SRP
└── What responsibility belongs here?

OCP
└── Can new behavior be added without modifying stable code?

LSP
└── Can this subtype safely replace its abstraction?

ISP
└── Is this client forced to depend on unnecessary methods?

DIP
└── Does the high-level module depend on abstractions?
```

They are different principles, but one design problem can violate multiple principles at the same time.

---

## 39. ISP Review Checklist

When reviewing code, ask:

- [ ] Is there a large interface?
- [ ] What are its clients?
- [ ] What methods does each client actually use?
- [ ] Is any client forced to depend on unused methods?
- [ ] Does any implementation throw `UnsupportedOperationException`?
- [ ] Are there empty or dummy implementations?
- [ ] Are unrelated capabilities grouped together?
- [ ] Can capabilities be separated meaningfully?
- [ ] Are the resulting interfaces cohesive?
- [ ] Did we avoid over-segregation?
- [ ] Does the new design improve LSP?
- [ ] Does the abstraction work well with DIP?
- [ ] Is the design still easy to understand?

---

## 40. Final Mental Model

The most important mental model:

```text
     INTERFACE
         │
         ▼
      CLIENT
         │
         ▼
What does client need?
    ┌────┴────┐
    ▼         ▼
 Needs   Doesn't need
    │         │
    ▼         ▼
  Keep      Remove
    │
    ▼
Group related
capabilities
    │
    ▼
Create meaningful
  interfaces
    │
    ▼
Avoid over-segregation
```

---

## 41. The One Question to Remember

Whenever you see an interface, ask:

> **"Is this client being forced to depend on something it doesn't need?"**

If the answer is **Yes → investigate ISP.**

---

## 42. Final Summary

ISP is not about blindly creating smaller interfaces. It is about designing interfaces around **meaningful capabilities and client requirements**.

The progression is:

```text
Fat Interface
      │
      ▼
Identify Clients
      │
      ▼
Identify Unused Dependencies
      │
      ▼
Identify Capability Groups
      │
      ▼
Create Focused Interfaces
      │
      ▼
Update Implementations
      │
      ▼
Check LSP
      │
      ▼
Check DIP
      │
      ▼
Check Over-Segregation
      │
      ▼
Clean Design
```

The key concepts to remember:

1. ISP is client-focused.
2. Large interfaces are a smell, not automatically a violation.
3. Clients should not depend on methods they don't use.
4. Implementations should not be forced to support capabilities they don't have.
5. `UnsupportedOperationException` can be a strong ISP smell.
6. Role/capability interfaces are a common ISP technique.
7. ISP does not mean one method per interface.
8. Avoid over-segregation.
9. ISP can overlap with LSP.
10. ISP can overlap with SRP.
11. ISP works very well with DIP.
12. The final goal is **focused, cohesive, client-specific abstractions**.
