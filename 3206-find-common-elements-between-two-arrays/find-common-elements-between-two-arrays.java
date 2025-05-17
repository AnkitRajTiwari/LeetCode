class Solution {
    public static int[] findIntersectionValues(int[] nums1, int[] nums2) {
        
        // Create a HashSet to store unique elements from the first array nums1
        HashSet<Integer> hs1 = new HashSet<Integer>();
        
        // Create another HashSet to store unique elements from the second array nums2
        HashSet<Integer> hs2 = new HashSet<Integer>();
    
        // Loop through each element in nums1
        for (int i = 0; i < nums1.length; i++) {
            // Add the element to hs1 (duplicates automatically ignored by HashSet)
            hs1.add(nums1[i]);
        }
        
        // Loop through each element in nums2
        for (int i = 0; i < nums2.length; i++) {
            // Add the element to hs2 (duplicates automatically ignored)
            hs2.add(nums2[i]);
        }
        
        // Initialize two counters to zero:
        // ans1 will count how many elements of nums1 are present in nums2
        int ans1 = 0;
        // ans2 will count how many elements of nums2 are present in nums1
        int ans2 = 0;
        
        // Loop through elements of nums1 to check if each is contained in hs2 (elements of nums2)
        for (int num : nums1) {
            if (hs2.contains(num)) {
                ans1++;  // Increment ans1 if nums2 contains this element
            }
        }
        
        // Loop through elements of nums2 to check if each is contained in hs1 (elements of nums1)
        for (int num : nums2) {
            if (hs1.contains(num)) {
                ans2++;  // Increment ans2 if nums1 contains this element
            }
        }
        
        // Return an array with the two counts:
        // - ans1: count of elements in nums1 that appear in nums2
        // - ans2: count of elements in nums2 that appear in nums1
        return new int[] {ans1, ans2};
    }
}
