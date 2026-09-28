class Solution {
    public int longestBeautifulSubstring(String word) {
        //// two pointer + count frequency 
        int start=0;
        int counter=0;
        int answer=0;
        for(int end=0; end< word.length();end++)
        {
            if(end==0 || word.charAt(end)< word.charAt(end-1))
            {
                start=end; // make the window containing the new character not the previous 
                counter=1;/// increase conter to 1 because the freseh widnow already has start
            }

           else  if(word.charAt(end)!=word.charAt(end-1))
            {
                counter++;
            }
            if(counter==5)
            {
                answer=Math.max(answer, end-start+1);
            }
        }
        return answer;
    }
}