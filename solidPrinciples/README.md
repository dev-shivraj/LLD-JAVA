# Single Responsibility Principle in Java

This repository is a hands-on study of the **Single Responsibility Principle (SRP)**, the first principle in SOLID. The examples start with classes that mix several kinds of work and progressively separate those concerns into smaller, more cohesive classes.

The code is intentionally small and uses `System.out.println` as a stand-in for real business logic, databases, reporting engines, email providers, and other infrastructure. The value of the examples is in the boundaries between responsibilities, not in the output itself.

## Learning Goals

These examples explore:

- Single responsibility and the **one reason to change** heuristic
- Responsibility, cohesion, and low cohesion
- Change axes and independent change
- Business/domain, infrastructure, persistence, communication, and reporting responsibilities
- Meaningful class boundaries without over-fragmentation
- Multiple valid SRP designs
- The difference between SRP, LSP, and ISP
- Classes that violate more than one SOLID principle at the same time

## What SRP Means

> A class should have one reason to change.

A responsibility is a family of related decisions that may change together. It is not necessarily one method, one line of code, or one verb in a class name.

The phrase **one reason to change** is useful because it focuses on the source of change:

- A tax rule changes because the finance or regulatory policy changed.
- A database implementation changes because the persistence technology or schema changed.
- An email provider changes because the communication mechanism changed.
- A report format changes because a consumer or presentation requirement changed.
- A domain rule changes because the business changed.

These are different change axes. When one class owns all of them, an unrelated change can force that class to be edited, retested, and redeployed with every other concern.

SRP does not mean that every class must contain exactly one method. It means the methods and data in a class should be strongly related to one kind of change.

## Responsibility and Cohesion

### Cohesion

**Cohesion** describes how closely the responsibilities inside a class belong together. A class with high cohesion has methods that collaborate around one clear purpose. A class with low cohesion is a collection of unrelated operations that happen to be convenient to place together.

For example, these operations have high cohesion in an `Employee` domain model:

```java
calculateSalary();
calculateBonus();
calculateTax();
```

They all concern compensation rules. By contrast, the following group has low cohesion:

```java
calculateSalary();
saveToDatabase();
generatePayslip();
sendEmail();
```

The first method is domain logic, the second is persistence, the third is reporting/presentation, and the fourth is communication. Each is likely to change for a different reason.

### Low cohesion as a warning sign

Common warning signs include:

- A class has groups of methods separated by comments such as `group 1`, `group 2`, and `group 3`.
- The class name is broad, such as `CompanyService`, but its methods cover employees and invoices.
- Many methods do not use the same fields or collaborators.
- A change request requires editing an unrelated part of the class.
- The class imports database, email, file, formatting, and domain libraries together.
- Tests need to configure several unrelated dependencies just to test one rule.

Comments can reveal the groups, but comments do not create boundaries. If groups have independent change reasons, they are candidates for separate classes.

## Responsibility Categories in These Examples

The repository repeatedly uses the following categories:

| Responsibility | Typical operations | Likely change source |
| --- | --- | --- |
| Business/domain | `eat`, `play`, `createOrder`, salary rules, payment rules | Business policy and domain requirements |
| Infrastructure | File loading, encryption, external services | Technology, providers, protocols, operating environment |
| Persistence | `saveToDatabase`, save history, save metadata | Database, schema, ORM, storage choice |
| Communication | Email, notifications, confirmation messages | Provider, templates, delivery policy, channels |
| Reporting/presentation | Reports, receipts, payslips, invoices, playlists | Format, audience, rendering or analytical requirements |

These labels are practical design aids, not rigid laws. A real system may combine or split them differently depending on the domain and the rate of change.

## Part 1: Basic Extraction

`part1` introduces the basic contrast between mixed classes in `badDesign` and focused classes in `goodDesign`.

### Bird

- `badDesign.Bird` combines bird behavior (`eat`, `sleep`) with persistence, report generation, and notifications.
- `goodDesign.Bird` keeps the bird's behavior in the domain class.
- `BirdRepository` owns persistence.
- `BirdReportGenerator` owns reporting.
- `BirdNotificationService` owns communication.

The bird's behavior can change without modifying database or notification code. A notification provider can change without modifying the bird model.

### Employee

- `badDesign.Employee` combines salary calculation, bonus and tax rules, database persistence, payslip generation, and email.
- `goodDesign.Employee` retains the employee's salary behavior.
- `EmployeeCompensation` owns bonus and tax calculations.
- `EmployeeRepository` owns persistence.
- `PayslipGenerator` owns payslip generation.
- `EmployeeNotificationService` owns email communication.
- `EmployeeClient` demonstrates client-side use of the separated design.

The example also shows that compensation-related operations may remain together: bonus and tax have a stronger relationship to each other than either has to email delivery.

### Printer

- `badDesign.Printer` mixes printing and ink calculations with print-history persistence and low-ink notification.
- `goodDesign.Printer` owns printing-related behavior and ink usage.
- `PrinterRepository` owns print-history persistence.
- The attached part 1 design separates persistence; communication is identified as a separate responsibility in the bad design and can be extracted similarly.

### Other part 1 examples

- `Invoice` mixes total/discount rules, database persistence, printing, and emailing.
- `OrderService` mixes order rules, persistence, invoice generation, and confirmation email.
- `User` mixes registration/login, database persistence, welcome email, and reporting.

These smaller examples reinforce the same test: ask which stakeholder, policy, technology, or output format would request the change.

## Part 2: Finding Change Axes

`part2` makes the grouping more explicit with comments such as `group 1`, `group 2`, and `group 3`. The comments identify related methods, but the classes remain intentionally mixed so the reader can practice spotting boundaries.

### Bird

`part2.bird.badDesign.Bird` groups eating, sleeping, flying, and swimming as core bird behavior, while persistence, reports, and notifications are separate groups. Core domain behavior may contain multiple methods because those methods share a business/domain responsibility.

### Employee

`part2.employee.badDesign.Employee` groups salary, bonus, and tax calculations. `printSalarySlip` is deliberately questioned in the source: printing a payslip is not the same responsibility as calculating compensation. This is a cohesion and change-axis problem even though both operations mention salary.

### Payment

- `badDesign.PaymentService` mixes payment rules (`processPayment`, tax, discount) with receipt generation, transaction persistence, and confirmation communication.
- `goodDesign.Payment` keeps amount, tax, and discount calculations together as payment-domain behavior.

This example also highlights naming: a domain object such as `Payment` and an orchestration/service class such as `PaymentService` need not have the same responsibility.

### Cloud storage

`part2.cloudStorage.badDesign.CloudStorageService` mixes file operations, encryption, metadata persistence, upload notifications, and reporting. Encryption is infrastructure/security work, while upload/download/delete are storage-domain operations. Those change axes should not be forced to evolve together.

### Media player

`part2.mediaPlayer.badDesign.MediaPlayer` combines playback controls, file loading, playback-history persistence, playlist generation, and notifications. `loadFile` deserves careful analysis: it may be part of playback orchestration, but if loading involves a filesystem, network, or database, the technical mechanism may have its own change axis.

### Company

`part2.company.badDesign.CompanyService` is an especially clear low-cohesion example. It contains employee hiring, compensation, employee persistence, employee reports, employee email, invoice creation, invoice persistence, invoice printing, and invoice email. It crosses both a domain boundary (employees and invoices) and multiple technical boundaries.

## Part 3: Focused Designs

`part3` applies the extraction pattern more completely. Each bad design preserves the mixed responsibilities, while each good design separates the domain operation from supporting concerns.

### Bird

`goodDesign.Bird` contains eating, sleeping, flying, and swimming. `BirdRepository`, `BirdReportGenerator`, and `BirdNotificationService` handle persistence, reporting, and communication respectively.

The exact method names differ from part 1 (`generate` versus `generateReport`, for example). That is a reminder that SRP does not prescribe method names or one canonical class diagram.

### Employee

`goodDesign.Employee` retains salary calculation. `EmployeeCompensation` handles bonus and tax, `EmployeeRepository` handles persistence, `PayslipGenerator` handles presentation/report generation, and `EmployeeNotificationService` handles email.

This design separates compensation rules from the employee entity while still keeping the compensation rules cohesive.

### Payment

`goodDesign.PaymentService` contains payment processing, tax, and discount behavior. Supporting classes are:

- `PaymentRepository` for transaction persistence
- `ReceiptGenerator` for receipt/report generation
- `PaymentNotificationService` for confirmation communication

The service name does not make the design non-SRP. What matters is whether its methods belong to one coherent payment-domain responsibility.

### Printer

The printer's core behavior stays in `Printer`; print-history storage belongs in `PrinterRepository`. The same boundary can accommodate notification behavior in a separate notification collaborator when that requirement is implemented.

### MediaPlayer

`goodDesign.MediaPlayer` owns playback controls and file loading. The supporting classes separate playback-history persistence, playlist generation, and notification delivery:

- `PlaybackHistoryRepository`
- `PlaylistGenerator`
- `MediaNotificationService`

This design keeps the player focused while allowing storage, playlist algorithms, and notification channels to change independently.

### CloudStorage

`goodDesign.CloudStorageService` owns upload, download, and delete operations. The remaining responsibilities are extracted into:

- `FileEncryptionService` for encryption/security infrastructure
- `MetadataRepository` for metadata persistence
- `StorageNotificationService` for notifications
- `StorageReportGenerator` for reporting

This is the clearest example of multiple independent change axes being pulled apart.

### Order

`goodDesign.OrderService` owns order creation, total calculation, and discount rules. `OrderRepository`, `InvoiceGenerator`, and `OrderNotificationService` own persistence, invoice generation, and confirmation email.

### Additional payment and domain examples

The part 3 folders also contain bad and good payment designs alongside the order, employee, bird, cloud-storage, and media-player examples. Together they show a repeatable extraction approach rather than a special-case solution for one domain.

## A Practical SRP Refactoring Process

1. Start with the class's public behavior and list every method.
2. Group methods by the business capability or change source they serve.
3. Name each group as a responsibility: domain, persistence, communication, reporting, security, or infrastructure.
4. Ask who would request a change to each group.
5. If different groups have different answers, consider separate classes.
6. Move the smallest meaningful group behind a clear class boundary.
7. Pass domain data to the collaborator instead of giving every collaborator unrestricted access to the whole system.
8. Keep orchestration in an application/service layer only when coordinating a workflow is itself a coherent responsibility.
9. Test each extracted responsibility independently.
10. Recheck the result for unnecessary fragmentation and duplicated logic.

## Independent Change

Good boundaries reduce the blast radius of change:

- Changing a tax formula should affect compensation or payment logic, not email delivery.
- Switching from a database to another persistence mechanism should affect repositories, not domain calculations.
- Changing an email provider should affect notification services, not entities.
- Changing invoice or payslip formatting should affect generators, not order or employee rules.
- Changing encryption libraries should affect the encryption service, not upload/delete behavior.

Independent change is the operational benefit of SRP. It improves local reasoning, testing, deployment decisions, and ownership by different teams.

## Meaningful Boundaries and Avoiding Over-Fragmentation

SRP is not a command to create a class for every verb. Over-fragmentation creates indirection, ceremony, and objects that have no independent reason to change.

Keep related methods together when they:

- Use the same domain concepts and invariants
- Are changed by the same stakeholder
- Need the same data and collaborators
- Form one understandable capability

Extract when methods:

- Depend on unrelated frameworks or external systems
- Have different stakeholders or release rhythms
- Are likely to be tested independently
- Change for different policies or technical reasons
- Make the original class difficult to name accurately

There can be multiple valid SRP designs. Bonus and tax can live in `EmployeeCompensation`, in separate policy classes, or in a compensation service depending on the domain's complexity and expected change. The principle guides the boundary; it does not dictate one fixed number of classes.

## SRP, LSP, and ISP Are Different Questions

### SRP versus LSP

**SRP** asks: “Does this class have one reason to change?”

**Liskov Substitution Principle (LSP)** asks: “Can a subtype be used wherever its base type is expected without breaking the base type's behavioral promises?”

A class may violate SRP without using inheritance at all. For example, an `Employee` that calculates salary, saves itself, and sends email has an SRP problem, but no LSP issue is required. Conversely, a hierarchy can violate LSP while every class has a focused responsibility.

### SRP versus ISP

**SRP** is primarily about responsibilities and reasons to change within a class or module.

**Interface Segregation Principle (ISP)** asks: “Are clients forced to depend on methods they do not use?”

A large interface can violate ISP even when each implementing class is internally cohesive. A class can also violate SRP without implementing any interface. Splitting a concrete class into collaborators may support ISP later, but the principles diagnose different problems.

### One class can violate multiple principles

The `CompanyService` example can violate several principles at once:

- **SRP:** employee and invoice concerns, plus persistence, reporting, and communication, have different reasons to change.
- **ISP:** if exposed through one broad interface, clients may depend on methods unrelated to their needs.
- **DIP:** if it directly constructs database, email, or reporting implementations, it depends on concrete details.
- **OCP:** adding another communication channel or invoice format may require modifying the class.

These are related design smells, but each principle should be applied to the specific problem it describes. Do not claim that fixing one automatically fixes all of them.

## Repository Layout

```text
src/practice/srp/
├── part1/   # Basic bad/good pairs for introductory extraction
├── part2/   # Responsibility groups and change-axis analysis
└── part3/   # More complete focused designs
```

Most examples use the package pattern:

```text
practice.srp.<part>.<domain>.<badDesign|goodDesign>
```

The `badDesign` and `goodDesign` packages intentionally coexist so the designs can be compared side by side.

## Important Scope Note

The sample methods mostly print messages and do not implement real persistence, payment processing, encryption, playback, or reporting. In a production design, these classes would usually depend on abstractions for external systems, validate inputs, handle failures, and return meaningful results. Those concerns are useful next steps, but they are separate from the central SRP lesson: keep policies and responsibilities that change independently behind meaningful boundaries.

## Summary

SRP is a design tool for managing change:

- Identify the responsibility, not just the method name.
- Group behavior that changes for the same reason.
- Separate business/domain rules from infrastructure, persistence, communication, and reporting when their change axes differ.
- Prefer high cohesion and independent change.
- Extract meaningful collaborators, but avoid classes that are too small to own a real responsibility.
- Remember that several designs can satisfy SRP.
- Diagnose SRP, LSP, and ISP separately, even when one class violates more than one principle.

The bird, employee, payment, printer, media-player, cloud-storage, order, invoice, user, and company examples are all variations of this same design conversation: **what should change together, and what should be free to change independently?**
