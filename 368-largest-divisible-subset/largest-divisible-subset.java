class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);  // Sort to make divisibility checking easier

        // ld[i] = size of largest subset ending at nums[i]
        int[] ld = new int[n];
        Arrays.fill(ld, 1);

        // parent[i] = index of previous number in the subset for backtracking
        int[] parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;  // Initially, every number is its own parent
        }

        // Build DP and parent arrays
        for (int i = 0; i < n; i++) {
            int mx = 1;  // Maximum length of subset ending at i
            int ind = i;  // Parent index
            for (int j = 0; j <= i - 1; j++) {
                if (nums[i] % nums[j] == 0 && ld[j] + 1 > mx) {
                    mx = ld[j] + 1;
                    ind = j;
                }
            }
            ld[i] = mx;
            parent[i] = ind;  // Update parent index for backtracking
        }

        // Find the index of the maximum subset length
        int maxLen = -1;
        int maxIndex = -1;
        for (int i = 0; i < n; i++) {
            if (ld[i] > maxLen) {
                maxLen = ld[i];
                maxIndex = i;
            }
        }

        // Reconstruct the subset using parent array
        List<Integer> ans = new ArrayList<>();
        while (parent[maxIndex] != maxIndex) {
            ans.add(nums[maxIndex]);
            maxIndex = parent[maxIndex];
        }
        ans.add(nums[maxIndex]);  // Add the final element

        return ans;
    }
}