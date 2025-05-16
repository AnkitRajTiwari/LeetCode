class Solution {
    public int removeElement(int[] nums, int val) {
     int k=0;
     for(int i=0;i<nums.length;i++)
     {
        if(nums[i]!=val) // checks if the current value is equal to the val if it is not equal 
        {                // to it means that we have find the unique element a
            nums[k]=nums[i]; //  and then add it to the k and return the k
            k++;
        }
     }   
     return k;
    }
}