/**
 * Problem 8: Check if Singly Linked List is Empty
 * 
 * TASK:
 * Implement static boolean checkIfEmpty(Node head) that takes the head of a singly
 * linked list. The function should return true if the list is empty (i.e., head is null),
 * and false otherwise.
 * 
 * COMPLEXITY:
 * - Time Complexity: O(1) direct reference check.
 * - Auxiliary Space Complexity: O(1).
 */
public class CheckIfEmptySinglyLinkedList {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static boolean checkIfEmpty(Node head) {
        return head == null;
    }

    public static void main(String[] args) {
        // Sample 1: head = null
        System.out.println("Sample 1 (head = null): " + checkIfEmpty(null)); // Expected: true

        // Sample 2: head = 8
        Node h = new Node(8);
        System.out.println("Sample 2 (head = 8):    " + checkIfEmpty(h));    // Expected: false
    }
}
