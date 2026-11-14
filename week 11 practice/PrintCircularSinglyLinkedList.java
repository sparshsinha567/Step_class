/**
 * Problem 1: Print Circular Singly Linked List
 * 
 * TASK:
 * Implement static void printCircular(Node head) for a circular singly linked list.
 * The function should print the data of each node exactly once, in the order of
 * traversal, separated by a space. After printing all elements, it should print
 * a newline. Your traversal must correctly terminate after visiting all nodes in
 * one full cycle, without relying on a null check. Handle an empty list by printing
 * only a newline.
 * 
 * COMPLEXITY:
 * - Time Complexity: O(n) where n is the number of nodes in the circular list.
 * - Auxiliary Space Complexity: O(1) memory overhead.
 */
public class PrintCircularSinglyLinkedList {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static void printCircular(Node head) {
        if (head == null) {
            System.out.println();
            return;
        }
        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    public static void main(String[] args) {
        // Sample 1: 10 -> 20 -> 30 -> (back to 10)
        Node n1 = new Node(10);
        Node n2 = new Node(20);
        Node n3 = new Node(30);
        n1.next = n2;
        n2.next = n3;
        n3.next = n1;

        System.out.print("Sample 1 Output: ");
        printCircular(n1); // Expected: 10 20 30

        // Sample 2: head = null
        System.out.print("Sample 2 Output: ");
        printCircular(null); // Expected: (blank line)
    }
}
