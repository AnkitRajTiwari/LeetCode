class Solution {
    public int numberOfSubstrings(String s) {
        // Array to keep count of 'a', 'b', and 'c' in current window
        int[] count = new int[3];
        
        // Left pointer for sliding window start
        int left = 0;
        
        // Variable to store total valid substrings count
        int result = 0;
        
        // Right pointer to expand the window through the string
        for (int right = 0; right < s.length(); right++)
         {
            // Increment count of current character at index right
            count[s.charAt(right) - 'a']++;
            
            // While window contains at least one of each 'a', 'b', and 'c'
            while (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                // Add all substrings starting at 'left' and ending at or after 'right'
                result += s.length() - right;
                
                // Shrink window from left by decrementing count of character at 'left'
                count[s.charAt(left) - 'a']--;
                
                // Move left pointer forward to try smaller windows
                left++;
            }
        }
        
        // Return total count of substrings containing all three characters
        return result;
    }
}
