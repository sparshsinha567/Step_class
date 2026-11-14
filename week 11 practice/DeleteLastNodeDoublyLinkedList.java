/**
 * Problem 10: Delete Last Node from Doubly Linked List (from Head)
 * 
 * TASK:
 * Implement static DNode deleteLastNodeDoubly(DNode head) that takes the head of a
 * doubly linked list. The function should remove the last node from the list and return
 * the (possibly new) head of the list. Your implementation must correctly handle an empty
 * list, a list with a single node, and a list with multiple nodes, ensuring all prev and
 * next references are properly updated. Assume only the head reference is initially available.
 * 
 * COMPLEXITY:
 * - Time Complexity: O(n) to reach the tail node.
 * - Auxiliary Space Complexity: O(1).
 */
public class DeleteLastNodeDoublyLinkedList {

    public static class DNode {
        public int data;
        public DNode prev;
        public DNode next;

        public DNode(int data) {
            this.data = data;
        }
    }

    public static DNode deleteLastNodeDoubly(DNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        DNode current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        DNode last = current.next;
        current.next = null;
        last.prev = null;
        return head;
    }

    public static void printList(DNode head) {
        if (head == null) {
            System.out.println("(empty list)");
            return;
        }
        DNode curr = head;
        while (curr != null) {
            System.out.print(curr.data + (curr.next != null ? " <-> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample 1: 1 <-> 2 <-> 3
        DNode h1 = new DNode(1);
        DNode h2 = new DNode(2);
        DNode h3 = new DNode(3);
        h1.next = h2; h2.prev = h1;
        h2.next = h3; h3.prev = h2;

        System.out.print("Sample 1 Before: ");
        printList(h1);
        h1 = deleteLastNodeDoubly(h1);
        System.out.print("Sample 1 After:  ");
        printList(h1); // Expected: 1 <-> 2

        // Sample 2: head = 5 (single node)
        DNode singleNode = new DNode(5);
        System.out.print("\nSample 2 Before: ");
        printList(singleNode);
        singleNode = deleteLastNodeDoubly(singleNode);
        System.out.print("Sample 2 After:  ");
        printList(singleNode); // Expected: (empty list)
    }
}
