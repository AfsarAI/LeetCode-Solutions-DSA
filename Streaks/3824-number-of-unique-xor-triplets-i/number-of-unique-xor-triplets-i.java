class Solution {
    public int uniqueXorTriplets(int[] nums) {
        int n = nums.length;
        if (n==1 || n==2) return n;
        int p = 0;
        while(n != 0){
            n = n >> 1;
            p++;
        }
        return (int) Math.pow(2, p);
    }
}