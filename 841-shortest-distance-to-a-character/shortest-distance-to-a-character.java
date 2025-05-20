class Solution {
    public int[] shortestToChar(String s, char c) {
        int [] res = new int [s.length()];
        int pos = -s.length();
        for(int i=0;i<s.length();i++){
            if(c==s.charAt(i)) pos=i;
            res[i]=Math.abs(i-pos);
        }
        for(int i=pos-1;i>=0;i--){
            if(c==s.charAt(i)) pos=i;
            res[i]=Math.min(res[i],pos-i);
        }
        return res;

    }
}