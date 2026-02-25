import java.util.Scanner;

class UC3_PalindromeCheckerApp {

    public static void main(String[] args) {
        System.out.println("--- UC3: Palindrome Check Using String Reverse ---");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Text: ");
        String word = scanner.nextLine();

        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }

        boolean isPalindrome = word.equals(reversed);

        System.out.println("Input Text          : " + word);
        System.out.println("Reversed Text       : " + reversed);
        System.out.println("Is it a Palindrome? : " + isPalindrome);

        scanner.close();
    }
}