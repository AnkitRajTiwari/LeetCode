class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
        // it is an 2d array question 
        int n=grid.length;
        int totalelement=n*n; // firist we store all element from grid 1 to n ex= [[1,3],[2,2]]  total ement=size=2*2=4

        int [] count=new int[totalelement+1]; // store all element in this
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                count[grid[i][j]]++;
            }
        }

        int repeated=-1;
        int missing=-1;

        for(int i=0;i<=totalelement;i++)
        {
            if(count[i]==2)
            {
                repeated=i;
            }
            if(count[i]==0)
            {
                missing=i;
            }
        }
        return new int[]{repeated,missing};
    }
}