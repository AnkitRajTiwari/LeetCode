class Solution {
    public int[] occurrencesOfElement(int[] nums, int[] queries, int x) {
        int l=nums.length;
        // since we have to give the output in array format so we have to used the arraylist 
        
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<l;i++)
        {
            if(x==nums[i])
            {
                list.add(i);
            }
        }
        l=queries.length;
        int ans[]=new int[l];
        for(int i=0;i<l;i++)
        {
            int val=queries[i];
            ans[i]=val>list.size() ? -1:list.get(val-1);
        }
        return ans;
    }
}