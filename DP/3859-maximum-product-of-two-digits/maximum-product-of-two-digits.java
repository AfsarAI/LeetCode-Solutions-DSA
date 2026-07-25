class Solution {
    public int maxProduct(int n) {
        int max = Integer.MIN_VALUE;
        int prevMax = max;
        int temp = n;

        while(temp>0){
            int num = temp % 10;
            if (num >= max){
                prevMax = max;
                max = num;
            } else {
                if (num > prevMax){
                    prevMax = num;
                }
            }
            temp = temp / 10;
        }
        return max * prevMax;
    }
}