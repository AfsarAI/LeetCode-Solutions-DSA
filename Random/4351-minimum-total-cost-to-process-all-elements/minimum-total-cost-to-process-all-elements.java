class Solution {
    // static final long MOD = 1_000_000_007L;
    // static final long inv2 = 500000004L;
    // public int minimumCost(int[] nums, int k) {
    //     long resources = k;
    //     long op = 0;
    //     long ans = 0;
    //     for (int x : nums) {
    //         if (resources < x) {
    //             long ops = (x - resources + k - 1L) / k;
    //             long a = ops % MOD;
    //             long b = (2 * op + ops + 1) % MOD;
    //             long add = (((a * b) % MOD) * inv2) % MOD;
    //             ans = (ans + add) % MOD;
    //             op += ops;
    //             resources += ops * (long) k;
    //         }
    //         resources -= x;
    //     }
    //     return (int) ans;
    // }
    public int minimumCost(int[] A, int k) {
        long s = 0, mod = 1000000007;
        for (int a : A)
            s += a;
        long x = (s + k - 1) / k % mod;
        return (int) ((x - 1) * x / 2 % mod);
    }
}