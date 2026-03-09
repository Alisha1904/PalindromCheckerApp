import java.util.Scanner;
import java.util.Stack;

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        if (input == null) return false;

        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c); // Uses LIFO behavior to reverse characters
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) { // Compare with original sequence
                return false;
            }
        }
        return true;
    }
}

public class PalindromeCheckerAPP {
    private PalindromeStrategy strategy;

    public PalindromeCheckerAPP(PalindromeStrategy strategy) {
        this.strategy = strategy; // Injects the strategy at runtime
    }

    public boolean validate(String input) {
        return strategy.check(input); // Executes the selected algorithm
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input : ");
        String input = scanner.nextLine();

        // Injecting StackStrategy at runtime
        PalindromeCheckerAPP app = new PalindromeCheckerAPP(new StackStrategy());
        System.out.println("Is Palindrome? : " + app.validate(input));
        scanner.close();
    }
}