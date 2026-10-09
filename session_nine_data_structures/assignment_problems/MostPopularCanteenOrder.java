import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MostPopularCanteenOrder {

    public static class PopularItemResult {
        public final String item;
        public final int count;

        public PopularItemResult(String item, int count) {
            this.item = item;
            this.count = count;
        }

        @Override
        public String toString() {
            return "(\"" + item + "\", " + count + ")";
        }
    }

    /**
     * Finds the most frequently ordered canteen item. Breaks ties by picking the item
     * that appeared earliest in the orders list.
     *
     * Approach:
     * 1. First pass: count frequencies using a HashMap.
     * 2. Second pass: iterate through the original list in order, checking counts against max.
     *    Because we only update when strictly greater (>), the first item encountering the max
     *    is naturally preserved!
     *
     * Complexity Analysis:
     * - Hash Map Solution:
     *     Time Complexity: O(n) where n is orders.size() (two linear passes with O(1) hash lookups).
     *     Space Complexity: O(k) where k is the number of distinct items (k <= n).
     * - Nested Scan Comparison:
     *     Scanning the entire list again for every item takes O(n^2) time with O(1) space,
     *     which degrades severely on large inputs (e.g. 10^5 items).
     */
    public static PopularItemResult mostPopular(List<String> orders) {
        if (orders == null || orders.isEmpty()) {
            return new PopularItemResult("", 0);
        }

        Map<String, Integer> counts = new HashMap<>();
        for (String order : orders) {
            counts.put(order, counts.getOrDefault(order, 0) + 1);
        }

        String bestItem = "";
        int maxCount = -1;

        // Iterate through orders in original sequence to break ties by first occurrence
        for (String order : orders) {
            int freq = counts.get(order);
            if (freq > maxCount) {
                maxCount = freq;
                bestItem = order;
            }
        }

        return new PopularItemResult(bestItem, maxCount);
    }

    public static void main(String[] args) {
        List<String> orders1 = List.of("dosa", "idli", "vada", "dosa", "idli", "dosa", "tea");
        System.out.println("Sample 1: " + mostPopular(orders1)); // ("dosa", 3)

        List<String> orders2 = List.of("tea", "coffee", "coffee", "tea");
        System.out.println("Sample 2: " + mostPopular(orders2)); // ("tea", 2)
    }
}
