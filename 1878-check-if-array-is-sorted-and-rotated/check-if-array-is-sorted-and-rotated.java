class Solution {
    public boolean check(int[] nums) {
        // since the array is soerted and we have to find the possiton so use them mod]
        int n=nums.length;
        int count =0;
        for(int i=0;i<n;i++){
            if(nums[i]>nums[(i+1)%n]){
                count++;
            }
        }
        return count<=1;
    }
}