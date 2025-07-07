class Solution {
    public int[] getSubarrayBeauty(int[] nums, int k, int x) {
        int[] freq = new int[101];
        int[] result = new int[nums.length - k +1];
        for(int i= 0 ;i<k ;i++) freq[nums[i]+50]++;
        int curr = k;
        while(curr <= nums.length){
            // System.out.println(Arrays.toString(freq));
            int pos =0;
            for(int i = 0 ;i <=50 ;i++){
                pos += freq[i];
                if(pos>=x){
                    result[curr-k] = i - 50;
                    break;
                }
            }
            freq[nums[curr-k] + 50]--;
            if(curr < nums.length)freq[nums[curr] + 50]++;
            curr++;
        }

        return result;
    }
}