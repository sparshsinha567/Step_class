/**
 * Problem 7: Count Nodes in Singly Linked List
 * 
 * TASK:
 * Implement static int countNodes(Node head) that takes the head of a singly linked
 * list and returns the total number of nodes present in the list.
 * An empty list should return 0.
 * 
 * COMPLEXITY:
 * - Time Complexity: O(n) linear traversal of n nodes.
 * - Auxiliary Space Complexity: O(1) single counter variable.
 */
public class CountNodesSinglyLinkedList {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static int countNodes(Node head) {
        int count = 0;
        Node current = head;
        while (current != null) {
            count++;
            current = current.next;
        }
        return count;
    }

    public static void main(String[] args) {
        // Sample 1: 5 -> 10 -> 15
        Node h1 = new Node(5);
        h1.next = new Node(10);
        h1.next.next = new Node(15);
        System.out.println("Sample 1 Count: " + countNodes(h1)); // Expected: 3

        // Sample 2: head = null
        System.out.println("Sample 2 Count: " + countNodes(null)); // Expected: 0
    }
}
