class Solution {
    public int specialArray(int[] arr) {
        int x = 0;
        while (x<=arr.length) {
            int count = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] >= x) {
                    count++;
                }
            }

            if (count == x) {
                return count;
            }
            x++;
        }
        return -1;
    }
}