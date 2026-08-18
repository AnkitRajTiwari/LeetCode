class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        /////binary subarray with sum 
        /// sliding window + k 
        /// k=atmost(k)-atmost(k-1)
       return atMost(nums,goal) - atMost(nums,goal-1);
    }

    public int atMost(int [] nums, int goal)
    {
        if(goal<0) return 0;

        int start=0;
        int sum=0;
        int answer=0;
        for(int end=0; end<nums.length; end++)
        {
            // add
            sum=sum+nums[end];

            while(sum>goal)
            {
                sum=sum-nums[start];
                start++;
            }
            answer=answer+end-start+1;
        }
        return answer;
    }
}