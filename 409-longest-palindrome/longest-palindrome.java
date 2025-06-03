class Solution {
    public int longestPalindrome(String s) {
        boolean[] arr = new boolean[123];   // a-z ASCII value is 65 to 90 && A-Z ASCII value is 97 to 122
        int i = 0;
        int ans = 0;
        while(i<s.length()){
            if(arr[(int)(s.charAt(i))]==false){    // odd time charactor occur & note down into the array
                arr[(int)(s.charAt(i))] = true;    // note down into the array
            }else{
                arr[(int)(s.charAt(i))] = false;    //even time charactor occur & ans+=2
                ans+=2;
            }
            i++;
        }

        //after while loop if any odd occur reamining then longest palindrome is ans+1
        for(i = 65; i<arr.length ; i++){
            if(arr[i])return ans+1;
        }

        //otherwise longest palindrome is ans
        return ans;
    }
}