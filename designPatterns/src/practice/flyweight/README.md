# 🪶 Flyweight Design Pattern

A complete guide to understanding, implementing, and applying the Flyweight Design Pattern in Java.

---

## 📚 Table of Contents

1. [Introduction](#1-introduction)
2. [What Problem Does Flyweight Solve?](#2-what-problem-does-flyweight-solve)
3. [Definition](#3-definition)
4. [Pattern Classification](#4-pattern-classification)
5. [Core Idea](#5-core-idea)
6. [Intrinsic vs Extrinsic State](#6-intrinsic-vs-extrinsic-state)
7. [Basic Structure & Participants](#7-basic-structure--participants)
8. [Basic Java Implementation](#8-basic-java-implementation)
9. [How Flyweight Works](#9-how-flyweight-works)
10. [The Flyweight Factory](#10-the-flyweight-factory)
11. [Object Sharing](#11-object-sharing)
12. [Immutability](#12-immutability)
13. [Flyweight Keys & equals()/hashCode()](#13-flyweight-keys--equalshashcode)
14. [computeIfAbsent()](#14-computeifabsent)
15. [Thread Safety](#15-thread-safety)
16. [Flyweight Lifecycle](#16-flyweight-lifecycle)
17. [Real-World Examples](#17-real-world-examples)
18. [Flyweight + Other Concepts](#18-flyweight--other-concepts)
19. [Memory Optimization](#19-memory-optimization)
20. [Flyweight vs Other Patterns](#20-flyweight-vs-other-patterns)
21. [Common Implementation Mistakes](#21-common-implementation-mistakes)
22. [When to Use / Not Use Flyweight](#22-when-to-use--not-use-flyweight)
23. [Machine Coding Approach](#23-machine-coding-approach)
24. [Machine Coding Examples](#24-machine-coding-examples)
25. [Interview Questions](#25-interview-questions)
26. [Common Interview Follow-Ups](#26-common-interview-follow-ups)
27. [30-Second Interview Explanation](#27-30-second-interview-explanation)
28. [Machine Coding Checklist](#28-machine-coding-checklist)
29. [Final Mental Model & Summary](#29-final-mental-model--summary)

---

## 1. Introduction

The **Flyweight Design Pattern** is a structural design pattern used to reduce memory consumption when a large number of objects contain repeated data.

> **Main idea:** Share common state between multiple objects instead of storing the same state repeatedly.

**Example:** imagine a game with one million trees. A naive implementation:

```java
Tree tree1 = new Tree("Oak", "oak.png", "Green", 20, 10, 20);
Tree tree2 = new Tree("Oak", "oak.png", "Green", 20, 50, 80);
Tree tree3 = new Tree("Oak", "oak.png", "Green", 20, 100, 120);
```

Notice `"Oak"`, `"oak.png"`, `"Green"`, and `20` **repeat** across every tree — only `x` and `y` differ.

Flyweight separates these two kinds of state and **shares** the repeated part.

---

## 2. What Problem Does Flyweight Solve?

Suppose we have **1,000,000 objects**, each containing:

- 100 bytes of *common* data
- 20 bytes of *unique* data

Storing the common data independently in every object wastes memory unnecessarily.

Instead:

```
                Shared Data
                     │
        ┌────────────┼────────────┐
        ▼            ▼            ▼
     Object        Object        Object
   (unique data) (unique data) (unique data)
```

The shared data is stored **once**; each object keeps only its unique state plus a reference to the shared object.

---

## 3. Definition

> **Flyweight** is a structural design pattern that minimizes memory usage by sharing common *intrinsic* state between multiple objects while keeping unique *extrinsic* state outside the shared object.

Key terms: **intrinsic state · extrinsic state · Flyweight · Flyweight Factory · Context.**

---

## 4. Pattern Classification

Flyweight belongs to the **Structural Design Patterns** — patterns that focus on how objects and classes are composed.

| Structural patterns |
|---|
| Adapter · Bridge · Composite · Decorator · Facade · **Flyweight** · Proxy |

---

## 5. Core Idea

```
Many Objects
   ↓
Find Repeated State
   ↓
Separate Shared State
   ↓
Create Flyweight
   ↓
Keep Unique State Outside
   ↓
Reuse Flyweight
```

Instead of each object owning its own copy of common state:

```
Object 1 → own common state
Object 2 → own common state
Object 3 → own common state
```

we share one copy:

```
                Common State
                     │
        ┌────────────┼────────────┐
        ▼            ▼            ▼
     Object 1      Object 2     Object 3
```

---

## 6. Intrinsic vs Extrinsic State

### Intrinsic State

State that:
- is common between multiple objects
- does not depend on a specific object
- can be safely shared
- is usually immutable

**Example — `TreeType`:** `name`, `image`, `color`, `height`. For multiple Oak trees, `Oak / oak.png / Green / 20` can be shared. Intrinsic state belongs to the **Flyweight**.

### Extrinsic State

State that:
- varies between objects
- depends on the object / context
- cannot generally be shared

**Example — a tree's `x`, `y`** — different for every tree instance.

### Side-by-Side Comparison

| | Intrinsic State | Extrinsic State |
|---|---|---|
| Sharing | Shared | Unique |
| Stored in | Flyweight | Context |
| Mutability | Usually immutable | Usually object-specific |
| Reuse | Can be reused | Cannot be blindly shared |
| Effect | Reduces memory | Represents the individual object |

```
Tree                       (context — extrinsic)
 ├── x
 ├── y
 └── TreeType ──────────►  TreeType    (flyweight — intrinsic, shared)
                             ├── name
                             ├── image
                             ├── color
                             └── height
```

---

## 7. Basic Structure & Participants

```
Client → Context → Flyweight ◄── FlyweightFactory → Map<Key, Flyweight>
```

### Flyweight

Contains shared intrinsic state.

```java
public class TreeType {
    private final String name;
    private final String image;

    public TreeType(String name, String image) {
        this.name = name;
        this.image = image;
    }
}
```

### Context

Contains extrinsic state, plus a reference to its Flyweight.

```java
public class Tree {
    private final int x;
    private final int y;
    private final TreeType treeType;

    public Tree(int x, int y, TreeType treeType) {
        this.x = x;
        this.y = y;
        this.treeType = treeType;
    }
}
```

### Flyweight Factory

Responsible for:
- creating Flyweights
- storing Flyweights
- returning existing Flyweights
- preventing unnecessary duplication

Typically backed by a `Map<Key, Flyweight>`.

### Client

The client requests Flyweights from the factory, creates Context objects, and supplies extrinsic state where needed.

---

## 8. Basic Java Implementation

```java
import java.util.HashMap;
import java.util.Map;

class CharacterStyle {
    private final String font;
    private final int size;

    public CharacterStyle(String font, int size) {
        this.font = font;
        this.size = size;
    }

    public void render(char character, int position) {
        System.out.println(
            "Rendering " + character + " at " + position
                + " using " + font + " size " + size
        );
    }
}

class CharacterStyleFactory {
    private final Map<String, CharacterStyle> styles = new HashMap<>();

    public CharacterStyle getStyle(String font, int size) {
        String key = font + "-" + size;
        return styles.computeIfAbsent(
            key,
            ignored -> new CharacterStyle(font, size)
        );
    }
}
```

---

## 9. How Flyweight Works

```
Client
  │ request shared object
  ▼
FlyweightFactory
  │ check key
  ├─ exists ─────────► return existing object
  └─ doesn't exist
        │
        ▼
     create Flyweight
        │
        ▼
     store in Map
        │
        ▼
     return Flyweight
```

Repeated requests for the same intrinsic state return the **same object**.

---

## 10. The Flyweight Factory

One of the most important parts of the pattern.

```java
public class TreeTypeFactory {
    private final Map<TreeTypeKey, TreeType> treeTypes = new HashMap<>();

    public TreeType getTreeType(TreeTypeKey key) {
        return treeTypes.computeIfAbsent(key, ignored -> createTreeType(key));
    }

    private TreeType createTreeType(TreeTypeKey key) {
        return new TreeType(key.getName(), key.getImage());
    }
}
```

The factory guarantees that equivalent intrinsic state reuses the same Flyweight.

---

## 11. Object Sharing

```java
TreeType oak1 = factory.getTreeType("Oak", "oak.png", "Green", 20);
TreeType oak2 = factory.getTreeType("Oak", "oak.png", "Green", 20);

System.out.println(oak1 == oak2);   // true
```

```
oak1 ──┐
       ├──► TreeType   (one shared instance)
oak2 ──┘
```

---

## 12. Immutability

Flyweight objects should generally be **immutable**.

```java
public class TreeType {
    private final String name;
    private final String image;
    private final String color;
    private final int height;

    public TreeType(String name, String image, String color, int height) {
        this.name = name;
        this.image = image;
        this.color = color;
        this.height = height;
    }
    // no setters
}
```

**Why?** If 10,000 objects share the same mutable Flyweight and one client modifies it, every other client observes the change.

```
Shared Flyweight → Immutable → Safe to share
```

---

## 13. Flyweight Keys & equals()/hashCode()

The factory needs a **key** to determine whether two requests represent the same Flyweight — the key represents the intrinsic state.

```java
public class TreeTypeKey {
    private final String name;
    private final String image;
    private final String color;
    private final int height;

    public TreeTypeKey(String name, String image, String color, int height) {
        this.name = name;
        this.image = image;
        this.color = color;
        this.height = height;
    }
}
```

When a custom key is used inside a `HashMap` / `ConcurrentHashMap`, correct equality semantics are required:

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) {
        return true;
    }
    if (!(obj instanceof TreeTypeKey other)) {
        return false;
    }
    return height == other.height
        && Objects.equals(name, other.name)
        && Objects.equals(image, other.image)
        && Objects.equals(color, other.color);
}

@Override
public int hashCode() {
    return Objects.hash(name, image, color, height);
}
```

> ⚠️ Without correct `equals()`/`hashCode()`, the factory may incorrectly create duplicate Flyweights.

---

## 14. computeIfAbsent()

A very useful API for Flyweight implementations:

```java
map.computeIfAbsent(key, ignored -> createFlyweight());
```

Conceptually:

```
if key exists → return existing object
else          → create, store, and return the object
```

Especially useful for factory-based Flyweight implementations.

---

## 15. Thread Safety

If multiple threads can request Flyweights concurrently, the factory needs to be thread-safe — use `ConcurrentHashMap` instead of `HashMap`:

```java
private final Map<TreeTypeKey, TreeType> treeTypes = new ConcurrentHashMap<>();
```

```java
return treeTypes.computeIfAbsent(key, ignored -> new TreeType(/* ... */));
```

This gives a much safer concurrent implementation.

---

## 16. Flyweight Lifecycle

```
1. Client requests Flyweight
       ↓
2. Factory receives intrinsic state
       ↓
3. Factory creates a key
       ↓
4. Factory checks its Map
       ↓
5. Existing Flyweight?
       ├─ Yes → return it
       └─ No  → create → store → return it
```

---

## 17. Real-World Examples

### Text Editor

A document may contain millions of characters, each with `character`, `position`, `font`, `size`, `color`, `bold`, `italic`. Many characters share the same formatting (e.g. `Arial / 14 / Black / Bold`).

```
Character                    TextStyle   (Flyweight)
 ├── character                 ├── font
 ├── position                  ├── size
 └── TextStyle reference       ├── color
                                ├── bold
                                └── italic
```

### Game Map

A map may contain millions of tiles, with only a handful of terrain types (`GRASS`, `WATER`, `MOUNTAIN`, `DESERT`, `FOREST`).

```
MapTile                      TerrainType   (Flyweight)
 ├── row                       ├── name
 ├── column                    ├── texture
 └── terrainType                ├── movementCost
                                 └── color
```

### Logging

Millions of log entries may share a handful of log levels (`INFO`, `DEBUG`, `WARN`, `ERROR`, `TRACE`).

```
LogEntry                     LogLevel   (Flyweight)
 ├── timestamp                 ├── name
 ├── message                   ├── severity
 └── logLevel                  └── color
```

### Product Catalog

Millions of products may share a handful of product types (`Electronics`, `Furniture`, `Clothing`, `Books`).

```
Product                      ProductType   (Flyweight)
 ├── productId                  ├── category
 ├── name                       ├── defaultImage
 ├── price                      ├── taxCategory
 ├── stock                      └── shippingClass
 └── ProductType
```

### UI Icons

Thousands of buttons may reuse a handful of icons (`SAVE`, `DELETE`, `EDIT`, `SEARCH`, `DOWNLOAD`).

```
Button                        Icon   (Flyweight)
 ├── x                          ├── name
 ├── y                          ├── image
 ├── label                      ├── width
 └── Icon                       └── height
```

### Game Characters

Thousands of soldiers may share a handful of soldier types.

```
Soldier                      SoldierType   (Flyweight)
 ├── x                          ├── uniform
 ├── y                          ├── weapon
 ├── id                         ├── texture
 └── SoldierType                ├── movementSpeed
                                 └── health
```

---

## 18. Flyweight + Other Concepts

### Flyweight + Factory

Related, but with different responsibilities:

| | Answers |
|---|---|
| Factory | *"How should the object be created/retrieved?"* |
| Flyweight | *"Which state can be shared?"* |

```
Client → FlyweightFactory → Map<Key, Flyweight> → Flyweight
```

The factory manages the shared objects.

### Flyweight + SOLID

| Principle | How Flyweight applies |
|---|---|
| **Single Responsibility** | Flyweight holds shared state + behavior; Factory handles creation/reuse; Context holds object-specific state — kept as separate classes. |
| **Open/Closed** | New Flyweight types (`TreeType`, `TerrainType`, `Icon`, `TextStyle`) can be added without changing the sharing mechanism. |
| **Liskov Substitution** | If Flyweights share a common abstraction (e.g. `interface Renderable { void render(int x, int y); }`), implementations stay substitutable. |
| **Interface Segregation** | The Flyweight interface should only expose behavior clients actually need — avoid bloated interfaces. |
| **Dependency Inversion** | Higher-level code can depend on an abstraction (e.g. a `TerrainTypeFactory` interface) rather than a concrete Flyweight implementation. |

### Flyweight + Immutability

```
Shared State → Immutable → Safe to share → Used by many contexts
```

```java
private final String name;
private final String texture;
private final int movementCost;
// no setters
```

### Flyweight + Dependency Injection

In larger applications, the Flyweight Factory can be a shared dependency:

```
Application → FlyweightFactory → shared Flyweight A / B / C
```

Different services reuse the same factory rather than maintaining independent Flyweight collections.

### Flyweight + Thread Safety

```java
private final Map<Key, Flyweight> flyweights = new ConcurrentHashMap<>();

flyweights.computeIfAbsent(key, ignored -> createFlyweight(key));
```

The Flyweights themselves should preferably stay immutable.

---

## 19. Memory Optimization

**Without Flyweight** — 1,000,000 `Tree` objects, each storing everything:

```
Tree
 ├── x
 ├── y
 ├── name
 ├── image
 ├── color
 └── height
```

**With Flyweight:**

```
Tree                          TreeType
 ├── x                          ├── name
 ├── y                          ├── image
 └── TreeType reference         ├── color
                                 └── height
```

If there are only **10 distinct TreeTypes**, the large repeated state exists 10 times instead of one million times.

---

## 20. Flyweight vs Other Patterns

### Flyweight vs Factory

| Flyweight | Factory |
|---|---|
| Shares objects | Creates objects |
| Focuses on memory | Focuses on creation |
| Separates intrinsic/extrinsic state | Encapsulates creation logic |
| Reuses existing instances | May or may not reuse instances |
| Often *uses* a factory internally | Can exist independently |

> A Factory can be used to *implement* Flyweight, but a Factory itself is not a Flyweight.

### Flyweight vs Decorator

| Flyweight | Decorator |
|---|---|
| Shares common state | Adds behavior dynamically |
| `Object A → shared Flyweight` | `Service → LoggingDecorator → MetricsDecorator → ActualService` |

> Flyweight optimizes shared state; Decorator adds behavior.

### Flyweight vs Proxy

| Flyweight | Proxy |
|---|---|
| Focus: sharing state | Focus: controlling access to another object |
| — | Examples: lazy loading, access control, remote objects, caching, logging |

> Flyweight is primarily about reducing memory through sharing.

### Flyweight vs Adapter

| Adapter | Flyweight |
|---|---|
| Changes one interface into another | Shares common state |
| `Client → Adapter → Existing incompatible class` | `Many Contexts → Shared Flyweight` |

> Adapter changes interface; Flyweight shares state.

### Flyweight vs Singleton

| Singleton | Flyweight |
|---|---|
| Exactly **one** instance total | Potentially **many** shared instances |
| `Client A/B/C → one Singleton` | `Factory → TreeType A / B / C` |

> Singleton = one globally shared instance. Flyweight = potentially many shared instances, each representing a different intrinsic state.

### Flyweight vs Object Pool

| Flyweight | Object Pool |
|---|---|
| Object is shared **simultaneously** by many clients | Object is **borrowed and returned** |
| `Client A/B/C → same Flyweight, all at once` | `Pool → Object → Client → returned to Pool` |
| Good for immutable/common shared state | Good for expensive reusable resources (DB connections, threads, network resources) |

### Flyweight vs Cache

| Cache | Flyweight |
|---|---|
| Avoids repeated work or retrieval | Avoids duplicate shared object *state* |
| General-purpose technique | Specifically: shared intrinsic state + object reuse + memory optimization |

> A Flyweight implementation may internally use a `Map` like a cache, but the *intent* differs.

---

## 21. Common Implementation Mistakes

| # | Mistake | Why it's a problem |
|---|---|---|
| 1 | **Putting extrinsic state in the Flyweight** — e.g. `class TreeType { int x; int y; }` | The Flyweight can no longer be safely shared. |
| 2 | **Mutable Flyweights** — e.g. `treeType.setColor("RED");` | If many objects share the instance, all of them are affected. |
| 3 | **Creating Flyweights directly** — `new TreeType(...)` instead of `factory.getTreeType(...)` | Bypasses the sharing mechanism entirely. |
| 4 | **Incorrect key** | If the key doesn't include all intrinsic properties, two different Flyweights may be incorrectly treated as the same object. |
| 5 | **Missing `equals()`/`hashCode()`** | Custom keys in hash-based collections need correct equality semantics, or duplicates slip through. |
| 6 | **Using Flyweight everywhere** | Not every object needs it — the pattern adds factory logic, maps, keys, and indirection. Use it only when the memory benefit justifies the complexity. |

---

## 22. When to Use / Not Use Flyweight

### ✅ Use Flyweight when

- There are **many objects**
- They share **repeated common state**
- That common state is **expensive** to duplicate
- The state **can be shared safely** (i.e., is immutable)
- **Memory usage** genuinely matters

**Typical domains:** text editors, game engines, map rendering, character rendering, UI components, icons, product catalogs, logging systems, notification templates, document formatting.

### ❌ Avoid Flyweight when

- There are only a few objects
- Objects are very small
- Very little state is duplicated
- Shared state is frequently mutable
- The factory would introduce unnecessary complexity
- Memory usage isn't a real concern
- Profiling doesn't indicate a problem

---

## 23. Machine Coding Approach

A step-by-step process for tackling a Flyweight problem in an interview:

| Step | Action |
|---|---|
| 1 | **Identify object count** — are there potentially thousands or millions of objects? If not, Flyweight may not be necessary. |
| 2 | **Identify repeated data** — e.g. `font`, `image`, `color`, `texture`, `template`, `category` |
| 3 | **Identify unique data** — e.g. `x`, `y`, `id`, `timestamp`, `recipient`, `position` |
| 4 | **Separate the state** into `Flyweight` + `Context` |
| 5 | **Create a key** representing the intrinsic state |
| 6 | **Create the Factory**, backed by `Map<Key, Flyweight>` |
| 7 | **Make the Flyweight immutable** — `private final` fields, no setters |
| 8 | **Consider thread safety** — use `ConcurrentHashMap` if concurrent access is expected |
| 9 | **Verify sharing** — check with `object1 == object2` |

---

## 24. Machine Coding Examples

### Game Map

```
GameMap
 ├── TerrainTile { row, column, TerrainType }
 ├── TerrainTile { row, column, TerrainType }
 └── TerrainTile { row, column, TerrainType }
        │
        ▼
 TerrainTypeFactory → GRASS / WATER / MOUNTAIN / DESERT
```

| Intrinsic | Extrinsic |
|---|---|
| `TerrainType` | `TerrainTile` (row, column) |

### Tree Rendering

```
Tree { x, y, TreeType }
```

```
Tree 1 ─┐
Tree 2 ─┤
Tree 3 ─┼──► Oak TreeType   (shared)
Tree 4 ─┤
Tree 5 ─┘
```

### Notification Templates

```
Notification 1 ─┐
Notification 2 ─┤
Notification 3 ─┼──► EmailTemplate   (shared, intrinsic)
Notification 4 ─┤
Notification 5 ─┘
```

`recipient` and `data` are extrinsic:

```java
Notification { recipient, data, template }
```

### Document Formatting

```
Millions of characters
   │
   ▼
Character objects, each with: character, position, TextStyle reference
   │
   ├── shared TextStyle
   ├── shared TextStyle
   └── shared TextStyle
```

`TextStyle` holds `fontFamily`, `fontSize`, `bold`, `italic`, `color` — dramatically reducing duplicated formatting data.

---

## 25. Interview Questions

| # | Question | Answer |
|---|---|---|
| 1 | What is Flyweight? | A structural pattern that reduces memory usage by sharing common intrinsic state between objects, while keeping extrinsic state outside the shared object. |
| 2 | Why is Flyweight used? | To reduce memory consumption when many objects share common data. |
| 3 | What is intrinsic state? | Common, shareable state that doesn't depend on an individual object. |
| 4 | What is extrinsic state? | Object-specific state that varies between instances. |
| 5 | Where should intrinsic state live? | Inside the Flyweight. |
| 6 | Where should extrinsic state live? | Inside the Context object, or passed as a method parameter. |
| 7 | Why is immutability important? | The same Flyweight can be referenced by many objects — mutation could unexpectedly affect all of them. |
| 8 | What does the Flyweight Factory do? | Manages the lifecycle and reuse of Flyweight instances. |
| 9 | Can Flyweight objects have behavior? | Yes — behavior that operates using extrinsic state supplied by the caller. |
| 10 | Is Flyweight the same as Singleton? | No — Singleton guarantees one instance; Flyweight allows multiple shared instances for different intrinsic states. |
| 11 | Is Flyweight the same as caching? | No — caching is a broader technique for avoiding repeated work/retrieval; Flyweight specifically shares common object state to reduce memory. |
| 12 | Is Flyweight always beneficial? | No — it adds complexity and lookup overhead. Use it only when object count and duplicated state justify it. |

---

## 26. Common Interview Follow-Ups

**"What happens if Flyweight state is mutable?"**
Changes made through one client could affect every other client sharing that instance — so Flyweights should generally be immutable.

**"How would you make the factory thread-safe?"**
Use a concurrent collection such as `ConcurrentHashMap`, paired with an atomic lookup/create operation like `computeIfAbsent()`.

**"How do you identify whether two Flyweights are the same?"**
Use a key representing the complete intrinsic state, with correctly implemented `equals()` and `hashCode()` for hash-based collections.

**"Where do you put location information?"**
Location is usually extrinsic — pass it in, e.g. `tree.render(x, y);`, rather than storing `x`/`y` inside the shared `TreeType`.

**"Can different Flyweights exist?"**
Yes — e.g. `Grass`, `Water`, `Mountain`, `Desert`, `Forest` each represent a different intrinsic state.

---

## 27. 30-Second Interview Explanation

> Flyweight is a structural design pattern used to reduce memory consumption when a large number of objects share common state. We divide state into intrinsic and extrinsic state. Intrinsic state is common, immutable, and stored in the Flyweight. Extrinsic state is object-specific and stored in the Context. A `FlyweightFactory` manages and reuses Flyweight objects, usually using a `Map` keyed by the intrinsic state. This lets many objects share the same Flyweight instead of duplicating the same data.

---

## 28. Machine Coding Checklist

- [ ] Identify whether there are many objects
- [ ] Find repeated state
- [ ] Separate intrinsic state
- [ ] Separate extrinsic state
- [ ] Create Flyweight
- [ ] Create Context
- [ ] Create Flyweight key
- [ ] Implement `equals()`
- [ ] Implement `hashCode()`
- [ ] Create FlyweightFactory
- [ ] Store Flyweights in a Map
- [ ] Reuse existing Flyweights
- [ ] Make Flyweights immutable
- [ ] Consider thread safety
- [ ] Use `ConcurrentHashMap` when required
- [ ] Use `computeIfAbsent()`
- [ ] Keep unique state outside the Flyweight
- [ ] Provide a working client
- [ ] Verify object sharing
- [ ] Explain memory benefits
- [ ] Discuss trade-offs

---

## 29. Final Mental Model & Summary

### Mental Model

```
                     CLIENT
                       │
                       ▼
                  ┌──────────┐
                  │ Context  │
                  │ (unique  │
                  │  state)  │
                  └────┬─────┘
                       │ references
                       ▼
                  ┌──────────┐
                  │ Flyweight│
                  │ (shared  │
                  │  state)  │
                  └────▲─────┘
                       │
                  ┌────┴─────┐
                  │ Factory  │
                  │ Map<Key, │
                  │Flyweight>│
                  └──────────┘
```

```
Many Objects
   ↓
Find Repeated State
   ↓
Separate Intrinsic State
   ↓
Create Flyweight
   ↓
Keep Extrinsic State in Context
   ↓
Create Factory
   ↓
Store Flyweights in Map
   ↓
Reuse Flyweights
```

### The 10 Core Ideas

| # | Concept | Summary |
|---|---|---|
| 1 | **Intrinsic State** | Shared state — `font`, `color`, `texture`, `image`, `template`, `category` |
| 2 | **Extrinsic State** | Unique state — `x`, `y`, `position`, `recipient`, `id`, `timestamp` |
| 3 | **Flyweight** | Stores intrinsic state and is shared |
| 4 | **Context** | Stores extrinsic state and references the Flyweight |
| 5 | **Flyweight Factory** | Creates, stores, and reuses Flyweights |
| 6 | **Immutability** | Flyweights should generally be immutable, since they're shared |
| 7 | **Thread Safety** | Use concurrent collections when multiple threads access the factory |
| 8 | **Key** | Represents intrinsic state; lets the factory identify reusable Flyweights |
| 9 | **Main Benefit** | Reduced memory consumption for large numbers of similar objects |
| 10 | **Main Trade-off** | Added complexity and lookup/indirection overhead |

### 🧠 Final Definition to Remember

> **Flyweight** is a structural design pattern that shares common intrinsic state between multiple objects while keeping unique extrinsic state outside the shared object, reducing memory consumption when a large number of similar objects are required.

```
MANY OBJECTS
   ↓
Find Common Data
   ↓
Separate Shared Data
   ↓
Flyweight
   ↓
Store in Factory / Map
   ↓
Reuse Object
   ↓
Keep Unique Data in Context
```

**Remember:** Flyweight = share common state, keep unique state outside.
