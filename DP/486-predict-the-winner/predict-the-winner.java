class Solution {
    public boolean predictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i < n; i++){
            Arrays.fill(dp[i], -1);
        }
        int p1 = dfsP1(0, n-1, nums, dp);
        int totalSum = 0;
        for (int i = 0; i < n; i++){
            totalSum += nums[i];
        }
        int p2 = totalSum - p1;

        return p1 >= p2;
    }
    private int dfsP1(int i, int j, int[] nums, int[][] dp){
        if (i > j) return 0;
        if (i == j) return nums[i];

        if(dp[i][j] != -1) return dp[i][j];

        int take_i = nums[i] + Math.min(dfsP1(i+2, j, nums, dp), dfsP1(i+1, j-1, nums, dp));
        int take_j = nums[j] + Math.min(dfsP1(i, j-2, nums, dp), dfsP1(i+1, j-1, nums, dp));

        return dp[i][j] = Math.max(take_i, take_j);
    }
}