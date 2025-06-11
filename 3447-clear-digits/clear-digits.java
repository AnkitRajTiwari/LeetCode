class Solution {
    public String clearDigits(String s) {
        StringBuilder res = new StringBuilder();
        int i;
        for(i=0; i<s.length(); i++)
        {
            if(s.charAt(i)>='0'&&s.charAt(i)<='9')
            {
                res.deleteCharAt(res.length()-1);
            }
            else
            {
                res.append(s.charAt(i));
            }
        }
        return res.toString();
    }
}