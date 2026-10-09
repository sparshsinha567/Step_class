public class HotWeatherAlertWindows {

    /**
     * Counts the number of k-hour consecutive blocks whose average is >= threshold.
     * Uses sliding window to update running window sum in O(1) per step.
     *
     * Complexity Analysis:
     * - Sliding Window Approach:
     *     Time Complexity: O(n) where n = readings.length.
     *     Space Complexity: O(1) auxiliary space.
     * - Recalculating from Scratch (Naive):
     *     Time Complexity: O((n - k + 1) * k), which simplifies to O(n * k) or O(n^2) when k ~ n/2.
     *     Space Complexity: O(1).
     */
    public static int countAlerts(int[] readings, int k, int threshold) {
        if (readings == null || readings.length < k || k <= 0) {
            return 0;
        }

        long targetSum = (long) k * threshold;
        long currentSum = 0;
        int alertCount = 0;

        // Initialize sum of first k elements
        for (int i = 0; i < k; i++) {
            currentSum += readings[i];
        }

        if (currentSum >= targetSum) {
            alertCount++;
        }

        // Slide window from index k to n - 1
        for (int i = k; i < readings.length; i++) {
            currentSum += readings[i] - readings[i - k];
            if (currentSum >= targetSum) {
                alertCount++;
            }
        }

        return alertCount;
    }

    public static void main(String[] args) {
        int[] readings = {2, 2, 2, 2, 5, 5, 5, 8};
        int k = 3;
        int threshold = 4;

        int result = countAlerts(readings, k, threshold);
        System.out.println("Expected: 3");
        System.out.println("Actual:   " + result);
    }
}
