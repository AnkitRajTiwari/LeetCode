class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int runningSum = 0, ans = 0;
        for (int n : nums) {
            runningSum += n;            
            int rem = runningSum % k;   
            if (rem < 0) {
                rem += k;     
            }          
            ans += map.getOrDefault(rem, 0);
            map.put(rem , 1 + map.getOrDefault(rem, 0));
        }

        return ans;     
    }
}