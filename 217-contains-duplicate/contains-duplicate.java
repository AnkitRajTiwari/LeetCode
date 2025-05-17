class Solution {
    public boolean containsDuplicate(int[] nums) 
    {
        Arrays.sort(nums);
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1])
                return true;
        }
        return false;
    }
}


// Step 3: Iterate from i = 1 to i = 4
// i	nums[i]	nums[i-1]	Condition nums[i] == nums[i-1]?	Action
// 1	2	1	2 == 1? No	Continue loop
// 2	3	2	3 == 2? No	Continue loop
// 3	4	3	4 == 3? No	Continue loop
// 4	4	4	4 == 4? Yes	Return true (duplicate found)
