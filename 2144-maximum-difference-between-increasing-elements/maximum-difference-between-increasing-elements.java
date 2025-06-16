class Solution {
    public int maximumDifference(int[] nums) {
        int minval=nums[0];
        int maxdiff=-1;
        for(int i=1;i<nums.length;i++){
            int num=nums[i];
            if(num>minval){
                maxdiff=Math.max(maxdiff,num-minval);
            }
            else{
                minval=num;
            }
        }
        return maxdiff;
    }
}