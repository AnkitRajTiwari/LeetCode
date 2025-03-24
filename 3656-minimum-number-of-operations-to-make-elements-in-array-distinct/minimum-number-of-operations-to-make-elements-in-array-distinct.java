class Solution {
    public int minimumOperations(int[] nums) {
        // 12342357
       int hashmap[]=new int [101];
       int lastindx=0;
       for(int i=nums.length-1;i>=0;i--)
       {
        if(hashmap[nums[i]] > 0) // frequncy og each elemtns
        {
            lastindx=i+1;
            break;
        }
        hashmap[nums[i]]++;
       } 

       if(lastindx%3==0)
       {
        return lastindx/3;
       }
       return lastindx/3+1;
    }
}