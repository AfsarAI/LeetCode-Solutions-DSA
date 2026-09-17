class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] best = new int[n];

        Arrays.fill(best, Integer.MAX_VALUE);

        int left = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            sum += arr[right];

            while (sum > target) {
                sum -= arr[left++];
            }

            if (sum == target) {
                int len = right - left + 1;

                // A previous non-overlapping subarray
                if (left > 0 && best[left - 1] != Integer.MAX_VALUE) {
                    ans = Math.min(ans, len + best[left - 1]);
                }
            }

            // Carry forward the best answer seen so far
            if (right > 0) {
                best[right] = best[right - 1];
            }

            if (sum == target) {
                best[right] = Math.min(best[right], right - left + 1);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}