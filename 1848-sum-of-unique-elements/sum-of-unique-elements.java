class Solution {
    public int sumOfUnique(int[] nums) {
        // Create a frequency array to count how many times each number appears
        int[] arr = new int[101]; // Since 0 <= nums[i] <= 100 as per common constraints

        // Step 1: Count frequencies using normal for loop
        for (int i = 0; i < nums.length; i++) {
            arr[nums[i]]++;  // Increment the count for the value nums[i]
        }

        int sum = 0; // To store the final sum of unique elements

        // Step 2: Check for uniqueness and calculate sum
        for (int i = 0; i < nums.length; i++) {
            if (arr[nums[i]] == 1) {  // If this number occurred only once
                sum += nums[i];       // Add it to the result
            }
        }

        return sum; // Return the final sum
    }
}


