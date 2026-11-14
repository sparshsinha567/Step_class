/**
 * Problem 5: Split Singly Linked List into Two Halves
 * 
 * TASK:
 * Implement static Node splitListInHalf(Node head) that takes the head of a singly
 * linked list and splits it into two halves. If the list has an odd number of nodes,
 * the first half should contain the extra middle node. The function should return
 * the head of the second half of the list. The original list should be modified such
 * that the first half is properly terminated (its last node's next should be null).
 * Use the fast and slow pointer technique to find the middle. State time and space complexity.
 * 
 * COMPLEXITY:
 * - Time Complexity: O(n) linear pass using fast and slow pointers.
 * - Auxiliary Space Complexity: O(1) memory overhead.
 */
public class SplitSinglyLinkedListInHalf {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node splitListInHalf(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node slow = head;
        Node fast = head;

        // When fast reaches the end (or second to last), slow is at the end of the first half
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalfHead = slow.next;
        slow.next = null; // Terminate first half properly
        return secondHalfHead;
    }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println("(empty)");
            return;
        }
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample 1 (odd): 1 -> 2 -> 3 -> 4 -> 5
        Node h1 = new Node(1);
        h1.next = new Node(2);
        h1.next.next = new Node(3);
        h1.next.next.next = new Node(4);
        h1.next.next.next.next = new Node(5);

        System.out.println("Sample 1 (Odd Length):");
        Node secondHalf1 = splitListInHalf(h1);
        System.out.print("First half:  ");
        printList(h1);          // Expected: 1 -> 2 -> 3
        System.out.print("Returned:    ");
        printList(secondHalf1); // Expected: 4 -> 5

        // Sample 2 (even): 1 -> 2 -> 3 -> 4
        Node h2 = new Node(1);
        h2.next = new Node(2);
        h2.next.next = new Node(3);
        h2.next.next.next = new Node(4);

        System.out.println("\nSample 2 (Even Length):");
        Node secondHalf2 = splitListInHalf(h2);
        System.out.print("First half:  ");
        printList(h2);          // Expected: 1 -> 2
        System.out.print("Returned:    ");
        printList(secondHalf2); // Expected: 3 -> 4
    }
}
