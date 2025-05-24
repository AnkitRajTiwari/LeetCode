class Solution {
    public int m = 1000000007;
    public long pow(long x, long n){
        if(n==0){
            return 1;
        }

        long temp = pow(x, n/2);
        temp=temp%m;
        if(n%2==0) return (temp*temp)%m;

        else return (((temp*temp)%m) * (x%m))%m;

    }
    public int minNonZeroProduct(int p) {
        
        long mx = ((long)1<<p) - 1;
        //long x = y/2;
        long res = pow(mx-1, (mx-1)/2);
        res = ((res%m) * (mx%m))%m;
        return (int)res;
    }
}