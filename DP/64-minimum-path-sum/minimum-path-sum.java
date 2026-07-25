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

        if (dp[row][col] != -1) return dp[row][col];

        int up = -1, left = -1;
        if (row - 1 >= 0) {
            up = mat[row][col] + dfs(row-1, col, mat, dp);
        }
        if (col - 1 >= 0){
            left = mat[row][col] + dfs(row, col-1, mat, dp);
        }

        int min = Integer.MAX_VALUE;
        if (up != -1 && left != -1){
            min = Math.min(up, left);
        } else if (up == -1){
            min = left;
        } else {
            min = up;
        }

        return dp[row][col] = min;
    }
}