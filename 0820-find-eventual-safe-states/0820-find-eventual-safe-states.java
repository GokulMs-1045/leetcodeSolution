class Solution {

    private boolean dfs(int node, int[][] graph, boolean[] vis, boolean[] check, boolean[] path){

        vis[node] = true;
        path[node] = true;
        check[node] = false;

        for(int it : graph[node]){

            if(!vis[it]){
                if(dfs(it, graph, vis, check, path))
                    return true;
            }
            
            else if(path[it])
                return true;
        }

        check[node] = true;
        path[node] = false;

        return false;
    }

    public List<Integer> eventualSafeNodes(int[][] graph) {

        int V = graph.length;
        
        boolean[] path = new boolean[V];
        boolean[] vis = new boolean[V];
        boolean[] check = new boolean[V];

        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < V ; i++){

            if(!vis[i])
                dfs(i, graph, vis, check, path);
        }

        for(int i = 0 ; i < V ; i++)
            if(check[i])
                ans.add(i);

        return ans;
    }
}