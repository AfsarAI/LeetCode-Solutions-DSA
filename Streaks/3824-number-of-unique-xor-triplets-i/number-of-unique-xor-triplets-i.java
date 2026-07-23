class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;

        if (n <= 2) {
            return n;
        }

        int p = 0;

        while (n != 0) {
            n >>= 1;
            p++;
        }

        return 1 << p;
    }
}