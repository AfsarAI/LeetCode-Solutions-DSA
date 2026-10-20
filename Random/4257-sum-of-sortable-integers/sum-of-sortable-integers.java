class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int sum = 0;
        
        // Iterate through all possible divisors of n
        for (int k = 1; k * k <= n; k++) {
            if (n % k == 0) {
                // Check divisor k
                if (isValid(nums, k, n)) {
                    sum += k;
                }
                
                // Check the corresponding paired divisor (n / k)
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
        
        // Iterate over each subarray of length k
        for (int i = 0; i < n; i += k) {
            int currentMax = nums[i];
            int drops = 0;
            
            // Check the elements within the current subarray
            for (int j = 0; j < k; j++) {
                int val = nums[i + j];
                
                // Since the blocks cannot be swapped, every element in the current block 
                // must be greater than or equal to the maximum element in the previous block.
                if (i > 0 && val < prevMax) {
                    return false;
                }
                
                // Check cyclic drop: compare current element to the next (wrapping around)
                int nextVal = (j == k - 1) ? nums[i] : nums[i + j + 1];
                
                if (val > nextVal) {
                    drops++;
                    // A valid subarray can only have at most 1 decrease when considered cyclically
                    if (drops > 1) {
                        return false;
                    }
                }
                
                // Track the maximum value of the current block
                if (val > currentMax) {
                    currentMax = val;
                }
            }
            
            // Pass the maximum to the next block iteration
            prevMax = currentMax;
        }
        
        return true;
    }
}