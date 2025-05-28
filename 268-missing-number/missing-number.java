class Solution {
    public int missingNumber(int[] nums) {
       
		int n  = nums.length;
		int esum = n*(n+1)/2;
		int asum = 0;
		for(int i= 0;i<nums.length;i++){
		    asum+=nums[i];
		}
        return Math.abs(esum-asum);
    }
}