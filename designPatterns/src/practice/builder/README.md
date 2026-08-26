# Builder Design Pattern — Complete Guide

> Complete learning documentation for the Builder Design Pattern in Java.
>
> This README covers everything across Builder pattern:
>
> - Why Builder Pattern exists
> - The problem with constructors
> - Telescoping constructors
> - JavaBeans/setter approach
> - Basic Builder Pattern
> - Method chaining
> - Nested Builder
> - Static `builder()` method
> - Immutable objects
> - Required and optional fields
> - Validation
> - Default values
> - Defensive copying
> - Collections in Builder
> - Complex objects
> - Director
> - Builder vs Director
> - Step Builder
> - Compile-time construction constraints
> - Builder vs Constructor
> - Builder vs Factory
> - Builder vs Prototype
> - When Builder is useful
> - When Builder is overengineering
> - Complete examples
> - Complete solutions
> - LLD/interview perspective
>
> ------------------------------------------------------------------------------

# 1. What is the Builder Design Pattern?

The Builder Design Pattern is a **creational design pattern** used to construct complex objects step by step.

Instead of passing a large number of parameters directly to a constructor, we create an intermediate `Builder` object, configure it, and finally call `build()`.

The basic idea is:

    Client
       |
       v
    Builder
       |
       | configure
       v
    build()
       |
       v
    Product

Example:

    Car car = Car.builder()
            .setBrand("Toyota")
            .setModel("Camry")
            .setEngine("2.5L")
            .setColor("Black")
            .setAutomatic(true)
            .build();

The Builder is responsible for collecting all the configuration required to create the final object.

The final object is generally immutable.

------------------------------------------------------------------------------

# 2. Why Do We Need Builder Pattern?

Consider a class:

    public class User {

        private String name;
        private int age;
        private String email;
        private String phone;
        private String address;
        private String city;
        private String country;
        private boolean active;
        private String role;

    }

Suppose we create it using a constructor:

    User user = new User(
            "Shivraj",
            27,
            "shivraj@gmail.com",
            "9999999999",
            "Bangalore",
            "Bangalore",
            "India",
            true,
            "ADMIN"
    );

There are several problems.

## Problem 1 — Readability

What does this mean?

    new User(
        "Shivraj",
        27,
        "shivraj@gmail.com",
        "9999999999",
        "Bangalore",
        "Bangalore",
        "India",
        true,
        "ADMIN"
    );

The caller has to remember the parameter order.

------------------------------------------------------------------------------

# 3. Problem with Parameter Order

Suppose the constructor is:

    public User(
            String name,
            int age,
            String email,
            String phone
    )

Now imagine:

    new User(
        "Shivraj",
        27,
        "shivraj@gmail.com",
        "9999999999"
    );

This works.

But when there are many parameters, mistakes become very easy.

For example:

    new User(
        "Shivraj",
        27,
        "9999999999",
        "shivraj@gmail.com"
    );

The code may still compile if both parameters are `String`.

The compiler cannot understand that the email and phone were swapped.

------------------------------------------------------------------------------

# 4. Telescoping Constructor Problem

Another approach is to create multiple constructors.

Example:

    public class User {

        public User(String name) {
            ...
        }

        public User(String name, int age) {
            ...
        }

        public User(
                String name,
                int age,
                String email
        ) {
            ...
        }

        public User(
                String name,
                int age,
                String email,
                String phone
        ) {
            ...
        }

    }

This is called the **Telescoping Constructor Pattern**.

It becomes ugly as the number of optional parameters increases.

For example:

    User()
    User(name)
    User(name, age)
    User(name, age, email)
    User(name, age, email, phone)
    User(name, age, email, phone, address)
    ...

The number of constructors grows quickly.

------------------------------------------------------------------------------

# 5. Setter-Based Approach

Another approach is:

    User user = new User();

    user.setName("Shivraj");
    user.setAge(27);
    user.setEmail("shivraj@gmail.com");
    user.setPhone("9999999999");

This solves some readability problems.

But it introduces another major problem:

The object is mutable.

The caller can do:

    user.setAge(100);

after construction.

That may violate the object's invariants.

------------------------------------------------------------------------------

# 6. Builder Solves These Problems

Builder gives us:

    User user = User.builder()
            .setName("Shivraj")
            .setAge(27)
            .setEmail("shivraj@gmail.com")
            .setPhone("9999999999")
            .build();

Now the code is self-documenting.

The method names tell us what each value means.

------------------------------------------------------------------------------

# 7. Builder Pattern Classification

Builder is a:

    Creational Design Pattern

Creational patterns deal with:

    How objects are created.

Other creational patterns include:

    Singleton
    Factory
    Abstract Factory
    Prototype
    Builder

------------------------------------------------------------------------------

# 8. Basic Builder Structure

The basic structure is:

    Client
       |
       v
    Builder
       |
       | configuration
       v
    build()
       |
       v
    Product

The Builder generally contains:

    - fields corresponding to the Product
    - setter-like methods
    - validation
    - build() method

------------------------------------------------------------------------------

# 9. Basic Builder Example

Create:

    designPatterns/src/practice/builder/part1/User.java

Code:

    package practice.builder.part1;

    public class User {

        private String name;
        private int age;
        private String email;

        public User(
                String name,
                int age,
                String email
        ) {
            this.name = name;
            this.age = age;
            this.email = email;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        public String getEmail() {
            return email;
        }
    }

------------------------------------------------------------------------------

# 10. External Builder Class

Create:

    designPatterns/src/practice/builder/part1/UserBuilder.java

Code:

    package practice.builder.part1;

    public class UserBuilder {

        private String name;
        private int age;
        private String email;

        public UserBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder setAge(int age) {
            this.age = age;
            return this;
        }

        public UserBuilder setEmail(String email) {
            this.email = email;
            return this;
        }

        public User build() {
            return new User(
                    name,
                    age,
                    email
            );
        }
    }

------------------------------------------------------------------------------

# 11. Client

Create:

    designPatterns/src/practice/builder/part1/Client.java

Code:

    package practice.builder.part1;

    public class Client {

        public static void main(String[] args) {

            User user = new UserBuilder()
                    .setName("Shivraj")
                    .setAge(27)
                    .setEmail("shivraj@gmail.com")
                    .build();

            System.out.println(user.getName());
            System.out.println(user.getAge());
            System.out.println(user.getEmail());
        }
    }

The construction now becomes:

    UserBuilder
        |
        +-- setName()
        |
        +-- setAge()
        |
        +-- setEmail()
        |
        +-- build()
              |
              v
             User

------------------------------------------------------------------------------

# 12. Method Chaining

One important Builder concept is method chaining.

Consider:

    public UserBuilder setName(String name) {
        this.name = name;
        return this;
    }

Why return `this`?

Because `this` represents the current Builder object.

Therefore:

    builder.setName("Shivraj")

returns:

    builder

Then we can call:

    builder.setName("Shivraj")
           .setAge(27)

Then:

    builder.setName("Shivraj")
           .setAge(27)
           .setEmail("shivraj@gmail.com")

Finally:

    builder.setName("Shivraj")
           .setAge(27)
           .setEmail("shivraj@gmail.com")
           .build();

This is called:

    Method Chaining

------------------------------------------------------------------------------

# 13. Computer Example

Create:

    designPatterns/src/practice/builder/part1/Computer.java

Code:

    package practice.builder.part1;

    public class Computer {

        private String brand;
        private String processor;
        private int ram;
        private int storage;
        private String gpu;
        private boolean wifi;
        private boolean bluetooth;

        public Computer(
                String brand,
                String processor,
                int ram,
                int storage,
                String gpu,
                boolean wifi,
                boolean bluetooth
        ) {
            this.brand = brand;
            this.processor = processor;
            this.ram = ram;
            this.storage = storage;
            this.gpu = gpu;
            this.wifi = wifi;
            this.bluetooth = bluetooth;
        }

        public String getBrand() {
            return brand;
        }

        public String getProcessor() {
            return processor;
        }

        public int getRam() {
            return ram;
        }

        public int getStorage() {
            return storage;
        }

        public String getGpu() {
            return gpu;
        }

        public boolean isWifi() {
            return wifi;
        }

        public boolean isBluetooth() {
            return bluetooth;
        }
    }

------------------------------------------------------------------------------

# 14. ComputerBuilder

Create:

    designPatterns/src/practice/builder/part1/ComputerBuilder.java

Code:

    package practice.builder.part1;

    public class ComputerBuilder {

        private String brand;
        private String processor;
        private int ram;
        private int storage;
        private String gpu;
        private boolean wifi;
        private boolean bluetooth;

        public ComputerBuilder setBrand(String brand) {
            this.brand = brand;
            return this;
        }

        public ComputerBuilder setProcessor(String processor) {
            this.processor = processor;
            return this;
        }

        public ComputerBuilder setRam(int ram) {
            this.ram = ram;
            return this;
        }

        public ComputerBuilder setStorage(int storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setGpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public ComputerBuilder setWifi(boolean wifi) {
            this.wifi = wifi;
            return this;
        }

        public ComputerBuilder setBluetooth(boolean bluetooth) {
            this.bluetooth = bluetooth;
            return this;
        }

        public Computer build() {

            return new Computer(
                    brand,
                    processor,
                    ram,
                    storage,
                    gpu,
                    wifi,
                    bluetooth
            );
        }
    }

------------------------------------------------------------------------------

# 15. Computer Client

Create:

    designPatterns/src/practice/builder/part1/ComputerClient.java

Code:

    package practice.builder.part1;

    public class ComputerClient {

        public static void main(String[] args) {

            Computer computer = new ComputerBuilder()
                    .setBrand("Apple")
                    .setProcessor("M4")
                    .setRam(16)
                    .setStorage(512)
                    .setWifi(true)
                    .setBluetooth(true)
                    .build();

            System.out.println(
                    "Brand: " + computer.getBrand()
            );

            System.out.println(
                    "Processor: " + computer.getProcessor()
            );

            System.out.println(
                    "RAM: " + computer.getRam()
            );

            System.out.println(
                    "Storage: " + computer.getStorage()
            );

            System.out.println(
                    "GPU: " + computer.getGpu()
            );

            System.out.println(
                    "WiFi: " + computer.isWifi()
            );

            System.out.println(
                    "Bluetooth: " + computer.isBluetooth()
            );
        }
    }

------------------------------------------------------------------------------

# 16. Nested Builder

The most common Java implementation puts the Builder inside the Product class.

Instead of:

    User
    UserBuilder

we can have:

    User
      |
      +-- Builder

This keeps the construction logic close to the object being constructed.

------------------------------------------------------------------------------

# 17. Static builder() Method

A common API is:

    Car.builder()
        .setBrand("Toyota")
        .setModel("Camry")
        .build();

The method:

    public static Builder builder() {
        return new Builder();
    }

provides a clean entry point.

Instead of:

    new Car.CarBuilder()

we write:

    Car.builder()

This is more readable.

------------------------------------------------------------------------------

# 18. Immutable Builder Product

One of the strongest reasons to combine Builder with immutability is to create safe objects.

A typical immutable Product has:

    - private final fields
    - no setters
    - private constructor
    - values assigned only during construction

Example:

    public class Car {

        private final String brand;
        private final String model;

        private Car(
                String brand,
                String model
        ) {
            this.brand = brand;
            this.model = model;
        }

    }

The Builder is mutable.

The Product is immutable.

This gives us:

    Builder
       |
       | mutable configuration
       |
       v
    build()
       |
       v
    Immutable Product

------------------------------------------------------------------------------

# 19. Car Example

Create:

    designPatterns/src/practice/builder/part2/Car.java

Code:

    package practice.builder.part2;

    public class Car {

        private final String brand;
        private final String model;
        private final String engine;
        private final String color;
        private final boolean sunroof;
        private final boolean automatic;

        private Car(
                String brand,
                String model,
                String engine,
                String color,
                boolean sunroof,
                boolean automatic
        ) {
            this.brand = brand;
            this.model = model;
            this.engine = engine;
            this.color = color;
            this.sunroof = sunroof;
            this.automatic = automatic;
        }

        public static CarBuilder builder() {
            return new CarBuilder();
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public String getEngine() {
            return engine;
        }

        public String getColor() {
            return color;
        }

        public boolean isSunroof() {
            return sunroof;
        }

        public boolean isAutomatic() {
            return automatic;
        }

        public static class CarBuilder {

            private String brand;
            private String model;
            private String engine;
            private String color;
            private boolean sunroof;
            private boolean automatic;

            public CarBuilder setBrand(String brand) {
                this.brand = brand;
                return this;
            }

            public CarBuilder setModel(String model) {
                this.model = model;
                return this;
            }

            public CarBuilder setEngine(String engine) {
                this.engine = engine;
                return this;
            }

            public CarBuilder setColor(String color) {
                this.color = color;
                return this;
            }

            public CarBuilder setSunroof(boolean sunroof) {
                this.sunroof = sunroof;
                return this;
            }

            public CarBuilder setAutomatic(boolean automatic) {
                this.automatic = automatic;
                return this;
            }

            public Car build() {

                if (brand == null || brand.isBlank()) {
                    throw new IllegalArgumentException(
                            "Brand is required"
                    );
                }

                if (model == null || model.isBlank()) {
                    throw new IllegalArgumentException(
                            "Model is required"
                    );
                }

                if (engine == null || engine.isBlank()) {
                    throw new IllegalArgumentException(
                            "Engine is required"
                    );
                }

                return new Car(
                        brand,
                        model,
                        engine,
                        color,
                        sunroof,
                        automatic
                );
            }
        }
    }

------------------------------------------------------------------------------

# 20. Why is the Constructor Private?

The constructor:

    private Car(...) {
        ...
    }

prevents the client from directly constructing the object using:

    new Car(...)

Instead, the only intended creation path is:

    Car.builder()
        ...
        .build();

This allows the Builder to control:

    - configuration
    - validation
    - defaults
    - object creation

------------------------------------------------------------------------------

# 21. Builder Validation

Validation can be placed inside `build()`.

Example:

    public Car build() {

        if (brand == null || brand.isBlank()) {
            throw new IllegalArgumentException(
                    "Brand is required"
            );
        }

        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException(
                    "Model is required"
            );
        }

        return new Car(
                brand,
                model,
                engine,
                color,
                sunroof,
                automatic
        );
    }

The important idea is:

    configure
       |
       v
    build()
       |
       v
    validate
       |
       v
    create object

------------------------------------------------------------------------------

# 22. Required vs Optional Fields

Builder is particularly useful when an object has:

    Required fields
    +
    Optional fields

Example:

    Car

Required:

    brand
    model
    engine

Optional:

    color
    sunroof
    automatic

The caller can provide only what is required:

    Car car = Car.builder()
            .setBrand("Toyota")
            .setModel("Camry")
            .setEngine("2.5L")
            .build();

Or provide optional values:

    Car car = Car.builder()
            .setBrand("Toyota")
            .setModel("Camry")
            .setEngine("2.5L")
            .setColor("Black")
            .setSunroof(true)
            .setAutomatic(true)
            .build();

------------------------------------------------------------------------------

# 23. Default Values

Builder can provide default values.

Example:

    private String priority = "NORMAL";

Therefore:

    Order.builder()
        .setOrderId("ORD-1")
        .setCustomerId("CUS-1")
        .addItem("Laptop")
        .build();

automatically results in:

    priority = NORMAL

Another example:

    private boolean giftWrap = false;

Therefore the caller doesn't need to explicitly specify:

    setGiftWrap(false)

------------------------------------------------------------------------------

# 24. Laptop Example

Create:

    designPatterns/src/practice/builder/part2/Laptop.java

Code:

    package practice.builder.part2;

    public class Laptop {

        private final String brand;
        private final String model;
        private final String processor;
        private final int ram;
        private final int storage;
        private final String gpu;
        private final double screenSize;
        private final boolean backlit;

        private Laptop(
                String brand,
                String model,
                String processor,
                int ram,
                int storage,
                String gpu,
                double screenSize,
                boolean backlit
        ) {
            this.brand = brand;
            this.model = model;
            this.processor = processor;
            this.ram = ram;
            this.storage = storage;
            this.gpu = gpu;
            this.screenSize = screenSize;
            this.backlit = backlit;
        }

        public static LaptopBuilder builder() {
            return new LaptopBuilder();
        }

        public String getBrand() {
            return brand;
        }

        public String getModel() {
            return model;
        }

        public String getProcessor() {
            return processor;
        }

        public int getRam() {
            return ram;
        }

        public int getStorage() {
            return storage;
        }

        public String getGpu() {
            return gpu;
        }

        public double getScreenSize() {
            return screenSize;
        }

        public boolean isBacklit() {
            return backlit;
        }

        public static class LaptopBuilder {

            private String brand;
            private String model;
            private String processor;
            private int ram;
            private int storage;
            private String gpu;
            private double screenSize;
            private boolean backlit;

            public LaptopBuilder setBrand(String brand) {
                this.brand = brand;
                return this;
            }

            public LaptopBuilder setModel(String model) {
                this.model = model;
                return this;
            }

            public LaptopBuilder setProcessor(String processor) {
                this.processor = processor;
                return this;
            }

            public LaptopBuilder setRam(int ram) {
                this.ram = ram;
                return this;
            }

            public LaptopBuilder setStorage(int storage) {
                this.storage = storage;
                return this;
            }

            public LaptopBuilder setGpu(String gpu) {
                this.gpu = gpu;
                return this;
            }

            public LaptopBuilder setScreenSize(double screenSize) {
                this.screenSize = screenSize;
                return this;
            }

            public LaptopBuilder setBacklit(boolean backlit) {
                this.backlit = backlit;
                return this;
            }

            public Laptop build() {

                if (brand == null || brand.isBlank()) {
                    throw new IllegalArgumentException(
                            "Brand is required"
                    );
                }

                if (model == null || model.isBlank()) {
                    throw new IllegalArgumentException(
                            "Model is required"
                    );
                }

                if (processor == null || processor.isBlank()) {
                    throw new IllegalArgumentException(
                            "Processor is required"
                    );
                }

                if (ram <= 0) {
                    throw new IllegalArgumentException(
                            "RAM must be greater than 0"
                    );
                }

                return new Laptop(
                        brand,
                        model,
                        processor,
                        ram,
                        storage,
                        gpu,
                        screenSize,
                        backlit
                );
            }
        }
    }

------------------------------------------------------------------------------

# 25. Complex Builder Configuration

Builder becomes even more useful when objects contain collections.

Consider an HTTP request.

A request may contain:

    URL
    HTTP method
    headers
    query parameters
    body
    timeout
    retry count
    redirect configuration

Constructor-based creation would become difficult to read.

Builder makes it much cleaner.

------------------------------------------------------------------------------

# 26. HttpRequest Example

Create:

    designPatterns/src/practice/builder/part3/HttpRequest.java

Code:

    package practice.builder.part3;

    import java.util.HashMap;
    import java.util.Map;

    public class HttpRequest {

        private final String url;
        private final String method;
        private final Map<String, String> headers;
        private final String body;
        private final int timeout;
        private final int retryCount;
        private final boolean followRedirects;

        private HttpRequest(
                String url,
                String method,
                Map<String, String> headers,
                String body,
                int timeout,
                int retryCount,
                boolean followRedirects
        ) {
            this.url = url;
            this.method = method;
            this.headers = Map.copyOf(headers);
            this.body = body;
            this.timeout = timeout;
            this.retryCount = retryCount;
            this.followRedirects = followRedirects;
        }

        public static Builder builder() {
            return new Builder();
        }

        public String getUrl() {
            return url;
        }

        public String getMethod() {
            return method;
        }

        public Map<String, String> getHeaders() {
            return headers;
        }

        public String getBody() {
            return body;
        }

        public int getTimeout() {
            return timeout;
        }

        public int getRetryCount() {
            return retryCount;
        }

        public boolean isFollowRedirects() {
            return followRedirects;
        }

        public static class Builder {

            private String url;
            private String method;

            private final Map<String, String> headers =
                    new HashMap<>();

            private String body;

            private int timeout = 3000;

            private int retryCount = 0;

            private boolean followRedirects = true;

            public Builder setUrl(String url) {
                this.url = url;
                return this;
            }

            public Builder setMethod(String method) {
                this.method = method;
                return this;
            }

            public Builder addHeader(
                    String key,
                    String value
            ) {
                this.headers.put(key, value);
                return this;
            }

            public Builder setBody(String body) {
                this.body = body;
                return this;
            }

            public Builder setTimeout(int timeout) {
                this.timeout = timeout;
                return this;
            }

            public Builder setRetryCount(int retryCount) {
                this.retryCount = retryCount;
                return this;
            }

            public Builder setFollowRedirects(
                    boolean followRedirects
            ) {
                this.followRedirects = followRedirects;
                return this;
            }

            public HttpRequest build() {

                if (url == null || url.isBlank()) {
                    throw new IllegalArgumentException(
                            "URL is required"
                    );
                }

                if (method == null || method.isBlank()) {
                    throw new IllegalArgumentException(
                            "HTTP method is required"
                    );
                }

                if (timeout <= 0) {
                    throw new IllegalArgumentException(
                            "Timeout must be greater than 0"
                    );
                }

                if (retryCount < 0) {
                    throw new IllegalArgumentException(
                            "Retry count cannot be negative"
                    );
                }

                return new HttpRequest(
                        url,
                        method,
                        headers,
                        body,
                        timeout,
                        retryCount,
                        followRedirects
                );
            }
        }
    }

------------------------------------------------------------------------------

# 27. HTTP Client

Create:

    designPatterns/src/practice/builder/part3/HttpClient.java

Code:

    package practice.builder.part3;

    public class HttpClient {

        public static void main(String[] args) {

            HttpRequest request = HttpRequest.builder()
                    .setUrl("https://example.com/users")
                    .setMethod("POST")
                    .addHeader(
                            "Content-Type",
                            "application/json"
                    )
                    .addHeader(
                            "Authorization",
                            "Bearer token"
                    )
                    .setBody(
                            "{\"name\":\"Shivraj\"}"
                    )
                    .setTimeout(5000)
                    .setRetryCount(3)
                    .build();

            System.out.println(
                    "URL: " + request.getUrl()
            );

            System.out.println(
                    "Method: " + request.getMethod()
            );

            System.out.println(
                    "Headers: " + request.getHeaders()
            );

            System.out.println(
                    "Body: " + request.getBody()
            );

            System.out.println(
                    "Timeout: " + request.getTimeout()
            );

            System.out.println(
                    "Retry Count: " + request.getRetryCount()
            );

            System.out.println(
                    "Follow Redirects: " +
                    request.isFollowRedirects()
            );
        }
    }

------------------------------------------------------------------------------

# 28. Defensive Copying

This is an important Builder concept.

Suppose Builder contains:

    private final List<String> items =
            new ArrayList<>();

The Builder is mutable.

But the final Product should not expose the mutable Builder list.

Bad:

    this.items = items;

Potential problem:

    builder.addItem("Laptop");

    Order order = builder.build();

    builder.addItem("Mouse");

The Order could accidentally be affected if both references point to the same mutable list.

Instead:

    this.items = List.copyOf(items);

Now the Product receives an immutable copy.

The flow is:

    Builder List
        |
        | mutable
        v
      build()
        |
        | List.copyOf()
        v
    Product List
        |
        | immutable
        v
      Safe

------------------------------------------------------------------------------

# 29. Map.copyOf()

The same principle applies to Maps.

Instead of:

    this.headers = headers;

use:

    this.headers = Map.copyOf(headers);

This protects the Product from external mutation.

------------------------------------------------------------------------------

# 30. Request Example

Create:

    designPatterns/src/practice/builder/part3/Request.java

Code:

    package practice.builder.part3;

    import java.util.HashMap;
    import java.util.Map;

    public class Request {

        private final String url;
        private final String method;
        private final Map<String, String> headers;
        private final Map<String, String> queryParameters;
        private final String body;
        private final int timeout;

        private Request(
                String url,
                String method,
                Map<String, String> headers,
                Map<String, String> queryParameters,
                String body,
                int timeout
        ) {
            this.url = url;
            this.method = method;
            this.headers = Map.copyOf(headers);
            this.queryParameters = Map.copyOf(queryParameters);
            this.body = body;
            this.timeout = timeout;
        }

        public static Builder builder() {
            return new Builder();
        }

        public String getUrl() {
            return url;
        }

        public String getMethod() {
            return method;
        }

        public Map<String, String> getHeaders() {
            return headers;
        }

        public Map<String, String> getQueryParameters() {
            return queryParameters;
        }

        public String getBody() {
            return body;
        }

        public int getTimeout() {
            return timeout;
        }

        public static class Builder {

            private String url;
            private String method;

            private final Map<String, String> headers =
                    new HashMap<>();

            private final Map<String, String> queryParameters =
                    new HashMap<>();

            private String body;

            private int timeout = 3000;

            public Builder setUrl(String url) {
                this.url = url;
                return this;
            }

            public Builder setMethod(String method) {
                this.method = method;
                return this;
            }

            public Builder addHeader(
                    String key,
                    String value
            ) {
                this.headers.put(key, value);
                return this;
            }

            public Builder addQueryParameter(
                    String key,
                    String value
            ) {
                this.queryParameters.put(key, value);
                return this;
            }

            public Builder setBody(String body) {
                this.body = body;
                return this;
            }

            public Builder setTimeout(int timeout) {
                this.timeout = timeout;
                return this;
            }

            public Request build() {

                if (url == null || url.isBlank()) {
                    throw new IllegalArgumentException(
                            "URL is required"
                    );
                }

                if (method == null || method.isBlank()) {
                    throw new IllegalArgumentException(
                            "Method is required"
                    );
                }

                if (timeout <= 0) {
                    throw new IllegalArgumentException(
                            "Timeout must be greater than 0"
                    );
                }

                return new Request(
                        url,
                        method,
                        headers,
                        queryParameters,
                        body,
                        timeout
                );
            }
        }
    }

------------------------------------------------------------------------------

# 31. Notification Example

Create:

    designPatterns/src/practice/builder/part3/Notification.java

Code:

    package practice.builder.part3;

    import java.util.HashMap;
    import java.util.Map;

    public class Notification {

        private final String recipient;
        private final String message;
        private final String title;
        private final String priority;
        private final int retryCount;
        private final String scheduledTime;
        private final String email;
        private final String phone;
        private final boolean pushEnabled;
        private final Map<String, String> metadata;

        private Notification(
                String recipient,
                String message,
                String title,
                String priority,
                int retryCount,
                String scheduledTime,
                String email,
                String phone,
                boolean pushEnabled,
                Map<String, String> metadata
        ) {
            this.recipient = recipient;
            this.message = message;
            this.title = title;
            this.priority = priority;
            this.retryCount = retryCount;
            this.scheduledTime = scheduledTime;
            this.email = email;
            this.phone = phone;
            this.pushEnabled = pushEnabled;
            this.metadata = Map.copyOf(metadata);
        }

        public static Builder builder() {
            return new Builder();
        }

        public String getRecipient() {
            return recipient;
        }

        public String getMessage() {
            return message;
        }

        public String getTitle() {
            return title;
        }

        public String getPriority() {
            return priority;
        }

        public int getRetryCount() {
            return retryCount;
        }

        public String getScheduledTime() {
            return scheduledTime;
        }

        public String getEmail() {
            return email;
        }

        public String getPhone() {
            return phone;
        }

        public boolean isPushEnabled() {
            return pushEnabled;
        }

        public Map<String, String> getMetadata() {
            return metadata;
        }

        public static class Builder {

            private String recipient;
            private String message;
            private String title;

            private String priority = "NORMAL";

            private int retryCount = 0;

            private String scheduledTime;
            private String email;
            private String phone;

            private boolean pushEnabled = false;

            private final Map<String, String> metadata =
                    new HashMap<>();

            public Builder setRecipient(String recipient) {
                this.recipient = recipient;
                return this;
            }

            public Builder setMessage(String message) {
                this.message = message;
                return this;
            }

            public Builder setTitle(String title) {
                this.title = title;
                return this;
            }

            public Builder setPriority(String priority) {
                this.priority = priority;
                return this;
            }

            public Builder setRetryCount(int retryCount) {
                this.retryCount = retryCount;
                return this;
            }

            public Builder setScheduledTime(
                    String scheduledTime
            ) {
                this.scheduledTime = scheduledTime;
                return this;
            }

            public Builder setEmail(String email) {
                this.email = email;
                return this;
            }

            public Builder setPhone(String phone) {
                this.phone = phone;
                return this;
            }

            public Builder setPushEnabled(
                    boolean pushEnabled
            ) {
                this.pushEnabled = pushEnabled;
                return this;
            }

            public Builder addMetadata(
                    String key,
                    String value
            ) {
                this.metadata.put(key, value);
                return this;
            }

            public Notification build() {

                if (recipient == null ||
                        recipient.isBlank()) {

                    throw new IllegalArgumentException(
                            "Recipient is required"
                    );
                }

                if (message == null ||
                        message.isBlank()) {

                    throw new IllegalArgumentException(
                            "Message is required"
                    );
                }

                if (retryCount < 0) {
                    throw new IllegalArgumentException(
                            "Retry count cannot be negative"
                    );
                }

                return new Notification(
                        recipient,
                        message,
                        title,
                        priority,
                        retryCount,
                        scheduledTime,
                        email,
                        phone,
                        pushEnabled,
                        metadata
                );
            }
        }
    }

------------------------------------------------------------------------------

# 32. Director

The traditional Builder Pattern sometimes contains another component:

    Director

The Director is responsible for defining a construction recipe.

The Builder knows:

    HOW to construct individual parts.

The Director knows:

    WHICH parts to construct
    and
    IN WHAT ORDER.

Therefore:

    Builder  -> HOW
    Director -> WHAT SEQUENCE / RECIPE

------------------------------------------------------------------------------

# 33. Director Architecture

    Client
      |
      v
    Director
      |
      v
    Builder
      |
      v
    Product

Example:

    Client
      |
      v
    HouseDirector
      |
      +-- buildFoundation()
      |
      +-- buildWalls()
      |
      +-- buildDoors()
      |
      +-- buildWindows()
      |
      +-- buildRoof()
      |
      +-- build()
      |
      v
    House

------------------------------------------------------------------------------

# 34. House Example

Create:

    designPatterns/src/practice/builder/part4/House.java

Code:

    package practice.builder.part4;

    public class House {

        private final String foundation;
        private final String walls;
        private final String doors;
        private final String windows;
        private final String roof;

        public House(
                String foundation,
                String walls,
                String doors,
                String windows,
                String roof
        ) {
            this.foundation = foundation;
            this.walls = walls;
            this.doors = doors;
            this.windows = windows;
            this.roof = roof;
        }

        public void printDetails() {

            System.out.println(
                    "Foundation: " + foundation
            );

            System.out.println(
                    "Walls: " + walls
            );

            System.out.println(
                    "Doors: " + doors
            );

            System.out.println(
                    "Windows: " + windows
            );

            System.out.println(
                    "Roof: " + roof
            );
        }
    }

------------------------------------------------------------------------------

# 35. HouseBuilder

Create:

    designPatterns/src/practice/builder/part4/HouseBuilder.java

Code:

    package practice.builder.part4;

    public class HouseBuilder {

        private String foundation;
        private String walls;
        private String doors;
        private String windows;
        private String roof;

        public HouseBuilder buildFoundation() {
            foundation = "Concrete Foundation";
            return this;
        }

        public HouseBuilder buildWalls() {
            walls = "Brick Walls";
            return this;
        }

        public HouseBuilder buildDoors() {
            doors = "Wooden Doors";
            return this;
        }

        public HouseBuilder buildWindows() {
            windows = "Glass Windows";
            return this;
        }

        public HouseBuilder buildRoof() {
            roof = "Concrete Roof";
            return this;
        }

        public House build() {

            return new House(
                    foundation,
                    walls,
                    doors,
                    windows,
                    roof
            );
        }
    }

------------------------------------------------------------------------------

# 36. HouseDirector

Create:

    designPatterns/src/practice/builder/part4/HouseDirector.java

Code:

    package practice.builder.part4;

    public class HouseDirector {

        private final HouseBuilder builder;

        public HouseDirector(HouseBuilder builder) {
            this.builder = builder;
        }

        public House constructStandardHouse() {

            return builder
                    .buildFoundation()
                    .buildWalls()
                    .buildDoors()
                    .buildWindows()
                    .buildRoof()
                    .build();
        }
    }

------------------------------------------------------------------------------

# 37. HouseClient

Create:

    designPatterns/src/practice/builder/part4/HouseClient.java

Code:

    package practice.builder.part4;

    public class HouseClient {

        public static void main(String[] args) {

            HouseBuilder builder =
                    new HouseBuilder();

            HouseDirector director =
                    new HouseDirector(builder);

            House house =
                    director.constructStandardHouse();

            house.printDetails();
        }
    }

------------------------------------------------------------------------------

# 38. Is Director Mandatory?

No.

This is very important.

The Director is an optional component in many modern Builder implementations.

Modern Java code frequently looks like:

    Car car = Car.builder()
            .setBrand("Toyota")
            .setModel("Camry")
            .setEngine("2.5L")
            .build();

There is no Director.

The client itself controls the construction.

The conceptual structure becomes:

    Builder Pattern
         |
         +-- Product
         |
         +-- Builder
         |
         +-- Client
         |
         +-- Director (optional)

------------------------------------------------------------------------------

# 39. When is Director Useful?

Director is useful when you have predefined construction recipes.

For example:

    HouseDirector

could provide:

    constructStandardHouse()
    constructLuxuryHouse()
    constructBudgetHouse()

All of them could use the same Builder.

Conceptually:

    Director
       |
       +-- Standard House
       |
       +-- Luxury House
       |
       +-- Budget House

This prevents construction recipes from being duplicated across clients.

------------------------------------------------------------------------------

# 40. Builder vs Director

Builder:

    Knows how to construct individual parts.

Example:

    buildWalls()
    buildRoof()
    buildDoors()

Director:

    Knows which operations should happen
    and in what sequence.

Example:

    buildFoundation()
    buildWalls()
    buildDoors()
    buildWindows()
    buildRoof()

Remember:

    Builder  = HOW
    Director = RECIPE / SEQUENCE

------------------------------------------------------------------------------

# 41. Step Builder Pattern

A Step Builder is an advanced variation of Builder.

Normal Builder allows:

    Account.builder()
            .setUsername(...)
            .setPassword(...)
            .build();

But the client may also attempt:

    Account.builder()
            .build();

If certain fields are mandatory, we can enforce their order using interfaces.

The flow becomes:

    builder()
       |
       v
    UsernameStep
       |
       | setUsername()
       v
    PasswordStep
       |
       | setPassword()
       v
    OptionalStep
       |
       | build()
       v
    Account

------------------------------------------------------------------------------

# 42. Why Step Builder?

Suppose an Account requires:

    username
    password

but email is optional.

We want:

    Account.builder()
            .setUsername("shivraj")
            .setPassword("secret")
            .setEmail("shivraj@gmail.com")
            .build();

We do not want:

    Account.builder()
            .build();

or:

    Account.builder()
            .setPassword("secret")
            .build();

The Step Builder makes invalid construction impossible at compile time.

------------------------------------------------------------------------------

# 43. Account Step Builder

Create:

    designPatterns/src/practice/builder/part4/Account.java

Code:

    package practice.builder.part4;

    public class Account {

        private final String username;
        private final String password;
        private final String email;

        private Account(
                String username,
                String password,
                String email
        ) {
            this.username = username;
            this.password = password;
            this.email = email;
        }

        public static UsernameStep builder() {
            return new Builder();
        }

        public interface UsernameStep {

            PasswordStep setUsername(
                    String username
            );
        }

        public interface PasswordStep {

            OptionalStep setPassword(
                    String password
            );
        }

        public interface OptionalStep {

            OptionalStep setEmail(
                    String email
            );

            Account build();
        }

        private static class Builder
                implements UsernameStep,
                PasswordStep,
                OptionalStep {

            private String username;
            private String password;
            private String email;

            @Override
            public PasswordStep setUsername(
                    String username
            ) {
                this.username = username;
                return this;
            }

            @Override
            public OptionalStep setPassword(
                    String password
            ) {
                this.password = password;
                return this;
            }

            @Override
            public OptionalStep setEmail(
                    String email
            ) {
                this.email = email;
                return this;
            }

            @Override
            public Account build() {

                if (username == null ||
                        username.isBlank()) {

                    throw new IllegalArgumentException(
                            "Username is required"
                    );
                }

                if (password == null ||
                        password.isBlank()) {

                    throw new IllegalArgumentException(
                            "Password is required"
                    );
                }

                return new Account(
                        username,
                        password,
                        email
                );
            }
        }

        public String getUsername() {
            return username;
        }

        public String getEmail() {
            return email;
        }
    }

------------------------------------------------------------------------------

# 44. Step Builder Compile-Time Enforcement

This works:

    Account account =
            Account.builder()
                    .setUsername("shivraj")
                    .setPassword("secret")
                    .setEmail("shivraj@gmail.com")
                    .build();

But this does not compile:

    Account.builder()
            .build();

Why?

Because:

    Account.builder()

returns:

    UsernameStep

and `UsernameStep` does not contain `build()`.

Similarly:

    Account.builder()
            .setUsername("shivraj")

returns:

    PasswordStep

and `PasswordStep` does not contain `build()`.

Only:

    OptionalStep

contains:

    build()

Therefore the Java type system enforces the construction process.

------------------------------------------------------------------------------

# 45. Runtime vs Compile-Time Validation

Normal Builder:

    Invalid input
        |
        v
      build()
        |
        v
    validation
        |
        v
    exception

Step Builder:

    Invalid construction sequence
        |
        v
    Compiler rejects code

So:

    Normal Builder
        -> Runtime validation

    Step Builder
        -> Compile-time construction constraints

This distinction is important.

------------------------------------------------------------------------------

# 46. Step Builder Trade-Off

Step Builder is powerful, but it increases complexity.

Suppose there are 15 required construction steps.

We may end up with:

    Step1
      |
      v
    Step2
      |
      v
    Step3
      |
      v
    Step4
      |
      v
      ...
      |
      v
    Step15

This can create many interfaces and make the code harder to understand.

Therefore:

    Use Step Builder only when construction order
    itself is important.

Do not use it automatically.

------------------------------------------------------------------------------

# 47. Cross-Field Validation

Builder is a good place to perform validation involving multiple fields.

Example:

    giftWrap == true

requires:

    shippingAddress != null

This is not a simple individual field validation.

The rule is:

    giftWrap == true
            +
    shippingAddress missing
            |
            v
        INVALID

Builder can enforce this in `build()`.

------------------------------------------------------------------------------

# 48. Final Order Practice

Create:

    designPatterns/src/practice/builder/part4/Order.java

Code:

    package practice.builder.part4;

    import java.util.ArrayList;
    import java.util.List;

    public class Order {

        private final String orderId;
        private final String customerId;
        private final List<String> items;
        private final String shippingAddress;
        private final String billingAddress;
        private final String couponCode;
        private final String paymentMethod;
        private final String priority;
        private final boolean giftWrap;
        private final String notes;

        private Order(
                String orderId,
                String customerId,
                List<String> items,
                String shippingAddress,
                String billingAddress,
                String couponCode,
                String paymentMethod,
                String priority,
                boolean giftWrap,
                String notes
        ) {
            this.orderId = orderId;
            this.customerId = customerId;
            this.items = List.copyOf(items);
            this.shippingAddress = shippingAddress;
            this.billingAddress = billingAddress;
            this.couponCode = couponCode;
            this.paymentMethod = paymentMethod;
            this.priority = priority;
            this.giftWrap = giftWrap;
            this.notes = notes;
        }

        public static Builder builder() {
            return new Builder();
        }

        public String getOrderId() {
            return orderId;
        }

        public String getCustomerId() {
            return customerId;
        }

        public List<String> getItems() {
            return items;
        }

        public String getShippingAddress() {
            return shippingAddress;
        }

        public String getBillingAddress() {
            return billingAddress;
        }

        public String getCouponCode() {
            return couponCode;
        }

        public String getPaymentMethod() {
            return paymentMethod;
        }

        public String getPriority() {
            return priority;
        }

        public boolean isGiftWrap() {
            return giftWrap;
        }

        public String getNotes() {
            return notes;
        }

        public static class Builder {

            private String orderId;
            private String customerId;

            private final List<String> items =
                    new ArrayList<>();

            private String shippingAddress;
            private String billingAddress;
            private String couponCode;
            private String paymentMethod;

            private String priority = "NORMAL";

            private boolean giftWrap = false;

            private String notes;

            public Builder setOrderId(String orderId) {
                this.orderId = orderId;
                return this;
            }

            public Builder setCustomerId(String customerId) {
                this.customerId = customerId;
                return this;
            }

            public Builder addItem(String item) {
                this.items.add(item);
                return this;
            }

            public Builder setShippingAddress(
                    String shippingAddress
            ) {
                this.shippingAddress = shippingAddress;
                return this;
            }

            public Builder setBillingAddress(
                    String billingAddress
            ) {
                this.billingAddress = billingAddress;
                return this;
            }

            public Builder setCouponCode(
                    String couponCode
            ) {
                this.couponCode = couponCode;
                return this;
            }

            public Builder setPaymentMethod(
                    String paymentMethod
            ) {
                this.paymentMethod = paymentMethod;
                return this;
            }

            public Builder setPriority(
                    String priority
            ) {
                this.priority = priority;
                return this;
            }

            public Builder setGiftWrap(
                    boolean giftWrap
            ) {
                this.giftWrap = giftWrap;
                return this;
            }

            public Builder setNotes(String notes) {
                this.notes = notes;
                return this;
            }

            public Order build() {

                if (orderId == null ||
                        orderId.isBlank()) {

                    throw new IllegalArgumentException(
                            "Order ID is required"
                    );
                }

                if (customerId == null ||
                        customerId.isBlank()) {

                    throw new IllegalArgumentException(
                            "Customer ID is required"
                    );
                }

                if (items.isEmpty()) {

                    throw new IllegalArgumentException(
                            "Order must contain at least one item"
                    );
                }

                if (giftWrap &&
                        (shippingAddress == null ||
                         shippingAddress.isBlank())) {

                    throw new IllegalArgumentException(
                            "Shipping address is required for gift-wrapped orders"
                    );
                }

                return new Order(
                        orderId,
                        customerId,
                        items,
                        shippingAddress,
                        billingAddress,
                        couponCode,
                        paymentMethod,
                        priority,
                        giftWrap,
                        notes
                );
            }
        }
    }

------------------------------------------------------------------------------

# 49. Order Client

Create:

    designPatterns/src/practice/builder/part4/OrderClient.java

Code:

    package practice.builder.part4;

    public class OrderClient {

        public static void main(String[] args) {

            Order order = Order.builder()
                    .setOrderId("ORD-1001")
                    .setCustomerId("CUS-101")
                    .addItem("Laptop")
                    .addItem("Mouse")
                    .setShippingAddress("Bangalore")
                    .setBillingAddress("Bangalore")
                    .setCouponCode("SAVE20")
                    .setPaymentMethod("CARD")
                    .setPriority("HIGH")
                    .setGiftWrap(true)
                    .setNotes("Birthday gift")
                    .build();

            System.out.println(
                    "Order ID: " + order.getOrderId()
            );

            System.out.println(
                    "Customer ID: " + order.getCustomerId()
            );

            System.out.println(
                    "Items: " + order.getItems()
            );

            System.out.println(
                    "Shipping Address: " +
                    order.getShippingAddress()
            );

            System.out.println(
                    "Billing Address: " +
                    order.getBillingAddress()
            );

            System.out.println(
                    "Coupon Code: " +
                    order.getCouponCode()
            );

            System.out.println(
                    "Payment Method: " +
                    order.getPaymentMethod()
            );

            System.out.println(
                    "Priority: " +
                    order.getPriority()
            );

            System.out.println(
                    "Gift Wrap: " +
                    order.isGiftWrap()
            );

            System.out.println(
                    "Notes: " +
                    order.getNotes()
            );
        }
    }

Expected output:

    Order ID: ORD-1001
    Customer ID: CUS-101
    Items: [Laptop, Mouse]
    Shipping Address: Bangalore
    Billing Address: Bangalore
    Coupon Code: SAVE20
    Payment Method: CARD
    Priority: HIGH
    Gift Wrap: true
    Notes: Birthday gift

------------------------------------------------------------------------------

# 50. Order Validation Tests

## Missing Order ID

    Order.builder()
            .setCustomerId("CUS-1")
            .addItem("Laptop")
            .build();

Result:

    IllegalArgumentException:
    Order ID is required

------------------------------------------------------------------------------

# 51. Missing Customer ID

    Order.builder()
            .setOrderId("ORD-1")
            .addItem("Laptop")
            .build();

Result:

    IllegalArgumentException:
    Customer ID is required

------------------------------------------------------------------------------

# 52. No Items

    Order.builder()
            .setOrderId("ORD-1")
            .setCustomerId("CUS-1")
            .build();

Result:

    IllegalArgumentException:
    Order must contain at least one item

------------------------------------------------------------------------------

# 53. Gift Wrap Without Shipping Address

    Order.builder()
            .setOrderId("ORD-1")
            .setCustomerId("CUS-1")
            .addItem("Laptop")
            .setGiftWrap(true)
            .build();

Result:

    IllegalArgumentException:
    Shipping address is required for gift-wrapped orders

------------------------------------------------------------------------------

# 54. Valid Gift-Wrapped Order

    Order.builder()
            .setOrderId("ORD-1")
            .setCustomerId("CUS-1")
            .addItem("Laptop")
            .setShippingAddress("Bangalore")
            .setGiftWrap(true)
            .build();

This succeeds.

------------------------------------------------------------------------------

# 55. Builder vs Constructor

| Constructor | Builder |
|---|---|
| Simple object creation | Complex object creation |
| Few parameters | Many parameters |
| Parameter order matters | Method names identify values |
| Less code | More code |
| Can become unreadable | Usually more readable |
| Harder with many optional fields | Excellent for optional fields |
| Validation possible | Validation centralized in `build()` |
| Multiple constructors may be required | Usually one builder |

Use constructor when:

    The object has very few parameters.

Use Builder when:

    The object has many configuration options.

------------------------------------------------------------------------------

# 56. Builder vs Setter

Setter approach:

    User user = new User();

    user.setName("Shivraj");
    user.setAge(27);
    user.setEmail("shivraj@gmail.com");

Builder approach:

    User user = User.builder()
            .setName("Shivraj")
            .setAge(27)
            .setEmail("shivraj@gmail.com")
            .build();

Main difference:

    Setter
       |
       v
    Mutable Product

    Builder
       |
       v
    Immutable Product

Builder is especially useful when immutability is desired.

------------------------------------------------------------------------------

# 57. Builder vs Factory

Factory answers:

    "Which object should I create?"

Builder answers:

    "How should I configure this object?"

Example Factory:

    NotificationFactory
         |
         +-- EmailNotification
         +-- SMSNotification
         +-- PushNotification

Builder:

    EmailNotification.builder()
            .setRecipient(...)
            .setSubject(...)
            .setBody(...)
            .setPriority(...)
            .build();

Factory focuses on selecting the product type.

Builder focuses on configuring the product.

------------------------------------------------------------------------------

# 58. Builder and Factory Can Work Together

They are not mutually exclusive.

A system could do:

    Factory
       |
       v
    Choose Product Type
       |
       v
    Builder
       |
       v
    Configure Product
       |
       v
    build()
       |
       v
    Product

For example:

    NotificationFactory
            |
            v
    EmailNotification
            |
            v
    EmailNotification.Builder
            |
            v
         build()

------------------------------------------------------------------------------

# 59. Builder vs Prototype

Builder:

    Configuration
        |
        v
      build()
        |
        v
    New Object

Prototype:

    Existing Object
        |
        v
      clone()
        |
        v
    New Object

Builder creates a new object from configuration.

Prototype creates a new object by copying an existing object.

Builder is useful when:

    Construction is configuration-heavy.

Prototype is useful when:

    Creating the object from scratch is expensive
    or
    an existing object is a useful starting point.

------------------------------------------------------------------------------

# 60. Builder vs Prototype Example

Builder:

    Car car = Car.builder()
            .setBrand("Toyota")
            .setModel("Camry")
            .setEngine("2.5L")
            .build();

Prototype:

    Car original = ...;

    Car copy = original.clone();

Conceptually:

    Builder:

    Configuration
         |
         v
       Object


    Prototype:

    Existing Object
         |
         v
       Copy

------------------------------------------------------------------------------

# 61. When Should We Use Builder?

Builder is a good choice when:

    1. The object has many parameters.

    2. Many parameters are optional.

    3. The constructor becomes difficult to read.

    4. There are multiple valid configurations.

    5. The object should be immutable.

    6. Construction requires validation.

    7. There are default values.

    8. The object contains collections or maps.

    9. Construction has complex rules.

    10. Readability of object creation matters.

------------------------------------------------------------------------------

# 62. When Should We NOT Use Builder?

Don't use Builder automatically.

For:

    User user = new User("Shivraj", 27);

Builder might be unnecessary.

Using:

    User.builder()
            .setName("Shivraj")
            .setAge(27)
            .build();

may add unnecessary complexity.

Builder can become overengineering when:

    - There are only one or two fields.
    - There are no optional parameters.
    - Construction is trivial.
    - No validation is needed.
    - No configuration complexity exists.

------------------------------------------------------------------------------

# 63. Builder Pattern Advantages

## 1. Readability

Instead of:

    new User(
        "Shivraj",
        27,
        "shivraj@gmail.com",
        "9999999999"
    );

we get:

    User.builder()
            .setName("Shivraj")
            .setAge(27)
            .setEmail("shivraj@gmail.com")
            .setPhone("9999999999")
            .build();

------------------------------------------------------------------------------

# 64. Advantage — Optional Parameters

The caller can specify only what is needed.

Example:

    Car.builder()
            .setBrand("Toyota")
            .setModel("Camry")
            .setEngine("2.5L")
            .build();

No need to provide every optional parameter.

------------------------------------------------------------------------------

# 65. Advantage — Immutability

The Builder can be mutable:

    Builder
       |
       | mutable
       v
    configuration

while the Product remains immutable:

    Product
       |
       +-- final fields
       +-- no setters

------------------------------------------------------------------------------

# 66. Advantage — Validation

All construction validation can be centralized:

    build()
       |
       +-- required fields
       +-- ranges
       +-- null checks
       +-- cross-field rules
       +-- business constraints
       |
       v
    Product

------------------------------------------------------------------------------

# 67. Advantage — Default Values

Builder can define sensible defaults:

    timeout = 3000
    retryCount = 0
    priority = NORMAL
    followRedirects = true
    giftWrap = false

The caller only overrides what it needs.

------------------------------------------------------------------------------

# 68. Advantage — Defensive Copying

Collections can be safely copied:

    this.items = List.copyOf(items);

    this.headers = Map.copyOf(headers);

This is particularly useful for immutable objects.

------------------------------------------------------------------------------

# 69. Builder Disadvantages

Builder also has costs.

## 1. More Code

Instead of:

    new User("Shivraj", 27);

we may have:

    User
    Builder
    builder()
    setters
    build()

------------------------------------------------------------------------------

# 70. Disadvantage — More Classes / Interfaces

A traditional Builder with Director may involve:

    Product
    Builder
    ConcreteBuilder
    Director

Step Builder may add:

    UsernameStep
    PasswordStep
    OptionalStep

For simple objects, this is unnecessary complexity.

------------------------------------------------------------------------------

# 71. Disadvantage — Duplicate Fields

Builder usually contains copies of Product fields.

Example:

Product:

    private final String name;
    private final int age;

Builder:

    private String name;
    private int age;

This duplication is a trade-off of the pattern.

------------------------------------------------------------------------------

# 72. Disadvantage — Builder Reuse

A Builder is generally intended to construct one logical configuration at a time.

For example:

    Car.Builder builder = Car.builder();

    builder.setBrand("Toyota");

    Car car1 = builder
            .setModel("Camry")
            .build();

Then reusing the same builder without thinking about its state can be confusing.

Prefer:

    Car car1 = Car.builder()
            .setBrand("Toyota")
            .setModel("Camry")
            .build();

    Car car2 = Car.builder()
            .setBrand("Honda")
            .setModel("Civic")
            .build();

Use a fresh Builder for a fresh configuration.

------------------------------------------------------------------------------

# 73. Builder Thread Safety

A normal Builder is mutable:

    private String name;
    private int age;
    private String email;

Therefore it is generally not thread-safe.

Do not share the same Builder across multiple threads unless you explicitly synchronize its usage or otherwise design it for concurrency.

Normally:

    Thread 1 -> Builder 1 -> Product 1

    Thread 2 -> Builder 2 -> Product 2

is preferable to:

    Thread 1
        \
         Shared Builder
        /
    Thread 2

The final immutable Product can safely be shared much more easily.

------------------------------------------------------------------------------

# 74. Complete Builder Architecture

The most common modern Java implementation is:

    +--------------------------------+
    |             Product            |
    |                                |
    |  private final fields          |
    |                                |
    |  private Product(...)          |
    |                                |
    |  static builder()              |
    |                                |
    |  +--------------------------+  |
    |  |          Builder         |  |
    |  |                          |  |
    |  | mutable fields           |  |
    |  | setter-like methods      |  |
    |  | validation               |  |
    |  | build()                  |  |
    |  +--------------------------+  |
    +--------------------------------+

Client:

    Product product =
            Product.builder()
                    .setA(...)
                    .setB(...)
                    .setC(...)
                    .build();

------------------------------------------------------------------------------

# 75. Complete Construction Flow

    Client
      |
      v
    Product.builder()
      |
      v
    new Builder()
      |
      v
    setA()
      |
      v
    setB()
      |
      v
    setC()
      |
      v
    build()
      |
      +---- validate
      |
      +---- defaults already applied
      |
      +---- defensive copies
      |
      v
    private Product(...)
      |
      v
    Immutable Product

------------------------------------------------------------------------------

# 76. Builder Pattern Key Terminology

Remember these terms:

    Product
        The object being created.

    Builder
        The object responsible for constructing the Product.

    build()
        Finalizes construction and returns the Product.

    builder()
        Convenient static factory method that returns a Builder.

    Method Chaining
        Returning this from Builder methods.

    Director
        Optional object that controls a predefined construction recipe.

    Step Builder
        Builder variation that enforces construction steps through types/interfaces.

    Defensive Copy
        Copying mutable collections before storing them in an immutable Product.

------------------------------------------------------------------------------

# 77. Common Interview Question

## What problem does Builder solve?

Answer:

Builder solves the problem of constructing complex objects with many optional parameters while keeping object creation readable and avoiding telescoping constructors.

It also works well with immutable objects and allows construction validation to be centralized.

------------------------------------------------------------------------------

# 78. Common Interview Question

## Why not use a constructor?

Answer:

Constructors become difficult to read when there are many parameters, especially optional ones. Builder provides named-looking configuration methods, supports optional parameters cleanly, and can centralize validation.

------------------------------------------------------------------------------

# 79. Common Interview Question

## Why return this from Builder methods?

Answer:

Returning `this` enables method chaining.

Example:

    builder
        .setName("Shivraj")
        .setAge(27)
        .setEmail("shivraj@gmail.com");

Each method returns the same Builder instance.

------------------------------------------------------------------------------

# 80. Common Interview Question

## Why make the Product constructor private?

Answer:

To force clients to use the Builder as the intended construction mechanism and to centralize validation and object creation inside the Builder.

------------------------------------------------------------------------------

# 81. Common Interview Question

## Is Director mandatory?

Answer:

No.

Director is optional.

It is useful when the system has predefined construction recipes or when construction order needs to be encapsulated.

Modern Java Builder implementations often do not use Director.

------------------------------------------------------------------------------

# 82. Common Interview Question

## Builder vs Factory?

Answer:

Factory focuses on selecting or creating the appropriate product type.

Builder focuses on configuring and constructing a complex product step by step.

Factory answers:

    Which object?

Builder answers:

    How should this object be configured?

------------------------------------------------------------------------------

# 83. Common Interview Question

## Builder vs Prototype?

Answer:

Builder creates an object from configuration.

Prototype creates a new object by copying an existing object.

Builder:

    Configuration -> build() -> New Object

Prototype:

    Existing Object -> clone() -> New Object

------------------------------------------------------------------------------

# 84. Common Interview Question

## What is Step Builder?

Answer:

Step Builder is a Builder variation that uses interfaces or types to restrict which methods are available at each construction stage.

It can enforce mandatory construction order at compile time.

------------------------------------------------------------------------------

# 85. Common Interview Question

## Is Builder thread-safe?

Answer:

Usually no.

The Builder is generally mutable.

The final Product can be immutable and safely shared, but the Builder itself should generally not be shared across threads.

------------------------------------------------------------------------------

# 86. Real-World Java Examples

Builder style appears frequently in Java libraries and frameworks.

Examples include APIs for:

    HTTP requests
    database queries
    configuration objects
    UI components
    cloud SDK requests
    serialization configuration
    test data construction

A well-known style is:

    SomeObject.builder()
            .fieldA(...)
            .fieldB(...)
            .fieldC(...)
            .build();

This style is very common in modern Java code.

------------------------------------------------------------------------------

# 87. Builder and Lombok

In real Java projects, Lombok can generate Builder code.

For example:

    @Builder
    public class User {

        private String name;
        private int age;
        private String email;

    }

Then:

    User user = User.builder()
            .name("Shivraj")
            .age(27)
            .email("shivraj@gmail.com")
            .build();

The important thing is to understand the underlying Builder pattern before relying on Lombok.

Lombok is a convenience.

It does not replace understanding the design pattern.

------------------------------------------------------------------------------

# 88. Builder and Immutability

A very useful combination is:

    Builder + Immutable Product

Architecture:

    Mutable Builder
           |
           | build()
           v
    Immutable Product

Why?

Because configuration requires mutation:

    builder.setName(...)
    builder.setAge(...)

but the final object can remain immutable:

    private final String name;
    private final int age;

This gives flexibility during construction and safety after construction.

------------------------------------------------------------------------------

# 89. Builder and Validation

A good Builder often validates:

    Required fields
    Null values
    Empty values
    Numeric ranges
    Collection constraints
    Cross-field relationships
    Business rules

Example:

    if (items.isEmpty()) {
        throw new IllegalArgumentException(
                "Order must contain at least one item"
        );
    }

Cross-field:

    if (giftWrap &&
            shippingAddress == null) {

        throw new IllegalArgumentException(
                "Shipping address required"
        );
    }

------------------------------------------------------------------------------

# 90. Builder and Collections

For mutable Builder state:

    private final List<String> items =
            new ArrayList<>();

This is fine.

At Product construction:

    this.items = List.copyOf(items);

Similarly:

    this.headers = Map.copyOf(headers);

The important principle is:

    Mutable during construction
           |
           v
    Immutable after construction

------------------------------------------------------------------------------

# 91. Complete Mental Model

The most important thing to remember is:

    Builder is not simply
    "a class with setters".

It provides a controlled object construction process.

The complete flow is:

    Client
       |
       v
    Builder
       |
       +---- configure required fields
       |
       +---- configure optional fields
       |
       +---- apply defaults
       |
       +---- collect collections
       |
       +---- validate
       |
       +---- defensive copy
       |
       v
    build()
       |
       v
    Product
       |
       +---- immutable
       +---- valid
       +---- fully constructed

------------------------------------------------------------------------------

# 92. Builder Pattern Checklist

## Fundamentals

- [x] Builder is a creational pattern
- [x] Builder solves complex object construction
- [x] Builder avoids telescoping constructors
- [x] Builder improves readability
- [x] Builder supports optional parameters
- [x] Builder supports method chaining

## Implementation

- [x] Product
- [x] Builder
- [x] `builder()`
- [x] `build()`
- [x] Private constructor
- [x] Nested Builder
- [x] `final` Product fields
- [x] No Product setters

## Validation

- [x] Required fields
- [x] Null validation
- [x] Empty validation
- [x] Numeric validation
- [x] Collection validation
- [x] Cross-field validation

## Advanced

- [x] Default values
- [x] Defensive copying
- [x] Collections
- [x] Maps
- [x] Immutable Product
- [x] Builder mutability
- [x] Builder thread-safety considerations
- [x] Builder reuse considerations

## Director

- [x] Understand Director
- [x] Understand Builder vs Director
- [x] Understand construction recipes
- [x] Know Director is optional

## Step Builder

- [x] Understand Step Builder
- [x] Interface-based steps
- [x] Construction order
- [x] Compile-time enforcement
- [x] Runtime vs compile-time validation
- [x] Step Builder trade-offs

## Comparisons

- [x] Builder vs Constructor
- [x] Builder vs Setter
- [x] Builder vs Factory
- [x] Builder vs Prototype

## Practice

- [x] User Builder
- [x] Computer Builder
- [x] Car Builder
- [x] Laptop Builder
- [x] HTTP Request Builder
- [x] Request Builder
- [x] Notification Builder
- [x] House Builder
- [x] Director
- [x] Account Step Builder
- [x] Order Builder

------------------------------------------------------------------------------

# 93. Project Structure

The complete Builder practice structure is:

    designPatterns/src/practice/builder/

    builder/
    |
    +-- part1/
    |   |
    |   +-- User.java
    |   +-- UserBuilder.java
    |   +-- Client.java
    |   +-- Computer.java
    |   +-- ComputerBuilder.java
    |   +-- ComputerClient.java
    |
    +-- part2/
    |   |
    |   +-- Computer.java
    |   +-- ComputerBuilder.java
    |   +-- Car.java
    |   +-- CarClient.java
    |   +-- Laptop.java
    |
    +-- part3/
    |   |
    |   +-- HttpRequest.java
    |   +-- HttpClient.java
    |   +-- Request.java
    |   +-- Notification.java
    |
    +-- part4/
        |
        +-- House.java
        +-- HouseBuilder.java
        +-- HouseDirector.java
        +-- HouseClient.java
        +-- Account.java
        +-- Order.java
        +-- OrderClient.java

------------------------------------------------------------------------------

# 94. Builder Progress

    BUILDER DESIGN PATTERN

    Part 1  [██████████] 100% COMPLETE
    Part 2  [██████████] 100% COMPLETE
    Part 3  [██████████] 100% COMPLETE
    Part 4  [██████████] 100% COMPLETE

    Overall
    [████████████████████] 100% COMPLETE

Builder Design Pattern is COMPLETE.

------------------------------------------------------------------------------

# 95. Final Builder Summary

The Builder Pattern should now be mentally summarized as:

    Complex Object
          |
          v
       Builder
          |
          +---- Required Fields
          |
          +---- Optional Fields
          |
          +---- Default Values
          |
          +---- Collections
          |
          +---- Validation
          |
          +---- Cross-Field Rules
          |
          +---- Defensive Copies
          |
          v
        build()
          |
          v
    Immutable Product

The most common Java implementation is:

    Product product =
            Product.builder()
                    .setFieldA(valueA)
                    .setFieldB(valueB)
                    .setFieldC(valueC)
                    .build();

Remember:

    Constructor
        -> Simple construction

    Builder
        -> Complex configurable construction

    Factory
        -> Choose/create product type

    Prototype
        -> Copy existing object

    Director
        -> Optional construction recipe

    Step Builder
        -> Compile-time construction sequence

The central idea is:

    "Separate the construction of a complex object
     from its representation and allow the object
     to be constructed step by step."

------------------------------------------------------------------------------
# END OF BUILDER DESIGN PATTERN
------------------------------------------------------------------------------