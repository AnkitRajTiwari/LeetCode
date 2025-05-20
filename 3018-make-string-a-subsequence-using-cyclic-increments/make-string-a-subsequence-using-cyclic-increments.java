class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        int m=str1.length();
        int n=str2.length();
        int i=0;
        int j=0;
        while(i<m && j<n)
        {
            char ch1=str1.charAt(i);
            char ch2=str2.charAt(j);
            if(ch1==ch2 || (ch2-ch1)==1 || (ch1=='z' && ch2=='a'))
            {
                i++;
                j++;
            }
            else
            {
                i++;
            }
        }
        return j==n;
    }
}