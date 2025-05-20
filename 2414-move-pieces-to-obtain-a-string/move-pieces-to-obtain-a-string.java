class Solution {

    // Method to check if we can transform 'start' string into 'target' string
    public boolean canChange(String start, String target) {

        // Counters to keep track of unmatched 'L' and 'R' movements
        int left = 0, right = 0;

        // Iterate over every character in both strings
        for (int i = 0; i < start.length(); i++) {

            // If the current character in 'start' is 'R'
            if (start.charAt(i) == 'R') {
                right++;  // We have an 'R' that needs to move right

                // Invalid if there's an unmatched 'L' (since 'L' can't go past 'R')
                if (left != 0) 
                    return false;
            }

            // If the current character in 'start' is 'L'
            else if (start.charAt(i) == 'L') {
                left--;  // One 'L' is moving left, so decrease the counter
            }

            // If the current character in 'target' is 'R'
            if (target.charAt(i) == 'R') {
                right--;  // One 'R' has reached its destination, decrease right
            }

            // If the current character in 'target' is 'L'
            else if (target.charAt(i) == 'L') {
                left++;  // We expect an 'L' to reach this place

                // Invalid if any 'R' is still pending to move (can't cross 'L')
                if (right != 0)
                    return false;
            }

            // If at any point the count of unmatched 'L' or 'R' becomes negative,
            // it means we're trying to move a piece that doesn't exist
            if (left < 0 || right < 0)
                return false;
        }

        // At the end, all movements must be balanced (no unmatched moves left)
        return left == 0 && right == 0;
    }
}
