class Solution {
    public int countCells(char[][] grid, String pattern) {
        int length=pattern.length();
        int arr[]=new int[(grid.length*grid[0].length)+1];
        int arr2[]=new int[(grid.length*grid[0].length)+1];
        StringBuffer sb=new StringBuffer(pattern.length());
        for(int i=0;i<length;i++)sb.append('@');
        int ind=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                sb.deleteCharAt(0);
                sb.append(grid[i][j]);
                if(pattern.contentEquals(sb)){
                    arr[ind+1]--;
                    arr[ind-length+1]++;
                    }
                    ind++;
            }
        }
        ind=0;
         sb=new StringBuffer(pattern.length());
        for(int i=0;i<length;i++)sb.append('@');
        for(int j=0;j<grid[0].length;j++){
            for(int i=0;i<grid.length;i++){
                sb.deleteCharAt(0);
                sb.append(grid[i][j]);
                if(pattern.contentEquals(sb)){
                      arr2[ind+1]--;
                    arr2[ind-length+1]++;
                    }
                    ind++;
            }
        }
        int count=0;
        int count2=0;
        int answer=0;
      for(int i=0;i<arr.length;i++){
        count+=arr[i];
        arr[i]=count;
        count2+=arr2[i];
        arr2[i]=count2;
      }
      int row=grid.length;
      int col=grid[0].length;
       for(int i=0;i<arr.length-1;i++) {
                int r=i/col;
                int c=i%col;
                int x=(c*row)+r;
                if(arr[i]>0 && arr2[x]>0)answer++;
       }

        return answer;
    }
}