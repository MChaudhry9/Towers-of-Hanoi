package test1;

import java.util.Scanner;
import java.util.Stack;

public class Start_test {

    //constant strings (the names of the towers)
    private static final String START_TOWER = "A";
    private static final String END_TOWER = "C";
    private static final String MIDDLE_TOWER = "B";

    //main method 
    public static void main(String[] args) {
        initializeTowersOfHanoi();
    }

    //method to initialize the Towers of Hanoi puzzle
    public static void initializeTowersOfHanoi() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of disks: ");
        int numDisks = scanner.nextInt();

        //adding disks to tower
        Stack<Integer>[] towers = new Stack[3];
        for (int i = 0; i < 3; i++) {
            towers[i] = new Stack<>();
        }

        for (int i = numDisks; i > 0; i--) {
            towers[0].push(i);
        }

        //display disks/towers
        displayTowers(towers, numDisks);

        while (!towers[2].equals(createCompleteTower(numDisks))) {
            System.out.print("Enter your move (top disk from tower # to tower #): ");
            int from = scanner.nextInt() - 1;
            int to = scanner.nextInt() - 1;

            //validating and performing
            if (isValidMove(towers, from, to)) {
                towers[to].push(towers[from].pop());
                displayTowers(towers, numDisks);
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        System.out.println("Congratulations! You solved the Towers of Hanoi puzzle.");

        scanner.close();
    }

    //method to display the state of the towers
    public static void displayTowers(Stack<Integer>[] towers, int numDisks) {
        System.out.println("Towers state:");
        for (int i = 0; i < towers.length; i++) {
            System.out.print("Tower " + (i + 1) + ": ");
            for (Integer disk : towers[i]) {
                System.out.print(diskRepresentation(disk, numDisks) + " ");
            }
            System.out.println();
        }
    }

    //method to display disk size
    public static String diskRepresentation(int diskSize, int numDisks) {
        int width = numDisks + diskSize;
        return "*".repeat(diskSize) + " ".repeat(numDisks - diskSize);
    }

    //input validation method
    public static boolean isValidMove(Stack<Integer>[] towers, int from, int to) {
        if (from < 0 || from >= towers.length || to < 0 || to >= towers.length) {
            return false;//tower index doesnt exist
        }
        if (towers[from].isEmpty()) {
            return false;//there are no disks
        }
        if (!towers[to].isEmpty() && towers[to].peek() < towers[from].peek()) {
            return false; //cant place a bigger disk on a smaller one
        }
        return true;
    }

    //this method creates a complete tower (the answer) and compares with users 
    //current tower to check win condition
    public static Stack<Integer> createCompleteTower(int numDisks) {
        Stack<Integer> completeTower = new Stack<>();
        for (int i = numDisks; i > 0; i--) {
            completeTower.push(i);
        }
        return completeTower;
    }
}

