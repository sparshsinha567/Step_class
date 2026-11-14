/**
 * Problem 9: Insert at End of Circular Singly Linked List
 * 
 * TASK:
 * Implement static Node insertAtEndCircular(Node head, int value) that takes the head
 * of a circular singly linked list and an integer value. The function should insert a new
 * node with this value at the logical end of the list (meaning, it should be the new node
 * whose next points to the head). The list must remain circular, and the function should
 * return the (possibly new) head of the list. Handle the case of an initially empty list.
 * 
 * COMPLEXITY:
 * - Time Complexity: O(n) to find the current tail node whose next == head.
 * - Auxiliary Space Complexity: O(1).
 */
public class InsertAtEndCircularSinglyLinkedList {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node insertAtEndCircular(Node head, int value) {
        Node newNode = new Node(value);
        if (head == null) {
            newNode.next = newNode;
            return newNode;
        }
        Node current = head;
        while (current.next != head) {
            current = current.next;
        }
        current.next = newNode;
        newNode.next = head;
        return head;
    }

    public static void printCircular(Node head) {
        if (head == null) {
            System.out.println("(empty)");
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " -> ");
            current = current.next;
        } while (current != head);
        System.out.println("(back to " + head.data + ")");
    }

    public static void main(String[] args) {
        // Sample 1: 1 -> 2 -> 3 -> (back to 1), value = 4
        Node h1 = new Node(1);
        Node h2 = new Node(2);
        Node h3 = new Node(3);
        h1.next = h2;
        h2.next = h3;
        h3.next = h1;

        System.out.print("Sample 1 Before: ");
        printCircular(h1);
        h1 = insertAtEndCircular(h1, 4);
        System.out.print("Sample 1 After:  ");
        printCircular(h1); // Expected: 1 -> 2 -> 3 -> 4 -> (back to 1)

        // Sample 2: head = null, value = 9
        System.out.print("\nSample 2 After:  ");
        Node h2Empty = insertAtEndCircular(null, 9);
        printCircular(h2Empty); // Expected: 9 -> (back to 9)
    }
}
