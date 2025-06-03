class Solution {
    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;

        for (int num : nums) {
            // Add bits to 'twos' that are already in 'ones' and now appear again in num
            twos |= ones & num;

            // XOR current number with 'ones'
            ones ^= num;

            // Calculate the common bits in both 'ones' and 'twos' (i.e., bits that appeared 3 times)
            int threes = ones & twos;

            // Remove common bits (threes) from both ones and twos
            ones &= ~threes;
            twos &= ~threes;
        }

        return ones;
    }
}