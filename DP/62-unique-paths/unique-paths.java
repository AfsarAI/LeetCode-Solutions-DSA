class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        return uniquePaths(m-1, n-1, dp);
    }
    private int uniquePaths(int row, int col, int[][] dp){
        if (row == 0 && col == 0) return 1;

        if (dp[row][col] != -1) return dp[row][col];
        int up = 0, left = 0;
        if (row - 1 >= 0) {
            up = uniquePaths(row-1, col, dp);
        }
        if (col - 1 >= 0){
            left = uniquePaths(row, col-1, dp);
        }

        return dp[row][col] = up+left;
    }
}