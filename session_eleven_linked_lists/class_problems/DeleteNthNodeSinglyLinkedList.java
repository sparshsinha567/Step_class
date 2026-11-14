/**
 * Problem 4: Delete N-th Node from Singly Linked List
 * 
 * TASK:
 * Implement static Node deleteNthNode(Node head, int n) that takes the head of a singly
 * linked list and an integer n (representing the 1-based index of the node to be deleted).
 * The function should delete the node at the n-th position and return the head of the
 * modified list. You can assume that n will always be a valid index within the list's
 * bounds (1 <= n <= length of list). Handle the special case where n = 1 (deleting the head).
 * 
 * COMPLEXITY:
 * - Time Complexity: O(n) to reach the (n-1)-th node.
 * - Auxiliary Space Complexity: O(1) in-place deletion.
 */
public class DeleteNthNodeSinglyLinkedList {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    public static Node deleteNthNode(Node head, int n) {
        if (head == null || n < 1) {
            return head;
        }
        if (n == 1) {
            return head.next;
        }
        Node current = head;
        for (int i = 1; i < n - 1 && current != null; i++) {
            current = current.next;
        }
        if (current != null && current.next != null) {
            current.next = current.next.next;
        }
        return head;
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
        // Sample 1: 10 -> 20 -> 30 -> 40, n = 3
        Node head1 = new Node(10);
        head1.next = new Node(20);
        head1.next.next = new Node(30);
        head1.next.next.next = new Node(40);

        System.out.print("Sample 1 Before: ");
        printList(head1);
        head1 = deleteNthNode(head1, 3);
        System.out.print("Sample 1 After:  ");
        printList(head1); // Expected: 10 -> 20 -> 40

        // Sample 2: 10 -> 20 -> 30 -> 40, n = 1
        Node head2 = new Node(10);
        head2.next = new Node(20);
        head2.next.next = new Node(30);
        head2.next.next.next = new Node(40);

        System.out.print("\nSample 2 Before: ");
        printList(head2);
        head2 = deleteNthNode(head2, 1);
        System.out.print("Sample 2 After:  ");
        printList(head2); // Expected: 20 -> 30 -> 40
    }
}
