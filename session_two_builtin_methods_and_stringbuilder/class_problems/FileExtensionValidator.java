import java.util.Scanner;

public class FileExtensionValidator {

    private static final String[] ACCEPTED_EXTENSIONS = {"pdf", "docx", "zip"};

    public static class InvalidFilenameException extends Exception {
        public InvalidFilenameException(String message) {
            super(message);
        }
    }

    public static String validateFileExtension(String filename) throws InvalidFilenameException {
        if (filename == null) {
            throw new NullPointerException("Filename cannot be null.");
        }

        String cleanedFilename = filename.trim();
        if (cleanedFilename.isEmpty()) {
            throw new InvalidFilenameException("Filename is empty.");
        }

        int dotIndex = cleanedFilename.lastIndexOf('.');

        if (dotIndex == -1 || dotIndex == cleanedFilename.length() - 1) {
            return "Rejected — invalid file type";
        }

        String extension = cleanedFilename.substring(dotIndex + 1);

        for (String accepted : ACCEPTED_EXTENSIONS) {
            if (accepted.equalsIgnoreCase(extension)) {
                return "Accepted";
            }
        }

        return "Rejected — invalid file type";
    }

    public static void processFile(String filename) {
        System.out.println("\nFilename: \"" + filename + "\"");
        try {
            String result = validateFileExtension(filename);
            System.out.println("Output:   " + result);
        } catch (InvalidFilenameException e) {
            System.out.println("[Checked Exception]: " + e.getMessage());
        } catch (NullPointerException | IllegalArgumentException e) {
            System.out.println("[Unchecked Exception]: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        System.out.println("=============================================================");
        System.out.println("      Assignment Upload Portal - File Extension Validator     ");
        System.out.println("=============================================================");

        processFile("Assignment1.PDF");
        processFile("notes.txt");
        processFile("project_archive.zip");
        processFile("report.Docx");
        processFile("malicious_file.exe");
        processFile("noextension");
        processFile("");
        processFile(null);

        Scanner scanner = new Scanner(System.in);
        System.out.println("\n--- Interactive File Upload Validation ---");
        System.out.print("Enter uploaded filename: ");
        if (scanner.hasNextLine()) {
            String userInput = scanner.nextLine();
            if (!userInput.trim().isEmpty()) {
                processFile(userInput);
            }
        }
        scanner.close();
    }
}
