// Define a public class named Solution
class Solution {

    // Public method that returns the minimum length of string after removing matching prefixes and suffixes
    public int minimumLength(String s) {

        // Initialize two pointers: `l` from the beginning and `r` from the end of the string
        int l = 0, r = s.length() - 1;

        // Continue looping while left is less than right AND characters at both ends are equal
        while (l < r && s.charAt(l) == s.charAt(r)) {

            // Store the matching character
            char ch = s.charAt(l);

            // Move the left pointer forward as long as it points to the same character `ch`
            while (l <= r && s.charAt(l) == ch) {
                l++;
            }

            // Move the right pointer backward as long as it points to the same character `ch`
            while (l <= r && s.charAt(r) == ch) {
                r--;
            }
        }

        // ❗ Instead of returning `r - l + 1`, use a simple conditional return:
        // If `l > r`, it means the string was completely reduced, so return 0.
        // Otherwise, return the remaining length of the substring from `l` to `r`.
        if (l > r) {
            return 0;
        } else {
            return r - l + 1;
        }
    }
}
