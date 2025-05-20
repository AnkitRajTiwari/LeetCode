class Solution {
    public int[] leftRightDifference(int[] a) {
        int n = a.length;
        int[] ans = new int[n];
        int left = 0;
        int right = 0;
        for(int i = 0; i < n; i++) {
            ans[i] = Math.abs(ans[i] + left);
            ans[n - 1 - i] -= right;
            left += a[i];
            right += a[n - 1 - i];
        }
        for(int i = 0; i < n; i++) {
            if(ans[i] < 0) ans[i] *= -1;
        }
        return ans;
    }
}