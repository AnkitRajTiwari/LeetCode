class Solution {
    int ans;
    public int minOperations(int[] nums, int x) {
        // Step 1: Calculate the total sum of the array
        int totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        // Step 2: Find the target subarray sum we need to keep
        int target = totalSum - x;

        // If target is negative, it's impossible to reach x
        if (target < 0) {
            return -1;
        }

        // Initialize pointers for sliding window
        int left = 0;
        int currentSum = 0;
        int maxLength = -1; // to track the length of longest valid subarray

        // Step 3: Use sliding window to find the longest subarray with sum = target
        for (int right = 0; right < nums.length; right++) {
            currentSum += nums[right];  // expand the window by adding nums[right]

            // Shrink the window from the left if the sum exceeds the target
            while (currentSum > target && left <= right) {
                currentSum -= nums[left];
                left++;
            }

            // Check if current window matches the target sum
            if (currentSum == target) {
                maxLength = Math.max(maxLength, right - left + 1);  // update max length
            }
        }

        // Step 4: If no valid subarray found, return -1
        // Otherwise, return the number of operations = total length - longest valid subarray
        return maxLength == -1 ? -1 : nums.length - maxLength;
    }
}