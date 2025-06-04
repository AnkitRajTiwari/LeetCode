class Solution {
    public int firstMissingPositive(int[] nums) {
        HashSet<Integer> hi = new HashSet<>();
        int i=1;
        for(int j=0;j<nums.length;j++){
            hi.add(nums[j]);
        }
        while(true){
            if(!hi.contains(i)){
                return i;
            }
            i++;
        }
        // return i;
    }
}