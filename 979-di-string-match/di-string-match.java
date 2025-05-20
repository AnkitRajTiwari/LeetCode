class Solution {
    public static int[] diStringMatch(String s) {
        
        int n = s.length();
        int ans[] =  new int[n + 1];
        
        int iCount = 0;
        int dCount = n;
        
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == 'I') {
                ans[i] = iCount++;
            } else {
                ans[i] = dCount--;
            }
        }
        
        ans[n] = iCount; 
        
        return ans;
    }
}