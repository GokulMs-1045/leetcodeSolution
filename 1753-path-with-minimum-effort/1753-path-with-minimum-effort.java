class Solution {

    int[] delRow = {-1, 0, 1, 0};
    int[] delCol = {0, -1, 0, 1};

    private boolean isValid(int i, int j, int n, int m){

        if(i < 0 || i >= n || j < 0 || j >= m)
            return false;

        return true;
    }

    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;

        int[][] dist = new int[n][m];

        PriorityQueue<int[]> pq = new PriorityQueue<>(
            Comparator.comparingInt(a -> a[0])
        );

        for(int[] row : dist)
            Arrays.fill(row, (int) 1e9);

        dist[0][0] = 0;

        pq.add(new int[]{0, 0, 0});

        while(!pq.isEmpty()){

            int[] cell = pq.poll();
            int diff = cell[0];
            int row = cell[1];
            int col = cell[2];

            if(row == n - 1 && col == m - 1)
                return diff;

            for(int i = 0 ; i < 4 ; i++){

                int nrow = row + delRow[i];
                int ncol = col + delCol[i];

                if(isValid(nrow, ncol, n, m)){

                    int currDiff = Math.abs(heights[nrow][ncol] - heights[row][col]);

                    if(Math.max(diff, currDiff) < dist[nrow][ncol]){

                        dist[nrow][ncol] = Math.max(diff, currDiff);

                        pq.add(new int[]{Math.max(diff, currDiff), nrow, ncol});
                    }
                }
            }
        }

        return - 1;
    }
}