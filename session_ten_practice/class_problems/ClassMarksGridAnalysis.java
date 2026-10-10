import java.util.*;

public class ClassMarksGridAnalysis {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<String> names = new ArrayList<>();
        List<int[]> marksList = new ArrayList<>();

        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) continue;

            int openBracket = line.indexOf('[');
            int closeBracket = line.indexOf(']');
            if (openBracket == -1 || closeBracket == -1) continue;

            String name = line.substring(0, openBracket).trim();
            String numbersPart = line.substring(openBracket + 1, closeBracket);
            String[] tokens = numbersPart.split(",");
            int[] marks = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                marks[i] = Integer.parseInt(tokens[i].trim());
            }

            names.add(name);
            marksList.add(marks);
        }

        int n = names.size();
        int numSubjects = n > 0 ? marksList.get(0).length : 0;
        int[] studentTotals = new int[n];
        double[] subjectSums = new double[numSubjects];

        int maxTotal = -1;
        String topper = "";

        StringBuilder totalsBuilder = new StringBuilder("Totals ");
        for (int i = 0; i < n; i++) {
            int total = 0;
            int[] m = marksList.get(i);
            for (int j = 0; j < numSubjects; j++) {
                total += m[j];
                subjectSums[j] += m[j];
            }
            studentTotals[i] = total;
            totalsBuilder.append(names.get(i)).append(" ").append(total);
            if (i < n - 1) totalsBuilder.append(", ");

            if (total > maxTotal) {
                maxTotal = total;
                topper = names.get(i);
            }
        }

        System.out.println(totalsBuilder.toString());

        StringBuilder avgBuilder = new StringBuilder("averages ");
        for (int j = 0; j < numSubjects; j++) {
            double avg = subjectSums[j] / n;
            avgBuilder.append(String.format(Locale.US, "%.2f", avg));
            if (j < numSubjects - 1) avgBuilder.append(", ");
        }
        System.out.println(avgBuilder.toString());

        System.out.println("topper " + topper + " (" + maxTotal + ")");
        sc.close();
    }
}
