# 🎨 Decorator Design Pattern

A complete guide to understanding, implementing, and applying the Decorator Design Pattern in Java.

---

## 📚 Table of Contents

1. [Introduction](#1-introduction)
2. [What Problem Does Decorator Solve?](#2-what-problem-does-decorator-solve)
3. [Decorator Pattern Definition](#3-decorator-pattern-definition)
4. [Decorator Pattern Classification](#4-decorator-pattern-classification)
5. [Core Idea](#5-core-idea)
6. [Basic Structure](#6-basic-structure)
7. [Participants](#7-participants)
8. [Basic Java Implementation](#8-basic-java-implementation)
9. [How the Decorator Works](#9-how-the-decorator-works)
10. [Composition in Decorator](#10-composition-in-decorator)
11. [Runtime Composition](#11-runtime-composition)
12. [Multiple Decorators](#12-multiple-decorators)
13. [Decorator Execution Flow](#13-decorator-execution-flow)
14. [Before and After Behavior](#14-before-and-after-behavior)
15. [Input Transformation](#15-input-transformation)
16. [Output Transformation](#16-output-transformation)
17. [Decorator Ordering](#17-decorator-ordering)
18. [Decorator and Inheritance](#18-decorator-and-inheritance)
19. [Decorator and Composition](#19-decorator-and-composition)
20. [Decorator and SOLID](#20-decorator-and-solid)
21. [Real-World Use-Case Examples](#21-real-world-use-case-examples)
22. [Pipeline Examples](#22-pipeline-examples)
23. [Machine-Coding Perspective](#23-machine-coding-perspective)
24. [Decorator vs Other Patterns](#24-decorator-vs-other-patterns)
25. [Stateful Decorators](#25-stateful-decorators)
26. [Exception Handling](#26-exception-handling)
27. [Common Mistakes](#27-common-mistakes)
28. [When to Use / Not Use Decorator](#28-when-to-use--not-use-decorator)
29. [Advantages & Disadvantages](#29-advantages--disadvantages)
30. [Real-World Applications](#30-real-world-applications)
31. [Interview Questions](#31-interview-questions)
32. [30-Second Interview Explanation](#32-30-second-interview-explanation)
33. [Machine-Coding Checklist](#33-machine-coding-checklist)
34. [Final Mental Model & Summary](#34-final-mental-model--summary)

---

## 1. Introduction

The **Decorator Design Pattern** is a *structural* design pattern used to dynamically add responsibilities or behavior to an object.

Instead of modifying the original class or creating many subclasses, we **wrap** the original object inside decorator objects. The decorators implement the **same interface** as the object they wrap.

```
Client → Decorator → Component
```

Multiple decorators can be stacked:

```
Client → Logging → Metrics → Retry → Payment Service
```

This allows behavior to be composed dynamically.

---

## 2. What Problem Does Decorator Solve?

Consider a payment system that starts simple:

```
PaymentService → BasicPaymentService
```

Requirements keep growing — we now need: **logging, metrics, auditing, retry, validation, fraud checking, notifications.**

A naive approach creates a new class per combination:

```
PaymentWithLogging
PaymentWithMetrics
PaymentWithAudit
PaymentWithLoggingAndMetrics
PaymentWithLoggingAndAudit
PaymentWithLoggingMetricsAndAudit
PaymentWithLoggingMetricsAuditRetry
...
```

The number of combinations grows rapidly, causing:

- Too many classes
- Difficult maintenance
- Tight coupling
- Poor extensibility
- Large inheritance hierarchies

**Decorator solves this through composition** — instead of a new class per combination, behaviors are composed dynamically:

```java
PaymentService service =
    new LoggingDecorator(
        new MetricsDecorator(
            new RetryDecorator(
                new BasicPaymentService()
            )
        )
    );
```

---

## 3. Decorator Pattern Definition

> **Decorator** is a structural design pattern that allows behavior or responsibilities to be dynamically added to an object by wrapping it with other objects that implement the same interface.

Key ideas: **same interface · wrapping · composition · dynamic behavior · multiple decorators · runtime flexibility.**

---

## 4. Decorator Pattern Classification

Decorator belongs to the **Structural Design Patterns** — patterns that focus on how objects and classes are composed to form larger structures.

| Structural patterns |
|---|
| Adapter · **Decorator** · Facade · Proxy · Composite · Bridge · Flyweight |

Decorator specifically focuses on: **dynamically adding behavior to an object.**

---

## 5. Core Idea

> Wrap an object with another object that implements the **same interface**.

```java
interface PaymentService {
    void pay();
}
```

```
PaymentService
 ├─ BasicPaymentService
 ├─ LoggingDecorator
 ├─ MetricsDecorator
 └─ RetryDecorator
```

Every decorator can wrap another `PaymentService`:

```java
new LoggingDecorator(
    new MetricsDecorator(
        new BasicPaymentService()
    )
);
```

---

## 6. Basic Structure

```
        Component  «interface»
             ▲
   ┌─────────┴─────────┐
   │                    │
ConcreteComponent    Decorator
                        │  (holds a reference to Component)
                        ▼
                  ConcreteDecorator
```

| Element | Role |
|---|---|
| `Component` | The shared interface/contract |
| `ConcreteComponent` | The original, core implementation |
| `Decorator` | Implements `Component`, and *holds* a `Component` |
| `ConcreteDecorator` | Adds one specific behavior, delegating to the held component |

---

## 7. Participants

### 7.1 Component

Defines the common contract.

```java
interface PaymentService {
    void pay(double amount);
}
```

### 7.2 Concrete Component

The original / core implementation.

```java
class BasicPaymentService implements PaymentService {
    @Override
    public void pay(double amount) {
        System.out.println("Processing payment");
    }
}
```

### 7.3 Decorator

The base decorator also implements the same interface, and holds another component.

```java
abstract class PaymentServiceDecorator implements PaymentService {
    protected final PaymentService paymentService;

    protected PaymentServiceDecorator(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @Override
    public void pay(double amount) {
        paymentService.pay(amount);
    }
}
```

### 7.4 Concrete Decorator

Adds a specific responsibility.

```java
class LoggingDecorator extends PaymentServiceDecorator {
    public LoggingDecorator(PaymentService paymentService) {
        super(paymentService);
    }

    @Override
    public void pay(double amount) {
        System.out.println("Payment started");
        paymentService.pay(amount);
        System.out.println("Payment completed");
    }
}
```

---

## 8. Basic Java Implementation

A minimal, classic example — coffee with add-ons:

```java
interface Coffee {
    double getCost();
    String getDescription();
}
```

**Concrete component:**

```java
class SimpleCoffee implements Coffee {
    @Override
    public double getCost() { return 100; }

    @Override
    public String getDescription() { return "Simple Coffee"; }
}
```

**Base decorator:**

```java
abstract class CoffeeDecorator implements Coffee {
    protected final Coffee coffee;

    protected CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }
}
```

**Concrete decorator:**

```java
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public double getCost() { return coffee.getCost() + 20; }

    @Override
    public String getDescription() { return coffee.getDescription() + ", Milk"; }
}
```

**Usage:**

```java
Coffee coffee = new SimpleCoffee();
coffee = new MilkDecorator(coffee);

System.out.println(coffee.getDescription());
System.out.println(coffee.getCost());
```

The client only ever deals with the `Coffee` interface — it doesn't care whether the object underneath is `SimpleCoffee`, `MilkDecorator`, `SugarDecorator`, or `MilkDecorator(SugarDecorator(SimpleCoffee))`.

---

## 9. How the Decorator Works

```java
PaymentService service =
    new LoggingDecorator(
        new BasicPaymentService()
    );
```

```
LoggingDecorator → BasicPaymentService
```

Calling `service.pay(5000)`:

1. `LoggingDecorator.pay()` executes
2. Logging happens
3. It calls the wrapped `PaymentService`
4. `BasicPaymentService.pay()` executes
5. Control returns to the decorator
6. Additional after-processing can happen

---

## 10. Composition in Decorator

Decorator relies heavily on **composition**:

```java
protected final PaymentService paymentService;   // HAS-A
```

At the same time, the decorator **IS-A** `PaymentService` because it implements the same interface.

```
Decorator
 ├─ IS-A  Component   (implements the interface)
 └─ HAS-A Component   (wraps another instance)
```

This dual relationship is the key to the pattern.

---

## 11. Runtime Composition

One of the biggest benefits: behavior pipelines can be built **at runtime**.

```java
PaymentService service = new BasicPaymentService();
service = new LoggingDecorator(service);
service = new MetricsDecorator(service);
service = new RetryDecorator(service);
```

Final structure:

```
Retry → Metrics → Logging → Payment
```

The original implementation was never modified — a behavior pipeline was dynamically constructed.

---

## 12. Multiple Decorators

```java
PaymentService service =
    new LoggingDecorator(
        new MetricsDecorator(
            new RetryDecorator(
                new BasicPaymentService()
            )
        )
    );
```

```
Logging → Metrics → Retry → Payment
```

This is far more flexible than inheritance-based combinations.

---

## 13. Decorator Execution Flow

For the stack `Logging → Metrics → Retry → Payment`, execution starts from the **outermost** decorator and unwinds back outward:

```
Logging   (before)
  Metrics (before)
    Retry
      Payment
  Metrics (after)
Logging   (after)
```

This "wrap in, unwrap out" order is a defining characteristic of Decorator.

---

## 14. Before and After Behavior

Decorators can run logic **before** delegation:

```java
@Override
public void execute() {
    System.out.println("Before");
    component.execute();
}
```

**after** delegation:

```java
@Override
public void execute() {
    component.execute();
    System.out.println("After");
}
```

or **both**:

```java
@Override
public void execute() {
    System.out.println("Before");
    component.execute();
    System.out.println("After");
}
```

This makes Decorator useful for: logging, metrics, auditing, transactions, tracing, validation, notifications.

---

## 15. Input Transformation

A decorator doesn't have to forward the same input unchanged — it can transform it first.

```java
@Override
public void process(String data) {
    String compressedData = compress(data);
    component.process(compressedData);
}
```

```
Original Data → CompressionDecorator → Compressed Data → Component
```

---

## 16. Output Transformation

Decorators can also modify the **result**.

```java
@Override
public String execute() {
    String result = component.execute();
    return transform(result);
}
```

```
Component → Original Result → Decorator → Transformed Result
```

---

## 17. Decorator Ordering

**Ordering matters.** These two pipelines are *not* equivalent:

```
Encryption → Compression → Storage
```
```
Compression → Encryption → Storage
```

```
Encryption(Compression(data))   ≠   Compression(Encryption(data))
```

When composing decorators, always ask:

- Which behavior should execute first?
- Which behavior should execute last?
- Should failure prevent inner decorators from executing?
- Should the outer decorator observe failures?

---

## 18. Decorator and Inheritance

Inheritance alone produces a combinatorial explosion:

```
PaymentService
 ├─ PaymentWithLogging
 ├─ PaymentWithMetrics
 ├─ PaymentWithRetry
 ├─ PaymentWithLoggingAndMetrics
 ├─ PaymentWithLoggingAndRetry
 ├─ PaymentWithMetricsAndRetry
 └─ PaymentWithLoggingMetricsAndRetry ...
```

Decorator avoids this:

```
Logging(Metrics(Retry(Payment())))
```

> Decorator is often preferred when behavior combinations need to be dynamically composed.

---

## 19. Decorator and Composition

Instead of:

```
Subclass → Modified behavior
```

Decorator uses:

```
Decorator → Wrapped object
```

This follows the general design principle: **favor composition over inheritance.**

---

## 20. Decorator and SOLID

### 20.1 Single Responsibility Principle

A monolithic class might originally hold payment + logging + metrics + audit + retry + validation + notification logic together. Decorator lets each of these become a **separate class**, each with one responsibility.

### 20.2 Open/Closed Principle

New behavior can be introduced without touching the existing component:

```java
class FraudCheckDecorator extends PaymentServiceDecorator {
    // ...
}
```

The original payment implementation remains unchanged — strongly supporting **Open/Closed**.

### 20.3 Dependency Inversion Principle

The decorator depends on the **abstraction** (`PaymentService`), not a specific implementation (`BasicPaymentService`) — allowing it to wrap core implementations, other decorators, or different implementations interchangeably.

---

## 21. Real-World Use-Case Examples

### Logging

```java
@Override
public void pay(double amount) {
    System.out.println("[LOG] Payment started");
    paymentService.pay(amount);
    System.out.println("[LOG] Payment completed");
}
```

The core payment service doesn't need to know logging exists.

### Metrics

```java
@Override
public void pay(double amount) {
    long startTime = System.currentTimeMillis();
    paymentService.pay(amount);
    long endTime = System.currentTimeMillis();
    System.out.println("Execution time: " + (endTime - startTime) + " ms");
}
```

```
Start Timer → Execute Service → Stop Timer → Record Metric
```

### Retry

```java
@Override
public void execute() {
    for (int attempt = 1; attempt <= maxAttempts; attempt++) {
        try {
            component.execute();
            return;
        } catch (RuntimeException exception) {
            if (attempt == maxAttempts) {
                throw exception;
            }
        }
    }
}
```

```
Attempt 1 (fail) → Attempt 2 (fail) → Attempt 3 → Success / Failure
```

### Caching

```java
@Override
public User getUser(String id) {
    if (cache.containsKey(id)) {
        return cache.get(id);
    }
    User user = repository.getUser(id);
    cache.put(id, user);
    return user;
}
```

```
Client → CachingDecorator ──cache hit──> return cached result
                          └─cache miss──> Repository
```

The repository doesn't need to know caching exists.

### Auditing

```java
@Override
public void pay(double amount) {
    audit("Payment requested: " + amount);
    paymentService.pay(amount);
}
```

Common use cases: financial operations, user changes, order creation, security-sensitive actions, administrative operations.

### Validation

```java
@Override
public void createOrder(Order order) {
    if (order == null) {
        throw new IllegalArgumentException("Order cannot be null");
    }
    if (order.getAmount() <= 0) {
        throw new IllegalArgumentException("Amount must be positive");
    }
    orderService.createOrder(order);
}
```

```
Request → Validation (valid) → Core Service
```

### Authentication

```java
@Override
public void handle(Request request) {
    if (!isAuthenticated(request)) {
        throw new RuntimeException("Authentication failed");
    }
    requestHandler.handle(request);
}
```

If authentication fails, the wrapped component is **never executed**.

### Authorization

Authentication asks *"who are you?"*; authorization asks *"are you allowed to do this?"*

```java
@Override
public void handle(Request request) {
    if (!hasPermission(request)) {
        throw new RuntimeException("Access denied");
    }
    requestHandler.handle(request);
}
```

```
Request → Authentication → Authorization → Controller
```

---

## 22. Pipeline Examples

### Notification Pipeline

```
Logging → Metrics → Retry → Email
```

Each concern stays independent of the others.

### Fallback Decorator

A fallback decorator tries another channel if the primary one fails:

```
Try Email
  ├─ Success → Done
  └─ Failure → Retry
                 ├─ Success → Done
                 └─ Failure → SMS
```

### Middleware-Style Processing

Decorator has a strong conceptual relationship to middleware pipelines:

```
Logging → Authentication → Authorization → Rate Limiting → Controller
```

Each layer can perform work before/after the next layer, or stop execution — structurally similar to Decorator, though the exact design intent determines which pattern name best fits.

### Compression and Encryption (data transformation)

```
Encryption → Compression → Storage
```

```java
processor.process(encryptedData);
```

The next decorator may then compress it before storage — showing decorators can transform data, not just add logging.

### Payment Pipeline

```
Logging → Validation → Fraud Check → Audit → Metrics → Retry → Payment
```

Each layer has a focused responsibility; the core payment implementation stays simple.

### Order Processing Pipeline

```
Logging → Validation → Audit → Discount → Metrics → Order Service
```

A discount decorator can **transform** the order itself:

```
Original Order → Discount Decorator → Modified Order → Order Service
```

This shows Decorator isn't limited to cross-cutting concerns — it can modify data too.

---

## 23. Machine-Coding Perspective

Decorator becomes especially useful in LLD machine-coding problems when requirements say things like:

> *"The system should allow adding these features independently."*

e.g., logging / metrics / retry / audit / validation should all be **optional**:

```
Core Service
 ├─ Optional behavior
 ├─ Optional behavior
 └─ Optional behavior
```

### Thought Process — Ask These Questions

| # | Question | If "yes" |
|---|---|---|
| 1 | Is there a core operation? (Payment, Order, Notification, Shipping, Download) | Continue |
| 2 | Are there optional additional behaviors? (Logging, Metrics, Retry, Audit, Validation, Caching) | Continue |
| 3 | Can those behaviors be independently combined? | Consider Decorator |
| 4 | Does the behavior need to be dynamically composed? | Decorator becomes even more attractive |

---

## 24. Decorator vs Other Patterns

### Decorator vs Strategy

| Strategy | Decorator |
|---|---|
| Answers: *"which algorithm/behavior should I use?"* | Answers: *"what additional behaviors should I add?"* |
| Selects **one** algorithm, e.g. `UPI`, `Credit Card`, `PayPal` | **Combines** behaviors, e.g. `Logging → Metrics → Retry → Payment` |

> **Rule of thumb:** Choose one algorithm → Strategy. Combine additional behaviors → Decorator.

### Decorator vs Proxy

| Decorator | Proxy |
|---|---|
| Intent: **add or enhance** behavior | Intent: **control access** to an object |
| e.g. `Payment → LoggingDecorator` | e.g. authentication, authorization, lazy loading, remote access |

> The structure can be nearly identical between the two — the difference is primarily **intent**: enhance behavior → Decorator; control access → Proxy.

### Decorator vs Adapter

| Adapter | Decorator |
|---|---|
| Used when interfaces are **incompatible** | Normally **preserves** the same interface |
| `Client → Expected Interface → Adapter → Existing Interface` | `Client → Decorator → Same Component Interface` |

> **Rule of thumb:** Make incompatible interfaces work together → Adapter. Add behavior to an existing interface → Decorator.

### Decorator vs Chain of Responsibility

The key question: does every layer necessarily contribute behavior, or does each handler decide whether to continue?

| Decorator | Chain of Responsibility |
|---|---|
| Multiple layers **all** enhance the same operation | A handler can handle, reject, **or** pass the request onward |
| `Logging → Metrics → Retry → Component` | `Handler 1 (handles or passes) → Handler 2 → ...` |

> **Rule of thumb:** All layers enhance execution → Decorator. Handlers decide whether to process/pass → Chain of Responsibility.

### Decorator vs Inheritance

| Inheritance | Decorator |
|---|---|
| `Base Class → Child A / Child B / Child C` | `Decorator A → Decorator B → Component` |
| Good for a stable, hierarchical relationship | Good for dynamically combined behaviors |

---

## 25. Stateful Decorators

Decorators don't have to be stateless. Examples:

```java
// Rate limiter
private int requestCount;
private final int maxRequests;

// Cache
Map<String, User> cache;
```

For backend applications, consider:

- Is the decorator shared?
- Can multiple threads access it?
- Is the state thread-safe?
- Should state be per-request? Per-user? Distributed?

> Stateful decorators (caches, rate limiters, retry counters, circuit breakers) require more care than simple logging decorators.

---

## 26. Exception Handling

Decorators can handle exceptions in several ways:

**Propagate:**
```java
component.execute();   // exception goes straight to the caller
```

**Log and rethrow:**
```java
try {
    component.execute();
} catch (RuntimeException exception) {
    log(exception);
    throw exception;
}
```

**Recover:**
```java
try {
    component.execute();
} catch (RuntimeException exception) {
    fallback();
}
```

**Retry:**
```
Decorator → Try → Failure → Retry → Try again
```

Decorators can control failure behavior **without changing the core component**.

---

## 27. Common Mistakes

| # | Mistake | Explanation |
|---|---|---|
| 1 | **Different interface** | A decorator should implement the *same* contract as the component — otherwise transparent wrapping breaks down. |
| 2 | **Forgetting delegation** | e.g. a decorator that logs but never calls `component.execute()` accidentally breaks the chain. Always delegate unless intentionally short-circuiting. |
| 3 | **Incorrect ordering** | `Encryption → Compression` is not the same as `Compression → Encryption`. Always think through ordering. |
| 4 | **Huge decorators** | A decorator crammed with logging + validation + payment + database + notification + retry + metrics + audit loses its focused responsibility. |
| 5 | **Too many decorators** | A stack of 8+ decorators can become impossible to trace. If nobody can follow the execution flow, reconsider the design. |

---

## 28. When to Use / Not Use Decorator

### ✅ Use Decorator when

1. You need **optional behavior** (logging, metrics, audit)
2. Behaviors need to be **combined** (logging + metrics + retry)
3. Behavior needs to be added **dynamically** (`service = new LoggingDecorator(service);`)
4. **Subclass explosion** is occurring from combining features
5. You want to keep the **original component** focused and unmodified

### ❌ Consider Alternatives Instead

| Situation | Use instead |
|---|---|
| Hierarchy is simple and stable (e.g. `Animal → Dog`) | Plain inheritance |
| Need to select **one** algorithm | Strategy |
| Need interface compatibility | Adapter |
| Main purpose is access control | Proxy |
| Multiple handlers decide whether to process/pass | Chain of Responsibility |

---

## 29. Advantages & Disadvantages

### Advantages

- **Runtime flexibility** — behavior composed dynamically
- **Avoids subclass explosion** — no `ClassA`, `ClassAB`, `ClassABC`, `ClassABCD`...
- **Supports Open/Closed Principle** — add behavior without modifying the component
- **Single Responsibility** — each decorator focuses on one concern
- **Composition over inheritance** — flexible object composition
- **Reorderable behaviors** — different orderings produce different results

### Disadvantages

- **Many small classes** — large systems can accumulate many decorators
- **Harder debugging** — a deep stack (`Logging → Metrics → Retry → Cache → Audit → Validation → Service`) is harder to trace
- **Ordering problems** — order affects behavior, and that's easy to get wrong
- **Configuration complexity** — manually building a large decorator chain gets cumbersome
- **Stateful decorators need care** — thread safety and lifecycle become important

---

## 30. Real-World Applications

| Use case | Pipeline |
|---|---|
| Logging | `Logging → Service` |
| Metrics | `Metrics → Service` |
| Retry | `Retry → Service` |
| Caching | `Cache → Repository` |
| Authentication | `Authentication → Handler` |
| Authorization | `Authorization → Handler` |
| Auditing | `Audit → Service` |
| Validation | `Validation → Service` |
| Notification | `Notification → Core operation` |
| Data processing | `Encryption → Compression → Storage` |

---

## 31. Interview Questions

| # | Question | Answer |
|---|---|---|
| 1 | What is Decorator? | A structural pattern that dynamically adds responsibilities to an object by wrapping it with another object implementing the same interface. |
| 2 | Why use Decorator instead of inheritance? | It allows runtime composition and avoids creating many subclasses for different behavior combinations. |
| 3 | What's the key characteristic of Decorator? | The decorator and the wrapped component implement the same interface. |
| 4 | Does Decorator use inheritance? | Yes — the concrete decorator typically implements/extends the component contract — but the *primary* mechanism for adding behavior is composition. |
| 5 | Does Decorator use composition? | Yes — the decorator contains (`HAS-A`) another component. |
| 6 | Can multiple decorators be used? | Yes — `Decorator A → Decorator B → Decorator C → Component`. |
| 7 | Does decorator ordering matter? | Yes — different orders can produce different behavior. |
| 8 | Can a decorator modify input? | Yes. |
| 9 | Can a decorator modify output? | Yes. |
| 10 | Can a decorator stop execution? | Yes — e.g. validation or authentication can reject a request without calling the wrapped component. |
| 11 | Can decorators maintain state? | Yes — caches, rate limiters, retry counters, metrics, circuit breakers — but thread safety matters. |
| 12 | Decorator vs Proxy? | Decorator enhances behavior; Proxy controls access. Structure can be similar — intent is the key distinction. |
| 13 | Decorator vs Adapter? | Adapter changes interface compatibility; Decorator preserves the interface and adds behavior. |
| 14 | Decorator vs Strategy? | Strategy chooses an algorithm; Decorator combines additional behaviors. |
| 15 | Decorator vs Chain of Responsibility? | Decorator layers generally all contribute to the same operation; Chain of Responsibility handlers decide whether to handle or pass the request. |

---

## 32. 30-Second Interview Explanation

> Decorator is a structural design pattern used to dynamically add responsibilities to an object without modifying its original implementation. The decorator implements the same interface as the component and holds a reference to another component. This lets multiple decorators — Logging, Metrics, Retry, Audit — be stacked at runtime around something like a `PaymentService`. It favors composition over inheritance and helps avoid subclass explosion.

```
Logging → Metrics → Retry → PaymentService
```

---

## 33. Machine-Coding Checklist

Consider Decorator if the problem looks like:

```
Core Service
 ├─ Optional Logging
 ├─ Optional Metrics
 ├─ Optional Retry
 ├─ Optional Audit
 └─ Optional Validation
```

Checklist:

- [ ] Is there a common interface?
- [ ] Is there a core implementation?
- [ ] Can additional behavior be represented independently?
- [ ] Can behaviors be combined?
- [ ] Should behavior be dynamically configurable?
- [ ] Would inheritance create too many subclasses?
- [ ] Does ordering matter?
- [ ] Can each decorator have a single responsibility?

If most answers are **yes**, Decorator is likely a good fit.

---

## 34. Final Mental Model & Summary

### Mental Model

```
Decorator
 ├─ Adds behavior
 ├─ Delegates to the wrapped component
 └─ Implements the same interface as that component
```

Multiple decorators, visually:

```
Client
  ↓
Logging
  ↓
Metrics
  ↓
Retry
  ↓
Audit
  ↓
Core
```

**The key idea:** each decorator wraps the same abstraction and adds one focused behavior.

### Fundamental Relationships

```
Decorator
 ├─ IS-A  Component
 └─ HAS-A Component
```

```
Outer Decorator → Next Decorator → Next Decorator → Core Component → return outward
```

**Fundamental design principle:** favor composition over inheritance.

**Fundamental interview decision:**

```
Need to add/combine behaviors dynamically?
  YES → Consider Decorator
```

### Final Definition

> **Decorator** is a structural design pattern that dynamically adds responsibilities to an object by wrapping it with objects that implement the same interface, allowing behavior to be composed flexibly at runtime while avoiding unnecessary subclassing.

---

## 🏆 Coverage Checklist

| Topic | Covered |
|---|---|
| Core concepts & structure | ✅ |
| Component / Concrete Component / Decorator / Concrete Decorator | ✅ |
| Composition & runtime composition | ✅ |
| Multiple decorators & execution flow | ✅ |
| Before/after behavior, input/output transformation | ✅ |
| Ordering | ✅ |
| Logging, Metrics, Retry, Caching, Audit, Validation | ✅ |
| Authentication, Authorization, Fallback, Middleware | ✅ |
| Compression / Encryption pipelines | ✅ |
| SOLID alignment | ✅ |
| Comparisons: Strategy, Proxy, Adapter, Chain of Responsibility, Inheritance | ✅ |
| Stateful decorators & exception handling | ✅ |
| Machine coding checklist & interview questions | ✅ |
| Common mistakes, when to use / not use | ✅ |