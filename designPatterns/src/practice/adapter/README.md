# Adapter Design Pattern

The **Adapter Design Pattern** is a Structural Design Pattern that allows incompatible classes or APIs to work together by converting the interface of one class into an interface expected by the client.

---

## Table of Contents

1. [Introduction](#1-introduction)
2. [What Problem Does Adapter Solve?](#2-what-problem-does-adapter-solve)
3. [Without Adapter](#3-without-adapter)
4. [With Adapter](#4-with-adapter)
5. [Core Idea](#5-core-idea)
6. [Adapter Structure](#6-adapter-structure)
7. [Participants](#7-participants)
8. [Basic Example](#8-basic-example)
9. [Before / After Adapter](#9-before--after-adapter)
10. [Why Adapter Is Better](#10-why-adapter-is-better)
11. [Object Adapter](#11-object-adapter)
12. [Class Adapter](#12-class-adapter)
13. [Object Adapter vs Class Adapter](#13-object-adapter-vs-class-adapter)
14. [Multiple Adapters](#14-multiple-adapters)
15. [DTO Mapping](#15-dto-mapping)
16. [Exception Translation](#16-exception-translation)
17. [Third-Party API Integration](#17-third-party-api-integration)
18. [Adapter as an Integration Boundary](#18-adapter-as-an-integration-boundary)
19. [Anti-Corruption Layer](#19-anti-corruption-layer)
20. [API Versioning](#20-api-versioning)
21. [Adapter + Factory](#21-adapter--factory)
22. [Adapter + Dependency Injection](#22-adapter--dependency-injection)
23. [Two-Way Adapter](#23-two-way-adapter)
24. [Adapter vs Wrapper](#24-adapter-vs-wrapper)
25. [Adapter vs Decorator](#25-adapter-vs-decorator)
26. [Adapter vs Facade](#26-adapter-vs-facade)
27. [Adapter vs Factory / Builder / Prototype / Registry / Singleton](#27-adapter-vs-factory--builder--prototype--registry--singleton)
28. [SOLID Analysis](#28-solid-analysis)
29. [Testing Adapter](#29-testing-adapter)
30. [Common Mistakes](#30-common-mistakes)
31. [When to Use Adapter](#31-when-to-use-adapter)
32. [When Not to Use Adapter](#32-when-not-to-use-adapter)
33. [Part 1 Practice](#33-part-1-practice)
34. [Part 2 Practice](#34-part-2-practice)
35. [Part 3 Practice](#35-part-3-practice)
36. [Final Production LLD](#36-final-production-lld)
37. [Complete Production Implementation](#37-complete-production-implementation)
38. [Design Decisions](#38-design-decisions)
39. [Possible Extensions](#39-possible-extensions)
40. [Adapter and Business Logic](#40-adapter-and-business-logic)
41. [Adapter as a Boundary](#41-adapter-as-a-boundary)
42. [Key Mental Model](#42-key-mental-model)
43. [Interview Questions](#43-interview-questions)
44. [Common Interview Traps](#44-common-interview-traps)
45. [Adapter Pattern Summary](#45-adapter-pattern-summary)
46. [Adapter Golden Rules](#46-adapter-golden-rules)
47. [Adapter Checklist](#47-adapter-checklist)
48. [Design Patterns Progress](#48-design-patterns-progress)
49. [Final Takeaway](#49-final-takeaway)
50. [One-Line Interview Definition](#50-one-line-interview-definition)

---

## 1. Introduction

Adapter is a **Structural Design Pattern**. Its purpose is to make two incompatible interfaces work together.

The key idea is:

> Do not change the existing class. Adapt it to the interface your application expects.

For example, suppose our application expects:

```java
interface PaymentProcessor {

    void pay(double amount);
}
```

But a third-party payment SDK provides:

```java
class RazorpayGateway {

    public void makePayment(double amount) {
        System.out.println("Payment processed using Razorpay");
    }
}
```

These two interfaces are incompatible. Instead of changing `RazorpayGateway`, we create an Adapter.

```text
Client
   │
   ▼
PaymentProcessor
   │
   ▼
RazorpayAdapter
   │
   ▼
RazorpayGateway
```

The Adapter converts:

```text
Application Interface
        │
        ▼
     Adapter
        │
        ▼
Third-Party Interface
```

---

## 2. What Problem Does Adapter Solve?

Imagine our application was designed around this interface:

```java
interface PaymentProcessor {

    void pay(double amount);
}
```

Our business logic uses:

```java
class CheckoutService {

    private final PaymentProcessor paymentProcessor;

    public CheckoutService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(double amount) {
        paymentProcessor.pay(amount);
    }
}
```

Now suppose we integrate Razorpay. The third-party API is:

```java
class RazorpayGateway {

    public void makePayment(double amount) {
        System.out.println("Razorpay payment: " + amount);
    }
}
```

The method names are different. Our application expects `pay()`. Razorpay provides `makePayment()`. Therefore:

```text
PaymentProcessor  ✗  RazorpayGateway
```

The application cannot directly use the third-party class through the expected interface.

---

## 3. Without Adapter

We could modify our business logic:

```java
class CheckoutService {

    private final RazorpayGateway razorpayGateway;

    public CheckoutService(RazorpayGateway razorpayGateway) {
        this.razorpayGateway = razorpayGateway;
    }

    public void checkout(double amount) {
        razorpayGateway.makePayment(amount);
    }
}
```

This works. But now the business logic depends directly on Razorpay.

```text
CheckoutService
      │
      ▼
RazorpayGateway
```

**Problems:**

- Business logic depends on vendor-specific code.
- Replacing Razorpay becomes difficult.
- Testing becomes harder.
- Vendor details leak into application code.
- Adding Stripe may require changing `CheckoutService`.
- Tight coupling increases.

---

## 4. With Adapter

Create an adapter:

```java
class RazorpayAdapter implements PaymentProcessor {

    private final RazorpayGateway gateway;

    public RazorpayAdapter(RazorpayGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void pay(double amount) {
        gateway.makePayment(amount);
    }
}
```

Now:

```text
CheckoutService
      │
      ▼
PaymentProcessor
      │
      ▼
RazorpayAdapter
      │
      ▼
RazorpayGateway
```

The business logic knows only `PaymentProcessor`. It does not know that Razorpay exists.

---

## 5. Core Idea

The most important thing to remember:

> Adapter changes the interface, not the responsibility.

The Adapter translates one interface into another.

```text
Existing Interface
        │  incompatible
        ▼
     Adapter
        │  compatible
        ▼
Expected Interface
```

---

## 6. Adapter Structure

The classic structure is:

```text
Client
   │
   ▼
Target
   ▲
   │
Adapter
   │
   ▼
Adaptee
```

Where:

- **Client** — code that needs the functionality.
- **Target** — interface expected by Client.
- **Adapter** — converts Target calls into Adaptee calls.
- **Adaptee** — existing incompatible class.

---

## 7. Participants

### 1. Target

The interface expected by the application.

```java
interface PaymentProcessor {

    void pay(double amount);
}
```

### 2. Adaptee

The existing incompatible class.

```java
class RazorpayGateway {

    public void makePayment(double amount) {
        System.out.println("Razorpay payment");
    }
}
```

### 3. Adapter

The class that translates the Target interface into the Adaptee interface.

```java
class RazorpayAdapter implements PaymentProcessor {

    private final RazorpayGateway gateway;

    public RazorpayAdapter(RazorpayGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void pay(double amount) {
        gateway.makePayment(amount);
    }
}
```

### 4. Client

The application code using the Target interface.

```java
class CheckoutService {

    private final PaymentProcessor paymentProcessor;

    public CheckoutService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(double amount) {
        paymentProcessor.pay(amount);
    }
}
```

The Client does not know about the Adaptee.

---

## 8. Basic Example

**Target**

```java
interface PaymentProcessor {

    void pay(double amount);
}
```

**Adaptee**

```java
class RazorpayGateway {

    public void makePayment(double amount) {
        System.out.println("Razorpay payment: " + amount);
    }
}
```

**Adapter**

```java
class RazorpayAdapter implements PaymentProcessor {

    private final RazorpayGateway gateway;

    public RazorpayAdapter(RazorpayGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void pay(double amount) {
        gateway.makePayment(amount);
    }
}
```

**Client**

```java
class CheckoutService {

    private final PaymentProcessor paymentProcessor;

    public CheckoutService(PaymentProcessor paymentProcessor) {
        this.paymentProcessor = paymentProcessor;
    }

    public void checkout(double amount) {
        paymentProcessor.pay(amount);
    }
}
```

**Main**

```java
public class Main {

    public static void main(String[] args) {

        RazorpayGateway gateway = new RazorpayGateway();
        PaymentProcessor processor = new RazorpayAdapter(gateway);
        CheckoutService checkoutService = new CheckoutService(processor);

        checkoutService.checkout(1000);
    }
}
```

---

## 9. Before / After Adapter

**Before Adapter**

```text
CheckoutService
      │
      ▼
RazorpayGateway

Application depends directly on vendor API.
```

**After Adapter**

```text
CheckoutService
      │
      ▼
PaymentProcessor
      ▲
      │
RazorpayAdapter
      │
      ▼
RazorpayGateway
```

The application depends on its own abstraction.

---

## 10. Why Adapter Is Better

**1. Reduces Coupling**
Business logic no longer directly depends on third-party APIs.

**2. Makes Vendor Replacement Easier**
We can add `RazorpayAdapter`, `StripeAdapter`, `PayPalAdapter` without changing the business logic.

**3. Isolates External APIs**
Third-party SDK details remain inside the Adapter.

**4. Improves Testability**
We can provide a fake implementation of `PaymentProcessor` during tests.

**5. Protects the Application from API Changes**
If Razorpay changes `makePayment()` to `processPayment()`, only the Adapter needs modification.

---

## 11. Object Adapter

The most common implementation in Java is the **Object Adapter**. It uses composition.

Structure:

```text
Adapter
   │  has-a
   ▼
Adaptee
```

```java
class RazorpayAdapter implements PaymentProcessor {

    private final RazorpayGateway gateway;

    public RazorpayAdapter(RazorpayGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void pay(double amount) {
        gateway.makePayment(amount);
    }
}
```

The Adapter implements `Target`, contains `Adaptee`, and delegates calls to `Adaptee`.

### Why Object Adapter Is Preferred

Object Adapter uses composition instead of inheritance. Advantages:

- Works with final classes.
- Works with classes that cannot be extended.
- Can adapt different instances.
- More flexible.
- Lower coupling.
- Easier to test.
- Better aligned with composition over inheritance.

---

## 12. Class Adapter

Class Adapter uses inheritance.

Structure:

```text
Adapter
   │  extends
   ▼
Adaptee

Adapter also implements Target.
```

```java
class RazorpayGateway {

    public void makePayment(double amount) {
        System.out.println("Razorpay payment");
    }
}

interface PaymentProcessor {

    void pay(double amount);
}

class RazorpayClassAdapter extends RazorpayGateway implements PaymentProcessor {

    @Override
    public void pay(double amount) {
        makePayment(amount);
    }
}
```

Usage:

```java
PaymentProcessor processor = new RazorpayClassAdapter();
processor.pay(1000);
```

---

## 13. Object Adapter vs Class Adapter

| Feature | Object Adapter | Class Adapter |
|---|---|---|
| Technique | Composition | Inheritance |
| Has Adaptee | Yes | No |
| Extends Adaptee | No | Yes |
| Multiple inheritance issue | No | Potential issue |
| Final Adaptee | Works | Does not work |
| Flexibility | High | Lower |
| Preferred in Java | Yes | Less common |

Java generally favors the Object Adapter approach.

---

## 14. Multiple Adapters

A system can have many adapters for the same Target.

```text
PaymentProcessor
     ▲
┌────┼────┐
▼    ▼    ▼
Razorpay Stripe PayPal
Adapter  Adapter Adapter
```

Target:

```java
interface PaymentProcessor {

    void pay(double amount);
}
```

Razorpay:

```java
class RazorpayAdapter implements PaymentProcessor {

    private final RazorpayGateway gateway;

    public RazorpayAdapter(RazorpayGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void pay(double amount) {
        gateway.makePayment(amount);
    }
}
```

Stripe:

```java
class StripeAdapter implements PaymentProcessor {

    private final StripeClient client;

    public StripeAdapter(StripeClient client) {
        this.client = client;
    }

    @Override
    public void pay(double amount) {
        client.charge(amount);
    }
}
```

Now the application can work with either provider.

---

## 15. DTO Mapping

Real-world adapters often do more than rename methods — they frequently translate DTOs.

Suppose our application defines:

```java
class ShippingRequest {

    private final String source;
    private final String destination;
    private final double weight;

    public ShippingRequest(String source, String destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }
}
```

FedEx might expect:

```java
class FedExShipmentRequest {

    private final String originAddress;
    private final String destinationAddress;
    private final double packageWeight;

    public FedExShipmentRequest(String originAddress, String destinationAddress, double packageWeight) {
        this.originAddress = originAddress;
        this.destinationAddress = destinationAddress;
        this.packageWeight = packageWeight;
    }
}
```

The Adapter performs the translation:

```java
FedExShipmentRequest fedExRequest = new FedExShipmentRequest(
        request.getSource(),
        request.getDestination(),
        request.getWeight()
);
```

This is a major real-world use of Adapter.

### DTO Translation Flow

```text
Application DTO
      │
      ▼
ShippingRequest
      │
      ▼
FedExAdapter
      │  translate
      ▼
FedExShipmentRequest
      │
      ▼
  FedEx API
```

The rest of the application does not need to understand FedEx DTOs.

---

## 16. Exception Translation

External APIs may throw vendor-specific exceptions.

```java
class FedExApiException extends RuntimeException {

    public FedExApiException(String message) {
        super(message);
    }
}
```

Our application should not necessarily depend on this exception. Instead define an application-level exception:

```java
class ShippingException extends RuntimeException {

    public ShippingException(String message) {
        super(message);
    }

    public ShippingException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

Adapter translates:

```java
try {
    client.createShipment(request);
} catch (FedExApiException ex) {
    throw new ShippingException("Unable to create shipment", ex);
}
```

This keeps vendor-specific exceptions inside the integration boundary.

---

## 17. Third-Party API Integration

One of the strongest use cases of Adapter is third-party SDK integration.

```text
Application
      │
      ▼
ShippingProvider
      │
  ┌───┴───┐
  ▼       ▼
FedExAdapter  DHLAdapter
  │       │
  ▼       ▼
FedEx SDK   DHL SDK
```

The application knows `ShippingProvider`. It does not know `FedExClient`, `DHLClient`, `FedExShipmentRequest`, `DHLShipmentRequest`, `FedExApiException`, or `DHLApiException`.

---

## 18. Adapter as an Integration Boundary

A powerful architectural use of Adapter is creating a boundary between your system and external systems.

```text
┌─────────────────────────────────┐
│           Application            │
│                                   │
│  Domain / Business Logic          │
└──────────────┬────────────────────┘
               │
               ▼
        Application API
               │
               ▼
┌─────────────────────────────────┐
│              Adapter              │
│                                   │
│  DTO translation                  │
│  Exception translation            │
│  API translation                  │
│  Vendor-specific logic            │
└──────────────┬────────────────────┘
               │
               ▼
┌─────────────────────────────────┐
│          External System          │
│                                   │
│  FedEx / Stripe / Razorpay / etc. │
└─────────────────────────────────┘
```

This creates a clean boundary.

---

## 19. Anti-Corruption Layer

Adapter is often part of an **Anti-Corruption Layer (ACL)**.

> The purpose of an Anti-Corruption Layer is to prevent an external system's model from contaminating your application's domain model.

```text
Our Domain
   │
   ▼
ShippingRequest, ShippingRate, Shipment
   │
   ▼
FedExAdapter
   │
   ▼
FedEx Domain
FedExShipmentRequest, FedExRateResponse, FedExException
```

**Without the boundary:**

```text
Business Logic
      │
      ▼
FedEx DTOs, FedEx exceptions, FedEx enums, FedEx SDK
```

This creates vendor lock-in.

**With the boundary:**

```text
Business Logic
      │
      ▼
Our abstractions
      │
      ▼
   Adapter
      │
      ▼
 Vendor API
```

---

## 20. API Versioning

Adapter is also useful when an external API changes.

Suppose **Version 1**:

```java
class PaymentGatewayV1 {

    public void makePayment(double amount) {
        // ...
    }
}
```

**Version 2:**

```java
class PaymentGatewayV2 {

    public void processPayment(double amount, String currency) {
        // ...
    }
}
```

Our application still uses:

```java
interface PaymentProcessor {

    void pay(double amount);
}
```

The adapters isolate API differences.

```text
PaymentProcessor
      ▲
  ┌───┴───┐
  ▼       ▼
V1 Adapter  V2 Adapter
  │       │
  ▼       ▼
Gateway V1  Gateway V2
```

---

## 21. Adapter + Factory

Adapter solves: *how can incompatible APIs work with our application interface?*

Factory solves: *which implementation should we create?*

These are different responsibilities.

```text
Client
   │
   ▼
PaymentProcessor
   │
   ▼
PaymentProcessorFactory
   ├──► RazorpayAdapter
   ├──► StripeAdapter
   └──► PayPalAdapter
```

Factory:

```java
enum PaymentProviderType {
    RAZORPAY,
    STRIPE
}
```

```java
class PaymentProcessorFactory {

    public static PaymentProcessor create(PaymentProviderType type) {
        return switch (type) {
            case RAZORPAY -> new RazorpayAdapter(new RazorpayGateway());
            case STRIPE -> new StripeAdapter(new StripeClient());
        };
    }
}
```

The Factory creates/selects the Adapter. The Adapter performs the translation.

### Important Difference

- **Factory:** *"Which object should I create?"*
- **Adapter:** *"How do I make this incompatible object work with my interface?"*

They can work together.

---

## 22. Adapter + Dependency Injection

Instead of constructing dependencies inside the Adapter, inject them:

```java
class RazorpayAdapter implements PaymentProcessor {

    private final RazorpayGateway gateway;

    public RazorpayAdapter(RazorpayGateway gateway) {
        this.gateway = gateway;
    }
}
```

This is better because the dependency is injected. Advantages:

- Better testability.
- Lower coupling.
- Easier configuration.
- Easier replacement.
- Cleaner construction.

---

## 23. Two-Way Adapter

An Adapter can theoretically adapt in both directions.

```text
System A
   │
   ▼
Adapter
   │
   ▼
System B

System B
   │
   ▼
Adapter
   │
   ▼
System A
```

This is called a **Two-Way Adapter**. It is less common than normal one-way adapters but can be useful when two systems need to interact with each other's interfaces.

---

## 24. Adapter vs Wrapper

These terms are sometimes used interchangeably in everyday development, but conceptually they differ.

### Adapter

The primary goal is: **make an incompatible interface compatible.**

```text
Expected: pay()
Existing: makePayment()
Adapter:  pay() → makePayment()
```

### Wrapper

Wrapper is a broader term. A wrapper may:

- Hide implementation details.
- Add convenience methods.
- Encapsulate another object.
- Simplify access.
- Control access.

> Every Adapter is effectively a wrapper, but not every wrapper is an Adapter.

---

## 25. Adapter vs Decorator

This distinction is extremely important.

### Adapter

Changes the interface.

```text
Interface A
   │
   ▼
Adapter
   │
   ▼
Interface B
```

**Purpose:** Compatibility.

### Decorator

Preserves the interface while adding behavior.

```text
Component
   │
   ▼
Decorator
   │
   ▼
Concrete Component
```

**Purpose:** Add responsibilities dynamically.

```text
PaymentProcessor
      │
      ▼
LoggingDecorator
      │
      ▼
PaymentProcessor
```

The interface remains the same.

---

## 26. Adapter vs Facade

Both are Structural Patterns, but their purposes are different.

### Adapter

Works mainly with incompatible interfaces.

```text
Client
   │
   ▼
Adapter
   │
   ▼
Incompatible API
```

### Facade

Simplifies a complex subsystem.

```text
Client
   │
   ▼
Facade
   ├──► Service A
   ├──► Service B
   └──► Service C
```

- **Adapter:** *"Make this interface compatible."*
- **Facade:** *"Make this complex subsystem easier to use."*

---

## 27. Adapter vs Factory / Builder / Prototype / Registry / Singleton

| Adapter | Factory |
|---|---|
| Structural | Creational |
| Converts interface | Creates/selects objects |
| Solves compatibility | Solves object creation |
| Works around incompatible APIs | Controls construction |

**Adapter vs Builder** — Builder solves complex object construction; Adapter solves incompatible interfaces.

```text
Builder ──► Complex Object
Adapter ──► Compatible Interface
```

**Adapter vs Prototype** — Prototype solves object creation through copying; Adapter solves interface incompatibility.

```text
Prototype: Existing Object ──clone──► New Object
Adapter:   Client ──► Adapter ──► Existing Object
```

**Adapter vs Registry** — Registry solves object lookup/registration; Adapter solves interface compatibility. They can be combined:

```text
Registry
   │
   ▼
PaymentProcessor Adapter
   │
   ▼
Third-party API
```

**Adapter vs Singleton** — Singleton controls instance count; Adapter controls interface compatibility. Adapter does not need to be Singleton.

---

## 28. SOLID Analysis

Adapter works particularly well with SOLID principles.

### Single Responsibility Principle

An Adapter should primarily be responsible for integration translation.

```text
FedExAdapter
├── Convert application request
├── Call FedEx API
├── Convert response
└── Translate exceptions
```

Avoid putting business logic inside the Adapter.

**Bad:**

```java
class FedExAdapter {

    public void ship(Order order) {
        // Calculate discount
        // Validate business rules
        // Calculate tax
        // Decide shipping strategy
        // Call FedEx
    }
}
```

Business rules belong elsewhere.

### Open/Closed Principle

We should be able to add a new provider without modifying existing business logic.

```text
ShippingProvider
├── FedExAdapter
├── DHLAdapter
├── BlueDartAdapter
└── UPSAdapter
```

Adding a new Adapter extends the system.

### Liskov Substitution Principle

All adapters implementing the Target interface should behave correctly as implementations of that interface.

```java
ShippingProvider provider = new FedExAdapter(...);
```

or:

```java
ShippingProvider provider = new DHLAdapter(...);
```

The client should be able to use either.

### Interface Segregation Principle

The Target interface should be focused.

```java
interface ShippingProvider {

    ShippingRate getRate(ShippingRequest request);

    Shipment createShipment(ShipmentRequest request);
}
```

Avoid giant interfaces containing unrelated functionality.

### Dependency Inversion Principle

This is one of the strongest benefits of Adapter.

**Bad:**

```java
class ShippingService {

    private final FedExClient client;
}
```

**Better:**

```java
class ShippingService {

    private final ShippingProvider provider;

    public ShippingService(ShippingProvider provider) {
        this.provider = provider;
    }
}
```

High-level business logic depends on an abstraction. The Adapter connects that abstraction to the external implementation.

---

## 29. Testing Adapter

Adapters are integration boundaries, so testing is important. We can test:

1. Request translation.
2. API invocation.
3. Response translation.
4. Exception translation.
5. Edge cases.
6. Vendor failures.

```java
class FakeFedExClient {

    boolean called;

    void createShipment(FedExShipmentRequest request) {
        called = true;
    }
}
```

```java
@Test
void shouldCallFedExClient() {

    FakeFedExClient client = new FakeFedExClient();
    FedExAdapter adapter = new FedExAdapter(client);

    adapter.createShipment(request);

    assertTrue(client.called);
}
```

### Testing Strategy

A good Adapter test suite should cover:

```text
Application Request
        │
        ▼
     Adapter
        ├── Request Mapping Test
        ├── API Invocation Test
        ├── Response Mapping Test
        └── Exception Mapping Test
        │
        ▼
External Client
```

---

## 30. Common Mistakes

**Mistake 1 — Putting Business Logic in Adapter**
Adapter should translate. It should not become the entire business layer.

**Mistake 2 — Leaking Vendor Types**

Bad:

```java
public FedExResponse getRate(FedExRequest request)
```

This exposes FedEx to the application. Better:

```java
public ShippingRate getRate(ShippingRequest request)
```

The Adapter internally maps to FedEx types.

**Mistake 3 — Giant Adapter**

Avoid:

```text
MegaAdapter
├── Payment
├── Shipping
├── Notification
├── Tax
├── Inventory
└── Analytics
```

Prefer focused adapters.

**Mistake 4 — Modifying Third-Party Code**
Usually you cannot or should not modify external SDKs. Instead create an Adapter.

**Mistake 5 — Confusing Adapter with Facade**
Adapter is about compatibility. Facade is about simplification.

**Mistake 6 — Using Inheritance Without Need**
Prefer Object Adapter with composition unless Class Adapter has a strong reason.

**Mistake 7 — Creating Adapter Without an Incompatibility Problem**
Do not force a pattern. If interfaces already match, an Adapter may add unnecessary complexity.

---

## 31. When to Use Adapter

Use Adapter when:

- Existing API does not match your interface.
- Integrating third-party services.
- Integrating legacy systems.
- Migrating from old APIs to new APIs.
- Supporting multiple vendors.
- You need to isolate vendor-specific code.
- DTO structures differ.
- Exception models differ.
- You want to protect your domain model from external models.
- You need an Anti-Corruption Layer.

---

## 32. When Not to Use Adapter

Avoid Adapter when:

- Interfaces already match.
- A simple direct dependency is sufficient.
- The abstraction adds no value.
- You are only renaming a method without an architectural reason.
- The adapter becomes a giant business logic class.

> Use patterns to solve design problems, not to increase the number of classes.

---

## 33. Part 1 Practice

**Requirement:** build a payment system where the application expects:

```java
interface PaymentProcessor {

    void pay(double amount);
}
```

But Razorpay provides:

```java
class RazorpayGateway {

    public void makePayment(double amount) {
        System.out.println("Razorpay payment: " + amount);
    }
}
```

Create an Adapter.

**Expected Files:** `PaymentProcessor.java`, `RazorpayGateway.java`, `RazorpayAdapter.java`, `CheckoutService.java`, `Main.java`.

### Solution

```java
interface PaymentProcessor {

    void pay(double amount);
}
```

```java
class RazorpayGateway {

    public void makePayment(double amount) {
        System.out.println("Razorpay payment: " + amount);
    }
}
```

```java
class RazorpayAdapter implements PaymentProcessor {

    private final RazorpayGateway gateway;

    public RazorpayAdapter(RazorpayGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void pay(double amount) {
        gateway.makePayment(amount);
    }
}
```

```java
class CheckoutService {

    private final PaymentProcessor processor;

    public CheckoutService(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void checkout(double amount) {
        processor.pay(amount);
    }
}
```

```java
public class Main {

    public static void main(String[] args) {

        RazorpayGateway gateway = new RazorpayGateway();
        PaymentProcessor processor = new RazorpayAdapter(gateway);
        CheckoutService service = new CheckoutService(processor);

        service.checkout(1000);
    }
}
```

---

## 34. Part 2 Practice

**Requirement:** support two payment providers — Razorpay and Stripe. Application should depend only on:

```java
interface PaymentProcessor {

    void pay(double amount);
}
```

External APIs:

```java
class RazorpayGateway {

    void makePayment(double amount) {
        System.out.println("Razorpay");
    }
}
```

```java
class StripeClient {

    void charge(double amount) {
        System.out.println("Stripe");
    }
}
```

Create `RazorpayAdapter` and `StripeAdapter`.

**Expected Files:** `PaymentProcessor.java`, `RazorpayGateway.java`, `RazorpayAdapter.java`, `StripeClient.java`, `StripeAdapter.java`, `CheckoutService.java`, `Main.java`.

### Solution

```java
interface PaymentProcessor {

    void pay(double amount);
}
```

```java
class RazorpayGateway {

    public void makePayment(double amount) {
        System.out.println("Razorpay payment: " + amount);
    }
}
```

```java
class RazorpayAdapter implements PaymentProcessor {

    private final RazorpayGateway gateway;

    public RazorpayAdapter(RazorpayGateway gateway) {
        this.gateway = gateway;
    }

    @Override
    public void pay(double amount) {
        gateway.makePayment(amount);
    }
}
```

```java
class StripeClient {

    public void charge(double amount) {
        System.out.println("Stripe payment: " + amount);
    }
}
```

```java
class StripeAdapter implements PaymentProcessor {

    private final StripeClient client;

    public StripeAdapter(StripeClient client) {
        this.client = client;
    }

    @Override
    public void pay(double amount) {
        client.charge(amount);
    }
}
```

```java
class CheckoutService {

    private final PaymentProcessor processor;

    public CheckoutService(PaymentProcessor processor) {
        this.processor = processor;
    }

    public void checkout(double amount) {
        processor.pay(amount);
    }
}
```

```java
public class Main {

    public static void main(String[] args) {

        PaymentProcessor razorpay = new RazorpayAdapter(new RazorpayGateway());
        PaymentProcessor stripe = new StripeAdapter(new StripeClient());

        CheckoutService checkout1 = new CheckoutService(razorpay);
        CheckoutService checkout2 = new CheckoutService(stripe);

        checkout1.checkout(1000);
        checkout2.checkout(2000);
    }
}
```

---

## 35. Part 3 Practice

**Requirement:** build a Shipping Adapter.

Application interface:

```java
interface ShippingProvider {

    ShippingRate getRate(ShippingRequest request);

    Shipment createShipment(ShipmentRequest request);
}
```

External provider: FedEx. The FedEx API uses different DTOs and exceptions. The Adapter must:

1. Translate application request to FedEx request.
2. Call FedEx.
3. Translate FedEx response.
4. Translate FedEx exception.
5. Hide all FedEx-specific types from the application.

**Expected Files:**

```text
ShippingRequest.java
ShippingRate.java
ShipmentRequest.java
Shipment.java
ShippingProvider.java
ShippingException.java

FedExClient.java
FedExShipmentRequest.java
FedExRateResponse.java
FedExShipmentResponse.java
FedExApiException.java

FedExAdapter.java
ShippingService.java
Main.java
```

---

## 36. Final Production LLD

We will now design an e-commerce shipping system supporting multiple providers.

**Providers:** FedEx, DHL.

**Requirements:**

1. Application should support multiple shipping providers.
2. Providers have different APIs.
3. Providers have different request DTOs.
4. Providers have different response DTOs.
5. Providers have different exception types.
6. Business logic should not depend on provider SDKs.
7. New providers should be easy to add.
8. Provider-specific implementation should be isolated.
9. Application should work with a common `ShippingProvider` abstraction.

### Production Architecture

```text
Client
   │
   ▼
ShippingService
   │
   ▼
ShippingProvider
   ├────────────┐
   ▼            ▼
FedExAdapter  DHLAdapter
   │            │
   ▼            ▼
FedExClient   DHLClient
   │            │
   ▼            ▼
FedEx API     DHL API
```

If Factory is used:

```text
Client
   │
   ▼
ShippingProviderFactory
   ├────────────┐
   ▼            ▼
FedExAdapter  DHLAdapter
   │            │
   ▼            ▼
FedExClient   DHLClient
```

---

## 37. Complete Production Implementation

### Application Models

**ShippingRequest**

```java
class ShippingRequest {

    private final String source;
    private final String destination;
    private final double weight;

    public ShippingRequest(String source, String destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }
}
```

**ShippingRate**

```java
class ShippingRate {

    private final double amount;
    private final String provider;

    public ShippingRate(double amount, String provider) {
        this.amount = amount;
        this.provider = provider;
    }

    public double getAmount() {
        return amount;
    }

    public String getProvider() {
        return provider;
    }

    @Override
    public String toString() {
        return provider + " rate: " + amount;
    }
}
```

**ShipmentRequest**

```java
class ShipmentRequest {

    private final String source;
    private final String destination;
    private final double weight;

    public ShipmentRequest(String source, String destination, double weight) {
        this.source = source;
        this.destination = destination;
        this.weight = weight;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public double getWeight() {
        return weight;
    }
}
```

**Shipment**

```java
class Shipment {

    private final String trackingId;
    private final String provider;

    public Shipment(String trackingId, String provider) {
        this.trackingId = trackingId;
        this.provider = provider;
    }

    public String getTrackingId() {
        return trackingId;
    }

    public String getProvider() {
        return provider;
    }

    @Override
    public String toString() {
        return provider + " shipment: " + trackingId;
    }
}
```

**ShippingProvider** (the Target interface)

```java
interface ShippingProvider {

    ShippingRate getRate(ShippingRequest request);

    Shipment createShipment(ShipmentRequest request);
}
```

**ShippingException** (application-level exception)

```java
class ShippingException extends RuntimeException {

    public ShippingException(String message) {
        super(message);
    }

    public ShippingException(String message, Throwable cause) {
        super(message, cause);
    }
}
```

### FedEx External API

Imagine the external FedEx SDK provides:

```java
class FedExShipmentRequest {

    private final String originAddress;
    private final String destinationAddress;
    private final double packageWeight;

    public FedExShipmentRequest(String originAddress, String destinationAddress, double packageWeight) {
        this.originAddress = originAddress;
        this.destinationAddress = destinationAddress;
        this.packageWeight = packageWeight;
    }
}
```

FedEx response:

```java
class FedExRateResponse {

    private final double totalCharge;

    public FedExRateResponse(double totalCharge) {
        this.totalCharge = totalCharge;
    }

    public double getTotalCharge() {
        return totalCharge;
    }
}
```

Shipment response:

```java
class FedExShipmentResponse {

    private final String trackingNumber;

    public FedExShipmentResponse(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }

    public String getTrackingNumber() {
        return trackingNumber;
    }
}
```

FedEx exception:

```java
class FedExApiException extends RuntimeException {

    public FedExApiException(String message) {
        super(message);
    }
}
```

**FedEx Client**

```java
class FedExClient {

    public FedExRateResponse calculateRate(FedExShipmentRequest request) {
        return new FedExRateResponse(500);
    }

    public FedExShipmentResponse createShipment(FedExShipmentRequest request) {
        return new FedExShipmentResponse("FDX-12345");
    }
}
```

**FedEx Adapter**

```java
class FedExAdapter implements ShippingProvider {

    private final FedExClient client;

    public FedExAdapter(FedExClient client) {
        this.client = client;
    }

    @Override
    public ShippingRate getRate(ShippingRequest request) {
        try {
            FedExShipmentRequest fedExRequest = new FedExShipmentRequest(
                    request.getSource(),
                    request.getDestination(),
                    request.getWeight()
            );

            FedExRateResponse response = client.calculateRate(fedExRequest);

            return new ShippingRate(response.getTotalCharge(), "FedEx");

        } catch (FedExApiException ex) {
            throw new ShippingException("Unable to calculate FedEx rate", ex);
        }
    }

    @Override
    public Shipment createShipment(ShipmentRequest request) {
        try {
            FedExShipmentRequest fedExRequest = new FedExShipmentRequest(
                    request.getSource(),
                    request.getDestination(),
                    request.getWeight()
            );

            FedExShipmentResponse response = client.createShipment(fedExRequest);

            return new Shipment(response.getTrackingNumber(), "FedEx");

        } catch (FedExApiException ex) {
            throw new ShippingException("Unable to create FedEx shipment", ex);
        }
    }
}
```

### DHL External API

DHL may have a completely different API.

```java
class DHLShipmentRequest {

    private final String pickup;
    private final String delivery;
    private final double mass;

    public DHLShipmentRequest(String pickup, String delivery, double mass) {
        this.pickup = pickup;
        this.delivery = delivery;
        this.mass = mass;
    }
}
```

DHL response:

```java
class DHLRateResponse {

    private final double price;

    public DHLRateResponse(double price) {
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}
```

DHL shipment response:

```java
class DHLShipmentResponse {

    private final String trackingCode;

    public DHLShipmentResponse(String trackingCode) {
        this.trackingCode = trackingCode;
    }

    public String getTrackingCode() {
        return trackingCode;
    }
}
```

**DHL Client**

```java
class DHLClient {

    public DHLRateResponse calculateShippingCost(DHLShipmentRequest request) {
        return new DHLRateResponse(450);
    }

    public DHLShipmentResponse ship(DHLShipmentRequest request) {
        return new DHLShipmentResponse("DHL-67890");
    }
}
```

**DHL Adapter**

```java
class DHLAdapter implements ShippingProvider {

    private final DHLClient client;

    public DHLAdapter(DHLClient client) {
        this.client = client;
    }

    @Override
    public ShippingRate getRate(ShippingRequest request) {
        DHLShipmentRequest dhlRequest = new DHLShipmentRequest(
                request.getSource(),
                request.getDestination(),
                request.getWeight()
        );

        DHLRateResponse response = client.calculateShippingCost(dhlRequest);

        return new ShippingRate(response.getPrice(), "DHL");
    }

    @Override
    public Shipment createShipment(ShipmentRequest request) {
        DHLShipmentRequest dhlRequest = new DHLShipmentRequest(
                request.getSource(),
                request.getDestination(),
                request.getWeight()
        );

        DHLShipmentResponse response = client.ship(dhlRequest);

        return new Shipment(response.getTrackingCode(), "DHL");
    }
}
```

### Provider Type

```java
enum ShippingProviderType {
    FEDEX,
    DHL
}
```

### Shipping Provider Factory

Factory is responsible for selecting/creating the correct Adapter.

```java
class ShippingProviderFactory {

    public static ShippingProvider create(ShippingProviderType type) {
        return switch (type) {
            case FEDEX -> new FedExAdapter(new FedExClient());
            case DHL -> new DHLAdapter(new DHLClient());
        };
    }
}
```

Again:

- **Factory:** *"Which provider implementation?"*
- **Adapter:** *"How does that provider fit our interface?"*

### Shipping Service

The business layer depends only on the Target interface.

```java
class ShippingService {

    private final ShippingProvider provider;

    public ShippingService(ShippingProvider provider) {
        this.provider = provider;
    }

    public ShippingRate getRate(ShippingRequest request) {
        return provider.getRate(request);
    }

    public Shipment createShipment(ShipmentRequest request) {
        return provider.createShipment(request);
    }
}
```

Notice: `ShippingService` does not depend on `FedExClient`, `DHLClient`, `FedExShipmentRequest`, `DHLShipmentRequest`, `FedExApiException`, or `DHLApiException`. This is the major architectural benefit.

### Main

```java
public class Main {

    public static void main(String[] args) {

        ShippingProvider provider = ShippingProviderFactory.create(ShippingProviderType.FEDEX);
        ShippingService service = new ShippingService(provider);

        ShippingRequest rateRequest = new ShippingRequest("Bengaluru", "Mumbai", 5);
        ShippingRate rate = service.getRate(rateRequest);
        System.out.println(rate);

        ShipmentRequest shipmentRequest = new ShipmentRequest("Bengaluru", "Mumbai", 5);
        Shipment shipment = service.createShipment(shipmentRequest);
        System.out.println(shipment);
    }
}
```

### Complete Production Workflow

```text
Client
   │
   ▼
ShippingProviderFactory
   │  select provider
   ▼
FedExAdapter
   │  application request
   ▼
Convert ShippingRequest
   │  to
   ▼
FedExShipmentRequest
   │
   ▼
FedExClient
   │
   ▼
FedEx API
   │
   ▼
FedEx Response
   │
   ▼
FedExAdapter
   │  convert
   ▼
ShippingRate / Shipment
   │
   ▼
ShippingService
   │
   ▼
Client
```

### Complete Conceptual Architecture

```text
┌────────────────────────────────────────────┐
│                 Application                  │
│                                               │
│  Client                                      │
│    │                                          │
│    ▼                                          │
│  ShippingService                              │
│    │                                          │
│    ▼                                          │
│  ShippingProvider ◄────────────────┐          │
└────┬────────────────────────────────┼─────────┘
     │                                │
┌────┼────────────────────────────────┼─────────┐
│    │        Integration Layer       │          │
│    ▼                                │          │
│  FedExAdapter ──────────► FedExClient           │
│                                                 │
│  DHLAdapter ────────────► DHLClient             │
└────┬────────────────────────────────────────────┘
     │
     ▼
External APIs
```

### Why This Architecture Is Powerful

**Without Adapter:**

```text
ShippingService
├── FedExClient
├── DHLClient
├── UPSClient
└── BlueDartClient
```

As providers increase, business logic becomes tightly coupled.

**With Adapter:**

```text
ShippingService
      │
      ▼
ShippingProvider
├── FedExAdapter
├── DHLAdapter
├── UPSAdapter
└── BlueDartAdapter
```

The business logic remains stable.

### Adding a New Provider

Suppose we add UPS. External API:

```java
class UPSClient {

    public UPSResponse ship(UPSRequest request) {
        // ...
        return null;
    }
}
```

Create:

```java
class UPSAdapter implements ShippingProvider {

    private final UPSClient client;

    public UPSAdapter(UPSClient client) {
        this.client = client;
    }

    @Override
    public ShippingRate getRate(ShippingRequest request) {
        // Convert request
        // Call UPS
        // Convert response
        return null;
    }

    @Override
    public Shipment createShipment(ShipmentRequest request) {
        // Convert request
        // Call UPS
        // Convert response
        return null;
    }
}
```

The business layer does not need to know UPS-specific details.

---

## 38. Design Decisions

**Decision 1 — Use Object Adapter.** Composition provides more flexibility than inheritance.

**Decision 2 — Application-Owned Interface.** `ShippingProvider` belongs to our application. The application should define the abstraction according to its needs.

**Decision 3 — Keep Vendor Types Inside Adapter.** FedEx-specific classes should not leak into business logic.

**Decision 4 — Translate Exceptions.** Vendor exceptions should be converted into application-level exceptions.

**Decision 5 — Use Factory for Provider Selection.** Factory centralizes provider creation.

**Decision 6 — Use Dependency Injection.** Adapters receive external clients through constructors.

---

## 39. Possible Extensions

A production system can extend this design with:

- **Retry** — transient provider failures can be retried.
- **Timeout** — external API calls should have timeouts.
- **Circuit Breaker** — repeated provider failures can trigger circuit breaking.
- **Logging** — adapters can log provider interaction.
- **Metrics** — track success rate, failure rate, latency, provider usage, retry count.
- **Caching** — shipping rates may sometimes be cached depending on business requirements.
- **Fallback Provider** — if FedEx fails, fall back to DHL:

```text
FedEx
  │
  ✗
  ▼
 DHL
```

This should be implemented at an appropriate orchestration/resilience layer rather than blindly inside every Adapter.

---

## 40. Adapter and Business Logic

One of the most important design rules:

> Adapters should translate, not decide business policy.

**Good Adapter responsibility:**

```text
Application DTO
      │
      ▼
Vendor DTO
      │
      ▼
Vendor API
      │
      ▼
Vendor Response
      │
      ▼
Application DTO
```

**Bad Adapter responsibility:**

```text
Application DTO
      │
      ▼
   Adapter
      ├── Discount calculation
      ├── Tax calculation
      ├── Inventory decision
      ├── Pricing decision
      └── Business rules
      │
      ▼
  Vendor API
```

Business decisions belong to application/domain services.

---

## 41. Adapter as a Boundary

A useful mental model:

```text
OUR SYSTEM
┌───────────────────────────────────┐
│                                     │
│  Domain Models                      │
│  Business Logic                     │
│  Application Services               │
└──────────────┬──────────────────────┘
               │  stable boundary
               ▼
┌───────────────────────────────────┐
│              Adapter                │
│                                     │
│  Translation                        │
│  Mapping                            │
│  Exception Conversion               │
│  Vendor Isolation                   │
└──────────────┬──────────────────────┘
               │
               ▼
┌───────────────────────────────────┐
│          External System            │
│                                     │
│  Vendor SDK / Legacy API / Service  │
└───────────────────────────────────┘
```

---

## 42. Key Mental Model

Remember Adapter using this sentence:

> "The client speaks one language, the existing class speaks another language, and the Adapter is the translator."

```text
Client:   "I need pay(amount)"
              │
              ▼
Adapter:  "Let me translate that"
              │
              ▼
Razorpay: "makePayment(amount)"
```

---

## 43. Interview Questions

### Basic

**Q1. What is Adapter Pattern?**
Adapter is a Structural Design Pattern that converts the interface of an existing class into an interface expected by the client.

**Q2. What problem does Adapter solve?**
It allows incompatible interfaces to work together without modifying the existing class.

**Q3. What are the participants?**
Target, Adapter, Adaptee, Client.

**Q4. What is an Adaptee?**
The existing class whose interface is incompatible with the client's expected interface.

**Q5. What is the Target?**
The interface expected by the client.

### Intermediate

**Q6. What is Object Adapter?**
An Adapter that uses composition to contain the Adaptee.

**Q7. What is Class Adapter?**
An Adapter that extends the Adaptee and implements the Target interface.

**Q8. Which Adapter is preferred in Java?**
Usually Object Adapter, because Java favors composition and does not support multiple inheritance of classes.

**Q9. Can Adapter work with a final class?**
Object Adapter can. Class Adapter cannot extend a final class.

**Q10. Can Adapter translate exceptions?**
Yes — this is common in real-world integrations.

**Q11. Can Adapter translate DTOs?**
Yes — this is one of the most common production uses.

### Advanced

**Q12. Is Adapter only about renaming methods?**
No. Adapter can translate method names, parameters, DTOs, return values, exceptions, data formats, units, protocol representations, and API versions.

**Q13. Should Adapter contain business logic?**
Generally no. It should focus on integration and translation.

**Q14. Should vendor types leak outside the Adapter?**
Preferably no. The Adapter should isolate vendor-specific models.

**Q15. How does Adapter help DIP?**
The business layer depends on an application abstraction while the Adapter handles the external implementation.

**Q16. How does Adapter support OCP?**
New integrations can be added through new Adapter implementations without changing existing business logic.

### Comparison Questions

**Q17. Adapter vs Facade?** Adapter changes an incompatible interface; Facade simplifies a complex subsystem.

**Q18. Adapter vs Decorator?** Adapter changes interface compatibility; Decorator preserves the interface and adds behavior.

**Q19. Adapter vs Factory?** Adapter solves compatibility; Factory solves object creation/selection.

**Q20. Adapter vs Builder?** Adapter solves interface incompatibility; Builder solves complex object construction.

**Q21. Adapter vs Prototype?** Adapter solves compatibility; Prototype solves object creation through copying.

**Q22. Adapter vs Singleton?** Adapter solves compatibility; Singleton controls instance count.

### LLD Questions

**Q23. Design a payment system supporting Razorpay and Stripe.**

```text
PaymentProcessor
      ▲
  ┌───┴───┐
RazorpayAdapter  StripeAdapter
```

**Q24. Design a shipping system supporting FedEx and DHL.**

```text
ShippingProvider
      ▲
  ┌───┴───┐
FedExAdapter  DHLAdapter
```

**Q25. How would you prevent third-party SDK types from leaking into your application?**
Use an Adapter boundary and map external DTOs to application/domain models.

**Q26. Where would you put retry logic?**
Usually in an appropriate resilience/integration/orchestration layer rather than mixing extensive retry policy into every simple Adapter.

**Q27. Where would you put business rules?**
Inside domain/application services, not inside the Adapter.

---

## 44. Common Interview Traps

**"Why don't you just modify the third-party class?"**
Usually we cannot modify third-party code. Even if technically possible, modifying vendor code would create maintenance problems, upgrade problems, vendor coupling, and ownership issues. Adapter lets us isolate the external dependency.

**"Is Adapter always implemented using an interface?"**
No. Adapter can work with interfaces, abstract classes, or concrete classes. However, using a Target interface is often preferable because it provides a clean abstraction for the Client.

**"Does Adapter have to use inheritance?"**
No. The most common Java implementation uses composition — that is the Object Adapter.

**"Is Adapter a wrapper?"**
Adapter is a type of wrapper in the broad sense, but its defining purpose is interface compatibility.

**"Does Adapter need to be Singleton?"**
No. Adapter and Singleton solve completely different problems.

**"Can Adapter and Factory be used together?"**
Absolutely. Factory chooses/creates the Adapter. Adapter translates the external API.

---

## 45. Adapter Pattern Summary

The complete concept can be summarized as:

```text
CLIENT
   │
   ▼
TARGET
   ▲
   │
ADAPTER
   │
   ▼
ADAPTEE
```

| Term | Meaning |
|---|---|
| **Target** | Interface expected by application |
| **Adaptee** | Existing incompatible implementation |
| **Adapter** | Translator between the two |
| **Client** | Code using Target |

---

## 46. Adapter Golden Rules

1. Adapter is a Structural Pattern.
2. Its main purpose is interface compatibility.
3. Target is the interface expected by the client.
4. Adaptee is the existing incompatible class.
5. Adapter translates Target calls into Adaptee calls.
6. Object Adapter uses composition.
7. Class Adapter uses inheritance.
8. Object Adapter is generally preferred in Java.
9. Adapter can translate DTOs.
10. Adapter can translate exceptions.
11. Adapter is excellent for third-party APIs.
12. Adapter can isolate legacy systems.
13. Adapter can form an Anti-Corruption Layer.
14. Avoid leaking vendor types.
15. Avoid putting business logic inside Adapter.
16. Factory can create/select Adapters.
17. Adapter does not need to be Singleton.
18. Adapter is not the same as Facade.
19. Adapter is not the same as Decorator.
20. Do not use Adapter when there is no incompatibility problem.

---

## 47. Adapter Checklist

### Part 1 — Fundamentals

- [x] Understand Adapter Pattern
- [x] Understand Structural Pattern classification
- [x] Understand the problem Adapter solves
- [x] Understand Target
- [x] Understand Adaptee
- [x] Understand Adapter
- [x] Understand Client
- [x] Implement Object Adapter
- [x] Understand composition
- [x] Understand basic payment example
- [x] Understand Adapter vs Wrapper
- [x] Understand Adapter vs Decorator
- [x] Practice basic Adapter

### Part 2 — Variations / Deeper Concepts

- [x] Understand Class Adapter
- [x] Understand Object Adapter vs Class Adapter
- [x] Understand multiple Adapters
- [x] Understand third-party integration
- [x] Understand DTO mapping
- [x] Understand API translation
- [x] Understand Adapter + Factory
- [x] Understand Adapter + Dependency Injection
- [x] Understand legacy API migration
- [x] Understand two-way Adapter
- [x] Practice multi-provider payment Adapter

### Part 3 — Advanced Concepts

- [x] SOLID with Adapter (SRP, OCP, LSP, ISP, DIP)
- [x] Integration boundary
- [x] DTO translation
- [x] Exception translation
- [x] API versioning
- [x] Third-party SDK isolation
- [x] Anti-Corruption Layer
- [x] Testing strategy
- [x] Adapter pitfalls
- [x] Practice shipping Adapter

### Part 4 — Final Production LLD

- [x] Multi-provider shipping system
- [x] Application abstraction
- [x] FedEx Adapter
- [x] DHL Adapter
- [x] External DTO mapping
- [x] Response mapping
- [x] Exception translation
- [x] Factory + Adapter
- [x] Dependency Injection
- [x] Business logic isolation
- [x] Complete Java implementation
- [x] Architecture diagram
- [x] Production considerations
- [x] SOLID analysis
- [x] Extensions
- [x] Interview questions

---

## 48. Final Takeaway

The most important thing to remember about Adapter is:

> Adapter allows incompatible interfaces to work together without modifying the existing class.

The core structure is:

```text
Client
   │
   ▼
Target
   ▲
   │
Adapter
   │
   ▼
Adaptee
```

In real-world Java applications, Adapter is especially useful for:

```text
Application
      │
      ▼
Application Interface
      │
      ▼
   Adapter
      ├── DTO Mapping
      ├── API Translation
      ├── Exception Translation
      └── Vendor Isolation
      │
      ▼
Third-Party API
```

And when combined with Factory:

```text
Client
   │
   ▼
Factory
   ├── Adapter A
   ├── Adapter B
   └── Adapter C
   │
   ▼
External APIs
```

The fundamental distinction is:

```text
Factory: "Which implementation should I create?"
Adapter: "How can this incompatible implementation work
          with the interface my application expects?"
```

Once you understand this distinction, Adapter becomes a very natural pattern to recognize in real-world LLD problems.

---

## 49. One-Line Interview Definition

> Adapter is a Structural Design Pattern that converts the interface of an existing class into an interface expected by the client, allowing incompatible components to work together without modifying the existing class.