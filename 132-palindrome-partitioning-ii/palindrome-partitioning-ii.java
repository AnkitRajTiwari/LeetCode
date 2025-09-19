class Solution {
   
    public int minCut(String s) {
        int n = s.length();
        int[][] isPalindrome = new int[n][n];
        for(int i=0; i<n; i++){
            Arrays.fill(isPalindrome[i], -1);
            isPalindrome[i][i] = 1;
        }
        for(int l=2; l<=n; l++){
            for(int i=0; i<n-l+1; i++){
                int j = i+l-1;
                if(s.charAt(i) == s.charAt(j)){
                    if(l == 2){
                        isPalindrome[i][j] = 1;
                    }else{
                        isPalindrome[i][j] = isPalindrome[i+1][j-1];
                    }
                }
            }
        }
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        dp[n] = 0;

        for(int i=n-1; i>=0; i--){
            int cuts = Integer.MAX_VALUE;
            for(int j=i; j<n; j++){
                if(isPalindrome[i][j] == 1){
                    cuts = Math.min(cuts, dp[j+1]);
                }
            }
            dp[i] = cuts+1;
        }

        return dp[0]-1;
    }
}