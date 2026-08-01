class Solution {
    private int dfs(int r1, int c1, int c2, int[][] grid, int[][][] dp){
        int rows = grid.length;
        int cols = grid[0].length;

        if(r1 >= rows || c1 >= cols || c1 < 0 || c2 >= cols || c2 < 0)
            return Integer.MIN_VALUE;

        if (r1 == rows - 1) {
            if (c1 == c2)
                return grid[r1][c1];
            else
                return grid[r1][c1] + grid[r1][c2];
        }

        if (dp[r1][c1][c2] != -1) return dp[r1][c1][c2];

        int cherries = 0;
        if (c1 == c2){
            cherries += grid[r1][c1];
        } else {
            cherries += grid[r1][c1] + grid[r1][c2];
        }

        int best = Integer.MIN_VALUE;
        for (int i = -1; i <= 1; i++){
            for (int j = -1; j <= 1; j++){
                best = Math.max(best, dfs(r1+1, c1+i, c2+j, grid, dp));
            }
        }

        if(best == Integer.MIN_VALUE){
            dp[r1][c1][c2] = Integer.MIN_VALUE;
            return Integer.MIN_VALUE;
        }
        dp[r1][c1][c2] = cherries + best;
        return dp[r1][c1][c2];
    }
    
    public int cherryPickup(int[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int[][][] dp = new int[rows][cols][cols];
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                Arrays.fill(dp[i][j], -1);
            }
        }
        return Math.max(0, dfs(0,0,cols-1,grid,dp));
    } 
}