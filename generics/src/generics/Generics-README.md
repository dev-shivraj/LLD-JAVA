# Java Generics — Complete Guide

This README covers Java Generics from the basics to Wildcards, including:

- Why Generics are needed

- Problems without Generics

- `Object` vs Generics

- Generic Classes

- Type Parameters and Type Arguments

- Generic Primitive Types

- Autoboxing and Unboxing

- Compile-time Type Safety

- Static Variables and Generics

- Static Methods and Generics

- Generic Static Methods

- All 4 combinations of static methods

- Generic Methods with multiple type parameters

- Generic Inheritance

- Invariance

- Why `List<Dog>` is NOT `List<Animal>`

- Wildcards

- Unbounded Wildcard `?`

- Upper Bounded Wildcard `? extends`

- Lower Bounded Wildcard `? super`

- PECS — Producer Extends, Consumer Super

- Reading and Writing with Wildcards

- Wildcard vs Type Parameter

- Bounded Type Parameters

- Multiple Bounds

- Wildcard Capture

- Raw Types

- Type Erasure

- Generic Arrays

- Heap Pollution

- Practical examples

- Mental models and cheat sheets

---

# 1. What Are Generics?

Generics allow us to write classes, interfaces, and methods that can work with different types while maintaining compile-time type safety.

Instead of writing:

```java

class Pair {

    Object x;

    Object y;

}

```

we can write:

```java

class Pair<T, V> {

    T x;

    V y;

}

```

Now the same class can work with different types:

```text

Pair<String, Integer>

Pair<Integer, Double>

Pair<Dog, Animal>

Pair<String, String>

```

---

# 2. Why Do We Need Generics?

Let's first understand the problem without Generics.

Consider:

```java

public class ObjectPair {

    Object x;

    Object y;

    public ObjectPair() {}

    public ObjectPair(Object x, Object y) {

        this.x = x;

        this.y = y;

    }

    public Object getX() {

        return x;

    }

    public Object getY() {

        return y;

    }

    public void setX(Object x) {

        this.x = x;

    }

    public void setY(Object y) {

        this.y = y;

    }

}

```

We can use it like this:

```java

ObjectPair p = new ObjectPair();

p.setX(10);

p.setY(20);

```

At this point everything looks fine.

But because the fields are `Object`, we can do this:

```java

p.setX("Hello");

```

There is no compile-time error.

Now:

```java

int x = (int) p.getX();

```

At runtime:

```text

p.getX()

   |

   v

"Hello"

   |

   v

cast to int

   |

   v

ClassCastException

```

---

# 3. Important Terminology Correction

`ObjectPair` is NOT a raw type.

It is simply a non-generic class that uses `Object`.

These are different concepts:

```text

ObjectPair

    |

    v

Non-generic class

    |

    v

Uses Object

```

Whereas:

```java

Pair p = new Pair();

```

is a raw type if `Pair` is declared as:

```java

class Pair<T, V>

```

So remember:

```text

ObjectPair                  -> non-generic class

Pair<T, V>                  -> generic class

Pair<String, Integer>       -> parameterized type

Pair                        -> raw type

T, V                        -> type parameters

String, Integer             -> type arguments

```

---

# 4. Problem With Object

The problem with using `Object` is:

```text

Any type

   |

   v

Object

   |

   v

Type information is lost

   |

   v

Need casting

   |

   v

Possible runtime ClassCastException

```

Example:

```java

ObjectPair p = new ObjectPair();

p.setX(10);

p.setX("Hello");

p.setX(true);

p.setX(10.5);

```

Everything is allowed.

This provides flexibility but loses compile-time type safety.

---

# 5. Generic Pair

Now we introduce Generics:

```java

public class Pair<T, V> {

    T x;

    V y;

    public Pair() {}

    public Pair(T x, V y) {

        this.x = x;

        this.y = y;

    }

    public T getX() {

        return x;

    }

    public V getY() {

        return y;

    }

    public void setX(T x) {

        this.x = x;

    }

    public void setY(V y) {

        this.y = y;

    }

}

```

Now:

```java

Pair<String, Double> p = new Pair<>("Hello", 2.0);

```

means:

```text

T = String

V = Double

```

Conceptually:

```text

Pair<T, V>

    |

    v

Pair<String, Double>

    |

    +---- T -> String

    |

    +---- V -> Double

```

Therefore:

```java

p.setX("Hello");   // OK

p.setY(20.0);      // OK

```

But:

```java

p.setX(10);        // Compile-time error

p.setY("Hello");   // Compile-time error

```

---

# 6. Compile-Time Type Safety

Without Generics:

```java

ObjectPair p = new ObjectPair();

p.setX("Hello");

int x = (int) p.getX();

```

The problem appears at runtime.

With Generics:

```java

Pair<String, Double> p = new Pair<>();

p.setX(10);

```

The problem appears at compile time.

Therefore:

```text

Without Generics

Object

  |

  v

Casting

  |

  v

Possible runtime error

With Generics

Known type

  |

  v

Compiler checks

  |

  v

Compile-time error

```

This is one of the biggest benefits of Generics.

---

# 7. Generic Type Parameters

In:

```java

class Pair<T, V>

```

`T` and `V` are called **type parameters**.

They are placeholders.

When we write:

```java

Pair<String, Double>

```

`String` and `Double` are called **type arguments**.

So:

```text

Pair<T, V>

   ^  ^

   |  |

Type Parameters

Pair<String, Double>

      ^       ^

      |       |

Type Arguments

```

---

# 8. Generic Type Parameter Naming

There are common naming conventions:

```text

T -> Type

E -> Element

K -> Key

V -> Value

N -> Number

R -> Return type

S, U, V -> Additional types

```

Examples:

```java

class Box<T>

class Pair<K, V>

interface List<E>

```

These are conventions, not requirements.

You could write:

```java

class Pair<X, Y>

```

but standard Java convention is usually:

```java

class Pair<T, V>

```

---

# 9. Generic Primitive Types

This is NOT allowed:

```java

Pair<int, double> pair; // Compile-time error

```

Generics work with reference types, not primitive types.

Use wrapper classes:

```java

Pair<Integer, Double> pair;

```

Common mappings:

```text

int      -> Integer

long     -> Long

double   -> Double

float    -> Float

boolean  -> Boolean

char     -> Character

byte     -> Byte

short    -> Short

```

---

# 10. Autoboxing

Although this is invalid:

```java

Pair<int, int>

```

this works:

```java

Pair<Integer, Integer> p = new Pair<>();

p.setX(10);

```

Why?

Because Java automatically converts:

```text

int

 |

 v

Integer

```

This is called **autoboxing**.

Conceptually:

```java

p.setX(10);

```

becomes something similar to:

```java

p.setX(Integer.valueOf(10));

```

---

# 11. Unboxing

This also works:

```java

Integer x = p.getX();

int y = p.getX();

```

Java automatically converts:

```text

Integer

   |

   v

 int

```

This is called **unboxing**.

---

# 12. Generic Classes and Static Members

This is a very important rule:

> A static member cannot directly use the class's generic type parameters.

Consider:

```java

public class Pair<T, V> {

    T x;

    V y;

    static T value; // Compile-time error

}

```

Why?

Because `T` belongs to the parameterized type:

```text

Pair<String, Integer>

Pair<Double, Boolean>

Pair<Long, String>

```

Each parameterized type can have a different `T`.

But a static variable belongs to the class itself.

There is only one static variable:

```text

Pair

 |

 +---- static value

```

Java cannot decide whether that value should be:

```text

String

Double

Integer

Long

...

```

Therefore:

```java

static T value; // Invalid

static V value; // Invalid

```

are invalid.

---

# 13. Instance Members Can Use Generic Type Parameters

This is valid:

```java

public class Pair<T, V> {

    T x;

    V y;

}

```

Because `x` and `y` belong to individual objects.

For example:

```java

Pair<String, Integer> p1 = new Pair<>();

Pair<Double, Boolean> p2 = new Pair<>();

```

Conceptually:

```text

p1

 |

 +---- T = String

 |

 +---- V = Integer

p2

 |

 +---- T = Double

 |

 +---- V = Boolean

```

Each object can have different type arguments.

---

# 14. Static Methods and Generics

This is NOT allowed:

```java

public class Pair<T, V> {

    static T getValue() { // Invalid

        return null;

    }

}

```

Because the static method cannot use the class's `T`.

But a static method can declare its own generic type parameter:

```java

public class Pair<T, V> {

    public static <T> T getValue(T value) {

        return value;

    }

}

```

Notice:

```java

static <T> T getValue(T value)

       ^^^

```

The `<T>` belongs to the method.

It is NOT the same `T` as the class's `T`.

---

# 15. Class-Level T vs Method-Level T

Consider:

```java

class Pair<T, V> {

    public static <T> T getValue(T value) {

        return value;

    }

}

```

There are two different `T`s:

```text

class Pair<T, V>

          ^

          |

          Class-level T

static <T> T getValue(T value)

       ^

       |

       Method-level T

```

They are completely independent.

To make this clearer, use different names:

```java

class Pair<T, V> {

    public static <X> X getValue(X value) {

        return value;

    }

}

```

Now:

```text

Pair<T, V>

     |

     +---- T -> class type parameter

     |

     +---- V -> class type parameter

static <X> X getValue(X value)

         |

         +---- X -> method type parameter

```

---

# 16. Four Types of Static Methods

There are four basic combinations:

```text

                         Return

                    No          Yes

                ----------------------

Arguments   No   |  1           2

            Yes  |  3           4

```

---

# 17. Static Method — No Arguments, No Return

No generic type is needed.

```java

public static void printMessage() {

    System.out.println("Hello");

}

```

Client:

```java

Pair.printMessage();

```

Because there is no generic input or output, there is no need for:

```java

<T>

```

---

# 18. Static Method — Arguments, No Return

```java

public static <T> void print(T value) {

    System.out.println(value);

}

```

Client:

```java

Pair.print("Hello");

Pair.print(100);

Pair.print(10.5);

Pair.print(true);

```

Java infers:

```text

print("Hello")

     |

     v

T = String

print(100)

     |

     v

T = Integer

print(10.5)

     |

     v

T = Double

print(true)

     |

     v

T = Boolean

```

You can also explicitly specify the type:

```java

Pair.<String>print("Hello");

Pair.<Integer>print(100);

Pair.<Double>print(10.5);

```

---

# 19. Static Method — Arguments, Return

This is one of the most common generic method patterns.

```java

public static <T> T getValue(T value) {

    return value;

}

```

Client:

```java

String s = Pair.getValue("Hello");

Integer i = Pair.getValue(100);

Double d = Pair.getValue(10.5);

```

Java infers the type:

```text

getValue("Hello")

      |

      v

T = String

      |

      v

String returned

getValue(100)

      |

      v

T = Integer

      |

      v

Integer returned

```

---

# 20. Static Method — No Arguments, Return

This is valid:

```java

public static <T> T getEmptyValue() {

    return null;

}

```

But there is no argument from which Java can infer `T`.

You can explicitly specify it:

```java

String s = Pair.<String>getEmptyValue();

Integer i = Pair.<Integer>getEmptyValue();

Double d = Pair.<Double>getEmptyValue();

```

The syntax:

```java

Pair.<String>getEmptyValue();

```

explicitly tells Java:

```text

T = String

```

---

# 21. Generic Static Method With Multiple Type Parameters

A method can have multiple generic parameters.

```java

public static <X, Y> void printPair(X x, Y y) {

    System.out.println(x);

    System.out.println(y);

}

```

Client:

```java

Pair.printPair("Hello", 100);

Pair.printPair(10.5, true);

Pair.printPair("Shivraj", 27);

```

Inference:

```text

printPair("Hello", 100)

       |

       +---- X = String

       |

       +---- Y = Integer

printPair(10.5, true)

       |

       +---- X = Double

       |

       +---- Y = Boolean

```

---

# 22. Generic Inheritance

Consider:

```text

Creature

   ^

   |

 Animal

   ^

   |

  Dog

```

Therefore:

```java

Dog dog = new Dog("Dog");

Animal animal = dog;      // OK

Creature creature = dog;  // OK

Object object = dog;      // OK

```

Because:

```text

Dog IS-A Animal

Animal IS-A Creature

Creature IS-A Object

```

---

# 23. But Generic Types Are Invariant

This is one of the most important concepts.

Although:

```text

Dog <: Animal

```

it does NOT mean:

```text

List<Dog> <: List<Animal>

```

Therefore:

```java

List<Dog> dogs = new ArrayList<>();

List<Animal> animals = dogs; // Compile-time error

```

Generic types are **invariant by default**.

---

# 24. Why Is `List<Dog>` Not `List<Animal>`?

Suppose Java allowed:

```java

List<Dog> dogs = new ArrayList<>();

List<Animal> animals = dogs;

```

Now:

```java

animals.add(new Animal("Tiger"));

```

would be allowed because `animals` is supposedly a `List<Animal>`.

But the underlying list is actually:

```text

List<Dog>

```

Now it contains:

```text

Dog

Dog

Animal  <- invalid for List<Dog>

```

Then:

```java

Dog dog = dogs.get(2);

```

would be unsafe.

Therefore Java prevents:

```text

List<Dog> -> List<Animal>

```

---

# 25. Invariance

Remember:

```text

Dog <: Animal

but

List<Dog> is NOT a subtype of List<Animal>

```

In mathematical notation:

```text

Dog <: Animal

does not imply

List<Dog> <: List<Animal>

```

This is called **invariance**.

---

# 26. Wildcards

Wildcards allow controlled flexibility.

The wildcard is:

```java

?

```

It means:

> Some unknown type.

For example:

```java

List<?> list;

```

means:

```text

List of some unknown type

```

It could be:

```text

List<String>

List<Integer>

List<Dog>

List<Animal>

List<Object>

```

---

# 27. Three Main Wildcards

There are three forms:

```java

?

```

```java

? extends Animal

```

```java

? super Animal

```

They mean:

```text

?                  -> unknown type

? extends Animal   -> unknown type that is Animal or below

? super Animal     -> unknown type that is Animal or above

```

---

# 28. Unbounded Wildcard `?`

Example:

```java

static void printAnything(List<?> list) {

    for (Object value : list) {

        System.out.println(value);

    }

}

```

This accepts:

```text

List<String>

List<Integer>

List<Dog>

List<Animal>

List<Object>

```

because we don't care about the element type.

---

# 29. Reading From `List<?>`

This is safe:

```java

Object value = list.get(0);

```

Why?

Because whatever the actual type is, it is an `Object`.

For example:

```text

List<String>

   |

   v

String

   |

   v

Object

```

or:

```text

List<Dog>

   |

   v

Dog

   |

   v

Object

```

Therefore:

```java

Object value = list.get(0);

```

is always safe.

---

# 30. Writing to `List<?>`

This is generally not allowed:

```java

list.add("Hello");       // Invalid

list.add(10);            // Invalid

list.add(new Dog("Dog")); // Invalid

```

Because the actual list could be:

```text

List<Integer>

```

or:

```text

List<Dog>

```

Java doesn't know the exact type.

The only commonly allowed value is:

```java

list.add(null); // OK

```

because `null` can be assigned to any reference type.

---

# 31. Unbounded Wildcard Mental Model

```text

List<?>

"I don't know what type this list contains."

READ:

    Object

WRITE:

    Nothing specific

Possible:

    List<String>

    List<Integer>

    List<Dog>

    List<Animal>

    List<Object>

```

---

# 32. Upper Bounded Wildcard — `? extends`

Now:

```java

List<? extends Animal>

```

means:

> A List of some unknown type that is `Animal` or a subclass of `Animal`.

Given:

```text

Creature

   ^

   |

 Animal

   ^

   |

  Dog

```

Possible lists:

```text

List<Animal>

List<Dog>

```

Also any other subclass:

```text

List<Cat>

List<Tiger>

...

```

But not:

```text

List<Creature>

List<Object>

List<String>

```

---

# 33. Why Is `? extends Animal` Useful?

Consider:

```java

static void printAnimalNames(List<Animal> animals) {

    for (Animal animal : animals) {

        System.out.println(animal.getName());

    }

}

```

This accepts:

```text

List<Animal>

```

but NOT:

```text

List<Dog>

```

Even though:

```text

Dog IS-A Animal

```

We can improve it:

```java

static void printAnimalNames(List<? extends Animal> animals) {

    for (Animal animal : animals) {

        System.out.println(animal.getName());

    }

}

```

Now both work:

```java

List<Animal> animals = ...;

List<Dog> dogs = ...;

printAnimalNames(animals); // OK

printAnimalNames(dogs);    // OK

```

---

# 34. Reading From `? extends`

This is safe:

```java

Animal animal = animals.get(0);

```

Why?

Suppose the actual list is:

```text

List<Animal>

```

Then:

```text

get() -> Animal

```

Suppose it is:

```text

List<Dog>

```

Then:

```text

get() -> Dog

        |

        v

      Animal

```

Either way, we can safely treat the result as `Animal`.

Therefore:

```text

List<? extends Animal>

READ -> Animal

```

---

# 35. Writing to `? extends`

This is NOT allowed:

```java

animals.add(new Animal("Tiger")); // Invalid

animals.add(new Dog("Dog"));      // Invalid

```

Why?

Because Java doesn't know the exact type.

It could be:

```text

List<Dog>

```

or:

```text

List<Cat>

```

Suppose it is:

```text

List<Cat>

```

Then:

```java

animals.add(new Dog("Dog"));

```

would be unsafe.

Therefore:

```text

? extends

READ  -> Safe

WRITE -> Not safe

```

---

# 36. Upper Bound Mental Model

```text

        Animal

       /     \

     Dog     Cat

```

The actual list could be:

```text

List<Animal>

List<Dog>

List<Cat>

```

You can safely:

```java

Animal a = list.get(0);

```

But you cannot safely add a specific Animal subtype.

---

# 37. Lower Bounded Wildcard — `? super`

Now:

```java

List<? super Animal>

```

means:

> A List of some unknown type that is `Animal` or a superclass of `Animal`.

Given:

```text

Object

   ^

   |

Creature

   ^

   |

Animal

   ^

   |

Dog

```

Possible lists:

```text

List<Animal>

List<Creature>

List<Object>

```

Not:

```text

List<Dog>

```

because `Dog` is below `Animal`.

---

# 38. Important Correction About `? super Creature`

If you have:

```java

static void addAnimals(List<? super Creature> animals)

```

then valid types are:

```text

List<Creature>

List<Object>

```

NOT:

```text

List<Animal>

```

because:

```text

Creature

   ^

   |

Animal

```

means:

```text

Animal is a subtype of Creature

```

not a supertype.

---

# 39. `? super Animal`

This is easier to visualize:

```java

List<? super Animal>

```

Possible:

```text

List<Animal>

List<Creature>

List<Object>

```

because:

```text

Object

   ^

   |

Creature

   ^

   |

Animal

```

All of these lists can safely store an `Animal`.

---

# 40. Writing to `? super`

This works:

```java

static void addAnimals(List<? super Animal> animals) {

    animals.add(new Animal("Animal"));

    animals.add(new Dog("Dog"));

}

```

Why?

Because:

```text

Dog -> Animal

```

and:

```text

Animal

   |

   v

Creature

   |

   v

Object

```

Every possible list type can hold an Animal.

For example:

```java

List<Animal> animals = new ArrayList<>();

List<Creature> creatures = new ArrayList<>();

List<Object> objects = new ArrayList<>();

addAnimals(animals);

addAnimals(creatures);

addAnimals(objects);

```

All are valid.

---

# 41. Reading From `? super`

This is important:

```java

List<? super Animal> animals;

```

You can add:

```java

animals.add(new Animal("Animal"));

animals.add(new Dog("Dog"));

```

But:

```java

Animal animal = animals.get(0); // Invalid

```

is not safe.

You can only safely treat the returned value as:

```java

Object value = animals.get(0);

```

Why?

Because the actual list could be:

```text

List<Animal>

List<Creature>

List<Object>

```

If it's:

```text

List<Object>

```

the list could contain anything.

Therefore:

```text

List<? super Animal>

WRITE -> Animal

READ  -> Object

```

---

# 42. Lower Bound Mental Model

```text

Object

   ^

   |

Creature

   ^

   |

Animal

```

Possible:

```text

List<Animal>

List<Creature>

List<Object>

```

You can safely:

```java

list.add(new Animal(...));

list.add(new Dog(...));

```

But when reading:

```java

Object value = list.get(0);

```

---

# 43. PECS

One of the most important Java Generic rules:

> PECS = Producer Extends, Consumer Super

---

# 44. Producer Extends

If a collection produces values for you:

```java

Animal animal = animals.get(0);

```

use:

```java

List<? extends Animal>

```

The list is a producer.

```text

List

 |

 v

get()

 |

 v

Animal

```

Therefore:

```text

Producer -> extends

```

---

# 45. Consumer Super

If a collection consumes values from you:

```java

animals.add(new Animal(...));

```

use:

```java

List<? super Animal>

```

The list is a consumer.

```text

Your code

   |

   v

 add()

   |

   v

 List

```

Therefore:

```text

Consumer -> super

```

---

# 46. PECS Cheat Sheet

```text

             PECS

Producer

    |

    v

 extends

Consumer

    |

    v

 super

```

More practically:

```text

? extends T

READ  -> T

WRITE -> Nothing specific

? super T

READ  -> Object

WRITE -> T

```

---

# 47. Complete Wildcard Comparison

| Type | Meaning | Read | Write |

|---|---|---|---|

| `List<?>` | Unknown type | `Object` | Nothing specific |

| `List<? extends Animal>` | Animal or subtype | `Animal` | Nothing specific |

| `List<? super Animal>` | Animal or supertype | `Object` | `Animal` |

---

# 48. Compare `?`, `extends`, and `super`

## `?`

```java

List<?>

```

Means:

> I don't know the type.

Possible:

```text

List<String>

List<Integer>

List<Dog>

List<Animal>

List<Object>

```

---

## `? extends Animal`

```java

List<? extends Animal>

```

Means:

> I don't know the exact type, but it is Animal or a subtype.

Possible:

```text

List<Animal>

List<Dog>

List<Cat>

```

---

## `? super Animal`

```java

List<? super Animal>

```

Means:

> I don't know the exact type, but it is Animal or a supertype.

Possible:

```text

List<Animal>

List<Creature>

List<Object>

```

---

# 49. `List<?>` vs `List<Object>`

These are NOT the same.

Consider:

```java

List<String> strings = new ArrayList<>();

```

This is valid:

```java

List<?> unknown = strings;

```

But this is invalid:

```java

List<Object> objects = strings; // Compile-time error

```

Because:

```text

List<String>

    |

    v

List<?>       OK

List<String>

    |

    v

List<Object>  Invalid

```

`List<?>` means:

> List of some unknown type.

`List<Object>` means:

> List specifically parameterized with Object.

---

# 50. Wildcard vs Type Parameter

Compare:

```java

List<? extends Animal>

```

with:

```java

<T extends Animal>

```

They are not the same thing.

---

# 51. Wildcard

```java

static void print(List<? extends Animal> animals) {

    for (Animal animal : animals) {

        System.out.println(animal.getName());

    }

}

```

means:

> There is some unknown subtype of Animal, and I don't need to know exactly which one.

The exact type doesn't matter.

---

# 52. Type Parameter

```java

static <T extends Animal> T getFirst(List<T> animals) {

    return animals.get(0);

}

```

Here we give the type a name:

```text

T

```

Now we can use that exact type elsewhere.

For:

```java

List<Dog> dogs = ...;

Dog dog = getFirst(dogs);

```

Java infers:

```text

T = Dog

```

So the return type is:

```text

Dog

```

---

# 53. Key Difference

```text

? extends Animal

"I don't care what the exact subtype is."

<T extends Animal>

"I care about the exact subtype and I want to refer to it as T."

```

---

# 54. Example Comparing Both

Method 1:

```java

static Animal getFirst(List<? extends Animal> animals) {

    return animals.get(0);

}

```

Calling:

```java

List<Dog> dogs = ...;

Animal animal = getFirst(dogs);

```

Return type is:

```text

Animal

```

---

Method 2:

```java

static <T extends Animal> T getFirst(List<T> animals) {

    return animals.get(0);

}

```

Calling:

```java

List<Dog> dogs = ...;

Dog dog = getFirst(dogs);

```

Return type is:

```text

Dog

```

because:

```text

T = Dog

```

---

# 55. Bounded Type Parameters

Generics can also restrict a type parameter.

For example:

```java

<T extends Animal>

```

means:

> T must be Animal or a subclass of Animal.

Example:

```java

static <T extends Animal> void print(T animal) {

    System.out.println(animal.getName());

}

```

Valid:

```java

print(new Animal("Animal"));

print(new Dog("Dog"));

```

Invalid:

```java

print(new Creature()); // Compile-time error

print("Hello");        // Compile-time error

```

---

# 56. Why Bounded Type Parameters Are Useful

Because now the compiler knows that `T` has Animal's methods.

For example:

```java

static <T extends Animal> void printName(T animal) {

    System.out.println(animal.getName());

}

```

Since:

```text

T extends Animal

```

Java guarantees:

```text

T has all Animal functionality

```

Therefore:

```java

animal.getName();

```

is valid.

---

# 57. Multiple Bounds

A type parameter can have multiple bounds.

Example:

```java

<T extends Animal & Runnable>

```

means:

```text

T must be:

    Animal

AND

    Runnable

```

Example:

```java

static <T extends Animal & Runnable> void execute(T animal) {

    animal.getName();

    animal.run();

}

```

The class must appear first.

Valid:

```java

<T extends Animal & Runnable>

```

Invalid:

```java

<T extends Runnable & Animal>

```

---

# 58. Wildcards and Multiple Bounds

For most normal wildcard usage, think of:

```java

? extends Animal

```

as the upper-bound wildcard.

If you need a type parameter with multiple constraints, use a bounded type parameter:

```java

<T extends Animal & Runnable>

```

---

# 59. Wildcard Capture

You may eventually encounter code like:

```java

static void swap(List<?> list, int i, int j) {

    ...

}

```

The wildcard represents an unknown type.

Java can capture that unknown type with a helper method:

```java

static void swap(List<?> list, int i, int j) {

    swapHelper(list, i, j);

}

private static <T> void swapHelper(List<T> list, int i, int j) {

    T temp = list.get(i);

    list.set(i, list.get(j));

    list.set(j, temp);

}

```

The helper method says:

> Whatever the unknown type is, I will call it `T`.

This concept is called **wildcard capture**.

---

# 60. Generic Arrays

Arrays and Generics have some limitations.

This is not allowed:

```java

List<String>[] lists = new List<String>[10]; // Invalid

```

Java does not allow creating arrays of concrete parameterized types directly.

But:

```java

List<?>[] lists = new List<?>[10]; // Valid

```

is allowed.

This is one reason you often see:

```java

@SuppressWarnings("unchecked")

```

around certain generic array operations.

---

# 61. Type Erasure

An important concept behind Java Generics is **type erasure**.

Java Generics provide compile-time type safety while maintaining compatibility with older Java code.

At runtime, much of the generic type information is erased.

For example:

```java

List<String>

```

and:

```java

List<Integer>

```

both become conceptually:

```text

List

```

at runtime.

This is why:

```java

new ArrayList<String>()

```

doesn't create a completely different runtime class from:

```java

new ArrayList<Integer>()

```

---

# 62. Type Erasure Example

Consider:

```java

class Box<T> {

    T value;

    void set(T value) {

        this.value = value;

    }

    T get() {

        return value;

    }

}

```

Conceptually, after type erasure, Java uses a form based on `Object` for an unbounded type:

```text

T

|

v

Object

```

The compiler inserts the necessary casts at appropriate places.

This is one reason Generics provide compile-time safety without requiring separate runtime classes for every type argument.

---

# 63. Why Can't We Do `instanceof List<String>`?

This is invalid:

```java

if (list instanceof List<String>) {

}

```

because generic type arguments are erased at runtime.

Java can check:

```java

if (list instanceof List<?>) {

}

```

but cannot generally check:

```text

Is this specifically List<String>?

```

at runtime.

---

# 64. Raw Types

If you have:

```java

class Pair<T, V>

```

then:

```java

Pair pair = new Pair();

```

is a **raw type**.

You lose generic type safety.

Example:

```java

Pair pair = new Pair();

pair.setX("Hello");

pair.setX(100);

```

The compiler allows operations that should normally be restricted.

Raw types exist mainly for backward compatibility with pre-generics Java code.

Avoid them in new code.

Prefer:

```java

Pair<String, Integer> pair = new Pair<>();

```

---

# 65. Heap Pollution

Heap pollution occurs when a variable of a parameterized type refers to an object that is not of the expected parameterized type.

Raw types and unchecked operations can cause this.

Example:

```java

List<String> strings = new ArrayList<>();

List raw = strings;

raw.add(100);

```

Now the underlying list is supposed to be:

```text

List<String>

```

but it contains:

```text

Integer

```

Later:

```java

String s = strings.get(0);

```

can result in:

```text

ClassCastException

```

This is one reason raw types should be avoided.

---

# 66. Generic Inheritance Summary

Given:

```text

Creature

   ^

   |

 Animal

   ^

   |

  Dog

```

Object inheritance:

```java

Animal animal = new Dog("Dog");    // OK

Creature creature = new Dog("Dog"); // OK

```

Generic inheritance:

```java

List<Animal> animals = new ArrayList<Dog>(); // Invalid

```

because:

```text

Dog <: Animal

but

List<Dog> NOT <: List<Animal>

```

Wildcards provide controlled flexibility:

```java

List<? extends Animal>

```

accepts:

```text

List<Animal>

List<Dog>

```

---

# 67. Complete Example

```java

package generics.generics_in_inheritance;

import java.util.ArrayList;

import java.util.List;

public class Client {

    static void printAnimalName(Animal animal) {

        System.out.println(animal.getName());

    }

    // Accepts only List<Animal>

    static void printAnimalNames(List<Animal> animals) {

        for (Animal animal : animals)

            System.out.println(animal.getName());

    }

    // Accepts List<Animal>, List<Dog>, List<Cat>, etc.

    static void printAnimalNames2(List<? extends Animal> animals) {

        for (Animal animal : animals)

            System.out.println(animal.getName());

    }

    // Accepts List<Animal>, List<Creature>, List<Object>

    static void addAnimals(List<? super Animal> animals) {

        animals.add(new Animal("Animal1"));

        animals.add(new Dog("Dog1"));

    }

    // Accepts List of anything

    static void printAnything(List<?> list) {

        for (Object value : list)

            System.out.println(value);

    }

    static void main() {

        Animal animal = new Animal("Animal");

        Dog dog = new Dog("Dog");

        // Normal inheritance

        printAnimalName(animal);

        printAnimalName(dog);

        // List<Animal>

        List<Animal> animals = List.of(animal, dog);

        printAnimalNames(animals);

        // List<Dog>

        List<Dog> dogs = List.of(

            new Dog("Dog1"),

            new Dog("Dog2")

        );

        // Does not compile

        // printAnimalNames(dogs);

        // Works because of ? extends Animal

        printAnimalNames2(dogs);

        // ? super Animal

        List<Animal> animalList = new ArrayList<>();

        List<Creature> creatureList = new ArrayList<>();

        List<Object> objectList = new ArrayList<>();

        addAnimals(animalList);

        addAnimals(creatureList);

        addAnimals(objectList);

        // ? wildcard

        printAnything(dogs);

        printAnything(animals);

        printAnything(List.of("Hello", "World"));

        printAnything(List.of(1, 2, 3));

    }

}

```

---

# 68. Supporting Classes

```java

package generics.generics_in_inheritance;

public class Creature {

}

```

```java

package generics.generics_in_inheritance;

public class Animal extends Creature {

    String name;

    public Animal(String name) {

        this.name = name;

    }

    public String getName() {

        return name;

    }

    public void setName(String name) {

        this.name = name;

    }

}

```

```java

package generics.generics_in_inheritance;

public class Dog extends Animal {

    public Dog(String name) {

        super(name);

    }

}

```

Hierarchy:

```text

Object

  ^

  |

Creature

  ^

  |

Animal

  ^

  |

Dog

```

---

# 69. The Most Important Mental Model

Whenever you see:

```java

List<T>

```

think:

> "The list specifically contains T."

Therefore:

```java

List<Dog>

```

means:

> "This is specifically a List of Dog."

And:

```java

List<Animal>

```

means:

> "This is specifically a List of Animal."

They are different parameterized types.

---

# 70. When You See `?`

```java

List<?>

```

Think:

> "Some unknown type."

You don't care what it is.

---

# 71. When You See `? extends`

```java

List<? extends Animal>

```

Think:

> "Some unknown Animal subtype."

Diagram:

```text

        Animal

       /     \

     Dog     Cat

      \       /

       \     /

       unknown

```

You can safely read:

```java

Animal animal = list.get(0);

```

But you cannot safely add.

---

# 72. When You See `? super`

```java

List<? super Animal>

```

Think:

> "Some unknown supertype of Animal."

Diagram:

```text

Object

   ^

   |

Creature

   ^

   |

Animal

```

You can safely add:

```java

list.add(new Animal(...));

list.add(new Dog(...));

```

But when reading:

```java

Object object = list.get(0);

```

is the safe type.

---

# 73. Master Table

| Syntax | Meaning | Read As | Add |

|---|---|---|---|

| `List<T>` | Exactly T | T | T |

| `List<?>` | Unknown type | Object | Nothing specific |

| `List<? extends Animal>` | Animal or subtype | Animal | Nothing specific |

| `List<? super Animal>` | Animal or supertype | Object | Animal |

---

# 74. Generic Class vs Generic Method

### Generic Class

```java

class Pair<T, V> {

    T x;

    V y;

}

```

`T` and `V` belong to the class.

Instance members can use them.

---

### Generic Method

```java

static <T> T getValue(T value) {

    return value;

}

```

`T` belongs to the method.

Every invocation can infer a different `T`.

Example:

```java

getValue("Hello"); // T = String

getValue(10);      // T = Integer

getValue(10.5);    // T = Double

```

---

# 75. Static Generic Rule

Remember:

```text

Class generic parameter

        |

        v

        T

        |

        +---- Instance members -> can use T

        |

        +---- Static members   -> cannot directly use T

```

But:

```java

static <T> T method(T value)

```

is valid because the method declares its own `T`.

---

# 76. Four Static Generic Method Patterns

```text

1. No args + No return

static void method()

2. Args + No return

static <T> void method(T value)

3. Args + Return

static <T> T method(T value)

4. No args + Return

static <T> T method()

```

The fourth case usually needs explicit type information if there is no other context.

---

# 77. Wildcard Cheat Sheet

```text

?

Unknown type

? extends T

T or subtype

Producer

Read T

? super T

T or supertype

Consumer

Write T

Read Object

```

---

# 78. PECS Cheat Sheet

```text

P -> Producer

E -> Extends

C -> Consumer

S -> Super

```

Or simply:

```text

Producer -> ? extends T

Consumer -> ? super T

```

---

# 79. Real-World Example

Suppose you have:

```java

class Animal {

    void eat() {}

}

class Dog extends Animal {

    void bark() {}

}

class Cat extends Animal {

    void meow() {}

}

```

### Method only reads animals

```java

static void printAnimals(List<? extends Animal> animals) {

    for (Animal animal : animals)

        animal.eat();

}

```

Can accept:

```text

List<Dog>

List<Cat>

List<Animal>

```

---

### Method adds animals

```java

static void addAnimals(List<? super Animal> animals) {

    animals.add(new Dog());

    animals.add(new Cat());

}

```

Can accept:

```text

List<Animal>

List<Object>

```

and any valid supertype of Animal.

---

# 80. Why Wildcards Exist

Without wildcards:

```java

static void printAnimals(List<Animal> animals)

```

is too restrictive.

It rejects:

```text

List<Dog>

List<Cat>

```

Even though both contain Animals.

With:

```java

List<? extends Animal>

```

we can say:

> "I don't care about the exact subtype. Just guarantee that whatever comes out is an Animal."

Similarly:

```java

List<? super Animal>

```

allows us to say:

> "I don't care about the exact supertype. Just guarantee that it can safely store Animals."

---

# 81. Final Concept Map

```text

                         JAVA GENERICS

                              |

             +----------------+----------------+

             |                                 |

        Generic Classes                   Generic Methods

             |                                 |

       Pair<T, V>                         <T> T method()

             |                                 |

             |                                 |

        Type Safety                    Method-level T

             |                                 |

             +---------------+-----------------+

                             |

                        Inheritance

                             |

                      Generic Invariance

                             |

                 List<Dog> != List<Animal>

                             |

                         Wildcards

                             |

             +---------------+---------------+

             |               |               |

             ?          ? extends T       ? super T

             |               |               |

         Unknown          Upper bound      Lower bound

             |               |               |

          Object          Read as T       Write T

             |               |               |

             |           Producer         Consumer

             |               |               |

             |               +-------+-------+

             |                       |

             |                      PECS

             |                       |

             +-----------------------+

```

---

# 82. Final Rules to Memorize

## Rule 1

```text

Generics provide compile-time type safety.

```

## Rule 2

```text

Generic types are invariant.

List<Dog> is NOT List<Animal>

```

## Rule 3

```text

? = unknown type

```

## Rule 4

```text

? extends T

T or subtype

Producer

Read T

```

## Rule 5

```text

? super T

T or supertype

Consumer

Write T

Read Object

```

## Rule 6

```text

PECS

Producer Extends

Consumer Super

```

## Rule 7

```text

Class-level T cannot be directly used by static members.

```

## Rule 8

Static methods can declare their own generic type:

```java

static <T> T method(T value)

```

## Rule 9

```text

<T extends Animal>

```

and:

```text

<? extends Animal>

```

are not the same.

```text

<T extends Animal>

    |

    +---- Named type parameter

<? extends Animal>

    |

    +---- Unknown type

```

## Rule 10

`List<?>` is NOT the same as `List<Object>`.

```text

List<?>       -> List of unknown type

List<Object>  -> List specifically parameterized with Object

```

---

# 83. One-Minute Revision

If you forget everything else, remember this:

```text

                 GENERICS

                    |

                    v

             Compile-time

             type safety

                    |

                    v

          Generic types are

             invariant

                    |

                    v

          List<Dog> != List<Animal>

                    |

                    v

               WILDCARDS

                    |

        +-----------+-----------+

        |           |           |

        ?       ? extends     ? super

        |           |           |

     unknown     upper bound  lower bound

                    |           |

                 Producer    Consumer

                    |           |

                 READ T      WRITE T

                    |           |

                    +-----------+

                         |

                        PECS

                         |

             Producer Extends

             Consumer Super

```

The three most important examples:

```java

// Unknown type

List<?> list;

// Producer

List<? extends Animal> animals;

// Consumer

List<? super Animal> animals;

```

And the most important rule:

```text

If I GET values -> ? extends

If I PUT values -> ? super

If I don't care about the type -> ?

```

---

# 84. Recommended Practice Order

Practice Generics in this order:

1. `Object` vs Generics

2. Generic class `Pair<T, V>`

3. Type parameters vs type arguments

4. Generic methods

5. Static generic methods

6. Generic primitive limitation

7. Autoboxing / unboxing

8. Generic inheritance

9. Invariance

10. `List<?>`

11. `List<? extends Animal>`

12. `List<? super Animal>`

13. PECS

14. `<T extends Animal>`

15. `<T extends Animal & Runnable>`

16. Wildcard vs type parameter

17. Raw types

18. Type erasure

19. Heap pollution

20. Wildcard capture

21. Generic arrays

A very effective exercise is to look at each method signature and predict:

```text

1. Which calls compile?

2. Which calls fail?

3. What can I read?

4. What can I add?

5. What is the compile-time type of the returned value?

```

Once these become intuitive, Java Collections such as `List`, `Set`, `Map`, `Comparator`, `Collections`, and Stream APIs become much easier to understand.