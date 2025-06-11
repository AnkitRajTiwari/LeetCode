class Solution {
    public String sortString(String s) {
        int[] freq = new int[26];
        String ans = "";
        for(int i = 0; i < s.length(); i++){
            int ch = s.charAt(i) - 'a';
            freq[ch]++;
        }
        while(ans.length() != s.length()){  
        for(int i = 0; i < freq.length; i++){
            if(freq[i] > 0){
               	char c =(char) (i + 'a');
                ans+= c;
                freq[i]--;
            }
        }
        for(int i = freq.length -1; i >= 0; i--){
            if(freq[i] > 0){
                char c =(char) (i + 'a');
                ans+= c;
                freq[i]--;
            }
        }
     }
        return ans;
    }
}