class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] prefixMin = new int[n];
        int min = nums[n-1];
        for(int i = n-1; i >= 0; i--){
            min = Math.min(min, nums[i]);
            prefixMin[i] = min;
        }

        int score;
        int max = Integer.MIN_VALUE;
        int ans = -1;
        for(int i = 0; i < n; i++){
            max = Math.max(max, nums[i]);
            score = max - prefixMin[i];
            if(score <= k){
                return i;
            }
        }
        return -1;
    }
}