class Solution {
    public int longestSubarray(int[] nums) {
         //// variable size sliding window + two pointers for count 
         int start=0;
         int answer=0;
         int count=0;
         for(int end=0; end< nums.length; end++)
         {
            /// window size
            if(nums[end]==0)
            {
                count++;
            }
            /// shrink for more thn zero
            while(count > 1)
            {
                if(nums[start]== 0)
                {
                    count--;
                }
                start++;
            }
            answer=Math.max(answer, end-start);
         }
         return answer;
    }
}