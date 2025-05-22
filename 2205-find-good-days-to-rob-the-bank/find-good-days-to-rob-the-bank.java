class Solution {
    public List<Integer> goodDaysToRobBank(int[] arr, int time) {
        int n = arr.length;
        List<Integer> arr1 = new ArrayList<>();

        if(time == 0){
            for(int i = 0;i<n;i++)arr1.add(i);
            return arr1;
        }

        int[] l = new int[n];
        int[] r = new int[n];

        for(int i=1;i<n;i++){
            if(arr[i]<=arr[i-1]){
                l[i] = l[i-1]+1;
            }
        }
        for(int i=n-2;i>=0;i--){
            if(arr[i]<=arr[i+1]){
                r[i] = r[i+1]+1;
            }
        }

        for(int i = 0 ;i<n;i++){
            if(l[i]>=time && r[i]>=time){
                arr1.add(i);
            }
        }
    return arr1;
    }
}