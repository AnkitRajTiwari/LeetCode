class Solution {
    public int[] pivotArray(int[] nums, int pivot) {
        int []result =new int[nums.length];
        int index=0;
        // <pivot
        for(int i:nums)
        {
            if(i<pivot)
            {
                result[index++]=i;
            }
        }
        // == pivotfor
        for(int i:nums)
        {
            if(i== pivot)
            {
                result[index++]=i;
            }
        }
        // > pivot
        for(int i:nums)
        {
            if(i>pivot)
            {
                result[index++]=i;
            }
        }
       return result;
    }
}