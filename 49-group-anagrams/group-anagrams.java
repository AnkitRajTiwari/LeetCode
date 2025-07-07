// Define the class Solution
class Solution {

    // Method to group anagrams together from a list of strings
    public List<List<String>> groupAnagrams(String[] strs) {

        // Create a HashMap where:
        // - The key is the sorted version of the word (e.g., "aet" for "eat", "tea", "ate")
        // - The value is a list of words (original strings) that are anagrams of that key
        Map<String, List<String>> map = new HashMap<>();

        // Loop through each string in the input array
        for (String word : strs) {

            // Convert the current word into a character array
            char[] chars = word.toCharArray();

            // Sort the character array alphabetically
            Arrays.sort(chars);

            // Convert the sorted char array back to a string (this acts as a unique key for anagrams)
            String sortedWord = new String(chars);

            // If this sorted key is not already in the map, add it with a new empty list
            if (!map.containsKey(sortedWord)) {
                map.put(sortedWord, new ArrayList<>());
            }

            // Add the original word to the list corresponding to the sorted key
            map.get(sortedWord).add(word);
        }

        // Return all the values (lists of grouped anagrams) as a new ArrayList
        return new ArrayList<>(map.values());
    }
}
