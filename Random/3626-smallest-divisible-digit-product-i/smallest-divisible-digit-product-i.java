class Solution {
    public int smallestNumber(int n, int t) {
        if(n < t) return t;
        int til = 10 - (n % 10);
        int fir = n / 10;
        int sec = n % 10;
        int prod = fir * sec;
        if(prod == 0 && n >= 10) return n;
        while(til-- > 0){
            if(n > 10){
                fir = n / 10;
                sec = n % 10;
                prod = fir * sec;
            }else {
                prod = n;
            }
            if(prod % t == 0){
                return n;
            }else{
                n += 1;
            }
        }
        return n;
    }
}