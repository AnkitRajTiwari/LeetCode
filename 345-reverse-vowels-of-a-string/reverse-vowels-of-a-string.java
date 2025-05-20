// Define a public class named Solution
class Solution {

    // Define a public method named reverseVowels that returns a String and takes a String `s` as input
    public String reverseVowels(String s) {
        
        // Step 1: Convert the input string `s` into a character array for easy swapping
        char[] word = s.toCharArray(); 
        
        // Step 2: Initialize two pointers — one from the start and one from the end of the string
        int start = 0;
        int end = s.length() - 1;

        // Step 3: Define a string containing all vowels (both lowercase and uppercase)
        String vowels = "aeiouAEIOU";

        // Step 4: Use two-pointer technique to scan the string from both ends
        while (start < end) {
            
            // Step 4a: Move the `start` pointer forward until it points to a vowel
            while (start < end && vowels.indexOf(word[start]) == -1) {
                start++;
            }

            // Step 4b: Move the `end` pointer backward until it points to a vowel
            while (start < end && vowels.indexOf(word[end]) == -1) {
                end--;
            }

            // Step 5: Swap the vowels at the `start` and `end` pointers
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;

            // Step 6: Move both pointers towards the center
            start++;
            end--;
        }

        // Step 7: Convert the modified character array back to a string
        String answer = new String(word);

        // Step 8: Return the final string with vowels reversed
        return answer;
    }
}
