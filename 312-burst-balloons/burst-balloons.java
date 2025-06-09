import java.util.ArrayList;

class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        for (int i = 0; i < n; i++) {
            list.add(nums[i]);
        }
        list.add(1);

        int[][] dp = new int[n + 2][n + 2];

        for (int len = 1; len <= n; len++) {
            for (int i = 1; i <= n - len + 1; i++) {
                int j = i + len - 1;
                for (int k = i; k <= j; k++) {
                    int coins = list.get(i - 1) * list.get(k) * list.get(j + 1);
                    coins += (i <= k - 1) ? dp[i][k - 1] : 0;
                    coins += (k + 1 <= j) ? dp[k + 1][j] : 0;
                    dp[i][j] = Math.max(dp[i][j], coins);
                }
            }
        }
        return dp[1][n];
    }
}