class Solution {
    private int solve(int[] coins, int amount, int i, Integer[][] dp) {
        if (amount == 0) return 0;
        if (i < 0 || amount < 0) return Integer.MAX_VALUE;

        if(dp[i][amount] != null) return dp[i][amount];
        int notTake = solve(coins, amount, i - 1, dp);
        int take = Integer.MAX_VALUE;
        if (amount >= coins[i]) {
            take = solve(coins, amount - coins[i], i, dp);
            if(take != Integer.MAX_VALUE) take++;
        }
        return dp[i][amount] = Math.min(take, notTake);
    }
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        Integer[][] dp = new Integer[n+1][amount+1];
        int ans = solve(coins, amount, n - 1, dp);
        if (ans == Integer.MAX_VALUE) return -1;
        return ans;
    }
}