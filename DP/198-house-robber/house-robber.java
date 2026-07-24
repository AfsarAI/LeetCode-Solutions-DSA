class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return sum(n-1, nums, dp);
    }
    private int sum(int i, int[] arr, int[] dp){
        if (i==0) return arr[i];
        if (i<0) return 0;
        if (dp[i] != -1) return dp[i];
        int pick = arr[i] + sum(i-2, arr, dp);
        int notPick = sum(i-1, arr, dp);
        return dp[i] = Math.max(pick, notPick);
    }
}