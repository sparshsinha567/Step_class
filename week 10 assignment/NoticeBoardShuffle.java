import java.util.Arrays;

/**
 * Problem 1: The Notice Board Shuffle (Sorting Algorithms)
 * 
 * TASK:
 * The class representative pins test scores on the notice board and arranges them
 * in ascending order by only ever swapping two neighbouring sheets. Implement
 * int[] bubbleStats(int[] scores) that sorts the array using this neighbour-swap
 * method, stops as soon as a full sweep makes no swap, and returns {passes, swaps}:
 * the number of sweeps performed and the total number of swaps made. Explain why
 * an already-sorted board needs only one pass.
 * 
 * COMPLEXITY & CHARACTERISTICS:
 * - Time Complexity:
 *   - Best Case: O(n) when array is already sorted (1 pass, 0 swaps).
 *   - Worst Case: O(n^2) when array is reverse sorted (n-1 passes, n*(n-1)/2 swaps).
 *   - Average Case: O(n^2).
 * - Auxiliary Space Complexity: O(1) in-place algorithm.
 * - Stability: Stable. Elements of equal value are never swapped.
 * 
 * WHY AN ALREADY-SORTED BOARD NEEDS ONLY ONE PASS:
 * On an already sorted board, the inner loop compares each adjacent pair scores[j] and
 * scores[j+1] exactly once. Because every pair satisfies scores[j] <= scores[j+1], no swap
 * is executed and the boolean 'swapped' flag remains false. Detecting no swaps during
 * the entire first sweep confirms the array is sorted, triggering early loop termination
 * after exactly 1 pass in O(n) time.
 */
public class NoticeBoardShuffle {

    public static int[] bubbleStats(int[] scores) {
        if (scores == null || scores.length <= 1) {
            return new int[]{scores == null || scores.length == 0 ? 0 : 1, 0};
        }
        int n = scores.length;
        int passes = 0;
        int totalSwaps = 0;

        for (int i = 0; i < n - 1; i++) {
            passes++;
            boolean swapped = false;
            for (int j = 0; j < n - 1 - i; j++) {
                if (scores[j] > scores[j + 1]) {
                    int temp = scores[j];
                    scores[j] = scores[j + 1];
                    scores[j + 1] = temp;
                    totalSwaps++;
                    swapped = true;
                }
            }
            if (!swapped) {
                break;
            }
        }
        return new int[]{passes, totalSwaps};
    }

    public static void main(String[] args) {
        // Sample 1: scores = [5, 1, 4, 2, 8]
        int[] scores1 = {5, 1, 4, 2, 8};
        System.out.println("Sample 1 Initial: " + Arrays.toString(scores1));
        int[] stats1 = bubbleStats(scores1);
        System.out.println("Sorted: " + Arrays.toString(scores1) + " | passes = " + stats1[0] + ", swaps = " + stats1[1]);
        // Expected: [1, 2, 4, 5, 8], passes = 3, swaps = 4

        // Sample 2: scores = [1, 2, 3, 4]
        int[] scores2 = {1, 2, 3, 4};
        System.out.println("\nSample 2 Initial: " + Arrays.toString(scores2));
        int[] stats2 = bubbleStats(scores2);
        System.out.println("Sorted: " + Arrays.toString(scores2) + " | passes = " + stats2[0] + ", swaps = " + stats2[1]);
        // Expected: [1, 2, 3, 4], passes = 1, swaps = 0
    }
}
