class Solution {
    public boolean isPalindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i++) != s.charAt(j--)) return false;
        }
        return true;
    }
    public int solve(String s, int k, int i, int j, int[][] dp) {
        int n = s.length();
        if (i >= n || j >= n) return 0;
        if (dp[i][j] != -1) return dp[i][j];
        if (isPalindrome(s, i, j)) {
            int growWindow  = solve(s, k, i, j + 1, dp);
            int takeIt      = 1 + solve(s, k, j + 1, j + k, dp);
            int slideWindow = solve(s, k, i + 1, j + 1, dp);

            return dp[i][j] = Math.max(growWindow, Math.max(takeIt, slideWindow));
        }
        int slideWindow = solve(s, k, i + 1, j + 1, dp);
        int growWindow  = solve(s, k, i, j + 1, dp);
        return dp[i][j] = Math.max(slideWindow, growWindow);
    }
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        if (k == 1) return n;
        int[][] dp = new int[n][n];
        for (int[] row : dp) Arrays.fill(row, -1);
        return solve(s, k, 0, k - 1, dp);
    }
}
