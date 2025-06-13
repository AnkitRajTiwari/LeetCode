class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        for (int i = 0; i < nums2.length; i++) {
            mp.put(nums2[i], i);
        }
        int[] ans = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            ans[i] = -1;
            int curr = mp.get(nums1[i]) + 1;
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