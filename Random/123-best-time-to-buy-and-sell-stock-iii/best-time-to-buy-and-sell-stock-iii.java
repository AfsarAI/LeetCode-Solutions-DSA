class Solution {
    private int help(int idx, int maxTrac, int[][] dp, int[] prices, int n){
        if(maxTrac == 0 || idx == n) return 0;

        if(dp[idx][maxTrac] != -1) return dp[idx][maxTrac];

        int profit = 0;
        if(maxTrac % 2 == 0){
            int buy = -prices[idx] + help(idx+1, maxTrac-1, dp, prices, n);
            int notBuy = 0 + help(idx+1, maxTrac, dp, prices, n);
            profit += Math.max(buy, notBuy);
        }else{
            int sell = prices[idx] + help(idx+1, maxTrac-1, dp, prices, n);
            int notSell = 0 + help(idx+1, maxTrac, dp, prices, n);
            profit += Math.max(sell, notSell);
        }
        return dp[idx][maxTrac] = profit;
    }
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][5];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return help(0, 4, dp, prices, n);
    }
}