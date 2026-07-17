class Solution {
    private int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefixGcd = new int[n];
        int mxi = Integer.MIN_VALUE;
        for(int i = 0; i < n; i++){
            mxi = Math.max(mxi, nums[i]);
            prefixGcd[i] = gcd(nums[i], mxi);
        }
        Arrays.sort(prefixGcd);
        int small = 0;
        int large = n-1;
        long ansSum = 0;
        while(small < large){
            ansSum += gcd(prefixGcd[small], prefixGcd[large]);
            small++;
            large--;
        }
        return ansSum;
    }
}