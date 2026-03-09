import java.util.Scanner;

class Node {
    char data;
    Node next;

    Node(char data) {
        this.data = data;
        this.next = null;
    }
}

public class PalindromeCheckerAPP {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input: ");
        String input = scanner.nextLine();

        if (isPalindrome(input)) {
            System.out.println("Is Palindrome? : true");
        } else {
            System.out.println("Is Palindrome? : false");
        }

        scanner.close();
    }

    public static boolean isPalindrome(String str) {
        if (str == null || str.isEmpty())
            return true;

        // Create linked list from string
        Node head = new Node(str.charAt(0));
        Node current = head;

        for (int i = 1; i < str.length(); i++) {
            current.next = new Node(str.charAt(i));
            current = current.next;
        }

        // Find middle using slow & fast pointer
        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse second half
        Node secondHalfHead = reverseList(slow);
        Node firstHalfHead = head;

        // Compare both halves
        Node tempSecond = secondHalfHead;
        while (tempSecond != null) {
            if (firstHalfHead.data != tempSecond.data) {
                return false;
            }
            firstHalfHead = firstHalfHead.next;
            tempSecond = tempSecond.next;
        }

        return true;
    }

    // Reverse linked list
    private static Node reverseList(Node head) {
        Node prev = null;
        Node current = head;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        return prev;
    }
}