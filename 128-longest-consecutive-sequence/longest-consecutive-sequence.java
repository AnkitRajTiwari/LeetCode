class Solution {
    public int longestConsecutive(int[] nums) {
        /// here we will use the hashset becuse we have to find each numer exisit or not 
        int max=0;
        // add lelemt to set\
        Set<Integer> set=new HashSet<>();
        for(int i=0;i<nums.length;i++)
        {
            set.add(nums[i]);
        }

        //// split into left and right 

        for(int i=0; i<nums.length;i++)
        {
            int count=1;
            int num=nums[i]; ///// left see
            while(set.contains(--num))
            {
                count++;
                set.remove(num);

            }

            ///// right see reset 
            num=nums[i];
            while(set.contains(++num)){
                count++;
                set.remove(num);
            }
          max=Math.max(max, count);
        }
        return max;
    }
}