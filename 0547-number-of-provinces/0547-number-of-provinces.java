class Solution {

       private void dfs(int node, List<Integer> adjLs[], boolean[] vis) {
        
        // Mark the node as visited
        vis[node] = true; 
        
        // Traverse its unvisited neighbours
        for (int it : adjLs[node]) {
            
            if (!vis[it]) {
                // Recursively perform DFS
                dfs(it, adjLs, vis); 
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
        int V = isConnected.length;
        List<Integer>[] adjLs = new ArrayList[V];
        
        for(int i = 0 ; i < V ; i++)
            adjLs[i] = new ArrayList();
        

        for (int i = 0; i < V; i++) {
            for (int j = 0; j < V; j++) {
                if (isConnected[i][j] == 1 && i != j) {
                    adjLs[i].add(j); 
                    adjLs[j].add(i); 
                }
            }
        }

        boolean[] vis = new boolean[V];

        int cnt = 0;

        for(int i = 0 ; i < V ; i++){

            if(!vis[i]){
                cnt++;
                dfs(i, adjLs, vis);
            }
        }

        return cnt;
    }
}