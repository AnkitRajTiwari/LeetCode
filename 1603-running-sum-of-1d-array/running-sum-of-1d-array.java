class Solution {
    public int[] runningSum(int[] nums) {
        // running sum form 0 to 1
        // since we have to return an array
        int[] output=new int[nums.length];
        if(nums.length==0){
            return output;
        }
        // store the first at output 0
        output[0]=nums[0];
        for(int i=1;i<nums.length;i++){
            output[i]=output[i-1]+nums[i];
        }
        return output;
    }
}