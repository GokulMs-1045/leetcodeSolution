class Solution {

    public int[] delrow = {-1, 0, 1, 0};
    public int[] delcol = {0, 1, 0, -1};

    private boolean isValid(int i, int j, int n, int m){
        
        if(i < 0 || i >= n || j < 0 || j >= m)
            return false;

        return true;
    }

    public int[][] updateMatrix(int[][] mat) {

        int n = mat.length;
        int m = mat[0].length;

        int[][] vis = new int[n][m];
        int[][] dist = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){

                if(mat[i][j] == 0){
                    vis[i][j] = 1;
                    q.add(new int[]{i, j, 0});
                }
                else
                    vis[i][j] = 0;
            }
        }

        while(!q.isEmpty()){
            int[] cell = q.poll();

            int row = cell[0];
            int col = cell[1];
            int steps = cell[2];

            dist[row][col] = steps;

            for(int i = 0 ; i < 4 ; i++){

                int nrow = row + delrow[i];
                int ncol = col + delcol[i];

                if(isValid(nrow, ncol, n, m) && vis[nrow][ncol] == 0){
                    vis[nrow][ncol] = 1;
                    q.add(new int[]{nrow, ncol, steps + 1});
                }
            }
        }

        return dist;
    }
}