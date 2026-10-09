# Session 8: Object-Oriented Modeling & Design — Quiz & Concept Solutions

## Part B: Quiz Questions & Answers

### Q1. Common Interaction via TicketProcessor
- **Question:** A ticketing system manages various event types like concerts, plays, and sports matches. While all events have a title and a scheduled date, concerts also have a performer, and sports matches have competing teams. The system processes tickets for any event type through a common TicketProcessor. Which OOP concept allows the TicketProcessor to interact with different event types uniformly?
- **Correct Answer:** **C. Polymorphism**
- **Explanation:** Polymorphism allows a single interface or base type reference to invoke subtype-specific behavior at runtime without coupling the caller to concrete subclasses.

---

### Q2. Controlled Attribute Modification
- **Question:** In a social media application, a UserProfile object has a dateOfBirth attribute. The application prevents direct modification of dateOfBirth from outside the UserProfile class, requiring any changes to be made through an updateProfileInfo method that includes validation logic to ensure the date is valid and reasonable. Which OOP principle is being primarily enforced here?
- **Correct Answer:** **C. Encapsulation**
- **Explanation:** Encapsulation bundles data with the methods that operate on it and restricts direct access to internal object state to ensure validation and invariant preservation.

---

### Q3. Author to Book UML Multiplicity
- **Question:** A publishing house manages authors and their books. An author can write one or more books, but a book must always have exactly one author. If the author is removed from the system, their books still exist but might be reassigned to another author or marked as unauthored. Which UML multiplicity best describes the relationship from Author to Book?
- **Correct Answer:** **C. Author 1 --- 1..* Book**
- **Explanation:** Exactly 1 author is associated with 1 or more (`1..*`) books.

---

### Q4. Shopping Cart and Cart Item Lifecycle
- **Question:** A Shopping Cart object directly manages a collection of Cart Item objects. If the Shopping Cart is deleted, all its associated Cart Item objects are also destroyed, as they have no meaning or independent existence outside of that specific cart. Which UML relationship accurately models this strong ownership and lifecycle dependency?
- **Correct Answer:** **D. Composition**
- **Explanation:** Composition represents a strong "has-a" relationship where the parts cannot exist independently of the whole; their lifecycle is bound to the parent object.

---

### Q5. Course and Specialized Course Relationship
- **Question:** An online course platform defines a general Course concept. Specific types of courses, such as ProgrammingCourse and DesignCourse, extend this general Course by adding specialized attributes and behaviors while inheriting common ones. The specialized courses are essentially 'is-a' types of the general course. Which UML relationship represents the connection between the general Course and ProgrammingCourse?
- **Correct Answer:** **D. Generalization**
- **Explanation:** In UML, class inheritance is termed Generalization, depicting that a specific class inherits from a general superclass.

---

### Q6. Printable Contract and PdfDocument
- **Question:** A Printer class needs to interact with various Printable document types (e.g., PdfDocument, WordDocument). The Printer is designed to work with any object that adheres to a Printable contract, which defines a print() method, without needing to know the specific implementation details of each document type. Which UML relationship describes the connection between PdfDocument and the Printable contract?
- **Correct Answer:** **C. Realization**
- **Explanation:** Realization (represented by a dashed line with a closed hollow arrowhead) indicates that a concrete class implements the interface contract.

---

### Q7. Customer and Order Transaction Relationship
- **Question:** A Customer places an Order. The Customer can exist without placing any orders, and an Order can be created and completed even if the Customer record is later archived (though it would still reference the customer ID). There is no strong ownership or lifecycle dependency between them; they are just related by a transaction. Which UML relationship is most suitable for describing this scenario?
- **Correct Answer:** **B. Association**
- **Explanation:** Association models a loose, peer-level relationship between independent entities without lifecycle co-dependence.

---

### Q8. Task State Transitions Diagram
- **Question:** A task in a project management system has various statuses: Pending, InProgress, Completed, Blocked. A task can move from Pending to InProgress, from InProgress to Completed or Blocked, but a Completed task cannot return to Pending or InProgress. This behavior defines a specific flow of states and transitions. Which UML diagram type is best suited to model the lifecycle and valid transitions of a Task object?
- **Correct Answer:** **C. State diagram**
- **Explanation:** A State Machine / State Diagram models the sequence of discrete states an object goes through in response to events during its lifecycle.

---

### Q9. Generic ReportGenerator Interface
- **Question:** A reporting module generates various types of reports (e.g., Sales Summary, Inventory List, Employee Roster). The module interacts with a generic ReportGenerator interface, which defines a generate() method. This allows the module to request a report without needing to know the specific details of how each report type is created. Which design concept is primarily demonstrated by using a generic ReportGenerator interface?
- **Correct Answer:** **B. Abstraction**
- **Explanation:** Abstraction hides complex internal implementation details and exposes only the essential public interface to clients.

---

### Q10. Login Flow Message Sequence
- **Question:** When a user logs into an application, the following sequence of actions occurs: the user enters credentials, the AuthenticationService receives these credentials, it then calls the UserRepository to verify them, the UserRepository returns the result, and finally, the AuthenticationService grants or denies access. This interaction involves multiple objects exchanging messages over time. Which UML behavioral model is most appropriate for visualizing this specific order and flow of messages between objects during the login process?
- **Correct Answer:** **C. Sequence diagram**
- **Explanation:** A Sequence Diagram captures temporal object interactions by detailing the order of messages exchanged along lifelines over time.

---

## Part C: Concept Questions & Comprehensive Explanations

### Question 1: Encapsulation in User Object Design
- **State Controlled by User:** The internal state includes `email`, `userId`, `verificationStatus`, and timestamp of last change.
- **Why Unrestricted Access Leads to Invalid States:**
  - Direct field exposure permits invalid email formats (e.g., missing `@` or domain), nulls, or empty strings.
  - It bypasses uniqueness validation against the global user repository, risking duplicate account records and data corruption.
  - It prevents triggering side effects such as sending verification emails or invalidating active session tokens.
- **How Controlled Access Maintains Valid State:**
  - Enclosing `email` in a `private` field and exposing mutations only through `changeEmail(String newEmail)` guarantees that incoming input undergoes format validation, sanitization (trimming/lowercasing), uniqueness checks, and business rule enforcement before the object's internal state updates.

---

### Question 2: Composition vs. Inheritance in ReportingService
- **When Inheritance is Considered:**
  - Inheritance is suitable when child reports share a strict, universal "is-a" taxonomy and reuse foundational lifecycle templates (e.g., `AbstractReport` with template method `generate()`).
- **When Composition is More Suitable:**
  - Composition is vastly superior for orthogonal, optional capabilities like `DataExport` (CSV, PDF, JSON) and `DataVisualization` (BarChart, PieChart).
  - Injecting `ExportStrategy` and `VisualizationStrategy` interfaces into a report allows flexible runtime combination (e.g., `Report` has-a `Exporter` and has-a `Visualizer`).
- **Rigidities of Forcing Inheritance:**
  - Forcing optional behaviors into class inheritance leads to the **combinatorial explosion of subclasses** (e.g., `CsvExportPieChartReport`, `PdfExportNoChartReport`, `JsonExportBarChartReport`).
  - Fragile base class problems arise where changes to export logic ripple into unrelated reporting classes. Composition adheres to the Single Responsibility Principle and Open/Closed Principle.

---

### Question 3: Abstraction, Method Overriding, and Runtime Polymorphism in NotificationService
- **How They Work Together:**
  - **Abstraction:** The service depends strictly on an interface `NotificationChannel` declaring a polymorphic method `void send(String recipient, String message)`.
  - **Method Overriding:** Concrete implementations (`EmailNotification`, `SmsNotification`, `PushNotification`) override `send()` with their specific delivery protocols (SMTP, SMS Gateway API, APNs/FCM).
  - **Runtime Polymorphism (Dynamic Dispatch):** `NotificationService` calls `channel.send(to, msg)` on the interface reference. The JVM resolves the concrete implementation dynamically at runtime without needing `if-else` or `switch` statements checking channel types.
- **Impact of Introducing New Implementations:**
  - Introducing `InAppNotification` simply requires implementing `NotificationChannel`. The existing `NotificationService` code remains 100% untouched and closed for modification yet open for extension (Open/Closed Principle).

---

### Question 4: Composition vs. Aggregation in Organization, Department, and Employee
- **Differences:**
  - **Composition (Filled Diamond):** Strong ownership and shared lifecycle. The part cannot exist without the whole. If the whole is destroyed, the parts are destroyed.
  - **Aggregation (Hollow Diamond):** Weak "has-a" relationship where the parts have an independent lifecycle outside the container.
- **Organization and Department (Composition):**
  - A `Department` (e.g., "Engineering") is structurally an integral organ of the specific `Organization`. When the Organization is dissolved, its departments cease to exist as organizational entities. Hence, **Composition** is appropriate.
- **Department and Employee (Aggregation):**
  - An `Employee` is an autonomous person who exists independently of any department. If a department is dissolved, the employees remain employed, can be reassigned to other departments, or move to external organizations. Hence, **Aggregation** is appropriate.

---

### Question 5: Student and Course Multiplicity & Business Invariants
- **UML Multiplicity:**
  - The relationship between `Student` and `Course` is **Many-to-Many (`*` --- `*` or `0..*` --- `0..*`)**. A student can enroll in multiple courses, and a course can be taken by multiple students.
- **Why Duplicate Enrollment Business Rule is Distinct from Multiplicity:**
  - Multiplicity in UML specifies cardinality bounds (how many instances of entity B can be linked to entity A), but standard multiplicity notation does not convey uniqueness or set semantics over time.
  - To prevent duplicate enrollment for the same student-course pair, the association is typically modeled through an intermediate association class `Enrollment` with a composite unique key `(studentId, courseId)`, or enforced via unique collection constraints (e.g., `Set<Course>` rather than `List<Course>`) and transactional validation logic.
