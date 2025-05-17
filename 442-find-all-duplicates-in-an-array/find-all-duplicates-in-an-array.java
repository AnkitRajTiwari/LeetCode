class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        // Create a HashSet to keep track of numbers we've already seen
        HashSet<Integer> seen = new HashSet<>();

        // Create a list to store the result (duplicate elements)
        List<Integer> result = new ArrayList<>();

        // Loop through each number in the input array
        for (int num : nums) {
            // If the number has already been seen, it's a duplicate
            if (seen.contains(num)) {
                // Add it to the result list
                result.add(num);
            } else {
                // Otherwise, mark it as seen by adding to the set
                seen.add(num);
            }
        }

        // Return the list of duplicates
        return result;
    }
}