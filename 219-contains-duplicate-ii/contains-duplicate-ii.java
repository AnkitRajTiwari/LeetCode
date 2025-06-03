class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // since here we will use the hashmap
       HashMap<Integer,Integer> map=new HashMap<>();
       // loop through  the array
       for(int i=0;i<nums.length;i++){
        // and then check  that map.contains nums and i -map.get(nums[i])
        if(map.containsKey(nums[i]) && i-map.get(nums[i])<=k ){
            return true ;
        }
        map.put(nums[i],i);
       } 
       return false;
    }
}