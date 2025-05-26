class Solution {
    public int maximumWealth(int[][] accounts) {
        //return the max of sum of rows.
        
        int max_sum=0,sum=0;
        for(int[] i:accounts)
        {
            sum=0;
            for(int j:i)
            {
                sum=sum+j;
            }
            if(sum>max_sum)
            max_sum=sum;
        }
        return max_sum;

    }
}