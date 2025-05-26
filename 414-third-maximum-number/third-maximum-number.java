class Solution {
    public int thirdMax(int[] nums) {
        Arrays.sort(nums); // Sort the array in ascending order
        int tm = nums[nums.length - 1]; // Start with the maximum value
        int ans = tm; // Store max in case 3rd max doesn't exist
        int j = 0; // Counter for distinct max numbers found

        // Traverse from second last element to start
        for (int i = nums.length - 2; i >= 0; i--) {
            if (j < 3 && nums[i] < tm) { // If a new distinct number is found
                tm = nums[i];
                j++;
                if (j == 2) return tm; // Return 3rd distinct max
            }
        }

        return ans; // Return max if 3rd max doesn't exist
    }
}