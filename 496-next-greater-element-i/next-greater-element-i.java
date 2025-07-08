class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        // a hashmap to store the index of num2 so that 
        // we can check where did the num1 in the 2 apopears 
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            mp.put(nums2[i], i); // Example: if nums2 = [4,1,2], then map = {4:0, 1:1, 2:2}
        } 
        // an array to store the finasl 
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = -1; 
            // store the index of nums1 in num 2 and then check for another 
            int curr = mp.get(nums1[i]) + 1; 
           // Search for the next greater element to the right in nums2
            while (curr < nums2.length) {

                if (nums2[curr] > nums1[i]) {
                    ans[i] = nums2[curr];
                    break;
                }
                curr++;
            }
        }
        return ans;
    }
}