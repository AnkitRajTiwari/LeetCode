class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Base condition: if s1 is longer than s2, impossible to match
        if (s1.length() > s2.length()) return false;

        // Frequency arrays for characters in s1 and current window in s2
        int[] s1Freq = new int[26];
        int[] s2Freq = new int[26];

        // Fill frequency array for s1
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i) - 'a']++;
        }

        // Sliding window: compare each window of length s1.length()
        for (int i = s1.length(); i < s2.length(); i++) {
            // Check if current window matches the frequency of s1
            if (matches(s1Freq, s2Freq)) return true;

            // Slide window: remove leftmost char, add rightmost char
            s2Freq[s2.charAt(i) - 'a']++;
            s2Freq[s2.charAt(i - s1.length()) - 'a']--;
        }

        // Check for the last window
        return matches(s1Freq, s2Freq);
    }

    // Helper function to check if two frequency arrays are equal
    private boolean matches(int[] arr1, int[] arr2) {
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) return false;
        }
        return true;
    }
}
