class Solution {
    public int numberOfSubstrings(String s) {
        //// sliding window +two pointer+freq count
        int start=0;
        int []count=new int[3];
        int answer=0;
        for(int end=0; end<s.length(); end++)
        {
            /// count 
            char ch=s.charAt(end);
            count[ch-'a']++;
            /// if count quals
            while(count[0]>0 && count[1]>0 && count[2]>0)
            {     
                  ///// // All substrings from start to end,
                // extending end to the right, are valid
                answer+= s.length()-end;
                char chh=s.charAt(start);
                count[chh-'a']--;
                start++;
            }
        }
        return answer;
    }
}