/**
 * Problem 3: Reverse the Queue (Coding Assignment)
 * 
 * TASK:
 * At a ticket window, the queue order must be reversed so the last person is served
 * first. Reverse the singly linked list in place.
 * Implement Node reverse(Node head) and return the new head. Write your own node class
 * with data and next fields; do not use java.util.LinkedList.
 * 
 * CONSTRAINTS:
 *   0 <= length of list <= 1000
 *   No new nodes may be created.
 * 
 * COMPLEXITY:
 * - Time Complexity: O(n) single pass turning each next pointer around.
 * - Additional Space Complexity: O(1) in-place reversal using three references.
 */
public class ReverseTheQueue {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        Node next = null;

        while (current != null) {
            next = current.next; // Save next node
            current.next = prev; // Reverse current link
            prev = current;      // Move prev one step forward
            current = next;      // Move current one step forward
        }
        return prev; // prev becomes the new head
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
        // Sample 1: queue = 1 -> 2 -> 3 -> 4
        Node q1 = new Node(1);
        q1.next = new Node(2);
        q1.next.next = new Node(3);
        q1.next.next.next = new Node(4);

        System.out.print("Sample 1 Initial:  ");
        printList(q1);
        q1 = reverse(q1);
        System.out.print("Sample 1 Reversed: ");
        printList(q1); // Expected: 4 -> 3 -> 2 -> 1 -> null

        // Sample 2: queue = 9
        Node q2 = new Node(9);
        System.out.print("\nSample 2 Initial:  ");
        printList(q2);
        q2 = reverse(q2);
        System.out.print("Sample 2 Reversed: ");
        printList(q2); // Expected: 9 -> null
    }
}
