class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int finalXOR = 0;
        boolean allZero = true;

        for(int num : nums){
            finalXOR = finalXOR ^ num;
            if(num != 0){
                allZero = false;
            }
        }
        if(allZero) return 0;
        return (finalXOR == 0) ? n-1 : n;
    }
}