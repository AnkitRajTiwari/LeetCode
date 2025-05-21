class Solution {
    public int findTheDistanceValue(int[] arr1, int[] arr2, int d) {
        int n=arr1.length;
        int count =0;
        // loop 
        for(int i=0;i<n;i++)
        {
            boolean istrue=true;
            // second loop to iteratie and check 
            for(int j=0;j<arr2.length;j++)
            {
                // check
                if(Math.abs(arr1[i]-arr2[j])<=d)
                {
                    istrue=false;
                    break;
                }
            }
            if(istrue)
            {
                count++;
            }
        }
        return count;
    }
}