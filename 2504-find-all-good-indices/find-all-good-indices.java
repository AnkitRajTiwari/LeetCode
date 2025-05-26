class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> li = new ArrayList<>();
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        //left one from starting of array
        for(int i=1;i<n ; i++){
            if(nums[i]<=nums[i-1]){
                left[i] = left[i-1]+1;
            }
        }

        //right one from last
        for(int i=n-2 ; i>=0 ; i--){
            if(nums[i+1]>=nums[i]){
                right[i] = right[i+1]+1;
            }
        }
        for(int i=k ; i<n-k ; i++){
            if(left[i-1]>=k-1 && right[i+1]>=k-1){
                li.add(i);
            }
        }
        return li;
    }
}