public class MaxContainerArea {

    /**
     * Optimal Solution: Two-Pointer Greedy Approach
     *
     * Starts with left at 0 and right at heights.length - 1.
     * Computes area = min(heights[left], heights[right]) * (right - left).
     * Moves inward the pointer with the shorter wall because any container using that shorter
     * wall with a narrower width cannot possibly exceed the current area.
     *
     * Time Complexity: O(n) - Each step moves one pointer inward, inspecting each boundary once.
     * Auxiliary Space Complexity: O(1) - Only constant extra variables used.
     */
    public static int maxContainerArea(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }

        int left = 0;
        int right = heights.length - 1;
        int maxArea = 0;

        while (left < right) {
            int width = right - left;
            int hLeft = heights[left];
            int hRight = heights[right];
            int minHeight = Math.min(hLeft, hRight);
            int currentArea = minHeight * width;

            if (currentArea > maxArea) {
                maxArea = currentArea;
            }

            // Move the pointer pointing to the shorter vertical line
            if (hLeft < hRight) {
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }

    /**
     * Brute-Force Solution:
     *
     * Examines every possible pair (i, j) with 0 <= i < j < n.
     *
     * Time Complexity: O(n^2).
     * Auxiliary Space Complexity: O(1).
     * For large inputs (e.g., n = 10^5), O(n^2) requires ~10^10 operations which causes TLE,
     * whereas O(n) executes in milliseconds (~10^5 operations).
     */
    public static int maxContainerAreaBruteForce(int[] heights) {
        if (heights == null || heights.length < 2) {
            return 0;
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; i++) {
            for (int j = i + 1; j < heights.length; j++) {
                int area = Math.min(heights[i], heights[j]) * (j - i);
                if (area > maxArea) {
                    maxArea = area;
                }
            }
        }
        return maxArea;
    }

    public static void main(String[] args) {
        int[] heights = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        int optimalResult = maxContainerArea(heights);
        int bruteResult = maxContainerAreaBruteForce(heights);

        System.out.println("Expected Output: 49");
        System.out.println("Optimal Result:  " + optimalResult);
        System.out.println("Brute Result:    " + bruteResult);
    }
}
