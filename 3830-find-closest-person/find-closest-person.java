class Solution {
    public int findClosest(int x, int y, int z) {
        int one= Math.abs(z-x);
        int two= Math.abs(z-y);
        if(one>two){
            return 2;
        }
        else if(one==two){
            return 0;
        }
        else {
            return 1;
        }
        
    }
}