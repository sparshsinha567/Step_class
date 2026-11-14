/**
 * Problem 4: Train Coaches Both Ways (Coding Assignment)
 * 
 * TASK:
 * A train is stored as a doubly linked list of coach names. The control room needs
 * to print the train from the engine end and from the guard end, and to detach a coach
 * by name. Implement addLast, remove(String name), printForward and printBackward on
 * a doubly linked list with head and tail references.
 * 
 * CONSTRAINTS:
 *   1 <= number of coaches <= 50
 * 
 * COMPLEXITY:
 * - Finding the coach: O(n) sequential search from head.
 * - Unlinking the coach once found: O(1) constant pointer updates.
 * - Additional Space Complexity: O(1).
 */
public class TrainCoachesBothWays {

    public static class CoachNode {
        public String name;
        public CoachNode prev;
        public CoachNode next;

        public CoachNode(String name) {
            this.name = name;
        }
    }

    private CoachNode head;
    private CoachNode tail;

    public TrainCoachesBothWays() {
        this.head = null;
        this.tail = null;
    }

    public void addLast(String name) {
        CoachNode newNode = new CoachNode(name);
        if (head == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
    }

    public boolean remove(String name) {
        CoachNode current = head;
        while (current != null && !current.name.equals(name)) {
            current = current.next;
        }
        if (current == null) {
            return false; // Coach not found
        }

        // Unlink current node
        if (current == head && current == tail) {
            head = tail = null;
        } else if (current == head) {
            head = head.next;
            head.prev = null;
        } else if (current == tail) {
            tail = tail.prev;
            tail.next = null;
        } else {
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        return true;
    }

    public void printForward() {
        System.out.print("Forward: ");
        CoachNode current = head;
        while (current != null) {
            System.out.print(current.name + (current.next != null ? " <-> " : ""));
            current = current.next;
        }
        System.out.println();
    }

    public void printBackward() {
        System.out.print("Backward: ");
        CoachNode current = tail;
        while (current != null) {
            System.out.print(current.name + (current.prev != null ? " <-> " : ""));
            current = current.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TrainCoachesBothWays train = new TrainCoachesBothWays();
        train.addLast("Engine");
        train.addLast("A1");
        train.addLast("B1");
        train.addLast("B2");
        train.addLast("Guard");

        System.out.println("Initial Train Configuration:");
        train.printForward();
        train.printBackward();

        System.out.println("\nDetaching coach B1...");
        train.remove("B1");

        System.out.println("\nResulting Train Configuration:");
        train.printForward();  // Expected: Forward: Engine <-> A1 <-> B2 <-> Guard
        train.printBackward(); // Expected: Backward: Guard <-> B2 <-> A1 <-> Engine
    }
}
