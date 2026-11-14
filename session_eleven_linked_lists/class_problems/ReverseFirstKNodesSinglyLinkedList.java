/**
 * Problem 6: Reverse First K Nodes of Singly Linked List
 * 
 * TASK:
 * Implement static Node reverseFirstKNodes(Node head, int k) that takes the head of
 * a singly linked list and an integer k. The function should reverse only the first
 * k nodes of the list. The remaining nodes (from k+1 onwards) should remain in their
 * original relative order. Return the new head of the modified list.
 * Assume 1 <= k <= length of the list.
 * 
 * COMPLEXITY:
 * - Time Complexity: O(k) to reverse the first k nodes.
 * - Auxiliary Space Complexity: O(1) in-place pointer reversal.
 */
public class ReverseFirstKNodesSinglyLinkedList {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node reverseFirstKNodes(Node head, int k) {
        if (head == null || k <= 1) {
            return head;
        }
        Node prev = null;
        Node current = head;
        Node next = null;
        int count = 0;

        // Reverse first k nodes
        while (current != null && count < k) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
            count++;
        }

        // Connect tail of reversed section (original head) to (k+1)-th node
        head.next = current;
        return prev;
    }

    public static void printList(Node head) {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + (curr.next != null ? " -> " : ""));
            curr = curr.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample 1: 1 -> 2 -> 3 -> 4 -> 5, k = 3
        Node h1 = new Node(1);
        h1.next = new Node(2);
        h1.next.next = new Node(3);
        h1.next.next.next = new Node(4);
        h1.next.next.next.next = new Node(5);

        System.out.print("Sample 1 Before: ");
        printList(h1);
        h1 = reverseFirstKNodes(h1, 3);
        System.out.print("Sample 1 After:  ");
        printList(h1); // Expected: 3 -> 2 -> 1 -> 4 -> 5

        // Sample 2: 1 -> 2 -> 3 -> 4 -> 5, k = 5
        Node h2 = new Node(1);
        h2.next = new Node(2);
        h2.next.next = new Node(3);
        h2.next.next.next = new Node(4);
        h2.next.next.next.next = new Node(5);

        System.out.print("\nSample 2 Before: ");
        printList(h2);
        h2 = reverseFirstKNodes(h2, 5);
        System.out.print("Sample 2 After:  ");
        printList(h2); // Expected: 5 -> 4 -> 3 -> 2 -> 1
    }
}
