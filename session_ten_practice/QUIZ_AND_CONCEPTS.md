# Category B: Comprehensive Assessment — Quiz & Concept Solutions

## Part B: Quiz Questions & Answers

### Q1. Accessing Members from Derived Class
- **Question:** Consider the given UML class diagram. If Student is a derived type of Person, which members are directly accessible within the Student class?
- **Correct Answer:** **B. # age and + getName()**
- **Explanation:** In UML, `-` indicates `private`, `#` indicates `protected`, and `+` indicates `public`. Derived classes inherit and can directly access `protected` and `public` members of their superclass, while `private` members (`- name`) remain encapsulated and inaccessible directly.

---

### Q2. Invalid Class Inheritance Structure
- **Question:** Examine the three UML diagrams representing class hierarchies. Which diagram illustrates an invalid class inheritance structure, assuming a language that supports single class inheritance?
- **Correct Answer:** **C. Diagram 3, where a class attempts to extend two different classes.**
- **Explanation:** In object-oriented languages with single class inheritance (such as Java), a class cannot directly extend more than one superclass. Diagram 3 depicts multiple inheritance (`Class S --|> Q` and `Class S --|> R`), which is invalid for classes.

---

### Q3. Constructor Invocation Order
- **Question:** Based on the sequence diagram for creating a Manager object, which represents a derived type, in what order will the constructors be executed? Assume Manager extends Employee, and Employee extends Person.
- **Correct Answer:** **B. Person -> Employee -> Manager**
- **Explanation:** Constructor execution strictly follows top-down inheritance order: the base class constructor executes first to initialize fundamental state, followed progressively down the hierarchy to the most derived class.

---

### Q4. Member Access & Method Modifiers in Subclass
- **Question:** Consider a Derived class inheriting from a Base class as shown in the UML. Which of the following statements about accessing Base members or modifying Base operations from within Derived is correct?
- **Correct Answer:** **C. Derived can directly access protectedField.**
- **Explanation:** Protected fields are accessible to subclasses. Private fields cannot be accessed directly, methods marked `{final}` cannot be overridden, and overriding methods cannot assign weaker access privileges (e.g., cannot reduce `public` to `protected` or `private`).

---

### Q5. Dynamic Method Dispatch on Overridden Method
- **Question:** Given the UML class diagram where Bus extends Vehicle, and both classes define a fare() method. If a Vehicle reference points to a Bus object, and fare() is called through this reference, which version of the fare() operation will run?
- **Correct Answer:** **B. The fare() method defined in Bus.**
- **Explanation:** At runtime, Java utilizes dynamic method dispatch to invoke the method implementation belonging to the actual runtime object type (`Bus`), demonstrating runtime polymorphism.

---

### Q6. Overloading vs. Overriding Distinction
- **Question:** In the given UML diagram, Printer has two print methods with different parameters, and SpecialPrinter redefines one of them. Which statement correctly identifies the distinction between overloading and overriding?
- **Correct Answer:** **B. print(text: String) and print(data: int) in Printer are examples of overloading, and SpecialPrinter's print(text: String) is an example of overriding.**
- **Explanation:** Overloading consists of methods in the same scope having identical names but differing parameter signatures. Overriding involves a subclass redefining an inherited method with the exact same name and parameter signature.

---

### Q7. Direct Access via Upcasted Reference
- **Question:** If a Shape reference s is assigned a Circle object (upcasting), which of the following members can be accessed directly using the s reference?
- **Correct Answer:** **A. Only members defined in the Shape class.**
- **Explanation:** The compiler enforces type safety based on the reference type (`Shape`). Subclass-specific members (`radius`, `calculateArea()`) cannot be directly accessed through a superclass reference without an explicit downcast.

---

### Q8. Polymorphic Method Call in Array Iteration
- **Question:** Consider an array shapes of type Shape that holds a Circle object at index 0 and a Square object at index 1. Both Circle and Square override the area() method inherited from Shape. What is the expected behavior when a loop iterates through shapes and calls area() on each element?
- **Correct Answer:** **C. The area() method specific to Circle will be called for shapes[0], and the area() method specific to Square will be called for shapes[1].**
- **Explanation:** Polymorphic dispatch evaluates each element's runtime type upon invocation, correctly executing `Circle.area()` for index 0 and `Square.area()` for index 1.

---

### Q9. Runtime Downcasting Evaluation
- **Question:** Given an Account reference a that currently refers to a Current object. Which of the following casting attempts will succeed at runtime, and which will fail?
- **Correct Answer:** **B. s = (Savings) a; will fail, c = (Current) a; will succeed.**
- **Explanation:** Because `a` points to a `Current` object in memory, downcasting to `Current` is valid. Downcasting `a` to sibling type `Savings` results in a runtime `ClassCastException`.

---

### Q10. Benefit of Base-Type Reference Batch Processing
- **Question:** An array plans of type Plan contains objects of three different subtypes: PrepaidPlan, PostpaidPlan, and FamilyPlan. Each subtype overrides a bill() method to calculate charges differently. What is the benefit of processing these objects in a loop calling bill() on each Plan element?
- **Correct Answer:** **B. It allows uniform processing of different derived objects through a base-type reference, without needing type-specific conditional logic.**
- **Explanation:** Polymorphism decouples the caller from concrete subtypes, removing the need for `if-else` or `instanceof` blocks and facilitating clean, extensible system design (Open/Closed Principle).

---

### Q11. Abstraction vs. Encapsulation in Class Design
- **Question:** Consider a Printer class with the members shown in the UML diagram. Which of the following operations represents the essential behavior exposed to a caller, and which represent hidden details of 'how' the printer works?
- **Correct Answer:** **A. printDocument() is essential behavior; internalBuffer, loadBuffer(), and sendToPrintHead() are hidden details.**
- **Explanation:** The public method `+ printDocument()` constitutes the essential public interface (abstraction), while private buffer data and internal routing methods represent hidden implementation details (encapsulation).

---

### Q12. Abstract Class Instantiation & Subclass Referencing
- **Question:** Given the UML diagram, where Vehicle is an abstract class and Car is a concrete subclass. Which statements are true regarding the instantiation and referencing of these types?
- **Correct Answer:** **B. A Vehicle reference can refer to a Car object.**
- **Explanation:** Abstract classes cannot be instantiated directly with `new Vehicle()`. However, an abstract class reference can readily point to any concrete subclass instance (`Vehicle v = new Car()`).

---

### Q13. Consequences of Unimplemented Abstract Methods
- **Question:** In the given UML, Account is an abstract class with an abstract operation calculateFee(). SavingsAccount is a subclass of Account. If SavingsAccount does not implement calculateFee(), what will be the consequence?
- **Correct Answer:** **B. SavingsAccount must also be declared as an abstract class.**
- **Explanation:** If a subclass inherits an abstract method and does not provide a concrete implementation body, the subclass remains abstract and must be explicitly declared as `abstract`.

---

### Q14. Compilation Errors in Abstract Class Hierarchies
- **Question:** Given the abstract class Report and its subclass MonthlyReport as described in the UML. Which of the following scenarios would lead to a compilation error?
- **Correct Answer:** **B. MonthlyReport attempting to be a concrete class without implementing the abstract method generateBody().**
- **Explanation:** A non-abstract (concrete) class extending an abstract class must implement every inherited abstract method; omitting the implementation causes a compile-time error.

---

### Q15. Fundamental Role of an Interface
- **Question:** Based on the UML diagram for the Payable interface, what does an interface fundamentally specify and what does it typically not provide?
- **Correct Answer:** **A. It specifies operations a type promises to provide, but not per-object state or direct implementation.**
- **Explanation:** Interfaces declare public behavioral contracts (methods) that implementing classes must supply, without holding mutable per-object instance state or constructor logic.

---

### Q16. Implicit Modifiers in Interface Declarations
- **Question:** Given the Loggable interface in the UML diagram, which statement accurately describes the implicit visibility and modifiers of its members?
- **Correct Answer:** **B. logMessage() and getLogLevel() are implicitly public abstract.**
- **Explanation:** In Java interfaces, methods without bodies are implicitly `public abstract`. Variables/constants in an interface are implicitly `public static final`.

---

### Q17. Fulfilling Multiple Interface Realizations
- **Question:** A DataProcessor class realizes both the Serializable and Resettable interfaces as shown in the UML diagram. Which operations must the DataProcessor class implement to fulfill its contracts?
- **Correct Answer:** **C. Both serialize() from Serializable and reset() from Resettable.**
- **Explanation:** A concrete class implementing multiple interfaces enters into a binding contract with all of them, requiring implementations for all abstract operations across all realized interfaces.

---

### Q18. Choosing Appropriate Abstraction Mechanism
- **Question:** Consider a requirement for a type that needs to define a common protocol for unrelated classes to adhere to, without providing any default implementation or holding per-object state. Which type of construct would be the most appropriate choice for this requirement?
- **Correct Answer:** **C. Box C (Interface)**
- **Explanation:** An interface provides pure protocol/behavior specifications without coupling unrelated classes into an inheritance hierarchy or imposing internal state representation.

---

### Q19. UML Generalization vs. Realization
- **Question:** In the given UML diagram, classify the relationships between Dog and Animal, and Eagle and Flyable.
- **Correct Answer:** **B. Dog IS-A Animal (generalization); Eagle CAN-DO Flyable (realization).**
- **Explanation:** Class inheritance (`Dog --|> Animal`) represents generalization (**IS-A**). Interface implementation (`Eagle ..|> Flyable`) represents realization of a capability (**CAN-DO**).

---

### Q20. Standard Object Operations Inherited by Default
- **Question:** In many object-oriented languages, all classes implicitly inherit from a root type (e.g., Object in Java). Which of the following operations are commonly inherited by default by every object from this root type, and are often redefined for specific class behavior?
- **Correct Answer:** **A. equals(), hashCode(), toString()**
- **Explanation:** All Java objects inherit `equals()`, `hashCode()`, and `toString()` from `java.lang.Object`. These methods are routinely overridden to provide value equality, consistent hash bucket distribution, and readable string representations.

---

## Part C: Concept Questions & Detailed Solutions

### Question 1: Method Overloading vs. Method Overriding
- **Method Overloading:** Occurs when methods within the same class (or inherited) have the same name but different parameter lists (types, number, or order of arguments). Overloading is resolved at **compile-time** (static binding) based on the reference type and declared arguments.
- **Method Overriding:** Occurs when a subclass re-implements an inherited method using the exact same signature and return type. Overriding is resolved at **run-time** (dynamic binding / dynamic method dispatch) based on the actual object instance in memory.

---

### Question 2: Sequence of Constructor Invocation & Base Constructor Chaining
When a derived class object is created, constructors execute in a hierarchical order from the root superclass down to the derived class (**top-down**):
1. Base class fields are initialized and base constructor runs.
2. Intermediate class fields and constructors run.
3. Derived class fields are initialized and the derived constructor body completes.
If a derived class constructor needs to pass values to its superclass constructor, it uses the `super(...)` statement as the **first statement** within the derived constructor body.

---

### Question 3: Concrete Classes vs. Abstract Types vs. Interfaces
- **Concrete Class:** Can be instantiated directly, can hold mutable instance state, and provides full implementations for all methods. Used for specific, fully defined entities (e.g., `Car`, `SavingsAccount`).
- **Abstract Class:** Cannot be instantiated directly, can maintain instance fields/state, and can combine concrete methods with abstract method templates. Used to share code and state across closely related types within a strong **IS-A** hierarchy.
- **Interface:** Cannot be instantiated directly, cannot maintain instance state (only `public static final` constants), and defines method contracts. Used to establish polymorphic **CAN-DO** capabilities across unrelated classes (e.g., `Chargeable`, `Serializable`).

---

### Question 4: Identical Method Signatures Across Multiple Interfaces
When a class implements two interfaces that declare an abstract method with the identical signature and compatible return type, the implementing class provides a **single concrete method implementation** that satisfies both interface contracts simultaneously.
This demonstrates that interfaces represent pure behavioral contracts rather than conflicting implementations. As long as the class fulfills the signature requirements, the compiler treats both contractual obligations as satisfied.

---

### Question 5: Importance of Overriding Both `equals()` and `hashCode()`
The `equals()` method defines logical equivalence (content equality) between objects. The Java specification establishes a contract between `equals()` and `hashCode()`:
> **If two objects are equal according to `equals()`, their `hashCode()` must return identical integer values.**
If `equals()` is overridden but `hashCode()` is not, two logically identical objects will have different identity-based hash codes. When stored in hash-based collections (`HashMap`, `HashSet`), they will be mapped to different hash buckets, resulting in duplicate entries, lookup failures, and broken `contains()` checks.

---

### Question 6: Shallow Copying vs. Deep Copying
- **Shallow Copy:** Creates a new object instance but copies field values as-is. Primitive fields are copied directly, but references to nested objects continue to point to the original objects in memory.
- **Deep Copy:** Creates a new object instance and recursively clones all nested mutable objects, creating fully independent copies.
- **Scenario:** Suppose an `Order` object has an `ArrayList<Item>` field. A shallow copy creates a new `Order`, but both orders share the identical item list. Adding or removing an item in the copied order will corrupt the original order. A deep copy is essential to isolate states and prevent unintended side effects.

---

### Question 7: Inner Classes vs. Static Nested Classes
- **Inner Class (Non-static):** Associated with an enclosing class instance. It has direct access to all instance variables and methods (including private members) of the enclosing object. It must be instantiated using an outer instance (`outer.new Inner()`). **Use case:** Helper objects intimately tied to instance state, such as custom iterators or event handlers.
- **Static Nested Class:** Associated with the enclosing class itself, not any particular instance. It cannot access non-static instance members of the outer class directly. It is instantiated independently (`new Outer.StaticNested()`). **Use case:** Co-located helper classes that do not require outer instance state, such as `Map.Entry` or `Builder` patterns.

---

### Question 8: Array Operation Time Complexities
- **Index Access — $O(1)$:** Arrays are stored in contiguous memory locations. The address of an element is computed using direct pointer arithmetic: $\text{Address} = \text{Base} + (\text{Index} \times \text{Size})$. This requires constant mathematical operations regardless of array size.
- **Middle Insertion / Deletion — $O(n)$:** In a fixed contiguous array, adding or removing an element requires shifting subsequent elements to maintain contiguous layout (shifting $n - i$ elements right for insertion, left for deletion). Shifting scales linearly with array length $n$, yielding $O(n)$ time complexity.

---

### Question 9: Base-Type Uniform Processing & Dynamic Method Dispatch
An array of a base type (e.g., `Account[]`) can hold references to instances of any derived subclass (`SavingsAccount`, `CurrentAccount`). When a method call like `acc.withdraw(amt)` is invoked in a loop:
1. The compiler verifies that `withdraw()` exists on the `Account` reference type.
2. At runtime, Java uses **dynamic method dispatch** (via virtual method tables / vtables) to locate and invoke the overridden method of the actual runtime object.
This achieves polymorphism without manual type queries (`instanceof`) or branching logic.

---

### Question 10: 'IS-A' (Inheritance) vs. 'CAN-DO' (Interface) Decision
- **IS-A (Class Inheritance):** Use when the child class is a genuine subtype of the parent class, sharing intrinsic identity, core attributes, and common implementation logic (e.g., a `SavingsAccount` **is an** `Account`).
- **CAN-DO (Interface Realization):** Use when defining an operational capability, behavior, or role that can be fulfilled by multiple completely unrelated classes without imposing a common hierarchical lineage.
- **Example:** An interface `Chargeable` is ideal for both `ElectricCar` and `SmartPhone`. Both can be charged (**CAN-DO**), yet they are completely unrelated objects that should never share a common inheritance parent.
