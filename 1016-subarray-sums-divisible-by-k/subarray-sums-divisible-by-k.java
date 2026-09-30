class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        ////// hear we have to handle 0
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(0,1);
        int prefixsum=0;
        int counter=0;
        
        ///////////////// loop to add prefix 
        for(int i=0;i<nums.length;i++)
        {
            prefixsum=prefixsum + nums[i];

             ////// calculate the remainder

             int remainder=prefixsum % k;

             if(remainder<0)
             {
                remainder=remainder+k;
             } 

             //// if same remianider have encounter first 
             if(map.containsKey(remainder))
             {
                counter=counter+ map.get(remainder);
             }

             //// store and update the frequency 
             map.put(remainder, map.getOrDefault(remainder,0)+1);
        }
        return counter;
    }
}