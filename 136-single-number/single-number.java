class Solution {
    public int singleNumber(int[] nums) {
        int result=0;
        for(int num:nums)
        {
            result=result^num; // XOR each number if  duplicate then subtracts and if new then 
            //add 
        }
        return result;
    }
}
// 