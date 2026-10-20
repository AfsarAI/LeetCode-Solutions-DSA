class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int k = 1; k * k <= n; k++) {
            if (n % k == 0) {
                if (isValid(nums, k, n)) {
                    sum += k;
                }
                int k2 = n / k;
                if (k2 != k) {
                    if (isValid(nums, k2, n)) {
                        sum += k2;
                    }
                }
            }
        } 
        return sum;
    }
    
    private boolean isValid(int[] nums, int k, int n) {
        int prevMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i += k) {
            int currentMax = nums[i];
            int drops = 0;
            for (int j = 0; j < k; j++) {
                int val = nums[i + j];
                if (i > 0 && val < prevMax) {
                    return false;
                }

                int nextVal = (j == k - 1) ? nums[i] : nums[i + j + 1];
                
                if (val > nextVal) {
                    drops++;
                    if (drops > 1) {
                        return false;
                    }
                }
                if (val > currentMax) {
                    currentMax = val;
                }
            }
            prevMax = currentMax;
        }
        
        return true;
    }
}