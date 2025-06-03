// Define the Solution class
class Solution {

    // Function to count the number of good pairs
    public int numIdenticalPairs(int[] nums) {

        // Create a HashMap to store frequency of each number encountered so far
        Map<Integer, Integer> pairs = new HashMap<>();

        // Initialize a counter to store the total number of good pairs
        int count = 0;

        // Loop through each element in the array
        for (int i = 0; i < nums.length; i++) {

            // Check if this number has been seen before
            if (pairs.containsKey(nums[i])) {
                // If yes, then there are 'pairs.get(nums[i])' good pairs that can be formed with this number
                count += pairs.get(nums[i]);
            }

            // Update the frequency of this number in the map
            // If the number is already in the map, increment its count by 1
            // If it's not in the map, set its count to 1
            pairs.put(nums[i], pairs.getOrDefault(nums[i], 0) + 1);
        }

        // After the loop, return the total count of good pairs
        return count;
    }
}
