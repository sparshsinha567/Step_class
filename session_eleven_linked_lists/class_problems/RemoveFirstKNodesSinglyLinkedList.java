/**
 * Problem 3: Remove First K Nodes from Singly Linked List
 * 
 * TASK:
 * Implement static Node removeFirstKNodes(Node head, int k) that takes the head
 * of a singly linked list and an integer k. The function should remove the first
 * k nodes from the list. If k is greater than or equal to the total length of the list,
 * the entire list should become empty. Return the new head of the modified list.
 * Assume k >= 0.
 * 
 * COMPLEXITY:
 * - Time Complexity: O(min(k, n)) where n is the length of the list.
 * - Auxiliary Space Complexity: O(1) in-place pointer movement.
 */
public class RemoveFirstKNodesSinglyLinkedList {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node removeFirstKNodes(Node head, int k) {
        if (head == null || k <= 0) {
            return head;
        }
        Node current = head;
        while (k > 0 && current != null) {
            current = current.next;
            k--;
        }
        return current;
    }

    public static void printList(Node head) {
        if (head == null) {
            System.out.println("(empty list)");
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
        // Sample 1: 1 -> 2 -> 3 -> 4 -> 5, k = 2
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(3);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);

        System.out.print("Sample 1 Before: ");
        printList(head1);
        head1 = removeFirstKNodes(head1, 2);
        System.out.print("Sample 1 After:  ");
        printList(head1); // Expected: 3 -> 4 -> 5

        // Sample 2: 1 -> 2, k = 5
        Node head2 = new Node(1);
        head2.next = new Node(2);

        System.out.print("\nSample 2 Before: ");
        printList(head2);
        head2 = removeFirstKNodes(head2, 5);
        System.out.print("Sample 2 After:  ");
        printList(head2); // Expected: (empty list)
    }
}
