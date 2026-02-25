import java.util.Scanner;

class UC10_PalindromeCheckerApp {

    public static void main(String[] args) {
        System.out.println("--- UC10: Case-Insensitive & Space-Ignored Palindrome ---");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Text: ");
        String word = scanner.nextLine();

        String normalized = word.toLowerCase().replaceAll("[^a-z0-9]", "");
        String normalizedReversed = new StringBuilder(normalized).reverse().toString();
        boolean isPalindrome = normalized.equals(normalizedReversed);

        System.out.println("Input Text          : " + word);
        System.out.println("Normalized Text     : " + normalized);
        System.out.println("Is it a Palindrome? : " + isPalindrome);

        scanner.close();
    }
}