class Solution {
    public int[][] rangeAddQueries(int n, int[][] Q) {
        int[][] res = new int[n][n];
        for (var q : Q) {
            int r0 = q[0], c0 = q[1], r1 = q[2]+1, c1 = q[3]+1;
            for (int i = r0; i < r1; i++) for (int j = c0; j < c1; j++)
              res[i][j]++;
        }
        return res;
    }
}