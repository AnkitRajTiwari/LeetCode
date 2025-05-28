class Solution {
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            ans[i] = ans[i >> 1] + (i & 1);
        }
        return ans;
    }
}

// here ans[i>>1] means that shift it right by dividing it by 2 and discard the  remaindder and them add 1 if it is even last digit is even 
//i >> 1 is right shift: it divides i by 2 and discards the remainder.
// (Example: 5 >> 1 = 2, because binary 101 becomes 10)

// i & 1 is bitwise AND: it checks if the last bit of i is 1 (i.e., if i is odd).

// i & 1 == 1 if i is odd

// i & 1 == 0 if i is even