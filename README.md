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
