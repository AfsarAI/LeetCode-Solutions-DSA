class Solution {
    public int[] gcdValues(int[] nums, long[] queries) {
        int maxNum = 0;
        for (int num : nums){
           maxNum = Math.max(num, maxNum);
        }

        int[] countFreq = new int[maxNum+1];
        for(int num : nums){
            countFreq[num]++;
        }

        long[] gcdPairs = new long[maxNum+1];
        for(int i = 1; i <= maxNum; i++){
            for(int j = i; j <= maxNum; j+=i){
                gcdPairs[i] += countFreq[j];
            }
            gcdPairs[i] = gcdPairs[i] * (gcdPairs[i] - 1)/2;
        }

        for(int i = maxNum; i>=1; i--){
            for(int j = 2*i; j <= maxNum; j+=i){
                gcdPairs[i] -= gcdPairs[j];
            }
        }

        long[] preSum = new long[maxNum+1];
        for (int i = 1; i < maxNum; i++){
            preSum[i] = preSum[i-1] + gcdPairs[i];
        }

        int n = queries.length; 
        int[] ans = new int[n];

        for(int i = 0; i < n; i++){
            long k = queries[i] + 1;

            int left = 1, right = maxNum;
            while(left < right){
                int mid = left + (right-left) / 2;

                if (preSum[mid]>=k){
                    right = mid;
                } else left = mid+1;
            }
            ans[i] = left;
        }
        
        return ans;
    }

}