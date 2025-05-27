class Solution {
    public int findSubstringInWraproundString(String s) {
        int[] arr = new int[26];
        arr[s.charAt(0)-'a'] = 1;

        int count = 1;
        for(int i = 1; i < s.length(); i++) {
            if((s.charAt(i) - s.charAt(i-1) == 1) || (s.charAt(i) == 'a' && s.charAt(i-1) == 'z')) count++;
            else count = 1;

            arr[s.charAt(i)-'a'] = Math.max(count, arr[s.charAt(i)-'a']);
        }

        int ans = 0;
        for(int val : arr) {
            ans += val;
        }

        return ans;
    }
}

