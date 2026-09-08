class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int offset = 1000*20;
        int[][] dp = new int[n + 1][2001+20*1000];
        dp[0][offset] = 1;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            int num = nums[i - 1];
            sum += num;
            for (int j = -sum; j <= sum; j++) {
                int plus = dp[i - 1][j - num + offset];
                int minus = dp[i - 1][j + num + offset];
                dp[i][j + offset] = plus + minus;
            }
        }
        if (target < -sum || target > sum) return 0;
        return dp[n][target + offset];
    }
}