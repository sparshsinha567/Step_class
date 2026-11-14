import java.util.Arrays;

/**
 * Problem 3: The Attendance Disorder Score (Sorting Algorithms)
 * 
 * TASK:
 * Students are supposed to enter the lab in roll-number order. The lab assistant
 * measures how disordered the actual entry sequence was by counting disorder pairs:
 * pairs (i, j) with i < j but roll[i] > roll[j]. Implement long countInversions(int[] roll)
 * that returns this count. Checking every pair is O(n^2); your solution must run
 * in O(n log n) by counting the pairs while you split and merge the array.
 * 
 * COMPLEXITY & CHARACTERISTICS:
 * - Time Complexity: O(n log n) in all cases (best, average, worst) through divide-and-conquer.
 * - Auxiliary Space Complexity: O(n) temporary buffer used during merge step.
 * - Stability: Stable. Using roll[i] <= roll[j] during merging guarantees that identical roll numbers
 *   are not counted as inversions and maintain original order.
 */
public class AttendanceDisorderScore {

    public static long countInversions(int[] roll) {
        if (roll == null || roll.length <= 1) {
            return 0;
        }
        int[] clone = roll.clone();
        int[] temp = new int[roll.length];
        return mergeSortAndCount(clone, temp, 0, clone.length - 1);
    }

    private static long mergeSortAndCount(int[] arr, int[] temp, int left, int right) {
        long count = 0;
        if (left < right) {
            int mid = left + (right - left) / 2;
            count += mergeSortAndCount(arr, temp, left, mid);
            count += mergeSortAndCount(arr, temp, mid + 1, right);
            count += mergeAndCount(arr, temp, left, mid, right);
        }
        return count;
    }

    private static long mergeAndCount(int[] arr, int[] temp, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = left;
        long invCount = 0;

        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                // arr[i] > arr[j] means arr[j] is inverted with all remaining elements in the left half
                temp[k++] = arr[j++];
                invCount += (mid - i + 1);
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }
        while (j <= right) {
            temp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = temp[i];
        }

        return invCount;
    }

    public static void main(String[] args) {
        int[] roll1 = {2, 4, 1, 3, 5};
        System.out.println("Roll: " + Arrays.toString(roll1));
        System.out.println("Disorder Score: " + countInversions(roll1));
        // Expected: 3 (pairs: (2,1), (4,1), (4,3))

        int[] roll2 = {5, 4, 3, 2, 1};
        System.out.println("\nRoll: " + Arrays.toString(roll2));
        System.out.println("Disorder Score: " + countInversions(roll2));
        // Expected: 10
    }
}
