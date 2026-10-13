class Solution {
    public long maxAlternatingSum(int[] nums) {
        int n = nums.length;
        int[] absArr = new int[n];
        for(int i = 0; i < n; i++){
            absArr[i] = Math.abs(nums[i]);
        }
        Arrays.sort(absArr);
        int s = 0;
        int e = n-1;
        long score = 0;
        while(s < e){
            score += (long) absArr[e] * absArr[e];
            score -= (long) absArr[s] * absArr[s];
            s++;
            e--;
        }
        if(n % 2 != 0) score += (long) absArr[e] * absArr[e];
        return score;
    }
}