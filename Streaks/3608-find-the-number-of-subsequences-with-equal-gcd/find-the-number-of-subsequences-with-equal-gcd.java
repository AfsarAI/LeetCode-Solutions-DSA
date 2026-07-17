class Solution {

    private static final int MOD = 1_000_000_007;
    private Long[][][] dp;

    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    private long solve(int[] nums, int i, int firstGCD, int secondGCD) {

        if (i == nums.length) {
            return (firstGCD != 0 &&
                    secondGCD != 0 &&
                    firstGCD == secondGCD) ? 1 : 0;
        }

        if (dp[i][firstGCD][secondGCD] != null) {
            return dp[i][firstGCD][secondGCD];
        }

        long skip = solve(nums, i + 1, firstGCD, secondGCD);

        long seq1 = solve(
                nums,
                i + 1,
                gcd(firstGCD, nums[i]),
                secondGCD
        );

        long seq2 = solve(
                nums,
                i + 1,
                firstGCD,
                gcd(secondGCD, nums[i])
        );

        long ans = (skip + seq1 + seq2) % MOD;

        return dp[i][firstGCD][secondGCD] = ans;
    }

    public int subsequencePairCount(int[] nums) {

        int max = 0;
        for (int x : nums)
            max = Math.max(max, x);

        dp = new Long[nums.length + 1][max + 1][max + 1];

        return (int) solve(nums, 0, 0, 0);
    }
}