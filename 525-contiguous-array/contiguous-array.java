class Solution {
    public int findMaxLength(int[] nums) {
        // Create a HashMap to store the first occurrence of each count
        // Key: the current count (difference between 1s and 0s)
        // Value: the earliest index at which this count occurred
        HashMap<Integer, Integer> map = new HashMap<>();

        // Initialize count to track the difference between 1s and 0s
        int count = 0;

        // This variable will store the maximum length of the balanced subarray found so far
        int ans = 0;

        // Insert count = 0 at index -1
        // This handles the case when the subarray starts from index 0
        map.put(0, -1);

        // Loop through each element in the array
        for (int i = 0; i < nums.length; i++) {

            // If current number is 1, increment count
            if (nums[i] == 1) {
                count++;
            } 
            // If current number is 0, decrement count
            else {
                count--;
            }

            // If this count has been seen before, it means the subarray between
            // previous index and current index has equal 0s and 1s
            if (map.containsKey(count)) {
                // Calculate the length of the balanced subarray
                int length = i - map.get(count);
                // Update the maximum length found so far
                ans = Math.max(ans, length);
            } 
            // If this count is seen for the first time, store its index
            else {
                map.put(count, i);
            }
        }

        // Return the maximum length of subarray with equal 0s and 1s
        return ans;
    }
}
