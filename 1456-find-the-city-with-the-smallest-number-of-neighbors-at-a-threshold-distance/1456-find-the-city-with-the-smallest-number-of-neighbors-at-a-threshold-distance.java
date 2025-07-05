class Solution {
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {

        int[][] mat = new int[n][n];

        for(int[] row : mat)
            Arrays.fill(row, (int) 1e9);

        for(int[] it : edges){
            mat[it[0]][it[1]] = it[2];
            mat[it[1]][it[0]] = it[2];
        }

        for(int k = 0 ; k < n ; k++){
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){

                    mat[i][j] = Math.min(mat[i][j], mat[i][k] + mat[k][j]);
                }
            }
        }

        int minCount = (int)1e9;

        int ans = - 1;

        for(int i = 0 ; i < n ; i++){

            int count = 0; 

            for(int j = 0 ; j < n ; j++){

                if(i != j && mat[i][j] <= distanceThreshold)
                    count++;
            }

            if(count < minCount){
                minCount = count;
                ans = i;
            }

            else if(count == minCount)
                ans = i;
        }

        return ans;
    }
}