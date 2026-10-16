class Solution {
    private int help(int idx, int isBuy, int maxTrac, int[][][] dp, int[] prices, int n){
        if(maxTrac == 0) return 0;
        if(idx == n) return 0;

        if(dp[idx][isBuy][maxTrac] != -1) return dp[idx][isBuy][maxTrac];

        int profit = 0;
        if(isBuy == 1){
            int buy = -prices[idx] + help(idx+1, 0, maxTrac, dp, prices, n);
            int notBuy = 0 + help(idx+1, 1, maxTrac, dp, prices, n);
            profit += Math.max(buy, notBuy);
        }else{
            int sell = prices[idx] + help(idx+1, 1, maxTrac-1, dp, prices, n);
            int notSell = 0 + help(idx+1, 0, maxTrac, dp, prices, n);
            profit += Math.max(sell, notSell);
        }
        return dp[idx][isBuy][maxTrac] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][][] dp = new int[n][2][3];
        for(int[][] row : dp){
            for(int[] r : row){
                Arrays.fill(r, -1);
            }
        }
        return help(0, 1, 2, dp, prices, n);
    }
}