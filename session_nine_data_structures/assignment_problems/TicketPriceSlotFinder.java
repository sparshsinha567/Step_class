import java.util.List;

public class TicketPriceSlotFinder {

    /**
     * Binary Search to find the existing index of newPrice or its correct insertion slot
     * in a sorted list with no duplicates.
     *
     * Complexity Analysis:
     * - Binary Search Approach:
     *     Time Complexity: O(log n) where n is prices.size(). Search interval is halved each step.
     *     Auxiliary Space Complexity: O(1).
     * - Linear Scan Comparison:
     *     Time Complexity: O(n) sequentially scanning until prices[i] >= newPrice.
     *     Auxiliary Space Complexity: O(1).
     *
     * For n = 10^5, binary search completes in ~17 comparisons, whereas linear scan may take 10^5 operations.
     */
    public static int findSlot(int[] prices, int newPrice) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int low = 0;
        int high = prices.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (prices[mid] == newPrice) {
                return mid;
            } else if (prices[mid] < newPrice) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        // When not found, low points to the exact insertion index maintaining sorted order
        return low;
    }

    public static int findSlot(List<Integer> prices, int newPrice) {
        if (prices == null || prices.isEmpty()) {
            return 0;
        }

        int low = 0;
        int high = prices.size() - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midVal = prices.get(mid);

            if (midVal == newPrice) {
                return mid;
            } else if (midVal < newPrice) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low;
    }

    public static void main(String[] args) {
        int[] prices = {120, 150, 200, 260};

        System.out.println("Sample 1 (newPrice 150): " + findSlot(prices, 150)); // 1
        System.out.println("Sample 2 (newPrice 210): " + findSlot(prices, 210)); // 3
        System.out.println("Sample 3 (newPrice 300): " + findSlot(prices, 300)); // 4
    }
}
