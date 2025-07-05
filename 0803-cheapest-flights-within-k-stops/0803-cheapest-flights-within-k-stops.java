class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        
        if(src == dst)
            return 0;

        List<List<int[]>> adj = new ArrayList<>();

        for(int i = 0 ; i < n ; i++)
            adj.add(new ArrayList<>());

        for(int[] flight : flights)
            adj.get(flight[0]).add(new int[]{flight[1],flight[2]});

        int[]dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        
        dist[src] = 0;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{0, src, 0});

        while(!q.isEmpty()){
            int[] cell = q.poll();

            int stops = cell[0];
            int node = cell[1];
            int dis = cell[2];

            if(stops > k)
                continue;

            for(int[] it : adj.get(node)){

                int adjNode = it[0];
                int edgWt = it[1];

                if(dis + edgWt < dist[adjNode] && stops <= k){

                    dist[adjNode] = dis + edgWt;
                    
                    q.offer(new int[]{stops + 1, adjNode, dis + edgWt});
                }
            }
        }

        if (dist[dst] == Integer.MAX_VALUE) 
            return -1;

        return dist[dst];
    }
}