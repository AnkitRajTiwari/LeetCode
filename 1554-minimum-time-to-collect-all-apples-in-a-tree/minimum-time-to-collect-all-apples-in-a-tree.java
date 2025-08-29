class Solution {
    public int minTime(int n, int[][] edges, List<Boolean> hasApple) {
        //creating a adjacency list
        List<List<Integer>> adjlist = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            adjlist.add(new ArrayList<>());
        }
        for(int neighbour[] : edges){
            int from = neighbour[0];
            int to = neighbour[1];
            adjlist.get(from).add(to);
            adjlist.get(to).add(from);
        }
        int result = dfs(0,-1,adjlist,hasApple);
        return result;
    }
    public int dfs(int src,int parent,List<List<Integer>> adjlist,List<Boolean> hasApple){
        int timetaken = 0;
        for(int neighbour : adjlist.get(src)){
            if(neighbour == parent) continue;
            int timetakenbychild = dfs(neighbour,src,adjlist,hasApple);
            if(timetakenbychild > 0 || hasApple.get(neighbour) == true){
                timetaken += timetakenbychild + 2;
            }
        }
        return timetaken;
    }
}