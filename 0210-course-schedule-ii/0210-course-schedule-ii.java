class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {

        ArrayList<Integer>[] adj = new ArrayList[numCourses];

        for(int i = 0 ; i < numCourses ; i++)
            adj[i] = new ArrayList<>();

        for(int[] it : prerequisites){
            int u = it[0];
            int v = it[1];

            adj[v].add(u);
        }

        int[] inDegree = new int[numCourses];

        for(int i = 0 ; i < numCourses ; i++){
            for(int it  : adj[i]){
                inDegree[it]++;
            }
        }

        int[] ans = new int[numCourses];
        int idx = 0;

        Queue<Integer> q = new LinkedList<>();

        for(int i = 0 ; i < numCourses ; i++)
            if(inDegree[i] == 0)
                q.add(i);

        while(!q.isEmpty()){
            int node = q.poll();
            ans[idx++] = node;

            for(int it : adj[node]){
                inDegree[it]--;

                if(inDegree[it] == 0)
                    q.add(it);
            }
        }

        return idx == numCourses ? ans : new int[0];
    }
}