class Solution {
  public long maximumSubarraySum(int[] nums, int k) {
    long ans = Long.MIN_VALUE;
    long prefix = 0;
    Map<Integer, Long> hm = new HashMap<>();

    for (final int num : nums) {
    if(!hm.containsKey(num)||hm.get(num)>prefix){
        hm.put(num,prefix);
    }
    prefix+=num;
    if(hm.containsKey(num-k)){
        ans=Math.max(ans,prefix-hm.get(num-k));
    }
    if(hm.containsKey(num+k)){
        ans=Math.max(ans,prefix-hm.get(num+k));
    }
    }

    return ans == Long.MIN_VALUE ? 0 : ans;
  }
}