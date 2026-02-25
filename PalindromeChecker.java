import java.util.Scanner;
import java.util.Stack;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Deque;
import java.util.ArrayDeque;

// UC12: Strategy Pattern - Interface
interface PalindromeStrategy {
    boolean check(String word);
    String getStrategyName();
}

// UC12: Stack Strategy Implementation
class StackStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String word) {
        String normalized = word.toLowerCase().replaceAll("[^a-z0-9]", "");
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < normalized.length(); i++) {
            stack.push(normalized.charAt(i));
        }

        String stackReversed = "";
        while (!stack.isEmpty()) {
            stackReversed = stackReversed + stack.pop();
        }

        return normalized.equals(stackReversed);
    }

    @Override
    public String getStrategyName() {
        return "Stack Strategy";
    }
}

// UC12: Deque Strategy Implementation
class DequeStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String word) {
        String normalized = word.toLowerCase().replaceAll("[^a-z0-9]", "");
        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < normalized.length(); i++) {
            deque.offerLast(normalized.charAt(i));
        }

        while (deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                return false;
            }
        }

        return true;
    }

    @Override
    public String getStrategyName() {
        return "Deque Strategy";
    }
}

// UC12: Recursive Strategy Implementation
class RecursiveStrategy implements PalindromeStrategy {

    private boolean isPalindrome(String word, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (word.charAt(start) != word.charAt(end)) {
            return false;
        }
        return isPalindrome(word, start + 1, end - 1);
    }

    @Override
    public boolean check(String word) {
        String normalized = word.toLowerCase().replaceAll("[^a-z0-9]", "");
        return isPalindrome(normalized, 0, normalized.length() - 1);
    }

    @Override
    public String getStrategyName() {
        return "Recursive Strategy";
    }
}

// UC13: Two Pointer Strategy Implementation
class TwoPointerStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String word) {
        String normalized = word.toLowerCase().replaceAll("[^a-z0-9]", "");
        char[] chars = normalized.toCharArray();
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

    @Override
    public String getStrategyName() {
        return "Two Pointer Strategy";
    }
}

// UC13: StringBuilder Strategy Implementation
class StringBuilderStrategy implements PalindromeStrategy {

    @Override
    public boolean check(String word) {
        String normalized = word.toLowerCase().replaceAll("[^a-z0-9]", "");
        return normalized.equals(new StringBuilder(normalized).reverse().toString());
    }

    @Override
    public String getStrategyName() {
        return "StringBuilder Strategy";
    }
}

// UC12: Strategy Context Class
class PalindromeContext {

    private PalindromeStrategy strategy;

    public PalindromeContext(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public void setStrategy(PalindromeStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean executeStrategy(String word) {
        return strategy.check(word);
    }

    public String getStrategyName() {
        return strategy.getStrategyName();
    }
}

// UC11: Encapsulated PalindromeChecker Service Class
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

public class PalindromeCheckerApp {

    // UC8: Node class for Singly Linked List
    static class Node {
        char data;
        Node next;

        Node(char data) {
            this.data = data;
            this.next = null;
        }
    }

    // UC9: Recursive Palindrome Check Method
    static boolean ispalindrome(String word, int start, int end) {
        if (start >= end) {
            return true;
        }
        if (word.charAt(start) != word.charAt(end)) {
            return false;
        }
        return ispalindrome(word, start + 1, end - 1);
    }

    // UC13: Performance Measurement Helper
    static void measurePerformance(PalindromeStrategy strategy, String word) {
        long startTime = System.nanoTime();
        boolean result = strategy.check(word);
        long endTime = System.nanoTime();
        long duration = endTime - startTime;

        System.out.println("Strategy            : " + strategy.getStrategyName());
        System.out.println("Is it a Palindrome? : " + result);
        System.out.println("Execution Time      : " + duration + " ns");
        System.out.println();
    }

    public static void main(String[] args) {
        // UC1: Application Entry & Welcome Message
        System.out.println("--- UC1: Application Entry & Welcome Message ---");
        System.out.println("==============================");
        System.out.println("   Palindrome Checker App     ");
        System.out.println("   Version: 1.0.0             ");
        System.out.println("   System initialized successfully");
        System.out.println("==============================");
        System.out.println();

        // UC2: User Input Palindrome Check
        Scanner scanner = new Scanner(System.in);
        System.out.print("Input Text: ");
        String word = scanner.nextLine();
        System.out.println("--- UC2: Print a Hardcoded Palindrome Result ---");
        boolean isPalindrome = word.equals(new StringBuilder(word).reverse().toString());
        System.out.println("Is it a Palindrome? : " + isPalindrome);
        System.out.println();

        // UC3: Palindrome Check Using String Reverse with for loop
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed = reversed + word.charAt(i);
        }

        boolean isPalindromeUC3 = word.equals(reversed);

        System.out.println("--- UC3: Palindrome Check Using String Reverse ---");
        System.out.println("Input Text          : " + word);
        System.out.println("Reversed Text       : " + reversed);
        System.out.println("Is it a Palindrome? : " + isPalindromeUC3);
        System.out.println();

        // UC4: Character Array Based Palindrome Check
        System.out.println("--- UC4: Character Array Based Palindrome Check ---");

        char[] chars = word.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        boolean isPalindromeUC4 = true;

        while (start < end) {
            if (chars[start] != chars[end]) {
                isPalindromeUC4 = false;
                break;
            }
            start++;
            end--;
        }

        System.out.println("Input Text          : " + word);
        System.out.println("Is it a Palindrome? : " + isPalindromeUC4);
        System.out.println();

        // UC5: Stack-Based Palindrome Checker
        System.out.println("--- UC5: Stack-Based Palindrome Checker ---");

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            stack.push(word.charAt(i));
        }

        String stackReversed = "";
        while (!stack.isEmpty()) {
            stackReversed = stackReversed + stack.pop();
        }

        boolean isPalindromeUC5 = word.equals(stackReversed);

        System.out.println("Input Text          : " + word);
        System.out.println("Reversed Text       : " + stackReversed);
        System.out.println("Is it a Palindrome? : " + isPalindromeUC5);
        System.out.println();

        // UC6: Queue + Stack Based Palindrome Check
        System.out.println("--- UC6: Queue + Stack Based Palindrome Check ---");

        Queue<Character> queue = new LinkedList<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = 0; i < word.length(); i++) {
            queue.offer(word.charAt(i));
            stack2.push(word.charAt(i));
        }

        boolean isPalindromeUC6 = true;

        while (!queue.isEmpty() && !stack2.isEmpty()) {
            if (queue.poll() != stack2.pop()) {
                isPalindromeUC6 = false;
                break;
            }
        }

        System.out.println("Input Text          : " + word);
        System.out.println("Is it a Palindrome? : " + isPalindromeUC6);
        System.out.println();

        // UC7: Deque-Based Optimized Palindrome Checker
        System.out.println("--- UC7: Deque-Based Optimized Palindrome Checker ---");

        Deque<Character> deque = new ArrayDeque<>();

        for (int i = 0; i < word.length(); i++) {
            deque.offerLast(word.charAt(i));
        }

        boolean isPalindromeUC7 = true;

        while (deque.size() > 1) {
            if (deque.pollFirst() != deque.pollLast()) {
                isPalindromeUC7 = false;
                break;
            }
        }

        System.out.println("Input Text          : " + word);
        System.out.println("Is it a Palindrome? : " + isPalindromeUC7);
        System.out.println();

        // UC8: Linked List Based Palindrome Checker
        System.out.println("--- UC8: Linked List Based Palindrome Checker ---");

        Node head = null;
        Node tail = null;

        for (int i = 0; i < word.length(); i++) {
            Node newNode = new Node(word.charAt(i));
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node prev = null;
        Node current = slow;

        while (current != null) {
            Node nextNode = current.next;
            current.next = prev;
            prev = current;
            current = nextNode;
        }

        Node left = head;
        Node right = prev;
        boolean isPalindromeUC8 = true;

        while (right != null) {
            if (left.data != right.data) {
                isPalindromeUC8 = false;
                break;
            }
            left = left.next;
            right = right.next;
        }

        System.out.println("Input Text          : " + word);
        System.out.println("Is it a Palindrome? : " + isPalindromeUC8);
        System.out.println();

        // UC9: Recursive Palindrome Checker
        System.out.println("--- UC9: Recursive Palindrome Checker ---");

        boolean isPalindromeUC9 = ispalindrome(word, 0, word.length() - 1);

        System.out.println("Input Text          : " + word);
        System.out.println("Is it a Palindrome? : " + isPalindromeUC9);
        System.out.println();

        // UC10: Case-Insensitive & Space-Ignored Palindrome
        System.out.println("--- UC10: Case-Insensitive & Space-Ignored Palindrome ---");

        String normalized = word.toLowerCase().replaceAll("[^a-z0-9]", "");
        String normalizedReversed = new StringBuilder(normalized).reverse().toString();
        boolean isPalindromeUC10 = normalized.equals(normalizedReversed);

        System.out.println("Input Text          : " + word);
        System.out.println("Normalized Text     : " + normalized);
        System.out.println("Is it a Palindrome? : " + isPalindromeUC10);
        System.out.println();

        // UC11: Object-Oriented Palindrome Service
        System.out.println("--- UC11: Object-Oriented Palindrome Service ---");

        PalindromeChecker checker = new PalindromeChecker(word);
        boolean isPalindromeUC11 = checker.checkPalindrome();

        System.out.println("Input Text          : " + checker.getWord());
        System.out.println("Is it a Palindrome? : " + isPalindromeUC11);
        System.out.println();

        // UC12: Strategy Pattern for Palindrome Algorithms
        System.out.println("--- UC12: Strategy Pattern for Palindrome Algorithms ---");

        PalindromeContext context = new PalindromeContext(new StackStrategy());
        System.out.println("Strategy            : " + context.getStrategyName());
        System.out.println("Input Text          : " + word);
        System.out.println("Is it a Palindrome? : " + context.executeStrategy(word));
        System.out.println();

        context.setStrategy(new DequeStrategy());
        System.out.println("Strategy            : " + context.getStrategyName());
        System.out.println("Input Text          : " + word);
        System.out.println("Is it a Palindrome? : " + context.executeStrategy(word));
        System.out.println();

        context.setStrategy(new RecursiveStrategy());
        System.out.println("Strategy            : " + context.getStrategyName());
        System.out.println("Input Text          : " + word);
        System.out.println("Is it a Palindrome? : " + context.executeStrategy(word));
        System.out.println();

        // UC13: Performance Comparison
        System.out.println("--- UC13: Performance Comparison ---");
        System.out.println("Input Text          : " + word);
        System.out.println();

        measurePerformance(new StringBuilderStrategy(), word);
        measurePerformance(new TwoPointerStrategy(), word);
        measurePerformance(new StackStrategy(), word);
        measurePerformance(new DequeStrategy(), word);
        measurePerformance(new RecursiveStrategy(), word);

        scanner.close();
    }
}
