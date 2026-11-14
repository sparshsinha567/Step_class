/**
 * Problem 1: Priority Token Insertion (Coding Assignment)
 * 
 * TASK:
 * The token list sometimes needs a token added at the front (priority), at the end
 * (normal) or at a given position (rescheduled).
 * Implement addFirst, addLast and insertAt(int index, int token) (0-based) on your
 * singly linked list and print the list after all operations. Write your own node class
 * with data and next fields; do not use java.util.LinkedList.
 * 
 * CONSTRAINTS:
 *   0 <= index <= current size
 *   1 <= number of operations <= 50
 * 
 * COMPLEXITY:
 * - addFirst(int token): O(1) time complexity (creates node and points next to head).
 * - addLast(int token): O(n) time complexity (traverses from head to tail).
 * - insertAt(int index, int token): O(index) <= O(n) time complexity (walks to index - 1).
 * - Additional Space Complexity: O(1) per insertion.
 */
public class PriorityTokenInsertion {

    public static class Node {
        public int data;
        public Node next;

        public Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private int size;

    public PriorityTokenInsertion() {
        this.head = null;
        this.size = 0;
    }

    public void addFirst(int token) {
        Node newNode = new Node(token);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public void addLast(int token) {
        Node newNode = new Node(token);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public void insertAt(int index, int token) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index " + index + " out of bounds for size " + size);
        }
        if (index == 0) {
            addFirst(token);
            return;
        }
        Node newNode = new Node(token);
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    public void printList() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        PriorityTokenInsertion tokenList = new PriorityTokenInsertion();
        // Starting list: 101 -> 102 -> 103
        tokenList.addLast(101);
        tokenList.addLast(102);
        tokenList.addLast(103);
        System.out.print("Start:           ");
        tokenList.printList();

        // Operations: addFirst(100), addLast(104), insertAt(2, 150)
        tokenList.addFirst(100);
        tokenList.addLast(104);
        tokenList.insertAt(2, 150);

        System.out.print("Expected Output: 100 -> 101 -> 150 -> 102 -> 103 -> 104 -> null\nActual Output:   ");
        tokenList.printList();
    }
}
