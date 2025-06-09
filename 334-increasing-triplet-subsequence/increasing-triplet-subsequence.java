class Solution {
    public boolean increasingTriplet(int[] nums) {
        int first=Integer.MAX_VALUE;
        int second= Integer.MAX_VALUE;
        for(int i:nums){
            if(i<=first){
                first=i;
            }
            else if(i<=second){
                second=i;
            }
            else return true;
        }
        return false;
    }
}

// first will store the smallest number seen so far.

 // second will store the second smallest number seen after first.
 // If the current number i is less than or equal to first, we update first.
 // If the current number i is greater than first, but less than or equal to second, we update second.