class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[]vowelstring=new int[words.length];
        int sum=0;
        for(int i=0;i<words.length;i++){
            char first = words[i].charAt(0);
            char last = words[i].charAt(words[i].length() - 1);
            if ("aeiou".indexOf(first) != -1 && "aeiou".indexOf(last) != -1) {
                sum++;
            }
            vowelstring[i]=sum;
        }
        int[]ans=new int[queries.length];
        for(int i=0;i<queries.length;i++){
            int l=queries[i][0];
            int r=queries[i][1];
            ans[i] = (l==0)?vowelstring[r]:vowelstring[r]-vowelstring[l-1];
            
        }
        return ans;
    }
}