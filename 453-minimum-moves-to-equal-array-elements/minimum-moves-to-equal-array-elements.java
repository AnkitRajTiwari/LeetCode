class Solution {
    public int minMoves(int[] nums) {
        int min=Integer.MAX_VALUE;
        int moves=0;
        for(int x:nums){
            if(x<min) min=x;
        }
        // x - min gives the number of times we need to increase min to become x
        for(int x:nums) moves=moves+x-min;
        return moves;
    }
}