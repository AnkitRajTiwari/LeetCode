class Solution {
    public boolean maxSubstringLength(String s, int k) {
        int n = s.length() ;
        int[] f = new int[26];
        int[] l = new int[26];
        Arrays.fill(f, -1);

        char ch[] =  s.toCharArray();
        for (int i = 0; i <n  ;i++){
            char curr = ch[i] ;
            if (f[curr-'a'] == -1){
                f[curr-'a'] =  i ;
            }
            l[curr-'a'] = i ;
        }
        List<int[]> candidates = new ArrayList<>();

        for (int i = 0; i <n ; i++){
            char curr = ch[i] ;

            if (f[curr-'a'] != i) continue ;// not the firstOccurence
            int j = l[curr-'a'] ;
            int idx = i ;
            boolean valid = true ;
            while (idx <= j){
                char next = ch[idx] ;
                if (f[next-'a'] < i ){
                    valid = false ;
                    break ;
                }
                j = Math.max(j , l[next-'a']) ;
                idx++;
            }
            if (valid && !(i == 0 && j == n-1)) {
                candidates.add(new int[]{i,j});
            }
        }
        // get disjoint ones 
        // sort based on endofSubstring in Order to get max possible substring (Greedy)
        Collections.sort(candidates, Comparator.comparingInt(a->a[1]));
        int cnt = 0 ;
        int end = -1 ;
        for (int[] c : candidates){
            if (c[0] > end){
                cnt++;
                end = c[1] ;
            }
        }

        return cnt >= k;

    }
}