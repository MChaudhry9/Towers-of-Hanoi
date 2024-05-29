package test1;
import java.util.Scanner;

public class TowersOfHanoi {

    // Define the names of the towers
    private static final String START_TOWER = "A";
    private static final String END_TOWER = "C";
    private static final String MIDDLE_TOWER = "B";

    // Method to initialize the Towers of Hanoi puzzle
    public static void initializeTowersOfHanoi() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of disks
        System.out.print("Enter the number of disks: ");
        int numDisks = scanner.nextInt();

        // Close the scanner
        scanner.close();

        // Solve the Towers of Hanoi problem
        towersOfHanoi(numDisks, START_TOWER, END_TOWER, MIDDLE_TOWER);
    }

    // Recursive method to solve Towers of Hanoi problem
    public static void towersOfHanoi(int numDisks, String start, String end, String middle) {
        if (numDisks == 1) {
            // Base case: if only one disk, move it directly from start to end
            System.out.println("Move disk 1 from tower " + start + " to tower " + end);
        } else {
            // Move numDisks-1 disks from start to middle
            towersOfHanoi(numDisks - 1, start, middle, end);
            
            // Move the remaining disk from start to end
            System.out.println("Move disk " + numDisks + " from tower " + start + " to tower " + end);
            
            // Move numDisks-1 disks from middle to end
            towersOfHanoi(numDisks - 1, middle, end, start);
        }
    }

    public static void main(String[] args) {
        // Initialize the Towers of Hanoi puzzle
        initializeTowersOfHanoi();

        Scanner scanner = new Scanner(System.in);
        String move;

        // Loop to allow the user to make moves
        while (true) {
            // Prompt the user for the next move
            System.out.print("Enter your next move (e.g., '1A2'): ");
            move = scanner.nextLine();

            // Check if the user wants to quit
            if (move.equalsIgnoreCase("quit")) {
                System.out.println("Exiting the program.");
                break;
            }

            // Validate and process the move
            if (isValidMove(move)) {
                System.out.println("Move " + move + " is valid.");
                // Implement logic to process the move
                // For now, just print the move
            } else {
                System.out.println("Invalid move. Please try again.");
            }
        }

        scanner.close();
    }

    // Method to validate the user's move
    public static boolean isValidMove(String move) {
        // Implement logic to validate the move
        // For simplicity, assume all moves are valid for now
        return true;
    }
}

