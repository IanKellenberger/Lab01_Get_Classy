import java.util.Scanner;

public class SafeInputObj {
    private Scanner pipe;

    // Default constructor
    public SafeInputObj() {
        this.pipe = new Scanner(System.in);
    }

    // Constructor with custom Scanner
    public SafeInputObj(Scanner scanner) {
        this.pipe = scanner;
    }

    public String getNonZeroLenString(String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    public int getInt(String prompt) {
        int retInt = 0;
        boolean isValid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine(); // Consume newline left-over
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.nextLine(); // Consume invalid input
            }
        } while (!isValid);
        return retInt;
    }

    public double getDouble(String prompt) {
        double retDouble = 0.0;
        boolean isValid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                pipe.nextLine(); // Consume newline left-over
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter a number.");
                pipe.nextLine(); // Consume invalid input
            }
        } while (!isValid);
        return retDouble;
    }

    public int getRangedInt(String prompt, int low, int high) {
        int retInt = 0;
        boolean isValid = false;
        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextInt()) {
                retInt = pipe.nextInt();
                pipe.nextLine(); // Consume newline left-over
                if (retInt >= low && retInt <= high) {
                    isValid = true;
                } else {
                    System.out.println("Input out of range. Please enter a number between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter an integer.");
                pipe.nextLine(); // Consume invalid input
            }
        } while (!isValid);
        return retInt;
    }

    public double getRangedDouble(String prompt, double low, double high) {
        double retDouble = 0.0;
        boolean isValid = false;
        do {
            System.out.print("\n" + prompt + " [" + low + " - " + high + "]: ");
            if (pipe.hasNextDouble()) {
                retDouble = pipe.nextDouble();
                pipe.nextLine(); // Consume newline left-over
                if (retDouble >= low && retDouble <= high) {
                    isValid = true;
                } else {
                    System.out.println("Input out of range. Please enter a number between " + low + " and " + high + ".");
                }
            } else {
                System.out.println("Invalid input. Please enter a number.");
                pipe.nextLine(); // Consume invalid input
            }
        } while (!isValid);
        return retDouble;
    }

    public boolean getYNConfirm(String prompt) {
        boolean isValid = false;
        boolean response = false;
        do {
            System.out.print("\n" + prompt + " [Y/N]: ");
            String input = pipe.nextLine().trim().toUpperCase();
            if (input.equals("Y") || input.equals("N")) {
                response = input.equals("Y");
                isValid = true;
            } else {
                System.out.println("Invalid input. Please enter Y or N.");
            }
        } while (!isValid);
        return response;
    }

    public String getRegExString(String prompt, String regEx) {
        String retString = "";
        boolean isValid = false;
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
            if (retString.matches(regEx)) {
                isValid = true;
            } else {
                System.out.println("Invalid input. Please follow the pattern: " + regEx);
            }
        } while (!isValid);
        return retString;
    }
}
