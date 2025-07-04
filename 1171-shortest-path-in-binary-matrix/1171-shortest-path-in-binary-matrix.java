class Solution {

    private boolean isValid(int i, int j, int n, int m){

        if(i < 0 || i >= n || j < 0 || j >= m)
            return false;

        return true;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        if (grid[0][0] == 1 || grid[n - 1][m - 1] == 1)
            return -1;

        if (n == 1) 
            return 1;

        Queue<int[]> q = new LinkedList<>();
        int[][] dist = new int[n][m];

        for(int[] row : dist)
            Arrays.fill(row, Integer.MAX_VALUE);

        dist[0][0] = 1;

        q.add(new int[]{1, 0, 0});

        while(!q.isEmpty()){
            int[]cell = q.poll();
            int dis = cell[0];
            int row = cell[1];
            int col = cell[2];

            for(int i = - 1 ; i <= 1 ; i++){
                for(int j = - 1; j <= 1; j++){

                    int nrow = row + i;
                    int ncol = col + j;

                    if(isValid(nrow, ncol, n, m) && grid[nrow][ncol] == 0 && dis + 1 < dist[nrow][ncol]){

                        dist[nrow][ncol] = dis + 1;

                        if (nrow == n - 1 && 
                            ncol == m - 1)
                                return dis + 1;

                        q.add(new int[]{1 + dis, nrow, ncol});
                    }
                }
            }
        }

        return - 1;
    }
}