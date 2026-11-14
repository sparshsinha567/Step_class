import java.util.Arrays;

/**
 * Problem 5: The Contest Leaderboard (Sorting Algorithms)
 * 
 * TASK:
 * After a live coding contest, each Entry has a student name and marks between 0 and 100.
 * The leaderboard must list students from highest marks to lowest, and students with equal
 * marks must stay in the order in which they submitted (the input order).
 * Implement Entry[] leaderboard(Entry[] entries) using counting on the marks values,
 * without comparing two entries with each other, so that it runs in O(n + 101) time.
 * 
 * COMPLEXITY & CHARACTERISTICS:
 * - Time Complexity: O(n + 101) = O(n), non-comparison distribution sort.
 * - Auxiliary Space Complexity: O(n + 101) for output array and frequency/prefix-sum counts.
 * - Stability: Stable. We place entries right-to-left into the output array using cumulative counts,
 *   preserving initial submission order for ties.
 */
class Entry {
    String name;
    int marks;

    public Entry(String name, int marks) {
        this.name = name;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return name + " " + marks;
    }
}

public class ContestLeaderboard {

    public static Entry[] leaderboard(Entry[] entries) {
        if (entries == null || entries.length <= 1) {
            return entries == null ? new Entry[0] : entries.clone();
        }
        int n = entries.length;
        // Range: marks 0 to 100.
        // Invert key: key = 100 - marks, so 100 maps to key 0 (highest rank).
        int[] count = new int[101];

        for (Entry e : entries) {
            int key = 100 - e.marks;
            count[key]++;
        }

        // Cumulative frequency counts
        for (int i = 1; i < 101; i++) {
            count[i] += count[i - 1];
        }

        Entry[] output = new Entry[n];
        // Right-to-left traversal preserves stable submission order
        for (int i = n - 1; i >= 0; i--) {
            int key = 100 - entries[i].marks;
            output[count[key] - 1] = entries[i];
            count[key]--;
        }

        return output;
    }

    public static void main(String[] args) {
        Entry[] entries = {
            new Entry("Asha", 90),
            new Entry("Ravi", 75),
            new Entry("Neha", 90),
            new Entry("Kiran", 100),
            new Entry("Meera", 75)
        };

        System.out.println("Submissions: " + Arrays.toString(entries));
        Entry[] board = leaderboard(entries);
        System.out.println("Leaderboard: " + Arrays.toString(board));
        // Expected: [Kiran 100, Asha 90, Neha 90, Ravi 75, Meera 75]
    }
}
