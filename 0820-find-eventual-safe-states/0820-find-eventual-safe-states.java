class Solution {

    private boolean dfs(int node, boolean[] vis, boolean[] check, boolean[] path, int[][] graph){

        vis[node] = true;
        check[node] = false;
        path[node] = true;

        for(int it : graph[node]){

            if(!vis[it]){

                if(dfs(it, vis, check, path, graph))
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
        boolean[] vis = new boolean[V];
        boolean[] check = new boolean[V];
        boolean[] path = new boolean[V];

        for(int i = 0 ; i < V ; i++){

            if(!vis[i])
                dfs(i, vis, check, path, graph);
        }

        List<Integer> ans = new ArrayList<>();

        for(int i = 0 ; i < V ; i++){
            if(check[i])
                ans.add(i);
        }

        return ans;
    }
}