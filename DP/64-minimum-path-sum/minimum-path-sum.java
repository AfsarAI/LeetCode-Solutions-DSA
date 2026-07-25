class Solution {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return dfs(m-1, n-1, grid, dp);
    }
    private int dfs(int row, int col, int[][] mat, int[][] dp){
        if (row == 0 && col == 0) return mat[row][col];
        if (row < 0 || col < 0)
            return Integer.MAX_VALUE;

        if (dp[row][col] != -1) return dp[row][col];
        
        int up = dfs(row - 1, col, mat, dp);
        int left = dfs(row, col - 1, mat, dp);
        return dp[row][col] = mat[row][col] + Math.min(up, left);
    }
}