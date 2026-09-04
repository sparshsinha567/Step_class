import java.util.Scanner;

public class CsvStudentRecordParser {

    public static class InvalidStudentRecordException extends Exception {
        public InvalidStudentRecordException(String message) {
            super(message);
        }
    }

    public static void parseStudentRecord(String csvLine) throws InvalidStudentRecordException {
        if (csvLine == null) {
            throw new NullPointerException("CSV line cannot be null.");
        }

        String cleanedLine = csvLine.trim();
        if (cleanedLine.isEmpty()) {
            throw new InvalidStudentRecordException("CSV line is empty.");
        }

        String[] fields = cleanedLine.split(",");

        if (fields.length != 3) {
            System.out.println("Invalid Record");
            return;
        }

        String name = fields[0].trim();
        String rollNo = fields[1].trim();
        String dept = fields[2].trim();

        if (name.isEmpty() || rollNo.isEmpty() || dept.isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        StringBuilder recordBuilder = new StringBuilder();
        recordBuilder.append("Name: ").append(name)
                     .append(" | Roll No: ").append(rollNo)
                     .append(" | Dept: ").append(dept);

        System.out.println(recordBuilder.toString());
    }

    public static void processCsvLine(String csvLine) {
        System.out.println("\nInput:  \"" + csvLine + "\"");
        try {
            System.out.print("Output: ");
            parseStudentRecord(csvLine);
        } catch (InvalidStudentRecordException e) {
            System.out.println("[Checked Exception]: " + e.getMessage());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("[Unchecked Exception]: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("         T&P Team - CSV Student Record Parser                ");
        System.out.println("=============================================================");

        processCsvLine("Ananya Verma,RA2211003010123,CSE");
        processCsvLine("Ananya Verma,CSE");
        processCsvLine("Rohan Sharma,RA2211003010456,ECE");
        processCsvLine("Rahul, ,IT");
        processCsvLine("");
        processCsvLine(null);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive Student CSV Input ---");
        System.out.print("Enter CSV line (Name,RollNumber,Department): ");
        if (scanner.hasNextLine()) {
            String userInput = scanner.nextLine();
            if (!userInput.trim().isEmpty()) {
                processCsvLine(userInput);
            }
        }
        scanner.close();
    }
}
