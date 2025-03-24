class Solution {
    public int getCnt(int i , int j , int[][] properties ,int m ){
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        for(int k = 0 ; k < m ; k++){
            a.add(properties[i][k]);
            b.add(properties[j][k]);
        }
        int cnt = 0;
        for(int p : a){
            if(b.contains(p)) cnt++;
        }

        return cnt;
    }
    public void dfs(int node ,List<Integer>[] adj, boolean[] vis ){
        vis[node]=true;
        for(int i: adj[node]){
            if(!vis[i]){
                dfs(i,adj,vis);
            }
        }
    }
    public int numberOfComponents(int[][] properties, int k) {
        int n = properties.length;
        int m = properties[0].length;
        List<Integer>[] adj = new ArrayList[properties.length];
        for(int i = 0 ; i < n ; i++){
            adj[i] = new ArrayList<>();
        }
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(i==j) continue;
                int cnt = getCnt(i,j,properties,m);
                if(cnt>=k){
                    adj[i].add(j);
                    adj[j].add(i);
                }
            }
        }

        boolean vis[] = new boolean[n];
        int cnt = 0;
        for(int i = 0 ; i < n ; i++){
            if(!vis[i]){
                dfs(i,adj,vis);
                cnt++;
            }
        }

        return cnt;
    }
}