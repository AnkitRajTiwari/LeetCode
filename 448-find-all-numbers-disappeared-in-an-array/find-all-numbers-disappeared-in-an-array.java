class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
       Set<Integer> seen = new HashSet<>();

       for(int num: nums){
        seen.add(num);
       }
Arrays.sort(nums);
List<Integer> ans = new ArrayList<>();

       for(int i=0;i <nums.length; i++){
            if((i+1)!=nums[i] && !seen.contains(i+1)){
                ans.add(i+1);
            }
       }

       return ans;
    }
}