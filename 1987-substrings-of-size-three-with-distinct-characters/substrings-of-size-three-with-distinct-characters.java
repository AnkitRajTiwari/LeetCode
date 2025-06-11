class Solution {
    public int countGoodSubstrings(String s) {
        if(s.length()<3)
        {
            return 0;
        }
        int res=0;
         //  checking 3 character at a time 
        for(int i=0;i<=s.length()-3;i++)
        {
            char a =s.charAt(i);
             char b =s.charAt(i+1);
              char c =s.charAt(i+2);
              if(a!=b && b!=c && c!=a)
              {
                res++;
              }
        }
        return res ;
    }
}