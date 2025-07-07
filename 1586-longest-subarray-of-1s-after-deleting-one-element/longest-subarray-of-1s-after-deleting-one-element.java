class Solution {
    public int longestSubarray(int[] nums) {
        int left=0;
        int max=0;
        int lastzero=-1;
        for(int right=0;right<nums.length;right++){
            if(nums[right]==0){
                left=lastzero+1;
                lastzero=right;
            }
            max=Math.max(max,right-left);
        }
        return max;
    }
}