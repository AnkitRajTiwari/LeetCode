class Solution {
    public int characterReplacement(String s, int k) {
        ///// here sliding window + two pointer + frequency count 
        //// we have to find the maxfreq inside the current window
        HashMap<Character, Integer> map=new HashMap<>();
        int start=0;
        int answer=0;
        int largestcount=0;
        for(int end=0; end<s.length(); end++)
        {
            /// count the character 
              char ch=s.charAt(end);
              map.put(ch, map.getOrDefault(ch,0)+1);
              largestcount=Math.max(largestcount, map.get(ch));

              /// equation window size-largestcount
              if(end-start+1 - largestcount>k)
              {
                char chh= s.charAt(start);
                map.put(chh, map.get(chh) - 1);
                start++;
              }
              answer=Math.max(answer,end-start+1);
        } 
        return answer ;
    }
}