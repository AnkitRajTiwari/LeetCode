class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        int row = 0;
        int col = 0;

        int[] res = new int[n*m];
        boolean upward = true;

        for(int i=0; i<m*n; i++){
            res[i] = mat[row][col];
            if(upward){
                if(col == m-1){
                    row++;
                    upward = false;
                }
                else if(row == 0){
                    col++;
                    upward = false;
                }
                else{
                    row--;
                    col++;
                }
            }
            else{
                if(row == n-1){
                    col++;
                    upward = true;
                }
                else if(col == 0){
                    row++;
                    upward = true;
                }
                else{
                    row++;
                    col--;
                }
            }
        }
        return res;
    }
}