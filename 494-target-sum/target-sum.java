class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        //
        return helper(nums,target,0,0);
    }

    // step 1 to make the helper function
    public int helper(int[] nums,int target,int currentsum,int index)
    {
        // base case when we have reached the end of the nums 
        if(index==nums.length)
        {  // when we have reached the end check  that whether the current sum is equal to the 
            // target
            if(currentsum==target)
            {
                return 1;
            }
            else return 0; 
        }
         
         // now calculate that whether to add or subtract 
         // 1. if we want to add];
         // recursive fucntion
         int add=helper(nums,target,currentsum+nums[index],index+1);
         // 2.subtract
         int subtract=helper(nums,target,currentsum-nums[index],index+1);
         return add+subtract;
    } 

}