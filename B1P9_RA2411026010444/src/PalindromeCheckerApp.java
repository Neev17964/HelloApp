import java.util.Scanner;

class UC2_PalindromeCheckerApp {

    public static void main(String[] args) {
        System.out.println("--- UC2: Print a Hardcoded Palindrome Result ---");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Text: ");
        String word = scanner.nextLine();

        boolean isPalindrome = word.equals(new StringBuilder(word).reverse().toString());

        System.out.println("Input Text          : " + word);
        System.out.println("Is it a Palindrome? : " + isPalindrome);

        scanner.close();
    }
}


