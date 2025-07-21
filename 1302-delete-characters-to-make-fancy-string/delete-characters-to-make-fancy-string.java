class Solution {
    public String makeFancyString(String s) {
        // Create a StringBuilder to build the result string
        StringBuilder ans = new StringBuilder();
        
        // Initialize a counter to track consecutive repeated characters
        int cnt = 1;

        // Traverse through each character in the input string
        for (int i = 0; i < s.length(); i++) {
            // If current character is same as previous one, increment the count
            if (i > 0 && s.charAt(i) == s.charAt(i - 1)) {
                cnt++;
            } else {
                // If different, reset count to 1
                cnt = 1;
            }

            // Only append character if it's not part of three or more repetitions
            if (cnt <= 2) {
                ans.append(s.charAt(i));
            }
        }

        // Convert the StringBuilder to String and return
        return ans.toString();
    }
}