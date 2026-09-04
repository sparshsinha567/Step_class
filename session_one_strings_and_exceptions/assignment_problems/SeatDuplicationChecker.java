import java.util.Scanner;

public class SeatDuplicationChecker {

    public static class InvalidSeatDataException extends Exception {
        public InvalidSeatDataException(String message) {
            super(message);
        }
    }

    public static void checkDuplicateSeats(int[] seatNumbers) throws InvalidSeatDataException {
        if (seatNumbers == null) {
            throw new NullPointerException("Seat numbers array cannot be null.");
        }
        if (seatNumbers.length == 0) {
            throw new InvalidSeatDataException("Seat allocation list is empty.");
        }

        int[] recordedDuplicates = new int[seatNumbers.length];
        int duplicateCount = 0;

        for (int i = 0; i < seatNumbers.length; i++) {
            int currentSeat = seatNumbers[i];
            boolean isDuplicate = false;

            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (currentSeat == seatNumbers[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                boolean alreadyRecorded = false;
                for (int k = 0; k < duplicateCount; k++) {
                    if (recordedDuplicates[k] == currentSeat) {
                        alreadyRecorded = true;
                        break;
                    }
                }

                if (!alreadyRecorded) {
                    recordedDuplicates[duplicateCount++] = currentSeat;
                }
            }
        }

        if (duplicateCount > 0) {
            for (int i = 0; i < duplicateCount; i++) {
                System.out.println("Duplicate Seat Number Found: " + recordedDuplicates[i]);
            }
        } else {
            System.out.println("No Duplicate Seats Found");
        }
    }

    public static void processSeatCheck(int[] seats) {
        System.out.print("\nInput: {");
        if (seats != null) {
            for (int i = 0; i < seats.length; i++) {
                System.out.print(seats[i] + (i < seats.length - 1 ? ", " : ""));
            }
        }
        System.out.println("}");

        try {
            System.out.print("Output: ");
            checkDuplicateSeats(seats);
        } catch (InvalidSeatDataException e) {
            System.out.println("[Checked Exception]: " + e.getMessage());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("[Unchecked Exception]: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("       Examination Cell - Seat Duplication Checker           ");
        System.out.println("=============================================================");

        int[] sample1 = {101, 102, 103, 102, 105};
        int[] sample2 = {101, 102, 103, 104, 105};
        int[] sample3 = {201, 202, 201, 203, 202, 204};
        int[] sample4 = {};
        int[] sample5 = null;

        processSeatCheck(sample1);
        processSeatCheck(sample2);
        processSeatCheck(sample3);
        processSeatCheck(sample4);
        processSeatCheck(sample5);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Live Exam Hall Seat Input ---");
        System.out.print("Enter comma-separated seat numbers (e.g. 101, 102, 103): ");
        if (scanner.hasNextLine()) {
            String rawLine = scanner.nextLine().trim();
            if (!rawLine.isEmpty()) {
                try {
                    String[] tokens = rawLine.split(",");
                    int[] userSeats = new int[tokens.length];
                    for (int i = 0; i < tokens.length; i++) {
                        userSeats[i] = Integer.parseInt(tokens[i].trim());
                    }
                    processSeatCheck(userSeats);
                } catch (NumberFormatException e) {
                    System.out.println("[Format Error]: Please enter valid integer seat numbers.");
                }
            }
        }
        scanner.close();
    }
}
