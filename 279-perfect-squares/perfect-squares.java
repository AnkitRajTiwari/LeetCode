class Solution {
    /*Using Lagrange’s Four-Square Theorem
    *every natural number can be represented as 
    *the sum of four integer squares.
    */
    //So the answer is always between 1 to 4
    public boolean isSquare(int n) {
        int x = (int) Math.sqrt(n);
        return x * x == n;
    }
    public int numSquares(int n) {
        //if number is perfect square itself then answer is 1
        if (isSquare(n)) return 1;
        
        //Two square check
        for (int i = 1; i * i <= n; i++) {
            if (isSquare( n - i * i)) return 2;
        }

        /*
        *Legendre’s 3-square theorem
        *A positive integer n can be written as the sum of three squares 
        *if and only if n is not of the form: n = 4^k*(8b+7)
        */

        int m = n;
        //(m & 3) checks last 2 bits, if those bits are 00 then number is divisible by 4
        while ((m & 3) == 0) m = m >> 2;   // divide by 4, m >>= 2 is m = m / 4

        /*
        *Legender's theorem*
        *(m & 7) checks the last 3 bits (i.e., m % 8).
        *If remainder is 7, then m has the form 8b + 7.
        *Combined with Step 1, that means the original n was of the form 4^k(8b+7).
        */
        if ((m & 7) == 7) return 4;

        //if 1, 2, and 4 are checked so ans is 3 otherwise
        return 3;
    }
}