class Solution {
    public long maxSum(int[][] grid, int[] limits, int k) {
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<grid.length;i++)
        {
            List<Integer>ls=new ArrayList<>();
            for(int j=0;j<grid[0].length;j++)
            {
                ls.add(grid[i][j]);
            }
            Collections.sort(ls);
            Collections.reverse(ls);
            for(int j=0;j<limits[i];j++)
            {
                list.add(ls.get(j));
            }
        }
         Collections.sort(list);
         Collections.reverse(list);
         long sum=0;
         for(int i=0;i<k;i++)
         {
            sum=sum+list.get(i);
         }
         return sum;
    }
}