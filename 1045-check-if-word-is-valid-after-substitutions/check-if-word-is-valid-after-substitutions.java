class Solution {
    public boolean isValid(String s) {
        while(s.contains("abc"))
        {
            s=s.replaceAll("abc","");
        }
        return s.equals("") ? true:false;
    }
}