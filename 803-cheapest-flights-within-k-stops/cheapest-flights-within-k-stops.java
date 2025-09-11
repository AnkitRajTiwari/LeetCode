class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<int[]>> graph=new ArrayList<>();
        for(int i=0;i<n;i++)graph.add(new ArrayList<>());
        for(int[] flight:flights){
            int u=flight[0];
            int v=flight[1];
            int w=flight[2];
            graph.get(u).add(new int[]{v,w});
        }
        int[] dist=new int[n];
        Arrays.fill(dist,Integer.MAX_VALUE);
        dist[src]=0;
        Queue<int[]>q=new LinkedList<>();
        q.offer(new int[]{src,0});
        int steps=0;
        while(!q.isEmpty()){
            int size=q.size();
            if(steps>k)break;
            while(size-->0){
                int curr[]=q.poll();
                int u=curr[0];
                int wt=curr[1];
                for(int[] nei:graph.get(u)){
                    int v=nei[0];
                    int d=nei[1];
                    if(dist[v]>wt+d){
                        dist[v]=wt+d;
                        q.offer(new int[]{v,wt+d});
                    }
                }
            }
            steps++;
        }
        return dist[dst]==Integer.MAX_VALUE ? -1:dist[dst];
    }
}