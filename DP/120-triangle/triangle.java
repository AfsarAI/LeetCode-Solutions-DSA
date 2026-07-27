class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        Integer[][] dp = new Integer[n][n];
        return dfs(triangle, 0, 0, dp);
    }
    private int dfs(List<List<Integer>> triangle, int row, int col, Integer[][] dp){
        int totalRow = triangle.size();
        if (row == totalRow-1) return triangle.get(row).get(col);
        if (row > totalRow-1) return 0;
        if (dp[row][col] != null)
            return dp[row][col];

        int currCol = dfs(triangle, row+1, col, dp);
        int nextCol = dfs(triangle, row+1, col+1, dp);

        return dp[row][col] = triangle.get(row).get(col) + Math.min(currCol, nextCol);
    }
}