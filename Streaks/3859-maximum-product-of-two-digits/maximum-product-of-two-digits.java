class Solution {
    public int maxProduct(int n) {
        int max = -1;
        int secMax = max;
        int num = n;
        while(num > 0){
            int digit = num % 10;
            if (digit >= max){
                secMax = max;
                max = digit;
            } else if (digit > secMax) {
                secMax = digit;
            }
            num /= 10;
        }
        return max * secMax;
    }
}