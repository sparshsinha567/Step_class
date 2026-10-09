import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSumArray {

    /**
     * Approach 1: Two-Pointer Technique on Sorted Copy
     *
     * Sorts a copy of the array and uses two pointers at both ends.
     * If sum == target -> true.
     * If sum < target -> advance low pointer.
     * If sum > target -> decrement high pointer.
     *
     * Time Complexity: O(n log n) due to sorting.
     * Auxiliary Space Complexity: O(n) for sorting copy (or O(1) if in-place mutation permitted).
     */
    public static boolean hasPairWithSumTwoPointers(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        int[] copy = Arrays.copyOf(nums, nums.length);
        Arrays.sort(copy);

        int low = 0;
        int high = copy.length - 1;

        while (low < high) {
            int currentSum = copy[low] + copy[high];
            if (currentSum == target) {
                return true;
            } else if (currentSum < target) {
                low++;
            } else {
                high--;
            }
        }

        return false;
    }

    /**
     * Approach 2: Hash Set Lookup (Optimal)
     *
     * Time Complexity: O(n) average.
     * Auxiliary Space Complexity: O(n).
     */
    public static boolean hasPairWithSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(target - num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        System.out.println("Two-pointer test (9): " + hasPairWithSumTwoPointers(nums1, 9)); // true
        System.out.println("Hash-set test (9):    " + hasPairWithSum(nums1, 9)); // true

        int[] nums2 = {3, 4, 6};
        System.out.println("Two-pointer test (20): " + hasPairWithSumTwoPointers(nums2, 20)); // false
        System.out.println("Hash-set test (20):    " + hasPairWithSum(nums2, 20)); // false
    }
}
