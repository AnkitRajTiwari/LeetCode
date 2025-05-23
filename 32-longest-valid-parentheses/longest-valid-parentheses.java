class Solution {
    public int longestValidParentheses(String s) {
        if(s.length() == 0){
            return 0;
        }
        int maxlen = 0;
        int left = 0;
        int right = 0;
        // this loop will work for balanced paranthesis that work from left to right
        for(int i = 0;i<s.length();i++){
            if(s.charAt(i) == '('){
                left++;
            }else{
                right++;
            }
            if(left == right){
                maxlen = Math.max(maxlen , 2*right);
            }
            if(right > left){
                left = right = 0;
            }
        }
        left = right = 0;
        // this loop will work for balanced paranthesis that work from right to left
        for(int i = s.length() - 1 ; i >= 0 ; i--){
            if(s.charAt(i) == '('){
                left++;
            }else{
                right++;
            }
            if(left == right){
                maxlen = Math.max(maxlen , 2*left);
            }
            if(left > right){
                left = right = 0;
            }
        }
        return maxlen;
    }
}