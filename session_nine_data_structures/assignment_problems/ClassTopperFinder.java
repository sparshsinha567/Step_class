public class ClassTopperFinder {

    public static class TopperResult {
        public final int rowIndex;
        public final int total;

        public TopperResult(int rowIndex, int total) {
            this.rowIndex = rowIndex;
            this.total = total;
        }

        @Override
        public String toString() {
            return "(" + rowIndex + ", " + total + ")";
        }
    }

    /**
     * Finds the student with the highest total marks across all subjects.
     * In case of ties, the student with the smallest row index is preserved.
     *
     * Time Complexity: O(m * n) where m is the number of students and n is the number of subjects.
     * Space Complexity: O(1) auxiliary space beyond the input grid.
     */
    public static TopperResult findTopper(int[][] marks) {
        if (marks == null || marks.length == 0) {
            return new TopperResult(-1, 0);
        }

        int bestRowIndex = 0;
        int maxTotal = -1;

        for (int i = 0; i < marks.length; i++) {
            int currentTotal = 0;
            for (int j = 0; j < marks[i].length; j++) {
                currentTotal += marks[i][j];
            }

            // Strict inequality ensures tie breaks to the smaller row index
            if (currentTotal > maxTotal) {
                maxTotal = currentTotal;
                bestRowIndex = i;
            }
        }

        return new TopperResult(bestRowIndex, maxTotal);
    }

    public static void main(String[] args) {
        int[][] marks = {
            {78, 85, 90},
            {88, 92, 79},
            {65, 70, 95}
        };

        TopperResult topper = findTopper(marks);
        System.out.println("Expected: (1, 259)");
        System.out.println("Actual:   " + topper);
    }
}
