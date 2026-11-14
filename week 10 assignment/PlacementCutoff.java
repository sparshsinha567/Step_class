import java.util.Arrays;

/**
 * Problem 4: The Placement Cutoff (Sorting Algorithms)
 * 
 * TASK:
 * The placement cell receives the aptitude marks of all applicants and needs the
 * k-th highest mark to set the cutoff. Implement int kthHighest(int[] marks, int k)
 * that returns it, where 1 <= k <= marks.length. Sorting the whole array costs O(n log n).
 * Instead, reuse the partition step from quick sort (last element as pivot) and recurse
 * or loop only into the side that contains the answer, for an average time of O(n).
 * Duplicate marks count separately.
 * 
 * COMPLEXITY & CHARACTERISTICS:
 * - Time Complexity:
 *   - Average Case: O(n) QuickSelect algorithm (n + n/2 + n/4 + ... <= 2n).
 *   - Worst Case: O(n^2) if partitions are extremely unbalanced.
 * - Auxiliary Space Complexity: O(1) iterative partition without recursive call stack.
 * - Stability: Not stable. Lomuto partitioning swaps non-adjacent elements across the pivot.
 */
public class PlacementCutoff {

    public static int kthHighest(int[] marks, int k) {
        if (marks == null || k < 1 || k > marks.length) {
            throw new IllegalArgumentException("Invalid input or k out of bounds");
        }
        int[] arr = marks.clone();
        int n = arr.length;
        // In ascending order, the k-th highest element resides at index (n - k)
        int targetIndex = n - k;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int pivotIndex = partition(arr, low, high);
            if (pivotIndex == targetIndex) {
                return arr[pivotIndex];
            } else if (pivotIndex < targetIndex) {
                low = pivotIndex + 1;
            } else {
                high = pivotIndex - 1;
            }
        }
        return arr[low];
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
            }
        }
        int temp = arr[i];
        arr[i] = arr[high];
        arr[high] = temp;
        return i;
    }

    public static void main(String[] args) {
        int[] marks1 = {72, 95, 60, 88, 79};
        int k1 = 2;
        System.out.println("Marks: " + Arrays.toString(marks1) + ", k = " + k1);
        System.out.println("Cutoff (2nd highest): " + kthHighest(marks1, k1));
        // Expected: 88

        int[] marks2 = {50, 90, 90, 70};
        int k2 = 2;
        System.out.println("\nMarks: " + Arrays.toString(marks2) + ", k = " + k2);
        System.out.println("Cutoff (2nd highest): " + kthHighest(marks2, k2));
        // Expected: 90
    }
}
