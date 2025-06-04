class Solution {
    int[][][] dp;

    public int maxProfit(int[] prices) {
        int count = 2;
        dp = new int[prices.length][count + 1][2];

        // Initialize dp array to -1
        for (int i = 0; i < prices.length; i++) {
            for (int c = 0; c <= count; c++) {
                for (int cb = 0; cb < 2; cb++) {
                    dp[i][c][cb] = -1;
                }
            }
        }

        return solve(prices, 0, count, 1); // Start from day 0, 2 transactions, and can buy
    }

    int solve(int[] p, int i, int count, int canBuy) {
        if (i >= p.length) return 0;

        if (dp[i][count][canBuy] != -1) return dp[i][count][canBuy];

        if (count > 0 && canBuy == 1) {
            // Try buying or skipping
            int buy = -p[i] + solve(p, i + 1, count - 1, 0);
            int notBuy = solve(p, i + 1, count, 1);
            return dp[i][count][canBuy] = Math.max(buy, notBuy);
        } else if (canBuy == 0) {
            // Try selling or holding
            int sell = p[i] + solve(p, i + 1, count, 1);
            int hold = solve(p, i + 1, count, 0);
            return dp[i][count][canBuy] = Math.max(sell, hold);
        } else {
            return dp[i][count][canBuy] = 0;
        }
    }
}