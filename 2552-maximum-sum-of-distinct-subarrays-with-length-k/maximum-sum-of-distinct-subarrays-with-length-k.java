class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
         // Initialize result variable to store the maximum sum

        long res = 0;

        // 'l' is the left pointer for the sliding window

        int l = 0;

        // 'total' keeps track of the sum of the current window

        long total = 0;

        // A HashSet to keep track of unique elements in the current window
        Set<Integer> uniques = new HashSet<>();

        // Traverse the array using the right pointer 'r'

        for (int r = 0; r < nums.length; r++)
         {

            // If the current number is already in the set, 
            // move the left pointer to remove duplicates
            while (uniques.contains(nums[r])) {
                total -= nums[l];               // Subtract the value at left pointer from 
                                                // total
                uniques.remove(nums[l++]);      // Remove that value from the set and increment left pointer
            }

            // Add current element to the set (it's now unique)
            uniques.add(nums[r]);

            // Add current element value to the window sum
            total += nums[r];

            // If the window size exceeds 'k', shrink it from the left
            if ((r - l + 1) > k) {
                total -= nums[l];              // Remove the leftmost element's value
                uniques.remove(nums[l++]);     // Remove the leftmost element from the set
            }

            // If the window size is exactly 'k', update the result
            if ((r - l + 1) == k) {
                res = Math.max(res, total);    // Store the max sum found so far
            }
        }

        // Return the result
        return res;
    }
}
  