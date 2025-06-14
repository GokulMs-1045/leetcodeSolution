class Solution {

    private int func(int row, int col, int limit, List<List<Integer>> triangle, int[][] dp){

        if(row == limit)
            return triangle.get(row).get(col);

        if(dp[row][col] != - 1)
            return dp[row][col];

        int down = triangle.get(row).get(col) + func(row + 1, col, limit, triangle, dp);
        int downRight = triangle.get(row).get(col) + func(row + 1, col + 1, limit, triangle, dp);

        return dp[row][col] = Math.min(down, downRight);
    }

    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size() - 1;
        int dp[][] = new int[m][m];

        for(int[] row : dp)
            Arrays.fill(row, - 1);

        return func(0, 0, m, triangle, dp);
    }
}