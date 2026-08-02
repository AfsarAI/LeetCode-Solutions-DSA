class Solution {
    private int dfs(int[] piles, int l, int r, int[][] dp){
        if(l > r) return 0;
        if (l == r) return piles[l];

        if(dp[l][r] != -1) return dp[l][r];

        int takeL = piles[l] + Math.min(dfs(piles, l+2, r, dp), dfs(piles, l+1, r-1, dp));
        int takeR = piles[r] + Math.min(dfs(piles, l, r-2, dp), dfs(piles, l+1, r-1, dp));

        return dp[l][r] = Math.max(takeL, takeR);
    }
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        int total = 0;
        for(int i = 0; i < n; i++){
            total += piles[i];
        }

        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }

        int alic = dfs(piles, 0, n-1, dp);
        int bob = total - alic;
        return alic > bob;
    }
}