import java.util.Scanner;

class UC4_PalindromeCheckerApp {

    public static void main(String[] args) {
        System.out.println("--- UC4: Character Array Based Palindrome Check ---");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Text: ");
        String word = scanner.nextLine();

        char[] chars = word.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        boolean isPalindrome = true;

        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindrome = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("Input Text          : " + word);
        System.out.println("Is it a Palindrome? : " + isPalindrome);

        scanner.close();
    }
}