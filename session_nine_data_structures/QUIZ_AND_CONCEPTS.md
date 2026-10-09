# Session 9: Data Structures & Algorithms — Quiz & Concept Solutions

## Part B: Quiz Questions & Answers

### Q1. Array Index Access Complexity
- **Question:** What is the time complexity for accessing an element at a known index in a one-dimensional (1D) array?
- **Correct Answer:** **B. O(1)**
- **Explanation:** In a contiguous array, the memory address of an element at index $i$ is calculated directly in constant time via arithmetic formula: `Base_Address + (i * Element_Size)`.

---

### Q2. Adding Elements to Data Structures
- **Question:** The operation of adding a new element to a data structure is known as what?
- **Correct Answer:** **C. Insertion**
- **Explanation:** "Insertion" denotes adding a new data element, while "Traversal" visits elements, "Deletion" removes elements, and "Searching" locates elements.

---

### Q3. Choosing Data Structures
- **Question:** When choosing an appropriate data structure for a given problem, what is the most crucial step?
- **Correct Answer:** **C. Matching the required operations and constraints to the strengths of different data structures**
- **Explanation:** Optimal algorithm design involves balancing required operations (e.g., fast lookups vs. rapid insertions) against time and space constraints.

---

### Q4. Caching Concept
- **Question:** A software system stores frequently accessed calculations in a cache (extra memory) to avoid recomputing them, thereby speeding up future queries. This scenario best illustrates what concept?
- **Correct Answer:** **C. Time vs space trade-offs**
- **Explanation:** Allocating auxiliary space (caching) to drastically reduce execution time exemplifies the classic space-time trade-off.

---

### Q5. Sequential Loops Complexity
- **Question:** A function has two distinct loops. The first loop iterates $m$ times over one input, and the second loop (not nested) iterates $n$ times over a different input. What is the overall time complexity?
- **Correct Answer:** **B. O(m + n)**
- **Explanation:** Non-nested sequential loops are additive: $O(m) + O(n) = O(m + n)$.

---

### Q6. Linear Data Structure Definition
- **Question:** In which type of data structure are elements arranged sequentially, where each element (except the first/last) has exactly one predecessor and one successor?
- **Correct Answer:** **C. Linear data structure**
- **Explanation:** Linear data structures (arrays, linked lists, stacks, queues) maintain elements in a single sequential order.

---

### Q7. Simplifying Big-O Polynomials
- **Question:** An algorithm performs a number of operations proportional to $2n + 5$. According to the rules of Big-O notation, what is its simplified time complexity?
- **Correct Answer:** **C. O(n)**
- **Explanation:** Big-O notation drops lower-order terms ($+ 5$) and multiplicative constants ($2$) to characterize asymptotic growth rate.

---

### Q8. Non-Primitive Data Structure
- **Question:** Which of the following is an example of a non-primitive data structure?
- **Correct Answer:** **D. Linked list**
- **Explanation:** `int`, `char`, and `boolean` are primitive types provided directly by the programming language, whereas a `Linked list` is a composite, non-primitive reference data structure.

---

### Q9. 2D Array Traversal
- **Question:** For a two-dimensional (2D) array with $m$ rows and $n$ columns, what is the time complexity of visiting every element exactly once?
- **Correct Answer:** **B. O(m × n)**
- **Explanation:** The grid has a total of $m \times n$ cells. Visiting each cell once requires $m \times n$ operations.

---

### Q10. Fundamental Purpose of Data Structures
- **Question:** What is the fundamental purpose of a data structure?
- **Correct Answer:** **C. To organize, store, and access data efficiently for specific operations**
- **Explanation:** Data structures provide organized containers tailored to optimize specific computational tasks (search, insert, delete, sort).

---

## Part C: Concept Questions & Comprehensive Answers

### Question 1: Searching in Unsorted vs. Sorted 1D Array
- **Time Complexities:**
  - **Unsorted Array:** $O(n)$ worst/average case via Linear Search.
  - **Sorted Array:** $O(\log n)$ worst/average case via Binary Search.
- **Fundamental Reason for Efficiency Difference:**
  - In an unsorted array, no ordering invariant exists between adjacent elements; knowing that element $A[k] \neq target$ provides zero information about the values in any other positions. Hence, the algorithm must verify each element individually in sequence.
  - In a sorted array, the monotonic ordering invariant guarantees that for any element $A[mid]$, if $target < A[mid]$, then the target cannot exist anywhere in the sub-array from $mid$ to the end. This allows the search space to be halved ($N \to N/2 \to N/4 \dots$) with every single comparison, reducing linear steps to logarithmic steps.

---

### Question 2: Why Constant Multipliers Are Dropped in Big-O ($2n \to O(n)$)
- **Mathematical & Theoretical Rationale:**
  - Big-O notation measures the **asymptotic upper bound** of an algorithm's growth rate as input size $n$ approaches infinity ($n \to \infty$).
  - Formally, $f(n) \in O(g(n))$ if there exist positive constants $c$ and $n_0$ such that $0 \le f(n) \le c \cdot g(n)$ for all $n \ge n_0$. For $f(n) = 2n$, choosing $c = 2$ and $g(n) = n$ fulfills the definition: $2n \le 2(n)$, which proves $2n \in O(n)$.
- **Practical Engineering Rationale:**
  - Constant factors vary widely across hardware architectures, CPU cycle times, compiler optimizations, and memory caching effects.
  - Big-O focuses on scalability: whether doubling the dataset causes runtime to double ($O(n)$) or quadruple ($O(n^2)$). A $2n$ algorithm and an $n$ algorithm scale at the identical linear rate.

---

### Question 3: Traversal Strategy: Linear vs. Non-Linear Data Structures
- **Relationship of Elements:**
  - **Linear Data Structures (e.g., Arrays, Linked Lists):** Elements share a 1-to-1 relationship. Each item has at most one direct predecessor and one direct successor.
  - **Non-Linear Data Structures (e.g., Trees, Graphs):** Elements share hierarchical (1-to-many, parent-to-children) or networked (many-to-many, vertex-to-neighbors) relationships.
- **Fundamental Traversal Strategy Differences:**
  - **Linear Traversal:** Proceed along a single, deterministic linear path from start to end (index $0$ to $n-1$, or following `head.next`). It requires only a single pointer or loop counter with $O(1)$ auxiliary space and no branching decisions.
  - **Non-Linear Traversal:** Because each node can branch into multiple paths, traversal requires choosing an exploration order (such as Depth-First Search: Pre-order, In-order, Post-order; or Breadth-First Search: Level-order).
  - Furthermore, non-linear traversal requires auxiliary memory structures (a call stack for recursion/backtracking, an explicit Queue for BFS, or a Set for cycle tracking in graphs) to remember unvisited branches.
