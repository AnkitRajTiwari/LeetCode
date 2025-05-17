class Solution {
    public long countGood(int[] nums, int k) {
         int n = nums.length;   // Total number of elements
        int i = 0, j = 0;      // Two pointers for the sliding window

        long result = 0;       // To store the final answer
        long pairs = 0;        // To store how many good pairs we have in the current window

        HashMap<Integer, Integer> map = new HashMap<>(); // Frequency map for counting elements

        while (j < n)
        {
            // Add number of times nums[j] has already appeared to the pairs
            // Because each previous occurrence of nums[j] will make a new pair with nums[j]
            pairs += map.getOrDefault(nums[j], 0);
            
            // Increase the frequency of nums[j]
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            // If we have enough pairs (i.e., pairs >= k), we try to move left pointer i to reduce the window size
            while (pairs >= k)
            {
                result += (n - j);  // All subarrays from i to end with this j are valid

                // Before moving i, reduce frequency and pair count
                map.put(nums[i], map.get(nums[i]) - 1);
                pairs -= map.get(nums[i]);  // Remove the pairs formed by nums[i] in this window
                i++;  // Shrink the window from left
            }

            j++; // Expand the window from right
        }

        return result;
    }
}