class Solution {
    private int help(int idx, int isBuy, int k, int[][][] dp, int[] prices, int n){
        if(k == 0) return 0;
        if(idx == n) return 0;

        if(dp[idx][isBuy][k] != -1) return dp[idx][isBuy][k];

        int profit = 0;
        if(isBuy == 1){
            int buy = -prices[idx] + help(idx+1, 0, k, dp, prices, n);
            int notBuy = 0 + help(idx+1, 1, k, dp, prices, n);
            profit += Math.max(buy, notBuy);
        }else{
            int sell = prices[idx] + help(idx+1, 1, k-1, dp, prices, n);
            int notSell = 0 + help(idx+1, 0, k, dp, prices, n);
            profit += Math.max(sell, notSell);
        }
        return dp[idx][isBuy][k] = profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][k+1];
        for(int[][] row : dp){
            for(int[] r : row){
                Arrays.fill(r, -1);
            }
        }
        return help(0, 1, k, dp, prices, n);
    }
}