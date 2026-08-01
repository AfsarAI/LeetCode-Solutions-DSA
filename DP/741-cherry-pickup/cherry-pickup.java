class Solution {
    private int dfs(int r1, int c1, int r2, int[][] grid, int[][][] dp){
        int n = grid.length;
        int c2 = (r1 + c1) - r2;
        if(r1 >= n || r2 >= n || c1 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1)
            return Integer.MIN_VALUE;

        if(r1 == n-1 && c1 == n-1) return grid[r1][c1];

        if (dp[r1][c1][r2] != -1) return dp[r1][c1][r2];

        int cherries = 0;
        if (r1 == r2 && c1 == c2){
            cherries += grid[r1][c1];
        } else {
            cherries += grid[r1][c1] + grid[r2][c2];
        }

        int f1 = dfs(r1, c1+1, r2, grid, dp);
        int f2 = dfs(r1+1, c1, r2+1, grid, dp);
        int f3 = dfs(r1, c1+1, r2+1, grid, dp);
        int f4 = dfs(r1+1, c1, r2, grid, dp);

        int best = Math.max(Math.max(f1, f2), Math.max(f3, f4));
        if(best == Integer.MIN_VALUE){
            dp[r1][c1][r2] = Integer.MIN_VALUE;
            return Integer.MIN_VALUE;
        }
        dp[r1][c1][r2] = cherries + best;
        return dp[r1][c1][r2];
    }
    
    public int cherryPickup(int[][] grid) {
        int n = grid.length;
        int[][][] dp = new int[n][n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return Math.max(0, dfs(0,0,0,grid,dp));
    } 
}