class Solution {
    private int digitProduct(int x) {
        int product = 1;
        while (x > 0) {
            product *= x % 10;
            x /= 10;
        }
        return product;
    }
    public int smallestNumber(int n, int t) {
        while (digitProduct(n) % t != 0) {
            n++;
        }
        return n;
    }
}