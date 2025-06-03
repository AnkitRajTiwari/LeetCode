// Define a class named 'Solution'
class Solution {

    // Method that returns the number of subarrays with product less than k
    public int numSubarrayProductLessThanK(int[] nums, int k) {

        // If k is less than or equal to 1, there can be no product of positive numbers less than k
        // Because the smallest product of any positive number is at least 1
        // Hence, return 0 immediately in such cases
        if (k <= 1) return 0;

        // Initialize two pointers: left and right to represent the sliding window
        // 'product' holds the product of the elements in the current window
        // 'count' will store the total number of valid subarrays found
        int left = 0, right = 0, product = 1, count = 0;

        // Store the length of the input array for easy access
        int n = nums.length;

        // Start traversing the array using the right pointer
        while (right < n) {

            // Multiply the current element to the product to include it in the current window
            product *= nums[right];

            // If the product becomes equal to or greater than k,
            // then we need to shrink the window from the left side
            // until the product becomes less than k again
            while (product >= k) {
                // Divide the product by nums[left] to remove the leftmost element from the window
                product /= nums[left];
                // Move the left pointer one step to the right
                left++;
            }

            // At this point, the product of the subarray from left to right is less than k
            // The number of valid subarrays ending at 'right' and starting anywhere between 'left' and 'right'
            // is equal to (right - left + 1)
            // (right - left) gives number of indices between left and right
            // So we add (right - left + 1) to count. This is same as 1 + (right - left)
            count += 1 + (right - left);

            // Move the right pointer one step to the right to explore the next element
            right++;
        }

        // Return the total count of valid subarrays found
        return count;
    }
}
