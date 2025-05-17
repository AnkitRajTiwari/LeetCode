class Solution {
    public boolean checkIfPangram(String sentence) {
        // Loop through all lowercase letters from 'a' to 'z'
        for (char c = 'a'; c <= 'z'; c++) {
            // Check if the current character c is NOT present in the sentence
            if (!sentence.contains(String.valueOf(c))) 
                return false;  // If any letter is missing, the sentence is not a pangram, so return false immediately
        }
        // If the loop completes without returning false, it means all letters were found
        return true;  // The sentence is a pangram
    }
}
