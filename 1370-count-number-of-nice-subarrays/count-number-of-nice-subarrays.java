class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        //// same Sliding window +two pointers + exactly k 
        /// k, k-1 techniques
        int subarray= atMost(nums,k)- atMost(nums,k-1);
        return subarray;
    }

    public int atMost(int[] nums, int k)
    {

        if(k<0) return 0;
        int start=0;
        int count=0;
        int answer=0;
        for(int end=0; end<nums.length; end++)
        {
            /// check
            if(nums[end] %2 != 0)
            {
                count++;
            }
            /// else shrink
            while(count>k) {
                if(nums[start] %2 !=0)
                {
                count--;
                }
             start++;
            }
         answer= answer+ end-start+1;
        }
        return answer ;
    }
}