import java.util.Random;
import java.util.Scanner;

public class RockPaperScissorsGame {

    private static final int TOTAL_ROUNDS = 5;
    private static final String[] VALID_MOVES = {"Rock", "Paper", "Scissors"};

    public static class InvalidMoveException extends Exception {
        public InvalidMoveException(String message) {
            super(message);
        }
    }

    public static String playRound(String playerMove, String computerMove) {
        if (playerMove == null || computerMove == null) {
            throw new NullPointerException("Moves cannot be null.");
        }

        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }

        boolean playerWins = (playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
                             (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
                             (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"));

        return playerWins ? "Player Wins" : "Computer Wins";
    }

    public static String validateMove(String input) throws InvalidMoveException {
        if (input == null || input.trim().isEmpty()) {
            throw new InvalidMoveException("Input cannot be empty. Please enter \"Rock\", \"Paper\", or \"Scissors\".");
        }

        String cleanedInput = input.trim();
        for (String move : VALID_MOVES) {
            if (move.equalsIgnoreCase(cleanedInput)) {
                return move;
            }
        }
        throw new InvalidMoveException("Invalid move \"" + cleanedInput + "\". Allowed moves are: Rock, Paper, Scissors.");
    }

    public static String generateComputerMove() {
        Random random = new Random();
        int randomIndex = random.nextInt(VALID_MOVES.length);
        return VALID_MOVES[randomIndex];
    }

    public static void displaySummaryTable(String[][] roundRecords, int totalWins, int totalLosses, int totalDraws) {
        System.out.println("\n" + "=".repeat(60));
        System.out.println("\t\t--- GAME SUMMARY TABLE ---");
        System.out.println("=".repeat(60));
        System.out.printf("%-8s | %-15s | %-15s | %-15s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("-".repeat(60));

        for (int i = 0; i < roundRecords.length; i++) {
            System.out.printf("%-8s | %-15s | %-15s | %-15s\n",
                    roundRecords[i][0], roundRecords[i][1], roundRecords[i][2], roundRecords[i][3]);
        }

        System.out.println("=".repeat(60));
        double winPercentage = ((double) totalWins / roundRecords.length) * 100.0;
        System.out.printf("Final Summary (after %d rounds):\n", roundRecords.length);
        System.out.printf("Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n",
                totalWins, totalLosses, totalDraws, winPercentage);
        System.out.println("=".repeat(60));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[][] roundRecords = new String[TOTAL_ROUNDS][4];

        int totalWins = 0;
        int totalLosses = 0;
        int totalDraws = 0;

        System.out.println("=================================================");
        System.out.println("   Welcome to The College Coding Arcade!        ");
        System.out.println("   Game: \"Rock-Paper-Scissors\" (" + TOTAL_ROUNDS + " Rounds)      ");
        System.out.println("=================================================");

        String[] fallbackPlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};

        for (int round = 1; round <= TOTAL_ROUNDS; round++) {
            System.out.println("\n--- Round " + round + " ---");
            String playerMove = "";
            boolean validInput = false;

            while (!validInput) {
                try {
                    System.out.print("Enter your move (Rock / Paper / Scissors): ");
                    String rawInput = "";
                    if (scanner.hasNextLine()) {
                        rawInput = scanner.nextLine();
                    } else {
                        rawInput = fallbackPlayerMoves[round - 1];
                        System.out.println(rawInput + " (Auto-Demo)");
                    }

                    playerMove = validateMove(rawInput);
                    validInput = true;
                } catch (InvalidMoveException e) {
                    System.out.println("[Error]: " + e.getMessage());
                } catch (RuntimeException e) {
                    System.out.println("[Unexpected Error]: " + e.getMessage());
                }
            }

            String computerMove = generateComputerMove();
            String roundResult = playRound(playerMove, computerMove);

            System.out.println("Player: \"" + playerMove + "\" | Computer: \"" + computerMove + "\"");
            System.out.println("Outcome: " + roundResult);

            roundRecords[round - 1][0] = "Round " + round;
            roundRecords[round - 1][1] = playerMove;
            roundRecords[round - 1][2] = computerMove;
            roundRecords[round - 1][3] = roundResult;

            if (roundResult.equals("Player Wins")) {
                totalWins++;
            } else if (roundResult.equals("Computer Wins")) {
                totalLosses++;
            } else {
                totalDraws++;
            }
        }

        displaySummaryTable(roundRecords, totalWins, totalLosses, totalDraws);
        scanner.close();
    }
}
