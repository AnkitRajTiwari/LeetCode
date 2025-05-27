class Solution {
    public int minOperations(int[] nums) {
        Map<Integer, TreeSet<Integer>> map = new HashMap();
        SegmentTree tree = new SegmentTree(nums);
        for (int i = 0; i < nums.length; i++) {
            TreeSet<Integer> ids = map.getOrDefault(nums[i], new TreeSet());
            ids.add(i);
            map.put(nums[i], ids);
        }
        return minHelper(0, nums.length - 1, nums, map, tree);
    }
    private int minHelper(int l, int r, int[] nums,
            Map<Integer, TreeSet<Integer>> map, SegmentTree tree) {
        if (l > r) return 0;
        int ans = 0;
        int prev = l;
        int min = tree.getMin(l, r);
        SortedSet<Integer> set = map.get(min).subSet(l, r + 1);
        for (int i : set) {
            if (i < l || i > r) continue;
            ans += minHelper(prev, i - 1, nums, map, tree);
            prev = i + 1;
        }
        if (prev <= r)
            ans += minHelper(prev, r, nums, map, tree);
        if (min == 0) return ans;
        return ans + 1;
    }
}
class SegmentTree {
    int[] tree;
    int N;
    SegmentTree(int[] arr) {
        N = arr.length;
        tree = new int[4 * N];
        buildHelper(0, 0, N - 1, arr);
    }
    private int buildHelper(int root, int left, int right, int[] arr) {
        if (left == right) {
            tree[root] = arr[left];
            return arr[left];
        }
        int mid = (left + right) / 2;
        int op1 = buildHelper(2 * root + 1, left, mid, arr);
        int op2 = buildHelper(2 * root + 2, mid + 1, right, arr);
        return tree[root] = Math.min(op1, op2);
    }
    public int getMin(int L, int R) {
        return getMinHelper(0, 0, N - 1, L, R);
    }
    int MAX = 1000000000;
    private int getMinHelper(int root, int left, int right, int L, int R) {
        if (left > R || right < L) return MAX;
        if (left >= L && right <= R) {
            return tree[root];
        }
        int mid = (left + right) / 2;
        return Math.min(getMinHelper(2 * root + 1, left, mid, L, R), 
                getMinHelper(2 * root + 2, mid + 1, right, L, R));
    }
}
/*
0 -> 0 to N-1
1 -> 0 to mid
2 -> mid+1 to N-1

                0, [0,9]
            1[0,4]                              2[5,9]
     3[0,2]         4[3,4]             5[5,7]               6[8,9]
    7[0,1]  8[2]   9[3] 10[4]     11[5,6]     12[7]       13[8] 14[9]
  15[0] 16[1]                   17[5] 18[6]  

*/