class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 0) return 0;
        if (n == 1) return nums[0];
        int[] arr1 = new int[n-1];
        int[] arr2 = new int[n-1];
        int j = 0, k = 0;
        for (int i = 0; i < n; i++) {
            if (i != 0){
                arr1[j] = nums[i];
                j++;
            }
            if (i != n - 1){
                arr2[k] = nums[i];
                k++;
            }
        }
        int[] dp1 = new int[n-1];
        int[] dp2 = new int[n-1];
        Arrays.fill(dp1, -1);
        Arrays.fill(dp2, -1);
        return Math.max(sum(n-2, arr1, dp1), sum(n-2, arr2, dp2));
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