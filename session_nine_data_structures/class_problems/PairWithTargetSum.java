import java.util.HashSet;
import java.util.Set;

public class PairWithTargetSum {

    /**
     * Optimal Approach: Hash Set Lookup
     *
     * Iterates through elements while storing visited numbers in a hash set.
     * For each number, checks whether its complement (target - num) exists in the set.
     *
     * Time Complexity: O(n) on average because HashSet offers O(1) expected lookup and insertion.
     * Auxiliary Space Complexity: O(n) to store up to n elements in the hash set.
     */
    public static boolean hasPairWithSum(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }

        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }

    /**
     * Alternative Approach: Brute-Force Nested Loops
     *
     * Checks all possible distinct pairs (i, j) where i < j.
     *
     * Time Complexity: O(n^2) as it tests n * (n - 1) / 2 pairs.
     * Auxiliary Space Complexity: O(1) as no extra storage is allocated.
     */
    public static boolean hasPairWithSumBruteForce(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return false;
        }
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums1 = {2, 7, 11, 15};
        int target1 = 9;
        System.out.println("nums1 has pair summing to 9: " + hasPairWithSum(nums1, target1)); // true

        int[] nums2 = {3, 4, 6};
        int target2 = 20;
        System.out.println("nums2 has pair summing to 20: " + hasPairWithSum(nums2, target2)); // false
    }
}
