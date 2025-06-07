public class Solution {
    public int rob(int[] nums) {
        // Base case: If there are no houses, return 0
        if (nums == null || nums.length == 0) {
            return 0;
        }

        // Base case: If there is only one house, rob it
        if (nums.length == 1) {
            return nums[0];
        }

        // Base case: If there are two houses, rob the one with more money
        if (nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        }

        // Create an array to store the maximum money we can rob up to each house
        int[] arr = new int[nums.length];

        // Rob the first house
        arr[0] = nums[0];

        // Decide to rob either the first or second house
        arr[1] = Math.max(nums[0], nums[1]);

        // Loop through the rest of the houses
        for (int i = 2; i < nums.length; i++) {
            // At each house, we have two choices:
            // 1. Don't rob this house → dp[i-1]
            // 2. Rob this house → nums[i] + dp[i-2]
            // We take the max of these two choices
            arr[i] = Math.max(arr[i - 1], nums[i] + arr[i - 2]);
        }

        // The last element of dp contains the answer
        return arr[nums.length - 1];
    }
}

  
