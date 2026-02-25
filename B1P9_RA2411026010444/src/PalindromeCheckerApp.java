import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;

class UC6_PalindromeCheckerApp {

    public static void main(String[] args) {
        System.out.println("--- UC6: Queue + Stack Based Palindrome Check ---");

        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Text: ");
        String word = scanner.nextLine();

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            queue.offer(word.charAt(i));
            stack.push(word.charAt(i));
        }

        boolean isPalindrome = true;

        while (!queue.isEmpty() && !stack.isEmpty()) {
            if (queue.poll() != stack.pop()) {
                isPalindrome = false;
                break;
            }
        }

        System.out.println("Input Text          : " + word);
        System.out.println("Is it a Palindrome? : " + isPalindrome);

        scanner.close();
    }
}