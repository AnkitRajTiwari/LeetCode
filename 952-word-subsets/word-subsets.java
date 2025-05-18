class Solution 
{
    public List<String> wordSubsets(String[] words1, String[] words2) 
    {
        // This array stores the maximum frequency needed for each letter
        int[] maxFreq = new int[26];

        // Build the max frequency requirements from words2
        for (String b : words2) {
            int[] bFreq = countChars(b);
            for (int i = 0; i < 26; i++) {
                maxFreq[i] = Math.max(maxFreq[i], bFreq[i]);
            }
        }

        List<String> result = new ArrayList<>();

        // Now check each word in words1
        for (String a : words1) {
            int[] aFreq = countChars(a);
            boolean isUniversal = true;

            // Check if 'a' contains enough of every required character
            for (int i = 0; i < 26; i++)
             {
                if (aFreq[i] < maxFreq[i])
                {
                    isUniversal = false;
                    break;
                }
            }

            if (isUniversal)
            {
                result.add(a);
            }
        }

        return result;
    }

    private static int[] countChars(String word) {
        int[] count = new int[26]; // 26 letters in the alphabet
        for (char c : word.toCharArray()) {
            count[c - 'a']++;
        }
        return count;
    }

    
}