import java.util.Scanner;
import java.util.Stack;

interface PalindromeStrategy {
    boolean check(String input);
}

class StackStrategy implements PalindromeStrategy {
    @Override
    public boolean check(String input) {
        if (input == null) return false;

        Stack<Character> stack = new Stack<>();
        for (char c : input.toCharArray()) {
            stack.push(c);
        }

        for (char c : input.toCharArray()) {
            if (c != stack.pop()) {
                return false;
            }
        }
        return true;
    }
}

public class UseCase12PalindromeCheckerApp {
    private PalindromeStrategy strategy;

    public PalindromeCheckerAPP(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String input) {
        return strategy.check(input);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input : ");
        String input = scanner.nextLine();

        // Injecting StackStrategy at runtime
        UseCase12PalindromeCheckerApp app = new UseCase12PalindromeCheckerApp(new StackStrategy());

        System.out.println("Is Palindrome? : " + app.validate(input));
        scanner.close();
    }
}