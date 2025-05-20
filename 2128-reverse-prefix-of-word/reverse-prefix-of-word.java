class Solution {
    public String reversePrefix(String word, char ch) {
        
        // Step 1: Find the index of the first occurrence of the character `ch`
        int j = -1;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == ch) {
                j = i;
                break;
            }
        }

        // Step 2: If character not found, return the original word
        if (j == -1) return word;

        // Step 3: Create a StringBuilder with the prefix substring (from 0 to j inclusive)
        StringBuilder sb = new StringBuilder(word.substring(0, j + 1));

        // Step 4: Reverse the prefix in place
        sb.reverse();

        // Step 5: Append the rest of the original word (from index j+1 to the end)
        sb.append(word.substring(j + 1));

        // Step 6: Convert the StringBuilder to a string and return it
        return sb.toString();
    }
}
