class Solution {
    public int reverseDegree(String s) {
        int n = s.length();
        int revInd = 0;
        int sum = 0;
        for(int i = 0; i < n; i++){
            revInd = 26 - (s.charAt(i) - 'a');
            sum += revInd * (i+1);
        }
        return sum;
    }
}