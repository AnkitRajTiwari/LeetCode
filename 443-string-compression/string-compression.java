class Solution {
    public int compress(char[] chars) {
        
        // Get the total number of characters in the array
        int n = chars.length;

        // `idx` is the index where we will write compressed characters
        int idx = 0;

        // Iterate over the characters using index `i`
        for (int i = 0; i < n; i++) {

            // Store the current character
            char ch = chars[i];

            // Initialize count to track how many times the current character repeats
            int count = 0;

            // Count the number of repeating characters starting at position i
            while (i < n && chars[i] == ch) {
                count++; // increment repetition count
                i++;     // move to next character
            }

            // Write the character once
            chars[idx++] = ch;

            // If the character repeats more than once, write its count
            if (count > 1) {

                // Convert count (e.g., 12) into string → char array: ['1','2']
                char[] digits = Integer.toString(count).toCharArray();

                // Traditional for loop to insert each digit
                for (int j = 0; j < digits.length; j++) {
                    chars[idx++] = digits[j];  // write each digit of the count
                }
            }

            // Decrement `i` because the outer `for` loop will increment it again
            i--;
        }

        // Return the length of the compressed array
        return idx;
    }
}
