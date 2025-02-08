
import java.io.*;
import java.util.*;

public class LongestCompoundWord {
    public static void main(String[] args) throws IOException {
        String fileName = "Input_02.txt";  //can Change file name 
        List<String> words = readWordsFromFile(fileName);
        
        long startTime = System.currentTimeMillis();
        String[] result = findLongestCompoundWords(words);
        long endTime = System.currentTimeMillis();
        
        System.out.println("Longest Compound Word: " + result[0]);
        System.out.println("Second Longest Compound Word: " + result[1]);
        System.out.println("Time taken to process file " + fileName + ": " + (endTime - startTime) + " milliseconds");
    }

    private static List<String> readWordsFromFile(String fileName) throws IOException {
        List<String> words = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                words.add(line.trim());
            }
        }
        return words;
    }

    private static String[] findLongestCompoundWords(List<String> words) {
        Set<String> wordSet = new HashSet<>(words);  // HashSet for O(1) lookups
        words.sort(Comparator.comparingInt(String::length).reversed());  // Sorting in decending 

        String longest = "", secondLongest = "";
        
        for (String word : words) {
            wordSet.remove(word);  // Remove current word before checking
            if (canFormWord(word, wordSet)) {
                if (word.length() > longest.length()) {
                    secondLongest = longest;
                    longest = word;
                } else if (word.length() > secondLongest.length()) {
                    secondLongest = word;
                }
            }
            wordSet.add(word);  // Add word back 
        }

        return new String[]{longest, secondLongest};
    }

    private static boolean canFormWord(String word, Set<String> wordSet) {
        int len = word.length();
        if (len == 0) return false;

        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(word.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }

        return dp[len];  // If last index is true,  compound word
    }
}
