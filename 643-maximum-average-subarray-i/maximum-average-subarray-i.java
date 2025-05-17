class Solution { 
    public double findMaxAverage(int[] nums, int k) {
        int n = nums.length;
        int sum = 0;

        // Compute the sum of the first k elements
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }

        int maxsum = sum;

        // Slide the window from index k to n - 1
        for (int i = k; i < n; i++) {
            sum = sum - nums[i - k] + nums[i]; // Remove the first element of previous window, add new element
            maxsum = Math.max(maxsum, sum);
        }

        return (double) maxsum / k;
    }
}
