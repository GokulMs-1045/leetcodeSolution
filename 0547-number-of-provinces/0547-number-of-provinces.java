class Solution {

        private void bfs(int node, List<Integer> adjLs[], boolean[] vis) {
        
        vis[node] = true;
        
        Queue<Integer> q = new LinkedList<>();
        
        q.add(node); 
        
        while (!q.isEmpty()) {

            int i = q.poll();
            
            for (int adjNodes : adjLs[i]) {
                
                if (!vis[adjNodes]) {
                    
                    vis[adjNodes] = true;
                    
                    q.add(adjNodes);
                }
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
                bfs(i, adjLs, vis);
            }
        }

        return cnt;
    }
}