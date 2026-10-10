class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        int maxDiff = 0;
        int[] diffs = new int[n];
        for (int i = 0; i < n; i++) {
            diffs[i] = Math.abs(nums1[i] - nums2[i]);
            maxDiff = Math.max(maxDiff, diffs[i]);
        }
        long totalDiff = 0;
        int[] count = new int[maxDiff + 1];
        for (int i = 0; i < n; i++) {
            count[diffs[i]]++;
            totalDiff += diffs[i];
        }
        if (totalDiff <= k) return 0;
        for (int i = maxDiff; i > 0 && k > 0; i--) {
            if (count[i] > 0) {
                long reduceCount = Math.min((long)count[i], k);
                count[i] -= reduceCount;
                count[i - 1] += reduceCount;
                k -= reduceCount;
            }
        }
        long ans = 0;
        for (int i = 1; i <= maxDiff; i++) {
            if (count[i] > 0) {
                ans += (long) count[i] * (long) i * i;
            }
        }
        return ans;
    }
}