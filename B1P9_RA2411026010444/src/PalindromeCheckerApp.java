import java.util.Scanner;

class PalindromeChecker {

    private String word;

    public PalindromeChecker(String word) {
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public boolean checkPalindrome() {
        char[] chars = word.toLowerCase().replaceAll("[^a-z0-9]", "").toCharArray();
        int start = 0;
        int end = chars.length - 1;

        while (start < end) {
            if (chars[start] != chars[end]) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}

class UC11_PalindromeCheckerApp {

    public static void main(String[] args) {
        System.out.println("--- UC11: Object-Oriented Palindrome Service ---");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Text: ");
        String word = scanner.nextLine();

        PalindromeChecker checker = new PalindromeChecker(word);

        System.out.println("Input Text          : " + checker.getWord());
        System.out.println("Is it a Palindrome? : " + checker.checkPalindrome());

        scanner.close();
    }
}