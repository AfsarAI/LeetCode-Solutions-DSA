class Solution {
    public int maxLength(int[] nums) {
        int res = 1;        
        for (int i = 0; i < nums.length; i++) {
            long prodVal = nums[i];
            long gcdVal = nums[i];
            long lcmVal = nums[i];
            
            if (prodVal == gcdVal * lcmVal) {
                res = Math.max(res, 1);
            }
            
            for (int j = i + 1; j < nums.length; j++) {
                gcdVal = gcd(gcdVal, nums[j]);
                lcmVal = (lcmVal / gcd(lcmVal, nums[j])) * nums[j];
                if (prodVal > Long.MAX_VALUE / nums[j]) {
                    break;
                }
                prodVal *= nums[j];
                if (prodVal == gcdVal * lcmVal) {
                    res = Math.max(res, j - i + 1);
                } else if (prodVal > gcdVal * lcmVal) {
                    break;
                }
            }
        }
        
        return res;
    }

    private long gcd(long a, long b) {
        while (b != 0) {
            long temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}