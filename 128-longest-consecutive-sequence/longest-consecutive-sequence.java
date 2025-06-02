class Solution {
    public static int longestConsecutive(int[] nums) 
    {
        // If the input array is empty, there is no consecutive sequence
        if (nums.length == 0) return 0;

        // TreeSet stores unique elements in sorted order
        TreeSet<Integer> numbers = new TreeSet<>();

        // Add all elements from nums into the TreeSet to remove duplicates and sort them
        for (int i = 0; i < nums.length; i++) 
        {
            numbers.add(nums[i]);
        }

        // Variables to track the current chain value, current count of consecutive numbers,
        // and the maximum count found so far
        int chain = 0;
        int count = 0;
        int maxCount = 1; // Minimum consecutive sequence length is 1

        // Iterate through the sorted unique numbers
        for (int num : numbers)
         {
            // Check if current number is exactly 1 greater than previous number (consecutive)
            if (num == chain + 1) 
            {
                count++; // Increase count for consecutive sequence
                maxCount = Math.max(maxCount, count); // Update maxCount if current sequence  
                                                      // is longer
            } else
             {
                count = 1; // Reset count if not consecutive; start new sequence
            }
            chain = num; // Update chain to current number for next iteration comparison
        }

        // Return the length of the longest consecutive sequence found
        return maxCount;
    }
}






// Iteration	num	Check: num == chain + 1?	Action	Updated Variables
// 1	1	1 == 0 + 1 → true	count++ → 1	chain = 1, count = 1, maxCount = max(1,1)=1
// 2	2	2 == 1 + 1 → true	count++ → 2	chain = 2, count = 2, maxCount = max(1,2)=2
// 3	3	3 == 2 + 1 → true	count++ → 3	chain = 3, count = 3, maxCount = max(2,3)=3
// 4	4	4 == 3 + 1 → true	count++ → 4	chain = 4, count = 4, maxCount = max(3,4)=4
// 5	100	100 == 4 + 1 → false	count = 1	chain = 100, count = 1, maxCount = 4
// 6	200	200 == 100 + 1 → false	count = 1	chain = 200, count = 1, maxCount = 4

// Step 5: Return maxCount
// maxCount = 4 → longest consecutive sequence is length 4 (1,2,3,4)

// Summary Table
 // Step	num	chain before	Condition	count before	count after	maxCount before	// maxCount after	chain after
// 1	1	0	1 == 0 + 1 (true)	0	1	1	1	1
// 2	2	1	2 == 1 + 1 (true)	1	2	1	2	2
// 3	3	2	3 == 2 + 1 (true)	2	3	2	3	3
// 4	4	3	4 == 3 + 1 (true)	3	4	3	4	4
// 5	100	4	100 == 4 + 1 (false)	4	1	4	4	100
// 6	200	100	200 == 100 + 1(false)	1	1	4	4