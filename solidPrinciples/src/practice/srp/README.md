# Single Responsibility Principle (SRP)

SRP is the **S** in SOLID.

> **A class should have one reason to change.**

This does **not** mean:

> ~~A class should have only one method.~~

It means that the responsibilities inside a class should belong to the same cohesive reason for change.

---

## Table of Contents

1. [SOLID Overview](#1-solid-overview)
2. [SRP Definition](#2-srp-definition)
3. [What Does "Reason to Change" Mean?](#3-what-does-reason-to-change-mean)
4. [SRP Is About Responsibility Boundaries](#4-srp-is-about-responsibility-boundaries)
5. [Cohesion](#5-cohesion)
6. [Low Cohesion](#6-low-cohesion)
7. [Cohesion and SRP](#7-cohesion-and-srp)
8. [Cohesion Does NOT Mean One Method](#8-cohesion-does-not-mean-one-method)
9. [Different Responsibilities Should Be Separated](#9-different-responsibilities-should-be-separated)
10. [Business Responsibility vs Technical Responsibility](#10-business-responsibility-vs-technical-responsibility)
11. [Bird Example](#11-bird-example)
12. [Refactored Bird Design](#12-refactored-bird-design)
13. [Important Bird Insight](#13-important-bird-insight)
14. [Employee Example](#14-employee-example)
15. [Refactored Employee](#15-refactored-employee)
16. [Printer Example](#16-printer-example)
17. [Important Printer Lesson](#17-important-printer-lesson)
18. [Payment Example](#18-payment-example)
19. [Media Player Example](#19-media-player-example)
20. [Cloud Storage Example](#20-cloud-storage-example)
21. [Order Example](#21-order-example)
22. [The "Axes of Change" Idea](#22-the-axes-of-change-idea)
23. [What Does "Change Together" Mean?](#23-what-does-change-together-mean)
24. [Independent Change](#24-independent-change)
25. [SRP Does Not Mean "One Reason in the Universe"](#25-srp-does-not-mean-one-reason-in-the-universe)
26. [A Class Can Have Many Methods](#26-a-class-can-have-many-methods)
27. [A Class Can Have Only One Method and Still Violate SRP](#27-a-class-can-have-only-one-method-and-still-violate-srp)
28. [One Method Can Also Contain Multiple Responsibilities](#28-one-method-can-also-contain-multiple-responsibilities)
29. [SRP and Service Classes](#29-srp-and-service-classes)
30. [SRP and Technical Responsibilities](#30-srp-and-technical-responsibilities)
31. [SRP Refactoring Strategy](#31-srp-refactoring-strategy)
32. [SRP Refactoring Example](#32-srp-refactoring-example)
33. [How to Detect SRP Violations](#33-how-to-detect-srp-violations)
34. [SRP Smells](#34-srp-smells)
35. [SRP and "God Classes"](#35-srp-and-god-classes)
36. [SRP Is Context Dependent](#36-srp-is-context-dependent)
37. [SRP vs Cohesion](#37-srp-vs-cohesion)
38. [SRP vs Coupling](#38-srp-vs-coupling)
39. [SRP vs OCP](#39-srp-vs-ocp)
40. [SRP vs LSP](#40-srp-vs-lsp)
41. [SRP vs ISP](#41-srp-vs-isp)
42. [SRP vs DIP](#42-srp-vs-dip)
43. [Real-World Example](#43-real-world-example)
44. [Refactoring Rule of Thumb](#44-refactoring-rule-of-thumb)
45. [SRP Practical Checklist](#45-srp-practical-checklist)
46. [Quick SRP Decision Tree](#46-quick-srp-decision-tree)
47. [SRP Mental Model](#47-srp-mental-model)
48. [The Bird Mental Model](#48-the-bird-mental-model)
49. [Important Lessons Learned](#49-important-lessons-learned)
50. [Interview Questions](#50-interview-questions)
51. [Practice Problems We Covered](#51-practice-problems-we-covered)
52. [Example Final Architecture](#52-example-final-architecture)
53. [Final SRP Formula](#53-final-srp-formula)
54. [Final SRP Rule](#54-final-srp-rule)
55. [One-Line Memory Trick](#55-one-line-memory-trick)
56. [Final Example](#56-final-example)

---

## 1. SOLID Overview

SOLID consists of five principles:

| Letter | Principle                       | Main Question                                                                      |
|:------:|----------------------------------|-------------------------------------------------------------------------------------|
| **S**  | Single Responsibility Principle | Does this have one reason to change?                                                |
| **O**  | Open/Closed Principle            | Can we extend without modifying existing code?                                      |
| **L**  | Liskov Substitution Principle    | Can the subtype safely replace the parent?                                          |
| **I**  | Interface Segregation Principle  | Are clients forced to depend on things they don't need?                             |
| **D**  | Dependency Inversion Principle   | Does high-level code depend on abstractions rather than concrete implementations?   |

---

## 2. SRP Definition

The most important definition to remember:

> A class should have one reason to change.

The key phrase is:

- ✅ **"Reason to change"**

Not:

- ❌ One method
- ❌ One line of code
- ❌ One responsibility in an overly narrow sense

---

## 3. What Does "Reason to Change" Mean?

Suppose we have:

```java
public class Employee {

    public void calculateSalary() {
        System.out.println("Calculating salary");
    }

    public void saveToDatabase() {
        System.out.println("Saving employee");
    }

    public void sendEmail() {
        System.out.println("Sending email");
    }
}
```

There are multiple independent reasons for this class to change:

```text
Employee
├── Salary calculation
├── Database persistence
└── Email communication
```

Potential changes:

- Salary calculation requirement changes.
- Database implementation changes.
- Email provider changes.

**Therefore, this class has multiple reasons to change — this is an SRP violation.**

---

## 4. SRP Is About Responsibility Boundaries

Think of a class as owning a particular responsibility.

**Good:**

```text
Employee
└── Employee-related business behavior
```

**Bad:**

```text
Employee
├── Employee business behavior
├── Database persistence
├── Report generation
└── Email communication
```

The second class has multiple independent responsibilities.

---

## 5. Cohesion

Cohesion is one of the most important concepts for understanding SRP.

> Cohesion measures how closely related the responsibilities inside a module/class are.

**High cohesion:**

```text
EmployeeCompensation
├── calculateSalary()
├── calculateBonus()
└── calculateTax()
```

All methods are related to employee compensation. Therefore, the class is highly cohesive.

---

## 6. Low Cohesion

Consider:

```java
public class Employee {

    public void calculateSalary() { }

    public void saveToDatabase() { }

    public void sendEmail() { }

    public void generateReport() { }
}
```

We can identify:

```text
Employee
├── Salary
├── Persistence
├── Communication
└── Reporting
```

These responsibilities are not strongly related. **Therefore, the class has low cohesion.**

---

## 7. Cohesion and SRP

SRP and cohesion are strongly related.

A good SRP design generally tries to create classes that are:

- Highly cohesive
- Focused
- Related to one reason to change

Example:

```text
EmployeeCompensation
├── calculateSalary()
├── calculateBonus()
└── calculateTax()
```

The methods belong together. Therefore:

```text
High cohesion + One reason to change = Good SRP candidate
```

---

## 8. Cohesion Does NOT Mean One Method

This is extremely important.

**Bad interpretation:**

> One class must contain only one method.

That would result in:

```text
SalaryCalculator
└── calculateSalary()

BonusCalculator
└── calculateBonus()

TaxCalculator
└── calculateTax()
```

This may be unnecessarily fragmented. Instead:

```text
EmployeeCompensation
├── calculateSalary()
├── calculateBonus()
└── calculateTax()
```

These methods are related. Therefore, keeping them together can be a highly cohesive design.

---

## 9. Different Responsibilities Should Be Separated

Consider:

```text
Employee
├── calculateSalary()
├── calculateBonus()
├── calculateTax()
├── saveToDatabase()
├── generateReport()
└── sendEmail()
```

A better design:

```text
Employee
└── employee business behavior

EmployeeCompensation
├── salary
├── bonus
└── tax

EmployeeRepository
└── database persistence

PayslipGenerator
└── payslip generation

EmployeeNotificationService
└── email communication
```

Now each class has a clearer reason to change.

---

## 10. Business Responsibility vs Technical Responsibility

This distinction is very useful when identifying SRP violations.

### Business Responsibility

Business responsibility represents what the system actually needs to accomplish.

For example, for an `Employee`:

```text
calculateSalary()
calculateBonus()
calculateTax()
```

For a `Bird`:

```text
eat()
sleep()
fly()
```

These represent business/domain behavior.

### Technical Responsibility

Technical responsibilities are mechanisms used to support the business behavior. Examples:

```text
saveToDatabase()
sendEmail()
generateReport()
writeToFile()
callExternalAPI()
```

These often have different reasons to change.

---

## 11. Bird Example

**Bad design:**

```java
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

    public void saveToDatabase() {
        System.out.println("Saving bird");
    }

    public void generateReport() {
        System.out.println("Generating report");
    }

    public void sendNotification() {
        System.out.println("Sending notification");
    }
}
```

Responsibilities:

```text
Bird
├── eat()               ┐
├── sleep()              ├─ Bird business behavior
├── fly()                ┘
├── saveToDatabase()    ── Persistence
├── generateReport()    ── Reporting
└── sendNotification()  ── Communication
```

The bird behavior is cohesive. The technical responsibilities are not.

---

## 12. Refactored Bird Design

**Bird:**

```java
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

**Repository:**

```java
public class BirdRepository {

    public void save(Bird bird) {
        System.out.println("Saving bird");
    }
}
```

**Report generator:**

```java
public class BirdReportGenerator {

    public void generateReport(Bird bird) {
        System.out.println("Generating report");
    }
}
```

**Notification service:**

```java
public class BirdNotificationService {

    public void sendNotification(Bird bird) {
        System.out.println("Sending notification");
    }
}
```

Diagram:

```text
Bird
├── eat()
├── sleep()
└── fly()

BirdRepository
└── save()

BirdReportGenerator
└── generateReport()

BirdNotificationService
└── sendNotification()
```

---

## 13. Important Bird Insight

Consider:

```java
public class Bird {

    public void eat() { }

    public void sleep() { }

    public void fly() { }
}
```

This does **NOT** violate SRP simply because there are multiple methods. All three methods represent bird behavior — they are highly cohesive.

> **Multiple related methods can belong to the same responsibility.**

---

## 14. Employee Example

**Bad design:**

```java
public class Employee {

    public void calculateSalary() {
        System.out.println("Calculating salary");
    }

    public void calculateBonus() {
        System.out.println("Calculating bonus");
    }

    public void calculateTax() {
        System.out.println("Calculating tax");
    }

    public void saveToDatabase() {
        System.out.println("Saving employee");
    }

    public void generatePayslip() {
        System.out.println("Generating payslip");
    }

    public void sendEmail() {
        System.out.println("Sending email");
    }
}
```

We can group the responsibilities:

```text
Employee
├── salary/compensation
├── persistence
├── payslip/report
└── communication
```

---

## 15. Refactored Employee

**Employee:**

```java
public class Employee {

    public void calculateSalary() {
        System.out.println("Calculating salary");
    }
}
```

**Compensation:**

```java
public class EmployeeCompensation {

    public void calculateBonus(Employee employee) {
        System.out.println("Calculating bonus");
    }

    public void calculateTax(Employee employee) {
        System.out.println("Calculating tax");
    }
}
```

**Repository:**

```java
public class EmployeeRepository {

    public void saveToDatabase(Employee employee) {
        System.out.println("Saving employee");
    }
}
```

**Payslip:**

```java
public class PayslipGenerator {

    public void generatePayslip(Employee employee) {
        System.out.println("Generating payslip");
    }
}
```

**Notification:**

```java
public class EmployeeNotificationService {

    public void sendEmail(Employee employee) {
        System.out.println("Sending email");
    }
}
```

---

## 16. Printer Example

Consider:

```java
public class Printer {

    public void printDocument() {
        System.out.println("Document printed");
    }

    public void calculateInkUsage() {
        System.out.println("Ink usage calculated");
    }

    public void savePrintHistory() {
        System.out.println("Print history saved");
    }

    public void sendLowInkNotification() {
        System.out.println("Low ink notification sent");
    }
}
```

Grouping:

```text
Printer
├── printDocument()
└── calculateInkUsage()

PrinterRepository
└── savePrintHistory()

PrinterNotification
└── sendLowInkNotification()
```

`printDocument()` and `calculateInkUsage()` can reasonably remain together because both relate to printer operation. Persistence and notification are separate technical responsibilities.

---

## 17. Important Printer Lesson

SRP does **NOT** mean:

```text
Printer
└── print()

PrinterInkCalculator
└── calculateInkUsage()
```

This might be unnecessarily fragmented.

If calculating ink usage is strongly related to printer operation in the domain/context, keeping it with `Printer` may be appropriate.

> SRP is about meaningful responsibility boundaries.

---

## 18. Payment Example

**Bad design:**

```java
public class PaymentService {

    public void processPayment() {
        System.out.println("Processing payment");
    }

    public void calculateTax() {
        System.out.println("Calculating tax");
    }

    public void applyDiscount() {
        System.out.println("Applying discount");
    }

    public void generateReceipt() {
        System.out.println("Generating receipt");
    }

    public void saveTransaction() {
        System.out.println("Saving transaction");
    }

    public void sendConfirmation() {
        System.out.println("Sending confirmation");
    }
}
```

Possible grouping:

```text
Payment
├── processPayment()
├── calculateTax()
└── applyDiscount()

ReceiptGenerator
└── generateReceipt()

PaymentRepository
└── saveTransaction()

PaymentNotificationService
└── sendConfirmation()
```

The exact grouping depends on the domain. For example, tax and discount may belong to payment calculation if they are part of the payment calculation domain.

---

## 19. Media Player Example

**Bad design:**

```java
public class MediaPlayer {

    public void play() { }

    public void pause() { }

    public void stop() { }

    public void loadFile() { }

    public void savePlaybackHistory() { }

    public void generatePlaylist() { }

    public void sendNotification() { }
}
```

Possible grouping:

```text
MediaPlayer
├── play()
├── pause()
├── stop()
└── loadFile()

PlaybackHistoryRepository
└── savePlaybackHistory()

PlaylistService
└── generatePlaylist()

MediaNotificationService
└── sendNotification()
```

Again, the exact boundary depends on what `loadFile()` actually does. If loading involves filesystem, networking, and storage concerns, it may need further decomposition.

---

## 20. Cloud Storage Example

**Bad design:**

```java
public class CloudStorageService {

    public void uploadFile() { }

    public void downloadFile() { }

    public void deleteFile() { }

    public void encrypt() { }

    public void saveMetadataToDatabase() { }

    public void sendUploadNotification() { }

    public void generateReport() { }
}
```

Possible grouping:

```text
CloudStorageService
├── uploadFile()
├── downloadFile()
└── deleteFile()

EncryptionService
└── encrypt()

MetadataRepository
└── saveMetadataToDatabase()

StorageNotificationService
└── sendUploadNotification()

StorageReportGenerator
└── generateReport()
```

---

## 21. Order Example

**Bad design:**

```java
public class OrderService {

    void createOrder() { }

    void calculateTotal() { }

    void applyDiscount() { }

    void saveOrder() { }

    void generateInvoice() { }

    void sendConfirmationEmail() { }
}
```

Possible grouping:

```text
Order
├── createOrder()
├── calculateTotal()
└── applyDiscount()

OrderRepository
└── saveOrder()

InvoiceGenerator
└── generateInvoice()

OrderNotificationService
└── sendConfirmationEmail()
```

---

## 22. The "Axes of Change" Idea

One of the most useful ways to identify SRP violations is to look for different **axes of change**.

Consider:

```java
public class Employee {

    void calculateSalary() { }

    void saveToDatabase() { }

    void sendEmail() { }
}
```

There are three axes:

```text
Employee
├── Compensation changes
├── Database changes
└── Communication changes
```

If these requirements change independently, the class has multiple reasons to change. Therefore, SRP is likely violated.

---

## 23. What Does "Change Together" Mean?

If multiple methods are likely to change because of the same requirement, they may belong together.

Example:

```text
EmployeeCompensation
├── calculateSalary()
├── calculateBonus()
└── calculateTax()
```

Suppose the company changes its compensation rules. All three methods may need modification — they share the same reason to change. Therefore, grouping them is reasonable.

---

## 24. Independent Change

Suppose:

```text
calculateSalary()
saveToDatabase()
sendEmail()
```

Now:

- Salary calculation changes.
- Database technology changes.
- Email provider changes.

These changes are independent — they belong to different axes of change. Therefore, separating them improves the design.

---

## 25. SRP Does Not Mean "One Reason in the Universe"

This is a common misunderstanding.

Consider:

```text
EmployeeCompensation
├── calculateSalary()
├── calculateBonus()
└── calculateTax()
```

There are technically three methods and potentially different requirements. But they all belong to the same broader responsibility:

> Employee compensation.

So SRP is about finding meaningful responsibility boundaries, not artificially reducing everything to one tiny unit.

---

## 26. A Class Can Have Many Methods

This is completely valid:

```java
public class EmployeeCompensation {

    public void calculateSalary() { }

    public void calculateBonus() { }

    public void calculateTax() { }

    public void calculateOvertime() { }

    public void calculateDeduction() { }
}
```

All these methods are related to compensation. The class is cohesive. Therefore, having five methods does not violate SRP.

---

## 27. A Class Can Have Only One Method and Still Violate SRP

Consider:

```java
public class EmployeeService {

    public void processEmployee() {
        calculateSalary();
        saveToDatabase();
        sendEmail();
    }

    private void calculateSalary() { }

    private void saveToDatabase() { }

    private void sendEmail() { }
}
```

Even if there is only one public method, the class still contains multiple responsibilities.

> **Method count is not how we determine SRP.**

---

## 28. One Method Can Also Contain Multiple Responsibilities

Example:

```java
public void processEmployee() {
    calculateSalary();
    saveToDatabase();
    sendEmail();
}
```

The method itself coordinates multiple concerns. However, the main SRP discussion is about responsibility boundaries of modules/classes. The method can often delegate to focused components:

```java
public void processEmployee() {
    compensation.calculateSalary();
    repository.save(employee);
    notificationService.sendEmail(employee);
}
```

This creates better separation.

---

## 29. SRP and Service Classes

A class named `SomethingService` does not automatically follow SRP.

Example:

```java
public class UserService {

    public void registerUser() { }

    public void saveUser() { }

    public void generateUserReport() { }

    public void sendWelcomeEmail() { }
}
```

The name `UserService` does not magically make all responsibilities related. We still need to investigate:

```text
Registration
Persistence
Reporting
Communication
```

These may be separate reasons to change.

---

## 30. SRP and Technical Responsibilities

Technical responsibilities often become SRP violations when mixed with domain logic.

Examples:

```text
Business logic
+ Database logic
+ Email logic
+ File system logic
+ Logging logic
```

All inside one class can create a low-cohesion design. A better structure is:

```text
Domain
└── Business logic

Repository
└── Persistence

Notification Service
└── Communication

Report Generator
└── Reporting
```

---

## 31. SRP Refactoring Strategy

When you see a large class:

| Step | Action                                                     |
|:----:|-------------------------------------------------------------|
| 1    | List all methods.                                            |
| 2    | Group methods by responsibility.                              |
| 3    | Ask: *"Do these groups have different reasons to change?"*    |
| 4    | If yes, separate them into focused classes.                   |
| 5    | Keep related methods together — don't create one class per method unless there is a real reason. |

**Step 2 example:**

```text
calculateSalary()
calculateBonus()      ──►  Compensation
calculateTax()

saveToDatabase()       ──►  Persistence

sendEmail()             ──►  Communication
```

---

## 32. SRP Refactoring Example

**Before:**

```text
Employee
├── calculateSalary()
├── calculateBonus()
├── calculateTax()
├── saveToDatabase()
├── generatePayslip()
└── sendEmail()
```

**After:**

```text
Employee
└── core employee behavior

EmployeeCompensation
├── calculateSalary()
├── calculateBonus()
└── calculateTax()

EmployeeRepository
└── saveToDatabase()

PayslipGenerator
└── generatePayslip()

EmployeeNotificationService
└── sendEmail()
```

---

## 33. How to Detect SRP Violations

Use these questions:

1. Can I identify multiple independent reasons for this class to change?
2. Can I divide the methods into unrelated groups?
3. Do different methods belong to different business concerns?
4. Are business and technical responsibilities mixed?
5. Does the class handle persistence, communication, or reporting in addition to domain behavior?
6. Would different teams/stakeholders request changes to different parts of this class?
7. Are some methods likely to change without affecting the others?

If several answers are yes, investigate SRP.

---

## 34. SRP Smells

Common smells include:

- Very large classes
- Many unrelated methods
- Database code mixed with business logic
- Email/notification code mixed with domain logic
- Report generation mixed with domain logic
- File system operations mixed with business logic
- Multiple unrelated groups of fields
- Multiple independent reasons for change
- A class named `Manager`, `Service`, `Processor`, or `Utility` containing unrelated concerns

These are smells, not automatic violations. Always investigate the actual responsibilities.

---

## 35. SRP and "God Classes"

A **God Class** is a class that knows or does too much.

Example:

```text
CompanyService
├── hireEmployee()
├── calculateSalary()
├── calculateBonus()
├── saveEmployee()
├── generateEmployeeReport()
├── sendEmployeeEmail()
├── createInvoice()
├── saveInvoice()
├── printInvoice()
└── sendInvoiceEmail()
```

This class handles:

- Hiring
- Compensation
- Employee persistence
- Employee reporting
- Employee communication
- Invoice creation
- Invoice persistence
- Invoice presentation
- Invoice communication

This is a strong SRP smell.

---

## 36. SRP Is Context Dependent

There is not always exactly one correct decomposition.

For example:

```text
Payment
├── calculateAmount()
├── calculateTax()
└── applyDiscount()
```

This may be perfectly reasonable if the business considers all of these payment calculation responsibilities. Another system might have:

```text
PaymentCalculator
└── calculateAmount()

TaxCalculator
└── calculateTax()

DiscountCalculator
└── applyDiscount()
```

Both designs can potentially follow SRP. The correct design depends on:

- Domain
- Requirements
- Change patterns
- Complexity
- Team structure
- Reusability
- Coupling
- Cohesion

---

## 37. SRP vs Cohesion

| Concept      | Asks                                                         |
|--------------|----------------------------------------------------------------|
| **Cohesion** | How closely related are the things inside this class?          |
| **SRP**      | Does this class have one meaningful reason to change?          |

They are closely related. High cohesion generally helps achieve SRP.

Example:

```text
EmployeeCompensation
├── salary
├── bonus
└── tax
```

High cohesion → one broader responsibility → good SRP candidate.

---

## 38. SRP vs Coupling

| Concept      | Looks at                                            |
|--------------|-------------------------------------------------------|
| **Cohesion** | Inside a class/module                                  |
| **Coupling** | Relationships *between* classes/modules                |

```text
Class A  <──── coupling ────>  Class B
```

SRP and cohesion are directly related. SRP and coupling are related indirectly. For example, splitting responsibilities can sometimes reduce coupling, but:

> SRP itself is primarily about responsibility and reasons to change.

---

## 39. SRP vs OCP

| Principle | Question                                             |
|-----------|--------------------------------------------------------|
| **SRP**   | One meaningful reason to change.                        |
| **OCP**   | Open for extension, closed for modification.             |

Example:

```text
ShippingService
├── calculateStandard()
├── calculateExpress()
└── calculateInternational()
```

- SRP asks: *Are these responsibilities cohesive?*
- OCP asks: *What happens when a new shipping type is added?*

They solve different problems.

---

## 40. SRP vs LSP

| Principle | Question                                    |
|-----------|-------------------------------------------------|
| **SRP**   | Does the class have one reason to change?         |
| **LSP**   | Can the child safely replace the parent?          |

Example:

```text
Bird
├── eat()
├── sleep()
├── fly()
├── saveToDatabase()
└── sendNotification()
```

The class has SRP issues. If:

```java
class Penguin extends Bird {

    @Override
    public void fly() {
        throw new UnsupportedOperationException();
    }
}
```

then there is also an LSP issue. **One design can violate multiple SOLID principles.**

---

## 41. SRP vs ISP

ISP deals with interfaces.

Example:

```java
interface Printer {

    void print();

    void scan();

    void fax();
}
```

A simple printer may not need `scan` or `fax`. That is primarily an ISP problem. SRP is about the responsibility of a class/module.

---

## 42. SRP vs DIP

DIP deals with dependencies and abstractions.

Example:

```text
BackupService
    │
    ▼
AmazonS3
```

If `BackupService` directly depends on `AmazonS3`, DIP may be violated.

- SRP asks: *What responsibility does `BackupService` have?*
- DIP asks: *What does `BackupService` depend on?*

Different concerns.

---

## 43. Real-World Example

Consider an e-commerce `Order`.

**Bad:**

```text
OrderService
├── createOrder()
├── calculateTotal()
├── applyDiscount()
├── saveToDatabase()
├── generateInvoice()
├── sendEmail()
└── sendSMS()
```

**Potential design:**

```text
Order
└── order behavior

OrderCalculator
├── calculateTotal()
└── applyDiscount()

OrderRepository
└── save()

InvoiceGenerator
└── generateInvoice()

OrderNotificationService
├── sendEmail()
└── sendSMS()
```

Now each component has a clearer responsibility.

---

## 44. Refactoring Rule of Thumb

When you find a large class, do **NOT** immediately create one class for every method. Instead:

```text
Large Class
    │
    ▼
Identify responsibilities
    │
    ▼
Group related methods
    │
    ▼
Identify reasons to change
    │
    ▼
Separate independent groups
    │
    ▼
Create cohesive classes
```

---

## 45. SRP Practical Checklist

When reviewing a class, ask:

**Responsibility**
- What does this class do?
- Can I describe its responsibility in one meaningful sentence?

**Change**
- Why would this class change?
- Are there multiple independent reasons?

**Cohesion**
- Are the methods strongly related?
- Can I group them into separate unrelated clusters?

**Business vs Technical**
- Which methods represent business behavior?
- Which methods are persistence?
- Which methods are communication?
- Which methods are reporting?
- Which methods are infrastructure?

**Design**
- Can responsibilities be separated naturally?
- Am I creating too many tiny classes?
- Would the extracted classes be cohesive?

---

## 46. Quick SRP Decision Tree

```text
Start
  │
  ▼
Inspect class
  │
  ▼
List responsibilities
  │
  ▼
Group related methods
  │
  ▼
Are there independent groups?
  ├── NO  ──► Likely cohesive
  └── YES ──► Investigate
                │
                ▼
        Different reasons to change?
          ├── NO  ──► Keep together
          └── YES ──► Separate responsibilities
```

---

## 47. SRP Mental Model

```text
CLASS
  ├── Method
  ├── Method
  └── Method
        │
        ▼
   Same reason?
     ├── YES ──► Keep together
     └── NO  ──► Separate
```

---

## 48. The Bird Mental Model

**Good:**

```text
Bird
├── eat()
├── sleep()
└── fly()
```

Because these represent bird behavior.

**Bad:**

```text
Bird
├── eat()
├── sleep()
├── fly()
├── saveToDatabase()
├── generateReport()
└── sendNotification()
```

Because technical responsibilities have been mixed with bird behavior.

**Better:**

```text
Bird
├── eat()
├── sleep()
└── fly()

BirdRepository
└── save()

BirdReportGenerator
└── generateReport()

BirdNotificationService
└── sendNotification()
```

---

## 49. Important Lessons Learned

| # | Lesson |
|---|--------|
| 1 | SRP is not about one method per class. |
| 2 | SRP is about one meaningful reason to change. |
| 3 | Cohesion is extremely important when applying SRP. |
| 4 | Highly related methods can and should remain together. |
| 5 | Business responsibility and technical responsibility often have different reasons to change. |
| 6 | Database persistence is usually a separate responsibility from business logic. |
| 7 | Notification is usually a separate responsibility from business logic. |
| 8 | Report generation can be a separate responsibility. |
| 9 | One class can have multiple methods and still follow SRP. |
| 10 | One method can contain multiple concerns; method count alone does not determine SRP. |
| 11 | Creating one class per method is not good SRP. |
| 12 | SRP is context dependent. |
| 13 | One design can violate multiple SOLID principles simultaneously. |

---

## 50. Interview Questions

**Q1. What is SRP?**
SRP states: *A class should have one reason to change.*

**Q2. Does SRP mean one method per class?**
No. Multiple highly cohesive methods can belong to the same responsibility.

**Q3. What is cohesion?**
Cohesion measures how closely related the responsibilities inside a class/module are.

**Q4. What is high cohesion?**
High cohesion means the methods and data inside a class are strongly related to the same responsibility.

**Q5. What is low cohesion?**
Low cohesion means unrelated responsibilities are grouped inside the same class.

**Q6. What is the relationship between SRP and cohesion?**
SRP encourages meaningful responsibility boundaries, while high cohesion means the things inside the class strongly belong together. High cohesion generally supports good SRP design.

**Q7. Is `saveToDatabase()` always an SRP violation?**
Not automatically — it depends on context. However, persistence commonly has a different reason to change from domain/business behavior, so it is often a strong SRP smell.

**Q8. Does a class violate SRP if it has many methods?**
No. Method count does not determine SRP. The important question is whether the methods belong to the same responsibility.

**Q9. Does a class with one method always follow SRP?**
No. One method can still coordinate multiple responsibilities.

**Q10. What is an axis of change?**
An independent dimension along which a class may need to change. Examples: compensation rules, database technology, email provider, reporting format. Multiple independent axes can indicate an SRP violation.

**Q11. What does "change together" mean?**
Things that are likely to change because of the same requirement or responsibility can reasonably belong together.

**Q12. Should every business operation be a separate class?**
No. Related business operations should generally be grouped into cohesive components.

**Q13. What is a God Class?**
A class that contains too many responsibilities and knows or does too much. It is a common SRP smell.

**Q14. Is SRP only applicable to classes?**
The principle is commonly discussed at the class level, but the underlying idea of responsibility boundaries can also be applied to modules and other software components.

**Q15. Can two developers design different SRP-compliant solutions?**
Yes. There can be multiple valid designs. The correct boundary depends on the domain and expected change patterns.

---

## 51. Practice Problems We Covered

During practice, we analyzed SRP using:

- Bird
- Printer
- Employee
- Order
- Invoice
- Payment
- Media Player
- Cloud Storage
- Company Service

For each problem, the process was:

```text
Identify responsibilities
        │
        ▼
Group related methods
        │
        ▼
Identify cohesion
        │
        ▼
Identify reasons to change
        │
        ▼
Separate independent responsibilities
        │
        ▼
Create cohesive classes
```

---

## 52. Example Final Architecture

A typical SRP-friendly application might look like:

```text
domain/
├── Employee.java
├── Order.java
├── Payment.java
└── Bird.java

service/
├── EmployeeCompensation.java
├── OrderCalculator.java
└── PaymentService.java

repository/
├── EmployeeRepository.java
├── OrderRepository.java
└── PaymentRepository.java

notification/
├── EmployeeNotificationService.java
├── OrderNotificationService.java
└── PaymentNotificationService.java

report/
├── PayslipGenerator.java
├── InvoiceGenerator.java
└── ReportGenerator.java
```

The exact package structure is not part of SRP. The important thing is the responsibility boundary.

---

## 53. Final SRP Formula

```text
SRP
├── One meaningful responsibility
├── One reason to change
├── High cohesion
└── Separate independent responsibilities
```

---

## 54. Final SRP Rule

When looking at a class, ask:

> *"If requirements change in different areas, would I need to modify this same class for unrelated reasons?"*

If the answer is yes, investigate SRP. Then ask:

> *"Can I group the methods into cohesive responsibility groups?"*

If yes, those groups are candidates for separate classes. But remember:

> **Do not split classes just for the sake of splitting them.**

The goal is **not**:

```text
Many small classes
```

The goal is:

```text
Meaningful responsibilities + High cohesion + Independent reasons to change
```

---

## 55. One-Line Memory Trick

> **SRP = One class, one meaningful reason to change.**

> **SRP does NOT mean one method per class.**

The strongest practical question is:

> **"What different reasons could cause me to change this class?"**

If you find multiple independent reasons, investigate whether the responsibilities should be separated.

---

## 56. Final Example

**Bad:**

```java
public class Employee {

    void calculateSalary() { }

    void calculateBonus() { }

    void calculateTax() { }

    void saveToDatabase() { }

    void generatePayslip() { }

    void sendEmail() { }
}
```

**Better:**

```java
public class Employee {
    
    void calculateSalary() { }
}
```

```java
public class EmployeeCompensation {

    void calculateBonus() { }

    void calculateTax() { }
}
```

```java
public class EmployeeRepository {

    void saveToDatabase(Employee employee) { }
}
```

```java
public class PayslipGenerator {

    void generatePayslip(Employee employee) { }
}
```

```java
public class EmployeeNotificationService {

    void sendEmail(Employee employee) { }
}
```

The improved design separates independent responsibilities while keeping related responsibilities together.

**That is the essence of the Single Responsibility Principle.**
