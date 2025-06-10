class Solution {
    public int minIncrementForUnique(int[] nums) {
       // first sort the array 
       Arrays.sort(nums);
       int numtracker=0; // the next unique number that should be set 
       int minincrement=0;
       for(int num:nums){
        numtracker=Math.max(numtracker,num);
        minincrement+=numtracker-num;
        numtracker+=1;
        }
        return minincrement;
    }
}