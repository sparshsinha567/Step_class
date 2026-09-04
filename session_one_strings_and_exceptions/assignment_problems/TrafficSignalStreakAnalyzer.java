import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {

    public static class InvalidSignalLogException extends Exception {
        public InvalidSignalLogException(String message) {
            super(message);
        }
    }

    public static void findLongestStreak(String signalLog) throws InvalidSignalLogException {
        if (signalLog == null) {
            throw new NullPointerException("Signal log cannot be null.");
        }

        String cleanedLog = signalLog.trim().toUpperCase();

        if (cleanedLog.isEmpty()) {
            throw new InvalidSignalLogException("Signal log cannot be empty.");
        }

        for (int i = 0; i < cleanedLog.length(); i++) {
            char signal = cleanedLog.charAt(i);
            if (signal != 'R' && signal != 'Y' && signal != 'G') {
                throw new InvalidSignalLogException("Invalid signal code '" + signal + "' at position " + (i + 1)
                        + ". Only 'R', 'Y', and 'G' are allowed.");
            }
        }

        char longestStreakChar = cleanedLog.charAt(0);
        int maxStreakLength = 1;

        char currentStreakChar = cleanedLog.charAt(0);
        int currentStreakLength = 1;

        for (int i = 1; i < cleanedLog.length(); i++) {
            char currentChar = cleanedLog.charAt(i);

            if (currentChar == currentStreakChar) {
                currentStreakLength++;
            } else {
                if (currentStreakLength > maxStreakLength) {
                    maxStreakLength = currentStreakLength;
                    longestStreakChar = currentStreakChar;
                }
                currentStreakChar = currentChar;
                currentStreakLength = 1;
            }
        }

        if (currentStreakLength > maxStreakLength) {
            maxStreakLength = currentStreakLength;
            longestStreakChar = currentStreakChar;
        }

        System.out.printf("Longest Streak: '%c' repeated %d times\n", longestStreakChar, maxStreakLength);
    }

    public static void analyzeLog(String log) {
        System.out.println("\nSignal Log: \"" + log + "\"");
        try {
            System.out.print("Output:     ");
            findLongestStreak(log);
        } catch (InvalidSignalLogException e) {
            System.out.println("[Checked Exception]: " + e.getMessage());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("[Unchecked Exception]: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("   Traffic Signal Streak Analyzer - Longest Color Streak     ");
        System.out.println("=============================================================");

        analyzeLog("RRGGGYRR");
        analyzeLog("RRRRYYGG");
        analyzeLog("YYYYY");
        analyzeLog("RGB");
        analyzeLog("");
        analyzeLog(null);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive Signal Log Inspection ---");
        System.out.print("Enter signal log sequence (e.g. RRGGGYRR): ");
        if (scanner.hasNextLine()) {
            String inputLog = scanner.nextLine();
            if (!inputLog.trim().isEmpty()) {
                analyzeLog(inputLog);
            }
        }
        scanner.close();
    }
}
