class Solution {
    public int totalFruit(int[] fruits) {
        int i = 0, j = 0, n = fruits.length;
        while (j < n && fruits[i] == fruits[j]) {
            j++;
        }
        if (j == n) return n;

        int l = i, r = j + 1, ans = 0;
        while (r < n) {
            if (fruits[r] != fruits[j]) {
                if (fruits[r] == fruits[i]) {
                    i = j;
                    j = r;
                } else {
                    ans = Math.max(ans, r - l);
                    i = j;
                    l = j;
                    j = r;
                }
            }
            r++;
        }
        ans = Math.max(ans, r - l);
        return ans;
    }
}