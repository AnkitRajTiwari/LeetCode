class Solution {
    public List<List<Integer>> permute(int[] nums) 
    {
        List<Integer>smallList=new ArrayList<>();
        List<List<Integer>> bigList=new ArrayList<>();
        helper(nums,smallList,bigList);
        return bigList;
    }
    public void helper(int [] nums , List<Integer> smallList , List<List<Integer>> bigList )
    {
        // base case 
        if(smallList.size()==nums.length)
        { 

            // to add the permutation so that while bactracking there is no empty list at the 
            bigList.add(new ArrayList<Integer>(smallList));
            return;
        }
        for(int i=0;i<nums.length;i++)
       {
          if(!smallList.contains(nums[i]))
          {
            smallList.add(nums[i]);
            helper(nums,smallList,bigList);  
            // backtrACKING TO REMOVE 3 then 2 then 1 and then open the next branch 
            smallList.remove(smallList.size()-1);
          }
       }   
    }
}