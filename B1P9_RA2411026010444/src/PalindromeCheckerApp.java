import java.util.Scanner;

class UC9_PalindromeCheckerApp {

    static boolean isPalindrome(String word, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (word.charAt(start) != word.charAt(end)) {
            return false;
        }
        return isPalindrome(word, start + 1, end - 1);
    }

    public static void main(String[] args) {
        System.out.println("--- UC9: Recursive Palindrome Checker ---");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Text: ");
        String word = scanner.nextLine();

        boolean result = isPalindrome(word, 0, word.length() - 1);

        System.out.println("Input Text          : " + word);
        System.out.println("Is it a Palindrome? : " + result);

        scanner.close();
    }
}