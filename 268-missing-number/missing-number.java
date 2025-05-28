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
// first calculate the total sum by n*(n+1)/2
// then loop and calculate the actual sum esum by esum+=nums[i]
// int missing=Math.abs(totalsum-esum)
// hence the diff between the total sum and the actual sum gives the missing number 