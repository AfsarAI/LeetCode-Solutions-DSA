class Solution {
    public int maxValidPairSum(int[] A, int k) {
        int res = 0, pre = 0, n = A.length;
        for (int i = 0; i < n - k; i++) {
            pre = Math.max(pre, A[i]);
            res = Math.max(res, pre + A[i + k]);
        }
        return res;
    }
}