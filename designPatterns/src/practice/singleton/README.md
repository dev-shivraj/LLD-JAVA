# Singleton Design Pattern

Complete learning notes for the Singleton Design Pattern in Java.

This README covers:

- Singleton fundamentals
- Why Singleton is needed
- Private constructor
- Static instance
- Global access point
- Eager initialization
- Lazy initialization
- Thread safety
- Race conditions
- Synchronized Singleton
- Double-Checked Locking
- volatile
- Initialization-on-Demand Holder
- Enum Singleton
- Reflection attacks
- Serialization attacks
- readResolve()
- Cloning
- Singleton vs Static Utility
- Singleton vs Dependency Injection
- Global state
- Testability
- ClassLoaders
- Real-world examples
- Practice exercises
- Interview questions
- Design considerations

---

# 1. What Is Singleton?

Singleton is a Creational Design Pattern.

Its intent is:

> Ensure that a class has only one logical instance and provide a global access point to that instance.

The Singleton Pattern has two main responsibilities:

1. Control object creation.
2. Provide access to the same instance.

Conceptually:

    Client A --------\
    Client B ---------\
    Client C -----------> ONE SINGLETON INSTANCE
    Client D ---------/
    Client E --------/

All clients should receive the same logical object.

---

# 2. Project Structure

Singleton Design Pattern directory structures:

    designPatterns/
    └── src/
        └── practice/
            └── singleton/
                ├── part1/
                ├── part2/
                ├── part3/
                └── part4/

Every example and practice exercise should be created inside the appropriate part.

---

# 3. Why Do We Need Singleton?

Normally Java allows us to create multiple objects.

Example:

    Logger logger1 = new Logger();
    Logger logger2 = new Logger();
    Logger logger3 = new Logger();

This produces:

    logger1 ---> Logger Object #1

    logger2 ---> Logger Object #2

    logger3 ---> Logger Object #3

But some resources are logically required to be shared.

Examples:

- Application configuration
- Logger registry
- Metrics registry
- Connection pool
- Shared cache
- Resource manager
- Application-wide registry

Desired structure:

    Client A ----\
    Client B -----\
    Client C ------> ONE SHARED INSTANCE
    Client D -----/
    Client E ----/

---

# 4. Core Characteristics of Singleton

A traditional Singleton generally contains:

1. Private constructor.
2. Static instance.
3. Static access method.

Basic implementation:

    public class Singleton {

        private static Singleton instance;

        private Singleton() {
        }

        public static Singleton getInstance() {

            if (instance == null) {
                instance = new Singleton();
            }

            return instance;
        }
    }

---

# 5. Private Constructor

The constructor is private:

    private Singleton() {
    }

Why?

Because otherwise external code could do:

    Singleton s1 = new Singleton();
    Singleton s2 = new Singleton();

That would allow multiple objects.

The private constructor prevents normal external construction.

Therefore this is not allowed outside the class:

    Singleton s = new Singleton();

---

# 6. Static Instance

The Singleton instance is generally stored in a static field:

    private static Singleton instance;

Why static?

Because the instance belongs to the class rather than to an individual object.

We should be able to call:

    Singleton.getInstance();

without first creating a Singleton object.

---

# 7. Static getInstance()

The access method is generally static:

    public static Singleton getInstance()

This gives us a class-level access point.

Usage:

    Singleton singleton = Singleton.getInstance();

---

# 8. Basic Singleton Implementation

    public class Singleton {

        private static Singleton instance;

        private Singleton() {
        }

        public static Singleton getInstance() {

            if (instance == null) {
                instance = new Singleton();
            }

            return instance;
        }
    }

Client:

    public class Client {

        public static void main(String[] args) {

            Singleton s1 = Singleton.getInstance();
            Singleton s2 = Singleton.getInstance();

            System.out.println(s1 == s2);
        }
    }

Output:

    true

Both references point to the same object.

---

# 9. Understanding Object Identity

Consider:

    Singleton s1 = Singleton.getInstance();
    Singleton s2 = Singleton.getInstance();

Then:

    s1 == s2

should return:

    true

Why?

Because both variables refer to the same object.

Conceptually:

    s1 ------------------+
                         |
                         v
                     Singleton
                         ^
                         |
    s2 ------------------+

The most important property of Singleton is object identity.

---

# 10. Singleton Is About Identity

Do not think of Singleton merely as:

    "A class with a private constructor."

The real requirement is:

    "There should be one logical instance."

Therefore:

    s1 == s2

should be true.

The Singleton pattern is primarily about controlling object identity and lifecycle.

---

# 11. Singleton Can Have State

A Singleton can maintain state.

Example:

    public class ApplicationConfig {

        private String environment;

        private static ApplicationConfig instance;

        private ApplicationConfig() {
        }

        public static ApplicationConfig getInstance() {

            if (instance == null) {
                instance = new ApplicationConfig();
            }

            return instance;
        }

        public String getEnvironment() {
            return environment;
        }

        public void setEnvironment(String environment) {
            this.environment = environment;
        }
    }

Usage:

    ApplicationConfig config =
            ApplicationConfig.getInstance();

    config.setEnvironment("PROD");

Elsewhere:

    ApplicationConfig anotherConfig =
            ApplicationConfig.getInstance();

    System.out.println(
            anotherConfig.getEnvironment()
    );

Output:

    PROD

Both references point to the same object and therefore see the same state.

---

# 12. Very Important: Singleton Identity vs Singleton State

This distinction is extremely important.

Singleton guarantees:

    ONE LOGICAL INSTANCE

It does NOT automatically guarantee:

    THREAD-SAFE STATE

Example:

    public class Counter {

        private int count;

        public void increment() {
            count++;
        }
    }

Even if Counter is implemented as a Singleton, this:

    count++;

is not automatically thread-safe.

Therefore:

    Singleton != Automatically Thread Safe

There are two separate questions:

1. Can multiple Singleton instances be created?
2. Can multiple threads safely modify Singleton state?

These are different problems.

---

# 13. Eager Initialization

Eager initialization means the Singleton object is created when the class is initialized.

Implementation:

    public class Singleton {

        private static final Singleton INSTANCE =
                new Singleton();

        private Singleton() {
        }

        public static Singleton getInstance() {
            return INSTANCE;
        }
    }

Conceptually:

    Class Initialization
            |
            v
    new Singleton()
            |
            v
    INSTANCE created

---

# 14. Advantages of Eager Initialization

Advantages:

- Very simple.
- Easy to understand.
- Thread-safe class initialization.
- No explicit synchronization.
- Very little code.

Example:

    public static Singleton getInstance() {
        return INSTANCE;
    }

No explicit locking is required.

---

# 15. Disadvantages of Eager Initialization

The object is created even if nobody uses it.

For example:

    private static final HugeObject INSTANCE =
            new HugeObject();

Application startup:

    Application starts
            |
            v
    HugeObject created
            |
            v
    Nobody uses it

The object creation was unnecessary.

This matters when construction is expensive.

---

# 16. Lazy Initialization

Lazy initialization means:

> Create the Singleton only when it is first requested.

Implementation:

    public class Singleton {

        private static Singleton instance;

        private Singleton() {
        }

        public static Singleton getInstance() {

            if (instance == null) {
                instance = new Singleton();
            }

            return instance;
        }
    }

Execution:

    Application starts
            |
            v
    instance = null
            |
            v
    getInstance()
            |
            v
    instance == null
            |
            v
    new Singleton()
            |
            v
    instance created

---

# 17. Problem With Basic Lazy Singleton

The basic lazy Singleton implementation is NOT thread-safe.

Consider two threads.

Thread A:

    if (instance == null) {
        instance = new Singleton();
    }

Thread B:

    if (instance == null) {
        instance = new Singleton();
    }

Possible execution:

    Thread A                       Thread B

    instance == null               instance == null
          |                               |
          v                               v
        true                            true
          |                               |
          v                               v
    new Singleton()                new Singleton()
          |                               |
          v                               v
    Object #1                      Object #2

Now we have two objects.

That violates the Singleton requirement.

---

# 18. Race Condition

This code:

    if (instance == null) {
        instance = new Singleton();
    }

looks like one logical operation.

But internally it involves multiple steps.

Conceptually:

    CHECK
      |
      v
    READ instance
      |
      v
    COMPARE WITH null
      |
      v
    CREATE OBJECT
      |
      v
    ASSIGN REFERENCE

Multiple threads can interleave these steps.

That is a race condition.

---

# 19. Synchronized Singleton

One solution is to synchronize getInstance():

    public class Singleton {

        private static Singleton instance;

        private Singleton() {
        }

        public static synchronized Singleton getInstance() {

            if (instance == null) {
                instance = new Singleton();
            }

            return instance;
        }
    }

Only one thread can execute getInstance() at a time.

Conceptually:

    Thread A
       |
       v
      LOCK
       |
       v
    create instance
       |
       v
    UNLOCK
       |
       v
    Thread B
       |
       v
      LOCK
       |
       v
    return existing instance
       |
       v
    UNLOCK

---

# 20. Advantages of Synchronized Singleton

Advantages:

- Simple.
- Easy to understand.
- Thread-safe creation.
- Easy to implement.

---

# 21. Disadvantages of Synchronized Singleton

Every call to:

    getInstance()

requires synchronization.

But after the Singleton has already been created, synchronization is generally unnecessary just to return the existing reference.

Conceptually:

    First call:
        synchronization useful

    Later calls:
        synchronization unnecessary

This is why Double-Checked Locking is useful to understand.

---

# 22. Double-Checked Locking

Double-Checked Locking checks the instance twice.

Implementation:

    public class Singleton {

        private static volatile Singleton instance;

        private Singleton() {
        }

        public static Singleton getInstance() {

            if (instance == null) {

                synchronized (Singleton.class) {

                    if (instance == null) {

                        instance = new Singleton();
                    }
                }
            }

            return instance;
        }
    }

Notice:

    if (instance == null)

appears twice.

---

# 23. Why Do We Need the First Check?

Suppose the Singleton already exists.

Then:

    if (instance == null)

is false.

We immediately return:

    instance

without acquiring the lock.

This provides the fast path.

Conceptually:

    Singleton already exists
            |
            v
    instance != null
            |
            v
       return instance
            |
            v
       no lock needed

---

# 24. Why Do We Need the Second Check?

Suppose two threads reach the first check at approximately the same time.

    Thread A                         Thread B

    instance == null                instance == null
          |                               |
          v                               v
        true                            true
          |                               |
          v                               v
        LOCK                            WAIT
          |
          v
    create instance
          |
          v
       UNLOCK
                                          |
                                          v
                                        LOCK
                                          |
                                          v
                              check instance == null
                                          |
                                          v
                                        false
                                          |
                                          v
                                   return instance

Without the second check, Thread B could create another object after obtaining the lock.

---

# 25. Why Is volatile Required?

Double-Checked Locking traditionally uses:

    private static volatile Singleton instance;

Why?

Object creation is not conceptually one indivisible operation.

Conceptually:

    1. Allocate memory.
    2. Initialize object.
    3. Assign reference.

Without proper memory visibility and ordering guarantees, another thread could potentially observe an improperly published object.

volatile provides the required visibility and ordering guarantees for this pattern.

Therefore:

    private static volatile Singleton instance;

is important in Double-Checked Locking.

---

# 26. Final Double-Checked Locking Implementation

    public class Singleton {

        private static volatile Singleton instance;

        private Singleton() {
        }

        public static Singleton getInstance() {

            if (instance == null) {

                synchronized (Singleton.class) {

                    if (instance == null) {

                        instance = new Singleton();
                    }
                }
            }

            return instance;
        }
    }

Remember:

    Double-Checked Locking
            +
          volatile

---

# 27. Initialization-on-Demand Holder Idiom

The Holder idiom is one of the cleanest ways to implement a lazy Singleton.

Implementation:

    public class Singleton {

        private Singleton() {
        }

        private static class Holder {

            private static final Singleton INSTANCE =
                    new Singleton();
        }

        public static Singleton getInstance() {
            return Holder.INSTANCE;
        }
    }

---

# 28. How Holder Idiom Works

The nested Holder class is not initialized until it is actually used.

When we call:

    Singleton.getInstance();

execution reaches:

    Holder.INSTANCE

which causes Holder initialization.

Conceptually:

    Application starts
            |
            v
    Singleton class loaded
            |
            v
    Holder not initialized
            |
            v
    getInstance()
            |
            v
    Holder.INSTANCE accessed
            |
            v
    Holder initialized
            |
            v
    Singleton created

This gives us:

    Lazy initialization
            +
    Thread-safe initialization
            +
    No explicit synchronization

---

# 29. Why Is Holder Idiom Thread-Safe?

Java class initialization is thread-safe.

The JVM guarantees that class initialization happens safely.

Therefore:

    private static final Singleton INSTANCE =
            new Singleton();

inside the Holder class is safely initialized.

---

# 30. Advantages of Holder Idiom

Advantages:

- Lazy initialization.
- Thread-safe.
- No explicit synchronized method.
- No explicit synchronized block.
- No volatile required.
- Simple implementation.
- Good readability.

---

# 31. Holder vs Double-Checked Locking

Holder Idiom:

    - Lazy
    - Thread-safe
    - No explicit locking
    - No volatile
    - Simple
    - Easy to read

Double-Checked Locking:

    - Lazy
    - Thread-safe
    - Uses synchronized
    - Requires volatile
    - More complex
    - Easy to implement incorrectly

For a manually implemented lazy Singleton, the Holder idiom is an excellent implementation to understand and remember.

---

# 32. Enum Singleton

Java provides another powerful way to implement Singleton using enum.

Implementation:

    public enum Singleton {

        INSTANCE;

        public void doSomething() {
            System.out.println("Doing something");
        }
    }

Usage:

    Singleton.INSTANCE.doSomething();

---

# 33. Why Enum Singleton Is Powerful

Enum instances are specially managed by Java.

We do not need to manually write:

    private static Singleton instance;

or:

    private Singleton() {
    }

or:

    public static Singleton getInstance()

The enum mechanism manages the instance.

---

# 34. Enum Singleton Advantages

Enum Singleton provides strong protection against:

- Normal construction.
- Serialization problems.
- Reflective construction of enum constants.

It is also extremely concise.

---

# 35. Enum Singleton Disadvantage

Java enums already extend:

    java.lang.Enum

Therefore an enum cannot extend another class.

So enum Singleton is not always suitable if the class needs class inheritance.

---

# 36. Singleton Implementation Comparison

    +-------------------------+-------+-------------+------------+
    | Implementation          | Lazy  | Thread Safe | Complexity |
    +-------------------------+-------+-------------+------------+
    | Basic Lazy              | Yes   | No          | Very Low   |
    | Eager                   | No    | Yes         | Very Low   |
    | synchronized method     | Yes   | Yes         | Low        |
    | Double-Checked Locking  | Yes   | Yes         | Medium     |
    | Holder                  | Yes   | Yes         | Low        |
    | Enum                    | JVM   | Yes         | Very Low   |
    +-------------------------+-------+-------------+------------+

---

# 37. Reflection Can Break Traditional Singleton

Consider:

    public class Singleton {

        private static final Singleton INSTANCE =
                new Singleton();

        private Singleton() {
        }

        public static Singleton getInstance() {
            return INSTANCE;
        }
    }

Normally:

    Singleton s1 = Singleton.getInstance();

The constructor is private.

But reflection can access private constructors.

Example:

    Constructor<Singleton> constructor =
            Singleton.class.getDeclaredConstructor();

    constructor.setAccessible(true);

    Singleton s2 =
            constructor.newInstance();

Now:

    s1 == s2

can be:

    false

We have created another object.

---

# 38. Reflection Attack Flow

Normal code:

    private constructor
            |
            v
    external construction blocked

Reflection:

    getDeclaredConstructor()
            |
            v
    setAccessible(true)
            |
            v
    newInstance()
            |
            v
    another object

Therefore traditional Singleton implementations can be challenged through reflection.

---

# 39. Enum and Reflection

Enum Singleton is much more resistant to reflective construction because enum constants are specially managed by Java.

This is one of the major strengths of Enum Singleton.

---

# 40. Serialization Can Break Singleton

Consider:

    public class Singleton
            implements Serializable {

        private static final Singleton INSTANCE =
                new Singleton();

        private Singleton() {
        }

        public static Singleton getInstance() {
            return INSTANCE;
        }
    }

Suppose we serialize the Singleton.

Conceptually:

    Singleton
        |
        v
    Serialization
        |
        v
    Bytes

Then:

    Bytes
        |
        v
    Deserialization
        |
        v
    Object

Without special handling, deserialization can result in a different object identity.

Therefore:

    singleton1 == singleton2

may become:

    false

---

# 41. readResolve()

To preserve Singleton identity during Java serialization, use:

    private Object readResolve() {
        return INSTANCE;
    }

Complete example:

    public class Singleton
            implements Serializable {

        private static final Singleton INSTANCE =
                new Singleton();

        private Singleton() {
        }

        public static Singleton getInstance() {
            return INSTANCE;
        }

        private Object readResolve() {
            return INSTANCE;
        }
    }

During deserialization:

    Deserialization
          |
          v
    readResolve()
          |
          v
    existing INSTANCE returned

---

# 42. Cloning Can Break Singleton

Suppose Singleton supports cloning.

    Singleton s1 =
            Singleton.getInstance();

    Singleton s2 =
            s1.clone();

Potentially:

    s1 ---> Object #1

    s2 ---> Object #2

Therefore:

    s1 == s2

can become:

    false

---

# 43. Preventing Cloning

Override clone():

    @Override
    protected Object clone()
            throws CloneNotSupportedException {

        throw new CloneNotSupportedException(
                "Singleton cannot be cloned"
        );
    }

This prevents cloning from producing another Singleton object.

---

# 44. Singleton Attack Summary

Traditional Singleton can be challenged through:

    Singleton
       |
       +-------------------+
       |                   |
       v                   v
    Reflection        Serialization
       |                   |
       v                   v
    Constructor         New object
    bypass              identity
       |
       v
    Another instance

Another attack:

    Singleton
       |
       v
    Cloning
       |
       v
    Copied object

Common defenses:

    Reflection
        |
        v
    Enum Singleton

    Serialization
        |
        v
    readResolve()

    Cloning
        |
        v
    Prevent clone()

---

# 45. Singleton vs Static Utility Class

Singleton and static utility classes are often confused.

Singleton represents an actual object.

Example:

    Singleton singleton =
            Singleton.getInstance();

A Singleton can:

- Have instance state.
- Implement interfaces.
- Be passed as a dependency.
- Participate in polymorphism.
- Be replaced through abstraction.
- Be managed by dependency injection.

A static utility class generally provides stateless utility behavior.

Example:

    public final class MathUtils {

        private MathUtils() {
        }

        public static int add(int a, int b) {
            return a + b;
        }
    }

Usage:

    MathUtils.add(10, 20);

There is normally no meaningful object instance.

---

# 46. Singleton vs Static Utility

    +----------------------+-------------------------+
    | Singleton            | Static Utility         |
    +----------------------+-------------------------+
    | Represents object    | Represents functions   |
    | Can have state       | Usually stateless      |
    | Instance methods     | Static methods         |
    | Can implement        | Not normal instance    |
    | interfaces           | polymorphism           |
    | Can be injected      | Direct static access  |
    | Supports object      | No normal instance     |
    | polymorphism         | polymorphism           |
    +----------------------+-------------------------+

---

# 47. When Should We Use Static Utility?

Good examples:

- MathUtils
- StringUtils
- DateUtils
- FormattingUtils
- ValidationUtils

Example:

    MathUtils.add(10, 20);

There is usually no need to create a separate object for stateless utility behavior.

---

# 48. When Can Singleton Make Sense?

Potential examples:

- Application configuration.
- Connection pool.
- Shared cache.
- Metrics registry.
- Logger registry.
- Resource manager.

But this does NOT mean:

    "Every service should be Singleton."

That is a common design mistake.

---

# 49. Singleton vs Dependency Injection

Consider:

    class OrderService {

        public void placeOrder() {

            PaymentService payment =
                    PaymentService.getInstance();

            payment.pay();
        }
    }

OrderService directly depends on the Singleton.

This creates hidden coupling.

A better design is dependency injection:

    class OrderService {

        private final PaymentService paymentService;

        public OrderService(
                PaymentService paymentService) {

            this.paymentService = paymentService;
        }

        public void placeOrder() {
            paymentService.pay();
        }
    }

Now the dependency is provided from outside.

---

# 50. Why Dependency Injection Is Often Better

With Singleton:

    OrderService
         |
         v
    PaymentService.getInstance()
         |
         v
    Real Payment Service

Testing becomes harder.

With dependency injection:

    OrderService
         |
         v
    PaymentService interface
         ^
         |
    +----+----------------+
    |                     |
    v                     v
RealPaymentService   MockPaymentService

Production:

    new OrderService(
        new RealPaymentService()
    );

Testing:

    new OrderService(
        new MockPaymentService()
    );

This improves:

- Testability.
- Flexibility.
- Decoupling.
- Substitutability.

---

# 51. Global State Problem

Singleton often becomes global state.

Example:

    AppConfig.getInstance()
            .setEnvironment("PROD");

Any part of the application can potentially access it.

Conceptually:

    Service A ----\
    Service B -----\
    Service C ------> Global Singleton State
    Service D -----/
    Service E ----/

This can create hidden dependencies.

---

# 52. Why Global State Is Dangerous

Suppose:

    Config.getInstance()
          .setEnvironment("TEST");

Some unrelated service later reads:

    Config.getInstance()
          .getEnvironment();

The behavior now depends on who modified the Singleton earlier.

This makes the application harder to reason about.

---

# 53. Singleton and Testing

Consider:

    class UserService {

        public void createUser() {

            DatabaseManager
                    .getInstance()
                    .save();
        }
    }

Testing UserService is now coupled to the actual DatabaseManager Singleton.

With dependency injection:

    class UserService {

        private final DatabaseManager databaseManager;

        public UserService(
                DatabaseManager databaseManager) {

            this.databaseManager =
                    databaseManager;
        }
    }

Testing can provide a fake implementation.

---

# 54. Singleton and ClassLoaders

An advanced but important concept:

A Singleton is generally:

    One instance per class-loader-defined class.

It is not necessarily:

    Exactly one object across every possible class loader.

Conceptually:

    JVM
    |
    +---- ClassLoader A
    |        |
    |        +---- Singleton ---> Object #1
    |
    +---- ClassLoader B
             |
             +---- Singleton ---> Object #2

Therefore:

    Object #1 != Object #2

This can matter in:

- Application servers.
- Plugin systems.
- Containers.
- Modular applications.
- Systems using multiple class loaders.

---

# 55. Real LLD Example: Application Configuration

Suppose a banking application has:

    ApplicationConfig

with:

    applicationName = BankingApp
    environment     = PROD
    version         = 1.0

Many components need the same configuration.

Conceptually:

                    ApplicationConfig
                           |
                 +---------+---------+
                 |                   |
                 v                   v
            OrderService        UserService
                 |                   |
                 +---------+---------+
                           |
                           v
                      Same Config

A single shared configuration object may be reasonable.

However, in modern applications, a dependency injection container often manages singleton-scoped objects instead of manually implementing:

    ApplicationConfig.getInstance();

---

# 56. Real ApplicationConfig Singleton

    public class ApplicationConfig {

        private final String applicationName;
        private final String environment;
        private final String version;

        private ApplicationConfig() {

            applicationName = "BankingApp";
            environment = "PROD";
            version = "1.0";
        }

        private static class Holder {

            private static final ApplicationConfig INSTANCE =
                    new ApplicationConfig();
        }

        public static ApplicationConfig getInstance() {
            return Holder.INSTANCE;
        }

        public String getApplicationName() {
            return applicationName;
        }

        public String getEnvironment() {
            return environment;
        }

        public String getVersion() {
            return version;
        }

        public void printConfig() {

            System.out.println(
                    "Application: " +
                    applicationName
            );

            System.out.println(
                    "Environment: " +
                    environment
            );

            System.out.println(
                    "Version: " +
                    version
            );
        }
    }

Client:

    public class ConfigClient {

        public static void main(String[] args) {

            ApplicationConfig config =
                    ApplicationConfig.getInstance();

            config.printConfig();
        }
    }

Output:

    Application: BankingApp
    Environment: PROD
    Version: 1.0

---

# 57. Testing Singleton With Multiple Threads

We can use ExecutorService.

Example:

    ExecutorService executor =
            Executors.newFixedThreadPool(10);

    for (int i = 0; i < 20; i++) {

        executor.submit(() -> {

            ApplicationConfig config =
                    ApplicationConfig.getInstance();

            System.out.println(
                    Thread.currentThread().getName()
                            + " -> "
                            + System.identityHashCode(config)
            );
        });
    }

    executor.shutdown();

Expected behavior:

    pool-1-thread-1 -> 12345678
    pool-1-thread-2 -> 12345678
    pool-1-thread-3 -> 12345678
    pool-1-thread-4 -> 12345678

The actual number does not matter.

The important point is that all threads should observe the same object identity.

---

# 58. Singleton Creation Safety vs State Safety

This distinction deserves repetition.

Suppose:

    public class CounterSingleton {

        private int count;

        public void increment() {
            count++;
        }
    }

There are two questions.

Question 1:

    Will there be only one CounterSingleton object?

Question 2:

    Can multiple threads safely execute count++?

The answer to Question 1 can be YES.

The answer to Question 2 can still be NO.

Therefore:

    Singleton creation safety
            !=
    Singleton state safety

If the state must be thread-safe, additional synchronization or concurrency primitives may be required.

---

# 59. Common Singleton Mistakes

## Mistake 1: Public Constructor

Wrong:

    public Singleton() {
    }

This allows:

    new Singleton();

---

## Mistake 2: Non-static Instance

Wrong:

    private Singleton instance;

The instance should generally be class-level:

    private static Singleton instance;

---

## Mistake 3: Basic Lazy Singleton in Concurrent Code

Wrong for concurrent use:

    if (instance == null) {
        instance = new Singleton();
    }

Multiple threads can race.

---

## Mistake 4: Assuming Singleton Means Thread-Safe State

Wrong assumption:

    "Only one object exists, therefore all methods are thread-safe."

Not true.

---

## Mistake 5: Incorrect Double-Checked Locking

Incorrect:

    private static Singleton instance;

    public static Singleton getInstance() {

        if (instance == null) {

            synchronized (Singleton.class) {

                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }

        return instance;
    }

The traditional DCL implementation requires:

    private static volatile Singleton instance;

---

## Mistake 6: Making Every Service Singleton

Not every service needs one instance.

---

## Mistake 7: Excessive Global Mutable State

A Singleton with lots of mutable global state can become difficult to reason about.

---

## Mistake 8: Ignoring Testability

Singleton can introduce hidden dependencies and make unit testing harder.

---

## Mistake 9: Using Singleton When DI Is Better

Modern dependency injection frameworks can manage object lifecycles and singleton scope for you.

---

# 60. Singleton Decision Tree

When deciding whether to use Singleton:

    Do I need exactly one logical instance?
                    |
                   NO
                    |
                    v
             Don't use Singleton

                   YES
                    |
                    v
        Is it just stateless utility behavior?
                    |
              +-----+-----+
              |           |
             YES          NO
              |           |
              v           v
        Static Utility   Continue
                          |
                          v
              Can DI manage its lifecycle?
                          |
                    +-----+-----+
                    |           |
                   YES          NO
                    |           |
                    v           v
               Prefer DI    Singleton

If Singleton is justified, consider:

    Do I need lazy creation?
             |
            YES
             |
             v
        Holder / DCL

If serialization is involved:

    Add readResolve()

If cloning is possible:

    Prevent clone()

If a concise Java-specific implementation is desired:

    Consider Enum Singleton

---

# 61. Singleton Implementation Decision Guide

If simplicity is the priority and eager creation is acceptable:

    Use Eager Initialization.

If lazy creation is required and you want a clean manual implementation:

    Use Holder Idiom.

If you want to understand the classic concurrency approach:

    Learn Double-Checked Locking + volatile.

If you want a concise and robust Java-specific Singleton:

    Consider Enum Singleton.

If the application already uses Dependency Injection:

    Prefer DI-managed singleton scope over manually coded Singleton whenever appropriate.

---

# 62. Practice Structure

Our learning approach is:

    One Part
        |
        v
    Concepts
        |
        v
    Multiple Examples
        |
        v
    Practice Problem
        |
        v
    User Attempts
        |
        v
    Reference Solution
        |
        v
    Discussion
        |
        v
    Part Complete

Every practice should clearly mention where the file needs to be created.

---

# 63. Practice 1: Basic Singleton

Location:

    designPatterns/src/practice/singleton/part1/

Create:

    Singleton.java
    Client.java

Requirements:

1. Create a Singleton.
2. Make the constructor private.
3. Create a static instance.
4. Create getInstance().
5. Obtain the object twice.
6. Compare both references using ==.

Expected:

    true

Reference implementation:

    public class Singleton {

        private static Singleton instance;

        private Singleton() {
        }

        public static Singleton getInstance() {

            if (instance == null) {
                instance = new Singleton();
            }

            return instance;
        }
    }

Client:

    public class Client {

        public static void main(String[] args) {

            Singleton s1 = Singleton.getInstance();
            Singleton s2 = Singleton.getInstance();

            System.out.println(s1 == s2);
        }
    }

---

# 64. Practice 2: Eager Singleton

Location:

    designPatterns/src/practice/singleton/part2/

Create:

    EagerSingleton.java
    Client.java

Requirements:

1. Use eager initialization.
2. Make the constructor private.
3. Store the instance in a static final field.
4. Return the same instance.
5. Verify identity.

Reference:

    public class EagerSingleton {

        private static final EagerSingleton INSTANCE =
                new EagerSingleton();

        private EagerSingleton() {
        }

        public static EagerSingleton getInstance() {
            return INSTANCE;
        }
    }

---

# 65. Practice 3: Thread-Safe Singleton

Location:

    designPatterns/src/practice/singleton/part3/

Create:

    ThreadSafeSingleton.java
    Client.java

Requirements:

1. Use lazy initialization.
2. Make it thread-safe.
3. Use synchronized.
4. Run multiple threads.
5. Print identityHashCode().
6. Verify all threads receive the same object.

Reference:

    public class ThreadSafeSingleton {

        private static ThreadSafeSingleton instance;

        private ThreadSafeSingleton() {
        }

        public static synchronized ThreadSafeSingleton getInstance() {

            if (instance == null) {
                instance = new ThreadSafeSingleton();
            }

            return instance;
        }
    }

---

# 66. Practice 4: Double-Checked Locking

Location:

    designPatterns/src/practice/singleton/part3/

Create:

    DoubleCheckedSingleton.java
    Client.java

Requirements:

1. Use lazy initialization.
2. Use synchronized block.
3. Use two null checks.
4. Use volatile.
5. Test with multiple threads.

Reference:

    public class DoubleCheckedSingleton {

        private static volatile DoubleCheckedSingleton instance;

        private DoubleCheckedSingleton() {
        }

        public static DoubleCheckedSingleton getInstance() {

            if (instance == null) {

                synchronized (DoubleCheckedSingleton.class) {

                    if (instance == null) {

                        instance =
                                new DoubleCheckedSingleton();
                    }
                }
            }

            return instance;
        }
    }

---

# 67. Practice 5: Holder Singleton

Location:

    designPatterns/src/practice/singleton/part3/

Create:

    HolderSingleton.java
    Client.java

Requirements:

1. Use lazy initialization.
2. Do not use synchronized.
3. Do not use volatile.
4. Use a static nested Holder class.
5. Verify thread safety.

Reference:

    public class HolderSingleton {

        private HolderSingleton() {
        }

        private static class Holder {

            private static final HolderSingleton INSTANCE =
                    new HolderSingleton();
        }

        public static HolderSingleton getInstance() {
            return Holder.INSTANCE;
        }
    }

---

# 68. Practice 6: Enum Singleton

Location:

    designPatterns/src/practice/singleton/part3/

Create:

    EnumSingleton.java
    Client.java

Reference:

    public enum EnumSingleton {

        INSTANCE;

        public void execute() {
            System.out.println(
                    "Executing Singleton operation"
            );
        }
    }

Client:

    public class Client {

        public static void main(String[] args) {

            EnumSingleton singleton =
                    EnumSingleton.INSTANCE;

            singleton.execute();
        }
    }

---

# 69. Practice 7: Reflection Attack

Location:

    designPatterns/src/practice/singleton/part4/practice1/

Create:

    Singleton.java
    Client.java

Requirements:

1. Create a traditional Singleton.
2. Get the instance normally.
3. Obtain the private constructor using reflection.
4. Call setAccessible(true).
5. Create another instance.
6. Compare both objects.

Expected observation:

    singleton1 == singleton2

can be:

    false

The purpose is to understand how reflection can bypass a traditional private constructor.

---

# 70. Practice 8: Serialization

Location:

    designPatterns/src/practice/singleton/part4/practice2/

Create:

    SerializableSingleton.java
    Client.java

Requirements:

1. Implement Serializable.
2. Obtain Singleton.
3. Serialize it.
4. Deserialize it.
5. Compare identities.
6. Add readResolve().
7. Run again.
8. Verify identity.

Expected final result:

    true

Reference:

    private Object readResolve() {
        return INSTANCE;
    }

---

# 71. Practice 9: Cloning

Location:

    designPatterns/src/practice/singleton/part4/practice3/

Create:

    CloneSafeSingleton.java
    Client.java

Requirements:

1. Create a Singleton.
2. Attempt cloning.
3. Understand how a new object can be produced.
4. Override clone().
5. Prevent cloning.

Reference:

    @Override
    protected Object clone()
            throws CloneNotSupportedException {

        throw new CloneNotSupportedException(
                "Singleton cannot be cloned"
        );
    }

---

# 72. Practice 10: Singleton or Static Utility?

Location:

    designPatterns/src/practice/singleton/part4/practice4/

Decide whether each should be Singleton or Static Utility:

    StringUtils
    ApplicationConfiguration
    PaymentProcessor
    DateUtils
    ConnectionPool
    MathUtils

Possible reasoning:

    StringUtils
        -> Static Utility

    ApplicationConfiguration
        -> Singleton / DI-managed shared object

    PaymentProcessor
        -> Usually not Singleton by default

    DateUtils
        -> Static Utility

    ConnectionPool
        -> Shared resource may justify one managed instance

    MathUtils
        -> Static Utility

The important lesson is not memorizing the answers.

Ask:

    "Does this represent a uniquely shared object/resource,
     or is it simply utility behavior?"

---

# 73. Practice 11: Refactor Singleton to Dependency Injection

Location:

    designPatterns/src/practice/singleton/part4/practice5/

Create:

    PaymentService.java
    RealPaymentService.java
    MockPaymentService.java
    OrderService.java
    Client.java

Initial design:

    class OrderService {

        public void placeOrder() {

            PaymentService payment =
                    PaymentService.getInstance();

            payment.pay();
        }
    }

Refactor to:

    class OrderService {

        private final PaymentService paymentService;

        public OrderService(
                PaymentService paymentService) {

            this.paymentService = paymentService;
        }

        public void placeOrder() {
            paymentService.pay();
        }
    }

Goal:

    Production
        |
        v
    RealPaymentService

    Testing
        |
        v
    MockPaymentService

This demonstrates why explicit dependencies are generally easier to test.

---

# 74. Practice 12: Real-World Singleton

Location:

    designPatterns/src/practice/singleton/part4/practice6/

Create:

    ApplicationConfig.java
    ConfigClient.java

Requirements:

- Exactly one logical instance.
- Lazy initialization.
- Thread-safe.
- Holder idiom.
- Store applicationName.
- Store environment.
- Store version.
- Provide getters.
- Provide printConfig().
- Access from multiple threads.
- Print System.identityHashCode().
- Verify all threads receive the same object.

Example state:

    applicationName = BankingApp
    environment     = PROD
    version         = 1.0

Expected behavior:

    All threads should print the same identity hash code.

Reference:

    public class ApplicationConfig {

        private final String applicationName;
        private final String environment;
        private final String version;

        private ApplicationConfig() {

            applicationName = "BankingApp";
            environment = "PROD";
            version = "1.0";
        }

        private static class Holder {

            private static final ApplicationConfig INSTANCE =
                    new ApplicationConfig();
        }

        public static ApplicationConfig getInstance() {
            return Holder.INSTANCE;
        }

        public String getApplicationName() {
            return applicationName;
        }

        public String getEnvironment() {
            return environment;
        }

        public String getVersion() {
            return version;
        }

        public void printConfig() {

            System.out.println(
                    "Application: " +
                    applicationName
            );

            System.out.println(
                    "Environment: " +
                    environment
            );

            System.out.println(
                    "Version: " +
                    version
            );
        }
    }

---

# 75. Practice 13: Multi-Threaded Verification

Location:

    designPatterns/src/practice/singleton/part4/practice6/

Use ExecutorService.

Example:

    ExecutorService executor =
            Executors.newFixedThreadPool(10);

    for (int i = 0; i < 20; i++) {

        executor.submit(() -> {

            ApplicationConfig config =
                    ApplicationConfig.getInstance();

            System.out.println(
                    Thread.currentThread().getName()
                            + " -> "
                            + System.identityHashCode(config)
            );
        });
    }

    executor.shutdown();

Expected behavior:

    pool-1-thread-1 -> 12345678
    pool-1-thread-2 -> 12345678
    pool-1-thread-3 -> 12345678
    pool-1-thread-4 -> 12345678

The actual number will differ.

All identity hash codes should represent the same object.

---

# 76. Interview Questions

## Question 1

What is Singleton?

Answer:

Singleton is a Creational Design Pattern that ensures a class has only one logical instance and provides a global access point to that instance.

---

## Question 2

Why is the constructor private?

Answer:

The private constructor prevents external code from directly creating objects using new.

---

## Question 3

Why is the instance static?

Answer:

The instance belongs to the class rather than an individual object, allowing it to be accessed without creating another instance.

---

## Question 4

Why is getInstance() static?

Answer:

Clients need to obtain the Singleton before they have a Singleton object, so a class-level access method is required.

---

## Question 5

Is basic lazy Singleton thread-safe?

Answer:

No.

Two threads can simultaneously observe instance == null and create two objects.

---

## Question 6

How can Singleton be made thread-safe?

Common approaches:

1. Synchronized method.
2. Double-Checked Locking with volatile.
3. Initialization-on-Demand Holder.
4. Enum Singleton.

---

## Question 7

Why is volatile required in Double-Checked Locking?

Answer:

volatile provides the required memory visibility and ordering guarantees so that threads do not observe an improperly published Singleton object.

---

## Question 8

Why are there two null checks in DCL?

Answer:

The first check avoids synchronization when the Singleton already exists.

The second check prevents another thread from creating another object after the current thread acquires the lock.

---

## Question 9

What is the Holder idiom?

Answer:

The Holder idiom uses a static nested class whose initialization is triggered only when the Singleton is requested.

Example:

    private static class Holder {

        private static final Singleton INSTANCE =
                new Singleton();
    }

Java class initialization provides the thread-safety.

---

## Question 10

Can reflection break Singleton?

Answer:

Yes.

Traditional Singleton constructors can potentially be accessed through reflection.

Enum Singleton provides stronger protection against reflective construction of enum constants.

---

## Question 11

Can serialization break Singleton?

Answer:

Yes.

Deserialization can create a different object identity.

For Serializable Singleton, use:

    private Object readResolve() {
        return INSTANCE;
    }

---

## Question 12

Can cloning break Singleton?

Answer:

Yes.

If cloning is allowed, a new object can potentially be created.

Override clone() and prevent cloning when necessary.

---

## Question 13

Singleton vs Static Utility?

Answer:

Singleton represents an actual object and can have state, implement interfaces, and participate in dependency injection.

A static utility class generally provides stateless utility behavior through static methods.

---

## Question 14

Is Singleton an anti-pattern?

Answer:

Not automatically.

Singleton can be appropriate when exactly one logical shared instance is a genuine requirement.

It becomes problematic when used unnecessarily and creates:

- Global mutable state.
- Hidden dependencies.
- Tight coupling.
- Testing difficulties.
- Poor flexibility.

---

## Question 15

Singleton vs Dependency Injection?

Answer:

Singleton:

    PaymentService.getInstance();

The class directly asks for its dependency.

Dependency Injection:

    new OrderService(paymentService);

The dependency is provided externally.

DI generally improves:

- Testability.
- Decoupling.
- Flexibility.
- Substitutability.

---

## Question 16

Is Singleton one object per JVM?

Answer:

Not necessarily.

In environments with multiple class loaders, there can be one instance per class-loader-defined class.

A more accurate statement is:

    One Singleton instance per class-loader-defined Singleton class.

---

## Question 17

Does Singleton make methods thread-safe?

Answer:

No.

Singleton controls object creation and identity.

It does not automatically make mutable state thread-safe.

For example:

    count++;

can still have race conditions.

---

# 77. Important Singleton Mental Model

Do not memorize Singleton merely as:

    private static Singleton instance;

    private Singleton() {
    }

    public static Singleton getInstance() {
        return instance;
    }

Instead remember the complete design problem:

                        SINGLETON
                            |
                            v
                  One logical instance
                            |
                            v
                    Global access point
                            |
            +---------------+---------------+
            |               |               |
            v               v               v
        Creation       Concurrency      Robustness
            |               |               |
            |               |               +--> Reflection
            |               |               +--> Serialization
            |               |               +--> Cloning
            |               |               +--> Enum
            |               |
            |               +--> synchronized
            |               +--> volatile
            |               +--> Holder
            |
            +--> Eager
            +--> Lazy
            +--> DCL
            +--> Holder
            +--> Enum
                            |
                            v
                         Design
                            |
              +-------------+-------------+
              |                           |
              v                           v
         Singleton                        DI
              |
              v
       Use only when
       logically justified

---

# 78. Most Important Rules

Rule 1:

Singleton means ONE LOGICAL INSTANCE.

Rule 2:

A private constructor prevents normal external construction.

Rule 3:

Basic lazy Singleton is not thread-safe.

Rule 4:

Double-Checked Locking requires volatile.

Rule 5:

The Holder idiom provides clean lazy initialization.

Rule 6:

Enum is a powerful Singleton implementation.

Rule 7:

Singleton creation safety is different from Singleton state safety.

Rule 8:

Reflection can challenge traditional Singleton.

Rule 9:

Serialization requires readResolve() when using a Serializable Singleton.

Rule 10:

Cloning can create another object and should be prevented when necessary.

Rule 11:

Singleton introduces global access.

Rule 12:

Global mutable state can create hidden coupling.

Rule 13:

Do not make every service a Singleton.

Rule 14:

Singleton should be used because the domain/application requires one shared instance.

Rule 15:

Always consider whether dependency injection should manage the lifecycle instead.

---

# 79. Final Singleton Checklist

Fundamentals:

    [x] Understand Creational Design Patterns
    [x] Understand Singleton intent
    [x] Understand one logical instance
    [x] Understand global access point
    [x] Understand private constructor
    [x] Understand static instance
    [x] Understand static getInstance()
    [x] Understand object identity

Initialization:

    [x] Eager initialization
    [x] Lazy initialization
    [x] Advantages of eager initialization
    [x] Disadvantages of eager initialization
    [x] Advantages of lazy initialization
    [x] Basic lazy Singleton limitations

Concurrency:

    [x] Race condition
    [x] Thread-safe creation
    [x] synchronized method
    [x] Synchronization overhead
    [x] Double-Checked Locking
    [x] First null check
    [x] Second null check
    [x] volatile
    [x] Initialization-on-Demand Holder
    [x] JVM class initialization

Alternative Implementation:

    [x] Enum Singleton
    [x] Enum Singleton advantages
    [x] Enum Singleton limitations

Breaking Singleton:

    [x] Reflection
    [x] Serialization
    [x] readResolve()
    [x] Cloning
    [x] clone prevention
    [x] ClassLoader consideration

Design:

    [x] Singleton vs Static Utility
    [x] Singleton vs Dependency Injection
    [x] Global state
    [x] Hidden dependencies
    [x] Testability
    [x] Mutable Singleton state
    [x] ClassLoader behavior
    [x] When to use Singleton
    [x] When not to use Singleton
    [x] DI-managed Singleton

Practice:

    [x] Basic Singleton
    [x] Eager Singleton
    [x] Thread-safe Singleton
    [x] Double-Checked Locking
    [x] Holder Singleton
    [x] Enum Singleton
    [x] Reflection attack
    [x] Serialization
    [x] Cloning
    [x] Singleton vs Utility
    [x] Refactoring Singleton to DI
    [x] Real-world ApplicationConfig
    [x] Multi-threaded Singleton verification

---


# 80. Final Takeaway

The Singleton Pattern is fundamentally about controlling object identity.

The basic requirement is:

    Multiple clients
          |
          v
    Same logical instance

But learning Singleton properly requires understanding much more than the basic implementation.

The complete mental model is:

    Singleton
       |
       +--> Private Constructor
       |
       +--> Static Instance
       |
       +--> Global Access Point
       |
       +--> Eager Initialization
       |
       +--> Lazy Initialization
       |
       +--> Thread Safety
       |       |
       |       +--> synchronized
       |       +--> volatile
       |       +--> Double-Checked Locking
       |       +--> Holder
       |
       +--> Enum Singleton
       |
       +--> Reflection
       |
       +--> Serialization
       |       |
       |       +--> readResolve()
       |
       +--> Cloning
       |
       +--> Global State
       |
       +--> Testability
       |
       +--> Dependency Injection
       |
       +--> ClassLoaders
       |
       +--> LLD Design Decisions

The most important principle is:

    Do not use Singleton simply because
    "I want only one object."

Instead ask:

    "Does the system logically require exactly
     one shared instance?"

If yes, Singleton may be appropriate.

If the object lifecycle can be managed by Dependency Injection, prefer explicit dependencies and DI-managed lifecycle where appropriate.

---

# End of Singleton Design Pattern