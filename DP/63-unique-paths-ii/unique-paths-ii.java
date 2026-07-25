class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++){
                if(obstacleGrid[i][j] != 1){
                    dp[i][j] = -1;
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dfs(m-1, n-1, dp);
    }
    private int dfs(int row, int col, int[][] dp){
        if (row == 0 && col == 0 && dp[row][col] != 0) return 1;

        if (dp[row][col] != -1) return dp[row][col];
        int up = 0, left = 0;
        if (row - 1 >= 0) {
            up = dfs(row-1, col, dp);
        }
        if (col - 1 >= 0){
            left = dfs(row, col-1, dp);
        }

        return dp[row][col] = up+left;
    }
}