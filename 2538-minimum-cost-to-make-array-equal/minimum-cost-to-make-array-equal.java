class Solution {
public long check(int mid,int[] arr,int[] cost){
    
    long sum=0;
        
     for(int i=0;i<arr.length;i++){
         sum+= 1l* Math.abs(mid-arr[i])*cost[i];
     }       
     return sum;
}

    public long minCost(int[] nums, int[] cost) {
        int l=0,r=1000000;
        while(l<=r){
       int mid= (l+r)/2;
         long p1=check(mid-1,nums,cost);
        long p2=check(mid,nums,cost);
        long p3= check(mid+1,nums,cost);
       if(p1>=p2 && p3>=p2){
           return p2;
       }
        else if(p1<p2){
             r= (mid-1);
        }
         else  
          l=(mid+1);
    }
        
        return 0;
    }
}