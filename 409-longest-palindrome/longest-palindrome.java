class Solution
 {
    public int longestPalindrome(String s) 
    {
     HashMap<Character,Integer> map=new HashMap<>();
      int oddcount=0;
      for(char c:s.toCharArray())
      {
        map.put(c,map.getOrDefault(c,0)+1);
        if(map.get(c)%2==1){
            oddcount++;
        }
        else
        {
            oddcount--;
        }
      }
      if(oddcount>1)
      {
        return s.length()-oddcount+1;
      }
        return s.length();
      }
}