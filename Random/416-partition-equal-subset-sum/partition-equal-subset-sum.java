class Solution {
    private boolean dfs(int i, int sum, int[] nums, int[][] dp){
        int n = nums.length;
        if(sum == 0) return true;
        if(sum < 0 || i == n) return false;

        if(dp[i][sum] != -1) return dp[i][sum] == 1;

        boolean take = dfs(i+1, sum-nums[i], nums, dp);
        boolean noTake = dfs(i+1, sum, nums, dp);
        dp[i][sum] = (take || noTake) ? 1 : 0;
        return take || noTake;
    }
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int num : nums){
            totalSum += num;
        }
        if(totalSum % 2 != 0) return false;
        int[][] dp = new int[nums.length][totalSum/2 + 1];
        for(int[] row : dp){
            Arrays.fill(row, -1);
        }
        return dfs(0, totalSum/2, nums, dp);
    }
}