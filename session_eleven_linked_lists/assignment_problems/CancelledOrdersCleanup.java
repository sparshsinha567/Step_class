/**
 * Problem 2: Cancelled Orders Cleanup (Coding Assignment)
 * 
 * TASK:
 * A delivery app keeps order codes in a singly linked list. When a customer cancels,
 * every order with that code must be removed.
 * Implement Node removeAll(Node head, int code) that removes every node with the given
 * value and returns the (possibly new) head. Write your own node class with data and
 * next fields; do not use java.util.LinkedList.
 * 
 * CONSTRAINTS:
 *   0 <= length of list <= 1000
 * 
 * COMPLEXITY:
 * - Time Complexity: O(n) single linear scan over the list.
 * - Additional Space Complexity: O(1) in-place deletion without allocating extra nodes.
 */
public class CancelledOrdersCleanup {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node removeAll(Node head, int code) {
        // Step 1: Remove all matching nodes from the front
        while (head != null && head.data == code) {
            head = head.next;
        }
        if (head == null) {
            return null;
        }

        // Step 2: Traverse and skip matching nodes downstream
        Node current = head;
        while (current != null && current.next != null) {
            if (current.next.data == code) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        return head;
    }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println("null");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Sample 1: orders = 5 -> 3 -> 5 -> 8 -> 5, code = 5
        Node s1 = new Node(5);
        s1.next = new Node(3);
        s1.next.next = new Node(5);
        s1.next.next.next = new Node(8);
        s1.next.next.next.next = new Node(5);

        System.out.print("Sample 1 Before: ");
        printList(s1);
        s1 = removeAll(s1, 5);
        System.out.print("Sample 1 After:  ");
        printList(s1); // Expected: 3 -> 8 -> null

        // Sample 2: orders = 5 -> 5 -> 5, code = 5
        Node s2 = new Node(5);
        s2.next = new Node(5);
        s2.next.next = new Node(5);

        System.out.print("\nSample 2 Before: ");
        printList(s2);
        s2 = removeAll(s2, 5);
        System.out.print("Sample 2 After:  ");
        printList(s2); // Expected: null
    }
}
