class Solution {
    public boolean hasSameDigits(String s) {
        while(s.length()>2)
        {
            StringBuilder s1=new StringBuilder();
            for(int i=0;i<s.length()-1;i++)
            {
                int a=(s.charAt(i)+s.charAt(i+1))%10;
                s1.append(a);
            }
            s=s1.toString();
        }
        return s.charAt(0)==s.charAt(1);
    }
}