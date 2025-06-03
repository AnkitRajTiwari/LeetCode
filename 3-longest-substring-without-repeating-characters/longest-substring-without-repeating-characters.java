

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // Set to store unique characters in the current window
        Set<Character> set = new HashSet<>();
        
        int maxLength = 0; // To store the final result
        int left = 0;      // Left boundary of the sliding window

        // Right boundary of the window moves through the string
        for (int right = 0; right < s.length(); right++) {
            char currentChar = s.charAt(right);

            // If character is already in the set, shrink window from the left
            while (set.contains(currentChar)) {
                set.remove(s.charAt(left));
                left++;
            }

            // Add the current character to the window
            set.add(currentChar);

            // Update maxLength if this window is larger
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}
