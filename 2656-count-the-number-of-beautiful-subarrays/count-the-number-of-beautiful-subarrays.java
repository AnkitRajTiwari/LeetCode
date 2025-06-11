class Solution {
    public long beautifulSubarrays(int[] nums) {
        int n = nums.length;
        
       
        int sum = 0;
        long count = 0;
        // We will store the frequency of prefix xor
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0 , 1);
        
        for(int i = 0; i < n ;i++){
            // prefix xor
            sum ^= nums[i];
            if(freq.containsKey(sum)){ 

            //here we are checking that whether the same prefix xor
            // occured or not, if yes then we increase the count to
            // the freq 

                count += freq.get(sum);
                
            }
            freq.put(sum , freq.getOrDefault(sum , 0) + 1);
        }
        
       
       return count;
        
    }
}