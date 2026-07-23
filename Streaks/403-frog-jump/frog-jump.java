import java.util.Arrays;

class Solution {

    private Boolean[][] dp;

    public boolean canCross(int[] stones) {

        int n = stones.length;

        if (stones[1] != 1)
            return false;

        dp = new Boolean[n][n + 1];

        return dfs(1, 1, stones);
    }

    private boolean dfs(int index, int lastJump, int[] stones) {

        int n = stones.length;

        if (index == n - 1)
            return true;

        if (dp[index][lastJump] != null)
            return dp[index][lastJump];

        for (int jump = lastJump - 1; jump <= lastJump + 1; jump++) {

            if (jump <= 0)
                continue;

            int nextStone = stones[index] + jump;

            int nextIndex = Arrays.binarySearch(stones, nextStone);

            if (nextIndex >= 0) {
                if (dfs(nextIndex, jump, stones)) {
                    return dp[index][lastJump] = true;
                }
            }
        }

        return dp[index][lastJump] = false;
    }
}