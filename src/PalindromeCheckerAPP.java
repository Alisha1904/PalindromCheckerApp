import java.util.Scanner;

public class PalindromeCheckerAPP {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input : ");
        String input = scanner.nextLine();

        PalindromeService service = new PalindromeService();
        boolean isPalindrome = service.checkPalindrome(input);

        System.out.println("Is Palindrome? : " + isPalindrome);
        scanner.close();
    }
}

class PalindromeService {

    public boolean checkPalindrome(String input) {
        if (input == null) return false;

        int start = 0;
        int end = input.length() - 1;

        while (start < end) {
            if (input.charAt(start) != input.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}