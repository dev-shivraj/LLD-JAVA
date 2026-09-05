# Open/Closed Principle (OCP)

OCP is the **O** in SOLID.

> **Software entities should be open for extension but closed for modification.**

The key idea is:

> When new behavior is added, we should preferably extend the system instead of repeatedly modifying already-working code.

---

## Table of Contents

1. [SOLID Overview](#1-solid-overview)
2. [OCP Definition](#2-ocp-definition)
3. [Simple Mental Model](#3-simple-mental-model)
4. [Simple Example](#4-simple-example)
5. [Why This Becomes a Problem](#5-why-this-becomes-a-problem)
6. [Important Clarification](#6-important-clarification)
7. [Conditional Logic as an OCP Smell](#7-conditional-logic-as-an-ocp-smell)
8. [Variation Point](#8-variation-point)
9. [Shipping Example](#9-shipping-example)
10. [Identify the Abstraction](#10-identify-the-abstraction)
11. [Shipping Interface](#11-shipping-interface)
12. [Standard Shipping](#12-standard-shipping)
13. [Express Shipping](#13-express-shipping)
14. [International Shipping](#14-international-shipping)
15. [Adding Same-Day Shipping](#15-adding-same-day-shipping)
16. [Shipping Architecture](#16-shipping-architecture)
17. [Client Using Abstraction](#17-client-using-abstraction)
18. [Adding New Shipping Types](#18-adding-new-shipping-types)
19. [Core OCP Transformation](#19-core-ocp-transformation)
20. [Media Player Example](#20-media-player-example)
21. [Media Variation Point](#21-media-variation-point)
22. [Playable Interface](#22-playable-interface)
23. [MP3 Implementation](#23-mp3-implementation)
24. [MP4 Implementation](#24-mp4-implementation)
25. [Adding FLAC](#25-adding-flac)
26. [Bird Example](#26-bird-example)
27. [Bird Variation Point](#27-bird-variation-point)
28. [OCP and Bird: Important Connection](#28-ocp-and-bird-important-connection)
29. [Cloud Storage Example](#29-cloud-storage-example)
30. [Storage Variation Point](#30-storage-variation-point)
31. [OCP with Multiple Variation Points](#31-ocp-with-multiple-variation-points)
32. [Class Explosion Problem](#32-class-explosion-problem)
33. [Composition Solves the Problem](#33-composition-solves-the-problem)
34. [StorageProvider](#34-storageprovider)
35. [Encryption](#35-encryption)
36. [CloudStorageService](#36-cloudstorageservice)
37. [Why Composition Helps OCP](#37-why-composition-helps-ocp)
38. [OCP Through Inheritance](#38-ocp-through-inheritance)
39. [OCP Through Interfaces](#39-ocp-through-interfaces)
40. [OCP Through Composition](#40-ocp-through-composition)
41. [Inheritance vs Composition](#41-inheritance-vs-composition)
42. [Enum-Based Conditional Logic](#42-enum-based-conditional-logic)
43. [Not Every Enum Requires OCP](#43-not-every-enum-requires-ocp)
44. [When to Suspect OCP](#44-when-to-suspect-ocp)
45. [OCP and Strategy Pattern](#45-ocp-and-strategy-pattern)
46. [OCP and Factory Pattern](#46-ocp-and-factory-pattern)
47. [OCP and Dependency Injection](#47-ocp-and-dependency-injection)
48. [OCP Does Not Mean "Never Modify Code"](#48-ocp-does-not-mean-never-modify-code)
49. [OCP Is a Design Goal](#49-ocp-is-a-design-goal)
50. [Predicting Variation](#50-predicting-variation)
51. [Abstraction Should Follow Variation](#51-abstraction-should-follow-variation)
52. [OCP Refactoring Process](#52-ocp-refactoring-process)
53. [Before and After](#53-before-and-after)
54. [OCP Checklist](#54-ocp-checklist)
55. [Common OCP Smells](#55-common-ocp-smells)
56. [Class Explosion](#56-class-explosion)
57. [Multiple Independent Variation Points](#57-multiple-independent-variation-points)
58. [OCP and SOLID Relationships](#58-ocp-and-solid-relationships)
59. [OCP + LSP](#59-ocp--lsp)
60. [OCP + ISP](#60-ocp--isp)
61. [OCP + DIP](#61-ocp--dip)
62. [OCP + Strategy Pattern](#62-ocp--strategy-pattern)
63. [Practical Examples We Studied](#63-practical-examples-we-studied)
64. [OCP Practice Pattern](#64-ocp-practice-pattern)
65. [Example: Payment](#65-example-payment)
66. [Example: Notification](#66-example-notification)
67. [Example: Discount](#67-example-discount)
68. [Interview Question: What is OCP?](#68-interview-question-what-is-ocp)
69. [Interview Question: Does Every If-Else Violate OCP?](#69-interview-question-does-every-if-else-violate-ocp)
70. [Interview Question: How Do You Identify an OCP Violation?](#70-interview-question-how-do-you-identify-an-ocp-violation)
71. [Interview Question: What Is a Variation Point?](#71-interview-question-what-is-a-variation-point)
72. [Interview Question: How Can OCP Be Implemented?](#72-interview-question-how-can-ocp-be-implemented)
73. [Interview Question: Inheritance or Composition?](#73-interview-question-inheritance-or-composition)
74. [Interview Question: What Is Class Explosion?](#74-interview-question-what-is-class-explosion)
75. [Interview Question: Does OCP Mean We Never Modify Existing Code?](#75-interview-question-does-ocp-mean-we-never-modify-existing-code)
76. [Interview Question: Should We Create Abstractions for Every Possible Future Requirement?](#76-interview-question-should-we-create-abstractions-for-every-possible-future-requirement)
77. [Final OCP Mental Model](#77-final-ocp-mental-model)
78. [OCP Transformation](#78-ocp-transformation)
79. [Final OCP Checklist](#79-final-ocp-checklist)
80. [One-Line Memory Trick](#80-one-line-memory-trick)

---

## 1. SOLID Overview

| Letter | Principle                        | Main Question                                                |
|:------:|-----------------------------------|-----------------------------------------------------------------|
| **S**  | Single Responsibility Principle   | Does this have one reason to change?                            |
| **O**  | Open/Closed Principle             | Can we extend behavior without modifying existing behavior?     |
| **L**  | Liskov Substitution Principle     | Can the subtype safely replace the parent?                      |
| **I**  | Interface Segregation Principle   | Are clients forced to depend on methods they don't need?        |
| **D**  | Dependency Inversion Principle    | Does high-level code depend on abstractions?                    |

---

## 2. OCP Definition

The Open/Closed Principle says:

> A software entity should be open for extension but closed for modification.

There are two important terms.

### Open for Extension

We should be able to add new behavior.

### Closed for Modification

Existing, already-tested behavior should not need to be changed every time a new variation is introduced.

---

## 3. Simple Mental Model

Think:

```text
Existing Code
    │  new requirement
    ▼
Can we add a new implementation?
    │
    ▼
   YES
    │
    ▼
Existing code remains unchanged
```

Instead of:

```text
Existing Code
    │  new requirement
    ▼
Modify existing if/else
    │
    ▼
Modify existing switch
    │
    ▼
Modify existing class
```

---

## 4. Simple Example

Suppose we have:

```java
public class ShippingService {

    public double calculateShipping(String type) {

        if (type.equals("STANDARD")) {
            return 50;
        }

        if (type.equals("EXPRESS")) {
            return 100;
        }

        if (type.equals("INTERNATIONAL")) {
            return 500;
        }

        return 0;
    }
}
```

Now suppose we introduce `SAME_DAY`. We need to modify `ShippingService` and add another condition:

```java
if (type.equals("SAME_DAY")) {
    return 200;
}
```

This means existing code must be modified for every new shipping type. **This is an OCP smell.**

---

## 5. Why This Becomes a Problem

Imagine the application grows.

**Initially:**

```text
STANDARD
EXPRESS
INTERNATIONAL
```

**Later:**

```text
STANDARD
EXPRESS
INTERNATIONAL
SAME_DAY
OVERNIGHT
ECONOMY
PREMIUM
LOCAL
DRONE
```

Our class becomes:

```java
if (...) {
} else if (...) {
} else if (...) {
} else if (...) {
} else if (...) {
} else if (...) {
} else if (...) {
}
// ...
```

Every new type requires modification of existing code. This can lead to:

- Large conditional blocks
- Difficult maintenance
- Increased regression risk
- Harder testing
- Growing complexity
- Violations of OCP

---

## 6. Important Clarification

**Not every `if/else` violates OCP.** This is extremely important.

Example:

```java
if (year % 400 == 0) {
    return true;
}

if (year % 100 == 0) {
    return false;
}

if (year % 4 == 0) {
    return true;
}

return false;
```

This does not automatically violate OCP. The presence of `if/else` is not itself an OCP violation. The important question is:

> Are we repeatedly modifying existing code whenever a new variation/type is introduced?

---

## 7. Conditional Logic as an OCP Smell

A useful smell is:

```text
if type == A   → behavior A
if type == B   → behavior B
if type == C   → behavior C
if type == D   → behavior D
```

Especially when:

- The values represent different types.
- Each type has different behavior.
- New types are frequently added.
- Every new type requires modifying the same class.

In such cases, investigate OCP.

---

## 8. Variation Point

One of the most important OCP concepts is the **Variation Point**.

> A variation point is the part of the system where behavior is expected to vary.

For shipping:

```text
Shipping Type
├── Standard
├── Express
├── International
└── Same Day
```

The variation point is: **shipping behavior**.

---

## 9. Shipping Example

**Bad design:**

```java
public class ShippingService {

    public double calculateShipping(String type) {

        if (type.equals("STANDARD")) {
            return 50;
        }

        if (type.equals("EXPRESS")) {
            return 100;
        }

        if (type.equals("INTERNATIONAL")) {
            return 500;
        }

        return 0;
    }
}
```

The problem is not merely the `if`. The problem is:

> Every new shipping type forces modification of `ShippingService`.

---

## 10. Identify the Abstraction

Ask: *What is common between all shipping types?*

They all calculate shipping. Therefore:

```text
Shipping
└── calculateShipping()
```

We can create an abstraction.

---

## 11. Shipping Interface

```java
public interface Shipping {

    double calculateShipping();
}
```

Now concrete shipping implementations can provide their own behavior.

---

## 12. Standard Shipping

```java
public class StandardShipping implements Shipping {

    @Override
    public double calculateShipping() {
        return 50;
    }
}
```

---

## 13. Express Shipping

```java
public class ExpressShipping implements Shipping {

    @Override
    public double calculateShipping() {
        return 100;
    }
}
```

---

## 14. International Shipping

```java
public class InternationalShipping implements Shipping {

    @Override
    public double calculateShipping() {
        return 500;
    }
}
```

---

## 15. Adding Same-Day Shipping

Now suppose a new requirement arrives: `SameDayShipping`. We create a new class:

```java
public class SameDayShipping implements Shipping {

    @Override
    public double calculateShipping() {
        return 200;
    }
}
```

Notice what we did **NOT** modify:

```text
StandardShipping
ExpressShipping
InternationalShipping
```

This is the power of OCP.

---

## 16. Shipping Architecture

```text
Shipping
├── StandardShipping
├── ExpressShipping
├── InternationalShipping
└── SameDayShipping
```

The abstraction provides the extension point. New implementations can be added without modifying existing implementations.

---

## 17. Client Using Abstraction

Instead of depending on concrete implementations:

```java
public class ShippingService {

    public double calculate(Shipping shipping) {
        return shipping.calculateShipping();
    }
}
```

The service depends on `Shipping`, not `StandardShipping`, `ExpressShipping`, or `InternationalShipping`.

---

## 18. Adding New Shipping Types

Suppose we add:

```java
public class OvernightShipping implements Shipping {

    @Override
    public double calculateShipping() {
        return 300;
    }
}
```

No modification is required in:

```text
StandardShipping
ExpressShipping
InternationalShipping
SameDayShipping
ShippingService
```

We only extend the system.

---

## 19. Core OCP Transformation

**Bad:**

```text
ShippingService
├── if STANDARD
├── if EXPRESS
├── if INTERNATIONAL
└── if SAME_DAY
```

**Better:**

```text
Shipping
├── StandardShipping
├── ExpressShipping
├── InternationalShipping
├── SameDayShipping
└── OvernightShipping
```

---

## 20. Media Player Example

Suppose we have:

```java
public class MediaPlayer {

    public void play(String type) {

        if (type.equals("MP3")) {
            System.out.println("Playing MP3");
        }

        if (type.equals("MP4")) {
            System.out.println("Playing MP4");
        }

        if (type.equals("WAV")) {
            System.out.println("Playing WAV");
        }
    }
}
```

Adding a new format `FLAC` requires modifying `MediaPlayer`. **OCP smell.**

---

## 21. Media Variation Point

Identify what varies:

```text
Media Type
├── MP3
├── MP4
├── WAV
└── FLAC
```

The abstraction can be:

```text
Playable
└── play()
```

---

## 22. Playable Interface

```java
public interface Playable {

    void play();
}
```

---

## 23. MP3 Implementation

```java
public class MP3Media implements Playable {

    @Override
    public void play() {
        System.out.println("Playing MP3");
    }
}
```

---

## 24. MP4 Implementation

```java
public class MP4Media implements Playable {

    @Override
    public void play() {
        System.out.println("Playing MP4");
    }
}
```

---

## 25. Adding FLAC

```java
public class FLACMedia implements Playable {

    @Override
    public void play() {
        System.out.println("Playing FLAC");
    }
}
```

Again: existing implementations remain unchanged.

---

## 26. Bird Example

Bird is useful for understanding OCP as well.

Suppose we have:

```java
public class BirdService {

    public void move(String birdType) {

        if (birdType.equals("SPARROW")) {
            System.out.println("Sparrow flies");
        }

        if (birdType.equals("EAGLE")) {
            System.out.println("Eagle flies");
        }

        if (birdType.equals("PENGUIN")) {
            System.out.println("Penguin swims");
        }
    }
}
```

Now imagine adding `OSTRICH`, `EMU`, `KIWI`, `FLAMINGO`. We repeatedly modify `BirdService`. That is a potential OCP violation.

---

## 27. Bird Variation Point

The variation is:

```text
Bird movement
├── Flying
├── Swimming
├── Walking
└── Running
```

Instead of assuming every bird has the same movement behavior, we can model the behavior that varies:

```java
public interface Movement {

    void move();
}
```

Then:

```java
public class FlyingMovement implements Movement {

    @Override
    public void move() {
        System.out.println("Flying");
    }
}
```

And:

```java
public class SwimmingMovement implements Movement {

    @Override
    public void move() {
        System.out.println("Swimming");
    }
}
```

---

## 28. OCP and Bird: Important Connection

The Bird example teaches an important lesson:

> Don't force every variation into one large conditional structure.

Instead, identify the behavior that varies and create an extension point.

```text
Bird
└── Movement
    ├── FlyingMovement
    ├── SwimmingMovement
    └── WalkingMovement
```

This is often cleaner than:

```java
if (birdType == SPARROW) { }
if (birdType == PENGUIN) { }
if (birdType == OSTRICH) { }
// ...
```

---

## 29. Cloud Storage Example

Suppose:

```java
public class CloudStorageService {

    public void upload(String provider) {

        if (provider.equals("AWS")) {
            System.out.println("Uploading to AWS");
        }

        if (provider.equals("AZURE")) {
            System.out.println("Uploading to Azure");
        }

        if (provider.equals("GCP")) {
            System.out.println("Uploading to GCP");
        }
    }
}
```

Adding another cloud provider requires modifying the service. **Potential OCP violation.**

---

## 30. Storage Variation Point

The variation is:

```text
Storage Provider
├── AWS
├── Azure
├── GCP
└── New Provider
```

Create an abstraction:

```java
public interface StorageProvider {

    void upload();
}
```

Then:

```java
public class AWSStorage implements StorageProvider {

    @Override
    public void upload() {
        System.out.println("Uploading to AWS");
    }
}
```

```java
public class AzureStorage implements StorageProvider {

    @Override
    public void upload() {
        System.out.println("Uploading to Azure");
    }
}
```

```java
public class GCPStorage implements StorageProvider {

    @Override
    public void upload() {
        System.out.println("Uploading to GCP");
    }
}
```

---

## 31. OCP with Multiple Variation Points

Cloud storage introduced an important concept.

Suppose we have two independent variations:

```text
CloudStorage
├── Storage Provider
│   ├── AWS
│   ├── Azure
│   └── GCP
│
└── Encryption
    ├── AES
    ├── RSA
    └── None
```

There are two independent variation points:

1. Storage provider
2. Encryption strategy

---

## 32. Class Explosion Problem

A naive inheritance approach might produce:

```text
AWS + AES
AWS + RSA
AWS + None

Azure + AES
Azure + RSA
Azure + None

GCP + AES
GCP + RSA
GCP + None
```

Which could become:

```text
AWSAES
AWSRSA
AWSNoEncryption

AzureAES
AzureRSA
AzureNoEncryption

GCPAES
GCPRSA
GCPNoEncryption
```

This creates a **class explosion**.

---

## 33. Composition Solves the Problem

Instead of creating a class for every combination, use composition.

```text
CloudStorageService
├── StorageProvider
│   ├── AWS
│   ├── Azure
│   └── GCP
│
└── Encryption
    ├── AES
    ├── RSA
    └── None
```

Now the combinations are created dynamically.

---

## 34. StorageProvider

```java
public interface StorageProvider {

    void upload();
}
```

---

## 35. Encryption

```java
public interface Encryption {

    void encrypt();
}
```

---

## 36. CloudStorageService

```java
public class CloudStorageService {

    private final StorageProvider storageProvider;
    private final Encryption encryption;

    public CloudStorageService(
            StorageProvider storageProvider,
            Encryption encryption) {

        this.storageProvider = storageProvider;
        this.encryption = encryption;
    }

    public void upload() {
        encryption.encrypt();
        storageProvider.upload();
    }
}
```

The service is now composed from independent abstractions.

---

## 37. Why Composition Helps OCP

Suppose we add `GCPStorage` — we create a new implementation.
Suppose we add `RSAEncryption` — we create another implementation.

We do not need `GCPRSA`, because composition allows:

```java
new CloudStorageService(
        new GCPStorage(),
        new RSAEncryption());
```

This avoids class explosion.

---

## 38. OCP Through Inheritance

One way to achieve OCP is inheritance.

```java
abstract class Payment {

    abstract void process();
}
```

Then:

```java
class CreditCardPayment extends Payment {

    @Override
    void process() { }
}
```

```java
class UPIPayment extends Payment {

    @Override
    void process() { }
}
```

New payment type:

```java
class WalletPayment extends Payment {

    @Override
    void process() { }
}
```

Existing implementations remain unchanged.

---

## 39. OCP Through Interfaces

Interfaces are another common extension mechanism.

```java
public interface Notification {

    void send();
}
```

Implementations: `EmailNotification`, `SMSNotification`, `PushNotification`.

Adding `WhatsAppNotification` does not require changing the existing implementations.

---

## 40. OCP Through Composition

Composition is often preferable when multiple independent variation points exist.

```text
CloudStorageService
├── StorageProvider
└── Encryption
```

This gives us flexibility without creating combinations of subclasses.

---

## 41. Inheritance vs Composition

**Inheritance:**

```text
CloudStorage
├── AWSAES
├── AWSRSA
├── AzureAES
├── AzureRSA
├── GCPAES
└── GCPRSA
```

**Composition:**

```text
CloudStorageService
├── StorageProvider
└── Encryption
```

Composition scales better when dimensions of variation are independent.

---

## 42. Enum-Based Conditional Logic

Consider:

```java
enum PaymentType {
    CARD,
    UPI,
    WALLET
}
```

And:

```java
public void process(PaymentType type) {

    if (type == PaymentType.CARD) {
        // ...
    }

    if (type == PaymentType.UPI) {
        // ...
    }

    if (type == PaymentType.WALLET) {
        // ...
    }
}
```

This is not automatically an OCP violation. But if every newly introduced payment type requires modifying this method, it is a strong OCP smell.

---

## 43. Not Every Enum Requires OCP

Example:

```java
enum Status {
    ACTIVE,
    INACTIVE
}
```

And:

```java
if (status == Status.ACTIVE) {
    System.out.println("Active");
} else {
    System.out.println("Inactive");
}
```

There may be no reason to introduce polymorphism here. **OCP should not be applied mechanically.**

---

## 44. When to Suspect OCP

A strong OCP smell is:

```text
New Type
   │
   ▼
Modify Existing Conditional
   │
   ▼
Test Existing Code Again
```

Examples:

- New payment type
- New shipping type
- New media type
- New notification type
- New storage provider
- New file format
- New discount strategy
- New tax strategy

When these are frequently added, abstraction may be appropriate.

---

## 45. OCP and Strategy Pattern

The Strategy Pattern is frequently used to implement OCP.

```text
PaymentStrategy
├── CreditCardStrategy
├── UPIStrategy
└── WalletStrategy
```

**Client:**

```text
PaymentService ──► PaymentStrategy
```

New strategy: `CryptoPaymentStrategy` — add a new class rather than modifying the existing strategy implementations.

---

## 46. OCP and Factory Pattern

Factory can help create the correct implementation.

```text
ShippingFactory
├── StandardShipping
├── ExpressShipping
└── InternationalShipping
```

However, the factory itself may still require modification when a new type is added. Therefore:

> Using a Factory does not automatically guarantee OCP.

The design must be considered as a whole.

---

## 47. OCP and Dependency Injection

Dependency Injection makes it easy to provide different implementations.

```java
public class ShippingService {

    private final Shipping shipping;

    public ShippingService(Shipping shipping) {
        this.shipping = shipping;
    }
}
```

Client:

```java
ShippingService service = new ShippingService(new ExpressShipping());
```

Another client:

```java
ShippingService service = new ShippingService(new StandardShipping());
```

The service works with the abstraction.

---

## 48. OCP Does Not Mean "Never Modify Code"

This is another important clarification.

The phrase *closed for modification* does **NOT** mean *never modify any code under any circumstances*.

Requirements change. Bugs need fixing. Existing business rules may need modification.

OCP means:

> New variations should preferably be introduced through extension rather than requiring modifications to stable existing behavior.

---

## 49. OCP Is a Design Goal

OCP is not a magical rule where every class must be 100% immutable. Real systems evolve.

The goal is to identify areas where change is expected and design extension points around those areas.

---

## 50. Predicting Variation

We should not create abstractions for every hypothetical future requirement.

**Bad approach:**

```text
Maybe someday we will support:
AWS, Azure, GCP, Oracle Cloud, IBM Cloud, DigitalOcean, ...
```

Creating interfaces everywhere can make the system unnecessarily complex. Instead:

> Identify variation based on actual or reasonably expected requirements.

---

## 51. Abstraction Should Follow Variation

**Good approach:**

```text
Identify what changes
        │
        ▼
Identify variation point
        │
        ▼
Create abstraction
        │
        ▼
Create implementations
```

Example:

```text
Shipping Type
        │
        ▼
Shipping abstraction
├── Standard
├── Express
└── International
```

---

## 52. OCP Refactoring Process

When you find conditional logic:

| Step | Action |
|:----:|--------|
| 1 | Identify the condition, e.g. `if (type == STANDARD)`, `if (type == EXPRESS)`, `if (type == INTERNATIONAL)`. |
| 2 | Ask: *Does `type` represent different behaviors?* If yes, investigate OCP. |
| 3 | Identify the variation point, e.g. `Shipping Type`. |
| 4 | Create an abstraction, e.g. `Shipping`. |
| 5 | Move each behavior into its own implementation: `StandardShipping`, `ExpressShipping`, `InternationalShipping`. |
| 6 | Make the client depend on the abstraction. |
| 7 | Verify that adding a new implementation does not require modifying existing behavior. |

---

## 53. Before and After

### Before

```text
ShippingService
├── if STANDARD
├── if EXPRESS
└── if INTERNATIONAL
```

Adding `SAME_DAY` → **modify `ShippingService`**.

### After

```text
Shipping
├── StandardShipping
├── ExpressShipping
└── InternationalShipping
```

Adding `SAME_DAY` → **add `SameDayShipping`**. Existing classes remain unchanged.

---

## 54. OCP Checklist

When reviewing code, ask:

- Is there a frequently changing variation?
- Does a new type require modifying existing code?
- Is there a large `if/else` or `switch` based on type?
- Is an enum controlling different behaviors?
- Can the varying behavior be represented by an abstraction?
- Can each variation become an implementation?
- Can composition remove combinations of subclasses?
- Can the client depend on an abstraction?
- Will adding a new implementation leave existing implementations untouched?

---

## 55. Common OCP Smells

Potential smells:

- Large `if/else` blocks based on type
- Large `switch` statements based on enum
- Repeated modification of the same class
- Multiple type-specific behaviors in one class
- Adding a new type requires editing many files
- Many subclasses representing combinations of features
- Conditional logic scattered throughout the application

These are signals to investigate, not automatic violations.

---

## 56. Class Explosion

One major problem that OCP-aware design can help avoid is class explosion.

Suppose we have:

```text
3 storage providers
3 encryption strategies
4 compression strategies
```

A naive inheritance approach may require:

```text
3 × 3 × 4 = 36 combinations
```

With composition:

```text
CloudStorageService
├── StorageProvider
├── Encryption
└── Compression
```

We can combine implementations dynamically.

---

## 57. Multiple Independent Variation Points

This is an important design concept.

Suppose:

```text
CloudStorageService
├── Storage Provider
└── Encryption
```

These are independent. Do **NOT** necessarily create:

```text
AWSAES, AWSRSA, AzureAES, AzureRSA, GCPAES, GCPRSA
```

Instead:

```text
StorageProvider
├── AWS
├── Azure
└── GCP

Encryption
├── AES
├── RSA
└── None
```

Then compose them.

---

## 58. OCP and SOLID Relationships

### OCP + SRP

SRP helps create focused classes. OCP helps make those classes easier to extend.

```text
Shipping
└── shipping behavior
```

Then: `StandardShipping`, `ExpressShipping`, `InternationalShipping`.

SRP helps establish the boundary. OCP helps extend the boundary.

---

## 59. OCP + LSP

OCP commonly uses polymorphism. Polymorphism requires substitutable implementations.

```text
Shipping
├── StandardShipping
└── ExpressShipping
```

If implementations cannot safely behave as `Shipping`, LSP can be violated. Therefore, OCP and LSP often work together.

---

## 60. OCP + ISP

Interfaces provide extension points. But large interfaces can force implementations to implement methods they don't need. ISP helps keep extension interfaces focused.

---

## 61. OCP + DIP

DIP encourages high-level modules to depend on abstractions. OCP often uses those abstractions as extension points.

```text
ShippingService
      │
      ▼
   Shipping
├── StandardShipping
└── ExpressShipping
```

`ShippingService` depends on the abstraction. New implementations can be introduced without modifying it.

---

## 62. OCP + Strategy Pattern

```text
Context
   │
   ▼
Strategy
├── StrategyA
├── StrategyB
└── StrategyC
```

This is one of the most common practical implementations of OCP.

---

## 63. Practical Examples We Studied

We applied OCP thinking to:

- Shipping
- Media Player
- Bird
- Cloud Storage
- Storage providers
- Encryption strategies
- Multiple independent variation points

The recurring pattern was:

```text
Variation
    │
    ▼
Abstraction
├── Implementation A
├── Implementation B
└── Implementation C
    │
    ▼
New implementation
    │
    ▼
Existing code remains unchanged
```

---

## 64. OCP Practice Pattern

For every OCP problem, ask:

1. What changes?
2. Is there a variation point?
3. Is the existing code modified whenever that variation changes?
4. Can we introduce an abstraction?
5. Can each variation implement that abstraction?
6. Should we use inheritance or composition?
7. Are there multiple independent variation points?
8. Could inheritance create class explosion?

---

## 65. Example: Payment

**Bad:**

```java
public void processPayment(String type) {

    if (type.equals("CARD")) {
        // card payment
    }

    if (type.equals("UPI")) {
        // UPI payment
    }

    if (type.equals("WALLET")) {
        // wallet payment
    }
}
```

**Better:**

```java
public interface Payment {

    void process();
}
```

Implementations: `CardPayment`, `UPIPayment`, `WalletPayment`.

New payment: `CryptoPayment` — no modification to existing payment implementations is required.

---

## 66. Example: Notification

**Bad:**

```java
public void send(String type) {

    if (type.equals("EMAIL")) {
        // email
    }

    if (type.equals("SMS")) {
        // SMS
    }

    if (type.equals("PUSH")) {
        // push
    }
}
```

**Better:**

```java
public interface Notification {

    void send();
}
```

Implementations: `EmailNotification`, `SMSNotification`, `PushNotification`.

New: `WhatsAppNotification`.

---

## 67. Example: Discount

**Bad:**

```java
public double calculateDiscount(String customerType) {

    if (customerType.equals("REGULAR")) {
        return 0;
    }

    if (customerType.equals("PREMIUM")) {
        return 20;
    }

    if (customerType.equals("VIP")) {
        return 30;
    }

    return 0;
}
```

**Better:**

```java
public interface DiscountStrategy {

    double calculateDiscount();
}
```

Implementations: `RegularDiscount`, `PremiumDiscount`, `VIPDiscount`.

New: `EmployeeDiscount` — existing implementations remain unchanged.

---

## 68. Interview Question: What is OCP?

> The Open/Closed Principle states that software entities should be open for extension but closed for modification. We should be able to introduce new behavior by adding new implementations or extensions rather than repeatedly modifying stable existing code.

---

## 69. Interview Question: Does Every If-Else Violate OCP?

> No. `if/else` itself is not an OCP violation. It becomes a potential OCP smell when the conditional represents a variation in behavior and every new type requires modifying the existing code.

---

## 70. Interview Question: How Do You Identify an OCP Violation?

Look for:

- Type-based conditionals
- Enum-based behavior
- Large switch statements
- Repeated modification for new types
- Frequently changing behavior inside stable classes

Then ask: *Can the varying behavior be represented as an abstraction with separate implementations?*

---

## 71. Interview Question: What Is a Variation Point?

A variation point is a part of the system where behavior is expected to vary. Examples:

```text
Shipping Type
Payment Type
Media Type
Storage Provider
Encryption Algorithm
Notification Channel
Discount Strategy
```

---

## 72. Interview Question: How Can OCP Be Implemented?

Common techniques:

- Interfaces
- Abstract classes
- Inheritance
- Polymorphism
- Composition
- Strategy Pattern
- Dependency Injection

---

## 73. Interview Question: Inheritance or Composition?

**Use inheritance when:**

- There is a clear "is-a" relationship.
- Subtypes genuinely represent the abstraction.
- The variation is naturally modeled through subtype polymorphism.

**Use composition when:**

- There are multiple independent variation points.
- You want to combine behaviors dynamically.
- Inheritance would create many combinations.
- You want flexibility without class explosion.

---

## 74. Interview Question: What Is Class Explosion?

Class explosion happens when combinations of independent behaviors are modeled as separate subclasses.

```text
AWSAES, AWSRSA, AzureAES, AzureRSA, GCPAES, GCPRSA
```

Instead, use `StorageProvider + Encryption` through composition.

---

## 75. Interview Question: Does OCP Mean We Never Modify Existing Code?

No. OCP is a design goal. Bug fixes and changes to existing business rules may still require modification. The principle mainly addresses adding new variations or behaviors.

---

## 76. Interview Question: Should We Create Abstractions for Every Possible Future Requirement?

No. Over-engineering can be worse than under-engineering. Create abstractions around:

- Actual variation
- Known requirements
- Reasonably expected variation
- Meaningful extension points

Do not create interfaces everywhere simply because something might change someday.

---

## 77. Final OCP Mental Model

```text
              OCP
        ┌──────┴──────┐
        ▼             ▼
     Extend         Avoid
        │          modification
        ▼             │
New implementation  Existing behavior
        │             │
        └──────┬──────┘
               ▼
        Stable design
```

---

## 78. OCP Transformation

The most important transformation to remember:

**BAD**

```text
if TYPE_A → behavior A
if TYPE_B → behavior B
if TYPE_C → behavior C

New TYPE_D
    │
    ▼
Modify existing code
```

**GOOD**

```text
Abstraction
├── Type A implementation
├── Type B implementation
└── Type C implementation

New Type D
    │
    ▼
Add new implementation
```

---

## 79. Final OCP Checklist

Before considering an OCP design complete:

- [ ] Identify the variation point.
- [ ] Identify what behavior varies.
- [ ] Identify whether new variations require modifying existing code.
- [ ] Create an appropriate abstraction.
- [ ] Move each variation into its own implementation.
- [ ] Make the client depend on the abstraction.
- [ ] Verify existing implementations remain unchanged.
- [ ] Check whether composition is better than inheritance.
- [ ] Check for class explosion.
- [ ] Do not blindly replace every `if/else`.
- [ ] Do not create unnecessary abstractions.

---

## 80. One-Line Memory Trick

> **OCP = Add new behavior by extending the system instead of repeatedly modifying stable existing behavior.**

Or simply:

> **Open for extension, closed for modification.**

The practical question to remember is:

> **"If tomorrow a new type/behavior is added, how much existing code do I need to modify?"**

If the answer is *"I need to keep adding conditions to existing code"* — investigate OCP.

If the answer is *"I can create a new implementation of an existing abstraction"* — you are moving toward an OCP-friendly design.
