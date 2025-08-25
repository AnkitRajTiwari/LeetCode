class Solution {
    public int[] findDiagonalOrder(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int []ans=new int[n*m];
        int index=0;
        for(int i=0;i<n+m-1;i++){
            List<Integer> ls=new ArrayList<>();
            for(int j=0;j<n;j++){
                int key=i-j;
                if(key>=0 && key<m){
                    ls.add(mat[j][key]);
                }
            }
            if(i%2==0){
                Collections.reverse(ls);
            }
            for(int k:ls){
                ans[index++]=k;
            }
        }
         return ans;
    }
}