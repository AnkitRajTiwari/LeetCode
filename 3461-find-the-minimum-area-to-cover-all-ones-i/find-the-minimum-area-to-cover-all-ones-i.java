class Solution {
    public int minimumArea(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;     
        
        int minRow = Integer.MAX_VALUE;
        int maxRow = Integer.MIN_VALUE;
        int minCol = Integer.MAX_VALUE;     
        int maxCol = Integer.MIN_VALUE;

        // Traverse the grid to find the bounds of the rectangle containing all the 1's
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {       
                if (grid[i][j] == 1) {
                    minRow = Math.min(minRow, i);
                    maxRow = Math.max(maxRow, i);
                    minCol = Math.min(minCol, j);       
                    maxCol = Math.max(maxCol, j);
                }
            }
        }

        
        if (minRow == Integer.MAX_VALUE) {
            return 0;
        }           

        
        int height = maxRow - minRow + 1;
        int width = maxCol - minCol + 1;        
        
        return height * width;
    }
}