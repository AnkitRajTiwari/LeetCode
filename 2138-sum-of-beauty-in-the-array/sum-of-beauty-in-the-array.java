class Solution {
    public int sumOfBeauties(int[] nums) {
        int len = nums.length;
        boolean satisfied[] = new boolean[len];
        int leftmax = Integer.MIN_VALUE;
        int rightmin = Integer.MAX_VALUE;
        int ans = 0;
        
        for(int i=1;i<len-1;i++){
            // 1. Check if current element is the max element while going right 
            leftmax = Math.max(leftmax, nums[i-1]);
            if(nums[i]>leftmax)
                satisfied[i]=true;
        }
        for(int i=len-2;i>0;i--){
            // 2. Check if the current element is smallest while going left
            rightmin = Math.min(rightmin, nums[i+1]);
            // 3. Mark condition 1 (for 2 points) as satisfied iff satisfied[i] is true already
            if(nums[i]<rightmin)
                satisfied[i] = satisfied[i] && true;
            else
                satisfied[i] = false;
            // 4. if condition 1 is satisfied add 2 points else if condition 2 is satisfied add 1 point
                if(satisfied[i])
                    ans+=2;
                else if(nums[i-1]<nums[i] && nums[i]<nums[i+1])
                    ans+=1;
            
        }
        
        return ans;
    }
}