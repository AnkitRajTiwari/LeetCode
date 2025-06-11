class Solution {
    public int minNumber(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int n1 = nums1.length;
        int n2 = nums2.length;
        int result= 0;
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