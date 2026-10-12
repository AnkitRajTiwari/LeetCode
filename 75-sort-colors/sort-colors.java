class Solution {
    public void sortColors(int[] nums) {
        ///// three pointers 
        int low=0;
        int mid=0;
        int high=nums.length-1;
        while(mid<=high)
        {
            //// if low and mid is same 
            if(nums[mid]==0)
            {
                int temp=nums[mid];
                nums[mid]=nums[low];
                nums[low]=temp;
                low++;
                mid++;
            }
            else if(nums[mid]==1)
            {
                mid++;
            }
            else
            {
                /// swap mid and high if mid is not zero means starting elemt 
                int temp=nums[mid];
                nums[mid]=nums[high];
                nums[high]=temp;
                high--;
            }
        }
    }
}