class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;

        // Check all 32 bit positions
        for (int i = 0; i < 32; i++) {
            int sum = 0;

            // Count how many numbers have the i-th bit set
            for (int num : nums) {
                if ((num >> i & 1) == 1) {
                    sum++;
                }
            }

            // If bit count is not divisible by 3, that bit is set in the unique number
            if (sum % 3 != 0) {
                result |= (1 << i);
            }
        }

        return result;
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
