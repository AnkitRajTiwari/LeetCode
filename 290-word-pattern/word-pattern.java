class Solution {
    public boolean wordPattern(String pattern, String s) {
        // Create a HashMap to store the mapping of pattern characters to words
        HashMap<Character, String> map = new HashMap<>();

        // Split the input string by spaces to get individual words
        String[] stArr2 = s.split(" ");

        // If the number of pattern characters and words doesn't match, return false
        if(pattern.length() != stArr2.length) {
            return false;
        }

        // Create two sets to store unique characters and unique words
        Set<Character> set1 = new HashSet<>();
        Set<String> set2 = new HashSet<>();

        // Add all unique characters from pattern into set1
        for(char ch : pattern.toCharArray()) {
            set1.add(ch);
        }

        // Add all unique words from the input string into set2
        for(String s1 : stArr2) {
            set2.add(s1);
        }

        // If the number of unique characters and unique words doesn't match, return false
        if(set1.size() != set2.size()) {
            return false;
        }

        // Iterate through the pattern and corresponding words
        for(int i = 0; i < pattern.length(); i++) {
            // If the current character is already mapped
            if(map.containsKey(pattern.charAt(i))) {
                // Check if the previously mapped word matches the current word
                if(!map.get(pattern.charAt(i)).equals(stArr2[i])) {
                    return false; // Mismatch found, return false
                }
            } else {
                // If the character is not mapped yet, add the mapping
                map.put(pattern.charAt(i), stArr2[i]);
            }
        }

        // If all checks pass, return true
        return true;
    }
}
