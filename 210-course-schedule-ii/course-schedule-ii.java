class Solution {

    public boolean isCycle(ArrayList<Integer>[] graph){
        int V = graph.length;  // total number of nodes
        boolean[] isVisited = new boolean[V];
        boolean[] stack = new boolean[V];  // recursion stack array
        
        // check each component (graph may be disconnected)
        for(int i = 0;i<V;i++){
            if(!isVisited[i]){  // if node not visited -> run DFS
                if(isCycleUtil(graph, isVisited , i, stack)){
                   return true;  // cycle found
                }
            }
        }
        return false;  // no cycle found in any components
    }

    public boolean isCycleUtil(ArrayList<Integer>[] graph, boolean[] isVisited, int curr, boolean[] stack){
        isVisited[curr] = true;
        stack[curr] = true;

        isVisited[curr]=true;  // mark current node as visited
        stack[curr]=true;   // mark current node as part of recursion stack
        
        for(int i=0;i<graph[curr].size();i++){  // traverse all neighbours of current node
            int neighbour = graph[curr].get(i);
            if(stack[neighbour]){
                // if neighbour is already in recursion stack -> cycle found
                return true;
            }else if(!isVisited[neighbour] && isCycleUtil(graph, isVisited, neighbour, stack)){
                // if neighbour not visited, recursively check its DFS
                return true;
            }
        }
        stack[curr]=false;  // backtrack -> remove from recursion stack before returning
        
        return false;
    }

    //   modified dfs to get the TSO
    public void dfs(ArrayList<Integer>[] graph, int curr, boolean[] isVisited, Stack<Integer> st){
        isVisited[curr] = true;

        for(int i=0;i<graph[curr].size();i++){
            int neighbour = graph[curr].get(i);
            if(!isVisited[neighbour]){
                dfs(graph, neighbour, isVisited, st);
            }
        }
        st.push(curr);  // store this vertex to the stack
    }

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // Solution using graph TSO as question is indirectly asking for Topological Sort, if it is a DAG.

        //  Constructing adacency list
        ArrayList<Integer>[] graph = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            graph[i] = new ArrayList<>();
        }
        for(int i =0;i<prerequisites.length;i++){
            int u = prerequisites[i][1];
            int v = prerequisites[i][0];
            graph[u].add(v); //  u -> v
        }

        if(isCycle(graph)) return new int[0];  // if cycle present -> not DAG => no tso possible

        boolean[] isVisited = new boolean[numCourses];
        Stack<Integer> st = new Stack<>();  // to store vertices in reverse topological sorted order

        for(int i=0;i<numCourses;i++){  // call dfs for each components (grapg may disconnected)
            if(!isVisited[i]){
                dfs(graph, i, isVisited, st);
            }
        }

        int[] tso = new int[numCourses];  // ans
        int k=0;
        while(!st.isEmpty()){ // now store the vertices in ans tso
            tso[k++] = st.pop();
        }
        return tso;  // topological sorted order
    }
}