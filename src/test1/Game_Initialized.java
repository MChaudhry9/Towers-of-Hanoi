package test1;

import java.util.*;

public class Game_Initialized {

    // Define the names of the towers
    private static final String START_TOWER = "A";
    private static final String END_TOWER = "C";
    private static final String MIDDLE_TOWER = "B";

    // Main method to start the game
    public static void main(String[] args) {
        // Initialize the Towers of Hanoi puzzle
        initializeTowersOfHanoi();
    }

    // Method to initialize the Towers of Hanoi puzzle
    public static void initializeTowersOfHanoi() {
        Scanner scanner = new Scanner(System.in);

        // Prompt the user to enter the number of disks
        System.out.print("Enter the number of disks: ");
        int numDisks = scanner.nextInt();

        // Initialize the towers with disks
        Stack<Integer>[] towers = new Stack[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Stack<>();
        }

        // Add disks to the start tower
        for (int i = numDisks; i > 0; i--) {
            towers[0].push(i);
        }

        // Display initial state
        displayTowers(towers);

        // Main game loop
        while (!towers[2].equals(createCompleteTower(numDisks))) {
            System.out.print("Enter your move (from and to, e.g., 1 3): ");
            int from = scanner.nextInt() - 1;
            int to = scanner.nextInt() - 1;

            // Validate and perform the move
            if (isValidMove(towers, from, to)) {
                towers[to].push(towers[from].pop());
                displayTowers(towers);
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        System.out.println("Congratulations! You solved the Towers of Hanoi puzzle.");

        scanner.close();
    }

    // Method to display the state of the towers
    public static void displayTowers(Stack<Integer>[] towers) {
        System.out.println("Towers state:");
        for (int i = 0; i < towers.length; i++) {
            System.out.println("Tower " + (i + 1) + ": " + towers[i]);
        }
    }

    // Method to validate if a move is valid
    public static boolean isValidMove(Stack<Integer>[] towers, int from, int to) {
        if (from < 0 || from >= towers.length || to < 0 || to >= towers.length) {
            return false; // Invalid tower index
        }
        if (towers[from].isEmpty()) {
            return false; // No disk to move
        }
        if (!towers[to].isEmpty() && towers[to].peek() < towers[from].peek()) {
            return false; // Cannot place a bigger disk on a smaller one
        }
        return true;
    }

    // Helper method to create a complete tower for checking win condition
    public static Stack<Integer> createCompleteTower(int numDisks) {
        Stack<Integer> completeTower = new Stack<>();
        for (int i = numDisks; i > 0; i--) {
            completeTower.push(i);
        }
        return completeTower;
    }
}
