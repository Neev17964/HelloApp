import java.util.Scanner;
import java.util.Stack;

class UC5_PalindromeCheckerApp {

    public static void main(String[] args) {
        System.out.println("--- UC5: Stack-Based Palindrome Checker ---");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Text: ");
        String word = scanner.nextLine();

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        String stackReversed = "";
        while (!stack.isEmpty()) {
            stackReversed = stackReversed + stack.pop();
        }

        boolean isPalindrome = word.equals(stackReversed);

        System.out.println("Input Text          : " + word);
        System.out.println("Reversed Text       : " + stackReversed);
        System.out.println("Is it a Palindrome? : " + isPalindrome);

        scanner.close();
    }
}