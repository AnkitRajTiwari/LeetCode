class Solution {

    // Method to compute the integer part of the square root of x
    public int mySqrt(int x) {

        // Edge case: if x is 0, the square root is 0
        if (x == 0) {
            return 0;
        }

        // Initialize the binary search range from 1 to x
        int first = 1, last = x;

        // Perform binary search
        while (first <= last) {

            // Calculate the middle of the current search range
            int mid = first + (last - first) / 2;

            // Check if mid * mid is exactly equal to x
            // Note: mid * mid may cause overflow, so we use mid == x / mid
            if (mid == x / mid) {
                return mid;  // mid is the exact square root
            }

            // If mid * mid > x, then mid is too large
            else if (mid > x / mid) {
                last = mid - 1;  // shrink the search space to the left half
            }

            // If mid * mid < x, then mid is too small
            else {
                first = mid + 1;  // move to the right half
            }
        }

        // At the end of loop, 'last' will be the integer part of sqrt(x)
        return last;
    }
}
