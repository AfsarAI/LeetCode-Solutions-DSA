class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][2001+1000*20];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        return sum(nums, target, 0, dp);
    }
    private int sum(int[] arr, int target, int i, int[][] dp){
        int n = arr.length;
        if (i == n) {
            return target == 0 ? 1 : 0;
        }

        if (dp[i][target+1000*20] != -1) return dp[i][target+1000*20];

        int plus = sum(arr, target-arr[i], i+1, dp);
        int minus = sum(arr, target+arr[i], i+1, dp);

        return dp[i][target+1000*20] = plus+minus;
    }
}