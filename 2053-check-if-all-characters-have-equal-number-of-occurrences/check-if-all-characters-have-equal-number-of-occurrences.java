import java.util.*;

class Solution {
    public boolean areOccurrencesEqual(String s) {
        // Create an array to store frequency of each character (assuming only lowercase letters)
        int[] freq = new int[26]; // indices 0 to 25 correspond to 'a' to 'z'

        // Count the frequency of each character in the string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);         // Get character at index i
            int index = c - 'a';          // Map 'a' to 0, 'b' to 1, ..., 'z' to 25
            freq[index]++;                // Increment the frequency at that index
        }

        // Find the first non-zero frequency to use as reference
        int commonFreq = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                commonFreq = freq[i];     // Save the first non-zero frequency
                break;                    // Exit loop after finding the first one
            }
        }

        // Compare all other non-zero frequencies with the reference frequency
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0 && freq[i] != commonFreq) {
                return false;             // If any frequency doesn't match, return false
            }
        }

        // If all non-zero frequencies matched, return true
        return true;
    }
}
