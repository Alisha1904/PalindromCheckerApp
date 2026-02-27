
public class PalindromeCheckerApp {

    /**
     * Application entry point for UC2.
     * @param args Command-line arguments
     */
    public static void main(String[] args) {
        // Hardcoded string literal
        String input = "madam";
        boolean isPalindrome = true;

        // Hint: Loop only till half of the string length
        for (int i = 0; i < input.length() / 2; i++) {
            // Compare character at current index with its mirror index at the end
            if (input.charAt(i) != input.charAt(input.length() - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        // Print the result to the console
        System.out.println("Input text: " + input);
        System.out.println("Is it a Palindrome? : " + isPalindrome);
    }
}