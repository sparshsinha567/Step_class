public class WarehouseGridSummary {

    public static class SummaryResult {
        public final int totalItems;
        public final int maxRow;
        public final int maxCol;

        public SummaryResult(int totalItems, int maxRow, int maxCol) {
            this.totalItems = totalItems;
            this.maxRow = maxRow;
            this.maxCol = maxCol;
        }

        @Override
        public String toString() {
            return "(" + totalItems + ", (" + maxRow + ", " + maxCol + "))";
        }
    }

    /**
     * Traverses the 2D warehouse grid to compute the total item count and locates the
     * first occurrence of the storage bin holding the maximum item count.
     *
     * Time Complexity: O(m * n) where m is row count and n is column count.
     * Auxiliary Space Complexity: O(1) beyond the input grid.
     */
    public static SummaryResult warehouseSummary(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new SummaryResult(0, -1, -1);
        }

        int totalItems = 0;
        int maxItems = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int current = grid[r][c];
                totalItems += current;

                // Update only when strictly greater to preserve first encountered
                if (current > maxItems) {
                    maxItems = current;
                    maxRow = r;
                    maxCol = c;
                }
            }
        }

        return new SummaryResult(totalItems, maxRow, maxCol);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        SummaryResult res = warehouseSummary(grid);
        System.out.println("Expected: (49, (2, 1))");
        System.out.println("Actual:   " + res);
    }
}
