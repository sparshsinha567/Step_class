import java.util.Random;

public class TeamBmiCalculator {

    private static final double UNDERWEIGHT_LIMIT = 18.5;
    private static final double NORMAL_UPPER_LIMIT = 24.9;
    private static final double OVERWEIGHT_UPPER_LIMIT = 29.9;

    public static class InvalidHealthDataException extends Exception {
        public InvalidHealthDataException(String message) {
            super(message);
        }
    }

    public static double computeBmi(double weightKg, double heightM) throws InvalidHealthDataException {
        if (heightM <= 0.0 || weightKg <= 0.0) {
            throw new InvalidHealthDataException("Height and weight must be strictly positive values.");
        }
        if (heightM < 0.5 || heightM > 2.8) {
            throw new InvalidHealthDataException("Height " + heightM + " m is outside realistic human range (0.5m - 2.8m).");
        }
        if (weightKg < 10.0 || weightKg > 400.0) {
            throw new InvalidHealthDataException("Weight " + weightKg + " kg is outside realistic human range (10kg - 400kg).");
        }
        return weightKg / (heightM * heightM);
    }

    public static String getBmiStatus(double bmi) {
        if (Double.isNaN(bmi) || Double.isInfinite(bmi)) {
            throw new IllegalArgumentException("Invalid BMI numerical value provided.");
        }
        if (bmi < UNDERWEIGHT_LIMIT) {
            return "Underweight";
        } else if (bmi <= NORMAL_UPPER_LIMIT) {
            return "Normal";
        } else if (bmi <= OVERWEIGHT_UPPER_LIMIT) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }

    public static void printWellnessReport(double[] heights, double[] weights) {
        if (heights == null || weights == null) {
            throw new NullPointerException("Input arrays cannot be null.");
        }
        if (heights.length != weights.length) {
            throw new IllegalArgumentException("Heights and weights arrays must have equal length.");
        }

        System.out.println("=".repeat(75));
        System.out.println("\t\t  CORPORATE WELLNESS PROGRAM REPORT");
        System.out.println("=".repeat(75));
        System.out.printf("%-12s | %-12s | %-12s | %-10s | %-15s\n",
                "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-".repeat(75));

        int validCount = 0;
        double sumBmi = 0.0;

        for (int i = 0; i < heights.length; i++) {
            String personLabel = "Person " + (i + 1);
            try {
                double bmi = computeBmi(weights[i], heights[i]);
                String status = getBmiStatus(bmi);
                sumBmi += bmi;
                validCount++;

                System.out.printf("%-12s | %-12.2f | %-12.1f | %-10.2f | %-15s\n",
                        personLabel, heights[i], weights[i], bmi, status);
            } catch (InvalidHealthDataException e) {
                System.out.printf("%-12s | %-12.2f | %-12.1f | %-10s | [Error: %s]\n",
                        personLabel, heights[i], weights[i], "N/A", e.getMessage());
            } catch (RuntimeException e) {
                System.out.printf("%-12s | %-12.2f | %-12.1f | %-10s | [System Error]\n",
                        personLabel, heights[i], weights[i], "N/A");
            }
        }

        System.out.println("=".repeat(75));
        if (validCount > 0) {
            double avgBmi = sumBmi / validCount;
            System.out.printf("Team Summary: Total Evaluated = %d | Average BMI = %.2f | Average Category = %s\n",
                    validCount, avgBmi, getBmiStatus(avgBmi));
        }
        System.out.println("=".repeat(75));
    }

    public static void generateMockData(double[] heights, double[] weights) {
        Random random = new Random(42);
        for (int i = 0; i < heights.length; i++) {
            heights[i] = 1.50 + (random.nextDouble() * 0.45);
            weights[i] = 45.0 + (random.nextDouble() * 65.0);
        }
    }

    public static void main(String[] args) {
        System.out.println("\n--- 1. Sample Data Verification ---");
        double[] sampleHeights = {1.75, 1.60};
        double[] sampleWeights = {70.0, 90.0};
        printWellnessReport(sampleHeights, sampleWeights);

        System.out.println("\n--- 2. Full Team (10 Employees) Wellness Screening ---");
        int teamSize = 10;
        double[] teamHeights = new double[teamSize];
        double[] teamWeights = new double[teamSize];

        generateMockData(teamHeights, teamWeights);
        printWellnessReport(teamHeights, teamWeights);

        System.out.println("\n--- 3. Testing Exception Handling & Boundary Cases ---");
        double[] edgeHeights = {1.70, -1.5, 0.0};
        double[] edgeWeights = {65.0, 80.0, 55.0};
        printWellnessReport(edgeHeights, edgeWeights);
    }
}
