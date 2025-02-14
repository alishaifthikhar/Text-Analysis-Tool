import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Step 1: User Input
        System.out.println("Please enter a paragraph or a lengthy text:");
        String text = scanner.nextLine();
        
        if (text.trim().isEmpty()) {
            System.out.println("The input is empty. Please enter some text.");
            return;
        }
        
        // Step 2: Character Count
        int totalCharacters = text.length();
        System.out.println("\nTotal number of characters: " + totalCharacters);
        
        // Step 3: Word Count
        String[] words = text.split("\\s+"); // Split based on one or more spaces
        int totalWords = words.length;
        System.out.println("Total number of words: " + totalWords);
        
        // Step 4: Most Common Character (Ignoring spaces and case-insensitive)
        Map<Character, Integer> charFrequency = new HashMap<>();
        for (char ch : text.toCharArray()) {
            if (Character.isLetterOrDigit(ch)) {  // Considering only alphanumeric characters
                ch = Character.toLowerCase(ch);
                charFrequency.put(ch, charFrequency.getOrDefault(ch, 0) + 1);
            }
        }
        
        char mostCommonChar = Collections.max(charFrequency.entrySet(), Map.Entry.comparingByValue()).getKey();
        System.out.println("Most common character: " + mostCommonChar);
        
        // Step 5: Character Frequency (Case-insensitive)
        System.out.println("\nEnter a character to check its frequency:");
        char userChar = scanner.next().toLowerCase().charAt(0);
        
        if (!Character.isLetterOrDigit(userChar)) {
            System.out.println("Please enter a valid alphanumeric character.");
            return;
        }
        
        int charCount = 0;
        for (char ch : text.toLowerCase().toCharArray()) {
            if (ch == userChar) {
                charCount++;
            }
        }
        System.out.println("The character '" + userChar + "' appears " + charCount + " times in the text.");
        
        // Step 6: Word Frequency (Case-insensitive)
        scanner.nextLine();  // Consume leftover newline
        System.out.println("Enter a word to check its frequency:");
        String userWord = scanner.nextLine().toLowerCase();
        
        int wordCount = 0;
        for (String word : words) {
            if (word.equalsIgnoreCase(userWord)) {
                wordCount++;
            }
        }
        System.out.println("The word '" + userWord + "' appears " + wordCount + " times in the text.");
        
        // Step 7: Unique Words (Case-insensitive)
        Set<String> uniqueWords = new HashSet<>();
        for (String word : words) {
            uniqueWords.add(word.toLowerCase());
        }
        System.out.println("Number of unique words: " + uniqueWords.size());
        
        scanner.close();
    }
}
