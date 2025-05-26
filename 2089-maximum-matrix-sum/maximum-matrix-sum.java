class Solution {
    public long maxMatrixSum(int[][] matrix) {
        long sum = 0; // Initialize the total sum (use long to avoid overflow!) \U0001f31f
        int negativeCount = 0; // Count of negative numbers \U0001f522
        int minAbs = Integer.MAX_VALUE; // Minimum absolute value we've seen so far \U0001f50d

        for (int i = 0; i < matrix.length; i++) { // Loop through rows ➡️
            for (int j = 0; j < matrix[i].length; j++) { // Loop through columns in each row ⬇️
                int num = matrix[i][j]; // Get the current number \U0001f3af
                sum += Math.abs((long) num); // Add the absolute value to the total sum ➕ (cast to long!)

                if (num < 0) {
                    negativeCount++; // Increment negative count if the number is negative \U0001f4c8
                }

                minAbs = Math.min(minAbs, Math.abs(num)); // Update the minimum absolute value \U0001f4c9
            }
        }

        if (negativeCount % 2 == 0) { // If the number of negative numbers is even... \U0001f914
            return sum; // ...we're already at the maximum sum! \U0001f389
        } else { // Otherwise (odd number of negative numbers)... \U0001f641
            return sum - 2 * minAbs; // ...we need to flip two of the smallest absolute value numbers to make the count even \U0001f504
        }
    }
}