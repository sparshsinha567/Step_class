# Step_semester_3 — Java & Object-Oriented Programming

## Repository Overview & Branching Model
This repository follows the structured feature-branch workflow for the STEP Semester 3 Java curriculum.

- **`main`**: Dated daily log, progress tracking, and documentation.
- **`develop`**: Base Java project template.
- **`feature/session_1`**: Java Strings & Exception Handling (`session_one_strings_and_exceptions/`).
- **`feature/session_2`**: Built-In Methods, StringBuilder & Character Processing (`session_two_builtin_methods_and_stringbuilder/`).
- **`feature/session_3`**: OOP Classes, Encapsulation & Constructor Overloading (`session_three_oop_constructors_and_classes/`).
- **`feature/session_4`**: Java Keywords (`this`, `final`, `static`, `instanceof`) (`session_four_constructors_and_keywords/`).
- **`feature/session_5`**: Access Modifiers, Encapsulation, JavaBeans & Immutability (`session_five_access_modifiers_and_encapsulation/`).
- **`feature/session_6`**: OOP Inheritance & Polymorphism (`session_six_inheritance_and_polymorphism/`).
- **`feature/session_7`**: Abstract Classes & Interfaces (`session_seven_abstract_classes_and_interfaces/`).
- **`feature/session_8`**: Object-Oriented Modeling & System Design (`session_eight_ood_and_system_design/`).
- **`feature/session_9`**: Data Structures & Algorithms (`session_nine_data_structures/`).
- **`feature/session_10`**: Comprehensive OOP & Data Structures Practice (`session_ten_practice/`, `week 10 practice/` & `week 10 assignment/`).
- **`feature/session_11`**: Data Structures — Linked Lists (`session_eleven_linked_lists/`, `week 11 practice/` & `week 11 assignment/`).

---

## Daily Log & Progress Tracking

### Session 1: Java Strings & Exception Handling
- **Work Done:**
  - Implemented Live-Coding Problems (`class_problems`): Rock-Paper-Scissors Simulator, Palindrome Verification (3 approaches), Team BMI Calculator, First Non-Repeating Character, Customer Name Reversal.
  - Implemented Assignment Problems (`assignment_problems`): Exam Hall Seat Duplication Checker, Typing Speed Accuracy Checker, Traffic Signal Streak Analyzer, Warehouse Inventory Balancer, Movie Review Word Length Profiler.
- **Concepts Applied:** Strings, Escape sequences, ASCII Codes, Checked/Unchecked Exceptions, defensive input validation.
- **Status:** Completed & Tested.

### Session 2: String Built-In Methods & StringBuilder
- **Work Done:**
  - Implemented Live-Coding Problems (`class_problems`): Vowel & Consonant Counter, CSV Student Record Parser, File Extension Validator, Masked Phone Number Formatter, Bank Transaction Reference Generator.
  - Implemented Assignment Problems (`assignment_problems`): ATM PIN Length Validator, Word Reversal Encoder, Product Inventory CSV Parser, Library ISBN Normalizer & Validator, Stop-Word-Filtered Frequency Report.
- **Concepts Applied:** `split()`, `substring()`, `lastIndexOf()`, `trim()`, `replace()`, `StringBuilder`, `Character.isLetter()` / `isDigit()`.
- **Status:** Completed & Tested.

### Session 3: OOP, Classes, Encapsulation & Constructor Overloading
- **Work Done:**
  - Implemented Live-Coding Problems (`class_problems`): Placement Record Class, Encapsulated Mess-Card Wallet, Course Overloaded Constructors, ID Card Reference Copying, Student Instance vs Static.
  - Implemented Assignment Problems (`assignment_problems`): Library Book Inventory, Encapsulated Payroll Account, Employee Constructor Overloading, Hall Ticket Reference Copying, Company Employee Static Tracker.
- **Concepts Applied:** Encapsulation, Constructor Overloading, `this()` chaining, Object References vs Identity (`==`), `static` members.
- **Status:** Completed & Tested.

### Session 4: Java Keywords & Type Checking
- **Work Done:**
  - Implemented In-Class Practice (`class_problems`): Library Book Catalog (`this()`), Payroll Batch Bonus (`this`), Late Fees (`final` methods), Student Batch Setup (`static` block), Account Batch Payments (`instanceof`).
  - Implemented Assignment Problems (`assignment_problems`): Hackathon Registration (`this()`), Canteen Inventory (`this`), Parking Fine Calculator (`final`), Library Card Setup (`static` block), Canteen Payment Dispatch (`instanceof`).
- **Concepts Applied:** Constructor chaining (`this()`), `final` methods, `static` initialization blocks, `instanceof` type checking & safe downcasting.
- **Status:** Completed & Tested.

### Session 5: Access Modifiers, Encapsulation, JavaBeans & Immutability
- **Work Done:**
  - Implemented Practice Problems (`class_problems`): Movie Ticket Field Visibility Checker, Subclass Ticket Access Checker, Seat Booking Encapsulation Guard, Movie Booking Profile JavaBean & OTP Property, Immutable Booking Receipt & Nightly Settlement Ledger.
  - Implemented Assignment Problems (`assignment_problems`): Membership Field Reach Checker, Reference Desk Subclass Reach, Book Copy Circulation Guard, Library Member JavaBean & Security Answer Property, Immutable Loan Receipt & Nightly Circulation Ledger.
- **Concepts Applied:** Java's 4 access levels, `protected` cross-package subclass access (`OWN_TYPE` vs `PARENT_TYPE`), encapsulation & boundary validation, JavaBean conventions (`isX()`), write-once & write-only properties, true immutability with defensive copying (`.clone()`), wither pattern, static blocks, `instanceof` polymorphic dispatch, null-safety.
- **Status:** Completed & Tested.

### Session 6: OOP Inheritance & Polymorphism
- **Work Done:**
  - Implemented Practice Problems (`class_problems`):
    1. `LibraryBatchEnrollment.java` — Single inheritance, constructor validation with `IllegalArgumentException`, batch enrollment loop.
    2. `MembershipHierarchyClassifier.java` — Multilevel & hierarchical inheritance, `instanceof` generation classification, polymorphic total calculation.
    3. `StudentFineLedger.java` — Method overriding (`@Override`), `super.chargeFine()` call, defensive copy of fine history array.
    4. `WeeklyCirculationReport.java` — Polymorphic batch printing, `StringBuilder` assembly, safe downcast guarded by `instanceof`.
    5. `NightlyCirculationAudit.java` — Static counter & `final memberNumber`, non-regex renewal code validation, method overloading, null-safe batch audit.
  - Implemented Assignment Problems (`assignment_problems`):
    1. `GymBatchSignup.java` — Gym membership single inheritance, constructor validation, batch sign-up validator with `try/catch`.
    2. `GymMembershipHierarchy.java` — Multilevel (`EliteMember`) & hierarchical (`GroupClassMember`) inheritance, `instanceof` tier classification, polymorphic session tally.
    3. `PremiumLoyaltyFineLedger.java` — Late-fee discount override with `super.chargeLateFee(amount / 2)`, defensive copy of history array.
    4. `MonthlyAttendanceAnnouncer.java` — Polymorphic attendance announcement, `StringBuilder` assembly, safe downcasting guarded by `instanceof`.
    5. `GymWeeklyCheckInAudit.java` — Static counter & `final membershipNumber`, non-regex referral code validation, overloaded `payFee()`, null-safe `instanceof` audit.
- **Concepts Applied:** Single / Multilevel / Hierarchical inheritance, method overriding, `super`, runtime polymorphism, `instanceof` type guards, defensive copying, `final` and `static` members.
- **Status:** Completed & Tested.

### Session 7: Abstract Classes & Interfaces
- **Work Done:**
  - Implemented Practice Problems (`class_problems`):
    1. `TalkingToyBox.java` — Abstract class `Toy` preventing direct instantiation, static counter assigning final `toyId`, concrete subclasses `ToyCar` and `ToyRobot` implementing `makeSound()`.
    2. `WarehouseLabelPrinter.java` — Common interface `Printable` with `printLabel()`, implemented directly across unrelated classes `PackageBox` and `Invoice`, batch polymorphic printing via `printAll()`.
    3. `OrchestraWarmUpRoutine.java` — Three-tier multilevel inheritance (`Instrument` -> `StringInstrument` -> `Violin`), abstract method implementation, method overriding with chained `super.play()` calls.
    4. `SmartKitchenAssistant.java` — Abstract class `KitchenTool` with JavaBean encapsulation for bounded `speedLevel` (1–5) and `prepare()`, interface `Washable` with `clean()`, concrete implementation `Blender`.
    5. `PackageDropOffLog.java` — Abstract class `DeliveryNote` demonstrating compile-time method overloading (`confirmDelivery(signature)` delegating to `confirmDelivery()`), subclasses `ParcelNote` and `LetterNote`, and polymorphic batch logging `logAll()`.
  - Implemented Assignment Problems (`assignment_problems`):
    1. `MorningWakeUpCircuit.java` — Interface `Ringable` with `ring()`, implemented by unrelated classes `AlarmClock` and `Doorbell`, polymorphic batch execution via `ringAll()`.
    2. `GalleryDescriptionCards.java` — Abstract class `ArtPiece` with shared static ID generation counter in constructor, abstract `describe()`, concrete subclasses `Painting` and `Sculpture`.
    3. `BackyardToolshedRoutine.java` — Multilevel hierarchy (`GardenTool` -> `CuttingTool` -> `Pruner`), constructor chaining with `super()`, method overriding reusing parent output via `super.use()`.
    4. `DigitalClassroomSetup.java` — Abstract class `ClassroomDevice` (`operate()`), interface `Chargeable` with method overloading (`charge()` and `charge(int minutes)`), concrete implementation `Tablet`.
    5. `SkylineDeliveryFleet.java` — Abstract `Drone`, interface `Trackable` (`getLocation()`), hierarchical branching (`DeliveryDrone` implements `Trackable`, sibling `ScoutDrone` does not), unrelated `GroundRobot` implementing `Trackable`, safe type checking with `instanceof` and downcasting in `getLocationIfTrackable()`.
- **Concepts Applied:** Abstract classes vs Interfaces, abstract methods, contract enforcement, static auto-incrementing ID generators in abstract constructors, multilevel inheritance chaining with `super`, compile-time polymorphism (method overloading), runtime polymorphism (method overriding & dynamic dispatch), interface-based decoupling of unrelated types, `instanceof` type checking & safe downcasting.
- **Status:** Completed & Tested.

### Session 8: Object-Oriented Modeling & System Design
- **Work Done:**
  - Implemented In-Class / Practice Problems (`class_problems`):
    1. `VehicleRentalSystem.java` — Abstract base `Vehicle` (`Sedan`, `SUV`, `Truck`), dynamic daily charge calculation, and guarded availability state tracking across rentals.
    2. `EmployeeLeaveRequestWorkflow.java` — State transitions (`PENDING`, `APPROVED`, `REJECTED`), state revert guards preventing approved/rejected requests returning to pending, and specialization for `FullTimeEmployee`, `PartTimeEmployee`, and `Contractor`.
    3. `OnlineExaminationSystem.java` — Abstract `Question` self-evaluation contract with concrete `MultipleChoiceQuestion`, `TrueFalseQuestion`, and `ShortAnswerQuestion`; single attempt lock preventing modifications after submission.
    4. `HotelBookingSystem.java` — Abstract `Room` hierarchy (`StandardRoom`, `DeluxeRoom`, `Suite`), dynamic pricing per duration, interval overlap detection, and cancellation management.
    5. `PaymentProcessingSystem.java` — Polymorphic `PaymentMethod` interface (`CreditCardPayment`, `PayPalPayment`, `BankTransferPayment`), empty order validation, and transactional order status updating.
    - Comprehensive `QUIZ_AND_CONCEPTS.md` covering OOP principles, UML multiplicity (`1 --- 1..*`), composition vs aggregation vs association, realization, generalization, sequence and state diagrams.
  - Implemented Assignment Problems (`assignment_problems`):
    1. `HostelLaundryQueue.java` — `WashType` interface (`Quick`, `Normal`, `Heavy`, extensible `Delicate`), duration and charge rules, encapsulated busy/free status in `WashingMachine`.
    2. `AssignmentSubmissionPortal.java` — Abstract `Assignment` with specialized late penalty rates (`CodingAssignment` 10%/day, `WrittenAssignment` 20%/day), submission status encapsulation, and resubmission lock once graded.
    3. `CampusPremiereTicketCounter.java` — `Seat` hierarchy (`Regular`, `Premium`, `Recliner`), per-seat price calculation, 6-seat booking cap, duplicate booking prevention, and seat release on cancellation before show start.
    4. `FitZoneMembershipDesk.java` — Abstract `MembershipPlan` hierarchy with discount formulas (`Monthly`, `Quarterly`, `Annual`, `HalfYearly`), state machine (`Active`, `Frozen`, `Expired`), and invalid state transition guards.
    5. `CampusNoticeBroadcaster.java` — `NotificationChannel` interface (`EmailChannel`, `SmsChannel`, `AppChannel`, extensible `WhatsAppChannel`), notice title & department validation, and multi-channel targeted broadcasting to students.
- **Concepts Applied:** Encapsulation & state guards, Generalization vs Realization, Runtime Polymorphism & Dynamic Dispatch, Interface-driven extensibility (Open/Closed Principle), UML Multiplicity, Association vs Aggregation vs Composition lifecycles, Finite State Machine validations.
- **Status:** Completed & Tested.

### Session 9: Data Structures & Algorithms
- **Work Done:**
  - Implemented In-Class / Practice Problems (`class_problems`):
    1. `LibraryCatalogLookup.java` — Logarithmic Binary Search ($O(\log n)$ time, $O(1)$ space) on pre-sorted ISBN catalog tuples.
    2. `WarehouseGridSummary.java` — 2D array traversal ($O(m \times n)$ time, $O(1)$ space) calculating running total items and first-encountered maximum storage bin coordinates.
    3. `PairWithTargetSum.java` — Hash Set complement lookup ($O(n)$ time, $O(n)$ space) versus brute-force nested loops ($O(n^2)$ time, $O(1)$ space).
    4. `PairWithTargetSumArray.java` — Two-pointer approach on sorted copy ($O(n \log n)$ time, $O(n)$ space) compared against optimal Hash Set ($O(n)$ time).
    5. `MaxContainerArea.java` — Two-pointer inward greedy boundary search ($O(n)$ time, $O(1)$ space) and comparison with $O(n^2)$ brute-force approach.
    - Comprehensive `QUIZ_AND_CONCEPTS.md` covering index access complexity, linear vs non-linear data structures, cache space-time trade-offs, Big-O constant factor elimination ($2n \to O(n)$), and traversal strategies (linear single path vs non-linear DFS/BFS branching).
  - Implemented Assignment Problems (`assignment_problems`):
    1. `ClassTopperFinder.java` — 2D student-subject grid summation ($O(m \times n)$ time, $O(1)$ space) with strict tie-breaking favoring the smallest row index.
    2. `MergeTokenQueues.java` — Two-pointer linear merge ($O(m + n)$ time, $O(m + n)$ space) of pre-sorted arrays without post-concatenation sorting ($O((m+n)\log(m+n))$).
    3. `MostPopularCanteenOrder.java` — Hash map frequency counting combined with original order traversal ($O(n)$ time, $O(k)$ space) to break ties by first occurrence.
    4. `HotWeatherAlertWindows.java` — Fixed-size sliding window ($O(n)$ time, $O(1)$ space) tracking contiguous $k$-hour temperature averages and integer threshold comparison ($sum \ge k \times threshold$) to avoid decimal division.
    5. `TicketPriceSlotFinder.java` — Binary search ($O(\log n)$ time, $O(1)$ space) finding exact price index or insertion slot for pre-sorted unique price lists.
- **Concepts Applied:** Asymptotic Big-O time and auxiliary space analysis, 1D & 2D array traversals, Hash tables (expected $O(1)$ lookup/insertion), Two-Pointer technique, Fixed-size Sliding Window, Logarithmic Binary Search and lower-bound insertion.
- **Status:** Completed & Tested.

### Session 10: Comprehensive OOP & Data Structures Practice (Category B)
- **Work Done:**
  - Implemented Practice Problems (`week 10 practice` / `session_ten_practice/class_problems`):
    1. `BankAccountWithdrawalSystem.java` — Abstract base `Account` with polymorphism, `SavingsAccount` with minimum balance guard ($1000$), `CurrentAccount` with overdraft limit guard ($-5000$).
    2. `CampusVehiclePassSystem.java` — `Vehicle` hierarchy (`Bike`, `Car`, `EBike`, `ECar`), `Chargeable` interface for electric vehicles, fee calculation, and charging bay allocation verification.
    3. `StudentClubRegistrationManagement.java` — Unique member registration using `HashSet` with properly overridden `equals()` and `hashCode()` based on roll number, duplicate rejection, member counting, and presence checks.
    4. `ClassMarksGridAnalysis.java` — 2D array marks analysis across 3 subjects, student total calculation, subject average formatted to two decimal places, and topper identification.
    5. `PayrollRegisterSystem.java` — Abstract `Staff` hierarchy (`FullTime`, `PartTime`, `Intern`), customized pay calculations, `toString()` payslip formatting, total payroll aggregation, and top earner tracking.
    - Comprehensive `QUIZ_AND_CONCEPTS.md` covering:
      - 20 Quiz solutions with detailed justifications (Inheritance, Polymorphism, Access Modifiers, Interfaces, Abstract Classes, UML Class & Sequence Diagrams, Upcasting/Downcasting, `equals()`/`hashCode()`).
      - 10 Concept question answers (Compile-time vs Runtime resolution, Constructor chaining & `super(...)`, Concrete vs Abstract vs Interfaces, Multiple interface realization, `equals()`/`hashCode()` contract in hash-based collections, Shallow vs Deep copying, Inner vs Static nested classes, Array time complexity, Dynamic method dispatch, and IS-A vs CAN-DO design decisions).
  - Implemented Assignment Problems (`week 10 assignment` / `session_ten_practice/assignment_problems`):
    1. `NoticeBoardShuffle.java` — Optimized Bubble Sort with early termination flag (`bubbleStats`), returning pass and swap metrics. Demonstrates $O(n)$ best-case verification on already sorted inputs.
    2. `HackathonRegistrationDesk.java` — Stable in-place Insertion Sort (`sortTeams`) using strict inequality key comparison (`>`) to maintain submission order for equal team sizes.
    3. `AttendanceDisorderScore.java` — Divide-and-conquer Merge Sort inversion counting (`countInversions`) running in $O(n \log n)$ time and $O(n)$ auxiliary space.
    4. `PlacementCutoff.java` — Average $O(n)$ QuickSelect algorithm (`kthHighest`) using Lomuto partition to identify cutoff score without full $O(n \log n)$ sorting.
    5. `ContestLeaderboard.java` — Stable non-comparison Counting Sort (`leaderboard`) with inverted keys (`100 - marks`) running in $O(n + 101)$ time and preserving entry order for ties.
- **Concepts Applied:** Runtime Polymorphism, Dynamic Method Dispatch, Abstract Classes vs Interfaces, Hash Sets and Object Equivalence Contracts (`equals`/`hashCode`), 2D Matrix traversal, In-Place Sorting (Bubble Sort, Insertion Sort), Divide-and-Conquer Inversion Counting (Merge Sort), QuickSelect Partitioning, Non-Comparison Stable Distribution Sorting (Counting Sort), Stability & Big-O Complexity Analysis.
- **Status:** Completed & Tested.

### Session 11: Data Structures — Linked Lists (Category B)
- **Work Done:**
  - Implemented Practice Problems (`week 11 practice` / `session_eleven_linked_lists/class_problems`):
    1. `PrintCircularSinglyLinkedList.java` — Traversal of circular singly linked list using `do-while` loop without relying on null checks.
    2. `InsertAtTailDoublyLinkedList.java` — Tail insertion in doubly linked list updating both `prev` and `next` references from `head`.
    3. `RemoveFirstKNodesSinglyLinkedList.java` — Deletion of the first $k$ nodes from singly linked list with boundary and edge case handling.
    4. `DeleteNthNodeSinglyLinkedList.java` — Deletion of 1-based $n$-th node from singly linked list handling head and internal positions.
    5. `SplitSinglyLinkedListInHalf.java` — Fast and slow pointer technique to bisect singly linked list into two properly terminated halves.
    6. `ReverseFirstKNodesSinglyLinkedList.java` — In-place pointer reversal of the first $k$ nodes while preserving remaining downstream sequence.
    7. `CountNodesSinglyLinkedList.java` — Linear traversal counting nodes in singly linked list.
    8. `CheckIfEmptySinglyLinkedList.java` — $O(1)$ null-head check for empty singly linked list.
    9. `InsertAtEndCircularSinglyLinkedList.java` — Tail insertion maintaining circular reference back to head.
    10. `DeleteLastNodeDoublyLinkedList.java` — Traversal and detachment of tail node updating predecessor references in doubly linked list.
    - Comprehensive `QUIZ_AND_CONCEPTS.md` covering:
      - 10 Quiz solutions with detailed justifications (Node storage components, Dynamic memory allocation vs arrays, Index access complexity, Bidirectional traversal benefits, Circular list termination invariants, Dummy/Sentinel nodes in head modifications, Cycle detection via Floyd's algorithm, In-place reversal auxiliary space, Relinking vs copying array memory efficiency, and Reference overwriting risks).
      - 5 Concept question answers (Head vs Tail insertion complexity and tail pointer impact, Predecessor requirements in singly vs doubly linked lists, Traversal performance & CPU cache locality vs contiguous arrays, Memory efficiency of relinking vs array copying, and 'next' pointer traversal invariants).
  - Implemented Assignment Problems (`week 11 assignment` / `session_eleven_linked_lists/assignment_problems`):
    1. `PriorityTokenInsertion.java` — Custom singly linked list supporting `addFirst`, `addLast`, and `insertAt(index, token)` with detailed operation complexity analysis.
    2. `CancelledOrdersCleanup.java` — Batch deletion `removeAll(head, code)` in singly linked list handling head and internal occurrences in $O(n)$ time and $O(1)$ space.
    3. `ReverseTheQueue.java` — In-place $O(n)$ time $O(1)$ auxiliary space iterative pointer reversal `reverse(head)` without allocating new nodes.
    4. `TrainCoachesBothWays.java` — Doubly linked list with `head` and `tail` references supporting `addLast`, `remove(name)`, `printForward`, and `printBackward`.
    5. `RoundRobinGameTurns.java` — Circular singly linked list with `tail` reference supporting $O(1)$ `addLast(name)` and cyclic turn simulation `printTurns(turns)`.
- **Concepts Applied:** Singly Linked Lists, Doubly Linked Lists, Circular Linked Lists, Fast & Slow Pointers (Floyd's Cycle / Tortoise & Hare), Sentinel / Dummy Nodes, Pointer Relinking, In-Place Reversal, Dynamic Heap Memory Allocation, Time and Space Complexity Analysis.
- **Status:** Completed & Tested.
