import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeTokenQueues {

    /**
     * Merges two pre-sorted lists/arrays of token numbers into a single sorted list
     * using the two-pointer technique.
     *
     * Time Complexity: O(m + n) where m = counterA.length and n = counterB.length.
     * Auxiliary Space Complexity: O(m + n) for the output list.
     *
     * Comparison with Naive Sort:
     * Joining both lists and then running an O(K log K) sort algorithm requires
     * O((m + n) log(m + n)) time. The two-pointer merge exploits the pre-sorted invariant
     * to achieve optimal O(m + n) linear time.
     */
    public static List<Integer> mergeTokens(List<Integer> counterA, List<Integer> counterB) {
        if (counterA == null) counterA = new ArrayList<>();
        if (counterB == null) counterB = new ArrayList<>();

        List<Integer> result = new ArrayList<>(counterA.size() + counterB.size());
        int pA = 0;
        int pB = 0;

        while (pA < counterA.size() && pB < counterB.size()) {
            int valA = counterA.get(pA);
            int valB = counterB.get(pB);

            if (valA <= valB) {
                result.add(valA);
                pA++;
            } else {
                result.add(valB);
                pB++;
            }
        }

        while (pA < counterA.size()) {
            result.add(counterA.get(pA));
            pA++;
        }

        while (pB < counterB.size()) {
            result.add(counterB.get(pB));
            pB++;
        }

        return result;
    }

    public static int[] mergeTokens(int[] counterA, int[] counterB) {
        if (counterA == null) counterA = new int[0];
        if (counterB == null) counterB = new int[0];

        int[] result = new int[counterA.length + counterB.length];
        int pA = 0;
        int pB = 0;
        int k = 0;

        while (pA < counterA.length && pB < counterB.length) {
            if (counterA[pA] <= counterB[pB]) {
                result[k++] = counterA[pA++];
            } else {
                result[k++] = counterB[pB++];
            }
        }

        while (pA < counterA.length) {
            result[k++] = counterA[pA++];
        }

        while (pB < counterB.length) {
            result[k++] = counterB[pB++];
        }

        return result;
    }

    public static void main(String[] args) {
        List<Integer> a1 = List.of(3, 8, 15, 20);
        List<Integer> b1 = List.of(5, 8, 12);
        System.out.println("Sample 1 Output: " + mergeTokens(a1, b1)); // [3, 5, 8, 8, 12, 15, 20]

        List<Integer> a2 = List.of();
        List<Integer> b2 = List.of(4, 9);
        System.out.println("Sample 2 Output: " + mergeTokens(a2, b2)); // [4, 9]
    }
}
