/**
 * Problem 2: Insert at Tail of Doubly Linked List (from Head)
 * 
 * TASK:
 * Implement static DNode insertAtTailDoubly(DNode head, int value) which inserts
 * a new node with the given value at the tail of a doubly linked list.
 * The function should correctly update all prev and next references for the
 * new node and its neighbors. Return the (possibly new) head of the list.
 * Your implementation should work even if only the head reference is initially
 * available and must correctly handle an empty list.
 * 
 * COMPLEXITY:
 * - Time Complexity: O(n) to traverse to the end of the list when only head is given.
 * - Auxiliary Space Complexity: O(1) auxiliary memory.
 */
public class InsertAtTailDoublyLinkedList {

    public static class DNode {
        public int data;
        public DNode prev;
        public DNode next;

        public DNode(int data) {
            this.data = data;
        }
    }

    public static DNode insertAtTailDoubly(DNode head, int value) {
        DNode newNode = new DNode(value);
        if (head == null) {
            return newNode;
        }
        DNode current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.next = newNode;
        newNode.prev = current;
        return head;
    }

    public static void printList(DNode head) {
        DNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + (curr.next != null ? " <-> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample 1: 1 <-> 2 <-> 3, value = 4
        DNode h1 = new DNode(1);
        DNode h2 = new DNode(2);
        DNode h3 = new DNode(3);
        h1.next = h2; h2.prev = h1;
        h2.next = h3; h3.prev = h2;

        System.out.print("Sample 1 Before: ");
        printList(h1);
        h1 = insertAtTailDoubly(h1, 4);
        System.out.print("Sample 1 After:  ");
        printList(h1); // Expected: 1 <-> 2 <-> 3 <-> 4

        // Sample 2: head = null, value = 7
        System.out.print("\nSample 2 After:  ");
        DNode hEmpty = insertAtTailDoubly(null, 7);
        printList(hEmpty); // Expected: 7
    }
}
