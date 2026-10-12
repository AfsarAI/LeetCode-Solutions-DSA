class Solution {
    public int maxSum(List<Integer> nums, int k) {
        int[] count = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if (((num >> i) & 1) == 1) {
                    count[i]++;
                }
            }
        }
        long ans = 0;
        long MOD = 1_000_000_007;
        for (int j = 0; j < k; j++) {
            long currentNum = 0;
            for (int i = 0; i < 32; i++) {
                if (count[i] > 0) {
                    currentNum |= (1L << i); 
                    count[i]--;              
                }
            }
            ans = (ans + (currentNum * currentNum) % MOD) % MOD;
        }
        return (int) ans;
    }
}