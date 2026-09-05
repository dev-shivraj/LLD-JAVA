# Dependency Inversion Principle (DIP)

DIP is the **D** in SOLID.

DIP helps us design software where high-level business logic does not become tightly coupled to low-level implementation details such as:

- Database
- Payment provider
- Cloud storage
- Email provider
- SMS provider
- File system
- External APIs
- Logging implementations
- Third-party libraries

The central idea is:

> High-level modules should not depend directly on low-level concrete implementations. Both should depend on abstractions.

And:

> Abstractions should not depend on details. Details should depend on abstractions.

---

## Table of Contents

1. [SOLID Overview](#1-solid-overview)
2. [What Is a Dependency?](#2-what-is-a-dependency)
3. [Concrete Dependency](#3-concrete-dependency)
4. [High-Level vs Low-Level Modules](#4-high-level-vs-low-level-modules)
5. [The Problem DIP Solves](#5-the-problem-dip-solves)
6. [Dependency Inversion](#6-dependency-inversion)
7. [The Two Rules of DIP](#7-the-two-rules-of-dip)
8. [The Most Important Mental Model](#8-the-most-important-mental-model)
9. [What Is an Abstraction?](#9-what-is-an-abstraction)
10. [Concrete Implementations](#10-concrete-implementations)
11. [DIP Is About Dependency Direction](#11-dip-is-about-dependency-direction)
12. [Why Is It Called "Dependency Inversion"?](#12-why-is-it-called-dependency-inversion)
13. [Dependency Injection vs Dependency Inversion](#13-dependency-injection-vs-dependency-inversion)
14. [Simple Difference](#14-simple-difference)
15. [Dependency Injection Types](#15-dependency-injection-types)
16. [Constructor Injection](#16-constructor-injection)
17. [Why Constructor Injection Is Preferred](#17-why-constructor-injection-is-preferred)
18. [Setter Injection](#18-setter-injection)
19. [Method Injection](#19-method-injection)
20. [Constructor vs Setter vs Method Injection](#20-constructor-vs-setter-vs-method-injection)
21. [Composition Root](#21-composition-root)
22. [Why the Composition Root Matters](#22-why-the-composition-root-matters)
23. [Example: Payment System](#23-example-payment-system)
24. [Example: Cloud Storage](#24-example-cloud-storage)
25. [DIP With Multiple Variation Points](#25-dip-with-multiple-variation-points)
26. [Composition Instead of Class Explosion](#26-composition-instead-of-class-explosion)
27. [Bird Example](#27-bird-example)
28. [Bird With DIP](#28-bird-with-dip)
29. [Employee Example](#29-employee-example)
30. [Media Player Example](#30-media-player-example)
31. [Order Processing Example](#31-order-processing-example)
32. [Good Order Design](#32-good-order-design)
33. [Concrete Implementations (Order)](#33-concrete-implementations-order)
34. [Final OrderService](#34-final-orderservice)
35. [Final Client](#35-final-client)
36. [Switching Implementations](#36-switching-implementations)
37. [DIP Workflow](#37-dip-workflow)
38. [How to Identify a DIP Violation](#38-how-to-identify-a-dip-violation)
39. [Smell 4: Business Logic Knows Infrastructure](#39-smell-4-business-logic-knows-infrastructure)
40. [Smell 5: Difficult Testing](#40-smell-5-difficult-testing)
41. [DIP and Unit Testing](#41-dip-and-unit-testing)
42. [DIP and Loose Coupling](#42-dip-and-loose-coupling)
43. [DIP and Flexibility](#43-dip-and-flexibility)
44. [DIP and OCP](#44-dip-and-ocp)
45. [DIP and SRP](#45-dip-and-srp)
46. [DIP and LSP](#46-dip-and-lsp)
47. [DIP and ISP](#47-dip-and-isp)
48. [SOLID Relationship](#48-solid-relationship)
49. [DIP Does Not Mean "Interface Everywhere"](#49-dip-does-not-mean-interface-everywhere)
50. [DIP Does Not Mean "No Concrete Classes"](#50-dip-does-not-mean-no-concrete-classes)
51. [DIP Does Not Mean "Never Use new"](#51-dip-does-not-mean-never-use-new)
52. [DIP and Factory Pattern](#52-dip-and-factory-pattern)
53. [DIP and Dependency Injection Frameworks](#53-dip-and-dependency-injection-frameworks)
54. [Manual DI vs Framework DI](#54-manual-di-vs-framework-di)
55. [DIP in Real-World Architecture](#55-dip-in-real-world-architecture)
56. [Infrastructure vs Business Logic](#56-infrastructure-vs-business-logic)
57. [Common DIP Mistakes](#57-common-dip-mistakes)
58. [Quick DIP Identification Checklist](#58-quick-dip-identification-checklist)
59. [DIP Refactoring Process](#59-dip-refactoring-process)
60. [Before and After](#60-before-and-after)
61. [DIP Cheat Sheet](#61-dip-cheat-sheet)
62. [One-Line Definitions](#62-one-line-definitions)
63. [Interview Answer](#63-interview-answer)
64. [Simple Interview Example](#64-simple-interview-example)
65. [DIP vs OCP](#65-dip-vs-ocp)
66. [DIP vs SRP](#66-dip-vs-srp)
67. [DIP vs LSP](#67-dip-vs-lsp)
68. [DIP vs ISP](#68-dip-vs-isp)
69. [Complete SOLID Connection](#69-complete-solid-connection)
70. [Final Mental Model](#70-final-mental-model)
71. [Final DIP Example to Remember](#71-final-dip-example-to-remember)
72. [Final DIP Checklist](#72-final-dip-checklist)
73. [Final DIP Formula](#73-final-dip-formula)
74. [Final One-Minute Revision](#74-final-one-minute-revision)

---

## 1. SOLID Overview

| Letter | Principle |
|:------:|-----------|
| **S** | Single Responsibility Principle |
| **O** | Open/Closed Principle |
| **L** | Liskov Substitution Principle |
| **I** | Interface Segregation Principle |
| **D** | Dependency Inversion Principle |

DIP is primarily about dependency direction and decoupling high-level business logic from low-level implementation details.

---

## 2. What Is a Dependency?

A class depends on another class when it needs that class to perform its work.

```java
public class OrderService {

    private PaymentService paymentService;

    public void processOrder() {
        paymentService.pay();
    }
}
```

Here:

```text
OrderService ──► PaymentService
```

`OrderService` depends on `PaymentService`.

---

## 3. Concrete Dependency

Consider:

```java
public class OrderService {

    private StripePayment payment = new StripePayment();

    public void processOrder() {
        payment.pay();
    }
}
```

The dependency is:

```text
OrderService
    │
    ▼
StripePayment
```

The problem is that `OrderService` is directly coupled to Stripe. If tomorrow the application changes from Stripe to Razorpay, we have to modify `OrderService`.

```text
OrderService ──► StripePayment
        │
     CHANGE
        ▼
OrderService ──► RazorpayPayment
```

This is undesirable.

---

## 4. High-Level vs Low-Level Modules

Understanding these two terms is extremely important.

### High-Level Module

A high-level module contains the business logic or the main behavior of the application.

Examples: `OrderService`, `PaymentService`, `FoodDeliveryService`, `EmployeeService`, `BackupService`, `NotificationService`.

```java
public class OrderService {

    public void processOrder() {
        // Business logic
    }
}
```

`OrderService` represents an application/business operation.

### Low-Level Module

A low-level module usually contains implementation details.

Examples: `StripePayment`, `RazorpayPayment`, `MySQLRepository`, `MongoRepository`, `S3Storage`, `AzureBlobStorage`, `EmailNotification`, `SMSNotification`.

```java
public class StripePayment {

    public void pay(double amount) {
        System.out.println("Payment using Stripe");
    }
}
```

Stripe is an implementation detail.

---

## 5. The Problem DIP Solves

**Without DIP:**

```text
High-Level Module
    │
    ▼
Low-Level Concrete Module
```

```text
OrderService
    │
    ▼
StripePayment
```

Now the high-level business logic knows the implementation detail. This creates tight coupling.

---

## 6. Dependency Inversion

**With DIP:**

```text
High-Level Module
    │
    ▼
Abstraction
    ▲
    │
Low-Level Module
```

```text
OrderService
    │
    ▼
PaymentGateway
    ▲
    │
StripePayment
```

Now:

- `OrderService` depends on `PaymentGateway`.
- `StripePayment` implements `PaymentGateway`.
- `OrderService` does not know that Stripe exists.

---

## 7. The Two Rules of DIP

### Rule 1

> High-level modules should not depend on low-level modules. Both should depend on abstractions.

**Bad:**

```text
OrderService ──► StripePayment
```

**Good:**

```text
OrderService ──► PaymentGateway ◄── StripePayment
```

### Rule 2

> Abstractions should not depend on details. Details should depend on abstractions.

**Bad conceptual dependency:**

```text
Abstraction
    │
    ▼
Concrete implementation
```

**Good:**

```text
Abstraction
    ▲
    │
Concrete implementation
```

```text
PaymentGateway
    ▲
    │
StripePayment
```

`StripePayment` depends on the abstraction by implementing it.

---

## 8. The Most Important Mental Model

**BAD DESIGN**

```text
High-Level
    │
    ▼
Concrete Implementation
```

**DIP wants — GOOD DESIGN**

```text
High-Level
    │
    ▼
Abstraction
    ▲
    │
Concrete Implementation
```

This is the single most important diagram for DIP.

---

## 9. What Is an Abstraction?

An abstraction defines *what* can be done, without specifying exactly *how* it is done.

In Java, abstractions are commonly represented using interfaces or abstract classes.

```java
public interface PaymentGateway {

    void pay(double amount);
}
```

This says: *any payment gateway must provide a `pay()` operation.* It does not care whether payment is processed using Stripe, Razorpay, PayPal, cash, or bank transfer.

---

## 10. Concrete Implementations

**Stripe:**

```java
public class StripePayment implements PaymentGateway {

    @Override
    public void pay(double amount) {
        System.out.println("Payment processed using Stripe");
    }
}
```

**Razorpay:**

```java
public class RazorpayPayment implements PaymentGateway {

    @Override
    public void pay(double amount) {
        System.out.println("Payment processed using Razorpay");
    }
}
```

Both follow the same abstraction.

```text
PaymentGateway
      ▲
      │
  ┌───┴───┐
  ▼       ▼
Stripe  Razorpay
```

---

## 11. DIP Is About Dependency Direction

```text
OrderService ──► StripePayment
```

Dependency direction:

```text
Business Logic ──► Implementation Detail
```

DIP changes it to:

```text
OrderService ──► PaymentGateway
                       ▲
                       │
                 StripePayment
```

Now the dependency structure is:

```text
Business Logic
      │
      ▼
Abstraction
      ▲
      │
Implementation Detail
```

This is the "inversion" in Dependency Inversion Principle.

---

## 12. Why Is It Called "Dependency Inversion"?

Normally, we might naturally design:

```text
High-level business code
      │
      ▼
Concrete implementation
```

DIP reverses the dependency relationship by introducing an abstraction:

```text
High-level business code
      │
      ▼
   Interface
      ▲
      │
Concrete implementation
```

The business logic no longer depends directly on the implementation. The implementation now conforms to the abstraction.

---

## 13. Dependency Injection vs Dependency Inversion

These two concepts are related but not the same.

### Dependency Inversion Principle

DIP is a **design principle**. It tells us: *depend on abstractions rather than concrete implementations.*

### Dependency Injection

Dependency Injection is a **technique** used to provide dependencies from outside.

```java
public class OrderService {

    private final PaymentGateway paymentGateway;

    public OrderService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
}
```

The dependency is supplied from outside. That is Dependency Injection.

---

## 14. Simple Difference

```text
DIP = WHAT design should we follow?
DI  = HOW can we provide the dependency?
```

- **DIP:** `OrderService` should depend on `PaymentGateway`.
- **DI:** Give `PaymentGateway` to `OrderService` from outside.

---

## 15. Dependency Injection Types

We practiced three major forms of Dependency Injection:

1. Constructor Injection
2. Setter Injection
3. Method Injection

---

## 16. Constructor Injection

The dependency is passed through the constructor.

```java
public class BackupService {

    private final Storage storage;

    public BackupService(Storage storage) {
        this.storage = storage;
    }

    public void backup() {
        storage.upload();
    }
}
```

Client:

```java
Storage storage = new S3Storage();
BackupService service = new BackupService(storage);
service.backup();
```

Architecture:

```text
Client
  │ creates
  ▼
S3Storage
  │
  ▼
Storage
  │
  ▼
BackupService
```

Constructor injection is generally the preferred form when the dependency is required for the object to function.

---

## 17. Why Constructor Injection Is Preferred

It makes required dependencies explicit.

```java
public BackupService(Storage storage) {
    this.storage = storage;
}
```

Anyone creating `BackupService` immediately knows: *`BackupService` requires `Storage`.*

It also allows us to use `final`:

```java
private final Storage storage;
```

This means the dependency cannot accidentally be reassigned.

---

## 18. Setter Injection

The dependency is provided through a setter.

```java
public class BackupService {

    private Storage storage;

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public void backup() {
        storage.upload();
    }
}
```

Client:

```java
BackupService service = new BackupService();
service.setStorage(new S3Storage());
service.backup();
```

Setter injection can be useful when the dependency is optional or can change during the object's lifecycle.

---

## 19. Method Injection

The dependency is passed directly to the method.

```java
public class BackupService {

    public void backup(Storage storage) {
        storage.upload();
    }
}
```

Client:

```java
BackupService service = new BackupService();
service.backup(new S3Storage());
```

This is useful when the dependency is needed only for a specific operation.

---

## 20. Constructor vs Setter vs Method Injection

| Type | Dependency Location | Best Use |
|---|---|---|
| **Constructor** | Constructor | Required dependency |
| **Setter** | Setter method | Optional/changeable dependency |
| **Method** | Method parameter | Needed only for one operation |

```text
Required dependency          → Constructor Injection
Optional/changeable dependency → Setter Injection
Operation-specific dependency  → Method Injection
```

---

## 21. Composition Root

The **composition root** is the place where concrete implementations are created and connected.

```java
PaymentGateway payment = new StripePayment();
OrderRepository repository = new MySQLOrderRepository();
Notification notification = new EmailNotification();

OrderService service = new OrderService(payment, repository, notification);
```

The client/composition root decides which payment provider, which database, which notification provider, which storage provider. The business service does not make those decisions.

---

## 22. Why the Composition Root Matters

**Without a composition root:**

```text
OrderService
├── new StripePayment()
├── new MySQLRepository()
└── new EmailNotification()
```

**With a composition root:**

```text
Client
  ├──────────┬──────────┐
  ▼          ▼          ▼
Stripe     MySQL       Email
  └──────────┴──────────┘
              │
              ▼
        OrderService
              │
              ▼
        Abstractions
```

The business logic remains independent of infrastructure choices.

---

## 23. Example: Payment System

### Bad Design

```java
public class PaymentService {

    private StripePayment payment = new StripePayment();

    public void process(double amount) {
        payment.pay(amount);
    }
}
```

**Problem:** if Stripe is replaced with Razorpay, `PaymentService` must change.

### Good Design

**PaymentGateway**

```java
public interface PaymentGateway {

    void pay(double amount);
}
```

**StripePayment**

```java
public class StripePayment implements PaymentGateway {

    @Override
    public void pay(double amount) {
        System.out.println("Payment using Stripe");
    }
}
```

**RazorpayPayment**

```java
public class RazorpayPayment implements PaymentGateway {

    @Override
    public void pay(double amount) {
        System.out.println("Payment using Razorpay");
    }
}
```

**PaymentService**

```java
public class PaymentService {

    private final PaymentGateway paymentGateway;

    public PaymentService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }

    public void process(double amount) {
        paymentGateway.pay(amount);
    }
}
```

**Client**

```java
PaymentGateway gateway = new StripePayment();
PaymentService service = new PaymentService(gateway);
service.process(5000);
```

To switch:

```java
PaymentGateway gateway = new RazorpayPayment();
```

`PaymentService` does not change.

---

## 24. Example: Cloud Storage

Cloud storage is an excellent example for DIP. Possible providers: AWS S3, Azure Blob Storage, Google Cloud Storage.

### Bad Design

```java
public class BackupService {

    private final S3Storage storage = new S3Storage();

    public void backup() {
        storage.upload();
    }
}
```

Dependency:

```text
BackupService
      │
      ▼
  S3Storage
```

**Problem:** if S3 changes to Azure, `BackupService` needs modification.

### Good Design

**Storage**

```java
public interface Storage {

    void upload();
}
```

**S3Storage**

```java
public class S3Storage implements Storage {

    @Override
    public void upload() {
        System.out.println("Uploading to AWS S3");
    }
}
```

**AzureStorage**

```java
public class AzureStorage implements Storage {

    @Override
    public void upload() {
        System.out.println("Uploading to Azure Blob Storage");
    }
}
```

**BackupService**

```java
public class BackupService {

    private final Storage storage;

    public BackupService(Storage storage) {
        this.storage = storage;
    }

    public void backup() {
        storage.upload();
    }
}
```

**Client**

```java
Storage storage = new S3Storage();
BackupService service = new BackupService(storage);
service.backup();
```

Switch to Azure:

```java
Storage storage = new AzureStorage();
BackupService service = new BackupService(storage);
service.backup();
```

`BackupService` remains unchanged.

---

## 25. DIP With Multiple Variation Points

Cloud storage becomes more interesting when we have:

1. Storage provider
2. Encryption strategy

Possible combinations:

```text
S3 + AES
S3 + RSA
Azure + AES
Azure + RSA
GCP + AES
GCP + RSA
```

A bad design might create classes such as `S3AES`, `S3RSA`, `AzureAES`, `AzureRSA`, `GCPAES`, `GCPRSA`. This creates **class explosion**.

---

## 26. Composition Instead of Class Explosion

Create two abstractions.

**Storage**

```java
public interface Storage {

    void upload();
}
```

**Encryption**

```java
public interface Encryption {

    void encrypt();
}
```

Now compose them:

```java
public class CloudStorageService {

    private final Storage storage;
    private final Encryption encryption;

    public CloudStorageService(Storage storage, Encryption encryption) {
        this.storage = storage;
        this.encryption = encryption;
    }

    public void backup() {
        encryption.encrypt();
        storage.upload();
    }
}
```

Now we can combine implementations freely.

```java
Storage storage = new S3Storage();
Encryption encryption = new AESEncryption();

CloudStorageService service = new CloudStorageService(storage, encryption);
```

Another combination:

```java
Storage storage = new AzureStorage();
Encryption encryption = new RSAEncryption();

CloudStorageService service = new CloudStorageService(storage, encryption);
```

No new combination-specific class is required.

---

## 27. Bird Example

Bird is useful for understanding DIP together with the other SOLID principles.

```java
public class Bird {

    public void eat() {
        System.out.println("Bird eating");
    }

    public void sleep() {
        System.out.println("Bird sleeping");
    }

    public void saveToDatabase() {
        System.out.println("Saving bird");
    }

    public void sendNotification() {
        System.out.println("Sending notification");
    }
}
```

There are multiple responsibilities here — this first violates SRP. But there can also be a DIP issue if business logic directly depends on a concrete database.

---

## 28. Bird With DIP

**BirdRepository**

```java
public interface BirdRepository {

    void save(Bird bird);
}
```

**MySQLBirdRepository**

```java
public class MySQLBirdRepository implements BirdRepository {

    @Override
    public void save(Bird bird) {
        System.out.println("Saving bird to MySQL");
    }
}
```

**BirdService**

```java
public class BirdService {

    private final BirdRepository repository;

    public BirdService(BirdRepository repository) {
        this.repository = repository;
    }

    public void saveBird(Bird bird) {
        repository.save(bird);
    }
}
```

Now `BirdService` does not care whether we use MySQL, MongoDB, PostgreSQL, or file storage. It depends on `BirdRepository`.

---

## 29. Employee Example

**Bad design:**

```java
public class EmployeeService {

    private final MySQLEmployeeRepository repository = new MySQLEmployeeRepository();

    public void save(Employee employee) {
        repository.save(employee);
    }
}
```

**Good design:**

**EmployeeRepository**

```java
public interface EmployeeRepository {

    void save(Employee employee);
}
```

**MySQLEmployeeRepository**

```java
public class MySQLEmployeeRepository implements EmployeeRepository {

    @Override
    public void save(Employee employee) {
        System.out.println("Saving employee to MySQL");
    }
}
```

**EmployeeService**

```java
public class EmployeeService {

    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public void save(Employee employee) {
        repository.save(employee);
    }
}
```

---

## 30. Media Player Example

Suppose our application supports MP3, MP4, and WAV.

**Bad design:**

```java
public class MediaPlayer {

    public void play(String type) {

        if (type.equals("MP3")) {
            // MP3 logic
        } else if (type.equals("MP4")) {
            // MP4 logic
        } else if (type.equals("WAV")) {
            // WAV logic
        }
    }
}
```

This can become tightly coupled to every media implementation.

**Better design:**

**Playable**

```java
public interface Playable {

    void play();
}
```

**MP3Media**

```java
public class MP3Media implements Playable {

    @Override
    public void play() {
        System.out.println("Playing MP3");
    }
}
```

**MP4Media**

```java
public class MP4Media implements Playable {

    @Override
    public void play() {
        System.out.println("Playing MP4");
    }
}
```

**MediaPlayer**

```java
public class MediaPlayer {

    private final Playable media;

    public MediaPlayer(Playable media) {
        this.media = media;
    }

    public void play() {
        media.play();
    }
}
```

Now:

```text
MediaPlayer
      │
      ▼
  Playable
      ▲
      │
  ┌───┴───┐
  ▼       ▼
 MP3     MP4
```

---

## 31. Order Processing Example

This was our final integrated DIP example. The system had payment, repository, notification, and invoice generation.

### Bad Design

```java
public class OrderService {

    private final StripePayment payment = new StripePayment();
    private final MySQLOrderRepository repository = new MySQLOrderRepository();
    private final EmailNotification notification = new EmailNotification();
    private final InvoiceGenerator invoiceGenerator = new InvoiceGenerator();

    public void processOrder(String orderId, double amount) {
        payment.pay(amount);
        repository.save(orderId);
        invoiceGenerator.generate(orderId, amount);
        notification.send("Order processed");
    }
}
```

Dependency graph:

```text
OrderService
   ├── Stripe
   ├── MySQL
   ├── Email
   └── Invoice
```

This is tightly coupled.

---

## 32. Good Order Design

Create abstractions.

**PaymentGateway**

```java
public interface PaymentGateway {

    void pay(double amount);
}
```

**OrderRepository**

```java
public interface OrderRepository {

    void save(String orderId);
}
```

**Notification**

```java
public interface Notification {

    void send(String message);
}
```

**InvoiceGenerator**

```java
public interface InvoiceGenerator {

    void generate(String orderId, double amount);
}
```

---

## 33. Concrete Implementations (Order)

**Stripe:**

```java
public class StripePayment implements PaymentGateway {

    @Override
    public void pay(double amount) {
        System.out.println("Payment processed using Stripe");
    }
}
```

**Razorpay:**

```java
public class RazorpayPayment implements PaymentGateway {

    @Override
    public void pay(double amount) {
        System.out.println("Payment processed using Razorpay");
    }
}
```

**MySQL:**

```java
public class MySQLOrderRepository implements OrderRepository {

    @Override
    public void save(String orderId) {
        System.out.println("Order saved to MySQL");
    }
}
```

**MongoDB:**

```java
public class MongoOrderRepository implements OrderRepository {

    @Override
    public void save(String orderId) {
        System.out.println("Order saved to MongoDB");
    }
}
```

**Email:**

```java
public class EmailNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("Email sent: " + message);
    }
}
```

**SMS:**

```java
public class SMSNotification implements Notification {

    @Override
    public void send(String message) {
        System.out.println("SMS sent: " + message);
    }
}
```

---

## 34. Final OrderService

```java
public class OrderService {

    private final PaymentGateway paymentGateway;
    private final OrderRepository orderRepository;
    private final Notification notification;
    private final InvoiceGenerator invoiceGenerator;

    public OrderService(
            PaymentGateway paymentGateway,
            OrderRepository orderRepository,
            Notification notification,
            InvoiceGenerator invoiceGenerator) {

        this.paymentGateway = paymentGateway;
        this.orderRepository = orderRepository;
        this.notification = notification;
        this.invoiceGenerator = invoiceGenerator;
    }

    public void processOrder(String orderId, double amount) {
        paymentGateway.pay(amount);
        orderRepository.save(orderId);
        invoiceGenerator.generate(orderId, amount);
        notification.send("Order " + orderId + " processed");
    }
}
```

Notice: `OrderService` does not contain `new StripePayment()`, `new RazorpayPayment()`, `new MySQLOrderRepository()`, `new MongoOrderRepository()`, `new EmailNotification()`, or `new SMSNotification()`. It only knows abstractions.

---

## 35. Final Client

```java
public class OrderClient {

    public static void main(String[] args) {

        PaymentGateway paymentGateway = new StripePayment();
        OrderRepository orderRepository = new MySQLOrderRepository();
        Notification notification = new EmailNotification();
        InvoiceGenerator invoiceGenerator = new PDFInvoiceGenerator();

        OrderService orderService = new OrderService(
                paymentGateway,
                orderRepository,
                notification,
                invoiceGenerator
        );

        orderService.processOrder("ORD-101", 5000);
    }
}
```

The client performs the wiring.

---

## 36. Switching Implementations

**Current configuration:**

```text
Stripe + MySQL + Email + PDF
```

**Change to:**

```text
Razorpay + MongoDB + SMS + PDF
```

Only the composition changes:

```java
PaymentGateway payment = new RazorpayPayment();
OrderRepository repository = new MongoOrderRepository();
Notification notification = new SMSNotification();
```

`OrderService` remains unchanged. This is one of the strongest indicators that the design has good dependency inversion.

---

## 37. DIP Workflow

```text
1. Identify the high-level business logic
        │
        ▼
2. Identify dependencies
        │
        ▼
3. Ask: "Are these concrete implementation details?"
        │
        ▼
4. If yes, introduce an abstraction
        │
        ▼
5. Make the high-level module depend on the abstraction
        │
        ▼
6. Make concrete implementations implement the abstraction
        │
        ▼
7. Inject dependencies from outside
        │
        ▼
8. Wire everything in the client/composition root
```

---

## 38. How to Identify a DIP Violation

**Smell 1 — `new` inside business logic**

```java
class OrderService {

    private Payment payment = new StripePayment();
}
```
Ask: *why does the business service know which implementation to create?*

**Smell 2 — Concrete class as a field**

```java
private MySQLRepository repository;
```
Ask: *does this high-level class really need to know about MySQL?*

**Smell 3 — Concrete class as constructor dependency**

Even this can be a problem:

```java
public OrderService(StripePayment payment) {
}
```

Because the high-level module is still coupled to Stripe. Prefer:

```java
public OrderService(PaymentGateway payment) {
}
```

---

## 39. Smell 4: Business Logic Knows Infrastructure

If a class containing business logic directly knows about MySQL, MongoDB, AWS, Azure, Stripe, Razorpay, SMTP, Kafka, or Redis, investigate whether DIP is being violated.

It doesn't automatically mean there is a violation, but it is a strong design smell.

---

## 40. Smell 5: Difficult Testing

Suppose:

```java
public class OrderService {

    private final StripePayment payment = new StripePayment();
}
```

How do we easily test what happens when payment fails? We are forced to use the real Stripe implementation or somehow manipulate the class.

With DIP:

```text
PaymentGateway
      ▲
      │
FakePaymentGateway
```

We can provide a fake implementation during testing.

---

## 41. DIP and Unit Testing

DIP makes unit testing easier because dependencies can be replaced.

```java
public class FakePayment implements PaymentGateway {

    @Override
    public void pay(double amount) {
        System.out.println("Fake payment");
    }
}
```

Test:

```java
PaymentGateway payment = new FakePayment();
PaymentService service = new PaymentService(payment);
```

We can test the business logic without calling a real payment provider.

---

## 42. DIP and Loose Coupling

DIP helps us achieve loose coupling.

**Bad:**

```text
OrderService ──► StripePayment
```

Strong coupling.

**Good:**

```text
OrderService ──► PaymentGateway ◄── StripePayment
```

Now `OrderService` is coupled to the abstraction rather than the implementation.

---

## 43. DIP and Flexibility

```text
PaymentGateway
      ▲
      │
  ┌───┴────┐
  ▼        ▼
Stripe   Razorpay
```

We can add `PayPalPayment → PaymentGateway` without modifying `PaymentService`. The system becomes easier to extend.

---

## 44. DIP and OCP

DIP and OCP are strongly related.

OCP says: *software should be open for extension but closed for modification.* DIP helps us achieve this.

```text
PaymentGateway ◄── StripePayment
```

Later:

```text
PaymentGateway ◄── RazorpayPayment
```

We added a new implementation without modifying the high-level service.

```text
DIP
 └── Depend on abstraction
       └── New implementation can be added
             └── Existing business logic remains unchanged
                   └── Supports OCP
```

---

## 45. DIP and SRP

SRP says: *a class should have one reason to change.*

Suppose:

```text
OrderService
├── business logic
├── MySQL details
├── Email details
└── Stripe details
```

Now changes in database, email, or payment implementation can force `OrderService` to change. DIP separates those technical dependencies. So SRP and DIP often work together.

---

## 46. DIP and LSP

LSP says: *subtypes should be substitutable for their base abstraction.*

```text
PaymentGateway ◄── StripePayment
```

`StripePayment` should correctly fulfill the contract defined by `PaymentGateway`. DIP tells us to depend on the abstraction. LSP tells us implementations must behave correctly according to that abstraction.

---

## 47. DIP and ISP

ISP says: *clients should not be forced to depend on interfaces they do not need.*

```java
interface Storage {

    void upload();

    void download();

    void delete();

    void encrypt();

    void generateReport();
}
```

This may be too large. ISP can help us create focused abstractions. Then DIP allows high-level modules to depend on those focused abstractions. So the principles complement each other.

---

## 48. SOLID Relationship

```text
SRP → Separate responsibilities
OCP → Extend without modifying existing behavior
LSP → Implementations must honor abstractions
ISP → Keep abstractions focused
DIP → High-level code depends on abstractions
```

Together they help create:

```text
High Cohesion + Low Coupling + Flexible Architecture + Testable Code
```

---

## 49. DIP Does Not Mean "Interface Everywhere"

This is a very important point.

**Bad interpretation:** *every class must have an interface.* That is not DIP.

```java
public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }
}
```

We don't automatically need `interface CalculatorInterface` just because DIP exists. Use abstractions where they provide meaningful decoupling.

Good candidates often include: external systems, databases, payment providers, storage providers, messaging systems, notification systems, APIs, pluggable strategies.

---

## 50. DIP Does Not Mean "No Concrete Classes"

Concrete classes are completely fine. The problem is unnecessary dependency from high-level business logic to implementation details.

```text
OrderService ──► PaymentGateway ◄── StripePayment
```

`StripePayment` is still concrete. DIP does not eliminate concrete implementations. It changes *who depends on whom*.

---

## 51. DIP Does Not Mean "Never Use new"

This is another common misunderstanding.

Using `new StripePayment()` is not automatically wrong. The important question is: **where** is the concrete dependency created?

Prefer creating concrete implementations at the composition root.

```java
PaymentGateway payment = new StripePayment();
OrderService service = new OrderService(payment);
```

instead of:

```java
public class OrderService {

    private PaymentGateway payment;

    public OrderService() {
        payment = new StripePayment();
    }
}
```

The first approach keeps infrastructure decisions outside the business class.

---

## 52. DIP and Factory Pattern

Sometimes a factory can be used to create concrete implementations.

```java
PaymentGateway payment = PaymentFactory.create("STRIPE");
```

The factory hides creation logic. However, the high-level module should still ideally depend on the abstraction. Factory and DIP can work together.

---

## 53. DIP and Dependency Injection Frameworks

Frameworks such as Spring make dependency injection easier.

```java
@Component
class OrderService {

    private final PaymentGateway paymentGateway;

    public OrderService(PaymentGateway paymentGateway) {
        this.paymentGateway = paymentGateway;
    }
}
```

The framework can determine which implementation should be injected. But remember: **DIP is a principle. Dependency Injection frameworks are tools.** You can implement DIP manually without Spring.

---

## 54. Manual DI vs Framework DI

**Manual:**

```java
PaymentGateway payment = new StripePayment();
OrderService service = new OrderService(payment);
```

**Framework:**

```text
OrderService
      │
      ▼
PaymentGateway
      ▲
      │
Spring injects implementation
```

The principle remains the same.

---

## 55. DIP in Real-World Architecture

A common architecture looks like:

```text
Controller
    │
    ▼
Service           HIGH LEVEL
    │
    ▼
Abstraction
    ▲
    │
Repository        LOW LEVEL
    │
    ▼
Database
```

```text
OrderController
      │
      ▼
 OrderService
      │
      ▼
OrderRepository
      ▲
      │
MySQLOrderRepository
      │
      ▼
    MySQL
```

The business service doesn't need to know the database implementation details.

---

## 56. Infrastructure vs Business Logic

**Business logic:** `OrderService`, `PaymentService`, `EmployeeService`, `FoodDeliveryService`, `BackupService`.

**Infrastructure:** MySQL, MongoDB, AWS S3, Stripe, Razorpay, SMTP, Kafka, Redis.

DIP helps keep:

```text
Business Logic
      │
      ▼
Abstraction
      ▲
      │
Infrastructure
```

---

## 57. Common DIP Mistakes

**Mistake 1 — Creating concrete dependencies inside the high-level class**

```java
class OrderService {

    private StripePayment payment = new StripePayment();
}
```

**Mistake 2 — Creating an abstraction but still depending on the concrete implementation**

```java
class OrderService {

    private PaymentGateway gateway;

    public OrderService() {
        gateway = new StripePayment();
    }
}
```

Although the field uses the interface, the class is still responsible for selecting the concrete implementation. Better:

```java
public OrderService(PaymentGateway gateway) {
    this.gateway = gateway;
}
```

**Mistake 3 — Creating unnecessary interfaces**

Don't create abstractions simply to say *"I am following DIP."* The abstraction should provide useful decoupling.

**Mistake 4 — Huge interfaces**

If an abstraction contains unrelated responsibilities, ISP may also be violated.

**Mistake 5 — Confusing DIP with DI**

DIP is the principle. DI is one technique for implementing the principle.

---

## 58. Quick DIP Identification Checklist

When reviewing a class, ask:

1. Is this a high-level business module?
2. Does it directly depend on a concrete implementation?
3. Does it create that implementation using `new`?
4. Could the implementation change in the future?
5. Would changing the implementation require modifying the business class?
6. Can an abstraction represent the dependency?
7. Can the dependency be injected?

If the answers indicate tight coupling, investigate DIP.

---

## 59. DIP Refactoring Process

Suppose we have:

```text
OrderService
      │
      ▼
StripePayment
```

**Step 1 — Identify the dependency:** `StripePayment`.

**Step 2 — Ask what capability the business logic actually needs:** `PaymentGateway`.

**Step 3 — Create abstraction:**

```java
interface PaymentGateway {

    void pay(double amount);
}
```

**Step 4 — Make the concrete implementation implement it:**

```java
class StripePayment implements PaymentGateway {
}
```

**Step 5 — Change high-level class:**

```java
class OrderService {

    private final PaymentGateway paymentGateway;
}
```

**Step 6 — Inject the dependency:**

```java
public OrderService(PaymentGateway paymentGateway) {
    this.paymentGateway = paymentGateway;
}
```

**Step 7 — Create and wire dependencies outside:**

```java
PaymentGateway payment = new StripePayment();
OrderService service = new OrderService(payment);
```

Done.

---

## 60. Before and After

### Before

```java
class BackupService {

    private final S3Storage storage = new S3Storage();

    public void backup() {
        storage.upload();
    }
}
```

Dependency:

```text
BackupService ──► S3Storage
```

### After

```java
interface Storage {

    void upload();
}

class S3Storage implements Storage {

    public void upload() {
        System.out.println("S3");
    }
}

class BackupService {

    private final Storage storage;

    public BackupService(Storage storage) {
        this.storage = storage;
    }

    public void backup() {
        storage.upload();
    }
}
```

Dependency:

```text
BackupService ──► Storage ◄── S3Storage
```

---

## 61. DIP Cheat Sheet

| Concept | Meaning |
|---|---|
| **DIP** | Depend on abstractions |
| **High-level module** | Business logic |
| **Low-level module** | Implementation details |
| **Abstraction** | Contract/interface |
| **Dependency Injection** | Technique for supplying dependencies |
| **Constructor Injection** | Dependency through constructor |
| **Setter Injection** | Dependency through setter |
| **Method Injection** | Dependency through method |
| **Composition Root** | Place where dependencies are wired |
| **Loose Coupling** | Less dependency on concrete implementations |
| **Testability** | Easier to replace dependencies |
| **Flexibility** | Easier to switch implementations |

---

## 62. One-Line Definitions

- **Dependency** — a class/module that another class needs to perform its work.
- **Abstraction** — a contract describing what something can do without exposing implementation details.
- **High-Level Module** — a module containing business/application logic.
- **Low-Level Module** — a module containing implementation or infrastructure details.
- **Dependency Injection** — providing a dependency from outside instead of creating it internally.
- **Dependency Inversion Principle** — high-level modules and low-level modules should depend on abstractions rather than directly depending on each other.

---

## 63. Interview Answer

**What is Dependency Inversion Principle?**

> The Dependency Inversion Principle states that high-level modules should not depend directly on low-level modules. Both should depend on abstractions. It also states that abstractions should not depend on implementation details; implementation details should depend on abstractions. In Java, this is commonly achieved using interfaces and dependency injection.

---

## 64. Simple Interview Example

**Question:** Why should `OrderService` not directly create `StripePayment`?

**Answer:** Because Stripe is an implementation detail. If `OrderService` creates `StripePayment`, it becomes tightly coupled to Stripe. Replacing Stripe with Razorpay would require modifying `OrderService`.

Instead:

```text
OrderService ──► PaymentGateway ◄── StripePayment
```

`OrderService` depends on the abstraction, and Stripe implements that abstraction. The concrete dependency can then be injected from outside.

---

## 65. DIP vs OCP

| DIP | OCP |
|---|---|
| Focuses on dependency direction | Focuses on modification/extension |
| Depend on abstractions | Open for extension |
| Reduces coupling | Reduces modification |
| Uses abstractions | Uses abstractions/polymorphism |
| Helps make architecture flexible | Helps add new behavior safely |

They often work together.

---

## 66. DIP vs SRP

| SRP | DIP |
|---|---|
| Focuses on responsibility | Focuses on dependencies |
| One reason to change | Depend on abstractions |
| Improves cohesion | Reduces coupling |
| Separates responsibilities | Separates business logic from implementation details |

---

## 67. DIP vs LSP

| DIP | LSP |
|---|---|
| Focuses on dependency direction | Focuses on substitutability |
| Depend on abstractions | Implementations must honor abstraction |
| Reduces coupling | Prevents incorrect inheritance/substitution |

---

## 68. DIP vs ISP

| DIP | ISP |
|---|---|
| Depend on abstractions | Keep abstractions small |
| Focuses on dependency direction | Focuses on interface design |
| Reduces coupling | Prevents unnecessary dependencies |

---

## 69. Complete SOLID Connection

```text
                    SOLID
        ┌─────────────┼─────────────┐
        ▼              ▼              ▼
      SRP             OCP            LSP
        │              │              │
   Separate       Extend safely      Safe
   concerns       without         substitution
                  modification
                       │
                  ┌────┴────┐
                  ▼         
                 ISP
                  │
          Focused contracts
                  │
                  ▼
                 DIP
                  │
          Depend on abstractions
                  │
                  ▼
             Loose coupling
```

---

## 70. Final Mental Model

Whenever you see:

```text
Business Logic
      │
      ▼
Concrete Technology
```

ask: *can I introduce an abstraction between them?*

Then transform it into:

```text
Business Logic
      │
      ▼
Abstraction
      ▲
      │
Concrete Technology
```

Then inject the dependency:

```text
Client / Composition Root
         │
         ▼
Concrete Implementation
         │
         ▼
    Abstraction
         ▲
         │
   Business Service
```

This is the essence of DIP.

---

## 71. Final DIP Example to Remember

Imagine an online shopping application. The business service needs payment, database, notification, and invoice.

**Bad:**

```text
OrderService
├── StripePayment
├── MySQLRepository
├── EmailNotification
└── PDFInvoice
```

**Good:**

```text
OrderService
   ├──────────────┬──────────────┐
   ▼               ▼               ▼
PaymentGateway  OrderRepository  Notification
   ▲               ▲               ▲
   │               │               │
Stripe          MySQL           Email
Razorpay        Mongo             SMS

              InvoiceGenerator
                     ▲
                     │
                PDFInvoice
```

And the client/composition root wires everything:

```java
PaymentGateway payment = new StripePayment();
OrderRepository repository = new MySQLOrderRepository();
Notification notification = new EmailNotification();
InvoiceGenerator invoice = new PDFInvoiceGenerator();

OrderService service = new OrderService(
        payment,
        repository,
        notification,
        invoice
);
```

The business service doesn't care which implementation is being used. That is the core benefit of DIP.

---

## 72. Final DIP Checklist

Before considering a design DIP-friendly, verify:

- [ ] High-level business logic does not directly depend on infrastructure details.
- [ ] Important replaceable dependencies have abstractions.
- [ ] High-level modules depend on interfaces/abstractions.
- [ ] Concrete implementations implement those abstractions.
- [ ] Concrete dependencies are not unnecessarily created inside business classes.
- [ ] Dependencies can be injected.
- [ ] Constructor injection is used for required dependencies.
- [ ] Setter injection is used where dependencies are optional/changeable.
- [ ] Method injection is used where a dependency is operation-specific.
- [ ] Dependency wiring happens at the composition root.
- [ ] Implementations can be replaced without modifying high-level business logic.
- [ ] Dependencies can be replaced easily during unit testing.
- [ ] Interfaces are meaningful and not created unnecessarily.
- [ ] Interfaces remain focused and work well with ISP.

---

## 73. Final DIP Formula

```text
High-Level Business Logic
         │
         ▼
    Abstraction
         ▲
         │
    Implementation
```

```text
DIP              = Depend on abstractions
DI               = Inject the dependencies
Composition Root = Wire the dependencies
Result           = Loose Coupling + Flexibility + Testability
```

---

## 74. Final One-Minute Revision

If you have only one minute before an interview, remember:

1. DIP is the D in SOLID.
2. High-level modules should not depend directly on low-level modules.
3. Both should depend on abstractions.
4. Abstractions should not depend on implementation details.
5. Implementation details should depend on abstractions.
6. Interfaces are commonly used as abstractions in Java.
7. Dependency Injection is a technique that helps implement DIP.
8. Constructor injection is generally preferred for required dependencies.
9. Setter injection is useful for optional/changeable dependencies.
10. Method injection is useful when a dependency is needed for one operation.
11. The composition root should decide concrete implementations.
12. DIP reduces coupling.
13. DIP improves testability.
14. DIP makes replacing infrastructure easier.
15. DIP often works together with SRP, OCP, LSP, and ISP.

The core diagram to remember:

```text
BAD
OrderService ──► StripePayment

GOOD
OrderService ──► PaymentGateway ◄── StripePayment
```

If you remember this dependency direction, you understand the heart of DIP.