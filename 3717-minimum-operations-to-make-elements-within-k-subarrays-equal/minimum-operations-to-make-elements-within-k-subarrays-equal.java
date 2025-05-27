class Solution {
    long dp[][];
    int maxHeapSize=0,minHeapSize=0;
    long maxHeapSum=0,minHeapSum=0;
    public long minOperations(int[] nums, int x, int k) {
        long diff[]=new long[nums.length-x+1];
        dp=new long[diff.length][k+1];
        for(long arr[]:dp)
            Arrays.fill(arr,-1);
        List<Long> median_from_i=new ArrayList<>();
        calculateMedian(nums,x,median_from_i);
        //for(int i=0;i<median_from_i.size();i++)
            //System.out.print(median_from_i.get(i)+" ");
        for(int i=0;i<nums.length-x+1;i++){
            long med_start_i=median_from_i.get(i);
            //diff[i]=calculate(nums,i,x,med_start_i);
            diff[i]=med_start_i;
        }
        return solve(diff,0,k,x);
    }
    long mx = (long)1e14;
    public long solve(long diff[],int index,int k,int x){
        if(k==0)
            return 0;
        if(index>=diff.length)
            return mx;
        if(dp[index][k]!=-1)
            return dp[index][k];
        long dont_take=solve(diff,index+1,k,x);
        long take=diff[index]+solve(diff,index+x,k-1,x);
        return dp[index][k]=Math.min(take,dont_take);
    }
    /*public long calculate(int nums[],int i,int x,long median){
        long sum=0;
        for(int j=i;j<i+x;j++){
            sum+=Math.abs(nums[j]-median);
        }
        return sum;
    }*/
    public void calculateMedian(int nums[],int x,List<Long> ans){
        PriorityQueue<Integer> maxHeap=new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> minHeap=new PriorityQueue<>();
        HashMap<Integer,Integer> delayed=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(i<x){
                if(maxHeap.size()>0 && maxHeap.peek()>=nums[i]){
                    maxHeap.add(nums[i]);
                    maxHeapSize++;
                    maxHeapSum+=nums[i];
                    balance(maxHeap,minHeap,delayed);
                }
                else{
                    minHeap.add(nums[i]);
                    minHeapSize++;
                    minHeapSum+=nums[i];
                    balance(maxHeap,minHeap,delayed);
                }
                if(i==x-1){
                    long median=(maxHeap.peek());
                    ans.add(median * maxHeapSize - maxHeapSum + minHeapSum - median * minHeapSize);
                }
            }
            else{
                int val=delayed.getOrDefault(nums[i-x],0);
                delayed.put(nums[i-x],val+1);
                if(nums[i-x]<=maxHeap.peek()){
                    maxHeapSize--;
                    maxHeapSum-=nums[i-x];
                }
                else{
                    minHeapSize--;
                    minHeapSum-=nums[i-x];
                }
                balance(maxHeap,minHeap,delayed);
                if(maxHeap.size()>0 && maxHeap.peek()>=nums[i]){
                    maxHeap.add(nums[i]);
                    maxHeapSize++;
                    maxHeapSum+=nums[i];
                    balance(maxHeap,minHeap,delayed);
                }
                else{
                    minHeap.add(nums[i]);
                    minHeapSize++;
                    minHeapSum+=nums[i];
                    balance(maxHeap,minHeap,delayed);
                }
                long median=(maxHeap.peek());
                ans.add(median * maxHeapSize - maxHeapSum + minHeapSum - median * minHeapSize);
            }
        }
    }
    public void balance(PriorityQueue<Integer> maxHeap,PriorityQueue<Integer> minHeap,HashMap<Integer,Integer> delayed){
        if(maxHeapSize>minHeapSize+1){
            while(maxHeapSize>minHeapSize+1){
                maxHeapSum-=maxHeap.peek();
                minHeapSum+=maxHeap.peek();
                minHeapSize++;
                maxHeapSize--;
                minHeap.add(maxHeap.poll());
            }
        }
        if(minHeapSize>maxHeapSize){
            while(minHeapSize>maxHeapSize){
                maxHeapSum+=minHeap.peek();
                minHeapSum-=minHeap.peek();
                maxHeapSize++;
                minHeapSize--;
                maxHeap.add(minHeap.poll());
            }
        }
        clear(maxHeap,minHeap,delayed);
    }
    public void clear(PriorityQueue<Integer> maxHeap,PriorityQueue<Integer> minHeap,HashMap<Integer,Integer> delayed){
        while(maxHeap.size()>0 && delayed.containsKey(maxHeap.peek())){
            int val=delayed.getOrDefault(maxHeap.peek(),0);
            if(val>1)
                delayed.put(maxHeap.peek(),val-1);
            else
                delayed.remove(maxHeap.peek());
            maxHeap.poll();
        }
        while(minHeap.size()>0 && delayed.containsKey(minHeap.peek())){
            int val=delayed.getOrDefault(minHeap.peek(),0);
            if(val>1)
                delayed.put(minHeap.peek(),val-1);
            else
                delayed.remove(minHeap.peek());
            minHeap.poll();
        }
    }
}