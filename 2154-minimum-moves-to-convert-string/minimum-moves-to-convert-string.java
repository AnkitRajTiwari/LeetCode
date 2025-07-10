class Solution {
    public int minimumMoves(String s) {
        int i=0;
        int step=0;
        while(i<s.length()){
            if(s.charAt(i)=='X'){
                // move i to  3
                i=i+3;
                step++;
            }
            else{
                i++;
            }
        }
        return step;
    }
}