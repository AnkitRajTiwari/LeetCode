class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        // maximum sum then use the slidig window or hashet or two pointer 
        HashSet<Integer> res=new HashSet<>();
        int left=0;
        int right=0;
        int maxsum=0;
        int currsum=0;
        while(right<nums.length)
        {
            while(res.contains(nums[right])){
                res.remove(nums[left]);
                currsum-=nums[left];
                left++;
            }
            res.add(nums[right]);
            currsum+=nums[right];
            maxsum=Math.max(maxsum,currsum);
            right++;
        }
           return maxsum;
    }
}