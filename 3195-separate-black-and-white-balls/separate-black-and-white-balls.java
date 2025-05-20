// Define a class named Solution
class Solution {

    // Define a method named 'minimumSteps' which takes a string 's' and returns a long integer
    public long minimumSteps(String s) {

        // Initialize a variable to keep track of total swaps needed
        long swap = 0;

        // Initialize a counter for how many '1's (black tiles) we've seen so far
        int black = 0; 

        // Loop through each character of the string from left to right
        for (int i = 0; i < s.length(); i++) {

            // If the current character is '0' (white tile)
            if (s.charAt(i) == '0') {

                // To move this '0' left past all previous '1's, we need one swap per '1'
                // Add the number of '1's seen so far to the total swap count
                swap += (long) black;
            } else {
                // If the current character is '1', increase the count of 'black' tiles seen
                black++;
            }
        }

        // After checking all characters, return the total number of swaps
        return swap;
    }
}
 