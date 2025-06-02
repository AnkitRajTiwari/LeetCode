class Solution {
    public boolean isSubsequence(String s, String t) {
        int left=0; // for the left pointer 
        int right=0; // for the right pointer 
        while(left<s.length() && right<t.length()){
            if(s.charAt(left) == t.charAt(right)){
                left++;
            }
            right++;
        }
        return left==s.length();
    }
}