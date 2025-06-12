class Solution {
    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        if(nums.length==1)return nums[0];
        if(nums[0]!=nums[1])return nums[0];
        for(int i=1;i<nums.length-2;i++)
        {
            if(nums[i]!=nums[i-1]&& nums[i]!=nums[i+1])
            {
                return nums[i];
            }
        }
        return nums[nums.length-1];
    }
}

 // another approach 
  //  class Solution {
  //  public int singleNumber(int[] arr) {
  //  int ones = 0, twos = 0;
  //  for (int i : arr) {
  //      ones = (ones ^ i) & ~twos; // ones ^ i, XOR i with current ones., If the bit is  /
                                                      // already in ones, this will remove it 
  //      twos = (twos ^ i) & ~ones; // 
  //  }
  //  return ones;
