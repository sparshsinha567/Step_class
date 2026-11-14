/**
 * Problem 5: Round-Robin Game Turns (Coding Assignment)
 * 
 * TASK:
 * Players take turns in a fixed circle. Store the players in a circular singly linked list
 * and print who plays each turn for a given number of turns.
 * Implement addLast(String name) on a circular list (keep a tail reference) and printTurns(int turns).
 * 
 * CONSTRAINTS:
 *   1 <= number of players <= 20
 *   1 <= turns <= 100
 * 
 * COMPLEXITY:
 * - Adding a player: O(1) time complexity by maintaining a direct tail pointer.
 * - Printing turns: O(turns) time complexity.
 * - Space Complexity: O(n) to store players in the circular list.
 */
public class RoundRobinGameTurns {

    public static class PlayerNode {
        public String name;
        public PlayerNode next;

        public PlayerNode(String name) {
            this.name = name;
        }
    }

    private PlayerNode tail;

    public RoundRobinGameTurns() {
        this.tail = null;
    }

    public void addLast(String name) {
        PlayerNode newNode = new PlayerNode(name);
        if (tail == null) {
            tail = newNode;
            tail.next = tail;
        } else {
            newNode.next = tail.next; // Points to head
            tail.next = newNode;
            tail = newNode;
        }
    }

    public void printTurns(int turns) {
        if (tail == null || turns <= 0) {
            System.out.println();
            return;
        }
        PlayerNode current = tail.next; // Head is tail.next
        for (int i = 0; i < turns; i++) {
            System.out.print(current.name + (i == turns - 1 ? "" : " "));
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        RoundRobinGameTurns game = new RoundRobinGameTurns();
        game.addLast("Asha");
        game.addLast("Ravi");
        game.addLast("Neha");

        System.out.println("Simulating 7 Turns:");
        System.out.print("Expected Output: Asha Ravi Neha Asha Ravi Neha Asha\nActual Output:   ");
        game.printTurns(7);
    }
}
