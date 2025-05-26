class Solution {
    public int numberOfBeams(String[] nums) {
        int len=0,res=0;
        for(int i=nums.length-1;i>=0;i--){
            int temp=count(nums[i]);
            res+=(temp*len);
            if(temp!=0)len=temp;
        }
        return res;
    }
    int count(String s){
        int i=0,j=s.length()-1,count=0;
        while(i<j){
           if(s.charAt(i)==49)count++;
           if(s.charAt(j)==49)count++;
            i++;
            j--;
        }
        if(i==j&&s.charAt(i)==49)count++;
        return count;
    }
}
