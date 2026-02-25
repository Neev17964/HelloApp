import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

class UC7_PalindromeCheckerApp {

    public static void main(String[] args) {
        System.out.println("--- UC7: Deque-Based Optimized Palindrome Checker ---");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Text: ");
        String word = scanner.nextLine();

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < word.length(); i++) {
            deque.offerLast(word.charAt(i));
        }

        boolean isPalindrome = true;

        while (deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input Text          : " + word);
        System.out.println("Is it a Palindrome? : " + isPalindrome);

        scanner.close();
    }
}