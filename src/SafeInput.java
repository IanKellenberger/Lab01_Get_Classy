import java.util.Scanner;

public class SafeInput {

    /**
     * Prompts the user for input and ensures that the input is not empty.
     *
     * @param pipe  the Scanner object to read input
     * @param prompt the prompt message to display
     * @return the non-empty input string
     */
    public static String getNonZeroLenString(Scanner pipe, String prompt) {
        String retString = "";
        do {
            System.out.print("\n" + prompt + ": ");
            retString = pipe.nextLine();
        } while (retString.length() == 0);
        return retString;
    }

    /**
     * Prompts the user for an integer and ensures valid input.
     *
     * @param pipe  the Scanner object to read input
     * @param prompt the prompt message to display
     * @return the integer value entered by the user
     */
    public static int getInt(Scanner pipe, String prompt) {
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

    /**
     * Prompts the user for a double and ensures valid input.
     *
     * @param pipe  the Scanner object to read input
     * @param prompt the prompt message to display
     * @return the double value entered by the user
     */
    public static double getDouble(Scanner pipe, String prompt) {
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

    /**
     * Prompts the user for an integer within a specified range.
     *
     * @param pipe  the Scanner object to read input
     * @param prompt the prompt message to display
     * @param low the lower bound (inclusive) of the range
     * @param high the upper bound (inclusive) of the range
     * @return the integer value entered by the user within the specified range
     */
    public static int getRangedInt(Scanner pipe, String prompt, int low, int high) {
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

    /**
     * Prompts the user for a double within a specified range.
     *
     * @param pipe  the Scanner object to read input
     * @param prompt the prompt message to display
     * @param low the lower bound (inclusive) of the range
     * @param high the upper bound (inclusive) of the range
     * @return the double value entered by the user within the specified range
     */
    public static double getRangedDouble(Scanner pipe, String prompt, double low, double high) {
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

    /**
     * Prompts the user for a yes/no confirmation.
     *
     * @param pipe  the Scanner object to read input
     * @param prompt the prompt message to display
     * @return true if the user confirms with 'Y', false if 'N'
     */
    public static boolean getYNConfirm(Scanner pipe, String prompt) {
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

    /**
     * Prompts the user for input and ensures it matches a specified regular expression.
     *
     * @param pipe  the Scanner object to read input
     * @param prompt the prompt message to display
     * @param regEx the regular expression pattern the input must match
     * @return the input string that matches the regular expression
     */
    public static String getRegExString(Scanner pipe, String prompt, String regEx) {
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

    /**
     * Prints a formatted header with stars around it.
     *
     * @param msg the message to display in the header
     */
    public static void prettyHeader(String msg) {
        int totalLength = 60;
        int msgLength = msg.length();

        // Calculate spaces on each side of the message to center it
        int spacesNeeded = totalLength - 6 - msgLength; // 6 stars and 2 spaces around the message

        // Print top row of stars
        for (int i = 0; i < totalLength; i++) {
            System.out.print("*");
        }
        System.out.println(); // Move to next line

        // Print centered message with stars and spaces
        System.out.print("***");
        for (int i = 0; i < spacesNeeded / 2; i++) {
            System.out.print(" ");
        }
        System.out.print(msg); // Print the message
        for (int i = 0; i < spacesNeeded / 2; i++) {
            System.out.print(" ");
        }
        // Adjust for odd number of spaces if necessary
        if (spacesNeeded % 2 != 0) {
            System.out.print(" ");
        }
        System.out.println("***");

        // Print bottom row of stars
        for (int i = 0; i < totalLength; i++) {
            System.out.print("*");
        }
        System.out.println(); // Move to next line
    }
}
