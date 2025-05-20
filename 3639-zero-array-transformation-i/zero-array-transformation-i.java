class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
            int n = nums.length;
            int diff[] = new int[n+1];
            diff[0] = nums[0];
            for(int i = 1; i < n; i++)
                diff[i] = nums[i] - nums[i-1];
            diff[n] = 0;
            for(int i[]: queries)
            {
                diff[i[0]]--;
                diff[i[1]+1]++;
            }
            for(int i = 0; i < n; i++)
            {
                if(i != 0)
                    diff[i] += diff[i-1];
                if(diff[i] > 0)
                    return false;
            }
            return true;
    }
}
