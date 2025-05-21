class Solution {
    public int[] answerQueries(int[] nums, int[] queries) {
        int n=nums.length;
        int q=queries.length;
        int[] res=new int[q];
        Arrays.sort(nums);

        for(int i=1;i<n;i++)
        {
            nums[i]=nums[i]+nums[i-1];
        }
        for(int i=0;i<q;i++)
        {
            int left=0,right=nums.length-1;
            while(left<=right)
            {
                int mid=(left+right)/2;
                if(nums[mid]>queries[i])
                {
                    right=mid-1;
                }
                else
                {
                    left=mid+1;
                }
            }
            res[i]=left;
        }
        return res;
    }
}