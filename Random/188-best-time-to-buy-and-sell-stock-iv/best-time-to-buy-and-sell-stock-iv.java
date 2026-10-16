class Solution {
    private int help(int idx, int k, int[][] dp, int[] prices, int n){
        if(k == 0 || idx == n) return 0;

        if(dp[idx][k] != -1) return dp[idx][k];
        
        int profit = 0;
        if(k % 2 == 0){
            int buy = -prices[idx] + help(idx+1, k-1, dp, prices, n);
            int notBuy = 0 + help(idx+1, k, dp, prices, n);
            profit += Math.max(buy, notBuy);
        }else{
            int sell = prices[idx] + help(idx+1, k-1, dp, prices, n);
            int notSell = 0 + help(idx+1, k, dp, prices, n);
            profit += Math.max(sell, notSell);
        }
        return dp[idx][k] = profit;
    }
    public int maxProfit(int k, int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][k*2+1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return help(0, k*2, dp, prices, n);
    }
}