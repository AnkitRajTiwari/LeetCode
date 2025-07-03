class Solution {
    public int bitwiseComplement(int n) {
        int i=0;
        double t=0;
        if(n==0)
        {
            return 1;
        }
        if(n==1)
        {
            return 0;
        }
        while(n>1)
        {
         
         if(n%2==0)
         {
            t=t+Math.pow(2,i);
         }
         i++;
         n/=2;
        }
        
      return (int)t;
    }
}