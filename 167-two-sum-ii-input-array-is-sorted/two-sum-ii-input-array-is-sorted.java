class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0; // Start pointer
        int right = numbers.length - 1; // End pointer

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // Add 1 to convert to 1-based indexing
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++; // Increase sum by moving left pointer to the right
            } else {
                right--; // Decrease sum by moving right pointer to the left
            }
        }

        return new int[]{}; // No solution (though problem guarantees one)
    }
}
    
