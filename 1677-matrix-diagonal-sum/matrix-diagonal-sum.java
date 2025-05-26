class Solution {
    public int diagonalSum(int[][] mat) {
        int sum = 0;
        int n = mat.length;
        int i =0, j=0;
        int l =n-1;
        while(i<n){
            sum+=mat[i][j];
            sum+=mat[i][l];
            i++;
            j++;
            l--;
        }
        if (n == 1) return mat[0][0];
        if (n%2 != 0)return sum - mat[n/2][n/2];
        else return sum;
    }
}