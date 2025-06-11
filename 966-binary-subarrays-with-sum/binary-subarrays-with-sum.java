class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
       int count = 0;
       int currSum = 0;

       for(int i = 0;i<nums.length;i++){
         currSum = 0;
        for(int j = i;j<nums.length;j++){
            currSum+=nums[j];
            count+= currSum == goal?1:0;
        }
       }

       return count;
    }
}