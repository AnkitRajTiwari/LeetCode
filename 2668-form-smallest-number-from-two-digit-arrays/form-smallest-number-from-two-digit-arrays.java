class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        // sort both in the ascending order 
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n1 = nums1.length;
        int n2 = nums2.length;
        int result= 0;

        //If a digit from nums1 is equal to a digit from nums2, that means we found a common 
        // digit.
        // Save it in result and return it immediately, because due to sorting, this will be  //  the smallest possible common digit.
        for(int i = 0 ; i< n1; i++){
            for(int j = 0 ; j <n2; j++ ){
                if(nums1[i] == nums2[j]){
                    result = nums1[i];
                    return result;
                }
            }
        }
        return ((nums1[0]>nums2[0])? (nums2[0] *10) + nums1[0] :(nums1[0] *10) + nums2[0] );
    }
}