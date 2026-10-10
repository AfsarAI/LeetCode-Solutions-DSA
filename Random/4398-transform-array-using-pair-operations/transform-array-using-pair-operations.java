class Solution {
    public boolean canTransform(int[] source, int[] target) {
        int n = source.length;
        long sum = 0;
        for(int i = 0; i < n; i++) {
            sum += (long) source[i] - target[i];
        }
        if(sum == 0) return true;
        return false;
    }
}