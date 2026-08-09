class Solution {
    private int dfs(int a, int i, int m, int[] p, int[][][] dp){
        int n = p.length;
        if(i >= n) return 0;

        int sum = 0;
        int res = (a == 1) ? -1 : Integer.MAX_VALUE;

        if(dp[a][i][m] != -1) return dp[a][i][m];

        for(int x = 1; x <= Math.min(2*m, n-i); x++){
            sum += p[i + x -1];
            if(a == 1){
                res = Math.max(res, sum + dfs(0, i+x, Math.max(m,x), p, dp));
            }else{
                res = Math.min(res, dfs(1, i+x, Math.max(m,x), p, dp));
            }
        }
        return dp[a][i][m] = res;
    }
    public int stoneGameII(int[] piles) {
        int[][][] dp = new int[2][101][101];
        for(int[][] mat : dp){
            for(int[] row : mat){
                Arrays.fill(row, -1);
            }
        }
        return dfs(1, 0, 1, piles, dp);
    }
}