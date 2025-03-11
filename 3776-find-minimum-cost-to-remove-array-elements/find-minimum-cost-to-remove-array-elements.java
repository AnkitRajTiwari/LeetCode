class Solution {
    public int dp[][];
    public int rec(int nums[],int i,int pi,int n){
        if(i==n) return nums[pi];
        if(i==n-1) return Math.max(nums[i],nums[pi]);
        if(dp[i][pi]!=-1) return dp[i][pi];
        
        int a=Math.max(nums[i],nums[i+1])+rec(nums,i+2,pi,n);
        int b=Math.max(nums[pi],nums[i+1])+rec(nums,i+2,i,n);
        int c=Math.max(nums[pi],nums[i])+rec(nums,i+2,i+1,n);
        return dp[i][pi]=Math.min(a,Math.min(b,c));
    }
    public int minCost(int[] nums) {
        int n=nums.length;
        dp=new int[n][n];
        for(int i[]:dp) Arrays.fill(i,-1);
        return rec(nums,1,0,n);
    }
}