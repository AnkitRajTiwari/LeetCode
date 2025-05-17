class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        long count = 0, result = 0;
        int left = 0;

        for (int right = 0; right < nums.length; right++) {
            int val = nums[right];
            int currentFreq = freq.getOrDefault(val, 0);
            count += currentFreq;
            freq.put(val, currentFreq + 1);

            while (count >= k) {
                result += nums.length - right; 
                int leftVal = nums[left];
                int leftFreq = freq.get(leftVal);
                freq.put(leftVal, leftFreq - 1);
                count -= leftFreq - 1;
                left++;
            }
        }

        return result;
    }
}