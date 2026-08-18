class Solution {
    public int lengthOfLongestSubstring(String s) {
       //// can be solved using the hashset

       HashSet<Character> hs=new HashSet<>();
       int start=0;
       int answer=0;
       for(int end=0; end<s.length(); end++)
       {
            /// check
            while(hs.contains(s.charAt(end)))
            {
                hs.remove(s.charAt(start));
                start++;
            }
            hs.add(s.charAt(end));
            answer=Math.max(answer, end-start+1);
       }
       return answer;
    }
}