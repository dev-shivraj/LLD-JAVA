# Facade Design Pattern

The **Facade Design Pattern** is a structural design pattern that provides a simple, unified interface to a complex subsystem.

Instead of forcing clients to interact with many classes and understand their interactions, a Facade provides a single entry point that coordinates those components.

---

## Table of Contents

1. [What is the Facade Design Pattern?](#1-what-is-the-facade-design-pattern)
2. [Why Do We Need Facade?](#2-why-do-we-need-facade)
3. [The Problem Without Facade](#3-the-problem-without-facade)
4. [Solution: Facade](#4-solution-facade)
5. [Core Structure](#5-core-structure)
6. [Important Characteristics](#6-important-characteristics)
7. [Real-World Analogy](#7-real-world-analogy)
8. [Basic Java Example](#8-basic-java-example)
9. [Home Theater Facade](#9-home-theater-facade)
10. [Facade in E-Commerce](#10-facade-in-e-commerce)
11. [What Does the Facade Know?](#11-what-does-the-facade-know)
12. [Facade Should Expose Use Cases](#12-facade-should-expose-use-cases)
13. [Facade Should Speak the Client's Language](#13-facade-should-speak-the-clients-language)
14. [Facade Does Not Have to Be an Interface](#14-facade-does-not-have-to-be-an-interface)
15. [Facade Does Not Have to Be a Singleton](#15-facade-does-not-have-to-be-a-singleton)
16. [Multiple Facades](#16-multiple-facades)
17. [Avoid the God Facade](#17-avoid-the-god-facade)
18. [Thin Facade Principle](#18-thin-facade-principle)
19. [Facade vs Orchestration Service](#19-facade-vs-orchestration-service)
20. [Facade vs Service](#20-facade-vs-service)
21. [Facade + Dependency Injection](#21-facade--dependency-injection)
22. [Facade + Repository](#22-facade--repository)
23. [Layered Facade Architecture](#23-layered-facade-architecture)
24. [Facade + Adapter](#24-facade--adapter)
25. [Adapter vs Facade](#25-adapter-vs-facade)
26. [Facade + Factory](#26-facade--factory)
27. [Facade + Adapter + Factory](#27-facade--adapter--factory)
28. [Error Handling in Facade](#28-error-handling-in-facade)
29. [Facade Is Not a Transaction Manager](#29-facade-is-not-a-transaction-manager)
30. [Partial Failure](#30-partial-failure)
31. [Idempotency](#31-idempotency)
32. [Retry Considerations](#32-retry-considerations)
33. [Validation Boundaries](#33-validation-boundaries)
34. [Facade and Business Logic](#34-facade-and-business-logic)
35. [Facade and Testing](#35-facade-and-testing)
36. [Important Failure Tests](#36-important-failure-tests)
37. [Facade and Events](#37-facade-and-events)
38. [Synchronous vs Asynchronous Work](#38-synchronous-vs-asynchronous-work)
39. [Facade and Concurrency](#39-facade-and-concurrency)
40. [Facade and Thread Safety](#40-facade-and-thread-safety)
41. [Facade as an Architectural Boundary](#41-facade-as-an-architectural-boundary)
42. [Facade + External APIs](#42-facade--external-apis)
43. [Facade and Anti-Corruption Layer](#43-facade-and-anti-corruption-layer)
44. [Facade vs Anti-Corruption Layer](#44-facade-vs-anti-corruption-layer)
45. [Production Example](#45-production-example)
46. [Domain Models](#46-domain-models)
47. [Payment Provider Type](#47-payment-provider-type)
48. [PaymentProcessor](#48-paymentprocessor)
49. [Razorpay External Client](#49-razorpay-external-client)
50. [Razorpay Adapter](#50-razorpay-adapter)
51. [Stripe External Client](#51-stripe-external-client)
52. [Stripe Adapter](#52-stripe-adapter)
53. [Payment Factory](#53-payment-factory)
54. [CartService](#54-cartservice)
55. [PricingService](#55-pricingservice)
56. [InventoryService](#56-inventoryservice)
57. [OrderService](#57-orderservice)
58. [ShippingService](#58-shippingservice)
59. [NotificationService](#59-notificationservice)
60. [CheckoutFacade](#60-checkoutfacade)
61. [Main](#61-main)
62. [Complete Production Workflow](#62-complete-production-workflow)
63. [Failure Workflow](#63-failure-workflow)
64. [Why This Design Is Better](#64-why-this-design-is-better)
65. [SOLID Analysis](#65-solid-analysis)
66. [Dependency Inversion Principle](#66-dependency-inversion-principle)
67. [Open/Closed Principle](#67-openclosed-principle)
68. [Liskov Substitution Principle](#68-liskov-substitution-principle)
69. [Interface Segregation Principle](#69-interface-segregation-principle)
70. [Composition Over Inheritance](#70-composition-over-inheritance)
71. [Facade vs Decorator](#71-facade-vs-decorator)
72. [Facade vs Singleton](#72-facade-vs-singleton)
73. [Facade vs Factory](#73-facade-vs-factory)
74. [Facade vs Adapter vs Factory](#74-facade-vs-adapter-vs-factory)
75. [Facade vs Builder](#75-facade-vs-builder)
76. [Facade vs Prototype](#76-facade-vs-prototype)
77. [Facade vs Registry](#77-facade-vs-registry)
78. [When Should You Use Facade?](#78-when-should-you-use-facade)
79. [When Should You NOT Use Facade?](#79-when-should-you-not-use-facade)
80. [Common Mistakes](#80-common-mistakes)
81. [Interview Questions — Basic](#81-interview-questions--basic)
82. [Interview Questions — Intermediate](#82-interview-questions--intermediate)
83. [Interview Questions — Advanced](#83-interview-questions--advanced)
84. [LLD Interview Approach](#84-lld-interview-approach)
85. [Complete Architecture Summary](#85-complete-architecture-summary)
86. [Pattern Combination Summary](#86-pattern-combination-summary)
87. [Facade Mental Model](#87-facade-mental-model)
88. [One-Line Definition](#88-one-line-definition)
89. [One-Line Memory Trick](#89-one-line-memory-trick)
90. [Pattern Comparison Cheat Sheet](#90-pattern-comparison-cheat-sheet)
91. [Facade Checklist](#91-facade-checklist)
92. [Final Takeaway](#92-final-takeaway)

---

## 1. What is the Facade Design Pattern?

The Facade Pattern provides a simplified interface over a collection of complex classes or subsystems.

> Facade provides a simple, unified interface to a complex subsystem while hiding the complexity of coordinating its underlying components.

The key word is **simplification**.

---

## 2. Why Do We Need Facade?

Consider an e-commerce checkout process. A checkout may involve: Cart, Pricing, Inventory, Payment, Order, Shipping, Notification.

Without a Facade, the client needs to know how all these components interact:

```java
Cart cart = cartService.getCart(userId);

double amount = pricingService.calculatePrice(cart);

inventoryService.reserve(cart);

checkoutService.pay(paymentId, amount);

String orderId = orderService.createOrder(cart, amount);

shippingService.createShipment(orderId, cart);

notificationService.sendConfirmation(userId, orderId);
```

The client now knows which services exist, which to call first, what data flows between them, how the checkout workflow works, and how errors should be handled. This creates unnecessary coupling.

---

## 3. The Problem Without Facade

```text
Client
   ├─────────┬─────────┬─────────┐
   ▼         ▼         ▼         ▼
 Cart     Pricing  Inventory  Payment
                                  │
                                  ▼
                               Order
                                  │
                                  ▼
                              Shipping
                                  │
                                  ▼
                             Notification
```

The client directly depends on many components.

**Problems:**

1. **Too many dependencies** — the client needs references to many services.
2. **Workflow knowledge leaks into the client** — the client needs to know the correct order of operations.
3. **High coupling** — changing the internal workflow can require changing clients.
4. **Duplicate workflows** — multiple clients may implement the same workflow independently.
5. **Difficult maintenance** — the more subsystem details exposed to clients, the harder the system becomes to change.
6. **Difficult testing** — the client now needs to deal with many dependencies.

---

## 4. Solution: Facade

Introduce a `CheckoutFacade`.

```text
Client
   │
   ▼
CheckoutFacade
   │
   ├──────────┬──────────┬──────────┐
   ▼          ▼          ▼          ▼
 Cart      Pricing   Inventory   Payment
                                     │
                                     ▼
                                  Order
                                     │
                                     ▼
                                 Shipping
                                     │
                                     ▼
                                Notification
```

The client now only needs:

```java
CheckoutResult result = checkoutFacade.checkout(request);
```

The Facade internally coordinates the subsystem.

---

## 5. Core Structure

```text
Client
   │
   ▼
Facade
   │
   ├───────────┬───────────┐
   ▼           ▼           ▼
Subsystem A Subsystem B Subsystem C
```

**Components:**

- **Client** — the object that wants to perform an operation.
- **Facade** — provides the simplified interface.
- **Subsystems** — the underlying classes/components that perform the actual work.

---

## 6. Important Characteristics

A Facade:

- Simplifies access.
- Reduces client coupling.
- Hides subsystem complexity.
- Coordinates multiple components.
- Provides a convenient entry point.
- Does not necessarily modify subsystem interfaces.
- Does not necessarily prevent direct subsystem access.
- Does not have to be an interface.
- Does not have to be a Singleton.

---

## 7. Real-World Analogy

Consider a home theater. To watch a movie you may need to:

1. Turn on the TV
2. Turn on the amplifier
3. Set the input
4. Turn on the DVD player
5. Start the movie
6. Dim the lights

Without a Facade, the user needs to perform all these operations. With a Facade:

```java
homeTheater.watchMovie("Inception");
```

Internally:

```text
watchMovie()
   ├── TV.on()
   ├── Amplifier.on()
   ├── Amplifier.setInput()
   ├── DVDPlayer.on()
   ├── DVDPlayer.play()
   └── Lights.dim()
```

The Facade provides a simple interface to a complex subsystem.

---

## 8. Basic Java Example

### Subsystems

**TV**

```java
public class TV {

    public void on() {
        System.out.println("TV ON");
    }

    public void off() {
        System.out.println("TV OFF");
    }
}
```

**Amplifier**

```java
public class Amplifier {

    public void on() {
        System.out.println("Amplifier ON");
    }

    public void setInput(String input) {
        System.out.println("Input set to " + input);
    }

    public void off() {
        System.out.println("Amplifier OFF");
    }
}
```

**DVD Player**

```java
public class DVDPlayer {

    public void on() {
        System.out.println("DVD Player ON");
    }

    public void play(String movie) {
        System.out.println("Playing " + movie);
    }

    public void off() {
        System.out.println("DVD Player OFF");
    }
}
```

**Lights**

```java
public class Lights {

    public void dim() {
        System.out.println("Lights dimmed");
    }

    public void on() {
        System.out.println("Lights ON");
    }
}
```

---

## 9. Home Theater Facade

```java
public class HomeTheaterFacade {

    private final TV tv;
    private final Amplifier amplifier;
    private final DVDPlayer dvdPlayer;
    private final Lights lights;

    public HomeTheaterFacade(TV tv, Amplifier amplifier, DVDPlayer dvdPlayer, Lights lights) {
        this.tv = tv;
        this.amplifier = amplifier;
        this.dvdPlayer = dvdPlayer;
        this.lights = lights;
    }

    public void watchMovie(String movie) {
        lights.dim();
        tv.on();
        amplifier.on();
        amplifier.setInput("DVD");
        dvdPlayer.on();
        dvdPlayer.play(movie);
    }

    public void endMovie() {
        dvdPlayer.off();
        amplifier.off();
        tv.off();
        lights.on();
    }
}
```

The client only needs:

```java
HomeTheaterFacade facade = new HomeTheaterFacade(tv, amplifier, dvdPlayer, lights);
facade.watchMovie("Inception");
```

---

## 10. Facade in E-Commerce

A more realistic example is checkout.

Subsystems: `CartService`, `PricingService`, `InventoryService`, `PaymentService`, `OrderService`, `ShippingService`, `NotificationService`.

Facade:

```java
checkoutFacade.checkout(request);
```

Workflow:

```text
Client
   │
   ▼
CheckoutFacade
   ├── Get Cart
   ├── Calculate Price
   ├── Reserve Inventory
   ├── Process Payment
   ├── Create Order
   ├── Create Shipment
   └── Send Notification
   │
   ▼
CheckoutResult
```

---

## 11. What Does the Facade Know?

The Facade knows the high-level workflow:

1. Get cart
2. Calculate price
3. Reserve inventory
4. Process payment
5. Create order
6. Create shipment
7. Send confirmation

But it does not need to know the internal implementation of each service — how inventory is stored, how pricing is calculated, how the payment gateway works, how orders are persisted, how shipping is integrated, or how notification is delivered. This separation is the core benefit.

---

## 12. Facade Should Expose Use Cases

Good Facade APIs are usually use-case oriented:

```java
checkout(request);
cancelOrder(orderId);
returnOrder(orderId);
registerUser(request);
```

**Bad Facade API:**

```java
getPaymentService();
getInventoryService();
getDatabase();
getShippingService();
```

Why is this bad? Because the client can now bypass the Facade and directly interact with internal components. The abstraction is weakened.

---

## 13. Facade Should Speak the Client's Language

Instead of exposing technical operations:

```java
inventoryService.reserve(...);
checkoutService.authorize(...);
shippingService.createShipment(...);
```

The Facade can expose the business operation:

```java
checkoutFacade.checkout(request);
```

The caller thinks in terms of *"Checkout"* instead of *"coordinate seven technical services."*

---

## 14. Facade Does Not Have to Be an Interface

A common misconception is: *every design pattern class must implement an interface.* False.

A Facade can simply be:

```java
public class CheckoutFacade {

    public CheckoutResult checkout(CheckoutRequest request) {
        // orchestration
    }
}
```

An interface is useful only when there is a genuine reason: multiple implementations, dependency inversion requirement, alternative workflows, testing requirements, architectural boundary. Do not create an interface just to "make it a design pattern."

---

## 15. Facade Does Not Have to Be a Singleton

Another common misconception: *Facade should be Singleton.* False.

Facade and Singleton solve different problems.

```text
Singleton → Controls object instance creation/lifecycle
Facade    → Simplifies access to a complex subsystem
```

A Facade can simply be:

```java
CheckoutFacade facade = new CheckoutFacade(...);
```

The dependency injection/container may decide its lifecycle separately.

---

## 16. Multiple Facades

A large application can have multiple Facades:

```text
Application
├── CheckoutFacade
├── OrderFacade
├── PaymentFacade
├── AccountFacade
└── ProductFacade
```

This is completely valid. Each Facade should represent a cohesive boundary.

---

## 17. Avoid the God Facade

**Bad design:**

```java
public class ApplicationFacade {

    public void checkout() {}
    public void cancelOrder() {}
    public void registerUser() {}
    public void login() {}
    public void createProduct() {}
    public void generateInvoice() {}
    public void processRefund() {}
    public void generateReport() {}
    public void sendEmail() {}
    public void createShipment() {}
}
```

This becomes a **God Object**. Better:

```text
CheckoutFacade
OrderFacade
AccountFacade
PaymentFacade
ReportingFacade
```

> **Rule:** a Facade should simplify a subsystem, not become the entire application.

---

## 18. Thin Facade Principle

A good Facade should generally remain relatively thin.

**Good:**

```text
Facade
├── Service A
├── Service B
├── Service C
└── Service D
```

**Bad:**

```text
Facade
├── 500 lines of business logic
├── database queries
├── HTTP requests
├── payment algorithms
├── pricing algorithms
└── inventory rules
```

The Facade should primarily coordinate.

---

## 19. Facade vs Orchestration Service

Facade and orchestration/application service can look very similar.

- **Facade's primary goal:** simplify access to a complex subsystem.
- **Orchestration/Application Service's primary goal:** coordinate multiple operations to implement a business use case.

In real systems, the same class can effectively play both roles.

```java
checkoutFacade.checkout(request);
```

can internally orchestrate:

```text
Cart → Pricing → Inventory → Payment → Order → Notification
```

The important thing is the responsibility, not the class name.

---

## 20. Facade vs Service

A Service usually owns a specific capability: `PaymentService`, `InventoryService`, `OrderService`, `ShippingService`.

A Facade combines multiple capabilities behind a simpler entry point:

```text
CheckoutFacade
├── PaymentService
├── InventoryService
├── OrderService
└── ShippingService
```

```text
Service → Performs a specific capability
Facade  → Simplifies access to multiple capabilities
```

---

## 21. Facade + Dependency Injection

The Facade should generally receive its dependencies.

**Avoid:**

```java
public class CheckoutFacade {

    private final PaymentService checkoutService = new PaymentService();
    private final InventoryService inventoryService = new InventoryService();
}
```

This tightly couples construction to the Facade. **Prefer constructor injection:**

```java
public class CheckoutFacade {

    private final PaymentService checkoutService;
    private final InventoryService inventoryService;

    public CheckoutFacade(PaymentService checkoutService, InventoryService inventoryService) {
        this.checkoutService = checkoutService;
        this.inventoryService = inventoryService;
    }
}
```

Benefits: lower coupling, easier testing, easier replacement, clear dependencies, better adherence to DIP.

---

## 22. Facade + Repository

The Facade should generally not directly access the database.

**Bad:**

```text
CheckoutFacade → SQL → Database
```

**Better:**

```text
CheckoutFacade → OrderService → OrderRepository → Database
```

Each layer has a clearer responsibility.

---

## 23. Layered Facade Architecture

A production application may look like:

```text
Controller
   │
   ▼
CheckoutFacade
   │
   ▼
Application Services
   │
   ▼
Domain Services
   │
   ▼
Repositories / Ports
   │
   ▼
Adapters / Infrastructure
   ├── Database
   ├── APIs
   └── Queue
```

The Facade acts as a clean entry point to the use case.

---

## 24. Facade + Adapter

Facade and Adapter solve different problems but can work together.

Suppose our application has `PaymentProcessor`. External providers (Razorpay, Stripe, PayPal) have incompatible APIs. Adapters translate their APIs.

```text
PaymentProcessor
├── RazorpayAdapter
├── StripeAdapter
└── PayPalAdapter
```

The Facade can then coordinate payment without knowing vendor details.

```text
CheckoutFacade
      │
      ▼
PaymentProcessor
      │
      ▼
   Adapter
      │
      ▼
External Payment API
```

---

## 25. Adapter vs Facade

This distinction is extremely important.

### Adapter

**Problem:** existing interface doesn't match what the client expects.
**Solution:** convert one interface into another.

```text
Client → Target → Adapter → Adaptee
```

### Facade

**Problem:** the subsystem is complex.
**Solution:** provide a simpler interface over the subsystem.

```text
Client
   │
   ▼
Facade
   ├── Subsystem A
   ├── Subsystem B
   └── Subsystem C
```

```text
Adapter = Compatibility
Facade  = Simplicity
```

---

## 26. Facade + Factory

Facade can also work with Factory.

Suppose the checkout system supports Razorpay, Stripe, PayPal. Factory selects the correct payment implementation.

```text
CheckoutFacade
      │
      ▼
PaymentProcessorFactory
      ├── RazorpayProcessor
      ├── StripeProcessor
      └── PayPalProcessor
```

```java
PaymentProcessor processor = paymentFactory.getProcessor(request.paymentProvider());
processor.pay(request.userId(), amount);
```

**Responsibilities:**

```text
Facade  → Coordinates checkout
Factory → Selects/creates implementation
Adapter → Translates incompatible external API
```

---

## 27. Facade + Adapter + Factory

These patterns can be combined.

```text
Client
   │
   ▼
CheckoutFacade
   │
   ▼
PaymentProcessorFactory
   ├────────────┐
   ▼            ▼
RazorpayAdapter  StripeAdapter
   │            │
   ▼            ▼
Razorpay API   Stripe API
```

Each pattern solves a different problem:

- **Facade** — simplifies checkout.
- **Factory** — selects payment implementation.
- **Adapter** — makes external APIs compatible with our application abstraction.

---

## 28. Error Handling in Facade

A Facade often coordinates multiple operations.

```text
Reserve Inventory
      │
      ▼
Process Payment
      │
   FAILURE
```

Inventory is already reserved. We may need a compensating action:

```text
Reserve Inventory → Payment → FAILURE → Release Inventory
```

```java
inventoryService.reserve(cart);

try {
    checkoutService.pay(paymentId, amount);
} catch (PaymentException e) {
    inventoryService.release(cart);
    throw e;
}
```

---

## 29. Facade Is Not a Transaction Manager

A Facade coordinating operations does not automatically mean those operations are one database transaction.

```text
Inventory Database → Payment Provider → Shipping Provider → Order Database
```

These may be completely independent systems. A single transaction may not cover all of them. Production systems may need idempotency, retry, compensation, saga/workflow, eventual consistency, and distributed transaction strategies.

The Facade coordinates the workflow but should not become a giant transaction-management system.

---

## 30. Partial Failure

Consider:

```text
Inventory       SUCCESS
Payment         SUCCESS
Order           SUCCESS
Shipping        SUCCESS
Notification    FAILURE
```

Should the entire checkout fail? Not necessarily — the order may already be valid. A production system may instead:

```text
Order Created
      │
      ▼
OrderCreatedEvent
      │
      ▼
Notification Service
```

If notification fails:

```text
Notification Failure → Retry → Success
```

Not every downstream failure should necessarily roll back the entire workflow.

---

## 31. Idempotency

Suppose a client calls `checkoutFacade.checkout(request)`. The request succeeds, but the network response is lost. The client retries.

```text
First Request
   ├── Payment SUCCESS
   └── Order CREATED
       │
   Network Timeout
       │
       ▼
    Retry
   ├── Payment AGAIN
   └── Order AGAIN
```

This could result in duplicate payment or duplicate orders. A production checkout workflow may therefore use an idempotency key:

```java
checkout(request, "CHECKOUT-123");
```

Conceptually:

```text
Request
   │
   ▼
Idempotency Check
   ├── Already processed → Return previous result
   └── New request       → Execute workflow
```

The Facade may participate in this workflow, while persistence of idempotency state belongs to an appropriate component.

---

## 32. Retry Considerations

Retries must be handled carefully.

```java
checkoutService.pay();

if (failed) {
    checkoutService.pay();
}
```

This can be dangerous. The first request might have succeeded but the response may have been lost. Retrying could charge the customer twice.

> Retry behavior depends on whether the operation is safely idempotent.

---

## 33. Validation Boundaries

Some basic request validation can happen at the Facade boundary:

```java
if (request == null) {
    throw new IllegalArgumentException("Request cannot be null");
}
```

But domain-specific rules should remain with the appropriate component:

```text
CheckoutFacade → OrderService → Order Business Rules
```

Don't put every business rule into the Facade.

---

## 34. Facade and Business Logic

**Bad:**

```java
public CheckoutResult checkout(CheckoutRequest request) {
    // Calculate discounts
    // Calculate taxes
    // Validate inventory
    // Validate customer
    // Implement payment protocol
    // Construct SQL
    // Parse external API JSON
    // Create shipment
    // Send email
    // Hundreds of lines...
}
```

The Facade has become a God Object. **Better:**

```text
CheckoutFacade
├── PricingService     — Pricing rules
├── InventoryService   — Inventory rules
├── PaymentService     — Payment rules
└── OrderService       — Order rules
```

The Facade coordinates. The individual components own their responsibilities.

---

## 35. Facade and Testing

Facades are generally straightforward to unit test when dependencies are injected.

```text
CheckoutFacade
├── FakeCartService
├── FakePricingService
├── FakeInventoryService
└── FakePaymentService
```

We can verify the workflow:

```text
checkout() → Cart called → Pricing called → Inventory reserved → Payment called
```

---

## 36. Important Failure Tests

A production-quality Facade should test more than the happy path.

**Test 1 — Success**

```text
Cart SUCCESS, Pricing SUCCESS, Inventory SUCCESS, Payment SUCCESS,
Order SUCCESS, Notification SUCCESS
```
Expected: Checkout SUCCESS.

**Test 2 — Payment failure**

```text
Cart SUCCESS, Pricing SUCCESS, Inventory SUCCESS, Payment FAILURE,
Inventory RELEASE, Order NOT CREATED
```

**Test 3 — Inventory failure**

```text
Cart SUCCESS, Pricing SUCCESS, Inventory FAILURE, Payment NOT ATTEMPTED
```

**Test 4 — Notification failure**

```text
Cart SUCCESS, Pricing SUCCESS, Inventory SUCCESS, Payment SUCCESS,
Order SUCCESS, Notification FAILURE
```

The expected behavior must be explicitly defined.

---

## 37. Facade and Events

A production system may move secondary operations to events.

```text
CheckoutFacade
      │
      ▼
Create Order
      │
      ▼
OrderCreatedEvent
   ├── Email
   ├── Invoice
   ├── Analytics
   └── Loyalty
```

This keeps the Facade from synchronously coordinating every possible downstream operation.

---

## 38. Synchronous vs Asynchronous Work

Not every operation must be synchronous. Core checkout operations:

```text
Reserve Inventory → Process Payment → Create Order
```

Secondary operations:

```text
OrderCreated
   ├── Email
   ├── Analytics
   ├── Invoice
   └── Loyalty
```

This can improve scalability and reduce the responsibilities of the Facade.

---

## 39. Facade and Concurrency

Sometimes independent operations can execute concurrently.

```text
Facade
   ├────────────┐
   ▼            ▼
Calculate     Recommendations
Shipping
   └────────────┘
        │
        ▼
     Response
```

However, don't introduce concurrency unnecessarily. Ask: are operations independent? Are they thread-safe? What happens if one fails? Is the complexity worth the latency improvement? Facade itself does not imply concurrency.

---

## 40. Facade and Thread Safety

A Facade may be shared by multiple threads. Avoid request-specific mutable fields.

**Bad:**

```java
public class CheckoutFacade {

    private CheckoutRequest currentRequest;

    public void checkout(CheckoutRequest request) {
        this.currentRequest = request;
    }
}
```

Multiple threads can interfere with each other. **Prefer:**

```java
public CheckoutResult checkout(CheckoutRequest request) {
    // Request is local to this invocation
}
```

Prefer stateless Facades whenever possible.

---

## 41. Facade as an Architectural Boundary

A Facade can provide a boundary between layers.

```text
Controller
   │
   ▼
CheckoutFacade
   │
   ▼
Application Layer
   │
   ▼
Domain Layer
   │
   ▼
Infrastructure
```

The caller depends on the Facade rather than the internal subsystem structure. This provides architectural encapsulation.

---

## 42. Facade + External APIs

Suppose our checkout communicates with Razorpay, FedEx, and Twilio.

**Bad:**

```text
CheckoutFacade
├── Razorpay SDK
├── FedEx SDK
└── Twilio SDK
```

The Facade is now tightly coupled to vendors. **Better:**

```text
CheckoutFacade
├── PaymentService → PaymentAdapter → Razorpay
├── ShippingService → ShippingAdapter → FedEx
└── NotificationService → NotificationAdapter → Twilio
```

This protects the application from external API details.

---

## 43. Facade and Anti-Corruption Layer

An Anti-Corruption Layer protects your internal domain model from external or legacy models.

Suppose our application uses `PaymentRequest` / `PaymentResult`, but the external provider uses `TransactionPayload` / `GatewayResponse` / `GatewayStatus`. We don't want those external types spreading throughout our application.

```text
Application
      │
      ▼
Facade / Service
      │
      ▼
Adapter / Anti-Corruption Boundary
      │
      ▼
External System
```

- **Facade:** simplifies access.
- **Anti-Corruption Layer:** protects your domain model from an external model.

They can be used together.

---

## 44. Facade vs Anti-Corruption Layer

| Concept | Main Purpose |
|---|---|
| **Facade** | Simplify access to a complex subsystem |
| **Anti-Corruption Layer** | Protect internal domain from external/legacy models |
| **Adapter** | Translate incompatible interfaces |

Possible architecture:

```text
Application → Facade → Anti-Corruption Boundary → Adapter → External System
```

---

## 45. Production Example

Consider an e-commerce checkout with these requirements:

1. Retrieve cart
2. Calculate price
3. Reserve inventory
4. Process payment
5. Create order
6. Create shipment
7. Send confirmation
8. Support multiple payment providers
9. Isolate external payment APIs
10. Release inventory when payment fails

**Architecture:**

```text
Client
   │
   ▼
CheckoutFacade
   ├── CartService
   ├── PricingService
   ├── InventoryService → Inventory
   │
   ▼
PaymentFactory
   ├── RazorpayAdapter → Razorpay API
   └── StripeAdapter   → Stripe API
   │
   ▼
OrderService → OrderRepository → Database
   │
   ▼
ShippingService
   │
   ▼
NotificationService
```

---

## 46. Domain Models

**CheckoutRequest**

```java
public record CheckoutRequest(String userId, PaymentProviderType paymentProvider) {
}
```

**CheckoutResult**

```java
public record CheckoutResult(String orderId, double amount, String status) {
}
```

**Cart**

```java
import java.util.List;

public record Cart(String userId, List<String> items) {
}
```

---

## 47. Payment Provider Type

```java
public enum PaymentProviderType {
    RAZORPAY,
    STRIPE
}
```

---

## 48. PaymentProcessor

Our application defines its own abstraction.

```java
public interface PaymentProcessor {

    void pay(String userId, double amount);
}
```

Notice that it does not expose Razorpay DTOs, Stripe DTOs, vendor-specific exceptions, or vendor-specific method names. This keeps the application independent of external payment providers.

---

## 49. Razorpay External Client

Imagine this is a third-party SDK.

```java
public class RazorpayClient {

    public void createPayment(String customer, long amountInPaise) {
        System.out.println("Razorpay payment: " + customer + ", amount=" + amountInPaise);
    }
}
```

---

## 50. Razorpay Adapter

```java
public class RazorpayAdapter implements PaymentProcessor {

    private final RazorpayClient razorpayClient;

    public RazorpayAdapter(RazorpayClient razorpayClient) {
        this.razorpayClient = razorpayClient;
    }

    @Override
    public void pay(String userId, double amount) {
        long amountInPaise = Math.round(amount * 100);
        razorpayClient.createPayment(userId, amountInPaise);
    }
}
```

---

## 51. Stripe External Client

```java
public class StripeClient {

    public void charge(String customerId, long amountInCents) {
        System.out.println("Stripe payment: " + customerId + ", amount=" + amountInCents);
    }
}
```

---

## 52. Stripe Adapter

```java
public class StripeAdapter implements PaymentProcessor {

    private final StripeClient stripeClient;

    public StripeAdapter(StripeClient stripeClient) {
        this.stripeClient = stripeClient;
    }

    @Override
    public void pay(String userId, double amount) {
        long amountInCents = Math.round(amount * 100);
        stripeClient.charge(userId, amountInCents);
    }
}
```

---

## 53. Payment Factory

```java
public class PaymentProcessorFactory {

    private final PaymentProcessor razorpayProcessor;
    private final PaymentProcessor stripeProcessor;

    public PaymentProcessorFactory(PaymentProcessor razorpayProcessor, PaymentProcessor stripeProcessor) {
        this.razorpayProcessor = razorpayProcessor;
        this.stripeProcessor = stripeProcessor;
    }

    public PaymentProcessor getProcessor(PaymentProviderType type) {
        return switch (type) {
            case RAZORPAY -> razorpayProcessor;
            case STRIPE -> stripeProcessor;
        };
    }
}
```

---

## 54. CartService

```java
import java.util.List;

public class CartService {

    public Cart getCart(String userId) {
        System.out.println("Fetching cart for " + userId);
        return new Cart(userId, List.of("Laptop", "Mouse"));
    }
}
```

---

## 55. PricingService

```java
public class PricingService {

    public double calculate(Cart cart) {
        System.out.println("Calculating cart price...");
        return 75000;
    }
}
```

---

## 56. InventoryService

```java
public class InventoryService {

    public void reserve(Cart cart) {
        System.out.println("Inventory reserved");
    }

    public void release(Cart cart) {
        System.out.println("Inventory released");
    }
}
```

---

## 57. OrderService

```java
public class OrderService {

    public String createOrder(Cart cart, double amount) {
        String orderId = "ORD-10001";
        System.out.println("Order created: " + orderId);
        return orderId;
    }
}
```

---

## 58. ShippingService

```java
public class ShippingService {

    public void createShipment(String orderId, Cart cart) {
        System.out.println("Shipment created for " + orderId);
    }
}
```

---

## 59. NotificationService

```java
public class NotificationService {

    public void sendConfirmation(String userId, String orderId) {
        System.out.println("Confirmation sent to " + userId + " for " + orderId);
    }
}
```

---

## 60. CheckoutFacade

This is the central component.

```java
public class CheckoutFacade {

    private final CartService cartService;
    private final PricingService pricingService;
    private final InventoryService inventoryService;
    private final PaymentProcessorFactory paymentProcessorFactory;
    private final OrderService orderService;
    private final ShippingService shippingService;
    private final NotificationService notificationService;

    public CheckoutFacade(
            CartService cartService,
            PricingService pricingService,
            InventoryService inventoryService,
            PaymentProcessorFactory paymentProcessorFactory,
            OrderService orderService,
            ShippingService shippingService,
            NotificationService notificationService) {

        this.cartService = cartService;
        this.pricingService = pricingService;
        this.inventoryService = inventoryService;
        this.paymentProcessorFactory = paymentProcessorFactory;
        this.orderService = orderService;
        this.shippingService = shippingService;
        this.notificationService = notificationService;
    }

    public CheckoutResult checkout(CheckoutRequest request) {

        Cart cart = cartService.getCart(request.userId());
        double amount = pricingService.calculate(cart);

        inventoryService.reserve(cart);

        try {
            PaymentProcessor processor = paymentProcessorFactory.getProcessor(request.paymentProvider());
            processor.pay(request.userId(), amount);

            String orderId = orderService.createOrder(cart, amount);

            shippingService.createShipment(orderId, cart);
            notificationService.sendConfirmation(request.userId(), orderId);

            return new CheckoutResult(orderId, amount, "SUCCESS");

        } catch (RuntimeException e) {
            inventoryService.release(cart);
            throw e;
        }
    }
}
```

---

## 61. Main

```java
public class Main {

    public static void main(String[] args) {

        CartService cartService = new CartService();
        PricingService pricingService = new PricingService();
        InventoryService inventoryService = new InventoryService();

        RazorpayClient razorpayClient = new RazorpayClient();
        StripeClient stripeClient = new StripeClient();

        PaymentProcessor razorpayAdapter = new RazorpayAdapter(razorpayClient);
        PaymentProcessor stripeAdapter = new StripeAdapter(stripeClient);

        PaymentProcessorFactory paymentFactory = new PaymentProcessorFactory(razorpayAdapter, stripeAdapter);

        OrderService orderService = new OrderService();
        ShippingService shippingService = new ShippingService();
        NotificationService notificationService = new NotificationService();

        CheckoutFacade checkoutFacade = new CheckoutFacade(
                cartService,
                pricingService,
                inventoryService,
                paymentFactory,
                orderService,
                shippingService,
                notificationService
        );

        CheckoutRequest request = new CheckoutRequest("USER-101", PaymentProviderType.RAZORPAY);

        CheckoutResult result = checkoutFacade.checkout(request);

        System.out.println("Checkout Result: " + result);
    }
}
```

---

## 62. Complete Production Workflow

```text
Client
   │
   ▼
CheckoutFacade
   │
   ▼
Get Cart
   │
   ▼
Calculate Price
   │
   ▼
Reserve Inventory
   │
   ▼
PaymentProcessorFactory
   ├────────────┐
   ▼            ▼
RazorpayAdapter  StripeAdapter
   │            │
   ▼            ▼
Razorpay API   Stripe API
   │
   ▼
Create Order
   │
   ▼
Create Shipment
   │
   ▼
Send Confirmation
   │
   ▼
CheckoutResult
```

---

## 63. Failure Workflow

If payment fails:

```text
Client
   │
   ▼
CheckoutFacade
   │
   ▼
Get Cart
   │
   ▼
Calculate Price
   │
   ▼
Reserve Inventory
   │
   ▼
Payment
   │
FAILURE
   │
   ▼
Release Inventory
   │
   ▼
Exception
```

This prevents inventory from remaining unnecessarily reserved.

---

## 64. Why This Design Is Better

**Without Facade:**

```text
Client
├── Cart
├── Pricing
├── Inventory
├── Payment
├── Order
├── Shipping
└── Notification
```

The client knows the entire workflow.

**With Facade:**

```text
Client
   │
   ▼
CheckoutFacade
   │
   ▼
Internal subsystem
```

The client only knows the checkout operation.

**Benefits:** lower coupling, better encapsulation, cleaner client code, centralized workflow, easier maintenance, easier testing, easier subsystem evolution, vendor details remain hidden.

---

## 65. SOLID Analysis

### Single Responsibility Principle

The Facade has a cohesive responsibility: coordinate the checkout use case. It does not own payment implementation, inventory implementation, database access, shipping implementation, or notification implementation.

---

## 66. Dependency Inversion Principle

The application depends on abstractions such as `PaymentProcessor` rather than directly depending on `RazorpayClient`. The external dependency is isolated behind the Adapter.

---

## 67. Open/Closed Principle

Suppose we add another payment provider, e.g. PayPal. We can introduce `PayPalAdapter implements PaymentProcessor`. The checkout workflow itself does not need to understand PayPal's API. The payment selection mechanism can be extended independently.

---

## 68. Liskov Substitution Principle

Both `RazorpayAdapter` and `StripeAdapter` implement `PaymentProcessor`. The Facade can use either through the common abstraction.

---

## 69. Interface Segregation Principle

The `PaymentProcessor` interface is small:

```java
public interface PaymentProcessor {

    void pay(String userId, double amount);
}
```

Clients don't need to depend on unnecessary payment methods.

---

## 70. Composition Over Inheritance

Our adapters use composition:

```java
public class RazorpayAdapter implements PaymentProcessor {

    private final RazorpayClient razorpayClient;
}
```

The Adapter contains the external client rather than inheriting from it. This gives loose coupling, easier testing, better flexibility, ability to work with final classes, and easier replacement.

---

## 71. Facade vs Decorator

These patterns are often confused.

**Facade** — simplifies access:

```text
Client → Facade → A, B, C
```

**Decorator** — adds behavior:

```text
Client → LoggingDecorator → CachingDecorator → RealService
```

```text
Facade    = Simplify
Decorator = Enhance
```

---

## 72. Facade vs Singleton

```text
Singleton → Controls number/lifecycle of instances
Facade    → Simplifies subsystem access
```

A Facade may be a Singleton in some application, but that is an independent lifecycle decision.

---

## 73. Facade vs Factory

```text
Factory → Creates/selects objects
Facade  → Simplifies subsystem access
```

```text
CheckoutFacade → PaymentFactory → PaymentProcessor
```

---

## 74. Facade vs Adapter vs Factory

| Pattern | Main Problem Solved |
|---|---|
| **Factory** | How should an object be created/selected? |
| **Adapter** | How can incompatible interfaces work together? |
| **Facade** | How can complex subsystem access be simplified? |

```text
Factory → Create
Adapter → Convert
Facade  → Simplify
```

---

## 75. Facade vs Builder

Builder constructs complex objects step-by-step:

```text
Builder → Configure object → Configure object → Configure object → Object
```

Facade coordinates existing components:

```text
Facade → Component A, Component B, Component C → Result
```

```text
Builder → Construct an object
Facade  → Coordinate a subsystem
```

---

## 76. Facade vs Prototype

Prototype is about copying an existing object:

```text
Existing Object → Prototype → New Copy
```

Facade is about simplifying access:

```text
Client → Facade → Subsystems
```

---

## 77. Facade vs Registry

Registry stores and retrieves objects using keys:

```text
Registry
├── "razorpay" → Processor
├── "stripe"   → Processor
└── "paypal"   → Processor
```

Facade simplifies a workflow. They can be combined:

```text
Facade → Registry → Implementation
```

---

## 78. When Should You Use Facade?

Use Facade when:

1. **The subsystem is complex** — many classes interact with each other.
2. **Clients repeatedly perform the same workflow** — instead of duplicating the workflow, centralize it.
3. **You want a clean application boundary**, e.g. `Controller → Facade → Subsystem`.
4. **You want to hide external integrations** — the Facade can work with application-level abstractions while adapters isolate vendors.
5. **You want lower client coupling** — instead of `Client → 7 services`, you can have `Client → Facade`.

---

## 79. When Should You NOT Use Facade?

Don't create a Facade just because it is a design pattern. Avoid unnecessary Facades when:

- The subsystem is already simple.
- There is no meaningful simplification.
- The Facade only forwards every method.
- It creates another unnecessary abstraction layer.
- It becomes a God Object.

```java
userFacade.getUserService().getUser(id);
```

This provides little value.

---

## 80. Common Mistakes

**Mistake 1 — God Facade.** One Facade for the entire application. *Fix:* split by cohesive use cases.

**Mistake 2 — Business logic dump.** Putting hundreds of lines of business logic inside the Facade. *Fix:* keep domain logic in appropriate services/domain objects.

**Mistake 3 — Exposing internal services.**

```java
facade.getPaymentService();
```
*Fix:* expose business/use-case operations.

**Mistake 4 — Direct external SDK dependencies.**

```text
Facade → Razorpay SDK
Facade → Stripe SDK
Facade → FedEx SDK
```
*Fix:* use abstractions and adapters.

**Mistake 5 — Making every Facade a Singleton.** False assumption — Facade and Singleton solve different problems.

**Mistake 6 — Treating Facade as a transaction manager.** A Facade coordinates workflow but does not automatically provide distributed transaction guarantees.

**Mistake 7 — Assuming everything must be synchronous.** Some operations can be handled asynchronously through events.

**Mistake 8 — Blind retries.** Retrying payment operations without considering idempotency can cause duplicate charges.

---

## 81. Interview Questions — Basic

**Q1. What is the Facade Pattern?**
A structural design pattern that provides a simple, unified interface to a complex subsystem.

**Q2. Why use Facade?**
To reduce client coupling and hide subsystem complexity.

**Q3. Is Facade a creational, structural, or behavioral pattern?**
Structural.

**Q4. Does Facade require an interface?**
No.

**Q5. Does Facade require Singleton?**
No.

---

## 82. Interview Questions — Intermediate

**Q6. What is the difference between Facade and Adapter?**
Adapter solves interface incompatibility. Facade simplifies access to a complex subsystem.

```text
Adapter → Compatibility
Facade  → Simplification
```

**Q7. Can we have multiple Facades?** Yes.

**Q8. Can a Facade directly instantiate subsystem classes?** It can, but constructor injection is generally preferable for loose coupling and testability.

**Q9. Can a Facade contain business logic?** It can contain orchestration logic, but extensive business/domain logic should generally remain in the appropriate services/domain objects.

**Q10. Can Facade and Factory be used together?** Yes.

---

## 83. Interview Questions — Advanced

**Q11. How would you handle partial failure in a Facade workflow?**
Define explicit failure semantics and use compensation, retries, idempotency, or asynchronous events where appropriate.

**Q12. How would you prevent duplicate checkout during retry?**
Use idempotency keys and persistent idempotency state.

**Q13. How would you isolate third-party APIs?**
Use application-level abstractions and Adapters.

**Q14. Can Facade be used as an architectural boundary?**
Yes — it can provide a clean entry point between clients/controllers and complex application subsystems.

**Q15. Can Facade be used with event-driven architecture?**
Yes — the Facade can perform the core synchronous workflow and publish events for secondary operations.

---

## 84. LLD Interview Approach

If an interviewer asks you to design an e-commerce checkout system, think:

| Step | Action |
|:----:|--------|
| 1 | Identify the use case: `checkout()`. |
| 2 | Identify subsystem responsibilities: Cart, Pricing, Inventory, Payment, Order, Shipping, Notification. |
| 3 | Ask whether clients should coordinate them — if yes, introduce `CheckoutFacade`. |
| 4 | Identify external systems: Razorpay, Stripe, FedEx, Twilio. |
| 5 | Introduce Adapters: `PaymentAdapter`, `ShippingAdapter`, `NotificationAdapter`. |
| 6 | Identify implementation selection — use Factory where appropriate. |
| 7 | Consider failure — e.g. payment failure → release inventory. |
| 8 | Consider production concerns: idempotency, retry, partial failure, events, asynchronous processing, thread safety. |

---

## 85. Complete Architecture Summary

```text
Client
   │
   ▼
CheckoutFacade
   │
   ├─────────────┬─────────────┐
   ▼             ▼             ▼
CartService  PricingService InventoryService
                                   │
                                   ▼
                              Inventory DB

                              PaymentProcessorFactory
                                   ├─────────────┐
                                   ▼             ▼
                          RazorpayAdapter   StripeAdapter
                                   │             │
                                   ▼             ▼
                            Razorpay API    Stripe API
                                   │
                                   ▼
                              OrderService
                                   │
                                   ▼
                             OrderRepository
                                   │
                                   ▼
                                Database
                                   │
                                   ▼
                             ShippingService
                                   │
                                   ▼
                             ShippingAdapter
                                   │
                                   ▼
                            Shipping Provider
                                   │
                                   ▼
                           NotificationService
                                   │
                                   ▼
                          Notification Provider
```

---

## 86. Pattern Combination Summary

Facade can work naturally with many other patterns.

```text
Facade
├── Factory    → Implementation
├── Adapter    → External API
├── Service    → Business capability
├── Repository → Persistence
├── Events
└── Async processing
```

The important thing is not to use patterns for the sake of using patterns. Each pattern should solve a specific design problem.

---

## 87. Facade Mental Model

```text
Complex Subsystem

    A
   / \
  B   C
   \ /
    D   E
     \ /
      F

       │
       ▼
    Facade
       │
       ▼
Simple Interface
```

The subsystem itself may remain complex. The Facade simply provides a simpler way to interact with it.

---

## 88. One-Line Definition

> Facade provides a simple, unified interface to a complex subsystem, hiding the complexity of coordinating its underlying components.

---

## 89. One-Line Memory Trick

```text
Facade = Simplify
```

---

## 90. Pattern Comparison Cheat Sheet

| Pattern | Core Purpose |
|---|---|
| **Singleton** | Control instance creation/lifecycle |
| **Builder** | Construct complex objects step-by-step |
| **Prototype** | Create objects by copying existing objects |
| **Registry** | Store/retrieve reusable objects by key |
| **Factory** | Create/select objects |
| **Adapter** | Convert incompatible interfaces |
| **Facade** | Simplify access to complex subsystems |
| **Decorator** | Add behavior dynamically |
| **Flyweight** | Share intrinsic state to reduce memory |

---

## 91. Facade Checklist

### Part 1 — Fundamentals

- [x] Definition
- [x] Structural pattern classification
- [x] Problem
- [x] Before Facade / After Facade
- [x] Core structure (Client, Facade, Subsystems)
- [x] Home theater example
- [x] E-commerce example
- [x] Facade does not require interface
- [x] Facade does not require Singleton
- [x] Basic Java implementation
- [x] Basic practice

### Part 2 — Variations and Deeper Concepts

- [x] Layered Facades
- [x] Multiple Facades
- [x] God Facade
- [x] Orchestration
- [x] Facade + Adapter
- [x] Facade + Factory
- [x] Constructor Injection
- [x] Error Handling
- [x] Compensation
- [x] Transaction boundaries
- [x] Idempotency
- [x] Retry considerations
- [x] Thin Facade
- [x] Keeping business logic outside Facade
- [x] Checkout practice

### Part 3 — Advanced Concepts

- [x] Architectural boundary
- [x] Client-oriented APIs
- [x] Layered architecture
- [x] Repository interaction
- [x] External API isolation
- [x] Anti-Corruption Layer
- [x] Thin Facade principle
- [x] Testing / failure-path testing
- [x] Partial failure
- [x] Events / asynchronous processing
- [x] Concurrency considerations
- [x] Thread safety
- [x] SOLID principles
- [x] Pattern combinations
- [x] Common mistakes
- [x] Advanced interview questions

### Part 4 — Final Production LLD

- [x] E-commerce checkout system
- [x] CheckoutFacade / CheckoutRequest / CheckoutResult
- [x] CartService / PricingService / InventoryService
- [x] PaymentProcessor / RazorpayAdapter / StripeAdapter
- [x] PaymentProcessorFactory
- [x] OrderService / ShippingService / NotificationService
- [x] Constructor injection
- [x] Payment failure compensation
- [x] Factory + Adapter + Facade
- [x] SOLID analysis
- [x] Event-driven extension
- [x] Production considerations
- [x] Common interview traps
- [x] LLD interview approach
- [x] Complete architecture

---

## 92. Final Takeaway

When you see a system where:

```text
Client
├── Component A
├── Component B
├── Component C
├── Component D
└── Component E
```

and the client needs to understand how these components work together, consider a Facade:

```text
Client
   │
   ▼
Facade
├── Component A
├── Component B
├── Component C
├── Component D
└── Component E
```

The Facade provides:

- Simplicity
- Encapsulation
- Lower coupling
- Centralized orchestration
- Cleaner client APIs
- Easier evolution of complex subsystems

The most important distinction to remember:

```text
Factory   → Create
Adapter   → Convert
Facade    → Simplify
Decorator → Enhance
Flyweight → Share
```

And the core Facade principle:

> Don't make the subsystem necessarily simpler. Make the subsystem simpler *to use*.